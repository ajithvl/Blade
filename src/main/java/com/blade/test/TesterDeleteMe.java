package com.blade.test;

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

    
    @Test(groups = {"Positive"})
    public void testOne() {
        System.out.println("    This is test ONE");
    }
    
    @Test(groups = {"Negative"})
    public void testTwo() {
        System.out.println("    This is test TWO");
        Assert.assertTrue(false);
    }
    
    @Test(dependsOnMethods = {"testTwo" })
    public void testThree() {
        System.out.println("    This is test THREE");
    }
    
  
}

