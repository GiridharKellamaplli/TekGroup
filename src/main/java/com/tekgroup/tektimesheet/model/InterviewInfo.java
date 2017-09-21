package com.tekgroup.tektimesheet.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="interview_info")
public class InterviewInfo {

	@Id
	@GeneratedValue
	private Integer id;
	private LocalDate date;
	// private LocalTime startTime;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	private String name;
	private String mode;
	private String with;
	private Byte round;
	private boolean isRecording;

	public InterviewInfo() {

	}

	public InterviewInfo(LocalDate date, LocalDateTime startTime, LocalDateTime endTime, String name, String mode,
			String with, Byte round, boolean isRecording) {
		super();
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;
		this.name = name;
		this.mode = mode;
		this.with = with;
		this.round = round;
		this.isRecording = isRecording;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
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

	public String getWith() {
		return with;
	}

	public void setWith(String with) {
		this.with = with;
	}

	public Byte getRound() {
		return round;
	}

	public void setRound(Byte round) {
		this.round = round;
	}

	public boolean isRecording() {
		return isRecording;
	}

	public void setRecording(boolean isRecording) {
		this.isRecording = isRecording;
	}

	@Override
	public String toString() {
		return "InterviewInfo [id=" + id + ", date=" + date + ", startTime=" + startTime + ", endTime=" + endTime
				+ ", name=" + name + ", mode=" + mode + ", with=" + with + ", round=" + round + ", isRecording="
				+ isRecording + "]";
	}
	
	

}
