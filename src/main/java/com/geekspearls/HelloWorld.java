/**
 * COPYRIGHT (C) 2015 Andrew Liu. All Rights Reserved.
 * <p>
 * SpringDemo com.geekspearls.HelloWorld
 *
 * @author Andrew Liu
 * @since 2015 24/07/2015 9:14 PM
 */
package com.geekspearls;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * @author Andrew
 */
public class HelloWorld {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        HelloWorldBean bean = (HelloWorldBean) context.getBean("helloWorldBean");
        System.out.println("Application started [" + new Date() + "] " + bean.sayHello());
    }
}
