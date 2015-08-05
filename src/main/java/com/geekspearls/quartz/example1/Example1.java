/**
 * COPYRIGHT (C) 2015 Andrew Liu. All Rights Reserved.
 * <p>
 * SpringDemo com.geekspearls.quartz.example1.Example1
 *
 * @author Andrew Liu
 * @since 2015 5/08/2015 7:57 PM
 */
package com.geekspearls.quartz.example1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * Quartz + Spring example 1: Spring context XML configuration
 *
 * @author Andrew
 */
public class Example1 {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-quartz.xml");
        System.out.println("Application started [" + new Date() + "] ");
    }
}
