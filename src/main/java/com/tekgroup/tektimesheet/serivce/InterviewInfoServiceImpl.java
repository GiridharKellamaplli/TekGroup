package com.tekgroup.tektimesheet.serivce;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tekgroup.tektimesheet.dao.InterviewInfoRepository;
import com.tekgroup.tektimesheet.model.InterviewInfo;

@Service
public class InterviewInfoServiceImpl implements InterviewInfoService{
	
	
	@Autowired
	private InterviewInfoRepository interviewInfoRepository;


	@Override
	public boolean save(InterviewInfo interviewInfo) {
		
		
		if(interviewInfoRepository.save(interviewInfo)!=null)
			return true;
		else 
			return false;
	}


	@Override
	public List<InterviewInfo> findAll() {
		return interviewInfoRepository.findAll();
	}


	@Override
	public List<InterviewInfo> findTodaySlots(LocalDate date) {
		// TODO Auto-generated method stub
		return interviewInfoRepository.findTodaySlots(date);
	}


}
