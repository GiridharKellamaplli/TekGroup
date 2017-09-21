package com.tekgroup.tektimesheet.serivce;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tekgroup.tektimesheet.dao.InterviewInfoRepository;
import com.tekgroup.tektimesheet.model.InterviewInfo;

@Service
public class InterviewInfoServiceImpl implements InterviewInfoService{
	
	private SessionFactory sessionFactory;
	
	@Autowired
	private InterviewInfoRepository interviewInfoRepository;

	@Override
	public List<InterviewInfo> findByName(String name) {
		return interviewInfoRepository.findByName(name);
	}

	@Override
	public InterviewInfo saveOrUpdate(InterviewInfo interviewInfo) {
		return interviewInfoRepository.save(interviewInfo);
	}

	@Override
	public List<InterviewInfo> findAllInterviews() {
		return interviewInfoRepository.findAll();
	}

	@Override
	public int deleteByNameAndSlot(String name, LocalDateTime startTime) {
		
		return 0;
	}

}
