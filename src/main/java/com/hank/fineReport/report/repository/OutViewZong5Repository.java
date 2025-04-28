package com.hank.fineReport.report.repository;


import com.hank.fineReport.report.model.OutViewZong5;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OutViewZong5Repository extends JpaRepository<OutViewZong5, Long> {

    @Query(value = """
            select * From nxuser.VGB_OUTVIEWZONG5
            """,nativeQuery = true)
    public List<OutViewZong5> getov5();
}
