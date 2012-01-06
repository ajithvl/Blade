package com.blade.listeners;

import com.blade.Global;
import org.apache.log4j.Logger;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;
import org.testng.SkipException;

    
/**
 *
 * @author avarakukalayil
 */
public class MethodListener implements IInvokedMethodListener {
    
    static final Logger logger = Logger.getLogger(MethodListener.class);
    
    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        logger.debug("BeforeInvocation:: Checking if [" + method.getTestMethod().getTestClass().getName() + "] exists in [" + Global.toBeSkipped + "]");
        if(Global.shutdown) {
            logger.debug("BeforeInvocation:: Skipped (Reason = shutting down) [" + method.getTestMethod() + "]");
            throw new SkipException("Shutdown initiated Skipped [" + method.getTestMethod().getTestClass() + "] at runtime");
        }
        
        if(Global.toBeSkipped.contains(method.getTestMethod().getTestClass().getName())) {
            logger.debug("BeforeInvocation:: Skipped [" + method.getTestMethod() + "]");
            testResult.setStatus(3);
            throw new SkipException("Skipped [" + method.getTestMethod().getTestClass() + "] at runtime");
        }
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
    }

}
