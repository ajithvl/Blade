package com.blade;

import com.blade.lib.Sikuli;
import org.testng.Assert;
import org.testng.annotations.*;



public class TesterDeleteMe {
    // CLASS SETUP
    @BeforeClass
    public void setUp() {
        System.out.println("> SETUP");
    }

    @AfterClass
    public void tearDown() {
        System.out.println("> TEARDOWN");
    }

    
    // METHOD SETUP
    @BeforeMethod
    public void beforeMethod() {
        System.out.println("    > BEFORE METHOD");
    }
    
    @AfterMethod
    public void afterMethod() {
        System.out.println("    > AFTER METHOD");
    }
    
    
    
    
    @Test(groups = {"TestRun"})
    public void testPassed() {
        System.out.println("    This is test ONE");
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
        }
    }
    
    @Test(groups = {"TestRun"})
    public void testFailed() {
        System.out.println("    This is test TWO");
        try {
            Thread.sleep(6000);
        } catch (Exception e) {
        }
        Assert.assertEquals(1, 2);
    }
    
    @Test(dependsOnMethods = {"testFailed" })
    public void testSkipped() {
        System.out.println("    This is test THREE");
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
        }
    }
    
    
    
    
    
    @Test(groups = {"TestRun"})
    public void testPassedx1() {
        System.out.println("    This is test X1");
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
        }
    }
    
    @Test(groups = {"TestRun"})
    public void testPassedx2() {
        System.out.println("    This is test X2");
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
        }
    }
    @Test(groups = {"TestRun"})
    public void testPassedx3() {
        System.out.println("    This is test X3");
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
        }
    }

}

