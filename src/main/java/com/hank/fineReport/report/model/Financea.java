package com.hank.fineReport.report.model;



import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Setter
@Getter
@Data
@Entity
@Table(name="BJ_FINANCEA")
public class Financea implements Serializable {


    @EmbeddedId
    private FinanceaId id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="PRO_DATE" , insertable = false, updatable = false)
    private Date proDate;

    @Column(name="PRO_ID", insertable = false, updatable = false)
    private Integer proId;

    @Column(name="FACTORY" , insertable = false, updatable = false)
    private String factory;

    @Column(name="PRO_NUM")
    private Integer proNum;

    @Transient
    private String hrefURL;

    public Financea() {}

    public Financea(Integer proId, Date proDate, String factory) {
        this.proId = proId;
        this.proDate = proDate;
        this.factory = factory;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Financea that = (Financea) o;
        return proId.equals(that.proId) &&
                proDate.equals(that.proDate) &&
                factory.equals(that.factory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(proId, proDate, factory);
    }



}
