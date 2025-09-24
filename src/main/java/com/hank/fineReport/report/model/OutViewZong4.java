package com.hank.fineReport.report.model;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name="VGB_OUTVIEWZONG4"  ,schema = "nxuser")
public class OutViewZong4 implements Serializable {

    @EmbeddedId
    private OutViewZongId outViewZongId;

    @Column(name="FACTORY",insertable=false, updatable=false)
    private String factory;

    @Column(name="BRAND_NO",insertable=false, updatable=false)
    private String brandNo;

    @Column(name="ORDER_AUTO1")
    private Integer orderAuto1;

    @Column(name="ORD_QTY1")
    private Integer ordQty1;

//--------------------------------------------
    @Column(name="ORDER_AUTO2")
    private Integer orderAuto2;

    @Column(name="NOTIN_QTY2")
    private Integer notinQty2;

    @Column(name="ORD_QTY2")
    private Integer ordQty2;

//---------------------------------------------
    @Column(name="ORDER_AUTOZONG")
    private Integer orderAutoZong;

    @Column(name="NOTIN_QTYZONG")
    private Integer notinQtyZong;

    @Column(name="ORD_QTYZONG")
    private Integer ordQtyZong;
}
