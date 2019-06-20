package com.virtualpairprogrammers.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.virtualpairprogrammers.data.MenuDao;
import com.virtualpairprogrammers.data.MenuDaoFactory;
import com.virtualpairprogrammers.domain.Order;

@WebServlet(value = "/kitchenAsyncServlet", asyncSupported = true)
public class KitchenAsyncServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		Long Size = Long.parseLong(request.getParameter("size"));

		MenuDao dao = MenuDaoFactory.getMenuDao();
		while (dao.getAllOrders().size() < Size) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}

		Order order = dao.getOrder(Size);
		out.println("<p><strong>Next Order: </strong>" + order.toString() + "</p>");
		out.close();
	}
}
