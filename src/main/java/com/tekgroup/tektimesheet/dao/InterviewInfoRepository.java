package com.tekgroup.tektimesheet.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tekgroup.tektimesheet.model.InterviewInfo;

public interface InterviewInfoRepository extends JpaRepository<InterviewInfo, Integer> {

	public List<InterviewInfo> findByDateOrderByDateDescStartTimeAsc(LocalDate date);

	public List<InterviewInfo> findAllByOrderByDateDescStartTimeAsc();

	public InterviewInfo findById(int id);

	public void deleteById(int id);
	
	public List<InterviewInfo> findByName(String name);
	/*
	@Query("SELECT p from InterviewInfo p where p.name=name")
	public List<InterviewInfo> findByName(@Param("name") String name );*/

	/*
	 * @Query("SELECT p FROM InterviewInfo p WHERE p.date = :date") public
	 * List<InterviewInfo> findTodaySlots(@Param("date") LocalDate date);
	 */

}
