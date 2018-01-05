<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "form" uri ="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix ="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Song</title>
</head>
<body>
   <p><a href="/dashboard">Dashboard</a>
   
   <form:form action="/addSong" method="POST" modelAttribute="newSong">
     <form:label path="title" name="title">Title</form:label>
     <form:input path="title" type="text"/>
     <form:errors path="title"/>
      <br>
      <br>
     <form:label path="artist" name="artist">Artist</form:label>
     <form:input path="artist" type="text"/>
      <form:errors path="artist"/>
     <br>
     <br>
     <form:label path="rating" name="rating">Rating(1-10)</form:label>
     <form:input path="rating" type="number"/>
      <form:errors path="rating"/>
     <br>
     <br>
     <input type="submit" value="Add Song"/>
   </form:form>
</body>
</html>