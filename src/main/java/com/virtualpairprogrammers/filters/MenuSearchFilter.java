package com.virtualpairprogrammers.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/searchResults.html")
public class MenuSearchFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse reponse, FilterChain chain)
			throws IOException, ServletException {
		String searchTerm = request.getParameter("searchTerm");
		System.out.println("from filter we know that you searched: " + searchTerm);
		chain.doFilter(request, reponse);

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
