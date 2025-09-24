package com.hank.fineReport.report.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@EnableScheduling
public class MailJobScheduler {

    @Autowired
    private  MailService mailService;

    @Autowired
    private MailTestService testService;



    //安老
    @Scheduled(cron = "0 0 8 ? * MON-FRI", zone = "Asia/Taipei")
    public void scheduleAL() {
        try {
            mailService.sendfilledTotalMailAL();
            mailService.sendNoCheckTotalMailAL();
        } catch (Exception e) {
            log.info("發送email 失敗" + e.getMessage());
        }
    }

    //廣寧
    @Scheduled(cron = "0 0 8 ? * MON-FRI", zone = "Asia/Taipei")
    public void scheduleGN() {
        try {
            mailService.sendfilledTotalMailGN();
            mailService.sendNoCheckTotalMailGN();
        } catch (Exception e) {
            log.info("發送email 失敗" + e.getMessage());
        }
    }

    //太平
    @Scheduled(cron = "0 0 8 ? * MON-FRI", zone = "Asia/Taipei")
    public void scheduleTP() {
        try {
            mailService.sendfilledTotalMailTP();
            mailService.sendNoCheckTotalMailTP();
        } catch (Exception e) {
            log.info("發送email 失敗" + e.getMessage());
        }
    }


//    @Scheduled(cron = "*/10 * * * * *")
//    public void scheduletest() {
//        try {
//            testService.sendNoCheckTotalMailAL();
//        } catch (Exception e) {
//            // 記 log；避免丟出讓排程噴錯
//        }
//    }
}
