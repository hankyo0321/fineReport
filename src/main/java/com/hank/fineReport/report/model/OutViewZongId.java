package com.hank.fineReport.report.model;




import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class OutViewZongId implements Serializable {

    @Column(name="FACTORY" )
    private String factory;

    @Column(name="BRAND_NO")
    private String brandNo;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OutViewZongId that = (OutViewZongId) o;
        return factory.equals(that.factory) &&
                brandNo.equals(that.brandNo) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(factory, brandNo);
    }
}
