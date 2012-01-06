/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blade.listeners;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;
import org.testng.annotations.Test;

/**
 *
 * @author avarakukalayil
 */
public class MethodInterceptor implements IMethodInterceptor {

    public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
        System.out.println(methods.size());
        System.out.println(methods.get(0));
        System.out.println(methods.get(1));
        System.out.println(methods.get(2));
        System.out.println(methods.get(3));
        List<IMethodInstance> result = new ArrayList<IMethodInstance>();
//        for (IMethodInstance m : methods) {
//            Test test = m.getMethod().getMethod().getAnnotation(Test.class);
//            Set<String> groups = new HashSet<String>();
//            for (String group : test.groups()) {
//                groups.add(group);
//            }
//            if (groups.contains("fast")) {
//                result.add(0, m);
//            } else {
//                result.add(m);
//            }
//        }
//        System.out.println(result.size());
//        
//        return result;
        System.out.println(context.getAllTestMethods().toString());
        methods.remove(0);
        return methods;
    }
}
