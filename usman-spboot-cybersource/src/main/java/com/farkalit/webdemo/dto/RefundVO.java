package com.farkalit.webdemo.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author farkalitusman
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RefundVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected String orderId;

	protected Double amount;

	protected String channel;
	
	protected String requestId;

	public RefundVO() {
	}

	public RefundVO(String orderId, Double amount, String requestId, String channel) {
		this.orderId = orderId;
		this.amount = amount;
		this.requestId=requestId;
		this.channel = channel;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channelId) {
		this.channel = channelId;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	@Override
	public String toString() {
		return "RefundVO [orderId=" + orderId + ", amount=" + amount + ", channel=" + channel + ", requestId="
				+ requestId + "]";
	}

}
