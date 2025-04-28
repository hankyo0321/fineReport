package com.hank.fineReport.report.service;

import com.hank.fineReport.report.model.*;
import com.hank.fineReport.report.repository.*;
import com.hank.fineReport.report.repository.mapper.FinanceaMapper;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import jakarta.mail.internet.MimeMessage;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class MailService {

    @Value("${sevenday.Unfulfilled.order.details}")
    private String sevenUnfulfilledUrl;

    @Value("${expired.Unfulfilled.order.details}")
    private String expiredUnfulfilledUrl;

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

    @Autowired
    private FormatMailService formatMailService;

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
     * 未滿單預警數據總表 (安老)
     * @throws MessagingException
     */
    public void sendfilledTotalMailAL() throws MessagingException {

        /**
         * 未滿單預警數據總表
         */
        LocalDate today = LocalDate.now();
        LocalDateTime startOfDay = LocalDate.now().atStartOfDay();

        StringBuilder htmlContent = new StringBuilder();

        htmlContent.append("<h2>【預警-未滿單&成型未開補】安老廠 【Cảnh báo-chưa đủ đơn&Thành hình chưa khai bù】Xưởng An Lão</h2>");
        htmlContent.append("<table border='1' cellpadding='5' cellspacing='0' style='border-collapse: collapse;'>");
        htmlContent.append("<tr style='background-color:#007bff;color:white;'>");
        htmlContent.append("<th>預警名稱</th><th>預警週期</th><th>責任單位</th><th>AL</th><th>備註</th>");
        htmlContent.append("</tr>");


        //訂單距離客人交期7 天未滿單
        Financea financeaAL = finceRepository.findByProIdSevenDaysANDFactoryAL(startOfDay);
        htmlContent.append("<tr>");
        htmlContent.append("<td>").append("訂單距離客人交期7天未滿單\n" +
                "Đơn hàng cách ngày xuất hàng của khách hàng 7 ngày chưa đủ đơn").append("</td>");
        htmlContent.append("<td>").append("周一至周六\n" +
                "Từ thứ 2 đến thứ 7").append("</td>");
        htmlContent.append("<td>").append("生管\n" +
                "Sinh Quản").append("</td>");
        htmlContent.append("<td>").append(financeaAL.getProNum()).append("</td>");
        htmlContent.append("<td rowspan='2'>").append("未滿單PO數\n" +
                "số lượng đơn chưa đủ đơn").append("</td>");
        htmlContent.append("</tr>");

        //訂單已過客人交期未滿單
        //zong2
        Financea financeaPastAL = finceRepository.findByProIdPastANDFactoryAL(startOfDay);
        htmlContent.append("<tr>");
        htmlContent.append("<td>").append("訂單已過客人交期未滿單\n" +
                "Đơn hàng chưa đủ đơn khi đã quá ngày xuất hàng của khách hàng").append("</td>");
        htmlContent.append("<td>").append("周一至周六\n" +
                "Từ thứ 2 đến thứ 7").append("</td>");
        htmlContent.append("<td>").append("生管\n" +
                "Sinh Quản").append("</td>");
        htmlContent.append("<td>").append(financeaPastAL.getProNum()).append("</td>");
        htmlContent.append("</tr>");

        //訂單距離客人交期10天未滿單成型未開補
        //zong3
        Financea financeaTenAL = finceRepository.findByProIdtenDaysANDFactoryAL(startOfDay);
        htmlContent.append("<tr>");
        htmlContent.append("<td>").append("訂單距離客人交期10天未滿單成型未開補\n" +
                "Đơn hàng cách ngày xuất hàng của khách hàng 10 ngày thành hình chưa khai bù").append("</td>");
        htmlContent.append("<td>").append("周一至周六\n" +
                "Từ thứ 2 đến thứ 7").append("</td>");
        htmlContent.append("<td>").append("生管\n" +
                "Sinh Quản").append("</td>");
        htmlContent.append("<td>").append(financeaTenAL.getProNum()).append("</td>");
        htmlContent.append("<td>").append("未開補工單數-大單\n" +
                "số đơn chưa khai bù - đơn to").append("</td>");
        htmlContent.append("</tr>");

        htmlContent.append("</table>");

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

//        String [] mailary = {"jay.xiao@stella.com.hk","hank.lin@stella.com.hk","demi.sun@stella.com.hk",
//        "joky.bai@stella.com.hk","soso.yang@stella.com.hk"};

//        helper.setTo(mailary);
        helper.setTo("hank.lin@stella.com.hk");

        helper.setFrom("eip.mail@stella.com.hk");

        helper.setSubject("【預警-未滿單&成型未開補】安老廠 【Cảnh báo-chưa đủ đơn&Thành hình chưa khai bù】Xưởng An Lão ");
        helper.setText(htmlContent.toString(), true);

        mailSender.send(message);



    }

    /**
     * 未滿單預警數據總表 (廣寧)
     * @throws MessagingException
     */
    public void sendfilledTotalMailGN() throws MessagingException {

        /**
         * 未滿單預警數據總表
         */
        LocalDate today = LocalDate.now();
        LocalDateTime startOfDay = LocalDate.now().atStartOfDay();

        StringBuilder htmlContent = new StringBuilder();

        htmlContent.append("<h2>【預警-未滿單&成型未開補】廣寧廠  【Cảnh báo-chưa đủ đơn&Thành hình chưa khai bù】xưởng Quảng Ninh</h2>");
        htmlContent.append("<table border='1' cellpadding='5' cellspacing='0' style='border-collapse: collapse;'>");
        htmlContent.append("<tr style='background-color:#007bff;color:white;'>");
        htmlContent.append("<th>預警名稱</th><th>預警週期</th><th>責任單位</th><th>AL</th><th>備註</th>");
        htmlContent.append("</tr>");


        //訂單距離客人交期7 天未滿單
        Financea financeaGN = finceRepository.findByProIdSevenDaysANDFactoryGN(startOfDay);
        htmlContent.append("<tr>");
        htmlContent.append("<td>").append("訂單距離客人交期7天未滿單\n" +
                "Đơn hàng cách ngày xuất hàng của khách hàng 7 ngày chưa đủ đơn").append("</td>");
        htmlContent.append("<td>").append("周一至周六\n" +
                "Từ thứ 2 đến thứ 7").append("</td>");
        htmlContent.append("<td>").append("生管\n" +
                "Sinh Quản").append("</td>");
        htmlContent.append("<td>").append(financeaGN.getProNum()).append("</td>");
        htmlContent.append("<td rowspan='2'>").append("未滿單PO數\n" +
                "số lượng đơn chưa đủ đơn").append("</td>");
        htmlContent.append("</tr>");

        //訂單已過客人交期未滿單
        //zong2
        Financea financeaPastGN = finceRepository.findByProIdPastANDFactoryGN(startOfDay);
        htmlContent.append("<tr>");
        htmlContent.append("<td>").append("訂單已過客人交期未滿單\n" +
                "Đơn hàng chưa đủ đơn khi đã quá ngày xuất hàng của khách hàng").append("</td>");
        htmlContent.append("<td>").append("周一至周六\n" +
                "Từ thứ 2 đến thứ 7").append("</td>");
        htmlContent.append("<td>").append("生管\n" +
                "Sinh Quản").append("</td>");
        htmlContent.append("<td>").append(financeaPastGN.getProNum()).append("</td>");
        htmlContent.append("</tr>");

        //訂單距離客人交期10天未滿單成型未開補
        //zong3
        Financea financeaTenGN = finceRepository.findByProIdtenDaysANDFactoryGN(startOfDay);
        htmlContent.append("<tr>");
        htmlContent.append("<td>").append("訂單距離客人交期10天未滿單成型未開補\n" +
                "Đơn hàng cách ngày xuất hàng của khách hàng 10 ngày thành hình chưa khai bù").append("</td>");
        htmlContent.append("<td>").append("周一至周六\n" +
                "Từ thứ 2 đến thứ 7").append("</td>");
        htmlContent.append("<td>").append("生管\n" +
                "Sinh Quản").append("</td>");
        htmlContent.append("<td>").append(financeaTenGN.getProNum()).append("</td>");
        htmlContent.append("<td>").append("未開補工單數-大單\n" +
                "số đơn chưa khai bù - đơn to").append("</td>");
        htmlContent.append("</tr>");

        htmlContent.append("</table>");

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

//        String [] mailary = {"jay.xiao@stella.com.hk","hank.lin@stella.com.hk","demi.sun@stella.com.hk",
//        "joky.bai@stella.com.hk","soso.yang@stella.com.hk"};

//        helper.setTo(mailary);
        helper.setTo("hank.lin@stella.com.hk");

        helper.setFrom("eip.mail@stella.com.hk");

        helper.setSubject("【預警-未滿單&成型未開補】廣寧廠  【Cảnh báo-chưa đủ đơn&Thành hình chưa khai bù】xưởng Quảng Ninh");
        helper.setText(htmlContent.toString(), true);

        mailSender.send(message);


    }



    /**
     * 未滿單預警數據總表 (太平)
     * @throws MessagingException
     */
    public void sendfilledTotalMailTP() throws MessagingException {

        /**
         * 未滿單預警數據總表
         */
        LocalDate today = LocalDate.now();
        LocalDateTime startOfDay = LocalDate.now().atStartOfDay();

        StringBuilder htmlContent = new StringBuilder();

        htmlContent.append("<h2>【預警-未滿單&成型未開補】太平廠   【Cảnh báo-chưa đủ đơn&Thành hình chưa khai bù】xưởng Thái Bình</h2>");
        htmlContent.append("<table border='1' cellpadding='5' cellspacing='0' style='border-collapse: collapse;'>");
        htmlContent.append("<tr style='background-color:#007bff;color:white;'>");
        htmlContent.append("<th>預警名稱</th><th>預警週期</th><th>責任單位</th><th>AL</th><th>備註</th>");
        htmlContent.append("</tr>");


        //訂單距離客人交期7 天未滿單
        Financea financeaTP = finceRepository.findByProIdSevenDaysANDFactoryTP(startOfDay);
        htmlContent.append("<tr>");
        htmlContent.append("<td>").append("訂單距離客人交期7天未滿單\n" +
                "Đơn hàng cách ngày xuất hàng của khách hàng 7 ngày chưa đủ đơn").append("</td>");
        htmlContent.append("<td>").append("周一至周六\n" +
                "Từ thứ 2 đến thứ 7").append("</td>");
        htmlContent.append("<td>").append("生管\n" +
                "Sinh Quản").append("</td>");
        htmlContent.append("<td>").append(financeaTP.getProNum()).append("</td>");
        htmlContent.append("<td rowspan='2'>").append("未滿單PO數\n" +
                "số lượng đơn chưa đủ đơn").append("</td>");
        htmlContent.append("</tr>");

        //訂單已過客人交期未滿單
        //zong2
        Financea financeaPastTP = finceRepository.findByProIdPastANDFactoryTP(startOfDay);
        htmlContent.append("<tr>");
        htmlContent.append("<td>").append("訂單已過客人交期未滿單\n" +
                "Đơn hàng chưa đủ đơn khi đã quá ngày xuất hàng của khách hàng").append("</td>");
        htmlContent.append("<td>").append("周一至周六\n" +
                "Từ thứ 2 đến thứ 7").append("</td>");
        htmlContent.append("<td>").append("生管\n" +
                "Sinh Quản").append("</td>");
        htmlContent.append("<td>").append(financeaPastTP.getProNum()).append("</td>");
        htmlContent.append("</tr>");

        //訂單距離客人交期10天未滿單成型未開補
        //zong3
        Financea financeaTenTP = finceRepository.findByProIdtenDaysANDFactoryTP(startOfDay);
        htmlContent.append("<tr>");
        htmlContent.append("<td>").append("訂單距離客人交期10天未滿單成型未開補\n" +
                "Đơn hàng cách ngày xuất hàng của khách hàng 10 ngày thành hình chưa khai bù").append("</td>");
        htmlContent.append("<td>").append("周一至周六\n" +
                "Từ thứ 2 đến thứ 7").append("</td>");
        htmlContent.append("<td>").append("生管\n" +
                "Sinh Quản").append("</td>");
        htmlContent.append("<td>").append(financeaTenTP.getProNum()).append("</td>");
        htmlContent.append("<td>").append("未開補工單數-大單\n" +
                "số đơn chưa khai bù - đơn to").append("</td>");
        htmlContent.append("</tr>");

        htmlContent.append("</table>");

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

//        String [] mailary = {"jay.xiao@stella.com.hk","hank.lin@stella.com.hk","demi.sun@stella.com.hk",
//        "joky.bai@stella.com.hk","soso.yang@stella.com.hk"};

//        helper.setTo(mailary);
        helper.setTo("hank.lin@stella.com.hk");

        helper.setFrom("eip.mail@stella.com.hk");

        helper.setSubject("【預警-未滿單&成型未開補】太平廠   【Cảnh báo-chưa đủ đơn&Thành hình chưa khai bù】xưởng Thái Bình");
        helper.setText(htmlContent.toString(), true);

        mailSender.send(message);


    }




//    /**
//     * 未開補總表-訂單距離客人交期10天未滿單未開補
//     * @throws MessagingException
//     */
//    public  void sendNotOpenForReplenishmentMail()  throws MessagingException{
//        LocalDate today = LocalDate.now();
//        LocalDateTime startOfDay = LocalDate.now().atStartOfDay();
//
//        StringBuilder htmlContent = new StringBuilder();
//        //TODO 請確認資料
////        List<Financea> financeas = finceRepository.findByProIdSevenDaysANDFactory(startOfDay);
//
//
//        htmlContent.append("<h2>成型未開補數據匯總報表--生管</h2>");
//        htmlContent.append("<table border='1' cellpadding='5' cellspacing='0' style='border-collapse: collapse;'>");
//        htmlContent.append("<tr style='background-color:#007bff;color:white;'>");
//        htmlContent.append("<th>預警名稱</th><th>預警週期</th><th>責任單位</th>");
//
//        htmlContent.append("</tr>");
//
//        //訂單距離客人交期10天未滿單成型未開補
//        htmlContent.append("<tr>");
//        htmlContent.append("<td rowspan='2'>").append("訂單距離客人交期10天未滿單成型未開補").append("</td>");
//        htmlContent.append("<td rowspan='2'>").append("周一至周六").append("</td>");
//        htmlContent.append("<td rowspan='2'>").append("生管").append("</td>");
//        //
//
////        for (Financea financea : financeas) {
//////            String url = (i < URLary.length) ? URLary[i] : "#"; // 避免超出陣列範圍
////            String url ="http://10.10.250.213:8080/fr/decision/view/report?viewlet=%25E8%25A8%2582%25E5%2596%25AE%25E8%25B7%259D%25E9%259B%25A2%25E5%25AE%25A2%25E4%25BA%25BA%25E4%25BA%25A4%25E6%259C%259F10%25E5%25A4%25A9%25E6%259C%25AA%25E6%25BB%25BF%25E5%2596%25AE%25E6%259C%25AA%25E9%2596%258B%25E8%25A3%259C%25E6%2598%258E%25E7%25B4%25B0.cpt&ref_t=design&op=write&ref_c=7ea01938-6795-4586-a6b1-f5fe23634361";
////            htmlContent.append("<td style='width:100px; text-align:center;'>")
////                    .append("<a href='").append(url).append("' target='_blank' style='color:blue; text-decoration: none;'>")
////                    .append("<b>").append(financea.getProNum()).append("</b></a>")
////                    .append("</td>");
////        }
//        htmlContent.append("</tr>");
//
//        htmlContent.append("<tr>");
//        htmlContent.append("<td  style='text-align:center;'>").append("陶氏玉").append("</td>");
//        htmlContent.append("<td  style='text-align:center;'>").append("蒋够粮").append("</td>");
//        htmlContent.append("<td  style='text-align:center;'>").append("刘萍").append("</td>");
//        htmlContent.append("</tr>");
//        htmlContent.append("</table>");
//
//
//        //訂單距離客人交期10天未滿單未開補
//        htmlContent.append("<h2>訂單距離客人交期10天未滿單未開補</h2>");
//        htmlContent.append("<table border='1' cellpadding='5' cellspacing='0' style='width: 100% ;  table-layout: auto; text-align: center; border-collapse: collapse;'>");
//        htmlContent.append("<thead>");
//        htmlContent.append("<tr style='background-color:white;color:black;'>");
//        htmlContent.append("<th rowspan='2' style='border: 1px solid black; min-width: 150px;'>").append("工廠").append("</th>");
//        htmlContent.append("<th rowspan='2' style='border: 1px solid black; min-width: 150px;'>").append("品牌名稱").append("</th>");
//
//        htmlContent.append("<th colspan='4' style='text-align:center; border: 1px solid black; width: 180px; color:blue;'>").append("已生產").append("</th>");
//        htmlContent.append("<th colspan='4' style='text-align:center; border: 1px solid black; width: 180px; color:red;' >").append("未生產").append("</th>");
//        htmlContent.append("<th colspan='4' style='text-align:center; border: 1px solid black; width: 180px;'>").append("總計").append("</th>");
//        htmlContent.append("</tr>");
//
//        /**
//         *   訂單距離客人交期7 天未滿單
//         */
//        htmlContent.append("<tr>");
//        for(int x = 0;x<=2 ;x++){
//            htmlContent.append("<th rowspan='2' style='border: 1px solid black; padding: 10px; width: 100px; white-space: nowrap;'>").append("工單數").append("</th>");
//            htmlContent.append("<th rowspan='2' style='border: 1px solid black; padding: 10px; width: 100px; white-space: nowrap;'>").append("PO數").append("</th>");
//            htmlContent.append("<th rowspan='2' style='border: 1px solid black; padding: 10px; width: 100px; white-space: nowrap;'>").append("欠雙數").append("</th>");
//            htmlContent.append("<th rowspan='2' style='border: 1px solid black; padding: 10px; width: 100px; white-space: nowrap;'>").append("訂單雙數").append("</th>");
//        }
//        htmlContent.append("</tr>");
//        htmlContent.append("</thead>");
//
//        //資料部分
//        htmlContent.append("<tbody>");
//        List<OutViewZong3> outViewZong3ListList = outViewZong3Repository.getov3();
//        if(CollectionUtils.isEmpty(outViewZong3ListList)){
//            throw new MessagingException("查無資料");
//        }
//        for(OutViewZong3 oz:outViewZong3ListList){
//            if (oz==null){
//                break;
//            }
//            htmlContent.append("<tr>");
//
//            formatMailService.appendNotOpenForReplenishmentMail(htmlContent , oz);
//
//            htmlContent.append("</tr>");
//        }
//        htmlContent.append("</tbody>");
//
//        htmlContent.append("</table>");
//        MimeMessage message = mailSender.createMimeMessage();
//        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
//
////        String [] mailary = {"jay.xiao@stella.com.hk","hank.lin@stella.com.hk","demi.sun@stella.com.hk"};
////        String [] mailary = {"jay.xiao@stella.com.hk","hank.lin@stella.com.hk","demi.sun@stella.com.hk",
////                "joky.bai@stella.com.hk","soso.yang@stella.com.hk"};
//
////        helper.setTo(mailary);
//        helper.setTo("hank.lin@stella.com.hk");
//        helper.setFrom("eip.mail@stella.com.hk");
//        helper.setSubject("成型未開補數據匯總報表--生管");
//        helper.setText(htmlContent.toString(), true);
//
//        mailSender.send(message);
//
//    }


//    public void sendNotCheckMail()  throws MessagingException{
//        LocalDateTime startOfDay = LocalDate.now().atStartOfDay();
////        List<Financea> financeas = finceRepository.findByProIdSevenDaysANDFactory(startOfDay);
//        //訂單已過客人交期未滿單
////        List<Financea> financeaList = finceRepository.findByProIdPast(startOfDay);
//        /**
//         * Table 3
//         * 未驗貨預警數據匯總報表--品管
//         */
//        StringBuilder htmlContent = new StringBuilder();
//        htmlContent.append("<h2>未驗貨預警數據匯總報表--品管</h2>");
//        htmlContent.append("<table border='1' cellpadding='5' cellspacing='0' style='border-collapse: collapse;'>");
//        htmlContent.append("<tr style='background-color:#007bff;color:white;'>");
//        htmlContent.append("<th>預警名稱</th><th>預警週期</th><th>責任單位</th>");
////        for (Financea financea : financeas) {
////            htmlContent.append("<th>").append(financea.getFactory()).append("</th>");
////        }
//        htmlContent.append("</tr>");
//
//
//        //訂單距離客人交期7 天未滿單
//        htmlContent.append("<tr>");
//        htmlContent.append("<td rowspan='2'>").append("訂單距離客人交期7天未滿單").append("</td>");
//        htmlContent.append("<td rowspan='2'>").append("周一至周六").append("</td>");
//        htmlContent.append("<td rowspan='2'>").append("生管").append("</td>");
//        //zong4
//
////        for (Financea financea : financeas) {
////            String url ="http://10.10.250.213:8080/fr/decision/view/report?viewlet=%25E8%25A8%2582%25E5%2596%25AE%25E8%25B7%259D%25E9%259B%25A2%25E5%25AE%25A2%25E4%25BA%25BA%25E4%25BA%25A4%25E6%259C%259F7%25E5%25A4%25A9%25E6%259C%25AA%25E9%25A9%2597%25E8%25B2%25A8%25E6%2598%258E%25E7%25B4%25B0.cpt&ref_t=design&op=write&ref_c=7ea01938-6795-4586-a6b1-f5fe23634361";
////            htmlContent.append("<td style='width:100px; text-align:center;'>")
////                    .append("<a href='").append(url).append("' target='_blank' style='color:blue; text-decoration: none;'>")
////                    .append("<b>").append(financea.getProNum()).append("</b></a>")
////                    .append("</td>");
////        }
//        htmlContent.append("</tr>");
//
//        htmlContent.append("<tr>");
//        htmlContent.append("<td style='text-align :center;'>").append("黃氏娥").append("</td>");
//        htmlContent.append("<td style='text-align :center;'>").append("范氏雲").append("</td>");
//        htmlContent.append("<td style='text-align :center;'>").append("阮氏寧").append("</td>");
//        htmlContent.append("</tr>");
//
//        //訂單已過客人交期未滿單
//        htmlContent.append("<tr>");
//        htmlContent.append("<td rowspan='2'>").append("訂單已過客人交期未滿單").append("</td>");
//        htmlContent.append("<td rowspan='2'>").append("周一至周六").append("</td>");
//        htmlContent.append("<td rowspan='2'>").append("生管").append("</td>");
//        //ZONG5
//
////        for (Financea financea : financeas) {
//////            String url = (a < URLary.length) ? URLary[a] : "#"; // 避免超出陣列範圍
////            String url = "http://10.10.250.213:8080/fr/decision/view/report?viewlet=%25E8%25A8%2582%25E5%2596%25AE%25E5%25B7%25B2%25E9%2581%258E%25E5%25AE%25A2%25E4%25BA%25BA%25E4%25BA%25A4%25E6%259C%259F%25E6%259C%25AA%25E9%25A9%2597%25E8%25B2%25A8%25E6%2598%258E%25E7%25B4%25B0.cpt&ref_t=design&op=write&ref_c=7ea01938-6795-4586-a6b1-f5fe23634361";
////            htmlContent.append("<td style='width:100px; text-align:center;'>")
////                    .append("<a href='").append(url).append("' target='_blank' style='color:blue; text-decoration: none;'>")
////                    .append("<b>").append(financea.getProNum()).append("</b></a>")
////                    .append("</td>");
////        }
//        htmlContent.append("</tr>");
//
//        htmlContent.append("<tr>");
//        htmlContent.append("<td style='text-align :center;'>").append("黃氏娥").append("</td>");
//        htmlContent.append("<td style='text-align :center;'>").append("范氏雲").append("</td>");
//        htmlContent.append("<td style='text-align :center;'>").append("阮氏寧").append("</td>");
//        htmlContent.append("</tr>");
//        htmlContent.append("</table>");
//
//        //訂單距離客人交期7天未驗貨總表
//        htmlContent.append("<h2>訂單距離客人交期7天未驗貨</h2>");
//        htmlContent.append("<table border='1' cellpadding='5' cellspacing='0' style='width: 100% ;  table-layout: auto; text-align: center; border-collapse: collapse;'>");
//        htmlContent.append("<thead>");
//        htmlContent.append("<tr style='background-color:white;color:black;'>");
//        htmlContent.append("<th rowspan='2' style='border: 1px solid black; min-width: 150px;'>").append("工廠").append("</th>");
//        htmlContent.append("<th rowspan='2' style='border: 1px solid black; min-width: 150px;'>").append("品牌名稱").append("</th>");
//
//        htmlContent.append("<th colspan='2' style='text-align:center; border: 1px solid black; width: 180px; color:blue;'>").append("已滿單").append("</th>");
//        htmlContent.append("<th colspan='3' style='text-align:center; border: 1px solid black; width: 180px; color:red;' >").append("未滿單").append("</th>");
//        htmlContent.append("<th colspan='3' style='text-align:center; border: 1px solid black; width: 180px;'>").append("總計").append("</th>");
//        htmlContent.append("</tr>");
//
//        /**
//         *   訂單距離客人交期7 天未滿單
//         */
//        htmlContent.append("<tr>");
//        for(int x = 0;x<=2 ;x++){
//            if(x==0){
//                htmlContent.append("<th rowspan='2' style='border: 1px solid black; padding: 10px; width: 100px; white-space: nowrap;'>").append("PO數").append("</th>");
//                htmlContent.append("<th rowspan='2' style='border: 1px solid black; padding: 10px; width: 100px; white-space: nowrap;'>").append("訂單雙數").append("</th>");
//            }else{
//                htmlContent.append("<th rowspan='2' style='border: 1px solid black; padding: 10px; width: 100px; white-space: nowrap;'>").append("PO數").append("</th>");
//                htmlContent.append("<th rowspan='2' style='border: 1px solid black; padding: 10px; width: 100px; white-space: nowrap;'>").append("欠雙數").append("</th>");
//                htmlContent.append("<th rowspan='2' style='border: 1px solid black; padding: 10px; width: 100px; white-space: nowrap;'>").append("訂單雙數").append("</th>");
//            }
//        }
//        htmlContent.append("</tr>");
//        htmlContent.append("</thead>");
//
//        //資料部分
//        htmlContent.append("<tbody>");
//        List<OutViewZong4> outViewZong4List = outViewZong4Repository.getov4();
//        if(CollectionUtils.isEmpty(outViewZong4List)){
//            throw new MessagingException("查無資料");
//        }
//        for(OutViewZong4 oz:outViewZong4List){
//            if (oz==null){
//                break;
//            }
//            htmlContent.append("<tr>");
//
//            formatMailService.appendAll4Qty(htmlContent , oz);
//
//            htmlContent.append("</tr>");
//        }
//        htmlContent.append("</tbody>");
//
//
//        htmlContent.append("</table>");
//
//
//
//        /***********************************************/
//        //訂單已過客人交期未驗貨
//        htmlContent.append("<h2>訂單已過客人交期未驗貨</h2>");
//        htmlContent.append("<table border='1' cellpadding='5' cellspacing='0' style='width: 100% ;  table-layout: auto; text-align: center; border-collapse: collapse;'>");
//        htmlContent.append("<thead>");
//        htmlContent.append("<tr style='background-color:white;color:black;'>");
//        htmlContent.append("<th rowspan='2' style='border: 1px solid black; min-width: 150px;'>").append("工廠").append("</th>");
//        htmlContent.append("<th rowspan='2' style='border: 1px solid black; min-width: 150px;'>").append("品牌名稱").append("</th>");
//
//        htmlContent.append("<th colspan='2' style='text-align:center; border: 1px solid black; width: 180px; color:blue;'>").append("已滿單").append("</th>");
//        htmlContent.append("<th colspan='3' style='text-align:center; border: 1px solid black; width: 180px; color:red;' >").append("未滿單").append("</th>");
//        htmlContent.append("<th colspan='3' style='text-align:center; border: 1px solid black; width: 180px;'>").append("總計").append("</th>");
//        htmlContent.append("</tr>");
//
//        /**
//         *   訂單距離客人交期7 天未滿單
//         */
//        htmlContent.append("<tr>");
//        for(int y = 0;y<=2 ;y++){
//            if(y==0){
//                htmlContent.append("<th rowspan='2' style='border: 1px solid black; padding: 10px; width: 100px; white-space: nowrap;'>").append("PO數").append("</th>");
//                htmlContent.append("<th rowspan='2' style='border: 1px solid black; padding: 10px; width: 100px; white-space: nowrap;'>").append("訂單雙數").append("</th>");
//            }else{
//                htmlContent.append("<th rowspan='2' style='border: 1px solid black; padding: 10px; width: 100px; white-space: nowrap;'>").append("PO數").append("</th>");
//                htmlContent.append("<th rowspan='2' style='border: 1px solid black; padding: 10px; width: 100px; white-space: nowrap;'>").append("欠雙數").append("</th>");
//                htmlContent.append("<th rowspan='2' style='border: 1px solid black; padding: 10px; width: 100px; white-space: nowrap;'>").append("訂單雙數").append("</th>");
//            }
//        }
//        htmlContent.append("</tr>");
//        htmlContent.append("</thead>");
//
//        //資料部分
//        htmlContent.append("<tbody>");
//        List<OutViewZong5> outViewZong5List = outViewZong5Repository.getov5();
//        if(CollectionUtils.isEmpty(outViewZong5List)){
//            throw new MessagingException("查無資料");
//        }
//        for(OutViewZong5 oz:outViewZong5List){
//            if (oz==null){
//                break;
//            }
//            htmlContent.append("<tr>");
//
//            formatMailService.appendAll5Qty(htmlContent , oz);
//
//            htmlContent.append("</tr>");
//        }
//        htmlContent.append("</tbody>");
//
//
//        htmlContent.append("</table>");
//
//        MimeMessage message = mailSender.createMimeMessage();
//        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
//
//        String [] mailary = {"jay.xiao@stella.com.hk","hank.lin@stella.com.hk"};
////        String [] mailary = {"jay.xiao@stella.com.hk","hank.lin@stella.com.hk","demi.sun@stella.com.hk",
////                "joky.bai@stella.com.hk","soso.yang@stella.com.hk"};
//
////        helper.setTo(mailary);
//        helper.setTo("hank.lin@stella.com.hk");
//        helper.setFrom("eip.mail@stella.com.hk");
//        helper.setSubject("未驗貨預警數據匯總報表--品管");
//        helper.setText(htmlContent.toString(), true);
//
//        mailSender.send(message);
//
//    }





    /**
     * 未驗貨預警數據總表 (安老)
     * @throws MessagingException
     */
    public void sendNoCheckTotalMailAL() throws MessagingException {

        /**
         * 未滿單預警數據總表
         */
        LocalDate today = LocalDate.now();
        LocalDateTime startOfDay = LocalDate.now().atStartOfDay();

        StringBuilder htmlContent = new StringBuilder();

        htmlContent.append("<h2>訂單距離客人交期7天未驗貨\n" +
                "Đơn hàng cách ngày xuất hàng của khách hàng 7 ngày chưa kiểm hàng</h2>");
        htmlContent.append("<table border='1' cellpadding='5' cellspacing='0' style='border-collapse: collapse;'>");
        htmlContent.append("<tr style='background-color:#007bff;color:white;'>");
        htmlContent.append("<th>預警名稱</th><th>預警週期</th><th>責任單位</th><th>AL</th><th>備註</th>");
        htmlContent.append("</tr>");


        //訂單距離客人交期7 天未驗貨
        Financea financeaNoCheckAL = finceRepository.findByProIdNoCheckSevenDaysANDFactoryAL(startOfDay);
        htmlContent.append("<tr>");
        htmlContent.append("<td>").append("訂單距離客人交期7天未驗貨\n" +
                "Đơn hàng cách ngày xuất hàng của khách hàng 7 ngày chưa kiểm hàng").append("</td>");
        htmlContent.append("<td>").append("周一至周六\n" +
                "Từ thứ 2 đến thứ 7").append("</td>");
        htmlContent.append("<td>").append("品管\n" +
                "Phòng kiểm tra chất lượng").append("</td>");
        htmlContent.append("<td>").append(financeaNoCheckAL.getProNum()).append("</td>");
        htmlContent.append("<td rowspan='2'>").append("未驗貨PO數\n" +
                "Số lượng đơn chưa kiểm hàng").append("</td>");
        htmlContent.append("</tr>");

        //訂單已過客人交期未驗貨
        //zong2
        Financea financeaNoCheckPastAL = finceRepository.findByProIdNoCheckPastANDFactoryAL(startOfDay);
        htmlContent.append("<tr>");
        htmlContent.append("<td>").append("訂單已過客人交期未驗貨\n" +
                "Đơn hàng chưa kiểm hàng khi quá ngày xuất hàng của khách hàng").append("</td>");
        htmlContent.append("<td>").append("周一至周六\n" +
                "Từ thứ 2 đến thứ 7").append("</td>");
        htmlContent.append("<td>").append("品管\n" +
                "Phòng kiểm tra chất lượng").append("</td>");
        htmlContent.append("<td>").append(financeaNoCheckPastAL.getProNum()).append("</td>");
        htmlContent.append("</tr>");

        htmlContent.append("</table>");

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

//        String [] mailary = {"jay.xiao@stella.com.hk","hank.lin@stella.com.hk","demi.sun@stella.com.hk",
//        "joky.bai@stella.com.hk","soso.yang@stella.com.hk"};

//        helper.setTo(mailary);
        helper.setTo("hank.lin@stella.com.hk");

        helper.setFrom("eip.mail@stella.com.hk");

        helper.setSubject("【預警-未滿單&成型未開補】安老廠 【Cảnh báo-chưa đủ đơn&Thành hình chưa khai bù】Xưởng An Lão ");
        helper.setText(htmlContent.toString(), true);

        mailSender.send(message);



    }



    /**
     * 未驗貨預警數據總表 (廣寧)
     * @throws MessagingException
     */
    public void sendNoCheckTotalMailGN() throws MessagingException {

        /**
         * 未滿單預警數據總表
         */
        LocalDate today = LocalDate.now();
        LocalDateTime startOfDay = LocalDate.now().atStartOfDay();

        StringBuilder htmlContent = new StringBuilder();

        htmlContent.append("<h2>【預警-未滿單&成型未開補】安老廠 【Cảnh báo-chưa đủ đơn&Thành hình chưa khai bù】Xưởng An Lão</h2>");
        htmlContent.append("<table border='1' cellpadding='5' cellspacing='0' style='border-collapse: collapse;'>");
        htmlContent.append("<tr style='background-color:#007bff;color:white;'>");
        htmlContent.append("<th>預警名稱</th><th>預警週期</th><th>責任單位</th><th>AL</th><th>備註</th>");
        htmlContent.append("</tr>");


        //訂單距離客人交期7 天未驗貨
        Financea financeaNoCheckGN = finceRepository.findByProIdNoCheckSevenDaysANDFactoryGN(startOfDay);
        htmlContent.append("<tr>");
        htmlContent.append("<td>").append("訂單距離客人交期7天未驗貨\n" +
                "Đơn hàng cách ngày xuất hàng của khách hàng 7 ngày chưa kiểm hàng").append("</td>");
        htmlContent.append("<td>").append("周一至周六\n" +
                "Từ thứ 2 đến thứ 7").append("</td>");
        htmlContent.append("<td>").append("品管\n" +
                "Phòng kiểm tra chất lượng").append("</td>");
        htmlContent.append("<td>").append(financeaNoCheckGN.getProNum()).append("</td>");
        htmlContent.append("<td rowspan='2'>").append("未驗貨PO數\n" +
                "Số lượng đơn chưa kiểm hàng").append("</td>");
        htmlContent.append("</tr>");

        //訂單已過客人交期未驗貨
        //zong2
        Financea financeaNoCheckPastGN = finceRepository.findByProIdNoCheckPastANDFactoryGN(startOfDay);
        htmlContent.append("<tr>");
        htmlContent.append("<td>").append("訂單已過客人交期未驗貨\n" +
                "Đơn hàng chưa kiểm hàng khi quá ngày xuất hàng của khách hàng").append("</td>");
        htmlContent.append("<td>").append("周一至周六\n" +
                "Từ thứ 2 đến thứ 7").append("</td>");
        htmlContent.append("<td>").append("品管\n" +
                "Phòng kiểm tra chất lượng").append("</td>");
        htmlContent.append("<td>").append(financeaNoCheckPastGN.getProNum()).append("</td>");
        htmlContent.append("</tr>");

        htmlContent.append("</table>");

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

//        String [] mailary = {"jay.xiao@stella.com.hk","hank.lin@stella.com.hk","demi.sun@stella.com.hk",
//        "joky.bai@stella.com.hk","soso.yang@stella.com.hk"};

//        helper.setTo(mailary);
        helper.setTo("hank.lin@stella.com.hk");

        helper.setFrom("eip.mail@stella.com.hk");

        helper.setSubject("【預警-未滿單&成型未開補】安老廠 【Cảnh báo-chưa đủ đơn&Thành hình chưa khai bù】Xưởng An Lão ");
        helper.setText(htmlContent.toString(), true);

        mailSender.send(message);



    }



    /**
     * 未驗貨預警數據總表 (廣寧)
     * @throws MessagingException
     */
    public void sendNoCheckTotalMailTP() throws MessagingException {

        /**
         * 未滿單預警數據總表
         */
        LocalDate today = LocalDate.now();
        LocalDateTime startOfDay = LocalDate.now().atStartOfDay();

        StringBuilder htmlContent = new StringBuilder();

        htmlContent.append("<h2>【預警-未滿單&成型未開補】安老廠 【Cảnh báo-chưa đủ đơn&Thành hình chưa khai bù】Xưởng An Lão</h2>");
        htmlContent.append("<table border='1' cellpadding='5' cellspacing='0' style='border-collapse: collapse;'>");
        htmlContent.append("<tr style='background-color:#007bff;color:white;'>");
        htmlContent.append("<th>預警名稱</th><th>預警週期</th><th>責任單位</th><th>AL</th><th>備註</th>");
        htmlContent.append("</tr>");


        //訂單距離客人交期7 天未驗貨
        Financea financeaNoCheckTP = finceRepository.findByProIdNoCheckSevenDaysANDFactoryTP(startOfDay);
        htmlContent.append("<tr>");
        htmlContent.append("<td>").append("訂單距離客人交期7天未驗貨\n" +
                "Đơn hàng cách ngày xuất hàng của khách hàng 7 ngày chưa kiểm hàng").append("</td>");
        htmlContent.append("<td>").append("周一至周六\n" +
                "Từ thứ 2 đến thứ 7").append("</td>");
        htmlContent.append("<td>").append("品管\n" +
                "Phòng kiểm tra chất lượng").append("</td>");
        htmlContent.append("<td>").append(financeaNoCheckTP.getProNum()).append("</td>");
        htmlContent.append("<td rowspan='2'>").append("未驗貨PO數\n" +
                "Số lượng đơn chưa kiểm hàng").append("</td>");
        htmlContent.append("</tr>");

        //訂單已過客人交期未驗貨
        //zong2
        Financea financeaNoCheckPastTP = finceRepository.findByProIdNoCheckPastANDFactoryTP(startOfDay);
        htmlContent.append("<tr>");
        htmlContent.append("<td>").append("訂單已過客人交期未驗貨\n" +
                "Đơn hàng chưa kiểm hàng khi quá ngày xuất hàng của khách hàng").append("</td>");
        htmlContent.append("<td>").append("周一至周六\n" +
                "Từ thứ 2 đến thứ 7").append("</td>");
        htmlContent.append("<td>").append("品管\n" +
                "Phòng kiểm tra chất lượng").append("</td>");
        htmlContent.append("<td>").append(financeaNoCheckPastTP.getProNum()).append("</td>");
        htmlContent.append("</tr>");

        htmlContent.append("</table>");

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

//        String [] mailary = {"jay.xiao@stella.com.hk","hank.lin@stella.com.hk","demi.sun@stella.com.hk",
//        "joky.bai@stella.com.hk","soso.yang@stella.com.hk"};

//        helper.setTo(mailary);
        helper.setTo("hank.lin@stella.com.hk");

        helper.setFrom("eip.mail@stella.com.hk");

        helper.setSubject("【預警-未滿單&成型未開補】安老廠 【Cảnh báo-chưa đủ đơn&Thành hình chưa khai bù】Xưởng An Lão ");
        helper.setText(htmlContent.toString(), true);

        mailSender.send(message);



    }


}

