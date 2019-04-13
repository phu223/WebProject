<%-- 
    Document   : mission
    Created on : Aug 18, 2018, 4:20:53 PM
    Author     : Tachibana Kanade
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@page import="phu.dtos.MissionDTO"%>
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
        <s:form action="searchMission">
            <s:combobox label="search gerne" name="searchMissionBy" 
                        headerKey="1" readonly="true"
                        headerValue="Choose catagory"
                        list="{ 'mission name','status'}" />
            <s:textfield name="searchMission" label="search mission"/>
            <s:submit value="Search"/>
        </s:form><br/>
        <s:if test="%{!searchMission.isEmpty()}">
            <s:if test="%{list == null}"><h1>No mission found</h1></s:if>
            <s:else>
                <table border="1">

                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>mission code</th>

                            <th>mission name</th>
                            <th>status</th>
                            <th>Delete</th>
                            <th>view mission member</th>
                            <th>update</th>
                        </tr>
                    </thead>
                    <tbody>

                        <s:iterator value="list" status="counter">
                            <tr>
                                <s:form theme="simple" action="searchMission2">
                                    <td><s:property value="%{#counter.count}" /></td>
                                    <td><s:property value="missionCode"/>
                                        <s:hidden name="missionCode" value="%{missionCode}"/></td>

                                    <td><s:property   value="%{missionName}" /></td>
                                    <td><s:property value="%{status}"/></td>
                                    <td><s:url id="deletelink"  action="DeleteMissionAction">
                                            <s:param name="missionCode" value="%{missionCode}"/>

                                            <s:param name="searchMission" value="searchMission"/>
                                            <s:param name="searchMissionBy" value="searchMissionBy" />
                                        </s:url>
                                        <s:a href="%{deletelink}">delete</s:a></td>
                                    <td><s:url id="memberlink"  action="searchMissionDetail">
                                            <s:param name="missionCode" value="missionCode"/>


                                        </s:url>
                                        <s:a href="%{memberlink}">see pilot in this mission </s:a></td>
                                        <td>
                                        <s:hidden name="searchMissionBy" value="%{searchMissionBy}" />
                                        <s:submit value="Update" /></td>
                                    </s:form>
                            </tr>

                        </s:iterator>
                    </tbody>
                </table>
            </s:else>
        </s:if>
        <s:a href="addMission.jsp">add mission</s:a>
        <%@include file="myCss/footer.html" %>
    </body>
</html>
