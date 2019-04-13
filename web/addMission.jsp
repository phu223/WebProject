<%-- 
    Document   : addMission
    Created on : Aug 23, 2018, 9:19:16 AM
    Author     : Tachibana Kanade
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@page import="phu.dtos.MissionDTO" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="myCss/header.html" %>
        <s:form action="AddMissionAction">
            <s:textfield name="missionCode" value="" label="mission code" required="required" />
            <font color = "red" ><h2><c:out value="${sessionScope.missionError}" /></h2></font>
            <s:textfield name="missionName" value=""  label="mission name"  required="required" />
            <s:textfield name="startDate" value="" label="start date" required="required" />
            <font color = "red" ><h2><c:out value="${sessionScope.dateError}" /></h2></font>
            <s:textfield name="status" value="" label="status" required="required" />
            <s:textfield name="type" value="" label="mission type" required="required" />
            <s:submit value="Add Mission" />
        </s:form>
            <%@include file="myCss/footer.html" %>
    </body>
</html>
