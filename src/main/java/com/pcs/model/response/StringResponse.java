package com.pcs.model.response;

public class StringResponse {

	private String response;

	private String statusCode;

	public StringResponse(String response, String statusCode) {
		this.response = response;
		this.statusCode = statusCode;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

}