<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import ="java.util.List" %>
<%@page import ="com.virtualpairprogrammers.domain.MenuItem" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ricky's Restaurant</title>
</head>
<body>
	<jsp:include page="/header.jsp" />
	<form action = "orderReceived.html" method = 'POST'>
	
	<ul>
	<% List<MenuItem> fullMenuItems = ( List<MenuItem>) request.getAttribute("fullOrderMenu"); 
		for(MenuItem menuItem: fullMenuItems){
			out.println("<li>" + menuItem + "<input type='text' name='item_" +menuItem.getId() +"' /> </li>");
		}
	%>
		
	</ul>
	<input type="submit" value = "Order">
	</form>
	<jsp:include page="/footer.jsp"></jsp:include>
</body>
</html>