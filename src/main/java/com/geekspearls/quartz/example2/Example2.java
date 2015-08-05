/**
 * COPYRIGHT (C) 2015 Andrew Liu. All Rights Reserved.
 * <p>
 * SpringDemo com.geekspearls.quartz.example2.Example2
 *
 * @author Andrew Liu
 * @since 2015 5/08/2015 9:05 PM
 */
package com.geekspearls.quartz.example2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * @author Andrew
 */
public class Example2 {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-quartz2.xml");
        System.out.println("Application started [" + new Date() + "] ");
    }
}
