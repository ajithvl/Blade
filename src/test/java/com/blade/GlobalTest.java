/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blade;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


/**
 *
 * @author avarakukalayil
 */
public class GlobalTest {

    @BeforeClass
    public void setUp() {
    }

    @AfterClass
    public void tearDown() {
    }

    @Test
    public void testGetCustomParameter() throws Exception{
        Global.customParameter = "a=1,bcd=2, c=3";
        Assert.assertEquals(Global.getCustomParameter().get("a"), "1");
        Assert.assertEquals(Global.getCustomParameter().get("bcd"), "2");
        Assert.assertEquals(Global.getCustomParameter().get("c"), "3");
    }
}
