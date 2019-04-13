<%-- 
    Document   : addWeapon
    Created on : Aug 20, 2018, 3:25:25 PM
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
        <s:form action="AddWeaponAction" theme="simple">
            <s:textfield name="weaponCode" value="" label="weapon code" required="required" /><br/><c:out value="${sessionScope.weaponError}" />
            <s:textfield name="weaponName" value="" label="weapon name" required="required" /><br/>
            <s:textfield name="firePower" value="" label="power" required="required" type="number" /><br/>

            <s:textfield name="storeQuantity" value="" label="in stock" required="required" type="number" /><br/>
            <s:textfield name="weaponType" value="" label="type" required="required" /><br/>
            <s:combobox label="use for" name="useFor" 
                        headerKey="1" readonly="true"
                        headerValue="Choose catagory"
                        list="{'Gundam','Mobile Suit','Mobile Armour'}" /><br/>
            <s:submit value="Add weapon" />

        </s:form>
        <%@include file="myCss/footer.html" %>
    </body>
</html>
