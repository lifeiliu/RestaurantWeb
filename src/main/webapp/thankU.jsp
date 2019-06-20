<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script>
	function updateStatus(){
		var request = new XMLHttpRequest();
		request.onreadystatechange =function(){
			if (this.readyState ==4){
				var json = JSON.parse(this.responseText)
				document.getElementById("status").innerHTML = json.status;
				console.log(json.status);
				document.getElementById("time").innerHTML = "Last Updated: ";
			}
		}
		request.open("GET","/updatedStatus?id=${id}",true)
		
		request.send();
	}
	window.setInterval( 
			function(){
				updateStatus();
			},2000);
</script>
<title>Ricky's Restaurant</title>
</head>
<body>
	<jsp:include page="/header.jsp" />
	<p>Thank you - your order has been received. You need to pay $  ${total}</p>
	<p>You order status is <span id="status">${status}</span><input type = "button" value="refresh status" onClick="updateStatus()"/></p>
	<p id="time">${time}</p>
	<jsp:include page="/footer.jsp"></jsp:include>
</body>
</html>