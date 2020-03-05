/*
package com.peilw.child.config;

import com.peilw.child.components.MySecondJob;
import org.quartz.CronTrigger;
import org.quartz.JobDataMap;
import org.quartz.SimpleTrigger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.*;

@Configuration
public class QuartzConfig {
    @Bean
    MethodInvokingJobDetailFactoryBean methodInvokingJobDetailFactoryBean(){
        MethodInvokingJobDetailFactoryBean methodInvokingJobDetailFactoryBean=new MethodInvokingJobDetailFactoryBean();
        methodInvokingJobDetailFactoryBean.setTargetBeanName("myFirstJob");
        methodInvokingJobDetailFactoryBean.setStaticMethod("sayHello");
        return methodInvokingJobDetailFactoryBean;
    }
    @Bean
    JobDetailFactoryBean jobDetailFactoryBean(){
        JobDetailFactoryBean jobDetailFactoryBean=new JobDetailFactoryBean();
        jobDetailFactoryBean.setJobClass(MySecondJob.class);
        JobDataMap jobDataMap=new JobDataMap();
        jobDataMap.put("name","sang");
        jobDetailFactoryBean.setJobDataMap(jobDataMap);
        jobDetailFactoryBean.setDurability(true);
        return  jobDetailFactoryBean;
    }
    @Bean
    SimpleTriggerFactoryBean simpleTriggerFactoryBean(){
        SimpleTriggerFactoryBean simpleTriggerFactoryBean=new SimpleTriggerFactoryBean();
        simpleTriggerFactoryBean.setJobDetail(methodInvokingJobDetailFactoryBean().getObject());
        simpleTriggerFactoryBean.setRepeatCount(3);
        simpleTriggerFactoryBean.setStartDelay(2000);
        simpleTriggerFactoryBean.setRepeatInterval(2000);
        return simpleTriggerFactoryBean;
    }
    @Bean
    CronTriggerFactoryBean cronTriggerFactoryBean(){
        CronTriggerFactoryBean cronTriggerFactoryBean=new CronTriggerFactoryBean();
        cronTriggerFactoryBean.setJobDetail(jobDetailFactoryBean().getObject());
        cronTriggerFactoryBean.setCronExpression("* * * * * ?");
        return  cronTriggerFactoryBean;
    }
    @Bean
    SchedulerFactoryBean schedulerFactoryBean(){
        SchedulerFactoryBean schedulerFactoryBean=new SchedulerFactoryBean();
        SimpleTrigger simpleTrigger=simpleTriggerFactoryBean().getObject();
        CronTrigger cronTrigger=cronTriggerFactoryBean().getObject();
        schedulerFactoryBean.setTriggers(simpleTrigger,cronTrigger);
        return  schedulerFactoryBean;
    }
}
*/
