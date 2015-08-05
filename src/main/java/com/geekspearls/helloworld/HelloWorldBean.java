/**
 * COPYRIGHT (C) 2015 Andrew Liu. All Rights Reserved.
 * <p>
 * SpringDemo HelloWorldBean
 *
 * @author Andrew Liu
 * @since 2015 24/07/2015 8:59 PM
 */
package com.geekspearls.helloworld;

/**
 * @author Andrew
 */
public class HelloWorldBean {

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String sayHello() {
        return "Hello! " + name;
    }
}
