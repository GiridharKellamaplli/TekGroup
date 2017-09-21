package com.tekgroup.tektimesheet.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tekgroup.tektimesheet.model.InterviewInfo;

public interface InterviewInfoRepository extends JpaRepository<InterviewInfo, Integer> {
	
	public List<InterviewInfo> findByName(String name);
	
	public int deleteByNameAndStartTime(String name, LocalDateTime slot);

}
