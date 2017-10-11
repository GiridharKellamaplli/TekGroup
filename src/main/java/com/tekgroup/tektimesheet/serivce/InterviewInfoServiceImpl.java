package com.tekgroup.tektimesheet.serivce;

import java.sql.Time;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tekgroup.tektimesheet.dao.InterviewInfoRepository;
import com.tekgroup.tektimesheet.model.InterviewInfo;

@Service
public class InterviewInfoServiceImpl implements InterviewInfoService {

	@Autowired
	private InterviewInfoRepository interviewInfoRepository;

	@Override
	public boolean save(InterviewInfo interviewInfo) {

		interviewInfo = dateTimeParse(interviewInfo);

		Calendar calendar1 = Calendar.getInstance();
		calendar1.setTime(interviewInfo.getStartTime());

		Calendar calendar4 = Calendar.getInstance();
		calendar4.setTime(interviewInfo.getEndTime());

		Date x = calendar1.getTime();
		Date x2 = calendar4.getTime();

		System.out.println(calendar1);
		List<InterviewInfo> slots = interviewInfoRepository
				.findByInterviewLocalDateOrderByInterviewLocalDateDescStartTimeAsc(
						interviewInfo.getInterviewLocalDate());
		for (InterviewInfo slot : slots) {
			Calendar calendar2 = Calendar.getInstance();
			calendar2.setTime(slot.getStartTime());
			System.out.println(calendar2);
			Calendar calendar3 = Calendar.getInstance();
			calendar3.setTime(slot.getEndTime());
			System.out.println(calendar3);
			System.out.println(interviewInfo.getStartTime());
			System.out.println(slot.getStartTime());
			System.out.println(interviewInfo.getEndTime());
			System.out.println(slot.getEndTime());

			/*
			 * if ((interviewInfo.getStartTime().equals(slot.getStartTime())) &&
			 * (interviewInfo.getEndTime().equals(slot.getEndTime()))) return
			 * false;
			 */
			if (x.before(calendar2.getTime()) && x2.equals(calendar2.getTime())) {
				interviewInfoRepository.save(interviewInfo);
				return true;
			}
			if (x.equals(calendar3.getTime()) && x2.after(calendar3.getTime())) {
				interviewInfoRepository.save(interviewInfo);
				return true;
			}
			if (((x.before(calendar2.getTime()) || x.equals(calendar2.getTime())))
					&& (x2.after(calendar3.getTime()) || x2.equals(calendar3.getTime())))
				return false;
			if ((x.after(calendar2.getTime()) || x.equals(calendar2.getTime()))
					&& (x.before(calendar3.getTime()) || x.equals(calendar3.getTime())))
				return false;
			if ((x2.after(calendar2.getTime()) || x2.equals(calendar2.getTime()))
					&& (x2.before(calendar3.getTime()) || x2.equals(calendar3.getTime())))
				return false;
		}

		if (interviewInfoRepository.save(interviewInfo) != null)
			return true;
		else
			return false;

	}

	/**
	 * <p> Change the format of date and time to readable format </p>
	 * 
	 * @param interviewInfo
	 * 
	 * @return {@link InterviewInfo}
	 */
	private InterviewInfo dateTimeParse(InterviewInfo interviewInfo) {

		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
		String dateText = (interviewInfo.getInterviewLocalDate()).format(dateFormatter);
		interviewInfo.setInterviewDate(dateText);

		ZonedDateTime zonedStartTime = ZonedDateTime.ofInstant(Instant.parse(interviewInfo.getStartTimeText()),
				ZoneOffset.UTC);
		ZonedDateTime zonedEndTime = ZonedDateTime.ofInstant(Instant.parse(interviewInfo.getEndTimeText()),
				ZoneOffset.UTC);

		zonedStartTime = zonedStartTime.withZoneSameInstant(ZoneId.of("UTC-05:00"));
		zonedEndTime = zonedEndTime.withZoneSameInstant(ZoneId.of("UTC-05:00"));

		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("hh:mm a");

		Time startTime = Time.valueOf(zonedStartTime.toLocalTime());
		interviewInfo.setStartTime(startTime);

		Time endTime = Time.valueOf(zonedEndTime.toLocalTime());
		interviewInfo.setEndTime(endTime);

		interviewInfo.setStartTimeText(zonedStartTime.toLocalTime().format(dateTimeFormatter));
		interviewInfo.setEndTimeText(zonedEndTime.toLocalTime().format(dateTimeFormatter));

		return interviewInfo;

	}

	@Override
	public List<InterviewInfo> findAll() {
		return interviewInfoRepository.findAllByOrderByInterviewLocalDateDescStartTimeAsc(LocalDate.now());
	}

	@Override
	public List<InterviewInfo> findByDate(LocalDate date) {
		// TODO Auto-generated method stub
		return interviewInfoRepository.findByInterviewLocalDateOrderByInterviewLocalDateDescStartTimeAsc(date);
	}

	@Override
	public InterviewInfo findById(int id) {
		return interviewInfoRepository.findById(id);
	}

	@Override
	@Transactional
	public void delete(int id) {
		interviewInfoRepository.deleteById(id);
	}

}
