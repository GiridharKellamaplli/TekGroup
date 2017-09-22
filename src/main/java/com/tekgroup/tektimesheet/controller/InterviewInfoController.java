package com.tekgroup.tektimesheet.controller;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tekgroup.tektimesheet.model.InterviewInfo;
import com.tekgroup.tektimesheet.serivce.InterviewInfoService;

@RestController
@RequestMapping(value="/interview")
public class InterviewInfoController {
	
	@Autowired
	InterviewInfoService service;
	
	@RequestMapping(value="/slot", method = RequestMethod.POST)
	public ResponseEntity<Void> createSlot(@RequestBody InterviewInfo interviewInfo){
		System.out.println("Creating new time slot...");
		LocalDate localDate = interviewInfo.getDate();
		System.out.println(localDate);
		if(service.save(interviewInfo))
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		else
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
	}
	
	@RequestMapping(value="/slots", method = RequestMethod.GET)
	public ResponseEntity<List<InterviewInfo>> getSlots(){
		List<InterviewInfo> interviews = service.findAll();
		return new ResponseEntity<List<InterviewInfo>>(interviews, HttpStatus.OK);
	}
	
	@RequestMapping(value="/slots/today", method = RequestMethod.GET)
	public ResponseEntity<List<InterviewInfo>> getTodaySlots() throws ParseException{
		
		LocalDate date = LocalDate.now();
		System.out.println(date+" Today");
        List<InterviewInfo> interviews = service.findTodaySlots(date);
		return new ResponseEntity<List<InterviewInfo>>(interviews, HttpStatus.OK);
	}

}
