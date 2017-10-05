package com.tekgroup.tektimesheet;

import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tekgroup.tektimesheet.dao.InterviewInfoRepository;
import com.tekgroup.tektimesheet.model.InterviewInfo;
import com.tekgroup.tektimesheet.serivce.InterviewInfoServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
public class InterviewInfoControllerTest {

	@InjectMocks
	private InterviewInfoServiceImpl service;

	@Mock
	InterviewInfoRepository repository;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getSlotsTest() throws Exception {
		List<InterviewInfo> ints = getInterviewSlots();
		Mockito.when(repository.findAll()).thenReturn(ints);
		List<InterviewInfo> find = service.findAll();
		Assert.assertNotNull(find);
	}

	@Test
	public void getTodaySlotsTest() throws Exception {
		List<InterviewInfo> intToday = getInterviewSlots();
		LocalDate date = LocalDate.now();
		Mockito.when(repository.findByDateOrderByDateDescStartTimeAsc(date)).thenReturn(intToday);
		List<InterviewInfo> find1 = service.findByDate(date);
		Assert.assertNotNull(find1);
	}

	@Test
	public void getSlotByDateTest() throws Exception {
		List<InterviewInfo> intToday = getInterviewSlots();
		LocalDate date = LocalDate.now();
		Mockito.when(repository.findByDateOrderByDateDescStartTimeAsc(date)).thenReturn(intToday);
		List<InterviewInfo> find1 = service.findByDate(date);
		Assert.assertNotNull(find1);
	}

	@Test
	public void updateSlotTest() throws Exception {
		InterviewInfo update = getSlots(null, null, null, null, null, null, null, null, 0, false, false);
		Mockito.when(repository.findById(12)).thenReturn(update);
		service.findById(12);
	}

	public InterviewInfo getSlots(Integer id, LocalDate date, Time startTime, Time endTime, String name, String mode,
			String client, String vendor, int round, boolean recording, boolean isCancelled) {
		return new InterviewInfo(id, date, startTime, endTime, name, mode, client, vendor, round, recording,
				isCancelled);
	}

	private List<InterviewInfo> getInterviewSlots() {
		InterviewInfo info = new InterviewInfo();
		List<InterviewInfo> intInfo = new ArrayList<InterviewInfo>();
		info.setId(12);
		info.setName("kavya");
		info.setMode("Skype");
		info.setClient("unknown");
		info.setVendor("Vendor");
		info.setRecording(true);
		intInfo.add(info);
		return intInfo;
	}

}
