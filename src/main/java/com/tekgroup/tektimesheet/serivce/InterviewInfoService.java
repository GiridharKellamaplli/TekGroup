package com.tekgroup.tektimesheet.serivce;

import java.time.LocalDate;
import java.util.List;

import com.tekgroup.tektimesheet.model.InterviewInfo;

public interface InterviewInfoService {

	public boolean save(InterviewInfo interviewInfo);

	public List<InterviewInfo> findAll();

	public List<InterviewInfo> findByDate(LocalDate date);

	public List<InterviewInfo> findByUserName(String name);
	
	public InterviewInfo findById(int id);
	
	public void delete(int id);

}
