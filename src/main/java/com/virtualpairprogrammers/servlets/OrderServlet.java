package com.virtualpairprogrammers.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.virtualpairprogrammers.data.MenuDao;
import com.virtualpairprogrammers.data.MenuDaoFactory;
import com.virtualpairprogrammers.domain.MenuItem;

@WebServlet("/order.html")
@ServletSecurity(@HttpConstraint(rolesAllowed = { "user" }))
public class OrderServlet extends HttpServlet {

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		MenuDao menuDao = MenuDaoFactory.getMenuDao();
		List<MenuItem> menuItems = menuDao.getFullMenu();
		request.setAttribute("fullOrderMenu", menuItems);

		ServletContext context = request.getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher("/order.jsp");
		dispatcher.forward(request, response);
	}
}
