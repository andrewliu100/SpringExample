/**
 * COPYRIGHT (C) 2015 Andrew Liu. All Rights Reserved.
 * <p>
 * SpringDemo com.geekspearls.helloworld.HelloWorld
 *
 * @author Andrew Liu
 * @since 2015 24/07/2015 9:14 PM
 */
package com.geekspearls.helloworld;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * @author Andrew
 */
public class HelloWorld {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-helloworld.xml");
        HelloWorldBean bean = (HelloWorldBean) context.getBean("helloWorldBean");
        System.out.println("Application started [" + new Date() + "] " + bean.sayHello());
    }
}
