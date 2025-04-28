package com.hank.fineReport.report.repository.mapper;

import com.hank.fineReport.report.model.Financea;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;


@Mapper
public interface FinanceaMapper {

    List<Financea> findByProId( @Param("proId")Integer proId);
}
