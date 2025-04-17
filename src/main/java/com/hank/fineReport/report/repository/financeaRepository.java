package com.hank.fineReport.report.repository;

import com.hank.fineReport.report.model.Financea;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface financeaRepository extends JpaRepository<Financea, Long> {

    @Query("""
            SELECT f FROM Financea f WHERE f.proId =101 AND f.proDate >= :startOfDay
            
            """)
    List<Financea> findByProIdSevenDays( @Param("startOfDay") LocalDateTime startOfDay);

    @Query("""
            SELECT f FROM Financea f WHERE f.proId =102 AND f.proDate >= :startOfDay
            
            """)
    List<Financea> findByProIdPast( @Param("startOfDay") LocalDateTime startOfDay);
}
