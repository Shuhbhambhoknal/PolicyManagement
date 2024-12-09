package com.capg.policyapp.exception;

import java.time.LocalDate;

public class ExceptionResponse {
	private LocalDate timestamp;
	private String message;
	
	private String httpCodeMessage;
	private String details;
	public ExceptionResponse(LocalDate localDate, String message, String details,String httpCodeMessage) {
		this.timestamp = localDate;
		this.message = message;
		this.httpCodeMessage=httpCodeMessage;
		this.details = details;
		
	}
	public LocalDate getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDate timestamp) {
		this.timestamp = timestamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public String getHttpCodeMessage() {
		return httpCodeMessage;
	}
	public void setHttpCodeMessage(String httpCodeMessage) {
		this.httpCodeMessage = httpCodeMessage;
	}
	
	


}