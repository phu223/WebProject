<%-- 
    Document   : mission
    Created on : Aug 18, 2018, 4:20:53 PM
    Author     : Tachibana Kanade
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@page import="phu.dtos.GearDTO"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="myCss/header.html" %>
        <h1>Welcome <c:out value=" ${sessionScope.rank}" />

            <c:out value=" ${sessionScope.username}" />

        </h1> 
        <s:form action="LogOutAction">
            <s:submit  value="log out" />
        </s:form>
        <s:form action="SearchGearAction2">
            <s:combobox label="search gerne" name="searchGearFollow" 
                        headerKey="1" readonly="true"
                        headerValue="Choose catagory"
                        list="{'gear name','weapon slot'}" />
            <s:textfield name="searchGear" label="search gear"/>
            <s:submit value="Search"/>
        </s:form><br/>
        <s:if test="%{!searchGear.isEmpty()}">
            <s:if test="%{list == null}"><h1>No weapon found</h1></s:if>
            <s:else>
                <table border="1">

                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>gear code</th>
                            <th>gear name</th>
                            <th>slot available</th>
                            <th>weapon slot</th>
                            <th>Choose this gear</th>
                        </tr>
                    </thead>
                    <tbody>

                        <s:iterator value="list" status="counter">
                            <s:form action="SoidlerChooseGearAction" theme="simple">
                                <tr>

                                    <td><s:property value="%{#counter.count}" /></td>
                                    <td><s:property value="gearCode"/>
                                        <s:hidden name="gearCode" value="%{gearCode}"/></td>

                                    <td><s:property value="gearName"/></td>

                                    <td><s:property value="slotAvailable"/></td>

                                    <td><s:property value="weaponSlot"/></td>
                                    <td><s:submit value="choose" /></td>
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
