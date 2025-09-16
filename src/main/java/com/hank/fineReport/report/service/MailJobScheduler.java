package com.hank.fineReport.report.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class MailJobScheduler {

    @Autowired
    private  MailService mailService;

    @Autowired
    private MailTestService testService;




    @Scheduled(cron = "0 0 7 ? * MON-FRI", zone = "Asia/Taipei")
    public void schedule() {
        try {
            testService.sendNoCheckTotalMailAL();
        } catch (Exception e) {
            // 記 log；避免丟出讓排程噴錯
        }
    }


    @Scheduled(cron = "0/1 * * * * *")
    public void scheduletest() {
        try {
            testService.sendNoCheckTotalMailAL();
        } catch (Exception e) {
            // 記 log；避免丟出讓排程噴錯
        }
    }
}
