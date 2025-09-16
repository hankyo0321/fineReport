package com.hank.fineReport.report.service;

import com.hank.fineReport.report.model.Financea;
import com.hank.fineReport.report.repository.*;
import com.hank.fineReport.report.repository.mapper.FinanceaMapper;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class MailTestService {

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
        htmlContent.append("<td>").append("訂單距離客人交期7天未滿單\n" + "<br>"+
                "Đơn hàng cách ngày xuất hàng của khách hàng 7 ngày chưa đủ đơn").append("</td>");
        htmlContent.append("<td>").append("周一至周六\n" + "<br>"+
                "Từ thứ 2 đến thứ 7").append("</td>");
        htmlContent.append("<td>").append("生管\n" + "<br>"+
                "Sinh Quản").append("</td>");
        htmlContent.append("<td><a href='http://10.10.250.213:8080/fr/decision/view/report?viewlet=%25E8%25A8%2582%25E5%2596%25AE%25E8%25B7%259D%25E9%259B%25A2%25E5%25AE%25A2%25E4%25BA%25BA%25E4%25BA%25A4%25E6%259C%259F7%25E5%25A4%25A9%25E6%259C%25AA%25E6%25BB%25BF%25E5%2596%25AE%25E6%2598%258E%25E7%25B4%25B0%2528AL%2529.cpt&ref_t=design&op=view&ref_c=024d58aa-f9b8-49b5-bc04-cffc341ea78b'>").append(financeaAL.getProNum()).append("</a></td>");
        htmlContent.append("<td rowspan='2'>").append("未滿單PO數\n" + "<br>"+
                "số lượng đơn chưa đủ đơn").append("</td>");
        htmlContent.append("</tr>");

        //訂單已過客人交期未滿單
        //zong2
        Financea financeaPastAL = finceRepository.findByProIdPastANDFactoryAL(startOfDay);
        htmlContent.append("<tr>");
        htmlContent.append("<td>").append("訂單已過客人交期未滿單\n" + "<br>"+
                "Đơn hàng chưa đủ đơn khi đã quá ngày xuất hàng của khách hàng").append("</td>");
        htmlContent.append("<td>").append("周一至周六\n" + "<br>"+
                "Từ thứ 2 đến thứ 7").append("</td>");
        htmlContent.append("<td>").append("生管\n" + "<br>"+
                "Sinh Quản").append("</td>");
        htmlContent.append("<td><a href='http://10.10.250.213:8080/fr/decision/view/report?viewlet=%25E8%25A8%2582%25E5%2596%25AE%25E5%25B7%25B2%25E9%2581%258E%25E5%25AE%25A2%25E4%25BA%25BA%25E4%25BA%25A4%25E6%259C%259F%25E6%259C%25AA%25E6%25BB%25BF%25E5%2596%25AE%25E6%2598%258E%25E7%25B4%25B0%2528AL%2529.cpt&ref_t=design&op=view&ref_c=024d58aa-f9b8-49b5-bc04-cffc341ea78b'>").append(financeaPastAL.getProNum()).append("</a></td>");
        htmlContent.append("</tr>");

        //訂單距離客人交期10天未滿單成型未開補
        //zong3
        Financea financeaTenAL = finceRepository.findByProIdtenDaysANDFactoryAL(startOfDay);
        htmlContent.append("<tr>");
        htmlContent.append("<td>").append("訂單距離客人交期10天未滿單成型未開補\n" + "<br>"+
                "Đơn hàng cách ngày xuất hàng của khách hàng 10 ngày thành hình chưa khai bù").append("</td>");
        htmlContent.append("<td>").append("周一至周六\n" + "<br>"+
                "Từ thứ 2 đến thứ 7").append("</td>");
        htmlContent.append("<td>").append("生管\n" + "<br>"+
                "Sinh Quản").append("</td>");
        htmlContent.append("<td><a href='http://10.10.250.213:8080/fr/decision/view/report?viewlet=%25E8%25A8%2582%25E5%2596%25AE%25E8%25B7%259D%25E9%259B%25A2%25E5%25AE%25A2%25E4%25BA%25BA%25E4%25BA%25A4%25E6%259C%259F10%25E5%25A4%25A9%25E6%259C%25AA%25E6%25BB%25BF%25E5%2596%25AE%25E6%259C%25AA%25E9%2596%258B%25E8%25A3%259C%25E6%2598%258E%25E7%25B4%25B0%2528AL%2529.cpt&ref_t=design&op=view&ref_c=024d58aa-f9b8-49b5-bc04-cffc341ea78b'>").append(financeaTenAL.getProNum()).append("</a></td>");
        htmlContent.append("<td>").append("未開補工單數-大單\n" + "<br>"+
                "số đơn chưa khai bù - đơn to").append("</td>");
        htmlContent.append("</tr>");

        htmlContent.append("</table>");

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
        

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
        htmlContent.append("<td>").append("訂單距離客人交期7天未滿單\n" +  "<br>"+
                "Đơn hàng cách ngày xuất hàng của khách hàng 7 ngày chưa đủ đơn").append("</td>");
        htmlContent.append("<td>").append("周一至周六\n" + "<br>"+
                "Từ thứ 2 đến thứ 7").append("</td>");
        htmlContent.append("<td>").append("生管\n" + "<br>"+
                "Sinh Quản").append("</td>");
        htmlContent.append("<td> <a href='http://10.10.250.213:8080/fr/decision/view/report?viewlet=%25E8%25A8%2582%25E5%2596%25AE%25E8%25B7%259D%25E9%259B%25A2%25E5%25AE%25A2%25E4%25BA%25BA%25E4%25BA%25A4%25E6%259C%259F7%25E5%25A4%25A9%25E6%259C%25AA%25E6%25BB%25BF%25E5%2596%25AE%25E6%2598%258E%25E7%25B4%25B0%2528GN%2529.cpt&ref_t=design&op=view&ref_c=024d58aa-f9b8-49b5-bc04-cffc341ea78b'>").append(financeaGN.getProNum()).append("</a></td>");
        htmlContent.append("<td rowspan='2'>").append("未滿單PO數\n" +  "<br>"+
                "số lượng đơn chưa đủ đơn").append("</td>");
        htmlContent.append("</tr>");

        //訂單已過客人交期未滿單
        //zong2
        Financea financeaPastGN = finceRepository.findByProIdPastANDFactoryGN(startOfDay);
        htmlContent.append("<tr>");
        htmlContent.append("<td>").append("訂單已過客人交期未滿單\n" +  "<br>"+
                "Đơn hàng chưa đủ đơn khi đã quá ngày xuất hàng của khách hàng").append("</td>");
        htmlContent.append("<td>").append("周一至周六\n" +  "<br>"+
                "Từ thứ 2 đến thứ 7").append("</td>");
        htmlContent.append("<td>").append("生管\n" +  "<br>"+
                "Sinh Quản").append("</td>");
        htmlContent.append("<td> <a href='http://10.10.250.213:8080/fr/decision/view/report?viewlet=%25E8%25A8%2582%25E5%2596%25AE%25E5%25B7%25B2%25E9%2581%258E%25E5%25AE%25A2%25E4%25BA%25BA%25E4%25BA%25A4%25E6%259C%259F%25E6%259C%25AA%25E6%25BB%25BF%25E5%2596%25AE%25E6%2598%258E%25E7%25B4%25B0%2528GN%2529.cpt&ref_t=design&op=view&ref_c=024d58aa-f9b8-49b5-bc04-cffc341ea78b'>").append(financeaPastGN.getProNum()).append("</a> </td>");
        htmlContent.append("</tr>");

        //訂單距離客人交期10天未滿單成型未開補
        //zong3
        Financea financeaTenGN = finceRepository.findByProIdtenDaysANDFactoryGN(startOfDay);
        htmlContent.append("<tr>");
        htmlContent.append("<td>").append("訂單距離客人交期10天未滿單成型未開補\n" +  "<br>"+
                "Đơn hàng cách ngày xuất hàng của khách hàng 10 ngày thành hình chưa khai bù").append("</td>");
        htmlContent.append("<td>").append("周一至周六\n" +  "<br>"+
                "Từ thứ 2 đến thứ 7").append("</td>");
        htmlContent.append("<td>").append("生管\n" + "<br>"+
                "Sinh Quản").append("</td>");
        htmlContent.append("<td> <a href='http://10.10.250.213:8080/fr/decision/view/report?viewlet=%25E8%25A8%2582%25E5%2596%25AE%25E8%25B7%259D%25E9%259B%25A2%25E5%25AE%25A2%25E4%25BA%25BA%25E4%25BA%25A4%25E6%259C%259F10%25E5%25A4%25A9%25E6%259C%25AA%25E6%25BB%25BF%25E5%2596%25AE%25E6%259C%25AA%25E9%2596%258B%25E8%25A3%259C%25E6%2598%258E%25E7%25B4%25B0%2528GN%2529.cpt&ref_t=design&op=view&ref_c=024d58aa-f9b8-49b5-bc04-cffc341ea78b'>").append(financeaTenGN.getProNum()).append("</a> </td>");
        htmlContent.append("<td>").append("未開補工單數-大單\n" +  "<br>"+
                "số đơn chưa khai bù - đơn to").append("</td>");
        htmlContent.append("</tr>");

        htmlContent.append("</table>");

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");


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
        htmlContent.append("<td>").append("訂單距離客人交期7天未滿單\n" +  "<br>"+
                "Đơn hàng cách ngày xuất hàng của khách hàng 7 ngày chưa đủ đơn").append("</td>");
        htmlContent.append("<td>").append("周一至周六\n" +  "<br>"+
                "Từ thứ 2 đến thứ 7").append("</td>");
        htmlContent.append("<td>").append("生管\n" +  "<br>"+
                "Sinh Quản").append("</td>");
        htmlContent.append("<td> <a href='http://10.10.250.213:8080/fr/decision/view/report?viewlet=%25E8%25A8%2582%25E5%2596%25AE%25E8%25B7%259D%25E9%259B%25A2%25E5%25AE%25A2%25E4%25BA%25BA%25E4%25BA%25A4%25E6%259C%259F7%25E5%25A4%25A9%25E6%259C%25AA%25E6%25BB%25BF%25E5%2596%25AE%25E6%2598%258E%25E7%25B4%25B0%2528TP%2529.cpt&ref_t=design&op=view&ref_c=024d58aa-f9b8-49b5-bc04-cffc341ea78b'> ").append(financeaTP.getProNum()).append("</a> </td>");
        htmlContent.append("<td rowspan='2'>").append("未滿單PO數\n" +  "<br>"+
                "số lượng đơn chưa đủ đơn").append("</td>");
        htmlContent.append("</tr>");

        //訂單已過客人交期未滿單
        //zong2
        Financea financeaPastTP = finceRepository.findByProIdPastANDFactoryTP(startOfDay);
        htmlContent.append("<tr>");
        htmlContent.append("<td>").append("訂單已過客人交期未滿單\n" +  "<br>"+
                "Đơn hàng chưa đủ đơn khi đã quá ngày xuất hàng của khách hàng").append("</td>");
        htmlContent.append("<td>").append("周一至周六\n" +  "<br>"+
                "Từ thứ 2 đến thứ 7").append("</td>");
        htmlContent.append("<td>").append("生管\n" +  "<br>"+
                "Sinh Quản").append("</td>");
        htmlContent.append("<td> <a href='http://10.10.250.213:8080/fr/decision/view/report?viewlet=%25E8%25A8%2582%25E5%2596%25AE%25E5%25B7%25B2%25E9%2581%258E%25E5%25AE%25A2%25E4%25BA%25BA%25E4%25BA%25A4%25E6%259C%259F%25E6%259C%25AA%25E6%25BB%25BF%25E5%2596%25AE%25E6%2598%258E%25E7%25B4%25B0%2528TP%2529.cpt&ref_t=design&op=view&ref_c=024d58aa-f9b8-49b5-bc04-cffc341ea78b'>").append(financeaPastTP.getProNum()).append("</a> </td>");
        htmlContent.append("</tr>");

        //訂單距離客人交期10天未滿單成型未開補
        //zong3
        Financea financeaTenTP = finceRepository.findByProIdtenDaysANDFactoryTP(startOfDay);
        htmlContent.append("<tr>");
        htmlContent.append("<td>").append("訂單距離客人交期10天未滿單成型未開補\n" +  "<br>"+
                "Đơn hàng cách ngày xuất hàng của khách hàng 10 ngày thành hình chưa khai bù").append("</td>");
        htmlContent.append("<td>").append("周一至周六\n" +  "<br>"+
                "Từ thứ 2 đến thứ 7").append("</td>");
        htmlContent.append("<td>").append("生管\n" +  "<br>"+
                "Sinh Quản").append("</td>");
        htmlContent.append("<td> <a href='http://10.10.250.213:8080/fr/decision/view/report?viewlet=%25E8%25A8%2582%25E5%2596%25AE%25E8%25B7%259D%25E9%259B%25A2%25E5%25AE%25A2%25E4%25BA%25BA%25E4%25BA%25A4%25E6%259C%259F10%25E5%25A4%25A9%25E6%259C%25AA%25E6%25BB%25BF%25E5%2596%25AE%25E6%259C%25AA%25E9%2596%258B%25E8%25A3%259C%25E6%2598%258E%25E7%25B4%25B0%2528TP%2529.cpt&ref_t=design&op=view&ref_c=024d58aa-f9b8-49b5-bc04-cffc341ea78b'>").append(financeaTenTP.getProNum()).append("</a> </td>");
        htmlContent.append("<td>").append("未開補工單數-大單\n" +  "<br>"+
                "số đơn chưa khai bù - đơn to").append("</td>");
        htmlContent.append("</tr>");

        htmlContent.append("</table>");

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");


        helper.setTo("hank.lin@stella.com.hk");

        helper.setFrom("eip.mail@stella.com.hk");

        helper.setSubject("【預警-未滿單&成型未開補】太平廠   【Cảnh báo-chưa đủ đơn&Thành hình chưa khai bù】xưởng Thái Bình");
        helper.setText(htmlContent.toString(), true);

        mailSender.send(message);


    }




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

        htmlContent.append("<h2>【預警-未驗貨】安老廠 【Cảnh báo-chưa kiểm hàng】Xưởng An Lão</h2>");
        htmlContent.append("<table border='1' cellpadding='5' cellspacing='0' style='border-collapse: collapse;'>");
        htmlContent.append("<tr style='background-color:#007bff;color:white;'>");
        htmlContent.append("<th>預警名稱</th><th>預警週期</th><th>責任單位</th><th>AL</th><th>備註</th>");
        htmlContent.append("</tr>");


        //訂單距離客人交期7 天未驗貨
        Financea financeaNoCheckAL = finceRepository.findByProIdNoCheckSevenDaysANDFactoryAL(startOfDay);
        htmlContent.append("<tr>");
        htmlContent.append("<td>").append("訂單距離客人交期7天未驗貨\n" +  "<br>"+
                "Đơn hàng cách ngày xuất hàng của khách hàng 7 ngày chưa kiểm hàng").append("</td>");
        htmlContent.append("<td>").append("周一至周六\n" +  "<br>"+
                "Từ thứ 2 đến thứ 7").append("</td>");
        htmlContent.append("<td>").append("品管\n" +  "<br>"+
                "Phòng kiểm tra chất lượng").append("</td>");
        htmlContent.append("<td> <a href='http://10.10.250.213:8080/fr/decision/view/report?viewlet=%25E8%25A8%2582%25E5%2596%25AE%25E8%25B7%259D%25E9%259B%25A2%25E5%25AE%25A2%25E4%25BA%25BA%25E4%25BA%25A4%25E6%259C%259F7%25E5%25A4%25A9%25E6%259C%25AA%25E9%25A9%2597%25E8%25B2%25A8%25E6%2598%258E%25E7%25B4%25B0%2528AL%2529.cpt&ref_t=design&op=view&ref_c=024d58aa-f9b8-49b5-bc04-cffc341ea78b'>").append(financeaNoCheckAL.getProNum()).append("</a> </td>");
        htmlContent.append("<td rowspan='2'>").append("未驗貨PO數\n" +  "<br>"+
                "Số lượng đơn chưa kiểm hàng").append("</td>");
        htmlContent.append("</tr>");

        //訂單已過客人交期未驗貨
        //zong2
        Financea financeaNoCheckPastAL = finceRepository.findByProIdNoCheckPastANDFactoryAL(startOfDay);
        htmlContent.append("<tr>");
        htmlContent.append("<td>").append("訂單已過客人交期未驗貨\n" +  "<br>"+
                "Đơn hàng chưa kiểm hàng khi quá ngày xuất hàng của khách hàng").append("</td>");
        htmlContent.append("<td>").append("周一至周六\n" +  "<br>"+
                "Từ thứ 2 đến thứ 7").append("</td>");
        htmlContent.append("<td>").append("品管\n" +  "<br>"+
                "Phòng kiểm tra chất lượng").append("</td>");
        htmlContent.append("<td> <a href='http://10.10.250.213:8080/fr/decision/view/report?viewlet=%25E8%25A8%2582%25E5%2596%25AE%25E5%25B7%25B2%25E9%2581%258E%25E5%25AE%25A2%25E4%25BA%25BA%25E4%25BA%25A4%25E6%259C%259F%25E6%259C%25AA%25E9%25A9%2597%25E8%25B2%25A8%25E6%2598%258E%25E7%25B4%25B0%2528AL%2529.cpt&ref_t=design&op=view&ref_c=024d58aa-f9b8-49b5-bc04-cffc341ea78b'>").append(financeaNoCheckPastAL.getProNum()).append("</a> </td>");
        htmlContent.append("</tr>");

        htmlContent.append("</table>");

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");


        helper.setTo("hank.lin@stella.com.hk");

        helper.setFrom("eip.mail@stella.com.hk");

        helper.setSubject("【預警-未驗貨】安老廠 【Cảnh báo-chưa kiểm hàng】Xưởng An Lão");
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

        htmlContent.append("<h2>【預警-未驗貨】廣寧廠 【Cảnh báo-chưa kiểm hàng】xưởng Quảng Ninh</h2>");
        htmlContent.append("<table border='1' cellpadding='5' cellspacing='0' style='border-collapse: collapse;'>");
        htmlContent.append("<tr style='background-color:#007bff;color:white;'>");
        htmlContent.append("<th>預警名稱</th><th>預警週期</th><th>責任單位</th><th>AL</th><th>備註</th>");
        htmlContent.append("</tr>");


        //訂單距離客人交期7 天未驗貨
        Financea financeaNoCheckGN = finceRepository.findByProIdNoCheckSevenDaysANDFactoryGN(startOfDay);
        htmlContent.append("<tr>");
        htmlContent.append("<td>").append("訂單距離客人交期7天未驗貨\n" +  "<br>"+
                "Đơn hàng cách ngày xuất hàng của khách hàng 7 ngày chưa kiểm hàng").append("</td>");
        htmlContent.append("<td>").append("周一至周六\n" +  "<br>"+
                "Từ thứ 2 đến thứ 7").append("</td>");
        htmlContent.append("<td>").append("品管\n" +  "<br>"+
                "Phòng kiểm tra chất lượng").append("</td>");
        htmlContent.append("<td> <a href='http://10.10.250.213:8080/fr/decision/view/report?viewlet=%25E8%25A8%2582%25E5%2596%25AE%25E8%25B7%259D%25E9%259B%25A2%25E5%25AE%25A2%25E4%25BA%25BA%25E4%25BA%25A4%25E6%259C%259F7%25E5%25A4%25A9%25E6%259C%25AA%25E9%25A9%2597%25E8%25B2%25A8%25E6%2598%258E%25E7%25B4%25B0%2528GN%2529.cpt&ref_t=design&op=view&ref_c=024d58aa-f9b8-49b5-bc04-cffc341ea78b'>").append(financeaNoCheckGN.getProNum()).append("</a> </td>");
        htmlContent.append("<td rowspan='2'>").append("未驗貨PO數\n" +  "<br>"+
                "Số lượng đơn chưa kiểm hàng").append("</td>");
        htmlContent.append("</tr>");

        //訂單已過客人交期未驗貨
        //zong2
        Financea financeaNoCheckPastGN = finceRepository.findByProIdNoCheckPastANDFactoryGN(startOfDay);
        htmlContent.append("<tr>");
        htmlContent.append("<td>").append("訂單已過客人交期未驗貨\n" +  "<br>"+
                "Đơn hàng chưa kiểm hàng khi quá ngày xuất hàng của khách hàng").append("</td>");
        htmlContent.append("<td>").append("周一至周六\n" +  "<br>"+
                "Từ thứ 2 đến thứ 7").append("</td>");
        htmlContent.append("<td>").append("品管\n" +  "<br>"+
                "Phòng kiểm tra chất lượng").append("</td>");
        htmlContent.append("<td> <a href='http://10.10.250.213:8080/fr/decision/view/report?viewlet=%25E8%25A8%2582%25E5%2596%25AE%25E5%25B7%25B2%25E9%2581%258E%25E5%25AE%25A2%25E4%25BA%25BA%25E4%25BA%25A4%25E6%259C%259F%25E6%259C%25AA%25E9%25A9%2597%25E8%25B2%25A8%25E6%2598%258E%25E7%25B4%25B0%2528GN%2529.cpt&ref_t=design&op=view&ref_c=024d58aa-f9b8-49b5-bc04-cffc341ea78b'>").append(financeaNoCheckPastGN.getProNum()).append("</a> </td>");
        htmlContent.append("</tr>");

        htmlContent.append("</table>");

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
        helper.setTo("hank.lin@stella.com.hk");
        helper.setFrom("eip.mail@stella.com.hk");

        helper.setSubject("【預警-未驗貨】廣寧廠 【Cảnh báo-chưa kiểm hàng】xưởng Quảng Ninh ");
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

        htmlContent.append("<h2>【預警-未驗貨】太平廠 【Cảnh báo-chưa kiểm hàng】xưởng Thái Bình</h2>");
        htmlContent.append("<table border='1' cellpadding='5' cellspacing='0' style='border-collapse: collapse;'>");
        htmlContent.append("<tr style='background-color:#007bff;color:white;'>");
        htmlContent.append("<th>預警名稱</th><th>預警週期</th><th>責任單位</th><th>AL</th><th>備註</th>");
        htmlContent.append("</tr>");


        //訂單距離客人交期7 天未驗貨
        Financea financeaNoCheckTP = finceRepository.findByProIdNoCheckSevenDaysANDFactoryTP(startOfDay);
        htmlContent.append("<tr>");
        htmlContent.append("<td>").append("訂單距離客人交期7天未驗貨\n" +  "<br>"+
                "Đơn hàng cách ngày xuất hàng của khách hàng 7 ngày chưa kiểm hàng").append("</td>");
        htmlContent.append("<td>").append("周一至周六\n" +  "<br>"+
                "Từ thứ 2 đến thứ 7").append("</td>");
        htmlContent.append("<td>").append("品管\n" +  "<br>"+
                "Phòng kiểm tra chất lượng").append("</td>");
        htmlContent.append("<td> <a href='http://10.10.250.213:8080/fr/decision/view/report?viewlet=%25E8%25A8%2582%25E5%2596%25AE%25E8%25B7%259D%25E9%259B%25A2%25E5%25AE%25A2%25E4%25BA%25BA%25E4%25BA%25A4%25E6%259C%259F7%25E5%25A4%25A9%25E6%259C%25AA%25E9%25A9%2597%25E8%25B2%25A8%25E6%2598%258E%25E7%25B4%25B0%2528TP%2529.cpt&ref_t=design&op=view&ref_c=024d58aa-f9b8-49b5-bc04-cffc341ea78b'>").append(financeaNoCheckTP.getProNum()).append("</a> </td>");
        htmlContent.append("<td rowspan='2'>").append("未驗貨PO數\n" +  "<br>"+
                "Số lượng đơn chưa kiểm hàng").append("</td>");
        htmlContent.append("</tr>");

        //訂單已過客人交期未驗貨
        //zong2
        Financea financeaNoCheckPastTP = finceRepository.findByProIdNoCheckPastANDFactoryTP(startOfDay);
        htmlContent.append("<tr>");
        htmlContent.append("<td>").append("訂單已過客人交期未驗貨\n" +  "<br>"+
                "Đơn hàng chưa kiểm hàng khi quá ngày xuất hàng của khách hàng").append("</td>");
        htmlContent.append("<td>").append("周一至周六\n" +  "<br>"+
                "Từ thứ 2 đến thứ 7").append("</td>");
        htmlContent.append("<td>").append("品管\n" +  "<br>"+
                "Phòng kiểm tra chất lượng").append("</td>");
        htmlContent.append("<td> <a href='http://10.10.250.213:8080/fr/decision/view/report?viewlet=%25E8%25A8%2582%25E5%2596%25AE%25E5%25B7%25B2%25E9%2581%258E%25E5%25AE%25A2%25E4%25BA%25BA%25E4%25BA%25A4%25E6%259C%259F%25E6%259C%25AA%25E9%25A9%2597%25E8%25B2%25A8%25E6%2598%258E%25E7%25B4%25B0%2528TP%2529.cpt&ref_t=design&op=view&ref_c=024d58aa-f9b8-49b5-bc04-cffc341ea78b'>").append(financeaNoCheckPastTP.getProNum()).append("</a> </td>");
        htmlContent.append("</tr>");

        htmlContent.append("</table>");

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

        helper.setTo("hank.lin@stella.com.hk");

        helper.setFrom("eip.mail@stella.com.hk");

        helper.setSubject("【預警-未驗貨】太平廠 【Cảnh báo-chưa kiểm hàng】xưởng Thái Bình ");
        helper.setText(htmlContent.toString(), true);

        mailSender.send(message);



    }


}

