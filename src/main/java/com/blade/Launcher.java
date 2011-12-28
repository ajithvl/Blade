package com.blade;

import com.blade.core.HttpUtil;
import com.blade.core.NanoHTTPD;
import com.blade.ui.BladeUI;
import java.util.Arrays;
import java.util.Properties;
import org.apache.log4j.Logger;
import org.testng.TestNG;

/**
 *
 * @author avarakukalayil
 */
public class Launcher {
    static final Logger logger = Logger.getLogger(Launcher.class);
    final static int listeningPort = 9897;

    public static void main(String[] args) throws Exception {
        
        /*
         * Invoking HTTP server to listen to commands COMMANDS: 1) skip : Skip
         * all the tests in the list 2) abort : Gracefully abort all the pending
         * tests
         */
        NanoHTTPD server = new NanoHTTPD(listeningPort, null) {

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

        
        
        // Build the UI
        BladeUI ui = new BladeUI();
        ui.setListeningPort(listeningPort);
   
        ui.uiLogger("JAVA HOME = " + Global.JAVA_HOME);
        ui.uiLogger("JAVA VENDOR = " + Global.JAVA_VENDOR);
        ui.uiLogger("JAVA VERSION = " + Global.JAVA_VERSION);
        ui.uiLogger("OS ARCHITECTURE = " + Global.OS_ARCH);
        ui.uiLogger("OS NAME = " + Global.OS_NAME);
        ui.uiLogger("OS VERSION = " + Global.OS_VERSION);
        ui.uiLogger("USER DIRECTORY = " + Global.USER_DIR);
        ui.uiLogger("USER HOME = " + Global.USER_HOME);


        try {
            TestNG testng = new TestNG();

            // Add all config files to 
            for (String path : Global.getTestngXmlPaths()) {
                testng.setTestSuites(Arrays.asList("config/" + path));
            }

            testng.run();
        } catch (Exception e) {
            System.out.println("TESTNG EXCEPTION");
            e.printStackTrace();
        }


        
        
        // Stops the HTTP server
        server.stop();
    }
}
