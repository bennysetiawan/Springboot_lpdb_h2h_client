package com.lpdb.h2h.agent.config;

import com.lpdb.h2h.agent.jobs.SendToH2hJob;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SendToH2hCron {
   
   @Value("${save-timer}")
   private final String SAVE_TIMER;

   //jika dihilangkan akan menyebabkan error
   public SendToH2hCron() {
      this.SAVE_TIMER = "";
   }
   
   //Create Save Job
   @Bean
   public JobDetail sendToH2hJob() {
      return JobBuilder.newJob(SendToH2hJob.class)
         .withIdentity("sendToH2hJob", "groupSendToH2h")
         .storeDurably().build();
   }

   @Bean
   public Trigger saveJobTrigger(JobDetail sendToH2hJob) {
      return TriggerBuilder.newTrigger().forJob(sendToH2hJob)
         .withIdentity("SendToH2hJobTrigger", "groupSendToH2h")
         .withSchedule(CronScheduleBuilder.cronSchedule(SAVE_TIMER))
         .build();
   }

}
