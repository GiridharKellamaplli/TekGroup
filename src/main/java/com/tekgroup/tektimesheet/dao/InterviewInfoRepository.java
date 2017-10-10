package com.tekgroup.tektimesheet.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tekgroup.tektimesheet.model.InterviewInfo;

public interface InterviewInfoRepository extends JpaRepository<InterviewInfo, Integer> {

	public List<InterviewInfo> findByInterviewLocalDateOrderByInterviewLocalDateDescStartTimeAsc(LocalDate date);

	@Query("select i from InterviewInfo i where i.interviewLocalDate >= ?1")
	public List<InterviewInfo> findAllByOrderByInterviewLocalDateDescStartTimeAsc(LocalDate date);
	

	public InterviewInfo findById(int id);

	public void deleteById(int id);

	/*
	 * @Query("SELECT p FROM InterviewInfo p WHERE p.date = :date") public
	 * List<InterviewInfo> findTodaySlots(@Param("date") LocalDate date);
	 */

}
