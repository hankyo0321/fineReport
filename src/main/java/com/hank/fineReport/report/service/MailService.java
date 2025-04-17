package com.hank.fineReport.report.service;

import com.hank.fineReport.report.common.BaseResult;
import com.hank.fineReport.report.model.*;
import com.hank.fineReport.report.repository.*;
import com.hank.fineReport.report.repository.mapper.FinanceaMapper;
import jakarta.annotation.Resource;
import jakarta.mail.MessagingException;
import org.apache.catalina.util.StringUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import jakarta.mail.internet.MimeMessage;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.logging.SimpleFormatter;

@Service
public class MailService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private financeaRepository finceRepository;

    @Autowired
    private FinanceaMapper financeaMapper;

    @Autowired
    private OutViewRepository outViewRepository;

    @Autowired
    private OutViewZong1Repository outViewZong1Repository;

    @Autowired
    private OutViewZong2Repository outViewZong2Repository;

    @Autowired
    private OutViewZong3Repository outViewZong3Repository;

    @Autowired
    private OutViewZong4Repository outViewZong4Repository;

    @Autowired
    private OutViewZong5Repository outViewZong5Repository;

    private final String[] titlesDetailFilledary = {"序號","上線月份","上線日期","品牌名稱","型體編號","庫存代號","中文顏色","目的地","客戶訂單"
            ,"工作單號2","工廠出貨日","訂單數量","距離客人交期天數","產線名稱","首次入庫日期","成倉欠數","CUT TO BOX","訂單文件號"};


//    public void sendWarningEmail() throws MessagingException {
//        LocalDateTime startOfDay = LocalDate.now().atStartOfDay();
//        List<Financea> financeas = finceRepository.findByProIdSevenDays(startOfDay);
//
//        //訂單已過客人交期未滿單
//        List<Financea> financeaList = finceRepository.findByProIdPast(startOfDay);
//
//        /**
//         * Table 1
//         */
//        StringBuilder htmlContent = new StringBuilder();
//        htmlContent.append("<h2>未滿單預警數據匯總報表--生管</h2>");
//        htmlContent.append("<table border='1' cellpadding='5' cellspacing='0' style='border-collapse: collapse;'>");
//        htmlContent.append("<tr style='background-color:#007bff;color:white;'>");
//        htmlContent.append("<th>預警名稱</th><th>預警週期</th><th>責任單位</th>");
//        for (Financea financea : financeas) {
//            htmlContent.append("<th>").append(financea.getFactory()).append("</th>");
//        }
//        htmlContent.append("</tr>");
//
//
//            //訂單距離客人交期7 天未滿單
//            htmlContent.append("<tr>");
//            htmlContent.append("<td rowspan='2'>").append("訂單距離客人交期7天未滿單").append("</td>");
//            htmlContent.append("<td rowspan='2'>").append("周一至周六").append("</td>");
//            htmlContent.append("<td rowspan='2'>").append("生管").append("</td>");
//            for (Financea financea : financeas) {
//                htmlContent.append("<td>").append("<b style='color:blue;'>").append(financea.getProNum()).append("</b>").append("</td>");
//            }
//            htmlContent.append("</tr>");
//
//            htmlContent.append("<tr>");
//                htmlContent.append("<td>").append("陶氏玉").append("</td>");
//                htmlContent.append("<td>").append("蒋够粮").append("</td>");
//                htmlContent.append("<td>").append("刘萍").append("</td>");
//            htmlContent.append("</tr>");
//
//            //訂單已過客人交期未滿單
//            htmlContent.append("<tr>");
//                htmlContent.append("<td rowspan='2'>").append("訂單已過客人交期未滿單").append("</td>");
//                htmlContent.append("<td rowspan='2'>").append("周一至周六").append("</td>");
//                htmlContent.append("<td rowspan='2'>").append("生管").append("</td>");
//                for (Financea financea : financeaList) {
//                    htmlContent.append("<td>").append("<b style='color:blue;'>").append(financea.getProNum()).append("</b>").append("</td>");
//                }
//            htmlContent.append("</tr>");
//
//            htmlContent.append("<tr>");
//                htmlContent.append("<td>").append("陶氏玉").append("</td>");
//                htmlContent.append("<td>").append("蒋够粮").append("</td>");
//                htmlContent.append("<td>").append("刘萍").append("</td>");
//            htmlContent.append("</tr>");
//
//        htmlContent.append("</table>");
//
//        htmlContent.append("<br>");
//        htmlContent.append("<br>");
//        /**
//         *  Table2
//         */
//        //成型未開補數據匯總報表--生管
//        htmlContent.append("<h2>成型未開補數據匯總報表--生管</h2>");
//        htmlContent.append("<table border='1' cellpadding='5' cellspacing='0' style='border-collapse: collapse;'>");
//            htmlContent.append("<tr style='background-color:#007bff;color:white;'>");
//            htmlContent.append("<th>預警名稱</th><th>預警週期</th><th>責任單位</th>");
//            for (Financea financea : financeas) {
//                htmlContent.append("<th>").append(financea.getFactory()).append("</th>");
//            }
//            htmlContent.append("</tr>");
//
//            //訂單距離客人交期10天未滿單成型未開補
//            htmlContent.append("<tr>");
//            htmlContent.append("<td rowspan='2'>").append("訂單距離客人交期10天未滿單成型未開補").append("</td>");
//            htmlContent.append("<td rowspan='2'>").append("周一至周六").append("</td>");
//            htmlContent.append("<td rowspan='2'>").append("生管").append("</td>");
//            for (Financea financea : financeas) {
//                htmlContent.append("<td>").append("<b style='color:blue;'>").append(financea.getProNum()).append("</b>").append("</td>");
//            }
//            htmlContent.append("</tr>");
//
//            htmlContent.append("<tr>");
//                htmlContent.append("<td>").append("陶氏玉").append("</td>");
//                htmlContent.append("<td>").append("蒋够粮").append("</td>");
//                htmlContent.append("<td>").append("刘萍").append("</td>");
//            htmlContent.append("</tr>");
//        htmlContent.append("</table>");
//
//        htmlContent.append("<br>");
//        htmlContent.append("<br>");
//
//
//        /**
//         * Table 3
//         * 未驗貨預警數據匯總報表--品管
//         */
//        htmlContent.append("<h2>未驗貨預警數據匯總報表--品管</h2>");
//        htmlContent.append("<table border='1' cellpadding='5' cellspacing='0' style='border-collapse: collapse;'>");
//        htmlContent.append("<tr style='background-color:#007bff;color:white;'>");
//        htmlContent.append("<th>預警名稱</th><th>預警週期</th><th>責任單位</th>");
//        for (Financea financea : financeas) {
//            htmlContent.append("<th>").append(financea.getFactory()).append("</th>");
//        }
//        htmlContent.append("</tr>");
//
//
//        //訂單距離客人交期7 天未滿單
//        htmlContent.append("<tr>");
//        htmlContent.append("<td rowspan='2'>").append("訂單距離客人交期7天未滿單").append("</td>");
//        htmlContent.append("<td rowspan='2'>").append("周一至周六").append("</td>");
//        htmlContent.append("<td rowspan='2'>").append("生管").append("</td>");
//        for (Financea financea : financeas) {
//            htmlContent.append("<td>").append("<b style='color:blue;'>").append(financea.getProNum()).append("</b>").append("</td>");
//        }
//        htmlContent.append("</tr>");
//
//        htmlContent.append("<tr>");
//            htmlContent.append("<td>").append("黃氏娥").append("</td>");
//            htmlContent.append("<td>").append("范氏雲").append("</td>");
//            htmlContent.append("<td>").append("阮氏寧").append("</td>");
//        htmlContent.append("</tr>");
//
//        //訂單已過客人交期未滿單
//        htmlContent.append("<tr>");
//        htmlContent.append("<td rowspan='2'>").append("訂單已過客人交期未滿單").append("</td>");
//        htmlContent.append("<td rowspan='2'>").append("周一至周六").append("</td>");
//        htmlContent.append("<td rowspan='2'>").append("生管").append("</td>");
//        for (Financea financea : financeaList) {
//            htmlContent.append("<td>").append("<b style='color:blue;'>").append(financea.getProNum()).append("</b>").append("</td>");
//        }
//        htmlContent.append("</tr>");
//
//        htmlContent.append("<tr>");
//            htmlContent.append("<td>").append("黃氏娥").append("</td>");
//            htmlContent.append("<td>").append("范氏雲").append("</td>");
//            htmlContent.append("<td>").append("阮氏寧").append("</td>");
//        htmlContent.append("</tr>");
//
//        htmlContent.append("</table>");
//
//
//        MimeMessage message = mailSender.createMimeMessage();
//        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
//
//        helper.setTo("hank.lin@stella.com.hk");
//        helper.setSubject("訂單預警通知");
//        helper.setText(htmlContent.toString(), true);
//
//        mailSender.send(message);
//    }


//    /**
//     * 订单距离客人交期7天未满单
//     * @throws MessagingException
//     */
//    public void sendSevenfilledDetailMail() throws MessagingException {
//        StringBuilder htmlContent = new StringBuilder();
//        htmlContent.append("<h2 style='color:red'>订单距离客人交期7天未满单</h2>");
//        htmlContent.append("<table border='1' cellpadding='5' cellspacing='0' style='border-collapse: collapse; width: 100%;'>");
//        htmlContent.append("<tr style='background-color:#60A1B2;color:white;'>");
//
//        List<OutView> outViews = outViewRepository.getOutView1();
//
//
//        for (String title : titlesDetailFilledary) {
//            htmlContent.append("<th style='min-width: 200px; padding: 10px;'>") // 增加最小寬度
//                    .append(title)
//                    .append("</th>");
//        }
//        htmlContent.append("</tr>");
//        int i =0;
//        if(CollectionUtils.isEmpty(outViews)){
//            throw new MessagingException("查無資料");
//        }else{
//            //有資料
//            for (OutView ov :outViews) {
//                i++;
//                htmlContent.append("<tr>");
//
//                //序號
//                htmlContent.append("<td style='min-width: 200px; padding: 10px; text-align: center;'>") // 增加內邊距
//                        .append("<b style='color:black;'>").append(String.valueOf(i)).append("</b>")
//                        .append("</td>");
//
//                //上線月份
//                htmlContent.append("<td style='min-width: 200px; padding: 10px; text-align: center;'>") // 增加內邊距
//                        .append("<b style='color:black;'>").append(ov.getOnlineMon()==null?"":ov.getOnlineMon()).append("</b>")
//                        .append("</td>");
//
//                //上線日期
//                htmlContent.append("<td style='min-width: 200px; padding: 10px; text-align: center;'>") // 增加內邊距
//                        .append("<b style='color:black;'>").append(ov.getOnlineDate()==null?"":ov.getOnlineDate()).append("</b>")
//                        .append("</td>");
//
//                //品牌名稱
//                htmlContent.append("<td style='min-width: 200px; padding: 10px; text-align: center;'>") // 增加內邊距
//                        .append("<b style='color:black;'>").append(ov.getBrandDesc()==null?"":ov.getBrandDesc()).append("</b>")
//                        .append("</td>");
//
//                //型體編號
//                htmlContent.append("<td style='min-width: 200px; padding: 10px; text-align: center;'>") // 增加內邊距
//                        .append("<b style='color:black;'>").append(ov.getModelNo()==null?"":ov.getModelNo()).append("</b>")
//                        .append("</td>");
//
//                //庫存代號
//                htmlContent.append("<td style='min-width: 200px; padding: 10px; text-align: center;'>") // 增加內邊距
//                        .append("<b style='color:black;'>").append(ov.getSkuNo()==null?"":ov.getSkuNo()).append("</b>")
//                        .append("</td>");
//
//                //中文顏色
//                htmlContent.append("<td style='min-width: 200px; padding: 10px; text-align: center;'>") // 增加內邊距
//                        .append("<b style='color:black;'>").append(ov.getCustEngColor()==null?"":ov.getCustEngColor()).append("</b>")
//                        .append("</td>");
//
//                //目的地
//                htmlContent.append("<td style='min-width: 200px; padding: 10px; text-align: center;'>") // 增加內邊距
//                        .append("<b style='color:black;'>").append(ov.getAddress()==null?"":ov.getAddress()).append("</b>")
//                        .append("</td>");
//
//                //客戶訂單
//                htmlContent.append("<td style='min-width: 200px; padding: 10px; text-align: center;'>") // 增加內邊距
//                        .append("<b style='color:black;'>").append(ov.getCustOrder()==null?"":ov.getCustOrder()).append("</b>")
//                        .append("</td>");
//
//                //工作單號2
//                htmlContent.append("<td style='min-width: 200px; padding: 10px; text-align: center;'>") // 增加內邊距
//                        .append("<b style='color:black;'>").append(ov.getOrderNo()==null?"":ov.getOrderNo()).append("</b>")
//                        .append("</td>");
//
//                //工廠出貨日
//                htmlContent.append("<td style='min-width: 200px; padding: 10px; text-align: center;'>") // 增加內邊距
//                        .append("<b style='color:black;'>").append(ov.getOutCdate()==null?"":ov.getOutCdate()).append("</b>")
//                        .append("</td>");
//
//                //訂單數量
//                htmlContent.append("<td style='min-width: 200px; padding: 10px; text-align: center;'>") // 增加內邊距
//                        .append("<b style='color:black;'>").append(ov.getOrdQty()==null?"":ov.getOrdQty()).append("</b>")
//                        .append("</td>");
//
//                //距離客人交期天數
//                htmlContent.append("<td style='min-width: 200px; padding: 10px; text-align: center;'>") // 增加內邊距
//                        .append("<b style='color:black;'>").append(ov.getDate1()==null?"":ov.getDate1()).append("</b>")
//                        .append("</td>");
//
//                //產線名稱
//                htmlContent.append("<td style='min-width: 200px; padding: 10px; text-align: center;'>") // 增加內邊距
//                        .append("<b style='color:black;'>").append(ov.getMadeLine()==null?"":ov.getMadeLine()).append("</b>")
//                        .append("</td>");
//
//                //首次入庫日期
//                htmlContent.append("<td style='min-width: 200px; padding: 10px; text-align: center;'>") // 增加內邊距
//                        .append("<b style='color:black;'>").append(ov.getInsDate()==null?"":ov.getInsDate()).append("</b>")
//                        .append("</td>");
//
//                //成倉欠數
//                htmlContent.append("<td style='min-width: 200px; padding: 10px; text-align: center;'>") // 增加內邊距
//                        .append("<b style='color:black;'>").append(ov.getNotinQty()==null?"":ov.getNotinQty()).append("</b>")
//                        .append("</td>");
//
//                //custToBox
//                htmlContent.append("<td style='min-width: 200px; padding: 10px; text-align: center;'>") // 增加內邊距
//                        .append("<b style='color:black;'>").append(ov.getCutToBox()==null?"":ov.getCutToBox()).append("</b>")
//                        .append("</td>");
//
//                //訂單文件號
//                htmlContent.append("<td style='min-width: 200px; padding: 10px; text-align: center;'>") // 增加內邊距
//                        .append("<b style='color:black;'>").append(ov.getOrderAuto()==null?"":ov.getOrderAuto()).append("</b>")
//                        .append("</td>");
//
//
//                htmlContent.append("</tr>");
//            }
//        }
//
//        htmlContent.append("</table>");
//
//
//
//        MimeMessage message = mailSender.createMimeMessage();
//        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
//
//        helper.setTo("hank.lin@stella.com.hk");
//        helper.setSubject("訂單預警通知");
//        helper.setText(htmlContent.toString(), true);
//
//        mailSender.send(message);
//    }

//    /**
//     * 订单已过客人交期未满单
//     * @throws MessagingException
//     */
//    public void sendExpiredMail() throws MessagingException {
//        StringBuilder htmlContent = new StringBuilder();
//        htmlContent.append("<h2 style='color:red'>订单已过客人交期未满单</h2>");
//        htmlContent.append("<table border='1' cellpadding='5' cellspacing='0' style='border-collapse: collapse; width: 100%;'>");
//        htmlContent.append("<tr style='background-color:#60A1B2;color:white;'>");
//
//        List<OutView2> outViews = outViewRepository.getOutView2();
//
//
//        for (String title : titlesDetailFilledary) {
//            htmlContent.append("<th style='min-width: 200px; padding: 10px;'>") // 增加最小寬度
//                    .append(title)
//                    .append("</th>");
//        }
//        htmlContent.append("</tr>");
//        int i =0;
//        if(CollectionUtils.isEmpty(outViews)){
//            throw new MessagingException("查無資料");
//        }else{
//            //有資料
//            for (OutView2 ov :outViews) {
//                i++;
//                htmlContent.append("<tr>");
//
//                //序號
//                htmlContent.append("<td style='min-width: 200px; padding: 10px; text-align: center;'>") // 增加內邊距
//                        .append("<b style='color:black;'>").append(String.valueOf(i)).append("</b>")
//                        .append("</td>");
//
//                //上線月份
//                htmlContent.append("<td style='min-width: 200px; padding: 10px; text-align: center;'>") // 增加內邊距
//                        .append("<b style='color:black;'>").append(ov.getOnlineMon()==null?"":ov.getOnlineMon()).append("</b>")
//                        .append("</td>");
//
//                //上線日期
//                htmlContent.append("<td style='min-width: 200px; padding: 10px; text-align: center;'>") // 增加內邊距
//                        .append("<b style='color:black;'>").append(ov.getOnlineDate()==null?"":ov.getOnlineDate()).append("</b>")
//                        .append("</td>");
//
//                //品牌名稱
//                htmlContent.append("<td style='min-width: 200px; padding: 10px; text-align: center;'>") // 增加內邊距
//                        .append("<b style='color:black;'>").append(ov.getBrandDesc()==null?"":ov.getBrandDesc()).append("</b>")
//                        .append("</td>");
//
//                //型體編號
//                htmlContent.append("<td style='min-width: 200px; padding: 10px; text-align: center;'>") // 增加內邊距
//                        .append("<b style='color:black;'>").append(ov.getModelNo()==null?"":ov.getModelNo()).append("</b>")
//                        .append("</td>");
//
//                //庫存代號
//                htmlContent.append("<td style='min-width: 200px; padding: 10px; text-align: center;'>") // 增加內邊距
//                        .append("<b style='color:black;'>").append(ov.getSkuNo()==null?"":ov.getSkuNo()).append("</b>")
//                        .append("</td>");
//
//                //中文顏色
//                htmlContent.append("<td style='min-width: 200px; padding: 10px; text-align: center;'>") // 增加內邊距
//                        .append("<b style='color:black;'>").append(ov.getCustEngColor()==null?"":ov.getCustEngColor()).append("</b>")
//                        .append("</td>");
//
//                //目的地
//                htmlContent.append("<td style='min-width: 200px; padding: 10px; text-align: center;'>") // 增加內邊距
//                        .append("<b style='color:black;'>").append(ov.getAddress()==null?"":ov.getAddress()).append("</b>")
//                        .append("</td>");
//
//                //客戶訂單
//                htmlContent.append("<td style='min-width: 200px; padding: 10px; text-align: center;'>") // 增加內邊距
//                        .append("<b style='color:black;'>").append(ov.getCustOrder()==null?"":ov.getCustOrder()).append("</b>")
//                        .append("</td>");
//
//                //工作單號2
//                htmlContent.append("<td style='min-width: 200px; padding: 10px; text-align: center;'>") // 增加內邊距
//                        .append("<b style='color:black;'>").append(ov.getOrderNo()==null?"":ov.getOrderNo()).append("</b>")
//                        .append("</td>");
//
//                //工廠出貨日
//                htmlContent.append("<td style='min-width: 200px; padding: 10px; text-align: center;'>") // 增加內邊距
//                        .append("<b style='color:black;'>").append(ov.getOutCdate()==null?"":ov.getOutCdate()).append("</b>")
//                        .append("</td>");
//
//                //訂單數量
//                htmlContent.append("<td style='min-width: 200px; padding: 10px; text-align: center;'>") // 增加內邊距
//                        .append("<b style='color:black;'>").append(ov.getOrdQty()==null?"":ov.getOrdQty()).append("</b>")
//                        .append("</td>");
//
//                //距離客人交期天數
//                htmlContent.append("<td style='min-width: 200px; padding: 10px; text-align: center;'>") // 增加內邊距
//                        .append("<b style='color:black;'>").append(ov.getDate1()==null?"":ov.getDate1()).append("</b>")
//                        .append("</td>");
//
//                //產線名稱
//                htmlContent.append("<td style='min-width: 200px; padding: 10px; text-align: center;'>") // 增加內邊距
//                        .append("<b style='color:black;'>").append(ov.getMadeLine()==null?"":ov.getMadeLine()).append("</b>")
//                        .append("</td>");
//
//                //首次入庫日期
//                htmlContent.append("<td style='min-width: 200px; padding: 10px; text-align: center;'>") // 增加內邊距
//                        .append("<b style='color:black;'>").append(ov.getInsDate()==null?"":ov.getInsDate()).append("</b>")
//                        .append("</td>");
//
//                //成倉欠數
//                htmlContent.append("<td style='min-width: 200px; padding: 10px; text-align: center;'>") // 增加內邊距
//                        .append("<b style='color:black;'>").append(ov.getNotinQty()==null?"":ov.getNotinQty()).append("</b>")
//                        .append("</td>");
//
//                //custToBox
//                htmlContent.append("<td style='min-width: 200px; padding: 10px; text-align: center;'>") // 增加內邊距
//                        .append("<b style='color:black;'>").append(ov.getCutToBox()==null?"":ov.getCutToBox()).append("</b>")
//                        .append("</td>");
//
//                //訂單文件號
//                htmlContent.append("<td style='min-width: 200px; padding: 10px; text-align: center;'>") // 增加內邊距
//                        .append("<b style='color:black;'>").append(ov.getOrderAuto()==null?"":ov.getOrderAuto()).append("</b>")
//                        .append("</td>");
//
//
//                htmlContent.append("</tr>");
//            }
//        }
//
//        htmlContent.append("</table>");
//
//
//
//        MimeMessage message = mailSender.createMimeMessage();
//        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
//
//        helper.setTo("hank.lin@stella.com.hk");
//        helper.setSubject("訂單預警通知");
//        helper.setText(htmlContent.toString(), true);
//
//        mailSender.send(message);
//    }
//
//    /**
//     * 訂單距離客人交期10天未滿單未開補
//     * @throws MessagingException
//     */
//    public void sendNotOpenMail() throws MessagingException  {
//        StringBuilder htmlContent = new StringBuilder();
//        htmlContent.append("<h2 style='color:red'>訂單距離客人交期10天未滿單未開補</h2>");
//        htmlContent.append("<table border='1' cellpadding='5' cellspacing='0' style='border-collapse: collapse; width: 100%;'>");
//        htmlContent.append("<tr style='background-color:#60A1B2;color:white;'>");
//
//        List<OutView> outViews = outViewRepository.getOutView1ByTpUser();
//
//
//        for (String title : titlesDetailFilledary) {
//            htmlContent.append("<th style='min-width: 200px; padding: 10px;'>") // 增加最小寬度
//                    .append(title)
//                    .append("</th>");
//        }
//        htmlContent.append("</tr>");
//        int i =0;
//        if(CollectionUtils.isEmpty(outViews)){
//            throw new MessagingException("查無資料");
//        }else{
//            //有資料
//            for (OutView ov :outViews) {
//                i++;
//                htmlContent.append("<tr>");
//
//                //序號
//                htmlContent.append("<td style='min-width: 200px; padding: 10px; text-align: center;'>") // 增加內邊距
//                        .append("<b style='color:black;'>").append(String.valueOf(i)).append("</b>")
//                        .append("</td>");
//
//                //上線月份
//                htmlContent.append("<td style='min-width: 200px; padding: 10px; text-align: center;'>") // 增加內邊距
//                        .append("<b style='color:black;'>").append(ov.getOnlineMon()==null?"":ov.getOnlineMon()).append("</b>")
//                        .append("</td>");
//
//                //上線日期
//                htmlContent.append("<td style='min-width: 200px; padding: 10px; text-align: center;'>") // 增加內邊距
//                        .append("<b style='color:black;'>").append(ov.getOnlineDate()==null?"":ov.getOnlineDate()).append("</b>")
//                        .append("</td>");
//
//                //品牌名稱
//                htmlContent.append("<td style='min-width: 200px; padding: 10px; text-align: center;'>") // 增加內邊距
//                        .append("<b style='color:black;'>").append(ov.getBrandDesc()==null?"":ov.getBrandDesc()).append("</b>")
//                        .append("</td>");
//
//                //型體編號
//                htmlContent.append("<td style='min-width: 200px; padding: 10px; text-align: center;'>") // 增加內邊距
//                        .append("<b style='color:black;'>").append(ov.getModelNo()==null?"":ov.getModelNo()).append("</b>")
//                        .append("</td>");
//
//                //庫存代號
//                htmlContent.append("<td style='min-width: 200px; padding: 10px; text-align: center;'>") // 增加內邊距
//                        .append("<b style='color:black;'>").append(ov.getSkuNo()==null?"":ov.getSkuNo()).append("</b>")
//                        .append("</td>");
//
//                //中文顏色
//                htmlContent.append("<td style='min-width: 200px; padding: 10px; text-align: center;'>") // 增加內邊距
//                        .append("<b style='color:black;'>").append(ov.getCustEngColor()==null?"":ov.getCustEngColor()).append("</b>")
//                        .append("</td>");
//
//                //目的地
//                htmlContent.append("<td style='min-width: 200px; padding: 10px; text-align: center;'>") // 增加內邊距
//                        .append("<b style='color:black;'>").append(ov.getAddress()==null?"":ov.getAddress()).append("</b>")
//                        .append("</td>");
//
//                //客戶訂單
//                htmlContent.append("<td style='min-width: 200px; padding: 10px; text-align: center;'>") // 增加內邊距
//                        .append("<b style='color:black;'>").append(ov.getCustOrder()==null?"":ov.getCustOrder()).append("</b>")
//                        .append("</td>");
//
//                //工作單號2
//                htmlContent.append("<td style='min-width: 200px; padding: 10px; text-align: center;'>") // 增加內邊距
//                        .append("<b style='color:black;'>").append(ov.getOrderNo()==null?"":ov.getOrderNo()).append("</b>")
//                        .append("</td>");
//
//                //工廠出貨日
//                htmlContent.append("<td style='min-width: 200px; padding: 10px; text-align: center;'>") // 增加內邊距
//                        .append("<b style='color:black;'>").append(ov.getOutCdate()==null?"":ov.getOutCdate()).append("</b>")
//                        .append("</td>");
//
//                //訂單數量
//                htmlContent.append("<td style='min-width: 200px; padding: 10px; text-align: center;'>") // 增加內邊距
//                        .append("<b style='color:black;'>").append(ov.getOrdQty()==null?"":ov.getOrdQty()).append("</b>")
//                        .append("</td>");
//
//                //距離客人交期天數
//                htmlContent.append("<td style='min-width: 200px; padding: 10px; text-align: center;'>") // 增加內邊距
//                        .append("<b style='color:black;'>").append(ov.getDate1()==null?"":ov.getDate1()).append("</b>")
//                        .append("</td>");
//
//                //產線名稱
//                htmlContent.append("<td style='min-width: 200px; padding: 10px; text-align: center;'>") // 增加內邊距
//                        .append("<b style='color:black;'>").append(ov.getMadeLine()==null?"":ov.getMadeLine()).append("</b>")
//                        .append("</td>");
//
//                //首次入庫日期
//                htmlContent.append("<td style='min-width: 200px; padding: 10px; text-align: center;'>") // 增加內邊距
//                        .append("<b style='color:black;'>").append(ov.getInsDate()==null?"":ov.getInsDate()).append("</b>")
//                        .append("</td>");
//
//                //成倉欠數
//                htmlContent.append("<td style='min-width: 200px; padding: 10px; text-align: center;'>") // 增加內邊距
//                        .append("<b style='color:black;'>").append(ov.getNotinQty()==null?"":ov.getNotinQty()).append("</b>")
//                        .append("</td>");
//
//                //custToBox
//                htmlContent.append("<td style='min-width: 200px; padding: 10px; text-align: center;'>") // 增加內邊距
//                        .append("<b style='color:black;'>").append(ov.getCutToBox()==null?"":ov.getCutToBox()).append("</b>")
//                        .append("</td>");
//
//                //訂單文件號
//                htmlContent.append("<td style='min-width: 200px; padding: 10px; text-align: center;'>") // 增加內邊距
//                        .append("<b style='color:black;'>").append(ov.getOrderAuto()==null?"":ov.getOrderAuto()).append("</b>")
//                        .append("</td>");
//
//
//                htmlContent.append("</tr>");
//            }
//        }
//
//        htmlContent.append("</table>");
//
//
//
//        MimeMessage message = mailSender.createMimeMessage();
//        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
//
//        helper.setTo("hank.lin@stella.com.hk");
//        helper.setSubject("訂單預警通知");
//        helper.setText(htmlContent.toString(), true);
//
//        mailSender.send(message);
//
//
//    }


//    /**
//     * 未驗貨明細
//     * 订单距离客人交期7天未验货
//     * @throws MessagingException
//     */
//    public void sendSevenNotInspectedDetailMail()  throws MessagingException  {
//        StringBuilder htmlContent = new StringBuilder();
//        htmlContent.append("<h2 style='color:red'>订单距离客人交期7天未验货</h2>");
//        htmlContent.append("<table border='1' cellpadding='5' cellspacing='0' style='border-collapse: collapse; width: 100%;'>");
//        htmlContent.append("<tr style='background-color:#60A1B2;color:white;'>");
//
//        List<OutView> outViews = outViewRepository.getOutView1ByTpUser();
//
//
//        for (String title : titlesDetailFilledary) {
//            htmlContent.append("<th style='min-width: 200px; padding: 10px;'>") // 增加最小寬度
//                    .append(title)
//                    .append("</th>");
//        }
//        htmlContent.append("</tr>");
//        int i =0;
//        if(CollectionUtils.isEmpty(outViews)){
//            throw new MessagingException("查無資料");
//        }else{
//            //有資料
//            for (OutView ov :outViews) {
//                i++;
//                htmlContent.append("<tr>");
//
//                //序號
//                htmlContent.append("<td style='min-width: 200px; padding: 10px; text-align: center;'>") // 增加內邊距
//                        .append("<b style='color:black;'>").append(String.valueOf(i)).append("</b>")
//                        .append("</td>");
//
//                //上線月份
//                htmlContent.append("<td style='min-width: 200px; padding: 10px; text-align: center;'>") // 增加內邊距
//                        .append("<b style='color:black;'>").append(ov.getOnlineMon()==null?"":ov.getOnlineMon()).append("</b>")
//                        .append("</td>");
//
//                //上線日期
//                htmlContent.append("<td style='min-width: 200px; padding: 10px; text-align: center;'>") // 增加內邊距
//                        .append("<b style='color:black;'>").append(ov.getOnlineDate()==null?"":ov.getOnlineDate()).append("</b>")
//                        .append("</td>");
//
//                //品牌名稱
//                htmlContent.append("<td style='min-width: 200px; padding: 10px; text-align: center;'>") // 增加內邊距
//                        .append("<b style='color:black;'>").append(ov.getBrandDesc()==null?"":ov.getBrandDesc()).append("</b>")
//                        .append("</td>");
//
//                //型體編號
//                htmlContent.append("<td style='min-width: 200px; padding: 10px; text-align: center;'>") // 增加內邊距
//                        .append("<b style='color:black;'>").append(ov.getModelNo()==null?"":ov.getModelNo()).append("</b>")
//                        .append("</td>");
//
//                //庫存代號
//                htmlContent.append("<td style='min-width: 200px; padding: 10px; text-align: center;'>") // 增加內邊距
//                        .append("<b style='color:black;'>").append(ov.getSkuNo()==null?"":ov.getSkuNo()).append("</b>")
//                        .append("</td>");
//
//                //中文顏色
//                htmlContent.append("<td style='min-width: 200px; padding: 10px; text-align: center;'>") // 增加內邊距
//                        .append("<b style='color:black;'>").append(ov.getCustEngColor()==null?"":ov.getCustEngColor()).append("</b>")
//                        .append("</td>");
//
//                //目的地
//                htmlContent.append("<td style='min-width: 200px; padding: 10px; text-align: center;'>") // 增加內邊距
//                        .append("<b style='color:black;'>").append(ov.getAddress()==null?"":ov.getAddress()).append("</b>")
//                        .append("</td>");
//
//                //客戶訂單
//                htmlContent.append("<td style='min-width: 200px; padding: 10px; text-align: center;'>") // 增加內邊距
//                        .append("<b style='color:black;'>").append(ov.getCustOrder()==null?"":ov.getCustOrder()).append("</b>")
//                        .append("</td>");
//
//                //工作單號2
//                htmlContent.append("<td style='min-width: 200px; padding: 10px; text-align: center;'>") // 增加內邊距
//                        .append("<b style='color:black;'>").append(ov.getOrderNo()==null?"":ov.getOrderNo()).append("</b>")
//                        .append("</td>");
//
//                //工廠出貨日
//                htmlContent.append("<td style='min-width: 200px; padding: 10px; text-align: center;'>") // 增加內邊距
//                        .append("<b style='color:black;'>").append(ov.getOutCdate()==null?"":ov.getOutCdate()).append("</b>")
//                        .append("</td>");
//
//                //訂單數量
//                htmlContent.append("<td style='min-width: 200px; padding: 10px; text-align: center;'>") // 增加內邊距
//                        .append("<b style='color:black;'>").append(ov.getOrdQty()==null?"":ov.getOrdQty()).append("</b>")
//                        .append("</td>");
//
//                //距離客人交期天數
//                htmlContent.append("<td style='min-width: 200px; padding: 10px; text-align: center;'>") // 增加內邊距
//                        .append("<b style='color:black;'>").append(ov.getDate1()==null?"":ov.getDate1()).append("</b>")
//                        .append("</td>");
//
//                //產線名稱
//                htmlContent.append("<td style='min-width: 200px; padding: 10px; text-align: center;'>") // 增加內邊距
//                        .append("<b style='color:black;'>").append(ov.getMadeLine()==null?"":ov.getMadeLine()).append("</b>")
//                        .append("</td>");
//
//                //首次入庫日期
//                htmlContent.append("<td style='min-width: 200px; padding: 10px; text-align: center;'>") // 增加內邊距
//                        .append("<b style='color:black;'>").append(ov.getInsDate()==null?"":ov.getInsDate()).append("</b>")
//                        .append("</td>");
//
//                //成倉欠數
//                htmlContent.append("<td style='min-width: 200px; padding: 10px; text-align: center;'>") // 增加內邊距
//                        .append("<b style='color:black;'>").append(ov.getNotinQty()==null?"":ov.getNotinQty()).append("</b>")
//                        .append("</td>");
//
//                //custToBox
//                htmlContent.append("<td style='min-width: 200px; padding: 10px; text-align: center;'>") // 增加內邊距
//                        .append("<b style='color:black;'>").append(ov.getCutToBox()==null?"":ov.getCutToBox()).append("</b>")
//                        .append("</td>");
//
//                //訂單文件號
//                htmlContent.append("<td style='min-width: 200px; padding: 10px; text-align: center;'>") // 增加內邊距
//                        .append("<b style='color:black;'>").append(ov.getOrderAuto()==null?"":ov.getOrderAuto()).append("</b>")
//                        .append("</td>");
//
//
//                htmlContent.append("</tr>");
//            }
//        }
//
//        htmlContent.append("</table>");
//
//
//
//        MimeMessage message = mailSender.createMimeMessage();
//        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
//
//        helper.setTo("hank.lin@stella.com.hk");
//        helper.setSubject("訂單預警通知");
//        helper.setText(htmlContent.toString(), true);
//
//        mailSender.send(message);
//
//
//
//    }



//    /**
//     * 未驗貨明細
//     * 订单已过客人交期未验货
//     * @throws MessagingException
//     */
//    public void sendExpiredNotInspectedDetailMail() throws MessagingException {
//        StringBuilder htmlContent = new StringBuilder();
//        htmlContent.append("<h2 style='color:red'>订单已过客人交期未验货</h2>");
//        htmlContent.append("<table border='1' cellpadding='5' cellspacing='0' style='border-collapse: collapse; width: 100%;'>");
//        htmlContent.append("<tr style='background-color:#60A1B2;color:white;'>");
//        //需調整查詢資料
//        List<OutView> outViews = outViewRepository.getOutView1ByTpUser();
//
//
//        for (String title : titlesDetailFilledary) {
//            htmlContent.append("<th style='min-width: 200px; padding: 10px;'>") // 增加最小寬度
//                    .append(title)
//                    .append("</th>");
//        }
//        htmlContent.append("</tr>");
//        int i =0;
//        if(CollectionUtils.isEmpty(outViews)){
//            throw new MessagingException("查無資料");
//        }else{
//            //有資料
//            for (OutView ov :outViews) {
//                i++;
//                htmlContent.append("<tr>");
//
//                //序號
//                htmlContent.append("<td style='min-width: 200px; padding: 10px; text-align: center;'>") // 增加內邊距
//                        .append("<b style='color:black;'>").append(String.valueOf(i)).append("</b>")
//                        .append("</td>");
//
//                //上線月份
//                htmlContent.append("<td style='min-width: 200px; padding: 10px; text-align: center;'>") // 增加內邊距
//                        .append("<b style='color:black;'>").append(ov.getOnlineMon()==null?"":ov.getOnlineMon()).append("</b>")
//                        .append("</td>");
//
//                //上線日期
//                htmlContent.append("<td style='min-width: 200px; padding: 10px; text-align: center;'>") // 增加內邊距
//                        .append("<b style='color:black;'>").append(ov.getOnlineDate()==null?"":ov.getOnlineDate()).append("</b>")
//                        .append("</td>");
//
//                //品牌名稱
//                htmlContent.append("<td style='min-width: 200px; padding: 10px; text-align: center;'>") // 增加內邊距
//                        .append("<b style='color:black;'>").append(ov.getBrandDesc()==null?"":ov.getBrandDesc()).append("</b>")
//                        .append("</td>");
//
//                //型體編號
//                htmlContent.append("<td style='min-width: 200px; padding: 10px; text-align: center;'>") // 增加內邊距
//                        .append("<b style='color:black;'>").append(ov.getModelNo()==null?"":ov.getModelNo()).append("</b>")
//                        .append("</td>");
//
//                //庫存代號
//                htmlContent.append("<td style='min-width: 200px; padding: 10px; text-align: center;'>") // 增加內邊距
//                        .append("<b style='color:black;'>").append(ov.getSkuNo()==null?"":ov.getSkuNo()).append("</b>")
//                        .append("</td>");
//
//                //中文顏色
//                htmlContent.append("<td style='min-width: 200px; padding: 10px; text-align: center;'>") // 增加內邊距
//                        .append("<b style='color:black;'>").append(ov.getCustEngColor()==null?"":ov.getCustEngColor()).append("</b>")
//                        .append("</td>");
//
//                //目的地
//                htmlContent.append("<td style='min-width: 200px; padding: 10px; text-align: center;'>") // 增加內邊距
//                        .append("<b style='color:black;'>").append(ov.getAddress()==null?"":ov.getAddress()).append("</b>")
//                        .append("</td>");
//
//                //客戶訂單
//                htmlContent.append("<td style='min-width: 200px; padding: 10px; text-align: center;'>") // 增加內邊距
//                        .append("<b style='color:black;'>").append(ov.getCustOrder()==null?"":ov.getCustOrder()).append("</b>")
//                        .append("</td>");
//
//                //工作單號2
//                htmlContent.append("<td style='min-width: 200px; padding: 10px; text-align: center;'>") // 增加內邊距
//                        .append("<b style='color:black;'>").append(ov.getOrderNo()==null?"":ov.getOrderNo()).append("</b>")
//                        .append("</td>");
//
//                //工廠出貨日
//                htmlContent.append("<td style='min-width: 200px; padding: 10px; text-align: center;'>") // 增加內邊距
//                        .append("<b style='color:black;'>").append(ov.getOutCdate()==null?"":ov.getOutCdate()).append("</b>")
//                        .append("</td>");
//
//                //訂單數量
//                htmlContent.append("<td style='min-width: 200px; padding: 10px; text-align: center;'>") // 增加內邊距
//                        .append("<b style='color:black;'>").append(ov.getOrdQty()==null?"":ov.getOrdQty()).append("</b>")
//                        .append("</td>");
//
//                //距離客人交期天數
//                htmlContent.append("<td style='min-width: 200px; padding: 10px; text-align: center;'>") // 增加內邊距
//                        .append("<b style='color:black;'>").append(ov.getDate1()==null?"":ov.getDate1()).append("</b>")
//                        .append("</td>");
//
//                //產線名稱
//                htmlContent.append("<td style='min-width: 200px; padding: 10px; text-align: center;'>") // 增加內邊距
//                        .append("<b style='color:black;'>").append(ov.getMadeLine()==null?"":ov.getMadeLine()).append("</b>")
//                        .append("</td>");
//
//                //首次入庫日期
//                htmlContent.append("<td style='min-width: 200px; padding: 10px; text-align: center;'>") // 增加內邊距
//                        .append("<b style='color:black;'>").append(ov.getInsDate()==null?"":ov.getInsDate()).append("</b>")
//                        .append("</td>");
//
//                //成倉欠數
//                htmlContent.append("<td style='min-width: 200px; padding: 10px; text-align: center;'>") // 增加內邊距
//                        .append("<b style='color:black;'>").append(ov.getNotinQty()==null?"":ov.getNotinQty()).append("</b>")
//                        .append("</td>");
//
//                //custToBox
//                htmlContent.append("<td style='min-width: 200px; padding: 10px; text-align: center;'>") // 增加內邊距
//                        .append("<b style='color:black;'>").append(ov.getCutToBox()==null?"":ov.getCutToBox()).append("</b>")
//                        .append("</td>");
//
//                //訂單文件號
//                htmlContent.append("<td style='min-width: 200px; padding: 10px; text-align: center;'>") // 增加內邊距
//                        .append("<b style='color:black;'>").append(ov.getOrderAuto()==null?"":ov.getOrderAuto()).append("</b>")
//                        .append("</td>");
//
//
//                htmlContent.append("</tr>");
//            }
//        }
//
//        htmlContent.append("</table>");
//
//
//
//        MimeMessage message = mailSender.createMimeMessage();
//        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
//
//        helper.setTo("hank.lin@stella.com.hk");
//        helper.setSubject("訂單預警通知");
//        helper.setText(htmlContent.toString(), true);
//
//        mailSender.send(message);
//
//
//
//    }

    /**
     * 未滿單預警數據總表
     * @throws MessagingException
     */
    public void sendSevenfilledTotalMail() throws MessagingException {

        /**
         * 未滿單預警數據總表
         */
        LocalDate today = LocalDate.now();
        LocalDateTime startOfDay = LocalDate.now().atStartOfDay();

        StringBuilder htmlContent = new StringBuilder();
        List<Financea> financeas = finceRepository.findByProIdSevenDays(startOfDay);
        htmlContent.append("<h2>未滿單預警數據匯總報表--生管</h2>");
        htmlContent.append("<table border='1' cellpadding='5' cellspacing='0' style='border-collapse: collapse;'>");
        htmlContent.append("<tr style='background-color:#007bff;color:white;'>");
        htmlContent.append("<th>預警名稱</th><th>預警週期</th><th>責任單位</th>");
        for (Financea financea : financeas) {
            htmlContent.append("<th>").append(financea.getFactory()).append("</th>");
        }
        htmlContent.append("</tr>");


        //訂單距離客人交期7 天未滿單
        htmlContent.append("<tr>");
        htmlContent.append("<td rowspan='2'>").append("訂單距離客人交期7天未滿單").append("</td>");
        htmlContent.append("<td rowspan='2'>").append("周一至周六").append("</td>");
        htmlContent.append("<td rowspan='2'>").append("生管").append("</td>");
        //zong1

        String [] URLary =new String[3];
        //GN
        URLary[0]="http://10.10.250.213:8080/fr/decision/view/report?viewlet=%25E8%25AE%25A2%25E5%258D%2595%25E8%25B7%259D%25E7%25A6%25BB%25E5%25AE%25A2%25E4%25BA%25BA%25E4%25BA%25A4%25E6%259C%259F7%25E5%25A4%25A9%25E6%259C%25AA%25E6%25BB%25A1%25E5%258D%2595_GN.cpt&ref_t=design&op=write&ref_c=38997943-19e3-4d25-ab10-c31fc6cf1ab6";
        //TP
        URLary[1]="http://10.10.250.213:8080/fr/decision/view/report?viewlet=%25E8%25AE%25A2%25E5%258D%2595%25E8%25B7%259D%25E7%25A6%25BB%25E5%25AE%25A2%25E4%25BA%25BA%25E4%25BA%25A4%25E6%259C%259F7%25E5%25A4%25A9%25E6%259C%25AA%25E6%25BB%25A1%25E5%258D%2595_TP.cpt&ref_t=design&op=write&ref_c=38997943-19e3-4d25-ab10-c31fc6cf1ab6";
        //VN
        URLary[2]="http://10.10.250.213:8080/fr/decision/view/report?viewlet=%25E8%25AE%25A2%25E5%258D%2595%25E8%25B7%259D%25E7%25A6%25BB%25E5%25AE%25A2%25E4%25BA%25BA%25E4%25BA%25A4%25E6%259C%259F7%25E5%25A4%25A9%25E6%259C%25AA%25E6%25BB%25A1%25E5%258D%2595_AL.cpt&ref_t=design&op=write&ref_c=38997943-19e3-4d25-ab10-c31fc6cf1ab6";

        int a = 0;
        for (Financea financea : financeas) {
            String url = (a < URLary.length) ? URLary[a] : "#"; // 避免超出陣列範圍
            htmlContent.append("<td style='width:100px; text-align:center;'>")
                    .append("<a href='").append(url).append("' target='_blank' style='color:blue; text-decoration: none;'>")
                    .append("<b>").append(financea.getProNum()).append("</b></a>")
                    .append("</td>");
            a++;
        }
        htmlContent.append("</tr>");

        htmlContent.append("<tr>");
        htmlContent.append("<td style='text-align:center;'>").append("陶氏玉").append("</td>");
        htmlContent.append("<td style='text-align:center;' >").append("蒋够粮").append("</td>");
        htmlContent.append("<td  style='text-align:center;'>").append("刘萍").append("</td>");
        htmlContent.append("</tr>");

        //訂單已過客人交期未滿單
        htmlContent.append("<tr>");
        htmlContent.append("<td rowspan='2'>").append("訂單已過客人交期未滿單").append("</td>");
        htmlContent.append("<td rowspan='2'>").append("周一至周六").append("</td>");
        htmlContent.append("<td rowspan='2'>").append("生管").append("</td>");
        //訂單已過客人交期未滿單
        //zong2
        List<Financea> financeaList = finceRepository.findByProIdPast(startOfDay);
        String [] URLary2 =new String[3];
        //GN
        URLary2[0]="http://10.10.250.213:8080/fr/decision/view/report?viewlet=%25E8%25A8%2582%25E5%2596%25AE%25E5%25B7%25B2%25E9%2581%258E%25E5%25AE%25A2%25E4%25BA%25BA%25E4%25BA%25A4%25E6%259C%259F%25E6%259C%25AA%25E6%25BB%25BF%25E5%2596%25AE_GN.cpt&ref_t=design&op=write&ref_c=38997943-19e3-4d25-ab10-c31fc6cf1ab6";
        //TP
        URLary2[1]="http://10.10.250.213:8080/fr/decision/view/report?viewlet=%25E8%25A8%2582%25E5%2596%25AE%25E5%25B7%25B2%25E9%2581%258E%25E5%25AE%25A2%25E4%25BA%25BA%25E4%25BA%25A4%25E6%259C%259F%25E6%259C%25AA%25E6%25BB%25BF%25E5%2596%25AE_TP.cpt&ref_t=design&op=write&ref_c=38997943-19e3-4d25-ab10-c31fc6cf1ab6";
        //VN
        URLary2[2]="http://10.10.250.213:8080/fr/decision/view/report?viewlet=%25E8%25A8%2582%25E5%2596%25AE%25E5%25B7%25B2%25E9%2581%258E%25E5%25AE%25A2%25E4%25BA%25BA%25E4%25BA%25A4%25E6%259C%259F%25E6%259C%25AA%25E6%25BB%25BF%25E5%2596%25AE_AL.cpt&ref_t=design&op=write&ref_c=38997943-19e3-4d25-ab10-c31fc6cf1ab6";

        int b = 0;
        for (Financea financea : financeaList) {
            String url2 = (b < URLary2.length) ? URLary2[b] : "#"; // 避免超出陣列範圍
            htmlContent.append("<td style='width:100px; text-align:center;'>")
                    .append("<a href='").append(url2).append("' target='_blank' style='color:blue; text-decoration: none;'>")
                    .append("<b>").append(financea.getProNum()).append("</b></a>")
                    .append("</td>");
            b++;
        }
        htmlContent.append("</tr>");

        htmlContent.append("<tr>");
        htmlContent.append("<td style='text-align:center;'>").append("陶氏玉").append("</td>");
        htmlContent.append("<td style='text-align:center;' >").append("蒋够粮").append("</td>");
        htmlContent.append("<td style='text-align:center;'>").append("刘萍").append("</td>");
        htmlContent.append("</tr>");

        htmlContent.append("</table>");



        //未滿單總表資料-分廠分品牌-1
        htmlContent.append("<h2>订单距离客人交期7天未满单</h2>");
        htmlContent.append("<table border='1' cellpadding='5' cellspacing='0' style='width: 100% ;  table-layout: auto; text-align: center; border-collapse: collapse;'>");
        htmlContent.append("<thead>");
        htmlContent.append("<tr style='background-color:white;color:black;'>");
        htmlContent.append("<th rowspan='2' style='border: 1px solid black; min-width: 150px;'>").append("工廠").append("</th>");
        htmlContent.append("<th rowspan='2' style='border: 1px solid black; min-width: 150px;'>").append("品牌名稱").append("</th>");
        for(int i = 0;i<=5 ;i++){
            LocalDate sixMonthsAgo = today.minusMonths(6);
            int sixMonthValue= sixMonthsAgo.getMonthValue()+1;
            int sinMonthYearValue = sixMonthsAgo.getYear();
            int calculatedMonth = sixMonthValue + i;
            int calculatedYear = sinMonthYearValue;
            if(calculatedMonth>=12){
                calculatedYear += 1; // 往前加一年
                calculatedMonth = calculatedMonth-12 ; // 轉換為正確的月份
                if(calculatedMonth == 0){
                    calculatedMonth =12;
                }
            }
            htmlContent.append("<th colspan='3' style='text-align:center; border: 1px solid black; padding: 10px; width: 150px;'>")
                    .append(calculatedYear).append("-").append(String.format("%02d", calculatedMonth)).append("</th>");
        }
        htmlContent.append("<th colspan='3' style='text-align:center; border: 1px solid black; width: 180px;'>").append("總計").append("</th>");
        htmlContent.append("</tr>");

        /**
         *   訂單距離客人交期7 天未滿單
         */
        htmlContent.append("<tr>");
        for(int i = 0;i<=6 ;i++){
            htmlContent.append("<th rowspan='2' style='border: 1px solid black; padding: 10px; width: 100px; white-space: nowrap;'>").append("PO數").append("</th>");
            htmlContent.append("<th rowspan='2' style='border: 1px solid black; padding: 10px; width: 100px; white-space: nowrap;'>").append("欠雙數").append("</th>");
            htmlContent.append("<th rowspan='2' style='border: 1px solid black; padding: 10px; width: 100px; white-space: nowrap;'>").append("訂單雙數").append("</th>");
        }
        htmlContent.append("</tr>");
        htmlContent.append("</thead>");
        //資料部分
        htmlContent.append("<tbody>");
        List<OutViewZong1> outViewZong1List = outViewZong1Repository.getTotalOutViewZong1();
        if(CollectionUtils.isEmpty(outViewZong1List)){
            throw new MessagingException("查無資料");
        }
        for(OutViewZong1 oz:outViewZong1List){
            if (oz==null){
                break;
            }
            htmlContent.append("<tr>");

            appendAllQty(htmlContent , oz);


            htmlContent.append("</tr>");
        }
        htmlContent.append("</tbody>");


        htmlContent.append("</table>");


        /**
         * 訂單已過客人交期未滿單
         */
        htmlContent.append("<h2>訂單已過客人交期未滿單</h2>");
        htmlContent.append("<table border='1' cellpadding='5' cellspacing='0' style='width: 100% ;  table-layout: auto; text-align: center; border-collapse: collapse;'>");
        htmlContent.append("<thead>");
        htmlContent.append("<tr style='background-color:white;color:black;'>");
        htmlContent.append("<th rowspan='2' style='border: 1px solid black; min-width: 150px;'>").append("工廠").append("</th>");
        htmlContent.append("<th rowspan='2' style='border: 1px solid black; min-width: 150px;'>").append("品牌名稱").append("</th>");
        for(int i = 0;i<=5 ;i++){
            LocalDate sixMonthsAgo = today.minusMonths(6);
            int sixMonthValue= sixMonthsAgo.getMonthValue()+1;
            int sinMonthYearValue = sixMonthsAgo.getYear();
            int calculatedMonth = sixMonthValue + i;
            int calculatedYear = sinMonthYearValue;
            if(calculatedMonth>=12){
                calculatedYear += 1; // 往前加一年
                calculatedMonth = calculatedMonth-12 ; // 轉換為正確的月份
                if(calculatedMonth == 0){
                    calculatedMonth =12;
                }
            }
            htmlContent.append("<th colspan='3' style='text-align:center; border: 1px solid black; padding: 10px; width: 150px;'>")
                    .append(calculatedYear).append("-").append(String.format("%02d", calculatedMonth)).append("</th>");
        }
        htmlContent.append("<th colspan='3' style='text-align:center; border: 1px solid black; width: 180px;'>").append("總計").append("</th>");
        htmlContent.append("</tr>");

        /**
         *   訂單距離客人交期7 天未滿單
         */
        htmlContent.append("<tr>");
        for(int i = 0;i<=6 ;i++){
            htmlContent.append("<th rowspan='2' style='border: 1px solid black; padding: 10px; width: 100px; white-space: nowrap;'>").append("PO數").append("</th>");
            htmlContent.append("<th rowspan='2' style='border: 1px solid black; padding: 10px; width: 100px; white-space: nowrap;'>").append("欠雙數").append("</th>");
            htmlContent.append("<th rowspan='2' style='border: 1px solid black; padding: 10px; width: 100px; white-space: nowrap;'>").append("訂單雙數").append("</th>");
        }
        htmlContent.append("</tr>");
        htmlContent.append("</thead>");
        //資料部分
        htmlContent.append("<tbody>");
        List<OutViewZong2> outViewZong2List = outViewZong2Repository.getTotalOutViewZong2();
        if(CollectionUtils.isEmpty(outViewZong1List)){
            throw new MessagingException("查無資料");
        }
        for(OutViewZong2 oz:outViewZong2List){
            if (oz==null){
                break;
            }
            htmlContent.append("<tr>");

            appendAll2Qty(htmlContent , oz);

            htmlContent.append("</tr>");
        }
        htmlContent.append("</tbody>");


        htmlContent.append("</table>");



        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

        String [] mailary = {"jay.xiao@stella.com.hk","hank.lin@stella.com.hk"};

        helper.setTo(mailary);
//        helper.setTo("hank.lin@stella.com.hk");

        helper.setFrom("eip.mail@stella.com.hk");

        helper.setSubject("未滿單預警數據匯總報表--生管");
        helper.setText(htmlContent.toString(), true);

        mailSender.send(message);



    }


    /**
     * 未滿單總表-訂單距離客人交期七天未滿單
     * @param htmlContent
     * @param oz
     * @return
     */
    public  StringBuilder appendAllQty( StringBuilder htmlContent,   OutViewZong1 oz ){
        if(StringUtils.equals(oz.getBrandNo(),"一區 合計")|| StringUtils.equals(oz.getBrandNo(),"二區 合計")) {
            htmlContent.append("<td style='background-color:#FFFFE7;'>").append(oz.getFactory()).append("</td>");
            htmlContent.append("<td style='background-color:#FFFFE7;'>").append(oz.getBrandNo()).append("</td>");
            //qty1
            htmlContent.append("<td style='background-color:#FFFFE7;'>").append(oz.getPoQty1() == 0 ? "" : oz.getPoQty1()).append("</td>");
            htmlContent.append("<td style='background-color:#FFFFE7;'>").append(oz.getNotinQty1() == 0 ? "" : oz.getNotinQty1()).append("</td>");
            htmlContent.append("<td style='background-color:#FFFFE7;'>").append(oz.getOrdQtyt1() == 0 ? "" : oz.getOrdQtyt1()).append("</td>");

            //qty2
            htmlContent.append("<td style='background-color:#FFFFE7;'>").append(oz.getPoQty2() == 0 ? "" : oz.getPoQty2()).append("</td>");
            htmlContent.append("<td style='background-color:#FFFFE7;'>").append(oz.getNotinQty2() == 0 ? "" : oz.getNotinQty2()).append("</td>");
            htmlContent.append("<td style='background-color:#FFFFE7;'>").append(oz.getOrdQtyt2() == 0 ? "" : oz.getOrdQtyt2()).append("</td>");

            //qty3
            htmlContent.append("<td style='background-color:#FFFFE7;'>").append(oz.getPoQty3() == 0 ? "" : oz.getPoQty3()).append("</td>");
            htmlContent.append("<td style='background-color:#FFFFE7;'>").append(oz.getNotinQty3() == 0 ? "" : oz.getNotinQty3()).append("</td>");
            htmlContent.append("<td style='background-color:#FFFFE7;'>").append(oz.getOrdQtyt3() == 0 ? "" : oz.getOrdQtyt3()).append("</td>");

            //qty4
            htmlContent.append("<td style='background-color:#FFFFE7;'>").append(oz.getPoQty4() == 0 ? "" : oz.getPoQty4()).append("</td>");
            htmlContent.append("<td style='background-color:#FFFFE7;'>").append(oz.getNotinQty4() == 0 ? "" : oz.getNotinQty4()).append("</td>");
            htmlContent.append("<td style='background-color:#FFFFE7;'>").append(oz.getOrdQtyt4() == 0 ? "" : oz.getOrdQtyt4()).append("</td>");

            //qty5
            htmlContent.append("<td style='background-color:#FFFFE7;'>").append(oz.getPoQty5() == 0 ? "" : oz.getPoQty5()).append("</td>");
            htmlContent.append("<td style='background-color:#FFFFE7;'>").append(oz.getNotinQty5() == 0 ? "" : oz.getNotinQty5()).append("</td>");
            htmlContent.append("<td style='background-color:#FFFFE7;'>").append(oz.getOrdQtyt5() == 0 ? "" : oz.getOrdQtyt5()).append("</td>");

            //qty6
            htmlContent.append("<td style='background-color:#FFFFE7;'>").append(oz.getPoQty6() == 0 ? "" : oz.getPoQty6()).append("</td>");
            htmlContent.append("<td style='background-color:#FFFFE7;'>").append(oz.getNotinQty6() == 0 ? "" : oz.getNotinQty6()).append("</td>");
            htmlContent.append("<td style='background-color:#FFFFE7;'>").append(oz.getOrdQtyt6() == 0 ? "" : oz.getOrdQtyt6()).append("</td>");

            //總計
            htmlContent.append("<td style='background-color:#FFFFE7;'>").append(oz.getPoQtyZong() == 0 ? "" : oz.getPoQtyZong()).append("</td>");
            htmlContent.append("<td style='background-color:#FFFFE7;'>").append(oz.getNoTinQtyZong() == 0 ? "" : oz.getNoTinQtyZong()).append("</td>");
            htmlContent.append("<td style='background-color:#FFFFE7;'>").append(oz.getOrdQtyZong() == 0 ? "" : oz.getOrdQtyZong()).append("</td>");
        }else if(StringUtils.equals(oz.getBrandNo(),"AL 總計")||StringUtils.equals(oz.getBrandNo(),"GN 總計")
                ||StringUtils.equals(oz.getBrandNo(),"TP 總計")){
            htmlContent.append("<td style='background-color:#FFFF66;'>").append(oz.getFactory()).append("</td>");
            htmlContent.append("<td style='background-color:#FFFF66;'>").append(oz.getBrandNo()).append("</td>");
            //qty1
            htmlContent.append("<td style='background-color:#FFFF66;'>").append(oz.getPoQty1() == 0 ? "" : oz.getPoQty1()).append("</td>");
            htmlContent.append("<td style='background-color:#FFFF66;'>").append(oz.getNotinQty1() == 0 ? "" : oz.getNotinQty1()).append("</td>");
            htmlContent.append("<td style='background-color:#FFFF66;'>").append(oz.getOrdQtyt1() == 0 ? "" : oz.getOrdQtyt1()).append("</td>");

            //qty2
            htmlContent.append("<td style='background-color:#FFFF66;'>").append(oz.getPoQty2() == 0 ? "" : oz.getPoQty2()).append("</td>");
            htmlContent.append("<td style='background-color:#FFFF66;'>").append(oz.getNotinQty2() == 0 ? "" : oz.getNotinQty2()).append("</td>");
            htmlContent.append("<td style='background-color:#FFFF66;'>").append(oz.getOrdQtyt2() == 0 ? "" : oz.getOrdQtyt2()).append("</td>");

            //qty3
            htmlContent.append("<td style='background-color:#FFFF66;'>").append(oz.getPoQty3() == 0 ? "" : oz.getPoQty3()).append("</td>");
            htmlContent.append("<td style='background-color:#FFFF66;'>").append(oz.getNotinQty3() == 0 ? "" : oz.getNotinQty3()).append("</td>");
            htmlContent.append("<td style='background-color:#FFFF66;'>").append(oz.getOrdQtyt3() == 0 ? "" : oz.getOrdQtyt3()).append("</td>");

            //qty4
            htmlContent.append("<td style='background-color:#FFFF66;'>").append(oz.getPoQty4() == 0 ? "" : oz.getPoQty4()).append("</td>");
            htmlContent.append("<td style='background-color:#FFFF66;'>").append(oz.getNotinQty4() == 0 ? "" : oz.getNotinQty4()).append("</td>");
            htmlContent.append("<td style='background-color:#FFFF66;'>").append(oz.getOrdQtyt4() == 0 ? "" : oz.getOrdQtyt4()).append("</td>");

            //qty5
            htmlContent.append("<td style='background-color:#FFFF66;'>").append(oz.getPoQty5() == 0 ? "" : oz.getPoQty5()).append("</td>");
            htmlContent.append("<td style='background-color:#FFFF66;'>").append(oz.getNotinQty5() == 0 ? "" : oz.getNotinQty5()).append("</td>");
            htmlContent.append("<td style='background-color:#FFFF66;'>").append(oz.getOrdQtyt5() == 0 ? "" : oz.getOrdQtyt5()).append("</td>");

            //qty6
            htmlContent.append("<td style='background-color:#FFFF66;'>").append(oz.getPoQty6() == 0 ? "" : oz.getPoQty6()).append("</td>");
            htmlContent.append("<td style='background-color:#FFFF66;'>").append(oz.getNotinQty6() == 0 ? "" : oz.getNotinQty6()).append("</td>");
            htmlContent.append("<td style='background-color:#FFFF66;'>").append(oz.getOrdQtyt6() == 0 ? "" : oz.getOrdQtyt6()).append("</td>");

            //總計
            htmlContent.append("<td style='background-color:#FFFF66;'>").append(oz.getPoQtyZong() == 0 ? "" : oz.getPoQtyZong()).append("</td>");
            htmlContent.append("<td style='background-color:#FFFF66;'>").append(oz.getNoTinQtyZong() == 0 ? "" : oz.getNoTinQtyZong()).append("</td>");
            htmlContent.append("<td style='background-color:#FFFF66;'>").append(oz.getOrdQtyZong() == 0 ? "" : oz.getOrdQtyZong()).append("</td>");

        }else if(StringUtils.equals(oz.getBrandNo(),"VN 總計")){
            htmlContent.append("<td style='background-color:#FFF3FF;'>").append(oz.getFactory()).append("</td>");
            htmlContent.append("<td style='background-color:#FFF3FF;'>").append(oz.getBrandNo()).append("</td>");
            //qty1
            htmlContent.append("<td style='background-color:#FFF3FF;'>").append(oz.getPoQty1() == 0 ? "" : oz.getPoQty1()).append("</td>");
            htmlContent.append("<td style='background-color:#FFF3FF;'>").append(oz.getNotinQty1() == 0 ? "" : oz.getNotinQty1()).append("</td>");
            htmlContent.append("<td style='background-color:#FFF3FF;'>").append(oz.getOrdQtyt1() == 0 ? "" : oz.getOrdQtyt1()).append("</td>");

            //qty2
            htmlContent.append("<td style='background-color:#FFF3FF;'>").append(oz.getPoQty2() == 0 ? "" : oz.getPoQty2()).append("</td>");
            htmlContent.append("<td style='background-color:#FFF3FF;'>").append(oz.getNotinQty2() == 0 ? "" : oz.getNotinQty2()).append("</td>");
            htmlContent.append("<td style='background-color:#FFF3FF;'>").append(oz.getOrdQtyt2() == 0 ? "" : oz.getOrdQtyt2()).append("</td>");

            //qty3
            htmlContent.append("<td style='background-color:#FFF3FF;'>").append(oz.getPoQty3() == 0 ? "" : oz.getPoQty3()).append("</td>");
            htmlContent.append("<td style='background-color:#FFF3FF;'>").append(oz.getNotinQty3() == 0 ? "" : oz.getNotinQty3()).append("</td>");
            htmlContent.append("<td style='background-color:#FFF3FF;'>").append(oz.getOrdQtyt3() == 0 ? "" : oz.getOrdQtyt3()).append("</td>");

            //qty4
            htmlContent.append("<td style='background-color:#FFF3FF;'>").append(oz.getPoQty4() == 0 ? "" : oz.getPoQty4()).append("</td>");
            htmlContent.append("<td style='background-color:#FFF3FF;'>").append(oz.getNotinQty4() == 0 ? "" : oz.getNotinQty4()).append("</td>");
            htmlContent.append("<td style='background-color:#FFF3FF;'>").append(oz.getOrdQtyt4() == 0 ? "" : oz.getOrdQtyt4()).append("</td>");

            //qty5
            htmlContent.append("<td style='background-color:#FFF3FF;'>").append(oz.getPoQty5() == 0 ? "" : oz.getPoQty5()).append("</td>");
            htmlContent.append("<td style='background-color:#FFF3FF;'>").append(oz.getNotinQty5() == 0 ? "" : oz.getNotinQty5()).append("</td>");
            htmlContent.append("<td style='background-color:#FFF3FF;'>").append(oz.getOrdQtyt5() == 0 ? "" : oz.getOrdQtyt5()).append("</td>");

            //qty6
            htmlContent.append("<td style='background-color:#FFF3FF;'>").append(oz.getPoQty6() == 0 ? "" : oz.getPoQty6()).append("</td>");
            htmlContent.append("<td style='background-color:#FFF3FF;'>").append(oz.getNotinQty6() == 0 ? "" : oz.getNotinQty6()).append("</td>");
            htmlContent.append("<td style='background-color:#FFF3FF;'>").append(oz.getOrdQtyt6() == 0 ? "" : oz.getOrdQtyt6()).append("</td>");

            //總計
            htmlContent.append("<td style='background-color:#FFF3FF;'>").append(oz.getPoQtyZong() == 0 ? "" : oz.getPoQtyZong()).append("</td>");
            htmlContent.append("<td style='background-color:#FFF3FF;'>").append(oz.getNoTinQtyZong() == 0 ? "" : oz.getNoTinQtyZong()).append("</td>");
            htmlContent.append("<td style='background-color:#FFF3FF;'>").append(oz.getOrdQtyZong() == 0 ? "" : oz.getOrdQtyZong()).append("</td>");

        }else {
            htmlContent.append("<td>").append(oz.getFactory()).append("</td>");
            htmlContent.append("<td>").append(oz.getBrandNo()).append("</td>");
                        //qty1
            htmlContent.append("<td>").append(oz.getPoQty1()==0?"":oz.getPoQty1()).append("</td>");
            htmlContent.append("<td>").append(oz.getNotinQty1()==0?"":oz.getNotinQty1()).append("</td>");
            htmlContent.append("<td>").append(oz.getOrdQtyt1()==0?"":oz.getOrdQtyt1()).append("</td>");

            //qty2
            htmlContent.append("<td>").append(oz.getPoQty2()==0?"":oz.getPoQty2()).append("</td>");
            htmlContent.append("<td>").append(oz.getNotinQty2()==0?"":oz.getNotinQty2()).append("</td>");
            htmlContent.append("<td>").append(oz.getOrdQtyt2()==0?"": oz.getOrdQtyt2()).append("</td>");

            //qty3
            htmlContent.append("<td>").append(oz.getPoQty3()==0?"":oz.getPoQty3()).append("</td>");
            htmlContent.append("<td>").append(oz.getNotinQty3()==0?"":oz.getNotinQty3()).append("</td>");
            htmlContent.append("<td>").append(oz.getOrdQtyt3()==0?"": oz.getOrdQtyt3()).append("</td>");

            //qty4
            htmlContent.append("<td>").append(oz.getPoQty4()==0?"":oz.getPoQty4()).append("</td>");
            htmlContent.append("<td>").append(oz.getNotinQty4()==0?"":oz.getNotinQty4()).append("</td>");
            htmlContent.append("<td>").append(oz.getOrdQtyt4()==0?"": oz.getOrdQtyt4()).append("</td>");

            //qty5
            htmlContent.append("<td>").append(oz.getPoQty5()==0?"":oz.getPoQty5()).append("</td>");
            htmlContent.append("<td>").append(oz.getNotinQty5()==0?"":oz.getNotinQty5()).append("</td>");
            htmlContent.append("<td>").append(oz.getOrdQtyt5()==0?"": oz.getOrdQtyt5()).append("</td>");

            //qty6
            htmlContent.append("<td>").append(oz.getPoQty6()==0?"":oz.getPoQty6()).append("</td>");
            htmlContent.append("<td>").append(oz.getNotinQty6()==0?"":oz.getNotinQty6()).append("</td>");
            htmlContent.append("<td>").append(oz.getOrdQtyt6()==0?"": oz.getOrdQtyt6()).append("</td>");

            //總計
            htmlContent.append("<td>").append(oz.getPoQtyZong()==0?"":oz.getPoQtyZong()).append("</td>");
            htmlContent.append("<td>").append(oz.getNoTinQtyZong()==0?"":oz.getNoTinQtyZong()).append("</td>");
            htmlContent.append("<td>").append(oz.getOrdQtyZong()==0?"":oz.getOrdQtyZong()).append("</td>");

        }
        return htmlContent;
    }


    /**
     * 未滿單總表-訂單已過客人交期未滿單
     * @param htmlContent
     * @param oz
     * @return
     */
    public  StringBuilder appendAll2Qty( StringBuilder htmlContent,   OutViewZong2 oz ){
        if(StringUtils.equals(oz.getBrandNo(),"一區 合計")|| StringUtils.equals(oz.getBrandNo(),"二區 合計")) {
            htmlContent.append("<td style='background-color:#E6F0FA;'>").append(oz.getFactory()).append("</td>");
            htmlContent.append("<td style='background-color:#E6F0FA;'>").append(oz.getBrandNo()).append("</td>");
            //qty1
            htmlContent.append("<td style='background-color:#E6F0FA;'>").append(oz.getPoQty1() == 0 ? "" : oz.getPoQty1()).append("</td>");
            htmlContent.append("<td style='background-color:#E6F0FA;'>").append(oz.getNotinQty1() == 0 ? "" : oz.getNotinQty1()).append("</td>");
            htmlContent.append("<td style='background-color:#E6F0FA;'>").append(oz.getOrdQty1() == 0 ? "" : oz.getOrdQty1()).append("</td>");

            //qty2
            htmlContent.append("<td style='background-color:#E6F0FA;'>").append(oz.getPoQty2() == 0 ? "" : oz.getPoQty2()).append("</td>");
            htmlContent.append("<td style='background-color:#E6F0FA;'>").append(oz.getNotinQty2() == 0 ? "" : oz.getNotinQty2()).append("</td>");
            htmlContent.append("<td style='background-color:#E6F0FA;'>").append(oz.getOrdQty2() == 0 ? "" : oz.getOrdQty2()).append("</td>");

            //qty3
            htmlContent.append("<td style='background-color:#E6F0FA;'>").append(oz.getPoQty3() == 0 ? "" : oz.getPoQty3()).append("</td>");
            htmlContent.append("<td style='background-color:#E6F0FA;'>").append(oz.getNotinQty3() == 0 ? "" : oz.getNotinQty3()).append("</td>");
            htmlContent.append("<td style='background-color:#E6F0FA;'>").append(oz.getOrdQtyt3() == 0 ? "" : oz.getOrdQtyt3()).append("</td>");

            //qty4
            htmlContent.append("<td style='background-color:#E6F0FA;'>").append(oz.getPoQty4() == 0 ? "" : oz.getPoQty4()).append("</td>");
            htmlContent.append("<td style='background-color:#E6F0FA;'>").append(oz.getNotinQty4() == 0 ? "" : oz.getNotinQty4()).append("</td>");
            htmlContent.append("<td style='background-color:#E6F0FA;'>").append(oz.getOrdQtyt4() == 0 ? "" : oz.getOrdQtyt4()).append("</td>");

            //qty5
            htmlContent.append("<td style='background-color:#E6F0FA;'>").append(oz.getPoQty5() == 0 ? "" : oz.getPoQty5()).append("</td>");
            htmlContent.append("<td style='background-color:#E6F0FA;'>").append(oz.getNotinQty5() == 0 ? "" : oz.getNotinQty5()).append("</td>");
            htmlContent.append("<td style='background-color:#E6F0FA;'>").append(oz.getOrdQtyt5() == 0 ? "" : oz.getOrdQtyt5()).append("</td>");

            //qty6
            htmlContent.append("<td style='background-color:#E6F0FA;'>").append(oz.getPoQty6() == 0 ? "" : oz.getPoQty6()).append("</td>");
            htmlContent.append("<td style='background-color:#E6F0FA;'>").append(oz.getNotinQty6() == 0 ? "" : oz.getNotinQty6()).append("</td>");
            htmlContent.append("<td style='background-color:#E6F0FA;'>").append(oz.getOrdQtyt6() == 0 ? "" : oz.getOrdQtyt6()).append("</td>");

            //總計
            htmlContent.append("<td style='background-color:#E6F0FA;'>").append(oz.getPoQtyZong() == 0 ? "" : oz.getPoQtyZong()).append("</td>");
            htmlContent.append("<td style='background-color:#E6F0FA;'>").append(oz.getNoTinQtyZong() == 0 ? "" : oz.getNoTinQtyZong()).append("</td>");
            htmlContent.append("<td style='background-color:#E6F0FA;'>").append(oz.getOrdQtyZong() == 0 ? "" : oz.getOrdQtyZong()).append("</td>");
        }else if(StringUtils.equals(oz.getBrandNo(),"AL 總計")||StringUtils.equals(oz.getBrandNo(),"GN 總計")
                ||StringUtils.equals(oz.getBrandNo(),"TP 總計")){
            htmlContent.append("<td style='background-color:#96B4C8;'>").append(oz.getFactory()).append("</td>");
            htmlContent.append("<td style='background-color:#96B4C8;'>").append(oz.getBrandNo()).append("</td>");
            //qty1
            htmlContent.append("<td style='background-color:#96B4C8;'>").append(oz.getPoQty1() == 0 ? "" : oz.getPoQty1()).append("</td>");
            htmlContent.append("<td style='background-color:#96B4C8;'>").append(oz.getNotinQty1() == 0 ? "" : oz.getNotinQty1()).append("</td>");
            htmlContent.append("<td style='background-color:#96B4C8;'>").append(oz.getOrdQty1() == 0 ? "" : oz.getOrdQty1()).append("</td>");

            //qty2
            htmlContent.append("<td style='background-color:#96B4C8;'>").append(oz.getPoQty2() == 0 ? "" : oz.getPoQty2()).append("</td>");
            htmlContent.append("<td style='background-color:#96B4C8;'>").append(oz.getNotinQty2() == 0 ? "" : oz.getNotinQty2()).append("</td>");
            htmlContent.append("<td style='background-color:#96B4C8;'>").append(oz.getOrdQty2() == 0 ? "" : oz.getOrdQty2()).append("</td>");

            //qty3
            htmlContent.append("<td style='background-color:#96B4C8;'>").append(oz.getPoQty3() == 0 ? "" : oz.getPoQty3()).append("</td>");
            htmlContent.append("<td style='background-color:#96B4C8;'>").append(oz.getNotinQty3() == 0 ? "" : oz.getNotinQty3()).append("</td>");
            htmlContent.append("<td style='background-color:#96B4C8;'>").append(oz.getOrdQtyt3() == 0 ? "" : oz.getOrdQtyt3()).append("</td>");

            //qty4
            htmlContent.append("<td style='background-color:#96B4C8;'>").append(oz.getPoQty4() == 0 ? "" : oz.getPoQty4()).append("</td>");
            htmlContent.append("<td style='background-color:#96B4C8;'>").append(oz.getNotinQty4() == 0 ? "" : oz.getNotinQty4()).append("</td>");
            htmlContent.append("<td style='background-color:#96B4C8;'>").append(oz.getOrdQtyt4() == 0 ? "" : oz.getOrdQtyt4()).append("</td>");

            //qty5
            htmlContent.append("<td style='background-color:#96B4C8;'>").append(oz.getPoQty5() == 0 ? "" : oz.getPoQty5()).append("</td>");
            htmlContent.append("<td style='background-color:#96B4C8;'>").append(oz.getNotinQty5() == 0 ? "" : oz.getNotinQty5()).append("</td>");
            htmlContent.append("<td style='background-color:#96B4C8;'>").append(oz.getOrdQtyt5() == 0 ? "" : oz.getOrdQtyt5()).append("</td>");

            //qty6
            htmlContent.append("<td style='background-color:#96B4C8;'>").append(oz.getPoQty6() == 0 ? "" : oz.getPoQty6()).append("</td>");
            htmlContent.append("<td style='background-color:#96B4C8;'>").append(oz.getNotinQty6() == 0 ? "" : oz.getNotinQty6()).append("</td>");
            htmlContent.append("<td style='background-color:#96B4C8;'>").append(oz.getOrdQtyt6() == 0 ? "" : oz.getOrdQtyt6()).append("</td>");

            //總計
            htmlContent.append("<td style='background-color:#96B4C8;'>").append(oz.getPoQtyZong() == 0 ? "" : oz.getPoQtyZong()).append("</td>");
            htmlContent.append("<td style='background-color:#96B4C8;'>").append(oz.getNoTinQtyZong() == 0 ? "" : oz.getNoTinQtyZong()).append("</td>");
            htmlContent.append("<td style='background-color:#96B4C8;'>").append(oz.getOrdQtyZong() == 0 ? "" : oz.getOrdQtyZong()).append("</td>");

        }else if(StringUtils.equals(oz.getBrandNo(),"VN 總計")){
            htmlContent.append("<td style='background-color: #FFF3FF;'>").append(oz.getFactory()).append("</td>");
            htmlContent.append("<td style='background-color: #FFF3FF;'>").append(oz.getBrandNo()).append("</td>");
            //qty1
            htmlContent.append("<td style='background-color: #FFF3FF;'>").append(oz.getPoQty1() == 0 ? "" : oz.getPoQty1()).append("</td>");
            htmlContent.append("<td style='background-color: #FFF3FF;'>").append(oz.getNotinQty1() == 0 ? "" : oz.getNotinQty1()).append("</td>");
            htmlContent.append("<td style='background-color: #FFF3FF;'>").append(oz.getOrdQty1() == 0 ? "" : oz.getOrdQty1()).append("</td>");

            //qty2
            htmlContent.append("<td style='background-color: #FFF3FF;'>").append(oz.getPoQty2() == 0 ? "" : oz.getPoQty2()).append("</td>");
            htmlContent.append("<td style='background-color: #FFF3FF;'>").append(oz.getNotinQty2() == 0 ? "" : oz.getNotinQty2()).append("</td>");
            htmlContent.append("<td style='background-color: #FFF3FF;'>").append(oz.getOrdQty2() == 0 ? "" : oz.getOrdQty2()).append("</td>");

            //qty3
            htmlContent.append("<td style='background-color: #FFF3FF;'>").append(oz.getPoQty3() == 0 ? "" : oz.getPoQty3()).append("</td>");
            htmlContent.append("<td style='background-color: #FFF3FF;'>").append(oz.getNotinQty3() == 0 ? "" : oz.getNotinQty3()).append("</td>");
            htmlContent.append("<td style='background-color: #FFF3FF;'>").append(oz.getOrdQtyt3() == 0 ? "" : oz.getOrdQtyt3()).append("</td>");

            //qty4
            htmlContent.append("<td style='background-color: #FFF3FF;'>").append(oz.getPoQty4() == 0 ? "" : oz.getPoQty4()).append("</td>");
            htmlContent.append("<td style='background-color: #FFF3FF;'>").append(oz.getNotinQty4() == 0 ? "" : oz.getNotinQty4()).append("</td>");
            htmlContent.append("<td style='background-color: #FFF3FF;'>").append(oz.getOrdQtyt4() == 0 ? "" : oz.getOrdQtyt4()).append("</td>");

            //qty5
            htmlContent.append("<td style='background-color: #FFF3FF;'>").append(oz.getPoQty5() == 0 ? "" : oz.getPoQty5()).append("</td>");
            htmlContent.append("<td style='background-color: #FFF3FF;'>").append(oz.getNotinQty5() == 0 ? "" : oz.getNotinQty5()).append("</td>");
            htmlContent.append("<td style='background-color: #FFF3FF;'>").append(oz.getOrdQtyt5() == 0 ? "" : oz.getOrdQtyt5()).append("</td>");

            //qty6
            htmlContent.append("<td style='background-color: #FFF3FF;'>").append(oz.getPoQty6() == 0 ? "" : oz.getPoQty6()).append("</td>");
            htmlContent.append("<td style='background-color: #FFF3FF;'>").append(oz.getNotinQty6() == 0 ? "" : oz.getNotinQty6()).append("</td>");
            htmlContent.append("<td style='background-color: #FFF3FF;'>").append(oz.getOrdQtyt6() == 0 ? "" : oz.getOrdQtyt6()).append("</td>");

            //總計
            htmlContent.append("<td style='background-color: #FFF3FF;'>").append(oz.getPoQtyZong() == 0 ? "" : oz.getPoQtyZong()).append("</td>");
            htmlContent.append("<td style='background-color: #FFF3FF;'>").append(oz.getNoTinQtyZong() == 0 ? "" : oz.getNoTinQtyZong()).append("</td>");
            htmlContent.append("<td style='background-color: #FFF3FF;'>").append(oz.getOrdQtyZong() == 0 ? "" : oz.getOrdQtyZong()).append("</td>");

        }else {
            htmlContent.append("<td>").append(oz.getFactory()).append("</td>");
            htmlContent.append("<td>").append(oz.getBrandNo()).append("</td>");
            //qty1
            htmlContent.append("<td>").append(oz.getPoQty1()==0?"":oz.getPoQty1()).append("</td>");
            htmlContent.append("<td>").append(oz.getNotinQty1()==0?"":oz.getNotinQty1()).append("</td>");
            htmlContent.append("<td>").append(oz.getOrdQty1()==0?"":oz.getOrdQty1()).append("</td>");

            //qty2
            htmlContent.append("<td>").append(oz.getPoQty2()==0?"":oz.getPoQty2()).append("</td>");
            htmlContent.append("<td>").append(oz.getNotinQty2()==0?"":oz.getNotinQty2()).append("</td>");
            htmlContent.append("<td>").append(oz.getOrdQty2()==0?"": oz.getOrdQty2()).append("</td>");

            //qty3
            htmlContent.append("<td>").append(oz.getPoQty3()==0?"":oz.getPoQty3()).append("</td>");
            htmlContent.append("<td>").append(oz.getNotinQty3()==0?"":oz.getNotinQty3()).append("</td>");
            htmlContent.append("<td>").append(oz.getOrdQtyt3()==0?"": oz.getOrdQtyt3()).append("</td>");

            //qty4
            htmlContent.append("<td>").append(oz.getPoQty4()==0?"":oz.getPoQty4()).append("</td>");
            htmlContent.append("<td>").append(oz.getNotinQty4()==0?"":oz.getNotinQty4()).append("</td>");
            htmlContent.append("<td>").append(oz.getOrdQtyt4()==0?"": oz.getOrdQtyt4()).append("</td>");

            //qty5
            htmlContent.append("<td>").append(oz.getPoQty5()==0?"":oz.getPoQty5()).append("</td>");
            htmlContent.append("<td>").append(oz.getNotinQty5()==0?"":oz.getNotinQty5()).append("</td>");
            htmlContent.append("<td>").append(oz.getOrdQtyt5()==0?"": oz.getOrdQtyt5()).append("</td>");

            //qty6
            htmlContent.append("<td>").append(oz.getPoQty6()==0?"":oz.getPoQty6()).append("</td>");
            htmlContent.append("<td>").append(oz.getNotinQty6()==0?"":oz.getNotinQty6()).append("</td>");
            htmlContent.append("<td>").append(oz.getOrdQtyt6()==0?"": oz.getOrdQtyt6()).append("</td>");

            //總計
            htmlContent.append("<td>").append(oz.getPoQtyZong()==0?"":oz.getPoQtyZong()).append("</td>");
            htmlContent.append("<td>").append(oz.getNoTinQtyZong()==0?"":oz.getNoTinQtyZong()).append("</td>");
            htmlContent.append("<td>").append(oz.getOrdQtyZong()==0?"":oz.getOrdQtyZong()).append("</td>");

        }
        return htmlContent;
    }

    /**
     * 未開補總表-訂單距離客人交期10天未滿單未開補
     * @throws MessagingException
     */
    public  void sendNotOpenForReplenishmentMail()  throws MessagingException{
        LocalDate today = LocalDate.now();
        LocalDateTime startOfDay = LocalDate.now().atStartOfDay();

        StringBuilder htmlContent = new StringBuilder();
        //TODO 請確認資料
        List<Financea> financeas = finceRepository.findByProIdSevenDays(startOfDay);


        htmlContent.append("<h2>成型未開補數據匯總報表--生管</h2>");
        htmlContent.append("<table border='1' cellpadding='5' cellspacing='0' style='border-collapse: collapse;'>");
        htmlContent.append("<tr style='background-color:#007bff;color:white;'>");
        htmlContent.append("<th>預警名稱</th><th>預警週期</th><th>責任單位</th>");
        for (Financea financea : financeas) {
            htmlContent.append("<th>").append(financea.getFactory()).append("</th>");
        }
        htmlContent.append("</tr>");

        //訂單距離客人交期10天未滿單成型未開補
        htmlContent.append("<tr>");
        htmlContent.append("<td rowspan='2'>").append("訂單距離客人交期10天未滿單成型未開補").append("</td>");
        htmlContent.append("<td rowspan='2'>").append("周一至周六").append("</td>");
        htmlContent.append("<td rowspan='2'>").append("生管").append("</td>");
        //
        String [] URLary =new String[3];
        //GN
        URLary[0] = "http://10.10.250.213:8080/fr/decision/view/report?viewlet=%25E8%25A8%2582%25E5%2596%25AE%25E8%25B7%259D%25E9%259B%25A2%25E5%25AE%25A2%25E4%25BA%25BA%25E4%25BA%25A4%25E6%259C%259F10%25E5%25A4%25A9%25E6%259C%25AA%25E6%25BB%25BF%25E5%2596%25AE%25E6%259C%25AA%25E9%2596%258B%25E8%25A3%259C_GN.cpt&ref_t=design&op=write&ref_c=0adc21e2-abc3-4721-9418-190d77f8a905";
        //TP
        URLary[1]="http://10.10.250.213:8080/fr/decision/view/report?viewlet=%25E8%25A8%2582%25E5%2596%25AE%25E8%25B7%259D%25E9%259B%25A2%25E5%25AE%25A2%25E4%25BA%25BA%25E4%25BA%25A4%25E6%259C%259F10%25E5%25A4%25A9%25E6%259C%25AA%25E6%25BB%25BF%25E5%2596%25AE%25E6%259C%25AA%25E9%2596%258B%25E8%25A3%259C_GN.cpt&ref_t=design&op=write&ref_c=2a999fb4-71a7-45b2-be61-74f118f123ec";
        //VN
        URLary[2]="http://10.10.250.213:8080/fr/decision/view/report?viewlet=%25E8%25A8%2582%25E5%2596%25AE%25E8%25B7%259D%25E9%259B%25A2%25E5%25AE%25A2%25E4%25BA%25BA%25E4%25BA%25A4%25E6%259C%259F10%25E5%25A4%25A9%25E6%259C%25AA%25E6%25BB%25BF%25E5%2596%25AE%25E6%259C%25AA%25E9%2596%258B%25E8%25A3%259C_AL.cpt&ref_t=design&op=write&ref_c=0adc21e2-abc3-4721-9418-190d77f8a905";

        int i = 0;
        for (Financea financea : financeas) {
            String url = (i < URLary.length) ? URLary[i] : "#"; // 避免超出陣列範圍
            htmlContent.append("<td style='width:100px; text-align:center;'>")
                    .append("<a href='").append(url).append("' target='_blank' style='color:blue; text-decoration: none;'>")
                    .append("<b>").append(financea.getProNum()).append("</b></a>")
                    .append("</td>");
            i++;
        }
        htmlContent.append("</tr>");

        htmlContent.append("<tr>");
        htmlContent.append("<td  style='text-align:center;'>").append("陶氏玉").append("</td>");
        htmlContent.append("<td  style='text-align:center;'>").append("蒋够粮").append("</td>");
        htmlContent.append("<td  style='text-align:center;'>").append("刘萍").append("</td>");
        htmlContent.append("</tr>");
        htmlContent.append("</table>");


        //訂單距離客人交期10天未滿單未開補
        htmlContent.append("<h2>訂單距離客人交期10天未滿單未開補</h2>");
        htmlContent.append("<table border='1' cellpadding='5' cellspacing='0' style='width: 100% ;  table-layout: auto; text-align: center; border-collapse: collapse;'>");
        htmlContent.append("<thead>");
        htmlContent.append("<tr style='background-color:white;color:black;'>");
        htmlContent.append("<th rowspan='2' style='border: 1px solid black; min-width: 150px;'>").append("工廠").append("</th>");
        htmlContent.append("<th rowspan='2' style='border: 1px solid black; min-width: 150px;'>").append("品牌名稱").append("</th>");

        htmlContent.append("<th colspan='4' style='text-align:center; border: 1px solid black; width: 180px; color:blue;'>").append("已生產").append("</th>");
        htmlContent.append("<th colspan='4' style='text-align:center; border: 1px solid black; width: 180px; color:red;' >").append("未生產").append("</th>");
        htmlContent.append("<th colspan='4' style='text-align:center; border: 1px solid black; width: 180px;'>").append("總計").append("</th>");
        htmlContent.append("</tr>");

        /**
         *   訂單距離客人交期7 天未滿單
         */
        htmlContent.append("<tr>");
        for(int x = 0;x<=2 ;x++){
            htmlContent.append("<th rowspan='2' style='border: 1px solid black; padding: 10px; width: 100px; white-space: nowrap;'>").append("工單數").append("</th>");
            htmlContent.append("<th rowspan='2' style='border: 1px solid black; padding: 10px; width: 100px; white-space: nowrap;'>").append("PO數").append("</th>");
            htmlContent.append("<th rowspan='2' style='border: 1px solid black; padding: 10px; width: 100px; white-space: nowrap;'>").append("欠雙數").append("</th>");
            htmlContent.append("<th rowspan='2' style='border: 1px solid black; padding: 10px; width: 100px; white-space: nowrap;'>").append("訂單雙數").append("</th>");
        }
        htmlContent.append("</tr>");
        htmlContent.append("</thead>");

        //資料部分
        htmlContent.append("<tbody>");
        List<OutViewZong3> outViewZong3ListList = outViewZong3Repository.getov3();
        if(CollectionUtils.isEmpty(outViewZong3ListList)){
            throw new MessagingException("查無資料");
        }
        for(OutViewZong3 oz:outViewZong3ListList){
            if (oz==null){
                break;
            }
            htmlContent.append("<tr>");

            appendNotOpenForReplenishmentMail(htmlContent , oz);

            htmlContent.append("</tr>");
        }
        htmlContent.append("</tbody>");

        htmlContent.append("</table>");
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

        String [] mailary = {"jay.xiao@stella.com.hk","hank.lin@stella.com.hk","demi.sun@stella.com.hk"};

        helper.setTo(mailary);
//        helper.setTo("hank.lin@stella.com.hk");
        helper.setFrom("eip.mail@stella.com.hk");
        helper.setSubject("成型未開補數據匯總報表--生管");
        helper.setText(htmlContent.toString(), true);

        mailSender.send(message);

    }


    /**
     * 判斷區域 加入顏色
     * @param htmlContent
     * @param oz
     * @return
     */
    public StringBuilder appendNotOpenForReplenishmentMail( StringBuilder htmlContent ,OutViewZong3 oz ){
        if(StringUtils.equals(oz.getBrandNo(),"一區 合計")|| StringUtils.equals(oz.getBrandNo(),"二區 合計")) {
            htmlContent.append("<td style='background-color:#FAEBD7;'>").append(oz.getFactory()).append("</td>");
            htmlContent.append("<td style='background-color:#FAEBD7;'>").append(oz.getBrandNo()).append("</td>");
            //已生產
            htmlContent.append("<td style='background-color:#FAEBD7;'>").append(oz.getOrderNo1() == 0 ? "" : oz.getOrderNo1()).append("</td>");
            htmlContent.append("<td style='background-color:#FAEBD7;'>").append(oz.getOrderAuto1() == 0 ? "" : oz.getOrderAuto1()).append("</td>");
            htmlContent.append("<td style='background-color:#FAEBD7;'>").append(oz.getNotinQty1() == 0 ? "" : oz.getNotinQty1()).append("</td>");
            htmlContent.append("<td style='background-color:#FAEBD7;'>").append(oz.getOrdQty1() == 0 ? "" : oz.getOrdQty1()).append("</td>");

            //未生產
            htmlContent.append("<td style='background-color:#FAEBD7;'>").append(oz.getOrderNo2() == 0 ? "" : oz.getOrderNo2()).append("</td>");
            htmlContent.append("<td style='background-color:#FAEBD7;'>").append(oz.getOrderAuto2() == 0 ? "" : oz.getOrderAuto2()).append("</td>");
            htmlContent.append("<td style='background-color:#FAEBD7;'>").append(oz.getNotinQty2() == 0 ? "" : oz.getNotinQty2()).append("</td>");
            htmlContent.append("<td style='background-color:#FAEBD7;'>").append(oz.getOrdQty2() == 0 ? "" : oz.getOrdQty2()).append("</td>");

            //總計
            htmlContent.append("<td style='background-color:#FAEBD7;'>").append(oz.getOrderNoZong() == 0 ? "" : oz.getOrderNoZong()).append("</td>");
            htmlContent.append("<td style='background-color:#FAEBD7;'>").append(oz.getOrderAutoZong() == 0 ? "" : oz.getOrderAutoZong()).append("</td>");
            htmlContent.append("<td style='background-color:#FAEBD7;'>").append(oz.getNotinQtyZong() == 0 ? "" : oz.getNotinQtyZong()).append("</td>");
            htmlContent.append("<td style='background-color:#FAEBD7;'>").append(oz.getOrdQtyZong() == 0 ? "" : oz.getOrdQtyZong()).append("</td>");

        }else if(StringUtils.equals(oz.getBrandNo(),"AL 總計")||StringUtils.equals(oz.getBrandNo(),"GN 總計")
                ||StringUtils.equals(oz.getBrandNo(),"TP 總計")){
            htmlContent.append("<td style='background-color:#F5F5DC;'>").append(oz.getFactory()).append("</td>");
            htmlContent.append("<td style='background-color:#F5F5DC;'>").append(oz.getBrandNo()).append("</td>");
            //已生產
            htmlContent.append("<td style='background-color:#F5F5DC;'>").append(oz.getOrderNo1() == 0 ? "" : oz.getOrderNo1()).append("</td>");
            htmlContent.append("<td style='background-color:#F5F5DC;'>").append(oz.getOrderAuto1() == 0 ? "" : oz.getOrderAuto1()).append("</td>");
            htmlContent.append("<td style='background-color:#F5F5DC;'>").append(oz.getNotinQty1() == 0 ? "" : oz.getNotinQty1()).append("</td>");
            htmlContent.append("<td style='background-color:#F5F5DC;'>").append(oz.getOrdQty1() == 0 ? "" : oz.getOrdQty1()).append("</td>");

            //未生產
            htmlContent.append("<td style='background-color:#F5F5DC;'>").append(oz.getOrderNo2() == 0 ? "" : oz.getOrderNo2()).append("</td>");
            htmlContent.append("<td style='background-color:#F5F5DC;'>").append(oz.getOrderAuto2() == 0 ? "" : oz.getOrderAuto2()).append("</td>");
            htmlContent.append("<td style='background-color:#F5F5DC;'>").append(oz.getNotinQty2() == 0 ? "" : oz.getNotinQty2()).append("</td>");
            htmlContent.append("<td style='background-color:#F5F5DC;'>").append(oz.getOrdQty2() == 0 ? "" : oz.getOrdQty2()).append("</td>");

            //總計
            htmlContent.append("<td style='background-color:#F5F5DC;'>").append(oz.getOrderNoZong() == 0 ? "" : oz.getOrderNoZong()).append("</td>");
            htmlContent.append("<td style='background-color:#F5F5DC;'>").append(oz.getOrderAutoZong() == 0 ? "" : oz.getOrderAutoZong()).append("</td>");
            htmlContent.append("<td style='background-color:#F5F5DC;'>").append(oz.getNotinQtyZong() == 0 ? "" : oz.getNotinQtyZong()).append("</td>");
            htmlContent.append("<td style='background-color:#F5F5DC;'>").append(oz.getOrdQtyZong() == 0 ? "" : oz.getOrdQtyZong()).append("</td>");

        }else if(StringUtils.equals(oz.getBrandNo(),"VN 總計")){
            htmlContent.append("<td style='background-color:#FFF3FF;'>").append(oz.getFactory()).append("</td>");
            htmlContent.append("<td style='background-color:#FFF3FF;'>").append(oz.getBrandNo()).append("</td>");
            //已生產
            htmlContent.append("<td style='background-color:#FFF3FF;'>").append(oz.getOrderNo1() == 0 ? "" : oz.getOrderNo1()).append("</td>");
            htmlContent.append("<td style='background-color:#FFF3FF;'>").append(oz.getOrderAuto1() == 0 ? "" : oz.getOrderAuto1()).append("</td>");
            htmlContent.append("<td style='background-color:#FFF3FF;'>").append(oz.getNotinQty1() == 0 ? "" : oz.getNotinQty1()).append("</td>");
            htmlContent.append("<td style='background-color:#FFF3FF;'>").append(oz.getOrdQty1() == 0 ? "" : oz.getOrdQty1()).append("</td>");

            //未生產
            htmlContent.append("<td style='background-color:#FFF3FF;'>").append(oz.getOrderNo2() == 0 ? "" : oz.getOrderNo2()).append("</td>");
            htmlContent.append("<td style='background-color:#FFF3FF;'>").append(oz.getOrderAuto2() == 0 ? "" : oz.getOrderAuto2()).append("</td>");
            htmlContent.append("<td style='background-color:#FFF3FF;'>").append(oz.getNotinQty2() == 0 ? "" : oz.getNotinQty2()).append("</td>");
            htmlContent.append("<td style='background-color:#FFF3FF;'>").append(oz.getOrdQty2() == 0 ? "" : oz.getOrdQty2()).append("</td>");

            //總計
            htmlContent.append("<td style='background-color:#FFF3FF;'>").append(oz.getOrderNoZong() == 0 ? "" : oz.getOrderNoZong()).append("</td>");
            htmlContent.append("<td style='background-color:#FFF3FF;'>").append(oz.getOrderAutoZong() == 0 ? "" : oz.getOrderAutoZong()).append("</td>");
            htmlContent.append("<td style='background-color:#FFF3FF;'>").append(oz.getNotinQtyZong() == 0 ? "" : oz.getNotinQtyZong()).append("</td>");
            htmlContent.append("<td style='background-color:#FFF3FF;'>").append(oz.getOrdQtyZong() == 0 ? "" : oz.getOrdQtyZong()).append("</td>");

        }else {
            htmlContent.append("<td>").append(oz.getFactory()).append("</td>");
            htmlContent.append("<td>").append(oz.getBrandNo()).append("</td>");
            //已生產
            htmlContent.append("<td>").append(oz.getOrderNo1() == 0 ? "" : oz.getOrderNo1()).append("</td>");
            htmlContent.append("<td>").append(oz.getOrderAuto1() == 0 ? "" : oz.getOrderAuto1()).append("</td>");
            htmlContent.append("<td>").append(oz.getNotinQty1() == 0 ? "" : oz.getNotinQty1()).append("</td>");
            htmlContent.append("<td>").append(oz.getOrdQty1() == 0 ? "" : oz.getOrdQty1()).append("</td>");

            //未生產
            htmlContent.append("<td>").append(oz.getOrderNo2() == 0 ? "" : oz.getOrderNo2()).append("</td>");
            htmlContent.append("<td>").append(oz.getOrderAuto2() == 0 ? "" : oz.getOrderAuto2()).append("</td>");
            htmlContent.append("<td>").append(oz.getNotinQty2() == 0 ? "" : oz.getNotinQty2()).append("</td>");
            htmlContent.append("<td>").append(oz.getOrdQty2() == 0 ? "" : oz.getOrdQty2()).append("</td>");

            //總計
            htmlContent.append("<td>").append(oz.getOrderNoZong() == 0 ? "" : oz.getOrderNoZong()).append("</td>");
            htmlContent.append("<td>").append(oz.getOrderAutoZong() == 0 ? "" : oz.getOrderAutoZong()).append("</td>");
            htmlContent.append("<td>").append(oz.getNotinQtyZong() == 0 ? "" : oz.getNotinQtyZong()).append("</td>");
            htmlContent.append("<td>").append(oz.getOrdQtyZong() == 0 ? "" : oz.getOrdQtyZong()).append("</td>");

        }
        return htmlContent;
    }


    public void sendNotCheckMail()  throws MessagingException{
        LocalDateTime startOfDay = LocalDate.now().atStartOfDay();
        List<Financea> financeas = finceRepository.findByProIdSevenDays(startOfDay);
        //訂單已過客人交期未滿單
        List<Financea> financeaList = finceRepository.findByProIdPast(startOfDay);
        /**
         * Table 3
         * 未驗貨預警數據匯總報表--品管
         */
        StringBuilder htmlContent = new StringBuilder();
        htmlContent.append("<h2>未驗貨預警數據匯總報表--品管</h2>");
        htmlContent.append("<table border='1' cellpadding='5' cellspacing='0' style='border-collapse: collapse;'>");
        htmlContent.append("<tr style='background-color:#007bff;color:white;'>");
        htmlContent.append("<th>預警名稱</th><th>預警週期</th><th>責任單位</th>");
        for (Financea financea : financeas) {
            htmlContent.append("<th>").append(financea.getFactory()).append("</th>");
        }
        htmlContent.append("</tr>");


        //訂單距離客人交期7 天未滿單
        htmlContent.append("<tr>");
        htmlContent.append("<td rowspan='2'>").append("訂單距離客人交期7天未滿單").append("</td>");
        htmlContent.append("<td rowspan='2'>").append("周一至周六").append("</td>");
        htmlContent.append("<td rowspan='2'>").append("生管").append("</td>");
        //zong4
        String [] URLary =new String[3];
        //GN
        URLary[0]="http://10.10.250.213:8080/fr/decision/view/report?viewlet=%25E8%25A8%2582%25E5%2596%25AE%25E8%25B7%259D%25E9%259B%25A2%25E5%25AE%25A2%25E4%25BA%25BA%25E4%25BA%25A4%25E6%259C%259F7%25E5%25A4%25A9%25E6%259C%25AA%25E9%25A9%2597%25E8%25B2%25A8_GN.cpt&ref_t=design&op=write&ref_c=0adc21e2-abc3-4721-9418-190d77f8a905";
        //TP
        URLary[1]="http://10.10.250.213:8080/fr/decision/view/report?viewlet=%25E8%25A8%2582%25E5%2596%25AE%25E8%25B7%259D%25E9%259B%25A2%25E5%25AE%25A2%25E4%25BA%25BA%25E4%25BA%25A4%25E6%259C%259F7%25E5%25A4%25A9%25E6%259C%25AA%25E9%25A9%2597%25E8%25B2%25A8_TP.cpt&ref_t=design&op=write&ref_c=0adc21e2-abc3-4721-9418-190d77f8a905";
        //VN
        URLary[2]="http://10.10.250.213:8080/fr/decision/view/report?viewlet=%25E8%25A8%2582%25E5%2596%25AE%25E8%25B7%259D%25E9%259B%25A2%25E5%25AE%25A2%25E4%25BA%25BA%25E4%25BA%25A4%25E6%259C%259F7%25E5%25A4%25A9%25E6%259C%25AA%25E9%25A9%2597%25E8%25B2%25A8_VN.cpt&ref_t=design&op=write&ref_c=0adc21e2-abc3-4721-9418-190d77f8a905";

        int i = 0;
        for (Financea financea : financeas) {
            String url = (i < URLary.length) ? URLary[i] : "#"; // 避免超出陣列範圍
            htmlContent.append("<td style='width:100px; text-align:center;'>")
                    .append("<a href='").append(url).append("' target='_blank' style='color:blue; text-decoration: none;'>")
                    .append("<b>").append(financea.getProNum()).append("</b></a>")
                    .append("</td>");
            i++;
        }
        htmlContent.append("</tr>");

        htmlContent.append("<tr>");
        htmlContent.append("<td style='text-align :center;'>").append("黃氏娥").append("</td>");
        htmlContent.append("<td style='text-align :center;'>").append("范氏雲").append("</td>");
        htmlContent.append("<td style='text-align :center;'>").append("阮氏寧").append("</td>");
        htmlContent.append("</tr>");

        //訂單已過客人交期未滿單
        htmlContent.append("<tr>");
        htmlContent.append("<td rowspan='2'>").append("訂單已過客人交期未滿單").append("</td>");
        htmlContent.append("<td rowspan='2'>").append("周一至周六").append("</td>");
        htmlContent.append("<td rowspan='2'>").append("生管").append("</td>");
        //ZONG5

        String [] URLary5 =new String[3];

        //GN
        URLary[0]="http://10.10.250.213:8080/fr/decision/view/report?viewlet=%25E8%25A8%2582%25E5%2596%25AE%25E5%25B7%25B2%25E9%2581%258E%25E5%25AE%25A2%25E4%25BA%25BA%25E4%25BA%25A4%25E6%259C%259F%25E6%259C%25AA%25E9%25A9%2597%25E8%25B2%25A8_GN.cpt&ref_t=design&op=write&ref_c=0adc21e2-abc3-4721-9418-190d77f8a905";
        //TP
        URLary[1]="http://10.10.250.213:8080/fr/decision/view/report?viewlet=%25E8%25A8%2582%25E5%2596%25AE%25E5%25B7%25B2%25E9%2581%258E%25E5%25AE%25A2%25E4%25BA%25BA%25E4%25BA%25A4%25E6%259C%259F%25E6%259C%25AA%25E9%25A9%2597%25E8%25B2%25A8_TP.cpt&ref_t=design&op=write&ref_c=0adc21e2-abc3-4721-9418-190d77f8a905";
        //VN
        URLary[2]="http://10.10.250.213:8080/fr/decision/view/report?viewlet=%25E8%25A8%2582%25E5%2596%25AE%25E5%25B7%25B2%25E9%2581%258E%25E5%25AE%25A2%25E4%25BA%25BA%25E4%25BA%25A4%25E6%259C%259F%25E6%259C%25AA%25E9%25A9%2597%25E8%25B2%25A8_VN.cpt&ref_t=design&op=write&ref_c=0adc21e2-abc3-4721-9418-190d77f8a905";

        int a = 0;
        for (Financea financea : financeas) {
            String url = (a < URLary.length) ? URLary[a] : "#"; // 避免超出陣列範圍
            htmlContent.append("<td style='width:100px; text-align:center;'>")
                    .append("<a href='").append(url).append("' target='_blank' style='color:blue; text-decoration: none;'>")
                    .append("<b>").append(financea.getProNum()).append("</b></a>")
                    .append("</td>");
            a++;
        }
        htmlContent.append("</tr>");

        htmlContent.append("<tr>");
        htmlContent.append("<td style='text-align :center;'>").append("黃氏娥").append("</td>");
        htmlContent.append("<td style='text-align :center;'>").append("范氏雲").append("</td>");
        htmlContent.append("<td style='text-align :center;'>").append("阮氏寧").append("</td>");
        htmlContent.append("</tr>");
        htmlContent.append("</table>");

        //訂單距離客人交期7天未驗貨總表
        htmlContent.append("<h2>訂單距離客人交期7天未驗貨</h2>");
        htmlContent.append("<table border='1' cellpadding='5' cellspacing='0' style='width: 100% ;  table-layout: auto; text-align: center; border-collapse: collapse;'>");
        htmlContent.append("<thead>");
        htmlContent.append("<tr style='background-color:white;color:black;'>");
        htmlContent.append("<th rowspan='2' style='border: 1px solid black; min-width: 150px;'>").append("工廠").append("</th>");
        htmlContent.append("<th rowspan='2' style='border: 1px solid black; min-width: 150px;'>").append("品牌名稱").append("</th>");

        htmlContent.append("<th colspan='2' style='text-align:center; border: 1px solid black; width: 180px; color:blue;'>").append("已滿單").append("</th>");
        htmlContent.append("<th colspan='3' style='text-align:center; border: 1px solid black; width: 180px; color:red;' >").append("未滿單").append("</th>");
        htmlContent.append("<th colspan='3' style='text-align:center; border: 1px solid black; width: 180px;'>").append("總計").append("</th>");
        htmlContent.append("</tr>");

        /**
         *   訂單距離客人交期7 天未滿單
         */
        htmlContent.append("<tr>");
        for(int x = 0;x<=2 ;x++){
            if(x==0){
                htmlContent.append("<th rowspan='2' style='border: 1px solid black; padding: 10px; width: 100px; white-space: nowrap;'>").append("PO數").append("</th>");
                htmlContent.append("<th rowspan='2' style='border: 1px solid black; padding: 10px; width: 100px; white-space: nowrap;'>").append("訂單雙數").append("</th>");
            }else{
                htmlContent.append("<th rowspan='2' style='border: 1px solid black; padding: 10px; width: 100px; white-space: nowrap;'>").append("PO數").append("</th>");
                htmlContent.append("<th rowspan='2' style='border: 1px solid black; padding: 10px; width: 100px; white-space: nowrap;'>").append("欠雙數").append("</th>");
                htmlContent.append("<th rowspan='2' style='border: 1px solid black; padding: 10px; width: 100px; white-space: nowrap;'>").append("訂單雙數").append("</th>");
            }
        }
        htmlContent.append("</tr>");
        htmlContent.append("</thead>");

        //資料部分
        htmlContent.append("<tbody>");
        List<OutViewZong4> outViewZong4List = outViewZong4Repository.getov4();
        if(CollectionUtils.isEmpty(outViewZong4List)){
            throw new MessagingException("查無資料");
        }
        for(OutViewZong4 oz:outViewZong4List){
            if (oz==null){
                break;
            }
            htmlContent.append("<tr>");

            appendAll4Qty(htmlContent , oz);

            htmlContent.append("</tr>");
        }
        htmlContent.append("</tbody>");


        htmlContent.append("</table>");



        /***********************************************/
        //訂單已過客人交期未驗貨
        htmlContent.append("<h2>訂單已過客人交期未驗貨</h2>");
        htmlContent.append("<table border='1' cellpadding='5' cellspacing='0' style='width: 100% ;  table-layout: auto; text-align: center; border-collapse: collapse;'>");
        htmlContent.append("<thead>");
        htmlContent.append("<tr style='background-color:white;color:black;'>");
        htmlContent.append("<th rowspan='2' style='border: 1px solid black; min-width: 150px;'>").append("工廠").append("</th>");
        htmlContent.append("<th rowspan='2' style='border: 1px solid black; min-width: 150px;'>").append("品牌名稱").append("</th>");

        htmlContent.append("<th colspan='2' style='text-align:center; border: 1px solid black; width: 180px; color:blue;'>").append("已滿單").append("</th>");
        htmlContent.append("<th colspan='3' style='text-align:center; border: 1px solid black; width: 180px; color:red;' >").append("未滿單").append("</th>");
        htmlContent.append("<th colspan='3' style='text-align:center; border: 1px solid black; width: 180px;'>").append("總計").append("</th>");
        htmlContent.append("</tr>");

        /**
         *   訂單距離客人交期7 天未滿單
         */
        htmlContent.append("<tr>");
        for(int y = 0;y<=2 ;y++){
            if(y==0){
                htmlContent.append("<th rowspan='2' style='border: 1px solid black; padding: 10px; width: 100px; white-space: nowrap;'>").append("PO數").append("</th>");
                htmlContent.append("<th rowspan='2' style='border: 1px solid black; padding: 10px; width: 100px; white-space: nowrap;'>").append("訂單雙數").append("</th>");
            }else{
                htmlContent.append("<th rowspan='2' style='border: 1px solid black; padding: 10px; width: 100px; white-space: nowrap;'>").append("PO數").append("</th>");
                htmlContent.append("<th rowspan='2' style='border: 1px solid black; padding: 10px; width: 100px; white-space: nowrap;'>").append("欠雙數").append("</th>");
                htmlContent.append("<th rowspan='2' style='border: 1px solid black; padding: 10px; width: 100px; white-space: nowrap;'>").append("訂單雙數").append("</th>");
            }
        }
        htmlContent.append("</tr>");
        htmlContent.append("</thead>");

        //資料部分
        htmlContent.append("<tbody>");
        List<OutViewZong5> outViewZong5List = outViewZong5Repository.getov5();
        if(CollectionUtils.isEmpty(outViewZong5List)){
            throw new MessagingException("查無資料");
        }
        for(OutViewZong5 oz:outViewZong5List){
            if (oz==null){
                break;
            }
            htmlContent.append("<tr>");

            appendAll5Qty(htmlContent , oz);

            htmlContent.append("</tr>");
        }
        htmlContent.append("</tbody>");


        htmlContent.append("</table>");

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

        String [] mailary = {"jay.xiao@stella.com.hk","hank.lin@stella.com.hk"};

        helper.setTo(mailary);
//        helper.setTo("hank.lin@stella.com.hk");
        helper.setFrom("eip.mail@stella.com.hk");
        helper.setSubject("未驗貨預警數據匯總報表--品管");
        helper.setText(htmlContent.toString(), true);

        mailSender.send(message);








    }



    public StringBuilder appendAll4Qty(StringBuilder htmlContent , OutViewZong4 oz  ){
        if(StringUtils.equals(oz.getBrandNo(),"一區 合計")|| StringUtils.equals(oz.getBrandNo(),"二區 合計")) {
            htmlContent.append("<td style='background-color:#FFF3FF;'>").append(oz.getFactory()).append("</td>");
            htmlContent.append("<td style='background-color:#FFF3FF;'>").append(oz.getBrandNo()).append("</td>");
            //已滿單
            htmlContent.append("<td style='background-color:#FFF3FF;'>").append(oz.getOrderAuto1() == 0 ? "" : oz.getOrderAuto1()).append("</td>");
            htmlContent.append("<td style='background-color:#FFF3FF;'>").append(oz.getOrdQty1() == 0 ? "" : oz.getOrdQty1()).append("</td>");


            //未滿單
            htmlContent.append("<td style='background-color:#FFF3FF;'>").append(oz.getOrderAuto2() == 0 ? "" : oz.getOrderAuto2()).append("</td>");
            htmlContent.append("<td style='background-color:#FFF3FF;'>").append(oz.getNotinQty2() == 0 ? "" : oz.getNotinQty2()).append("</td>");
            htmlContent.append("<td style='background-color:#FFF3FF;'>").append(oz.getOrdQty2() == 0 ? "" : oz.getOrdQty2()).append("</td>");

            //總計
            htmlContent.append("<td style='background-color:#FFF3FF;'>").append(oz.getOrderAutoZong() == 0 ? "" : oz.getOrderAutoZong()).append("</td>");
            htmlContent.append("<td style='background-color:#FFF3FF;'>").append(oz.getNotinQtyZong() == 0 ? "" : oz.getNotinQtyZong()).append("</td>");
            htmlContent.append("<td style='background-color:#FFF3FF;'>").append(oz.getOrdQtyZong() == 0 ? "" : oz.getOrdQtyZong()).append("</td>");
        }else if(StringUtils.equals(oz.getBrandNo(),"AL 總計")||StringUtils.equals(oz.getBrandNo(),"GN 總計")
                ||StringUtils.equals(oz.getBrandNo(),"TP 總計")){

            htmlContent.append("<td style='background-color:#FFD5FF;'>").append(oz.getFactory()).append("</td>");
            htmlContent.append("<td style='background-color:#FFD5FF;'>").append(oz.getBrandNo()).append("</td>");
            //已滿單
            htmlContent.append("<td style='background-color:#FFD5FF;'>").append(oz.getOrderAuto1() == 0 ? "" : oz.getOrderAuto1()).append("</td>");
            htmlContent.append("<td style='background-color:#FFD5FF;'>").append(oz.getOrdQty1() == 0 ? "" : oz.getOrdQty1()).append("</td>");


            //未滿單
            htmlContent.append("<td style='background-color:#FFD5FF;'>").append(oz.getOrderAuto2() == 0 ? "" : oz.getOrderAuto2()).append("</td>");
            htmlContent.append("<td style='background-color:#FFD5FF;'>").append(oz.getNotinQty2() == 0 ? "" : oz.getNotinQty2()).append("</td>");
            htmlContent.append("<td style='background-color:#FFD5FF;'>").append(oz.getOrdQty2() == 0 ? "" : oz.getOrdQty2()).append("</td>");

            //總計
            htmlContent.append("<td style='background-color:#FFD5FF;'>").append(oz.getOrderAutoZong() == 0 ? "" : oz.getOrderAutoZong()).append("</td>");
            htmlContent.append("<td style='background-color:#FFD5FF;'>").append(oz.getNotinQtyZong() == 0 ? "" : oz.getNotinQtyZong()).append("</td>");
            htmlContent.append("<td style='background-color:#FFD5FF;'>").append(oz.getOrdQtyZong() == 0 ? "" : oz.getOrdQtyZong()).append("</td>");

        }else if(StringUtils.equals(oz.getBrandNo(),"VN 總計")){
            htmlContent.append("<td style='background-color:#F2F2F2;'>").append(oz.getFactory()).append("</td>");
            htmlContent.append("<td style='background-color:#F2F2F2;'>").append(oz.getBrandNo()).append("</td>");
            //已滿單
            htmlContent.append("<td style='background-color:#F2F2F2;'>").append(oz.getOrderAuto1() == 0 ? "" : oz.getOrderAuto1()).append("</td>");
            htmlContent.append("<td style='background-color:#F2F2F2;'>").append(oz.getOrdQty1() == 0 ? "" : oz.getOrdQty1()).append("</td>");


            //未滿單
            htmlContent.append("<td style='background-color:#F2F2F2;'>").append(oz.getOrderAuto2() == 0 ? "" : oz.getOrderAuto2()).append("</td>");
            htmlContent.append("<td style='background-color:#F2F2F2;'>").append(oz.getNotinQty2() == 0 ? "" : oz.getNotinQty2()).append("</td>");
            htmlContent.append("<td style='background-color:#F2F2F2;'>").append(oz.getOrdQty2() == 0 ? "" : oz.getOrdQty2()).append("</td>");

            //總計
            htmlContent.append("<td style='background-color:#F2F2F2;'>").append(oz.getOrderAutoZong() == 0 ? "" : oz.getOrderAutoZong()).append("</td>");
            htmlContent.append("<td style='background-color:#F2F2F2;'>").append(oz.getNotinQtyZong() == 0 ? "" : oz.getNotinQtyZong()).append("</td>");
            htmlContent.append("<td style='background-color:#F2F2F2;'>").append(oz.getOrdQtyZong() == 0 ? "" : oz.getOrdQtyZong()).append("</td>");

        }else {
            htmlContent.append("<td>").append(oz.getFactory()).append("</td>");
            htmlContent.append("<td>").append(oz.getBrandNo()).append("</td>");
            //已滿單
            htmlContent.append("<td>").append(oz.getOrderAuto1() == 0 ? "" : oz.getOrderAuto1()).append("</td>");
            htmlContent.append("<td>").append(oz.getOrdQty1() == 0 ? "" : oz.getOrdQty1()).append("</td>");


            //未滿單
            htmlContent.append("<td>").append(oz.getOrderAuto2() == 0 ? "" : oz.getOrderAuto2()).append("</td>");
            htmlContent.append("<td>").append(oz.getNotinQty2() == 0 ? "" : oz.getNotinQty2()).append("</td>");
            htmlContent.append("<td>").append(oz.getOrdQty2() == 0 ? "" : oz.getOrdQty2()).append("</td>");

            //總計
            htmlContent.append("<td>").append(oz.getOrderAutoZong() == 0 ? "" : oz.getOrderAutoZong()).append("</td>");
            htmlContent.append("<td>").append(oz.getNotinQtyZong() == 0 ? "" : oz.getNotinQtyZong()).append("</td>");
            htmlContent.append("<td>").append(oz.getOrdQtyZong() == 0 ? "" : oz.getOrdQtyZong()).append("</td>");

        }
        return htmlContent;
    }


    private StringBuilder appendAll5Qty(StringBuilder htmlContent, OutViewZong5 oz) {
        if(StringUtils.equals(oz.getBrandNo(),"一區 合計")|| StringUtils.equals(oz.getBrandNo(),"二區 合計")) {
            htmlContent.append("<td style='background-color:#f0fff0;'>").append(oz.getFactory()).append("</td>");
            htmlContent.append("<td style='background-color:#f0fff0;'>").append(oz.getBrandNo()).append("</td>");
            //已滿單
            htmlContent.append("<td style='background-color:#f0fff0;'>").append(oz.getOrderAuto1() == 0 ? "" : oz.getOrderAuto1()).append("</td>");
            htmlContent.append("<td style='background-color:#f0fff0;'>").append(oz.getOrdQty1() == 0 ? "" : oz.getOrdQty1()).append("</td>");


            //未滿單
            htmlContent.append("<td style='background-color:#f0fff0;'>").append(oz.getOrderAuto2() == 0 ? "" : oz.getOrderAuto2()).append("</td>");
            htmlContent.append("<td style='background-color:#f0fff0;'>").append(oz.getNotinQty2() == 0 ? "" : oz.getNotinQty2()).append("</td>");
            htmlContent.append("<td style='background-color:#f0fff0;'>").append(oz.getOrdQty2() == 0 ? "" : oz.getOrdQty2()).append("</td>");

            //總計
            htmlContent.append("<td style='background-color:#f0fff0;'>").append(oz.getOrderAutoZong() == 0 ? "" : oz.getOrderAutoZong()).append("</td>");
            htmlContent.append("<td style='background-color:#f0fff0;'>").append(oz.getNotinQtyZong() == 0 ? "" : oz.getNotinQtyZong()).append("</td>");
            htmlContent.append("<td style='background-color:#f0fff0;'>").append(oz.getOrdQtyZong() == 0 ? "" : oz.getOrdQtyZong()).append("</td>");
        }else if(StringUtils.equals(oz.getBrandNo(),"AL 總計")||StringUtils.equals(oz.getBrandNo(),"GN 總計")
                ||StringUtils.equals(oz.getBrandNo(),"TP 總計")){

            htmlContent.append("<td style='background-color:#90ee90;'>").append(oz.getFactory()).append("</td>");
            htmlContent.append("<td style='background-color:#90ee90;'>").append(oz.getBrandNo()).append("</td>");
            //已滿單
            htmlContent.append("<td style='background-color:#90ee90;'>").append(oz.getOrderAuto1() == 0 ? "" : oz.getOrderAuto1()).append("</td>");
            htmlContent.append("<td style='background-color:#90ee90;'>").append(oz.getOrdQty1() == 0 ? "" : oz.getOrdQty1()).append("</td>");


            //未滿單
            htmlContent.append("<td style='background-color:#90ee90;'>").append(oz.getOrderAuto2() == 0 ? "" : oz.getOrderAuto2()).append("</td>");
            htmlContent.append("<td style='background-color:#90ee90;'>").append(oz.getNotinQty2() == 0 ? "" : oz.getNotinQty2()).append("</td>");
            htmlContent.append("<td style='background-color:#90ee90;'>").append(oz.getOrdQty2() == 0 ? "" : oz.getOrdQty2()).append("</td>");

            //總計
            htmlContent.append("<td style='background-color:#90ee90;'>").append(oz.getOrderAutoZong() == 0 ? "" : oz.getOrderAutoZong()).append("</td>");
            htmlContent.append("<td style='background-color:#90ee90;'>").append(oz.getNotinQtyZong() == 0 ? "" : oz.getNotinQtyZong()).append("</td>");
            htmlContent.append("<td style='background-color:#90ee90;'>").append(oz.getOrdQtyZong() == 0 ? "" : oz.getOrdQtyZong()).append("</td>");

        }else if(StringUtils.equals(oz.getBrandNo(),"VN 總計")){
            htmlContent.append("<td style='background-color:#F2F2F2;'>").append(oz.getFactory()).append("</td>");
            htmlContent.append("<td style='background-color:#F2F2F2;'>").append(oz.getBrandNo()).append("</td>");
            //已滿單
            htmlContent.append("<td style='background-color:#F2F2F2;'>").append(oz.getOrderAuto1() == 0 ? "" : oz.getOrderAuto1()).append("</td>");
            htmlContent.append("<td style='background-color:#F2F2F2;'>").append(oz.getOrdQty1() == 0 ? "" : oz.getOrdQty1()).append("</td>");


            //未滿單
            htmlContent.append("<td style='background-color:#F2F2F2;'>").append(oz.getOrderAuto2() == 0 ? "" : oz.getOrderAuto2()).append("</td>");
            htmlContent.append("<td style='background-color:#F2F2F2;'>").append(oz.getNotinQty2() == 0 ? "" : oz.getNotinQty2()).append("</td>");
            htmlContent.append("<td style='background-color:#F2F2F2;'>").append(oz.getOrdQty2() == 0 ? "" : oz.getOrdQty2()).append("</td>");

            //總計
            htmlContent.append("<td style='background-color:#F2F2F2;'>").append(oz.getOrderAutoZong() == 0 ? "" : oz.getOrderAutoZong()).append("</td>");
            htmlContent.append("<td style='background-color:#F2F2F2;'>").append(oz.getNotinQtyZong() == 0 ? "" : oz.getNotinQtyZong()).append("</td>");
            htmlContent.append("<td style='background-color:#F2F2F2;'>").append(oz.getOrdQtyZong() == 0 ? "" : oz.getOrdQtyZong()).append("</td>");

        }else {
            htmlContent.append("<td>").append(oz.getFactory()).append("</td>");
            htmlContent.append("<td>").append(oz.getBrandNo()).append("</td>");
            //已滿單
            htmlContent.append("<td>").append(oz.getOrderAuto1() == 0 ? "" : oz.getOrderAuto1()).append("</td>");
            htmlContent.append("<td>").append(oz.getOrdQty1() == 0 ? "" : oz.getOrdQty1()).append("</td>");


            //未滿單
            htmlContent.append("<td>").append(oz.getOrderAuto2() == 0 ? "" : oz.getOrderAuto2()).append("</td>");
            htmlContent.append("<td>").append(oz.getNotinQty2() == 0 ? "" : oz.getNotinQty2()).append("</td>");
            htmlContent.append("<td>").append(oz.getOrdQty2() == 0 ? "" : oz.getOrdQty2()).append("</td>");

            //總計
            htmlContent.append("<td>").append(oz.getOrderAutoZong() == 0 ? "" : oz.getOrderAutoZong()).append("</td>");
            htmlContent.append("<td>").append(oz.getNotinQtyZong() == 0 ? "" : oz.getNotinQtyZong()).append("</td>");
            htmlContent.append("<td>").append(oz.getOrdQtyZong() == 0 ? "" : oz.getOrdQtyZong()).append("</td>");

        }

        return htmlContent;
    }
}

