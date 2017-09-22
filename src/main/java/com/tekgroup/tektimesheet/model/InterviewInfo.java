package com.tekgroup.tektimesheet.model;

import java.sql.Date;
import java.sql.Time;
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
//	@Column(name = "date", nullable = false)
	private LocalDate date;
//	@Column(name = "startTime", nullable = false)
	private Time startTime;
//	@Column(name = "endTime", nullable = false)
	private Time endTime;
//	@Column(name = "name", nullable=false)
	private String name;
//	@Column(name = "mode", nullable=false)
	private String mode;
//	@Column(name = "client", nullable=false)
	private String client;
	private int round;
	private String recording;

	public InterviewInfo() {

	}

	public InterviewInfo(LocalDate date, Time startTime, Time endTime, String name, String mode, String client, int round,
			String recording) {
		super();
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;
		this.name = name;
		this.mode = mode;
		this.client = client;
		this.round = round;
		this.recording = recording;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
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

	public int getRound() {
		return round;
	}

	public void setRound(int round) {
		this.round = round;
	}

	public String getRecording() {
		return recording;
	}

	public void setRecording(String recording) {
		this.recording = recording;
	}

	@Override
	public String toString() {
		return "InterviewInfo [id=" + id + ", date=" + date + ", startTime=" + startTime + ", endTime=" + endTime
				+ ", name=" + name + ", mode=" + mode + ", with=" + client + ", round=" + round + ", isRecording="
				+ recording + "]";
	}

}
