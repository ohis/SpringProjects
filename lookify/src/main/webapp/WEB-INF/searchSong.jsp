<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Top Ten Songs</title>
</head>
<body>
   <p><a href="/dashboard">Dashboard</a></p>
 <p>Top Ten Songs :</p>
  <p> 
   <c:forEach items="${topSongs}" var="song" varStatus="loop"> 
       <c:out value="${song.rating}"></c:out>  
           - <a href="/show/${loop.index + 1}"><c:out value="${song.title}"></c:out></a>  -  <c:out value="${song.artist}"></c:out>  
           
           <br>
  </c:forEach>
  </p>
</body>
</html>