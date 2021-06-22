package com.lpdb.h2h.agent.config;

import com.lpdb.h2h.agent.jobs.SavePdcJob;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SavePdcCron {
   
   @Value("${save-timer}")
   private final String SAVE_TIMER;

   //jika dihilangkan akan menyebabkan error
   public SavePdcCron() {
      this.SAVE_TIMER = "";
   }
   
   //Create Save Job
   @Bean
   public JobDetail savePdcJob() {
      return JobBuilder.newJob(SavePdcJob.class)
         .withIdentity("SavePdcJob", "groupSavePdcJob")
         .storeDurably().build();
   }

   @Bean
   public Trigger savePdcJobTrigger(JobDetail savePdcJob) {
      return TriggerBuilder.newTrigger().forJob(savePdcJob)
         .withIdentity("SavePdcJobTrigger", "groupSavePdcJob")
         .withSchedule(CronScheduleBuilder.cronSchedule(SAVE_TIMER))
         .build();
   }

}
