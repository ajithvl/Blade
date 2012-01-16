
package com.blade.listeners.reporters;

import com.blade.ui.BladeUI;
import java.util.List;
import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.TestNG;
import org.testng.xml.XmlSuite;

/**
 *
 * @author avarakukalayil
 */
public class FinalReporter implements IReporter{

    BladeUI ui;

    public FinalReporter(BladeUI ui) {
        this.ui = ui;
    }
    
    @Override
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
        // TO-DO: add code to display test result (no of pass, fail, skip etc.) in ui
    }
    
  

}
