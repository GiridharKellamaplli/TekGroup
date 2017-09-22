package com.tekgroup.tektimesheet.serivce;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import com.tekgroup.tektimesheet.model.InterviewInfo;

public interface InterviewInfoService {
	
	
	public boolean save(InterviewInfo interviewInfo);
	
	public List<InterviewInfo> findAll();
	
	public List<InterviewInfo> findTodaySlots(LocalDate date);

}
