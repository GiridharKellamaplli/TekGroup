package com.tekgroup.tektimesheet.serivce;

import java.time.LocalDate;
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

		Calendar calendar1 = Calendar.getInstance();
		calendar1.setTime(interviewInfo.getStartTime());

		Calendar calendar4 = Calendar.getInstance();
		calendar4.setTime(interviewInfo.getEndTime());

		Date x = calendar1.getTime();
		Date x2 = calendar4.getTime();

		System.out.println(calendar1);
		List<InterviewInfo> slots = interviewInfoRepository
				.findByDateOrderByDateDescStartTimeAsc(interviewInfo.getDate());
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
			 * (interviewInfo.getEndTime().equals(slot.getEndTime()))) return false;
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

	@Override
	public List<InterviewInfo> findByUserName(String name) {
		// TODO Auto-generated method stub
		return interviewInfoRepository.findByName(name);
	}

	@Override
	public List<InterviewInfo> findAll() {
		return interviewInfoRepository.findAllByOrderByDateDescStartTimeAsc();
	}

	@Override
	public List<InterviewInfo> findByDate(LocalDate date) {
		// TODO Auto-generated method stub
		return interviewInfoRepository.findByDateOrderByDateDescStartTimeAsc(date);
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
