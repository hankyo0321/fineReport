package com.hank.fineReport.report.repository;

import com.hank.fineReport.report.model.OutViewZong2;
import com.hank.fineReport.report.model.OutViewZong3;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OutViewZong3Repository extends JpaRepository<OutViewZong3 , Long> {

    @Query(value = """
            select * From nxuser.VGB_OUTVIEWZONG3
            """,nativeQuery = true)
    public List<OutViewZong3> getov3();
}
