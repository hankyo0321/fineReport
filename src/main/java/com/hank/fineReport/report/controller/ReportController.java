package com.hank.fineReport.report.controller;


import com.hank.fineReport.report.common.BaseResult;
import com.hank.fineReport.report.service.MailService;
import jakarta.mail.MessagingException;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ReportController {

    @Autowired
    private MailService mailService;


    /**
     * 【預警-未滿單&成型未開補】安老廠
     * @return
     */
    @GetMapping("/sendfilledTotalMailAL")
    public BaseResult<Void> sendfilledTotalMailAL(){
        try{
            mailService.sendfilledTotalMailAL();
            return BaseResult.success(null,"發信成功");
        }catch(MessagingException e){
            return BaseResult.failure(HttpStatus.INTERNAL_SERVER_ERROR,"發信失敗",e.getMessage());

        }
    }


    /**
     * 【預警-未滿單&成型未開補】廣寧廠
     * @return
     */
    @GetMapping("/sendfilledTotalMailGN")
    public BaseResult<Void> sendfilledTotalMailGN(){
        try{
            mailService.sendfilledTotalMailGN();
            return BaseResult.success(null,"發信成功");
        }catch(MessagingException e){
            return BaseResult.failure(HttpStatus.INTERNAL_SERVER_ERROR,"發信失敗",e.getMessage());

        }
    }


    /**
     * 【預警-未滿單&成型未開補】太平廠
     * @return
     */
    @GetMapping("/sendfilledTotalMailTP")
    public BaseResult<Void> sendfilledTotalMailTP(){
        try{
            mailService.sendfilledTotalMailTP();
            return BaseResult.success(null,"發信成功");
        }catch(MessagingException e){
            return BaseResult.failure(HttpStatus.INTERNAL_SERVER_ERROR,"發信失敗",e.getMessage());

        }
    }




    /**
     * 【預警-未驗貨】安老廠
     * @return
     */
    @GetMapping("/sendNoCheckTotalMailAL")
    public BaseResult<Void> sendNoCheckTotalMailAL(){
        try{
            mailService.sendNoCheckTotalMailAL();
            return BaseResult.success(null,"發信成功");
        }catch(MessagingException e){
            return BaseResult.failure(HttpStatus.INTERNAL_SERVER_ERROR,"發信失敗",e.getMessage());

        }
    }



    /**
     * 【預警-未驗貨】廣寧廠
     * @return
     */
    @GetMapping("/sendNoCheckTotalMailGN")
    public BaseResult<Void> sendNoCheckTotalMailGN(){
        try{
            mailService.sendNoCheckTotalMailGN();
            return BaseResult.success(null,"發信成功");
        }catch(MessagingException e){
            return BaseResult.failure(HttpStatus.INTERNAL_SERVER_ERROR,"發信失敗",e.getMessage());

        }
    }



    /**
     * 【預警-未驗貨】太平廠
     * @return
     */
    @GetMapping("/sendNoCheckTotalMailTP")
    public BaseResult<Void> sendNoCheckTotalMailTP(){
        try{
            mailService.sendNoCheckTotalMailTP();
            return BaseResult.success(null,"發信成功");
        }catch(MessagingException e){
            return BaseResult.failure(HttpStatus.INTERNAL_SERVER_ERROR,"發信失敗",e.getMessage());

        }
    }




}
