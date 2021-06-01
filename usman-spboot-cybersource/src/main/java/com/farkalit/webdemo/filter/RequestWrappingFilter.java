/**
 * 
 */
package com.farkalit.webdemo.filter;

import org.slf4j.MDC;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author farkalitusman
 *
 */
public abstract class RequestWrappingFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		CustomRequestWrapper customRequestWrapper = new CustomRequestWrapper(request);

		execute(customRequestWrapper, response, filterChain);

		filterChain.doFilter(customRequestWrapper, response);

		MDC.clear();

	}

	protected abstract void execute(CustomRequestWrapper customRequestWrapper, HttpServletResponse response,
			FilterChain filterChain);

}
