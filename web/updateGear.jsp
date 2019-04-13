<%-- 
    Document   : updateSoidler
    Created on : Aug 21, 2018, 3:54:53 PM
    Author     : Tachibana Kanade
--%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@page import="phu.dtos.GearDTO"%>
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
            <s:form action="UpdateGearAction">
                <s:textfield name="gearCode" value="%{gearCode}" label="gear code" readonly="true"  />
                <s:textfield name="gearName" value="%{gearName}" label="gear name" required="required" />
                <s:combobox label="choose type" name="type" 
                            value="%{type}" readonly="true"
                            list="{'Gundam','MA','MS'}" /><br/>


                <s:textfield name="status" value="%{status}" label="status" required="required" />
                <s:textfield name="slotAvailable" value="%{slotAvailable}" label="drive slot" required="required" type="number" />
                <s:textfield name="weaponSlot" value="%{weaponSlot}" label="weapon slot" required="required" type="number" />
                <s:submit value="update weapon" />
            </s:form>
        </s:iterator>
        <%@include file="myCss/footer.html" %>
    </body>
</html>
