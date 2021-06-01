/**
 * 
 */
package com.farkalit.webdemo.model;

import java.sql.Timestamp;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author farkalitusman
 *
 */
@Entity
@Table(name = "paycontract")
public class Paycontract {

	@EmbeddedId
	protected PaycontractId paycontractId;

	protected String channelId;
	
	protected Timestamp createDatetime;

	public Paycontract() {
		//default
	}

	public Paycontract(PaycontractId paycontractId, String channelId, Timestamp createDatetime) {
		this.paycontractId = paycontractId;
		this.channelId = channelId;
		this.createDatetime = createDatetime;
	}

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	public Timestamp getCreateDatetime() {
		return createDatetime;
	}

	public void setCreateDatetime(Timestamp createDatetime) {
		this.createDatetime = createDatetime;
	}

	@Override
	public String toString() {
		return "Paycontract [paycontractId=" + paycontractId + ", channelId=" + channelId + ", createDatetime="
				+ createDatetime + "]";
	}

}
