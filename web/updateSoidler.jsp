<%-- 
    Document   : updateSoidler
    Created on : Aug 21, 2018, 3:54:53 PM
    Author     : Tachibana Kanade
--%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@page import="phu.dtos.SoidlerDTO"%>
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
        <s:iterator value="list">
            <s:form action="SoidlerUpdateAction" theme="simple">
                <s:textfield name="username" value="%{username}" label="username" readonly="true" /><br/>
                <s:password name="password" value="%{password}"  label="password" required="required" /><br/>
                <s:textfield name="fullname" value="%{fullname}" label="fullname" required="required" /><br/>
                <s:combobox label="choose rank" name="rank" 
                            value="%{rank}" readonly="true"
                            list="{'Weapon Engineer','Pilot','Reserve'}" /><br/>
                <s:submit value="update soidler" />
            </s:form>
        </s:iterator>
        <%@include file="myCss/footer.html" %>
    </body>
</html>
