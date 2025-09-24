package com.hank.fineReport.report.model;




import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class OutViewId implements Serializable {


    @Column(name="ORDER_AUTO")
    private String orderAuto;

    @Column(name="CUST_ORDER")
    private String custOrder;//客戶訂單

    @Column(name="ORDER_NO")
    private String orderNo;//工作單號2

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OutViewId that = (OutViewId) o;
        return orderAuto.equals(that.orderAuto) &&
                custOrder.equals(that.custOrder) &&
                orderNo.equals(that.orderNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderAuto, custOrder, orderNo);
    }
}
