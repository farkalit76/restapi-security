/**
 * 
 */
package com.farkalit.webdemo.service;

import java.sql.Timestamp;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.farkalit.webdemo.dto.RefundVO;
import com.farkalit.webdemo.model.Paycontract;
import com.farkalit.webdemo.model.PaycontractId;
import com.farkalit.webdemo.repository.PaycontractRepository;


/**
 * @author farkalitusman
 *
 */
@Service
public class PaycontractService {

	private static final Logger LOG = LogManager.getLogger(PaycontractService.class);

	@Autowired
	private PaycontractRepository paycontractRepository;

	/**
	 * 
	 * @return
	 */
	public List<Paycontract> findAll() {
		return paycontractRepository.findAll();
	}

	/**
	 * 
	 * @param refund
	 * @return
	 */
	public Paycontract findOne(RefundVO refund) {
		PaycontractId id = new PaycontractId(refund.getOrderId(), refund.getRequestId());
		return paycontractRepository.findById(id).orElse(null);
	}

	/**
	 * 
	 * @param refund
	 */
	public void save(RefundVO refund) {
		LOG.info("refund:{}", refund);
		PaycontractId pid = new PaycontractId(refund.getOrderId(), refund.getRequestId());
		Paycontract entity = new Paycontract(pid, refund.getChannel(), new Timestamp(System.currentTimeMillis()));
		Paycontract save = paycontractRepository.save(entity);
		LOG.info("Paycontract saved:{}", save);
	}
}
