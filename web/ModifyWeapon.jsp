<%-- 
    Document   : ModifyWeapon
    Created on : Aug 24, 2018, 9:29:20 PM
    Author     : Tachibana Kanade
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="phu.dtos.PilotDTO"%>
<%@page import="phu.dtos.ArmanentDTO"%>
<%@page import="phu.dtos.GearDTO"%>
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
        </h1> <s:form action="LogOutAction">
            <s:submit  value="log out" /></s:form>

            <h1><s:property value="gearCode" /><s:hidden name="gearCode" value="%{gearCode}"/></h1>
        <s:url id="modifylink" action="SearchGearAction3" >

            <s:param name="gearCode" value="%{gearCode}" />

        </s:url>
        <s:a href="%{modifylink}" >Modified weapon</s:a>
        <s:if test="%{list == null}" ><h1>No Weapon found</h1></s:if>
        <s:else>




            <table border="1">
                <thead>
                    <tr>

                        <th>weapon code</th>
                        <th>quantity</th>
                    </tr>
                </thead>
                <tbody>
                    <s:iterator value="list">
                        <tr>
                            <s:form theme="simple">

                                <td> <s:property value="weaponCode" /><s:hidden name="weaponCode" value="weaponCode"/></td>
                                <td> <s:property value="quantity" /></td>
                                <td><s:url id="deletelink" action="SoidlerRemoveWeaponFromGundam" >

                                        <s:param name="gearCode" value="%{gearCode}" />
                                        <s:param name="weaponCode" value="%{weaponCode}" />

                                    </s:url>
                                    <s:a href="%{deletelink}" >delete weapon</s:a></td>

                            </s:form>
                        </tr>
                        <tr></tr>
                    </s:iterator>  
                </tbody>
            </table>



        </s:else>
        <%@include file="myCss/footer.html" %>
    </body>
</html>
