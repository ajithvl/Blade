package com.blade.tests;

import org.sikuli.script.*;
import org.apache.log4j.*;

import org.testng.Reporter;
import org.testng.annotations.*;
import org.testng.Assert;
import com.blade.lib.Sikuli;



public class Tester {

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
        System.out.println("> BEFORE METHOD");
    }
    
    @AfterMethod
    public void afterMethod() {
        System.out.println("> AFTER METHOD");
    }
    
    
    
    
    @Test(groups = {"TestRun"})
    public void test1() {
        System.out.println("This is test ONE");
        System.out.println("Invoking Sikuli");
        Sikuli s = new Sikuli();
        try {
            Thread.sleep(1);
        } catch (Exception e) {
        }
        //s.test();

    }

    @Test(groups = {"TestRun"})
    public void test2() {
        System.out.println("This is test TWO");
        Assert.assertTrue(false);
    }

    @Test(groups = {"TestRun"})
    public void test3() {
        Assert.assertTrue(true);
        System.out.println("This is test THREE");
    }
}
