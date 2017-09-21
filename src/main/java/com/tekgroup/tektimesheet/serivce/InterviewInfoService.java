package com.tekgroup.tektimesheet.serivce;

import java.time.LocalDateTime;
import java.util.List;

import com.tekgroup.tektimesheet.model.InterviewInfo;

public interface InterviewInfoService {
	
	public List<InterviewInfo> findByName(String name);
	
	public InterviewInfo saveOrUpdate(InterviewInfo interviewInfo);
	
	public List<InterviewInfo> findAllInterviews();
	
	public int deleteByNameAndSlot(String name, LocalDateTime startTime);

}
