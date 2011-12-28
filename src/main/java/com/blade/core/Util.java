/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blade.core;

/**
 *
 * @author avarakukalayil
 */
public class Util {
    
    
    public boolean empty(String str) {
        if((str == null)||(str.trim().length() == 0)) {
            return true;
        }
        return false;
    }
    
}
