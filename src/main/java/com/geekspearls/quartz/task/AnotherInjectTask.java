/**
 * COPYRIGHT (C) 2015 Andrew Liu. All Rights Reserved.
 * <p>
 * SpringDemo com.geekspearls.quartz.task.AnotherInjectTask
 *
 * @author Andrew Liu
 * @since 2015 15/08/2015 4:01 PM
 */
package com.geekspearls.quartz.task;

import com.geekspearls.quartz.example3.InjectObject;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;

/**
 * @author Andrew
 */
public class AnotherInjectTask extends QuartzJobBean {

    @Autowired
    private InjectObject injectObject;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("[" + new Date() + "] I am saying another hello from a Quartz job, " +
                injectObject);
    }

    public void setInjectObject(InjectObject injectObject) {
        this.injectObject = injectObject;
    }
}
