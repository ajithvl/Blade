package com.blade.listeners;

import com.blade.Global;
import org.apache.log4j.Logger;
import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestResult;
import org.testng.SkipException;

/**
 *
 * @author avarakukalayil
 */
public class RuntimeHooker implements IHookable {

     static final Logger logger = Logger.getLogger(RuntimeHooker.class);
    
    @Override
    public void run(final IHookCallBack icb, ITestResult testResult) {
        logger.debug("RuntimeHooker:: Checking if [" + testResult.getTestClass().getName() + "] exists in [" + Global.toBeSkipped + "]");
        
        if ((!Global.toBeSkipped.isEmpty()) && Global.toBeSkipped.contains(testResult.getTestClass().getName() + "." + testResult.getName())   ) {
            logger.debug("RuntimeHooker:: Skipped [" + testResult.getTestClass().getName() + "." + testResult.getName() + "]");
            testResult.setStatus(3);
            throw new SkipException("Skipped at runtime");
        } else {
            icb.runTestMethod(testResult);
        }
    }
}
