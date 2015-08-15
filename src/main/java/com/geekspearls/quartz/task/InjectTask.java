/**
 * COPYRIGHT (C) 2015 Andrew Liu. All Rights Reserved.
 * <p>
 * SpringDemo com.geekspearls.quartz.task.InjectTask
 *
 * @author Andrew Liu
 * @since 2015 15/08/2015 3:56 PM
 */
package com.geekspearls.quartz.task;

import com.geekspearls.quartz.example3.InjectObject;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.SchedulerException;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;

/**
 * @author Andrew
 */
public class InjectTask extends QuartzJobBean {

    private static final String APPLICATION_CONTEXT = "applicationContext";

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        try {
            ApplicationContext context =
                    (ApplicationContext) jobExecutionContext.getScheduler().getContext().get(APPLICATION_CONTEXT);
            if (context != null) {
                InjectObject obj = (InjectObject) context.getBean("geeksPearls");
                if (obj != null) {
                    System.out.println("[" + new Date() + "] I am saying hello from a Quartz job, " + obj);
                }
            }
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}
