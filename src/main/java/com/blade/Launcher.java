package com.blade;

import com.blade.core.NanoHTTPD;
import com.blade.listeners.reporters.RuntimeReporter;
import com.blade.ui.BladeUI;
import java.util.Properties;
import org.apache.log4j.Logger;

/**
 *
 * @author avarakukalayil
 */
public class Launcher {
    static final Logger logger = Logger.getLogger(Launcher.class);
    
    // Listening port (Propeller will control blade via this port)
    final static int listeningPort = 9897;

    public static void main(String[] args) throws Exception {
        
        /*
         * Invoking HTTP server to listen to commands COMMANDS: 1) skip : Skip
         * all the tests in the list 2) abort : Gracefully abort all the pending
         * tests
         */
        NanoHTTPD server = new NanoHTTPD(listeningPort, null) {

            @Override
            public NanoHTTPD.Response serve(String uri, String method, Properties header, Properties parms, Properties files) {
                if ("/run".equals(uri) && "POST".equals(method)) {
                    try {
                        //Object msgParam = parms.get("msg");
                        Global.setProjectName(parms.get("project_name").toString());
                        Global.setTestPlanId(parms.get("testplan_id").toString());
                        Global.setBuildId(parms.get("build_id").toString());
                        Global.setRunId(parms.get("run_id").toString());
                        Global.setTestngXmlPaths(parms.get("xml_paths").toString());
                        Global.setLogLevel(parms.get("log_level").toString());
                        Global.setSystemMonitor(parms.get("monitor").toString());
                        Global.setCustomParameter(parms.get("custom_params").toString());
                        Global.setPropellerHost(parms.get("propeller_host").toString());
                        Global.setBrowserName(parms.get("browser").toString());
                        TestRunner runner = new TestRunner();
                        runner.attachListner(new RuntimeReporter());
                        runner.execute();
                    } catch (Exception e) {
                        logger.error(e.getStackTrace());
                        return new NanoHTTPD.Response("500", "application/json", "{\"status\":\"Failed\",\"reason\":\"" + e.getMessage() + "\"}");
                    }
                    return new NanoHTTPD.Response("200", "application/json", "{\"status\":\"ok\"}");
                } else if ("/skip".equals(uri) && "POST".equals(method)) {
                    try {
                        Global.setToBeSkipped(parms.get("skip").toString());
                    } catch (Exception e) {
                        logger.error(e.getStackTrace());
                        return new NanoHTTPD.Response("500", "application/json", "{\"status\":\"Failed\",\"reason\":\"" + e.getMessage() + "\"}");
                    }
                    return new NanoHTTPD.Response("200", "application/json", "{\"status\":\"ok\"}");
                } else if ("/shutdown".equals(uri) && "POST".equals(method)) {
                    try {
                        Global.shutdown = true;
                    } catch (Exception e) {
                        logger.error(e.getStackTrace());
                        return new NanoHTTPD.Response("500", "application/json", "{\"status\":\"Failed\",\"reason\":\"" + e.getMessage() + "\"}");
                    }
                    return new NanoHTTPD.Response("200", "application/json", "{\"status\":\"ok\"}");
                }
                return new NanoHTTPD.Response("404", "text/plain", "Not Found");
            }
        };

        
        
        // Build the UI
        BladeUI ui = new BladeUI();
        ui.setListeningPort(listeningPort);
   
        ui.uiLogger("JAVA HOME = " + Global.JAVA_HOME);
        ui.uiLogger("JAVA VENDOR = " + Global.JAVA_VENDOR);
        ui.uiLogger("JAVA VERSION = " + Global.JAVA_VERSION);
        ui.uiLogger("OS ARCHITECTURE = " + Global.OS_ARCH);
        ui.uiLogger("OS NAME = " + Global.OS_NAME);
        ui.uiLogger("OS VERSION = " + Global.OS_VERSION);
        ui.uiLogger("USER DIRECTORY = " + Global.USER_DIR);
        ui.uiLogger("USER HOME = " + Global.USER_HOME);
        ui.uiLogger("------------------------------------------------------------------------------------");
        
        



        
        
        // Stops the HTTP server
        //server.stop();
    }
}
