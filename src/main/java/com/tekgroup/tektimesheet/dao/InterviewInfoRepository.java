package com.tekgroup.tektimesheet.dao;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tekgroup.tektimesheet.model.InterviewInfo;

public interface InterviewInfoRepository extends JpaRepository<InterviewInfo, Integer> {


	@Query("SELECT p FROM InterviewInfo p WHERE p.date = :date")
	public List<InterviewInfo> findTodaySlots(@Param("date") LocalDate date);
		
}
