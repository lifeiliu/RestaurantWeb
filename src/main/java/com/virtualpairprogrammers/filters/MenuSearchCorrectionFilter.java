package com.virtualpairprogrammers.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/searchResults.html")
public class MenuSearchCorrectionFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String searchTerm = request.getParameter("searchTerm");
		if (searchTerm.toLowerCase().equals("chook")) {
			MenuSearchCorrectionRequestWarpper warpper = new MenuSearchCorrectionRequestWarpper(
					(HttpServletRequest) request);
			warpper.setNewSearchTerm("chicken");
			chain.doFilter(warpper, response);
		} else {
			chain.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
