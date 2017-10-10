package com.tekgroup.tektimesheet.model;

import java.sql.Time;
import java.time.DayOfWeek;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "interview")
public class InterviewInfo {

	@Id
	@GeneratedValue()
	private Integer id;
	private LocalDate interviewLocalDate;
	private String interviewDate;
	private Time startTime;
	private Time endTime;
	private String startTimeText;
	private String endTimeText;
	private DayOfWeek dayOfWeek;
	private String name;
	private String mode;
	private String client;
	private String vendor;
	private int round;
	private boolean recording;
	private boolean isCancelled;

	public InterviewInfo() {

	}

	public InterviewInfo(LocalDate interviewLocalDate, String interviewDate, Time startTime, Time endTime,
			String startTimeText, String endTimeText, DayOfWeek dayOfWeek, String name, String mode, String client,
			String vendor, int round, boolean recording, boolean isCancelled) {
		this.interviewLocalDate = interviewLocalDate;
		this.interviewDate = interviewDate;
		this.startTime = startTime;
		this.endTime = endTime;
		this.startTimeText = startTimeText;
		this.endTimeText = endTimeText;
		this.dayOfWeek = dayOfWeek;
		this.name = name;
		this.mode = mode;
		this.client = client;
		this.vendor = vendor;
		this.round = round;
		this.recording = recording;
		this.isCancelled = isCancelled;
	}

	public LocalDate getInterviewLocalDate() {
		return interviewLocalDate;
	}

	public void setInterviewLocalDate(LocalDate interviewLocalDate) {
		this.interviewLocalDate = interviewLocalDate;
	}

	public String getInterviewDate() {
		return interviewDate;
	}

	public void setInterviewDate(String interviewDate) {
		this.interviewDate = interviewDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Time getStartTime() {
		return startTime;
	}

	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

	public Time getEndTime() {
		return endTime;
	}

	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public int getRound() {
		return round;
	}

	public void setRound(int round) {
		this.round = round;
	}

	public boolean getRecording() {
		return recording;
	}

	public void setRecording(boolean recording) {
		this.recording = recording;
	}

	public boolean isCancelled() {
		return isCancelled;
	}

	public void setCancelled(boolean isCancelled) {
		this.isCancelled = isCancelled;
	}

	public DayOfWeek getDayOfWeek() {
		return getInterviewLocalDate().getDayOfWeek();
	}

	public void setDayOfWeek(DayOfWeek dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public String getStartTimeText() {
		return startTimeText;
	}

	public void setStartTimeText(String startTimeText) {
		this.startTimeText = startTimeText;
	}

	public String getEndTimeText() {
		return endTimeText;
	}

	public void setEndTimeText(String endTimeText) {
		this.endTimeText = endTimeText;
	}

	@Override
	public String toString() {
		return "InterviewInfo [id=" + id + ", interviewLocalDate=" + interviewLocalDate + ", interviewDate="
				+ interviewDate + ", startTime=" + startTime + ", endTime=" + endTime + ", startTimeText="
				+ startTimeText + ", endTimeText=" + endTimeText + ", dayOfWeek=" + dayOfWeek + ", name=" + name
				+ ", mode=" + mode + ", client=" + client + ", vendor=" + vendor + ", round=" + round + ", recording="
				+ recording + ", isCancelled=" + isCancelled + "]";
	}

}
