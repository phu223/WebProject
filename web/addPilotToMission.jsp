<%-- 
    Document   : addPilotToMission
    Created on : Aug 23, 2018, 6:36:13 PM
    Author     : Tachibana Kanade
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="phu.dtos.PilotDTO"%>
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

        </h1>  <s:form action="LogOutAction">
            <s:submit  value="log out" /></s:form>
        <c:out value="${sessionScope.missionCode}"/>
        <s:form action="SearchPilotForMissionAction">
            <s:textfield name="searchPilot" value="" label="search pilot"/>
            <s:submit value="Search"/>
        </s:form>

        
        <s:if test="%{!searchPilot.isEmpty()}">

            <s:if test="%{list == null}"><h1>No pilot found</h1></s:if>
            <s:else>
                <table border="1">

                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>pilot code</th>

                            <th>pilot name</th>
                            <th>rank</th>
                            <th>status</th>
                            <th>Add</th>

                        </tr>
                    </thead>
                    <tbody>

                        <s:iterator value="list" status="counter">
                            <tr>
                                <s:form action="AddPilotToMissionAction" theme="simple">
                                    <td><s:property value="%{#counter.count}" /></td>
                                    <td><s:property value="pilotCode"/>
                                        <s:hidden name="pilotCode" value="%{pilotCode}"/><c:out value="${sessionScope.error}"/></td>
                                    
                                    <td><s:property value="pilotName"/></td>
                                    <td><s:property value="rank"/></td>
                                    <td><s:property value="status"/></td>

                                    <td>
                                        <s:hidden name="searchPilot" value="%{searchPilot}"/>
                                        <s:submit value="add" /></td>
                                    </s:form>
                            </tr>

                        </s:iterator>

                    </tbody>
                </table>
            </s:else>

        </s:if>
        <s:a href="mission.jsp" >return to mission page</s:a>
        <%@include file="myCss/footer.html" %>
    </body>
</html>
