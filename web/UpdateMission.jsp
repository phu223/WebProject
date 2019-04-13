<%-- 
    Document   : addMission
    Created on : Aug 23, 2018, 9:19:16 AM
    Author     : Tachibana Kanade
--%>

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
        <s:iterator value="list">
            <s:form action="UpdateMissionAction">
                <s:textfield name="missionCode" value="%{missionCode}" label="mission code" readonly="true" />
                <s:textfield name="missionName" value="%{missionName}"  label="mission name" required="required"  />
                <s:textfield name="startDate" value="%{startDate}" label="start date" required="required" />
                <s:textfield name="status" value="%{status}" label="status" required="required" />
                <s:textfield name="type" value="%{type}" label="mission type" required="required" />
                <s:submit value="update Mission" />
            </s:form>
        </s:iterator>
        <%@include file="myCss/footer.html" %>
    </body>
</html>
