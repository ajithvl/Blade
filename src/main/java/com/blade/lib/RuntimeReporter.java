/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blade.lib;

/**
 *
 * @author avarakukalayil
 */


import java.util.ArrayList;
import java.util.List;
import org.testng.*;
import org.testng.annotations.Listeners;


public class RuntimeReporter extends TestListenerAdapter {


    @Override
    public void onTestFailure(ITestResult testResult) {
        System.out.println("=============================");
        System.out.println(" > FAILED");
        System.out.println("=============================");
        System.out.println("Name = " +  testResult.getName());
        System.out.println("Status = " +  testResult.getStatus());
        System.out.println("Method = " +  testResult.getMethod());
        System.out.println("Parameters = " +  testResult.getParameters());
        System.out.println("TestClass = " +  testResult.getTestClass());
        System.out.println("StartMillis = " +  testResult.getStartMillis());
        System.out.println("EndMillis = " +  testResult.getEndMillis());
        System.out.println("isSuccess = " +  testResult.isSuccess());
        System.out.println("Host = " +  testResult.getHost());
        System.out.println("Instance = " +  testResult.getInstance());
        System.out.println("TestName = " +  testResult.getTestName());
        System.out.println("Throwable = " +  testResult.getThrowable());
        System.out.println("-----------------------------");
    }

    @Override
    public void onTestSkipped(ITestResult testResult) {
        System.out.println("=============================");
        System.out.println(" > SKIPPED");
        System.out.println("=============================");
        System.out.println("Name = " +  testResult.getName());
        System.out.println("Status = " +  testResult.getStatus());
        System.out.println("Method = " +  testResult.getMethod());
        System.out.println("Parameters = " +  testResult.getParameters());
        System.out.println("TestClass = " +  testResult.getTestClass());
        System.out.println("StartMillis = " +  testResult.getStartMillis());
        System.out.println("EndMillis = " +  testResult.getEndMillis());
        System.out.println("isSuccess = " +  testResult.isSuccess());
        System.out.println("Host = " +  testResult.getHost());
        System.out.println("Instance = " +  testResult.getInstance());
        System.out.println("TestName = " +  testResult.getTestName());
        System.out.println("Throwable = " +  testResult.getThrowable());
        System.out.println("-----------------------------");
    }

    @Override
    public void onTestSuccess(ITestResult testResult) {
        System.out.println("=============================");
        System.out.println(" > SUCCESS");
        System.out.println("=============================");
        System.out.println("Name = " +  testResult.getName());
        System.out.println("Status = " +  testResult.getStatus());
        System.out.println("Method = " +  testResult.getMethod());
        System.out.println("Parameters = " +  testResult.getParameters());
        System.out.println("TestClass = " +  testResult.getTestClass());
        System.out.println("StartMillis = " +  testResult.getStartMillis());
        System.out.println("EndMillis = " +  testResult.getEndMillis());
        System.out.println("isSuccess = " +  testResult.isSuccess());
        System.out.println("Host = " +  testResult.getHost());
        System.out.println("Instance = " +  testResult.getInstance());
        System.out.println("TestName = " +  testResult.getTestName());
        System.out.println("Throwable = " +  testResult.getThrowable());
        System.out.println("-----------------------------");
    }

    
    
    
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult testResult) {
        System.out.println("Test failed but with success percentage (listener)");
    }

    
    
    
    @Override
    public void onStart(ITestContext iTestContext) {
        System.out.println("=============================");
        System.out.println(" + TEST SUITE STARTED (listener)");
        System.out.println("=============================");
        System.out.println("Name = " +  iTestContext.getName());
        System.out.println("StartDate = " +  iTestContext.getStartDate());
        System.out.println("EndDate = " +  iTestContext.getEndDate());
        System.out.println("OutputDirectory = " +  iTestContext.getOutputDirectory());
        System.out.println("TestSuite = " +  iTestContext.getAllTestMethods()[0].getTestClass());
        System.out.println("Suit = " +  iTestContext.getSuite());
        System.out.println("Host = " +  iTestContext.getHost());
        System.out.println("----------------------------");
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        System.out.println("=============================");
        System.out.println(" + TEST SUITE ENDED");
        System.out.println("=============================");
        System.out.println("Name = " +  iTestContext.getName());
        System.out.println("StartDate = " +  iTestContext.getStartDate());
        System.out.println("EndDate = " +  iTestContext.getEndDate());
        System.out.println("OutputDirectory = " +  iTestContext.getOutputDirectory());
        System.out.println("TestSuite = " +  iTestContext.getAllTestMethods()[0].getTestClass());
        System.out.println("Suit = " +  iTestContext.getSuite());
        System.out.println("Host = " +  iTestContext.getHost());
        System.out.println("----------------------------");
    }

    
    
    
    @Override
    public void onTestStart(ITestResult testResult) {
        System.out.println("=============================");
        System.out.println("------ TEST CASE STARTED");
        System.out.println("=============================");
        System.out.println("Name = " +  testResult.getName());
        System.out.println("Status = " +  testResult.getStatus());
        System.out.println("Method = " +  testResult.getMethod());
        System.out.println("Parameters = " +  testResult.getParameters());
        System.out.println("TestClass = " +  testResult.getTestClass());
        System.out.println("StartMillis = " +  testResult.getStartMillis());
        System.out.println("isSuccess = " +  testResult.isSuccess());
        System.out.println("Host = " +  testResult.getHost());
        System.out.println("Instance = " +  testResult.getInstance());
        System.out.println("TestName = " +  testResult.getTestName());
        System.out.println("-----------------------------");
    }

    
    
    
    
    @Override
    public void onConfigurationFailure(ITestResult testResult) {
        System.out.println("### CONFIGURATION FAILED #########################");
    }
    
    @Override
    public void onConfigurationSkip(ITestResult testResult) {
        System.out.println("### CONFIGURATION SKIPPED ########################");
    }
    
    @Override
    public void onConfigurationSuccess(ITestResult testResult) {
        System.out.println("");
        System.out.println("=============================");
        System.out.println("### CONFIGURATION SUCCESS ####");
        System.out.println("=============================");
        System.out.println("Name = " +  testResult.getName());
        System.out.println("Host = " +  testResult.getHost());
        System.out.println("TestName = " +  testResult.getTestName());
        System.out.println("StartMillis = " +  testResult.getStartMillis());
        System.out.println("EndMillis = " +  testResult.getEndMillis());
        System.out.println("TestClass = " +  testResult.getTestClass());
        System.out.println("Status = " +  testResult.getStatus());
        System.out.println("Method = " +  testResult.getMethod());
        System.out.println("Parameters = " +  testResult.getParameters());
        System.out.println("Throwable = " +  testResult.getThrowable());
        System.out.println("isSuccess = " +  testResult.isSuccess());
        System.out.println("Instance = " +  testResult.getInstance());
        System.out.println("-----------------------------");
    }
    
    

}
