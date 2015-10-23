<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>계산기폼</title>
</head>
<%-- calcForm.jsp --%>
<body>
  <center>
    <h3>계산기폼</h3>
    <hr>
    <form action="calc" method="post">
      <input type="text" name="su1" size="4">
      <select name="oper">
         <option value="+">+</option>
         <option value="-">-</option>
         <option value="*">*</option>
         <option value="/">/</option>
      </select>
      <input type="text" name="su2" size="4">
      <input type="submit" value="계산">
    </form>     
    <br>       
    ${key }<br>
    <%= request.getAttribute("key") %>
  </center>
</body>








</html>







