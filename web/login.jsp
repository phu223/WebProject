<%-- 
    Document   : login
    Created on : Aug 22, 2018, 9:12:18 AM
    Author     : Tachibana Kanade
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="myCss/header.html" %>
        <h1>Login page</h1>
        <s:form action="login" method="POST">
            <s:textfield name="username" value=""  label="username" requiredLabel="username cannot be blank" required="required" />
            <s:password name="password" value="" label="password" requiredLabel="password cannot be blank" required="required" />
            <s:submit value="login" /><font color="red"><c:out value="${sessionScope.userError}" /></font>
            <s:reset value="reset"/>
        </s:form>
        <%@include file="myCss/footer.html" %>
    </body>
</html>
