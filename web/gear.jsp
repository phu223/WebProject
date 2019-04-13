<%-- 
    Document   : mission
    Created on : Aug 18, 2018, 4:20:53 PM
    Author     : Tachibana Kanade
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="phu.dtos.GearDTO" %>
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
        <s:a href="MainPage.jsp" >return to main page</s:a>
        <s:a href="addGear.jsp">add a gear</s:a>
        <s:form action="SearchGearAction">
            <s:combobox label="search gerne" name="searchGearFollow" 
                        headerKey="1" readonly="true"
                        headerValue="Choose catagory"
                        list="{'gear name','type','status','weapon slot'}" />
            <s:textfield name="searchGear" label="search gear"/>
            <s:submit value="Search"/>
        </s:form><br/>
        <s:if test="%{!searchGear.isEmpty()}">
            <s:if test="%{list == null}"><h1>No gear found</h1></s:if>
            <s:else>
                <table border="1">

                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>gear code</th>

                            <th>gear name</th>
                            <th>type</th>

                            <th>status</th>
                            <th>slot available</th>
                            <th>weapon slot</th>
                        </tr>
                    </thead>
                    <tbody>

                        <s:iterator value="list" status="counter">
                            <s:form theme="simple" action="SearchGearAction4">
                                <tr>

                                    <td><s:property value="%{#counter.count}" /></td>
                                    <td><s:property value="gearCode"/>
                                        <s:hidden name="gearCode" value="%{gearCode}"/></td>

                                    <td><s:property value="gearName"/></td>
                                    <td><s:property value="type"/></td>
                                    <td><s:property value="status"/></td>
                                    <td><s:property value="slotAvailable"/></td>

                                    <td><s:property value="weaponSlot"/></td>
                                    <td><s:url id="deletelink"  action="RemoveGearAction">
                                            <s:param name="gearCode" value="gearCode"/>
                                            <s:param name="rank" value="rank"/>
                                            <s:param name="searchGear" value="%{searchGear}"/>
                                            <s:param name="searchGearFollow" value="%{searchGearFollow}" />
                                        </s:url>
                                        <s:a href="%{deletelink}">delete</s:a></td>

                                        <td>
                                        <s:submit value="Update" />
                                    </td>
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
