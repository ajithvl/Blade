/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blade.lib;

/**
 *
 * @author avarakukalayil
 */
import java.io.IOException;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;

public class HttpUtil {
    static final Logger logger = Logger.getLogger(HttpUtil.class);

    public static HttpResponse get(String url) throws IOException {
    	logger.debug("GET-ing URL: " + url);
    	return fetchResponse(new HttpGet(url));
    }

    public static HttpResponse post(String url, List<NameValuePair> params) throws IOException {
    	logger.debug("POST-ing to URL: " + url);
    	logger.debug("Params: " + params);
    	HttpPost post = new HttpPost(url);
		post.setEntity(new UrlEncodedFormEntity(params));
    	return fetchResponse(post);
    }
    
    public static JSONObject extractJSON(HttpResponse response) throws IOException, JSONException {
    	String responseBody = EntityUtils.toString(response.getEntity());
    	logger.debug("Converting to JSON: " + responseBody);
        return new JSONObject(responseBody);
    }
    
    private  static HttpResponse fetchResponse(HttpUriRequest request) throws IOException {
        return new DefaultHttpClient().execute(request);
    }
}
