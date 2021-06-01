/**
 * 
 */
package com.farkalit.webdemo.filter;

import com.fasterxml.jackson.databind.JsonNode;

import lombok.Data;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.util.ContentCachingRequestWrapper;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author farkalitusman
 *
 */
@Data
public class CustomRequestWrapper extends ContentCachingRequestWrapper{

	private JsonNode jsonNode;
    private String requestBody;

    private ServletInputStream customServletInputStream;

    public CustomRequestWrapper(HttpServletRequest request) throws IOException {
        super(request);
        createJsonBody();
    }

    private void createJsonBody() throws IOException {

        char []charBuffer = new char[128];

        StringBuilder stringBuilder = getStringBuilder(charBuffer);

        requestBody = stringBuilder.toString();

        if (StringUtils.isNoneEmpty(requestBody)) {
            jsonNode = CommonUtil.getObjectMapper().readValue(requestBody, JsonNode.class);
        }
    }

    public String getRequestBodyAsString() {
        return jsonNode != null ? jsonNode.toString() : "";
    }

    @Override
    public ServletInputStream getInputStream() {
        if (customServletInputStream == null) {
            customServletInputStream = new CustomStringServletInputStream(getRequestBody().getBytes());
        }
        return customServletInputStream;
    }

    private StringBuilder getStringBuilder(char[] charBuffer) throws IOException {
        StringBuilder stringBuilder;
        int bytesRead;
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(super.getInputStream()))) {
            stringBuilder = new StringBuilder();
            while ((bytesRead = bufferedReader.read(charBuffer)) > 0)
                stringBuilder.append(charBuffer, 0, bytesRead);
        }
        return stringBuilder;
    }

}
