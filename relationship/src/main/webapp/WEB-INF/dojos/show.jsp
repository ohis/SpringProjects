<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dojo Page</title>
</head>
<body>
  <h1>In Show</h1>
  <h1><c:out value="${dojo.name }"></c:out> Location Ninjas</h1>
  
  <table>
    <thead>
    <tr>
       <td>First Name</td>
       <td>Last Name</td>
       <td>Age</td>
    </tr>
    </thead>
    <c:forEach items="${dojoNinja}" var="dojos">
    <tbody>
    <tr>
       <td><c:out value="${dojos.firstName }"></c:out></td>
       <td><c:out value="${dojos.lastName }"></c:out></td>
       <td><c:out value="${dojos.age }"></c:out></td>
    </tr>
    </tbody>
    </c:forEach>
  </table>
</body>
</html>