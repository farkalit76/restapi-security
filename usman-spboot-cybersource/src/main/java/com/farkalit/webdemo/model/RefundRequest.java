package com.farkalit.webdemo.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RefundRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	protected Double amount;

	protected String requestId;

	/**
	 * 
	 */
	public RefundRequest() {
		//empty
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	@Override
	public String toString() {
		return "RefundRequest [amount=" + amount + ", requestId=" + requestId + "]";
	}

}
