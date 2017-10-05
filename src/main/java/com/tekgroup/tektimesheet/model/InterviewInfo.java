package com.tekgroup.tektimesheet.model;

import java.sql.Time;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "interview")
public class InterviewInfo {

	@Id
	@GeneratedValue()
	private Integer id;
	
	private LocalDate date;
	private Time startTime;
	private Time endTime;
	
	private String name;
	private String mode;
	
	private String client;
	
	private String vendor;
	private int round;
	private boolean recording;
	private boolean isCancelled;

	public InterviewInfo() {

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

	public InterviewInfo(Integer id, LocalDate date, Time startTime, Time endTime, String name, String mode,
			String client, String vendor, int round, boolean recording, boolean isCancelled) {
		super();
		this.id = id;
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;
		this.name = name;
		this.mode = mode;
		this.client = client;
		this.vendor = vendor;
		this.round = round;
		this.recording = recording;
		this.isCancelled = isCancelled;
	}

	@Override
	public String toString() {
		return "InterviewInfo [id=" + id + ", date=" + date + ", startTime=" + startTime + ", endTime=" + endTime
				+ ", name=" + name + ", mode=" + mode + ", client=" + client + ", vendor=" + vendor + ", round=" + round
				+ ", recording=" + recording + ", isCancelled=" + isCancelled + "]";
	}

}
