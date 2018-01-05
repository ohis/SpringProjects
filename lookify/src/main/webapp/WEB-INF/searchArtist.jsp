<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Artist</title>
</head>
<body>
<p><a href="/dashboard">Dashboard</a></p>

   
  
  <table>
    <thead>
       <tr>
         <td>Name</td>
          <td>Rating</td>
           <td>action</td>
       </tr>
    </thead>
    <c:forEach items="${ allsongs }" var="song" varStatus="loop">
    <tbody>
      <tr>
        <td><a href="/show/${song.getID()}"> <c:out value="${song.title}"/></a></td>
        <td> <c:out value="${song.rating}"/></td>
      </tr>
    </tbody>
    </c:forEach>
  </table>
</body>
</html>