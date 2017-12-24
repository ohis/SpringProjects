<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix ="form" uri ="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix ="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><c:out value="${lang.name}"></c:out></title>
</head>
<body>
 <h1>in Edit</h1>
 
 <form:form action="/lang/edit/${id}" method="POST" modelAttribute="editLang">
   <form:label path="name" >Name
      <form:input path="name" type="text"/>
      <form:errors path ="name"/>
   </form:label>
   <br>
   <br>
   <form:label path="creator" >Creator
      <form:input path="creator" type="text"/>
      <form:errors path ="creator"/>
   </form:label>
   <br>
   <br>
   
   <form:label path="version" >Version
      <form:input path="version" type="text"/>
      <form:errors path ="version"/>
   </form:label>
   <br>
   <br>
   <input type="submit" value="Submit"/>
 </form:form>
</body>
</html>