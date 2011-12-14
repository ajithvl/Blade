/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blade.lib.core;

/**
 *
 * @author avarakukalayil
 */
import org.apache.http.client.entity.UrlEncodedFormEntity;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;


import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;

public class Http {

    //private static final boolean debug = false;
    static final Logger logger = Logger.getLogger(Http.class);

    /**
     * Makes a GET request to the URI specified and returns the response body
     * as String
     * ----------------------------------------------------------------------
     * @param uri   The URI which has to be requested
     * @return  Response body in String format
     */
    public static String get(URI uri) {
        HttpClient httpclient = new DefaultHttpClient();
        HttpGet httpget;
        HttpEntity entity;
        String responseBody = null;

        try {

            httpget = new HttpGet(uri);
            logger.info("GET REQUEST = [" + httpget.getURI() + "]");
            logger.info("Fetching Response");
            HttpResponse response = httpclient.execute(httpget);

            // Create a response handler
            entity = response.getEntity();
            responseBody = EntityUtils.toString(entity);

        } catch (ClientProtocolException e) {
            logger.error("Error in HTTP protocol: " + e.getMessage());
        } catch (IOException e) {
            logger.error("Fatal transport error: " + e.getMessage());
        } catch (Exception e) {
            logger.error("Network Exception: " + e.getMessage());
        } finally {
            httpclient.getConnectionManager().shutdown();
        }
        return responseBody;
    }

    /**
     * Makes a GET request to the URL specified and returns the response body
     * as JSONObject
     * ----------------------------------------------------------------------
     * @param url   The URL which has to be requested
     * @return  Response body in JSONObject format
     */
    public static JSONObject get(String url) {
        JSONObject jresponse = null;
        try {
            URI uri = new URI(url);
            String responseBody = get(uri);
            jresponse = new JSONObject(responseBody);
            return jresponse;
        } catch (URISyntaxException e) {
            logger.error(e.getMessage());
        } catch (JSONException e) {
            logger.error(e.getMessage());
        }
        return jresponse;
    }

    /**
     * Makes a POST request to the URI specified and returns the response body
     * as String
     * ----------------------------------------------------------------------
     * @param uri       The URI which has to be requested
     * @param postData  NameValuePair of post data
     * @return  Response body in String format
     */
    public static String post(URI uri, List<NameValuePair> postData) {
        HttpClient httpclient = new DefaultHttpClient();
        HttpPost httppost;
        HttpEntity entity;
        String responseBody = null;

        try {

            httppost = new HttpPost(uri);
            logger.info("POST REQUEST = [" + httppost.getURI() + "]");

            // Add POST Parameters
            httppost.setEntity(new UrlEncodedFormEntity(postData));

            logger.info("Fetching Response");
            HttpResponse response = httpclient.execute(httppost);

            // Create a response handler
            entity = response.getEntity();
            responseBody = EntityUtils.toString(entity);

        } catch (ClientProtocolException e) {
            logger.error("Error in HTTP protocol: " + e.getMessage());
        } catch (IOException e) {
            logger.error("Fatal transport error: " + e.getMessage());
        } catch (Exception e) {
            logger.error("Network Exception: " + e.getMessage());
        } finally {
            httpclient.getConnectionManager().shutdown();
        }
        return responseBody;
    }

    /**
     * Makes a POST request to the URL specified and returns the response body
     * as String
     * ----------------------------------------------------------------------
     * @param url       The URL which has to be requested
     * @param postData  String of post data
     * @return  Response body in JSONObject format
     */
    public static JSONObject post(String url, String postData) {
        JSONObject jresponse = null;
        URI uri;
        String[] postValueArray;
        List<NameValuePair> nameValuePairs;
        String[] nameValue;
        String responseBody;
        
        
        try {
            uri = new URI(url);
            postValueArray = postData.split("&");
            nameValuePairs = new ArrayList<NameValuePair>(1);
           
            for (String val : postValueArray) {
                nameValue = val.split("=");
                nameValuePairs.add(new BasicNameValuePair(nameValue[0], URLDecoder.decode(nameValue[1], "UTF-8")));
            }

            responseBody = post(uri, nameValuePairs);
            jresponse = new JSONObject(responseBody);
            return jresponse;
        } catch (URISyntaxException e) {
            logger.error(e.getMessage());
        } catch (JSONException e) {
            logger.error(e.getMessage());
        } catch (UnsupportedEncodingException e) {
            logger.error(e.getMessage());
        }
        return jresponse;
    }
}
