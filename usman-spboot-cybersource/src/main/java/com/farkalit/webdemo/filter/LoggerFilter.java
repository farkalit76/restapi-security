/**
 * 
 */
package com.farkalit.webdemo.filter;

import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

/**
 * @author farkalitusman
 *
 */
@Slf4j
@Component
public class LoggerFilter extends RequestWrappingFilter{

	 public static final String REQUEST_ID = "requestId";
	 
	@Override
    protected void execute(CustomRequestWrapper customRequestWrapper, HttpServletResponse response, FilterChain filterChain) {
        populateMDC(customRequestWrapper);

        logRequest(customRequestWrapper);
    }

    private void logRequest(CustomRequestWrapper customRequestWrapper) {

        StringBuilder headers = createHeadersAsString(customRequestWrapper);

        StringBuilder params = createRequestParamsAsString(customRequestWrapper);

        log.info("http Request received headers: {}, Params: {}, URI: {}, body: {}", headers, params,
                customRequestWrapper.getRequestURI(), customRequestWrapper.getRequestBodyAsString());
    }

    private StringBuilder createRequestParamsAsString(CustomRequestWrapper customRequestWrapper) {
        Enumeration<String> parameterNames = customRequestWrapper.getParameterNames();
        StringBuilder builder = new StringBuilder();
        builder.append("{");
        while (parameterNames.hasMoreElements()) {
            String parameter = parameterNames.nextElement();
            builder.append(parameter);
            builder.append(":");
            builder.append(customRequestWrapper.getParameter(parameter));
            builder.append(",");
        }
        builder.append("}");
        return builder;
    }

    private StringBuilder createHeadersAsString(CustomRequestWrapper customRequestWrapper) {
        Enumeration<String> headerNames = customRequestWrapper.getHeaderNames();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        while(headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            stringBuilder.append(headerName);
            stringBuilder.append(":");
            stringBuilder.append(customRequestWrapper.getHeader(headerName));
            stringBuilder.append(",");
        }
        stringBuilder.append("}");
        return stringBuilder;
    }

    private void populateMDC(CustomRequestWrapper customRequestWrapper) {
        MDC.put(REQUEST_ID, customRequestWrapper.getParameter(REQUEST_ID));
    }
}
