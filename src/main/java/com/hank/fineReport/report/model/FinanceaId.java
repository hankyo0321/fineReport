package com.hank.fineReport.report.model;


import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Embeddable
public class FinanceaId implements Serializable {

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="PRO_DATE")
    private Date proDate;

    @Column(name="PRO_ID")
    private Integer proId;

    @Column(name="FACTORY")
    private String factory;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FinanceaId that = (FinanceaId) o;
        return proId.equals(that.proId) &&
                proDate.equals(that.proDate) &&
                factory.equals(that.factory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(proId, proDate, factory);
    }
}
