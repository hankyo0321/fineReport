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
            SELECT f FROM Financea f WHERE f.proId =101 AND f.proDate >= :startOfDay AND f.factory = 'VN'
            
            """)
    Financea findByProIdSevenDaysANDFactoryAL(@Param("startOfDay") LocalDateTime startOfDay);

    @Query("""
            SELECT f FROM Financea f WHERE f.proId =101 AND f.proDate >= :startOfDay AND f.factory = 'GN'
            
            """)
    Financea findByProIdSevenDaysANDFactoryGN(@Param("startOfDay") LocalDateTime startOfDay);


    @Query("""
            SELECT f FROM Financea f WHERE f.proId =101 AND f.proDate >= :startOfDay AND f.factory = 'TP'
            
            """)
    Financea findByProIdSevenDaysANDFactoryTP(@Param("startOfDay") LocalDateTime startOfDay);

    @Query("""
            SELECT f FROM Financea f WHERE f.proId =102 AND f.proDate >= :startOfDay  AND f.factory = 'VN'
            
            """)
    Financea findByProIdPastANDFactoryAL( @Param("startOfDay") LocalDateTime startOfDay);

    @Query("""
            SELECT f FROM Financea f WHERE f.proId =102 AND f.proDate >= :startOfDay  AND f.factory = 'GN'
            
            """)
    Financea findByProIdPastANDFactoryGN( @Param("startOfDay") LocalDateTime startOfDay);


    @Query("""
            SELECT f FROM Financea f WHERE f.proId =102 AND f.proDate >= :startOfDay  AND f.factory = 'TP'
            
            """)
    Financea findByProIdPastANDFactoryTP( @Param("startOfDay") LocalDateTime startOfDay);

    @Query("""
            SELECT f FROM Financea f WHERE f.proId =103 AND f.proDate >= :startOfDay  AND f.factory = 'VN'
            
            """)
    Financea findByProIdtenDaysANDFactoryAL( @Param("startOfDay") LocalDateTime startOfDay);


    @Query("""
            SELECT f FROM Financea f WHERE f.proId =103 AND f.proDate >= :startOfDay  AND f.factory = 'GN'
            
            """)
    Financea findByProIdtenDaysANDFactoryGN( @Param("startOfDay") LocalDateTime startOfDay);



    @Query("""
            SELECT f FROM Financea f WHERE f.proId =103 AND f.proDate >= :startOfDay  AND f.factory = 'TP'
            
            """)
    Financea findByProIdtenDaysANDFactoryTP( @Param("startOfDay") LocalDateTime startOfDay);



    @Query("""
            SELECT f FROM Financea f WHERE f.proId =104 AND f.proDate >= :startOfDay AND f.factory = 'VN'
            
            """)
    Financea findByProIdNoCheckSevenDaysANDFactoryAL(@Param("startOfDay") LocalDateTime startOfDay);


    @Query("""
            SELECT f FROM Financea f WHERE f.proId =104 AND f.proDate >= :startOfDay AND f.factory = 'GN'
            
            """)
    Financea findByProIdNoCheckSevenDaysANDFactoryGN(@Param("startOfDay") LocalDateTime startOfDay);


    @Query("""
            SELECT f FROM Financea f WHERE f.proId =104 AND f.proDate >= :startOfDay AND f.factory = 'TP'
            
            """)
    Financea findByProIdNoCheckSevenDaysANDFactoryTP(@Param("startOfDay") LocalDateTime startOfDay);


    @Query("""
            SELECT f FROM Financea f WHERE f.proId =105 AND f.proDate >= :startOfDay  AND f.factory = 'VN'
            
            """)
    Financea findByProIdNoCheckPastANDFactoryAL( @Param("startOfDay") LocalDateTime startOfDay);


    @Query("""
            SELECT f FROM Financea f WHERE f.proId =105 AND f.proDate >= :startOfDay  AND f.factory = 'GN'
            
            """)
    Financea findByProIdNoCheckPastANDFactoryGN( @Param("startOfDay") LocalDateTime startOfDay);


    @Query("""
            SELECT f FROM Financea f WHERE f.proId =105 AND f.proDate >= :startOfDay  AND f.factory = 'TP'
            
            """)
    Financea findByProIdNoCheckPastANDFactoryTP( @Param("startOfDay") LocalDateTime startOfDay);
}
