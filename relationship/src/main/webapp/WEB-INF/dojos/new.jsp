<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix = "form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Dojo</title>
</head>
<body>
  <h1>New Dojo</h1>
  <form:form action="/dojos/create" method="POST" modelAttribute="newDojo">
    <form:label path="name">Name :</form:label>
    <form:input path="name" type="text"/>
    <form:errors path="name"/>
    <br>
    <br>
    <input type="submit" value="Create"/>
  </form:form>
</body>
</html>