package com.virtualpairprogrammers.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.virtualpairprogrammers.data.MenuDao;
import com.virtualpairprogrammers.data.MenuDaoFactory;
import com.virtualpairprogrammers.domain.Order;

@WebServlet("/thankYou.html")
@ServletSecurity(@HttpConstraint(rolesAllowed = { "user" }))

public class ThankYouServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		HttpSession session = request.getSession();
		Long orderId = (Long) session.getAttribute("orderId");
		MenuDao dao = MenuDaoFactory.getMenuDao();
		Order order = dao.getOrder(orderId);
		Double total = order.getOrderTotal();
		request.setAttribute("total", total);
		request.setAttribute("status", order.getStatus());
		request.setAttribute("id", orderId);

		if (total == null) {
			response.sendRedirect("/order.html");
			return;
		}

		ServletContext context = request.getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher("/thankU.jsp");
		dispatcher.forward(request, response);

	}
}
