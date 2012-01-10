package com.blade;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Properties;
import java.util.regex.Pattern;
import org.apache.log4j.Logger;

/**
 *
 * @author avarakukalayil
 */
public class Global {
    
    static final Logger logger = Logger.getLogger(Global.class);
    
    // SYSTEM PROPERTIES
    public static final String JAVA_HOME = System.getProperty("java.home");
    public static final String JAVA_VENDOR = System.getProperty("java.vendor");
    public static final String JAVA_VERSION = System.getProperty("java.version");
    public static final String OS_ARCH = System.getProperty("os.arch");
    public static final String OS_NAME = System.getProperty("os.name");
    public static final String OS_VERSION = System.getProperty("os.version");
    public static final String USER_DIR = System.getProperty("user.dir");
    public static final String USER_HOME = System.getProperty("user.home");
    public static final String USER_NAME = System.getProperty("user.name");
    
    // BLADE PROPERTIES
    private static String logLevel = System.getProperty("log.level");
    
    private static String runControlId = System.getProperty("test.id");
    private static String projectName = System.getProperty("project.name");
    private static String testPlanId = System.getProperty("test.plan.id");
    private static String buildId = System.getProperty("build.id");
    private static String runId = System.getProperty("run.id");
    private static String browserName = System.getProperty("browser.name");
    private static String testngXmlPaths = System.getProperty("testng.xml.paths");
    private static String propellerHost = System.getProperty("propeller.host");
    private static String systemMonitor = System.getProperty("system.monitor");
    public static String customParameter = System.getProperty("custom.parameter");
    
    
    // OTHER PROPERTIES
    public static ArrayList<String> toBeSkipped = new ArrayList();
    public static boolean shutdown = false;
    
    public static boolean TEST_STATUS = false;
    
    
    
    public static synchronized String getLogLevel() {
        return logLevel;
    }
    
    public static synchronized String getRunControlId() {
        return runControlId;
    }
    
    public static synchronized String getProjectName() {
        return projectName;
    }
    
    public static synchronized String getTestPlanId() {
        return testPlanId;
    }
    
    public static synchronized String getBuildId() {
        return buildId;
    }
    
    public static synchronized String getRunId() {
        return runId;
    }
    
    public static synchronized String getBrowserName() {
        return browserName;
    }
    
    
    public static synchronized String[] getTestngXmlPaths() throws Exception {
        Pattern p = Pattern.compile(",");
        return p.split(testngXmlPaths);
    }
    
    public static synchronized String getPropellerHost() {
        return propellerHost;
    }
    
    public static synchronized ArrayList<String> getSystemMonitor() throws Exception {
        Pattern p = Pattern.compile(",");
        ArrayList<String> monitorResources = new ArrayList(Arrays.asList(p.split(systemMonitor)));
        return monitorResources;
    }
    
    public static synchronized Properties getCustomParameter() throws Exception {
        Properties p = new Properties();
  
        Pattern p1 = Pattern.compile(",");
        Pattern p2 = Pattern.compile("=");
        
        for(String properties: p1.split(customParameter)) {
           String[] s = p2.split(properties.trim());
           p.put(s[0].trim(), s[1].trim());
        }
        
        return p;
    }
    
    
    /*
     * 
     * Setters
     * 
     */

    public static synchronized void setLogLevel(String ll) {
        logLevel = ll;
        System.setProperty("blade.log.level", ll);
    }
    
    public static synchronized void setRunControlId(String rcid) {
        runControlId = rcid;
    }
    
    public static synchronized void setProjectName(String pname) {
        projectName = pname;
    }
    
    public static synchronized void setTestPlanId(String tpid) {
        testPlanId = tpid;
    }
    
    public static synchronized void setBuildId(String bid) {
        buildId = bid;
    }
    
    public static synchronized void setRunId(String rid) {
        runId = rid;
    }
    
    public static synchronized void setBrowserName(String browser) {
        browser = browser.trim();
        if(browser.toLowerCase().equals("ie")) {
            logger.debug("Setting browser to [IE]");
            browserName = "IE";
        } else if(browser.toLowerCase().equals("ff")){
            logger.debug("Setting browser to [Firefox]");
            browserName = "FIREFOX";
        } else if(browser.toLowerCase().equals("chrome")){
            logger.debug("Setting browser to [Chrome]");
            browserName = "CHROME";
        } else if(browser.toLowerCase().equals("safari")){
            logger.debug("Setting browser to [Safari]");
            browserName = "SAFARI";
        } else {
            logger.debug("Setting default browser [Firefox]");
            browserName = "FIREFOX";
        }
        
    }
    
    public static synchronized void setTestngXmlPaths(String xmlPaths) throws Exception {
        testngXmlPaths = xmlPaths;
    }
    
    public static synchronized void setPropellerHost(String host) {
        propellerHost = host;
    }
    
    public static synchronized void setSystemMonitor(String monitor) throws Exception {
        systemMonitor = monitor;
    }
    
    public static synchronized void setCustomParameter(String custParams) throws Exception {
        customParameter = custParams;
    }
    
    public static synchronized void setToBeSkipped(String tests) {
        toBeSkipped.clear();
        Collections.addAll(toBeSkipped, Pattern.compile(",").split(tests));
    }    
}
