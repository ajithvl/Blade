package com.blade;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import org.apache.log4j.Logger;
import org.testng.*;

/**
 *
 * @author avarakukalayil
 */
public class TestRunner {

    static final Logger logger = Logger.getLogger(TestRunner.class);
    
    TestNG testng = new TestNG();

   
    public void attachListner(TestListenerAdapter tla) {
        testng.addListener(tla);
    }
    public void attachListner(IHookable tla) {
        testng.addListener(tla);
    }
    public void attachListner(IInvokedMethodListener tla) {
        testng.addListener(tla);
    }
    public void attachListner(IReporter tla) {
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
    
    public void setOutputDir() {
        Calendar currentDate = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yy_HH-mm-ss");
        String out = "output\\test\\" + Global.getProjectName() + "_" + formatter.format(currentDate.getTime());
        logger.debug("Setting output directory to: " + out);
        testng.setOutputDirectory(out);
    }
    
    public String getOutputDir() {
        return testng.getOutputDirectory();
    }

    
}
