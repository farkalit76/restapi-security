package com.farkalit.webdemo.model;

import java.io.Serializable;

public class RefundResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected String orderId;

	protected String channel;

	protected Double amount;

	protected String requestId;
	
	protected String type;

	/**
	 * 
	 */
	public RefundResponse() {
		// empty
	}

	public RefundResponse(String orderId, String channel, Double amount, String requestId) {
		super();
		this.orderId = orderId;
		this.channel = channel;
		this.amount = amount;
		this.requestId = requestId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "RefundRequest [amount=" + amount + ", requestId=" + requestId + "]";
	}
}
