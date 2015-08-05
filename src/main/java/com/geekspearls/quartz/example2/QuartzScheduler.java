/**
 * COPYRIGHT (C) 2015 Andrew Liu. All Rights Reserved.
 * <p>
 * SpringDemo com.geekspearls.quartz.example2.QuartzScheduler
 *
 * @author Andrew Liu
 * @since 2015 24/07/2015 9:21 PM
 */
package com.geekspearls.quartz.example2;

import com.geekspearls.quartz.task.GenerateReportTask;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;

import java.util.HashMap;
import java.util.Map;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * @author Andrew
 */
public class QuartzScheduler {

    private Scheduler scheduler;
    private Department[] departments = {Department.ENGINEER, Department.MARKETING, Department.SALES};
    private Map<Department, String> schedules = new HashMap<Department, String>();

    public void init() {
        schedules.put(Department.ENGINEER, "10 * * * * ?");
        schedules.put(Department.MARKETING, "30 * * * * ?");
        schedules.put(Department.SALES, "50 * * * * ?");

        for (Department department : departments) {
            schedule(department);
        }
    }

    private void schedule(Department department) {
        JobDetail job = newJob(GenerateReportTask.class)
                .withIdentity(department.toString(), "reportgen")
                .build();
        job.getJobDataMap().put(GenerateReportTask.DEPARTMENT, department.toString());
        Trigger trigger = newTrigger()
                .withIdentity(department.toString(), "reportgen")
                .withSchedule(cronSchedule(schedules.get(department)))
                .forJob(job).build();
        try {
            scheduler.scheduleJob(job, trigger);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    public Scheduler getScheduler() {
        return scheduler;
    }

    public void setScheduler(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    private enum Department {
        SALES, MARKETING, ENGINEER
    }
}
