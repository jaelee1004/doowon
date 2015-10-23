<%@page import="kr.ac.doowon.model.beans.Person"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Person정보출력</title>
</head>
<%-- list.jsp --%>
<body>
  <center>
    <h3>Person목록</h3>
    <hr>
    <table border="1" cellpadding="5">
       <tr bgcolor="yellow">
         <th>이름</th>
         <th>나이</th>
         <th>직업</th>
       </tr>
       <c:forEach var="person" items="${list }">
         <tr>
            <td><a href="updateForm?name=${person.name }">${person.name }</a></td>
            <td>${person.age }</td>
            <td>${person.job }</td>
         </tr>
       </c:forEach>
     <%--
        List<Person> list =  (List<Person>)request.getAttribute("list");
        for(int i=0; i<list.size(); i++){        
        	out.print("<tr>");
        	out.print("<td>데이터</td>");
        	out.print("<td>데이터</td>");
        	out.print("<td>데이터</td>");
        	out.print("</tr>");
        }
     --%>
    </table>
  </center>
</body>
</html>











