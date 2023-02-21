package com.example.socialMedia.genericExceptionHandling;

import java.time.LocalDate;


public class ErrorDetails {
	private LocalDate date;
	private String timestamp;
	private String details;

	public ErrorDetails() {

	}

	public ErrorDetails(LocalDate date, String timestamp, String details) {
		super();
		this.date = date;
		this.timestamp = timestamp;
		this.details = details;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

}
