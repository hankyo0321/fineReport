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

//    @GetMapping("/mail")
//    public BaseResult<Void> sendMail() {
//        try{
//            mailService.sendWarningEmail();
//            return BaseResult.success(null,"發信成功");
//        }catch(MessagingException e){
//            return BaseResult.failure(HttpStatus.INTERNAL_SERVER_ERROR,"發信失敗",e.getMessage());
//
//        }
//
//    }

    /**
     * 未滿單明細
     * 订单距离客人交期7天未满单
     * @return
     */
//    @GetMapping("/sendSevenfilledDetailMail")
//    public BaseResult<Void> sendSevenfilledDetailMail() {
//        try{
//            mailService.sendSevenfilledDetailMail();
//            return BaseResult.success(null,"發信成功");
//        }catch(MessagingException e){
//            return BaseResult.failure(HttpStatus.INTERNAL_SERVER_ERROR,"發信失敗",e.getMessage());
//
//        }
//
//    }

    /**
     * 未滿單明細
     * 订单已过客人交期未满单
     * @return
     */
//    @GetMapping("/sendExpiredMail")
//    public BaseResult<Void> sendExpiredMail() {
//        try{
//            mailService.sendExpiredMail();
//            return BaseResult.success(null,"發信成功");
//        }catch(MessagingException e){
//            return BaseResult.failure(HttpStatus.INTERNAL_SERVER_ERROR,"發信失敗",e.getMessage());
//
//        }
//
//    }

    /**
     * 未滿單未開補明細
     * 訂單距離客人交期10天未滿單未開補
     * @return
     */
//    @GetMapping("/sendNotOpenMail")
//    public BaseResult<Void>  sendNotOpenMail(){
//        try{
//            mailService.sendNotOpenMail();
//            return BaseResult.success(null,"發信成功");
//        }catch(MessagingException e){
//            return BaseResult.failure(HttpStatus.INTERNAL_SERVER_ERROR,"發信失敗",e.getMessage());
//
//        }
//    }


    /**
     * 未驗貨明細
     * 订单距离客人交期7天未验货
     * @return
     */
//    @GetMapping("/sendSevenNotInspectedDetailMail")
//    public BaseResult<Void> sendSevenNotInspectedDetailMail(){
//        try{
//            mailService.sendSevenNotInspectedDetailMail();
//            return BaseResult.success(null,"發信成功");
//        }catch(MessagingException e){
//            return BaseResult.failure(HttpStatus.INTERNAL_SERVER_ERROR,"發信失敗",e.getMessage());
//
//        }
//    }



    /**
     * 未驗貨明細
     * 订单已过客人交期未验货
     * @return
     */
//    @GetMapping("/sendExpiredNotInspectedDetailMail")
//    public BaseResult<Void> sendExpiredNotInspectedDetailMail(){
//        try{
//            mailService.sendExpiredNotInspectedDetailMail();
//            return BaseResult.success(null,"發信成功");
//        }catch(MessagingException e){
//            return BaseResult.failure(HttpStatus.INTERNAL_SERVER_ERROR,"發信失敗",e.getMessage());
//
//        }
//    }





    /**
     * 【預警-未滿單&成型未開補】安老廠
     * @return
     */
    @GetMapping("/sendfilledTotalMailAL")
    @Scheduled(cron = "0 0 7 ? * MON-FRI", zone = "Asia/Taipei")
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


    /**
     * 未開補總表-分廠分品牌-2
     * 訂單距離客人交期10天未滿單未開補
     * @return
     */
//    @GetMapping("/sendNotOpenForReplenishmentMail")
//    public BaseResult<Void> sendNotOpenForReplenishmentMail(){
//        try{
//            mailService.sendNotOpenForReplenishmentMail();
//            return BaseResult.success(null,"發信成功");
//        }catch(MessagingException e){
//            return BaseResult.failure(HttpStatus.INTERNAL_SERVER_ERROR,"發信失敗",e.getMessage());
//
//        }
//    }

    /**
     * 未驗貨總表
     * @return
     */
//    @GetMapping("/sendNotCheckMail")
//    public BaseResult<Void> sendNotCheckMail(){
//        try{
//            mailService.sendNotCheckMail();
//            return BaseResult.success(null,"發信成功");
//        }catch(MessagingException e){
//            return BaseResult.failure(HttpStatus.INTERNAL_SERVER_ERROR,"發信失敗",e.getMessage());
//
//        }
//    }

}
