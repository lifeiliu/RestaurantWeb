<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ricky's Restaurant</title>
</head>
<body>
	<jsp:include page="/header.jsp" />
	
	<ul>
		
	<c:forEach items="${fullMenu}" var="menuItem">
		<li>${menuItem}</li>
	</c:forEach>
	</ul>
	<jsp:include page="/footer.jsp"></jsp:include>
</body>
</html>