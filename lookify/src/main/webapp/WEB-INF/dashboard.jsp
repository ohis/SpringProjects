<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
  <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lookify!</title>
</head>
<body>
 <p><a href="/songs/new">Add New</a></p> <br> <p><a href="/TopSongs">Top Songs</a></p>
   <form:form action="/search" method="POST" modelAttribute="Currentartist">
     
     <form:input path="artist" type="text" name="artist"/>
     <input type="submit" value="Search Artists"/>
   </form:form>
   <br>
   <table>
     <thead>
        <tr>
           <td>Name</td>
           <td>rating</td>
           <td>actions</td>       
        </tr>
     </thead>
     <c:forEach items="${songs}" var = "song" varStatus="loop">
     <tbody>
       <tr>
        <td><a href="/show/${song.getID()}"><c:out value="${song.title }"/></a></td>
        
        <td><c:out value="${song.rating }"/></td>
        <td><a href="/song/delete/${song.getID()}">delete</a></td>
       </tr>     
     </tbody>  
     </c:forEach> 
   </table>
   
</body>
</html>