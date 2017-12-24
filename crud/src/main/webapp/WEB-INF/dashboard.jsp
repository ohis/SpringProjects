<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Languages</title>
</head>
<body>
  <h1>Who are you?</h1>
  
 <table>
    <thead>
    <tr>
     <td>Name</td>
      <td>Creator</td>
      <td>Version</td>
      <td>action</td> 
    </tr>
    </thead>
     <c:forEach items="${langs}" var="lang" varStatus="loop">
    <tbody>
   
    <tr>
    <td><a href="/lang/show/${loop.index}"><c:out value="${lang.name}"/></a></td>
    <td><c:out value="${lang.creator}"/></td>
    <td><c:out value="${lang.version}"/></td>
    <td><a href="/lang/delete/${loop.index}">delete</a> <a href="/lang/edit/${loop.index}">edit</a></td>
    </tr>
    
    </tbody>
    </c:forEach>
 </table>
  <br>
  <br>
  <p class='error'><form:errors path="language.*"/></p>
		
		<div class="form-container">
			<form:form action="/lang" method="POST" modelAttribute="lang">
				<p>
					<form:label path="name" for="name">Name</form:label>
					<form:input path="name" class="input-size float" type="text" name="name"/>
				</p>
				<p>
					<form:label path="creator" for="creator">Creator</form:label>
					<form:input path="creator" class="input-size float" type="text" name="creator"/>
				</p>
				<p>
					<form:label path="version" for="version">Version</form:label>
					<form:input path="version" class="input-size float" type="text" name="version"/>
				</p>
				<input class="float" type="submit" value="Submit" />						
			</form:form>
		</div>

 </body>
</html>