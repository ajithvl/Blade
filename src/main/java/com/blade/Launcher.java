package com.blade;

import com.blade.core.NanoHTTPD;
import com.blade.core.RuntimeReporter;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import org.testng.ITestContext;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.xml.XmlSuite;

/**
 *
 * @author avarakukalayil
 */
public class Launcher {
    
    public static void main(String[] args) throws Exception{
        
        /*
         * Invoking HTTP server to listen to commands
         * COMMANDS:
         * 1) skip      : Skip all the tests in the list
         * 2) abort     : Gracefully abort all the pending tests
         */
        
        NanoHTTPD server = new NanoHTTPD(9898, null) {

            @Override
            public NanoHTTPD.Response serve(String uri, String method, Properties header, Properties parms, Properties files) {
                if ("/skip".equals(uri) && "POST".equals(method)) {
                    Object msgParam = parms.get("msg");
                    return new NanoHTTPD.Response("200", "application/json", "{\"msg\":\"Skipping\"}");
                }
                if ("/abort".equals(uri) && "POST".equals(method)) {
                    Object msgParam = parms.get("msg");
                    return new NanoHTTPD.Response("200", "application/json", "{\"msg\":\"Aborting\"}");
                }
                return new NanoHTTPD.Response("404", "text/plain", "Not Found");
            }
        };

        
       
        
        //TestListenerAdapter tla = new RuntimeReporter();
        TestNG testng = new TestNG();
        //testng.addListener(tla);
        
        testng.setTestSuites(Arrays.asList("config/testng.xml"));
        testng.run();
        
        
        
        // Stops the HTTP server
        server.stop();
    }
}
