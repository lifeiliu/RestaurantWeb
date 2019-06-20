package com.virtualpairprogrammers.filters;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class MenuSearchCorrectionRequestWarpper extends HttpServletRequestWrapper {
	private String newSearchTerm;

	public MenuSearchCorrectionRequestWarpper(HttpServletRequest request) {
		super(request);
		// TODO Auto-generated constructor stub
	}

	public void setNewSearchTerm(String newSearchTerm) {
		this.newSearchTerm = newSearchTerm;
	}

	@Override
	public String getParameter(String key) {
		if (key.equals("searchTerm")) {
			return newSearchTerm;
		} else {
			return super.getParameter(key);
		}
	}

}
