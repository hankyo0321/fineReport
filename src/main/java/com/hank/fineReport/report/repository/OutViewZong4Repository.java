package com.hank.fineReport.report.repository;

import com.hank.fineReport.report.model.OutViewZong3;
import com.hank.fineReport.report.model.OutViewZong4;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OutViewZong4Repository extends JpaRepository<OutViewZong4, Long> {

    @Query(value = """
            select * From nxuser.VGB_OUTVIEWZONG4
            """,nativeQuery = true)
    public List<OutViewZong4> getov4();
}
