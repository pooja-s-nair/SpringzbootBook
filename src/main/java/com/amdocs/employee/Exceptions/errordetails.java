package com.amdocs.employee.Exceptions;
import java.time.LocalDateTime;

public class errordetails {
	String message;
	int statuscode;
	LocalDateTime datetime;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getStatuscode() {
		return statuscode;
	}
	public void setStatuscode(int statuscode) {
		this.statuscode = statuscode;
	}
	public LocalDateTime getDatetime() {
		return datetime;
	}
	public void setDatetime(LocalDateTime datetime) {
		this.datetime = datetime;
	}
	public errordetails(String message, int statuscode, LocalDateTime datetime) {
		super();
		this.message = message;
		this.statuscode = statuscode;
		this.datetime = datetime;
	}
	public errordetails() {
		super();
	}
	

}

