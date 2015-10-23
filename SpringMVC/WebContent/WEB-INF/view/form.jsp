<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%-- form.jsp --%>
<body>
  <h3>입력폼1</h3>
  <form action="submitName" method="get">
     이름: <input type="text" name="username">
     <input type="submit" value="전송">
  </form>
  <hr>
  
  <h3>입력폼2</h3>
  <form action="submitName" method="post">
     이름: <input type="text" name="username">
     <input type="submit" value="전송">
  </form>
  
</body>
</html>









