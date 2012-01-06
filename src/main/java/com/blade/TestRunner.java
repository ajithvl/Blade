package com.blade;

import java.util.Arrays;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;

/**
 *
 * @author avarakukalayil
 */
public class TestRunner {

    TestNG testng = new TestNG();

   
    public void attachListner(TestListenerAdapter tla) {
        testng.addListener(tla);
    }

    public void execute() {
        try {
            // Add all config files  
            for (String path : Global.getTestngXmlPaths()) {
                System.out.println("######## PATH = " + path);
                testng.setTestSuites(Arrays.asList("config/" + path));
            }

            testng.run();
        } catch (Exception e) {
            System.out.println("TESTNG EXCEPTION");
            e.printStackTrace();
        }
    }
    
    
    public void skipTest(String suitName) {
        //testng.g
    }
    
    public void skipTest(String suitName, String[] testNames) {
        //testng.
    }
    
}
