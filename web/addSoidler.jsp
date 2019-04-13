<%-- 
    Document   : AddPilot
    Created on : Aug 21, 2018, 8:18:01 AM
    Author     : Tachibana Kanade
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="myCss/header.html" %>
        <s:form action="AddSoidlerAction" >
            <s:textfield name="username" value="" label="username" required="required" />
            <c:out value="${sessionScope.soidlerError}" />
            <s:password name="password" value="" required="required" label="password"  />
            <s:textfield name="fullname" value="" label="fullname" />
            <s:combobox label="choose rank" name="rank" 
                        headerKey="1" readonly="true"
                        headerValue="Choose catagory"
                        list="{'Weapon Engineer','Pilot','Reserve'}" />
            <s:submit value="Add soidler" />
        </s:form>
        <%@include file="myCss/footer.html" %>
    </body>
</html>
