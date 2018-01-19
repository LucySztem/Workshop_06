<%--
  Created by IntelliJ IDEA.
  User: lucy
  Date: 19.01.18
  Time: 15:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@	taglib	prefix="form"
                 uri="http://www.springframework.org/tags/form"	%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page isELIgnored = "false" %>
<html>
<head>
    <title>Add new User</title>
</head>
<body>
<%--@elvariable id="user" type="pl.coderslab.entity.User"--%>
<form:form action="/user/register" method = "post" modelAttribute="user">
   Username <form:input path="username"/><br>
    Email <form:input path="email"/><br>
    Password <form:password path="password"/><br>
    <form:errors path="*"/>
    <input type="submit" value="send">
</form:form>
</body>
</html>
