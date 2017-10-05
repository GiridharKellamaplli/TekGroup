package com.tekgroup.tektimesheet.controller;

import java.security.Principal;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tekgroup.tektimesheet.model.InterviewInfo;
import com.tekgroup.tektimesheet.serivce.InterviewInfoService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/interview")
public class InterviewInfoController {

	@Autowired
	InterviewInfoService service;

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<Void> createSlot(@RequestBody InterviewInfo interviewInfo) {
		System.out.println("Creating new time slot...");
		if (service.save(interviewInfo))
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		else
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<List<InterviewInfo>> getSlots(HttpServletRequest request) {
		System.out.println("In getslots");
		
		Principal principal = request.getUserPrincipal();
		String user = principal.getName();
		System.out.println("userid $$$$$$$$$$$$$$$$$$$$$$"+ user);
		List<InterviewInfo> interviewByUserName = service.findByUserName(user);
		System.out.println(interviewByUserName);
		List<InterviewInfo> interviews = service.findAll();
		return new ResponseEntity<List<InterviewInfo>>(interviews, HttpStatus.OK);
	}

	@RequestMapping(value = "/today", method = RequestMethod.GET)
	public ResponseEntity<List<InterviewInfo>> getTodaySlots() throws ParseException {

		LocalDate date = LocalDate.now();
		System.out.println(date + " Today");
		List<InterviewInfo> interviews = service.findByDate(date);
		return new ResponseEntity<List<InterviewInfo>>(interviews, HttpStatus.OK);
	}

	@RequestMapping(value = "/{date}", method = RequestMethod.GET)
	public ResponseEntity<List<InterviewInfo>> getSlotsByDate(@PathVariable("date") String date) throws ParseException {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate localDate = LocalDate.parse(date, formatter);
		List<InterviewInfo> interviews = service.findByDate(localDate);
		return new ResponseEntity<List<InterviewInfo>>(interviews, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> updateSlot(@PathVariable("id") int id, @RequestBody InterviewInfo updatedInfo) {
		InterviewInfo interviewInfo = service.findById(id);
		if (interviewInfo != null) {
			if (updatedInfo.isCancelled()) {
				service.delete(id);
				return new ResponseEntity<Void>(HttpStatus.OK);
			}

			interviewInfo.setDate(updatedInfo.getDate());
			interviewInfo.setStartTime(updatedInfo.getStartTime());
			interviewInfo.setEndTime(updatedInfo.getEndTime());
			interviewInfo.setName(updatedInfo.getName());
			interviewInfo.setMode(updatedInfo.getMode());
			interviewInfo.setClient(updatedInfo.getClient());
			interviewInfo.setVendor(updatedInfo.getVendor());
			interviewInfo.setRound(updatedInfo.getRound());
			interviewInfo.setRecording(updatedInfo.getRecording());
			interviewInfo.setCancelled(updatedInfo.isCancelled());
			service.save(interviewInfo);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}

		else
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteSlot(@PathVariable("id") int id) {
		InterviewInfo interviewInfo = service.findById(id);
		if (interviewInfo != null) {
			service.delete(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} else
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}

}
