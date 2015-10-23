<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>수정폼</title>
</head>
<%-- update_form.jsp --%>
<body>
  <h3>수정폼</h3> 
  <hr>
  <form method="post" action="update">
	  이름: <input type="text" name="name" value="${person.name }"> <br>
	  나이: <input type="text" name="age" value="${person.age }"> <br>
	  직업: <input type="text" name="job" value="${person.job }"> <br>
	  <input type="submit" value="등록">
	  <input type="submit" value="삭제">
  </form>
</body>
</html>










