<%-- 
    Document   : weaponForPilot
    Created on : Aug 24, 2018, 10:48:46 PM
    Author     : Tachibana Kanade
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="phu.dtos.WeaponDTO"%>
<%@page import="phu.dtos.GearDTO"%>
<%@page import="phu.dtos.CrewDTO"%>
<%@page import="java.util.List"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="myCss/header.html" %>
        <h1>Welcome <c:out value=" ${sessionScope.rank}" />
            <c:out value=" ${sessionScope.fullname}" />
            (<c:out value=" ${sessionScope.username}" />) </h1>



        <s:form action="LogOutAction">
            <s:submit  value="log out" /></s:form>
        <s:form action="searchWeapon2">
            <s:combobox label="search weapon" name="searchWeaponType" 
                        headerKey="1" readonly="true"
                        headerValue="Choose catagory"
                        list="{'weapon name','weapon type','use for'}" />

            <s:textfield name="searchWeapon" value="" />

            <s:submit value="searchWeapon"/>
        </s:form>
        <s:iterator value="list2">
            <s:property value="gearCode" /><s:hidden name="gearCode" value="%{gearCode}" />
        </s:iterator>
        <br/>
        <s:if test="%{!searchWeapon.isEmpty()}">
            <s:if test="%{list == null}"><h1>No weapon found</h1></s:if>
            <s:else>
                <table border="1">

                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>weapon code</th>

                            <th>weapon name</th>
                            <th>fire power</th>
                            <th>use for</th>
                            <th>weapon type</th>

                            <th>Add</th>
                        </tr>
                    </thead>
                    <tbody><c:out value="${sessionScope.limitation}"/>
                        <s:iterator value="list" status="counter">
                            <s:form action="AddWeaponToGear" theme="simple">
                                <tr>

                                    <td><s:property value="%{#counter.count}" /></td>
                                    <td><s:property value="weaponCode"/>
                                        <s:hidden name="weaponCode" value="%{weaponCode}"/></td>
                                    <td><s:textfield name="weaponName" value="%{weaponName}"/></td>
                                    <td><s:textfield name="firePower" value="%{firePower}"/></td>
                                    <td><s:textfield name="useFor" value="%{useFor}"/></td>
                                    <td><s:textfield name="weaponType" value="%{weaponType}"/></td>

                                    <td><s:hidden name="gearCode" value="%{gearCode}" />
                                        <s:hidden name="searchWeapon" value="%{searchWeapon}"/>
                                        <s:hidden name="searchWeaponType" value="%{searchWeaponType}" />
                                        <s:submit value="Add" /></td>

                                </tr>
                            </s:form>
                        </s:iterator>
                    </tbody>
                </table>
            </s:else>
        </s:if>
        <%@include file="myCss/footer.html" %>
    </body>
</html>
