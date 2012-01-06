/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blade.listeners.reporters;

/**
 *
 * @author avarakukalayil
 */


import com.blade.Global;
import com.blade.lib.HttpUtil;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.testng.*;
import org.testng.annotations.Listeners;
import org.testng.Assert;
import org.apache.log4j.Logger;


public class RuntimeReporter extends TestListenerAdapter {
    static final Logger logger = Logger.getLogger(RuntimeReporter.class);
    
    
    
    private void report(String url, List<NameValuePair> params) {
        try {
            HttpResponse response = HttpUtil.post(url, params);
            int responseCode = response.getStatusLine().getStatusCode();
            logger.debug("POST ResponseCode = [" + responseCode + "]");
            String responseBody = EntityUtils.toString(response.getEntity());
            logger.debug("POST ResponseBody = [" + responseBody + "]");
            
            if(!responseBody.contains("SUCCESS")) 
                throw new Exception();
                
        } catch(Exception e) {
            logger.error("Failed to send report to " + url);
            //e.printStackTrace();
        }
    }
    

    @Override
    public void onTestFailure (ITestResult testResult) {
        String url = Global.getPropellerHost() + "/reporter/failed";
        
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("run_control_id", Global.getRunControlId()));
        params.add(new BasicNameValuePair("project_name", Global.getProjectName()   ));
        params.add(new BasicNameValuePair("testplan_id", Global.getTestPlanId()));
        params.add(new BasicNameValuePair("build_id", Global.getBuildId()));
        params.add(new BasicNameValuePair("run_id", Global.getRunId()));
        params.add(new BasicNameValuePair("testcase_name", testResult.getName()));
        params.add(new BasicNameValuePair("testsuite", testResult.getTestClass().toString()));
        params.add(new BasicNameValuePair("started", String.valueOf(testResult.getStartMillis())));
        params.add(new BasicNameValuePair("finished", String.valueOf(testResult.getEndMillis())));
        params.add(new BasicNameValuePair("throwable", testResult.getThrowable().toString()));
        params.add(new BasicNameValuePair("host", testResult.getHost()));
        
        report(url, params);
        
//        System.out.println("=============================");
//        System.out.println(" > FAILED");
//        System.out.println("=============================");
//        System.out.println("Name = " +  testResult.getName());
//        System.out.println("Status = " +  testResult.getStatus());
//        System.out.println("Method = " +  testResult.getMethod());
//        System.out.println("Parameters = " +  testResult.getParameters());
//        System.out.println("TestClass = " +  testResult.getTestClass());
//        System.out.println("StartMillis = " +  testResult.getStartMillis());
//        System.out.println("EndMillis = " +  testResult.getEndMillis());
//        System.out.println("isSuccess = " +  testResult.isSuccess());
//        System.out.println("Host = " +  testResult.getHost());
//        System.out.println("Instance = " +  testResult.getInstance());
//        System.out.println("TestName = " +  testResult.getTestName());
//        System.out.println("Throwable = " +  testResult.getThrowable());
//        System.out.println("-----------------------------");
    }

    @Override
    public void onTestSkipped(ITestResult testResult) {
        String url = Global.getPropellerHost() + "/reporter/skipped";
        
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("run_control_id", Global.getRunControlId()));
        params.add(new BasicNameValuePair("project_name", Global.getProjectName()   ));
        params.add(new BasicNameValuePair("testplan_id", Global.getTestPlanId()));
        params.add(new BasicNameValuePair("build_id", Global.getBuildId()));
        params.add(new BasicNameValuePair("run_id", Global.getRunId()));
        params.add(new BasicNameValuePair("testcase_name", testResult.getName()));
        params.add(new BasicNameValuePair("testsuite", testResult.getTestClass().toString()));
        params.add(new BasicNameValuePair("started", String.valueOf(testResult.getStartMillis())));
        params.add(new BasicNameValuePair("finished", String.valueOf(testResult.getEndMillis())));
        params.add(new BasicNameValuePair("host", testResult.getHost()));
        
        report(url, params);       
        
//        System.out.println("=============================");
//        System.out.println(" > SKIPPED");
//        System.out.println("=============================");
//        System.out.println("Name = " +  testResult.getName());
//        System.out.println("Status = " +  testResult.getStatus());
//        System.out.println("Method = " +  testResult.getMethod());
//        System.out.println("Parameters = " +  testResult.getParameters());
//        System.out.println("TestClass = " +  testResult.getTestClass());
//        System.out.println("StartMillis = " +  testResult.getStartMillis());
//        System.out.println("EndMillis = " +  testResult.getEndMillis());
//        System.out.println("isSuccess = " +  testResult.isSuccess());
//        System.out.println("Host = " +  testResult.getHost());
//        System.out.println("Instance = " +  testResult.getInstance());
//        System.out.println("TestName = " +  testResult.getTestName());
//        System.out.println("Throwable = " +  testResult.getThrowable());
//        System.out.println("-----------------------------");
    }

    @Override
    public void onTestSuccess(ITestResult testResult) {
        String url = Global.getPropellerHost() + "/reporter/success";
        
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("run_control_id", Global.getRunControlId()));
        params.add(new BasicNameValuePair("project_name", Global.getProjectName()   ));
        params.add(new BasicNameValuePair("testplan_id", Global.getTestPlanId()));
        params.add(new BasicNameValuePair("build_id", Global.getBuildId()));
        params.add(new BasicNameValuePair("run_id", Global.getRunId()));
        params.add(new BasicNameValuePair("testcase_name", testResult.getName()));
        params.add(new BasicNameValuePair("testsuite", testResult.getTestClass().toString()));
        params.add(new BasicNameValuePair("started", String.valueOf(testResult.getStartMillis())));
        params.add(new BasicNameValuePair("finished", String.valueOf(testResult.getEndMillis())));
        params.add(new BasicNameValuePair("host", testResult.getHost()));
        
        report(url, params);
        
//        System.out.println("=============================");
//        System.out.println(" > SUCCESS");
//        System.out.println("=============================");
//        System.out.println("Name = " +  testResult.getName());
//        System.out.println("Status = " +  testResult.getStatus());
//        System.out.println("Method = " +  testResult.getMethod());
//        System.out.println("Parameters = " +  testResult.getParameters());
//        System.out.println("TestClass = " +  testResult.getTestClass());
//        System.out.println("StartMillis = " +  testResult.getStartMillis());
//        System.out.println("EndMillis = " +  testResult.getEndMillis());
//        System.out.println("isSuccess = " +  testResult.isSuccess());
//        System.out.println("Host = " +  testResult.getHost());
//        System.out.println("Instance = " +  testResult.getInstance());
//        System.out.println("TestName = " +  testResult.getTestName());
//        System.out.println("Throwable = " +  testResult.getThrowable());
//        System.out.println("-----------------------------");
    }

    
    
    
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult testResult) {
        System.out.println("Test failed but with success percentage (listener)");
    }

    
    
    
    @Override
    public void onStart(ITestContext iTestContext) {
        String url = Global.getPropellerHost() + "/reporter/suite_start";
        
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("run_control_id", Global.getRunControlId()));
        params.add(new BasicNameValuePair("project_name", Global.getProjectName()   ));
        params.add(new BasicNameValuePair("testplan_id", Global.getTestPlanId()));
        params.add(new BasicNameValuePair("build_id", Global.getBuildId()));
        params.add(new BasicNameValuePair("run_id", Global.getRunId()));
        params.add(new BasicNameValuePair("suite_name", iTestContext.getName()));
        params.add(new BasicNameValuePair("start_date", String.valueOf(iTestContext.getStartDate().getTime())));
        params.add(new BasicNameValuePair("output_dir", iTestContext.getOutputDirectory()));
        params.add(new BasicNameValuePair("suit", iTestContext.getSuite().toString()));
        params.add(new BasicNameValuePair("host", iTestContext.getHost()));
        
        report(url, params);
        
//        System.out.println("=============================");
//        System.out.println(" + TEST SUITE STARTED (listener)");
//        System.out.println("=============================");
//        System.out.println("Name = " +  iTestContext.getName());
//        System.out.println("StartDate = " +  iTestContext.getStartDate());
//        System.out.println("EndDate = " +  iTestContext.getEndDate());
//        System.out.println("OutputDirectory = " +  iTestContext.getOutputDirectory());
//        ////System.out.println("TestSuite = " +  iTestContext.getAllTestMethods()[0].getTestClass());
//        System.out.println("Suit = " +  iTestContext.getSuite());
//        System.out.println("Host = " +  iTestContext.getHost());
//        System.out.println("----------------------------");
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        String url = Global.getPropellerHost() + "/reporter/suite_finish";
        
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("run_control_id", Global.getRunControlId()));
        params.add(new BasicNameValuePair("project_name", Global.getProjectName()   ));
        params.add(new BasicNameValuePair("testplan_id", Global.getTestPlanId()));
        params.add(new BasicNameValuePair("build_id", Global.getBuildId()));
        params.add(new BasicNameValuePair("run_id", Global.getRunId()));
        params.add(new BasicNameValuePair("suite_name", iTestContext.getName()));
        params.add(new BasicNameValuePair("start_date", String.valueOf(iTestContext.getStartDate().getTime())));
        params.add(new BasicNameValuePair("end_date", String.valueOf(iTestContext.getEndDate().getTime())));
        params.add(new BasicNameValuePair("output_dir", iTestContext.getOutputDirectory()));
        params.add(new BasicNameValuePair("suit", iTestContext.getSuite().toString()));
        params.add(new BasicNameValuePair("host", iTestContext.getHost()));
        
        report(url, params);
//        System.out.println("=============================");
//        System.out.println(" + TEST SUITE ENDED");
//        System.out.println("=============================");
//        System.out.println("Name = " +  iTestContext.getName());
//        System.out.println("StartDate = " +  iTestContext.getStartDate());
//        System.out.println("EndDate = " +  iTestContext.getEndDate());
//        System.out.println("OutputDirectory = " +  iTestContext.getOutputDirectory());
//        ////System.out.println("TestSuite = " +  iTestContext.getAllTestMethods()[0].getTestClass());
//        System.out.println("Suit = " +  iTestContext.getSuite());
//        System.out.println("Host = " +  iTestContext.getHost());
//        System.out.println("----------------------------");
    }

    
    
    
    @Override
    public void onTestStart(ITestResult testResult) {
        String url = Global.getPropellerHost() + "/reporter/test_start";
        
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("run_control_id", Global.getRunControlId()));
        params.add(new BasicNameValuePair("project_name", Global.getProjectName()   ));
        params.add(new BasicNameValuePair("testplan_id", Global.getTestPlanId()));
        params.add(new BasicNameValuePair("build_id", Global.getBuildId()));
        params.add(new BasicNameValuePair("run_id", Global.getRunId()));
        params.add(new BasicNameValuePair("testcase_name", testResult.getName()));
        params.add(new BasicNameValuePair("testsuite", testResult.getTestClass().toString()));
        params.add(new BasicNameValuePair("started", String.valueOf(testResult.getStartMillis())));
        params.add(new BasicNameValuePair("host", testResult.getHost()));
        
        report(url, params);
        
//        System.out.println("=============================");
//        System.out.println("------ TEST CASE STARTED");
//        System.out.println("=============================");
//        System.out.println("Name = " +  testResult.getName());
//        System.out.println("Status = " +  testResult.getStatus());
//        System.out.println("Method = " +  testResult.getMethod());
//        System.out.println("Parameters = " +  testResult.getParameters());
//        System.out.println("TestClass = " +  testResult.getTestClass());
//        System.out.println("StartMillis = " +  testResult.getStartMillis());
//        System.out.println("isSuccess = " +  testResult.isSuccess());
//        System.out.println("Host = " +  testResult.getHost());
//        System.out.println("Instance = " +  testResult.getInstance());
//        System.out.println("TestName = " +  testResult.getTestName());
//        System.out.println("-----------------------------");
    }

    
    
    
    
    @Override
    public void onConfigurationFailure(ITestResult testResult) {
        String url = Global.getPropellerHost() + "/reporter/config_failed";
        
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("run_control_id", Global.getRunControlId()));
        params.add(new BasicNameValuePair("project_name", Global.getProjectName()   ));
        params.add(new BasicNameValuePair("testplan_id", Global.getTestPlanId()));
        params.add(new BasicNameValuePair("build_id", Global.getBuildId()));
        params.add(new BasicNameValuePair("run_id", Global.getRunId()));
        params.add(new BasicNameValuePair("config_name", testResult.getName()));
        params.add(new BasicNameValuePair("testsuite", testResult.getTestClass().toString()));
        params.add(new BasicNameValuePair("started", String.valueOf(testResult.getStartMillis())));
        params.add(new BasicNameValuePair("finished", String.valueOf(testResult.getEndMillis())));
        params.add(new BasicNameValuePair("throwable", testResult.getThrowable().toString()));
        params.add(new BasicNameValuePair("host", testResult.getHost()));
        logger.debug("Adding post params [" + params.toString() + "]");
        
        report(url, params);
//        System.out.println("### CONFIGURATION FAILED #########################");
    }
    
    @Override
    public void onConfigurationSkip(ITestResult testResult) {
        String url = Global.getPropellerHost() + "/reporter/config_skipped";
        
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("run_control_id", Global.getRunControlId()));
        params.add(new BasicNameValuePair("project_name", Global.getProjectName()   ));
        params.add(new BasicNameValuePair("testplan_id", Global.getTestPlanId()));
        params.add(new BasicNameValuePair("build_id", Global.getBuildId()));
        params.add(new BasicNameValuePair("run_id", Global.getRunId()));
        params.add(new BasicNameValuePair("config_name", testResult.getName()));
        params.add(new BasicNameValuePair("testsuite", testResult.getTestClass().toString()));
        params.add(new BasicNameValuePair("started", String.valueOf(testResult.getStartMillis())));
        params.add(new BasicNameValuePair("finished", String.valueOf(testResult.getEndMillis())));
        params.add(new BasicNameValuePair("host", testResult.getHost()));
        
        report(url, params);
//        System.out.println("### CONFIGURATION SKIPPED ########################");
    }
    
    @Override
    public void onConfigurationSuccess(ITestResult testResult) {
        String url = Global.getPropellerHost() + "/reporter/config_success";
        
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("run_control_id", Global.getRunControlId()));
        params.add(new BasicNameValuePair("project_name", Global.getProjectName()   ));
        params.add(new BasicNameValuePair("testplan_id", Global.getTestPlanId()));
        params.add(new BasicNameValuePair("build_id", Global.getBuildId()));
        params.add(new BasicNameValuePair("run_id", Global.getRunId()));
        params.add(new BasicNameValuePair("config_name", testResult.getName()));
        params.add(new BasicNameValuePair("testsuite", testResult.getTestClass().toString()));
        params.add(new BasicNameValuePair("started", String.valueOf(testResult.getStartMillis())));
        params.add(new BasicNameValuePair("finished", String.valueOf(testResult.getEndMillis())));
        params.add(new BasicNameValuePair("host", testResult.getHost()));
        
        report(url, params);
        
//        System.out.println("");
//        System.out.println("=============================");
//        System.out.println("### CONFIGURATION SUCCESS ####");
//        System.out.println("=============================");
//        System.out.println("Name = " +  testResult.getName());
//        System.out.println("Host = " +  testResult.getHost());
//        System.out.println("TestName = " +  testResult.getTestName());
//        System.out.println("StartMillis = " +  testResult.getStartMillis());
//        System.out.println("EndMillis = " +  testResult.getEndMillis());
//        System.out.println("TestClass = " +  testResult.getTestClass());
//        System.out.println("Status = " +  testResult.getStatus());
//        System.out.println("Method = " +  testResult.getMethod());
//        System.out.println("Parameters = " +  testResult.getParameters());
//        System.out.println("Throwable = " +  testResult.getThrowable());
//        System.out.println("isSuccess = " +  testResult.isSuccess());
//        System.out.println("Instance = " +  testResult.getInstance());
//        System.out.println("-----------------------------");
    }
    
    

}
