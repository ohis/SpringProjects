<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ninja Gold Game</title>
</head>
<body>
   <h1>Your Gold : <c:out value="${result}"></c:out></h1>
   
   <h1>Farm</h1>
   <form  action="/farm" method="post">
    <p>(earns 10-20 gold)</p>
    <input type="hidden" name="farm" value="farm">
    <input type="submit" value="Find Gold">
   </form>
   
   <h1>Cave</h1>
   <form action="/cave" method="post">
   <p>(earns 5-10 gold)</p>
     <input type="hidden" name="cave">
     <input type="submit" value="Find Gold!">
   </form>
   
   <h1>House</h1>
   <form action="/house" method="post">
   <p>(earns 2-5 gold)</p>
   <input type="hidden" name="house">
   <input type ="submit" value="Find Gold!">
   </form>
   
   <h1>Casino!</h1>
   <form action="/casino" method="post">
   <p>(earns/takes 0-50 gold)</p>
   <input type="hidden" name="casino">
   <input type="submit" value="Find Gold!">
   </form>
   
   <h1>Activities:</h1>
   <textarea rows="6" cols="90">
   <c:forEach var="i" items="${msg}" varStatus="loop">
     <c:out value="${i}" />
   </c:forEach>
   </textarea>
</body>
</html>