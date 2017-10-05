package com.tekgroup.tektimesheet;

import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.tekgroup.tektimesheet.model.InterviewInfo;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TekTimeSheetApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TekTimeSheetIntegrationTests {

	@Value("${local.server.port}")
	private int port;

	@Autowired
	private TestRestTemplate testRestTemplate;
	
	private HttpHeaders headers = new HttpHeaders();

	private static final String URL = "/interview";

	@Test
	public void createSlotTest() throws Exception {
		final HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
		try {
			ResponseEntity<Void> entity = testRestTemplate.exchange(URL + "/", HttpMethod.POST, requestEntity,
					void.class);
			Void entries = entity.getBody();
			Assert.assertNotNull(entries);
			Assert.assertEquals("The message is ", entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void getSlotsTest() throws Exception {
		final HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
		try {
			Object obj = new Object[] {};
			ResponseEntity<InterviewInfo> entity = testRestTemplate.exchange(URL + "/", HttpMethod.GET, requestEntity,
					InterviewInfo.class, obj);
			final InterviewInfo entries = entity.getBody();
			Assert.assertNotNull(entries);
		//	Assert.assertEquals("Total no. of columns are ", 11, entries.size());
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void getTodaySlotsTest() throws Exception {
		HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
		try {
			Object obj = new Object[] {};
			ResponseEntity<InterviewInfo> entity = testRestTemplate.exchange(URL + "/today", HttpMethod.GET, requestEntity,
					InterviewInfo.class, obj);
			final InterviewInfo entries = entity.getBody();
			Assert.assertNotNull(entries);
	//		Assert.assertEquals("Total no. of columns are ", 11, entries.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void getSlotsByDateTest() throws Exception {
		HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
		try {
			Object obj = new Object[] {};
			ResponseEntity<InterviewInfo> entity = testRestTemplate.exchange(URL + "/{date}", HttpMethod.GET, requestEntity,
					InterviewInfo.class, obj);
			final InterviewInfo entries = entity.getBody();
			Assert.assertNotNull(entries);
	//		Assert.assertEquals("Total no. of columns are ", 11, entries.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void updateSlotTest() throws Exception {
		HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
		try {
			ResponseEntity<Void> entity = testRestTemplate.exchange(URL + "/{id}", HttpMethod.PUT, requestEntity,
					void.class);
			Void entries = entity.getBody();
			Assert.assertEquals("Total no. of columns are ", 11, entries);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void deleteSlotTest() throws Exception {
		HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
		try {
			ResponseEntity<Void> entity = testRestTemplate.exchange(URL + "/{id}", HttpMethod.DELETE, requestEntity,
					void.class);
			Void entries = entity.getBody();
			Assert.assertEquals("Total no. of columns are ", 11, entries);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
