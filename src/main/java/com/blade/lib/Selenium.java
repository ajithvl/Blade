package com.blade.lib;

/**
 *
 * @author avarakukalayil
 */
import com.blade.Global;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Selenium {

    public WebDriver driver;

    
    public void assignBrowser() {
        if ("FIREFOX".equals(Global.getBrowserName())) {
            driver = new FirefoxDriver();
        } else if ("IE".equals(Global.getBrowserName())) {
            driver = new InternetExplorerDriver();
        } else if ("CHROME".equals(Global.getBrowserName())) {
            driver = new FirefoxDriver();
        } else {
            driver = new FirefoxDriver();
        }
    }
    
    public void maximize() {
        driver.manage().window().setPosition(new Point(0,0));
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        Dimension dim = new Dimension((int) screenSize.getWidth(), (int) screenSize.getHeight());
        driver.manage().window().setSize(dim);
    }
    
    public WebDriver launchBrowser() {
        maximize();
        assignBrowser();
        return driver;
    }
    
    public WebDriver launchBrowser(String url) {
        assignBrowser();
        maximize();
        driver.get(url);
        return driver;
    }
}
