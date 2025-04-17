package com.hank.fineReport.report.model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name="VGB_OUTVIEW1")
public class OutView  implements Serializable {


    @EmbeddedId
    private  OutViewId outViewId;

    @Column(name="ONLINE_MON")
    private String onlineMon; //上線月份

    @Column(name ="ONLINE_DATE")
    private Date onlineDate;//上線日期

    @Column(name = "BRAND_DESC" ,nullable = false)
    private String brandDesc;//品牌名稱

    @Column(name="MODEL_NO" ,nullable = false)
    private String modelNo;//型體編號

    @Column(name="SKU_NO")
    private String skuNo;//庫存代號

    @Column(name="CUST_ENGCOLOR")
    private String custEngColor;//中文顏色

    @Column(name="ADDRESS")
    private String address;//目的地

    @Column(name="CUST_ORDER",insertable=false, updatable=false)
    private String custOrder;//客戶訂單

    @Column(name="ORDER_NO" ,insertable=false, updatable=false)
    private String orderNo;//工作單號2

    @Column(name="OUT_CDATE")
    private Date outCdate;//工廠出貨日

    @Column(name="ORD_QTY")
    private Integer ordQty;//訂單數量

    @Column(name="DATE1")
    private Integer date1;//距離客人交期天數

    @Column(name="MADE_LINE")
    private String madeLine;//產險名稱

    @Column(name="INS_DATE")
    private Date insDate;//首次入庫日期

    @Column(name="NOTIN_QTY")
    private Integer notinQty;//成倉欠數

    @Column(name="CUT_TO_BOX")
    private Integer cutToBox;//CUT_TO_BOX

    @Column(name="ORDER_AUTO", insertable=false, updatable=false)
    private String orderAuto;//訂單文件號


}
