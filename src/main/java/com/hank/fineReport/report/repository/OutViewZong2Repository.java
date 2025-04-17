package com.hank.fineReport.report.repository;


import com.hank.fineReport.report.model.OutViewZong2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface OutViewZong2Repository extends JpaRepository<OutViewZong2, Long> {

    @Query(value = """
            select * From nxuser.VGB_OUTVIEWZONG2
            """, nativeQuery = true)
    public List<OutViewZong2> getTotalOutViewZong2();



}
