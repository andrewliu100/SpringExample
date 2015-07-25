/**
 * COPYRIGHT (C) 2015 Andrew Liu. All Rights Reserved.
 * <p>
 * SpringDemo com.geekspearls.quartz.task.SayHelloTask
 *
 * @author Andrew Liu
 * @since 2015 24/07/2015 9:21 PM
 */
package com.geekspearls.quartz.task;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;

/**
 * @author Andrew
 */
public class SayHelloTask extends QuartzJobBean {

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        String name = jobExecutionContext.getMergedJobDataMap().getString("name");
        System.out.println("[" + new Date() + "] Hello from Quartz! " + name);
    }
}
