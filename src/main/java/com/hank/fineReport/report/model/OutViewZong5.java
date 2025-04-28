package com.hank.fineReport.report.model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name="VGB_OUTVIEWZONG5"  ,schema = "nxuser")
public class OutViewZong5 implements Serializable {

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
