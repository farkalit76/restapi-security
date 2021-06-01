package com.farkalit.webdemo.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.farkalit.webdemo.model.RefundVO;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author farkalitusman
 *
 */
@Component
public class JSONPojoUtil {

	private static final Logger LOG = LogManager.getLogger(JSONPojoUtil.class);

	/**
	 * Empty private constructor
	 */
	private JSONPojoUtil() {
	}

	/**
	 * Converting refund object to JSON string
	 * 
	 * @param refurefundObjnd
	 * @return
	 */
	public static String convertObjectToJson(Object object) {

		String jsonStr = "";
		ObjectMapper mapper = new ObjectMapper();
		try {
			jsonStr = mapper.writeValueAsString(object);
		} catch (Exception e) {
			LOG.error("POJO to JSON Conversion error:{}", e.getMessage());
			return jsonStr;
		}
		return jsonStr;
	}

	/**
	 * Converting refundJson String to RefundVO object
	 * 
	 * @param refundJson
	 * @return
	 */
	public static RefundVO convertToPOJO(String refundJson) {

		RefundVO refundObj = new RefundVO();
		ObjectMapper mapper = new ObjectMapper();
		try {
			refundObj = mapper.readValue(refundJson, RefundVO.class);
		} catch (Exception e) {
			LOG.error("JSON to Java Object Conversion Error:{}", e.getMessage());
			return null;
		}
		return refundObj;
	}
}
