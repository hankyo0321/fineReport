package com.hank.fineReport.report.model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
@Table(name="VGB_OUTVIEWZONG2"  ,schema = "nxuser")
public class OutViewZong2 implements Serializable {

    @EmbeddedId
    private OutViewZongId outViewZongId;

    @Column(name="FACTORY",insertable=false, updatable=false)
    private String factory;

    @Column(name="BRAND_NO",insertable=false, updatable=false)
    private String brandNo;

    @Column(name="PO_QTY1")
    private Integer poQty1;

    @Column(name="NOTIN_QTY1")
    private Integer notinQty1;

    @Column(name="ORD_QTY1")
    private Integer ordQty1;

    @Column(name="PO_QTY2")
    private Integer poQty2;

    @Column(name="NOTIN_QTY2")
    private Integer notinQty2;

    @Column(name="ORD_QTY2")
    private Integer ordQty2;

    @Column(name="PO_QTY3")
    private Integer poQty3;

    @Column(name="NOTIN_QTY3")
    private Integer notinQty3;

    @Column(name="ORD_QTY3")
    private Integer ordQtyt3;

    @Column(name="PO_QTY4")
    private Integer poQty4;

    @Column(name="NOTIN_QTY4")
    private Integer notinQty4;

    @Column(name="ORD_QTY4")
    private Integer ordQtyt4;

    @Column(name="PO_QTY5")
    private Integer poQty5;

    @Column(name="NOTIN_QTY5")
    private Integer notinQty5;

    @Column(name="ORD_QTY5")
    private Integer ordQtyt5;

    @Column(name="PO_QTY6")
    private Integer poQty6;

    @Column(name="NOTIN_QTY6")
    private Integer notinQty6;

    @Column(name="ORD_QTY6")
    private Integer ordQtyt6;

    @Column(name="PO_QTYZONG")
    private Integer poQtyZong;

    @Column(name="NOTIN_QTYZONG")
    private Integer noTinQtyZong;

    @Column(name = "ORD_QTYZONG")
    private Integer ordQtyZong;


}
