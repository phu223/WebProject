<%-- 
    Document   : mission
    Created on : Aug 18, 2018, 4:20:53 PM
    Author     : Tachibana Kanade
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="phu.dtos.WeaponDTO"%>
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
            (<c:out value=" ${sessionScope.username}" />) 

        </h1> 
        <s:form action="LogOutAction">
            <s:submit  value="log out" />
        </s:form>

        <s:a href="addWeapon.jsp">add new weapon</s:a>
        <s:form action="searchWeapon">
            <s:combobox label="search weapon" name="searchWeaponType" 
                        headerKey="1" readonly="true"
                        headerValue="Choose catagory"
                        list="{'weapon name','weapon type','use for'}" />

            <s:textfield name="searchWeapon" value="" />

            <s:submit value="searchWeapon"/>
        </s:form>
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
                            <th>store quantity</th>
                            <th>use for</th>
                            <th>weapon type</th>
                            <th>Delete weapon</th>
                            <th>Update</th>
                        </tr>
                    </thead>
                    <tbody>
                        <s:iterator value="list" status="counter">
                            <tr>
                                <s:form action="WeaponUpdate" theme="simple">
                                    <td><s:property value="%{#counter.count}" /></td>
                                    <td><s:property value="weaponCode"/>
                                        <s:hidden name="weaponCode" value="%{weaponCode}"/></td>

                                    <td><s:textfield name="weaponName" value="%{weaponName}"/></td>
                                    <td><s:textfield name="firePower" value="%{firePower}" type="number" /></td>
                                    <td><s:textfield name="storeQuantity" value="%{storeQuantity}" type="number" /></td>
                                    <td><s:textfield name="useFor" value="%{useFor}"/></td>
                                    <td><s:textfield name="weaponType" value="%{weaponType}"/></td>
                                    <td><s:url id="deletelink"  action="DeleteWeaponAction">
                                            <s:param name="weaponCode" value="weaponCode"/>
                                            <s:param name="searchWeapon" value="searchWeapon"/>
                                            <s:param name="searchWeaponType" value="searchWeaponType" />
                                        </s:url>
                                        <s:a href="%{deletelink}">delete</s:a></td>
                                    <td><s:hidden name="searchWeapon" value="%{searchWeapon}"/>
                                        <s:hidden name="searchWeaponType" value="%{searchWeaponType}" />
                                        <s:submit value="Update" /></td>
                                    </s:form>
                            </tr>

                        </s:iterator>
                    </tbody>
                </table>
            </s:else>
        </s:if>
        <%@include file="myCss/footer.html" %>
    </body>
</html>
