<%-- 
    Document   : Search
    Created on : Jun 4, 2018, 9:10:59 AM
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
        <title>Search</title>
    </head>
    <body>
        <%@include file="myCss/header.html" %>
        <font color = "red" >
        Welcome <c:out value=" ${sessionScope.rank}"/> <c:out value=" ${sessionScope.username}"/> 

        </font><br/>
        <h1>Choose your option</h1>

        <s:a href="mission.jsp">check mission</s:a><br/>

        <s:a href="pilot.jsp">check pilot</s:a><br/>

        <s:a href="gear.jsp">check gear</s:a><br/>

        <s:a href="soidler.jsp">check soidler</s:a><br/>
        <%@include file="myCss/footer.html" %>
    </body>


</html>
