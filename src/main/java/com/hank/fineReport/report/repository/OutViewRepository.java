package com.hank.fineReport.report.repository;

import com.hank.fineReport.report.model.OutView;
import com.hank.fineReport.report.model.OutView2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OutViewRepository extends JpaRepository<OutView, Long> {

    @Query(value = "select * From  vnuser.vgb_outview1", nativeQuery = true)
    List<OutView>  getOutView1();


    @Query(value = "select * From  vnuser.vgb_outview2", nativeQuery = true)
    List<OutView2>  getOutView2();


    @Query(value = "select * From  tpuser.vgb_outview1", nativeQuery = true)
    List<OutView>  getOutView1ByTpUser();
}
