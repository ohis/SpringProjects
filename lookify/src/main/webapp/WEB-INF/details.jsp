<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Details</title>
</head>
<body>
  <p><a href="/dashboard">Dashboard</a></p>
  
  <h4>Tile <c:out value="${song.title}"/></h4>
  <h4>Artist <c:out value="${song.artist}"/></h4>
  <h4>Rating(1-10) <c:out value="${song.rating}"/></h4>
  
</body>
</html>