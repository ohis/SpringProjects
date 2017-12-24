<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dojo Survey Index</title>
</head>
<body>
  <form action="/login" method="post">
    <label>Your Name :</label>
    <input type="text" name="name">
    <br>
    <label>Dojo Location :</label>
    <select name="location">
       <option value="dallas">Dallas</option>
       <option value="san jose">San Jose</option>
       <option value="burbank">Burbank</option>
       <option value="seattle">Seattle</option>
    </select>
     <br>
     <label>Favorite Language</label>
    <select name= "language">
      <option value="python">Python</option>
      <option value="java">Java</option>
      <option value="c">C</option>
      <option value="javascript">JavaScript</option>
    </select>
    <br>
    <br>
    <label>Comment (optional) :</label>
    <br>
    <br>
    <textarea rows="4" cols="40" name="comment"></textarea>
    <br>
    <input type="submit" value="Submit">
  </form>
</body>
</html>