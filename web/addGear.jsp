<%-- 
    Document   : addGear
    Created on : Aug 23, 2018, 9:09:31 AM
    Author     : Tachibana Kanade
--%>

<<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
        <s:form action="AddGearAction" >
            <s:textfield name="gearCode" value="" label="gear code" required="required" /><c:out value="${sessionScope.gearError}" />
            <s:textfield name="gearName" value="" label="gear name" required="required" />
            <s:combobox label="choose type" name="type" 
                        value="" readonly="true"
                        list="{'Gundam','MA','MS'}" /><br/>


            <s:textfield name="status" value="Available" label="status" required="required"  />
            <s:textfield name="slotAvailable" value="" label="drive slot" required="required" type="number" />
            <s:textfield name="weaponSlot" value="" label="weapon slot" required="required" type="number" />
            <s:submit value="Add weapon" />
        </s:form>
        <%@include file="myCss/footer.html" %>
    </body>
</html>
