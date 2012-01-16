/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blade.core;

/**
 *
 * @author avarakukalayil
 */

import org.testng.annotations.*;

public class UtilTest {
    
    
    
    @Test
    public void testSecreenshot() throws Exception {
        Util.captureScreen("target\\estscreen");
    }
}
