package com.blade.lib.core;

/**
 *
 * @author avarakukalayil
 */
import static org.testng.Assert.*;

import java.io.IOException;
import java.util.Properties;

import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.blade.testutil.NanoHTTPD;

public class HttpUtilTest {
	private NanoHTTPD server;
	
	@BeforeClass
	public void setUp() throws IOException {
    	server = new NanoHTTPD(9898, null) {
			@Override
			public Response serve(String uri, String method, Properties header,
					Properties parms, Properties files) {
				if("/get_path".equals(uri) && "GET".equals(method)) {
					return new Response("200", "application/json", "{\"msg\":\"Get Response\"}");
				}

				if("/post_path".equals(uri) && "POST".equals(method)) {
					Object msgParam = parms.get("msg");
					return new Response("200", "application/json", "{\"msg\":\"" + msgParam + "\"}");
				}
				return new Response("404", "text/plain", "Not Found");
			}
    	};
	}
	
	@AfterClass
	public void tearDown() {
		server.stop();
	}

    @Test
    public void testGet() throws JSONException {
    	JSONObject response = HttpUtil.get("http://localhost:9898/get_path");
    	assertEquals(response.toString(), "{\"msg\":\"Get Response\"}");
    }
    
    @Test
    public void testPost() throws JSONException {
    	JSONObject response = HttpUtil.post("http://localhost:9898/post_path", "msg=Hello");
    	assertEquals(response.toString(), "{\"msg\":\"Hello\"}");
    }
}
