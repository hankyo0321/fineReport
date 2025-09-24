package com.hank.fineReport.report.repository;

import com.hank.fineReport.report.model.OutView;

import com.hank.fineReport.report.model.OutViewZong1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface OutViewZong1Repository   extends JpaRepository<OutViewZong1, Long> {

    @Query(value = "select * From nxuser.VGB_OUTVIEWZONG1", nativeQuery = true)
    public List<OutViewZong1> getTotalOutViewZong1();



}
