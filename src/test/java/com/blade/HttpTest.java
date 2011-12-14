/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blade;

/**
 *
 * @author avarakukalayil
 */
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.blade.lib.core.Http;
import org.apache.log4j.BasicConfigurator;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class HttpTest {

    @BeforeClass
    public void setUp() {
        BasicConfigurator.configure();
    }

    @AfterClass
    public void cleanUp() {
        // code that will be invoked after this test ends
    }

    @Test
    public void getRequestWithUri() throws Exception {
        URI uri = new URI("http://www.google.com");
        String response = Http.get(uri);
        Assert.assertTrue(response.contains("Google"));
    }
    
    @Test
    public void postRequestWithUri() throws Exception {
        URI uri = new URI("http://www.google.com");
        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
        nameValuePairs.add(new BasicNameValuePair("id", "1"));
        String response = Http.post(uri, nameValuePairs);
    }
    
}
