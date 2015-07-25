/**
 * COPYRIGHT (C) 2015 Andrew Liu. All Rights Reserved.
 * <p>
 * SpringDemo com.geekspearls.quartz.task.HelloWorldTask
 *
 * @author Andrew Liu
 * @since 2015 25/07/2015 2:40 PM
 */
package com.geekspearls.quartz.task;

import java.util.Date;

/**
 * @author Andrew
 */
public class HelloWorldTask {

    public void sayHello() {
        System.out.println(new Date() + " Hello from Quartz! World");
    }
}
