package com.hank.fineReport.report.service;

import com.hank.fineReport.report.model.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class FormatMailService {


    /**
     * 未滿單總表-訂單距離客人交期七天未滿單
     * @param htmlContent
     * @param oz
     * @return
     */
    public StringBuilder appendAllQty(StringBuilder htmlContent,   OutViewZong1 oz ){
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


    public StringBuilder appendAll2Qty( StringBuilder htmlContent,   OutViewZong2 oz){
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


    public StringBuilder appendAll5Qty(StringBuilder htmlContent, OutViewZong5 oz) {
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
