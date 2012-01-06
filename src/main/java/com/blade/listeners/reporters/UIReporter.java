/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blade.listeners.reporters;

import com.blade.ui.BladeUI;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

/**
 *
 * @author avarakukalayil
 */
public class UIReporter extends TestListenerAdapter{
    BladeUI ui;

    public UIReporter(BladeUI ui) {
        this.ui = ui;
    }
    
    @Override
    public void onStart(ITestContext iTestContext) {
        ui.uiLogger("### TESTSUITE [" + iTestContext.getName() + "] STARTED #####################");
    }
    
    
    @Override
    public void onFinish(ITestContext iTestContext) {
        ui.uiLogger("### TESTSUITE [" + iTestContext.getName() + "] COMPLETED ###################");
    }
    
    
    @Override
    public void onTestFailure(ITestResult testResult) {
        ui.uiLogger("- " + testResult.getMethod() + " => FAILED");
        
    }

    @Override
    public void onTestSkipped(ITestResult testResult) {
        ui.uiLogger("- " + testResult.getMethod() + " => SKIPPED");
    }

    @Override
    public void onTestSuccess(ITestResult testResult) {
        ui.uiLogger("- " + testResult.getMethod() + " => SUCCESS");
    }
    
}
