/**
 * COPYRIGHT (C) 2015 Andrew Liu. All Rights Reserved.
 * <p>
 * SpringDemo com.geekspearls.quartz.example3.Example3
 *
 * @author Andrew Liu
 * @since 2015 15/08/2015 3:55 PM
 */
package com.geekspearls.quartz.example3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * @author Andrew
 */
public class Example3 {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-quartz3.xml");
        System.out.println("Application started [" + new Date() + "] ");
    }
}
