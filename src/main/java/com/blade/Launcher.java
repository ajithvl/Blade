package com.blade;


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
        TestListenerAdapter tla = new RuntimeReporter();
        TestNG testng = new TestNG();
        testng.addListener(tla);
        testng.setTestSuites(Arrays.asList("config/testng.xml"));
        testng.run();
        
    }
}
