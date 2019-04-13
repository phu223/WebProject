<%-- 
    Document   : updatePilot
    Created on : Aug 23, 2018, 9:38:08 AM
    Author     : Tachibana Kanade
--%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@page import="phu.dtos.PilotDTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="myCss/header.html" %>
        <s:
         <s:iterator value="list">
            <s:form action="PilotUpdateAction">
                <s:textfield name="pilotCode" value="%{pilotCode}" label="username" readonly="true" />
                
                <s:textfield name="pilotName" value="%{pilotName}" label="fullname" required="required" />
                <s:textfield name="status" value="%{status}" label="status" required="required" />
                <s:textfield name="rank" value="%{rank}" label="rank" readonly="true" />
                
                <s:submit value="update pilot" />
            </s:form>
        </s:iterator>
         <%@include file="myCss/footer.html" %>
    </body>
</html>
