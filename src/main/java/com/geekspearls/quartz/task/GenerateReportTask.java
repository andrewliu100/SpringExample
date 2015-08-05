/**
 * COPYRIGHT (C) 2015 Andrew Liu. All Rights Reserved.
 * <p>
 * SpringDemo com.geekspearls.quartz.task.GenerateReportTask
 *
 * @author Andrew Liu
 * @since 2015 5/08/2015 9:17 PM
 */
package com.geekspearls.quartz.task;

import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;

/**
 * @author Andrew
 */
public class GenerateReportTask extends QuartzJobBean {

    public static final String DEPARTMENT = "DEPARTMENT";

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        JobDataMap dataMap = jobExecutionContext.getMergedJobDataMap();
        String department = dataMap.getString(DEPARTMENT);
        System.out.println("[" + new Date() + "] Generating report for department " + department);
    }
}
