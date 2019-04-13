<%-- 
    Document   : mission
    Created on : Aug 18, 2018, 4:20:53 PM
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

        </h1> 
        <s:form action="LogOutAction">
            <s:submit  value="log out" />
        </s:form>
        <s:a href="MainPage.jsp" >return to main page</s:a>
        <s:form action="SearchPilotAction">
            <s:combobox label="search gerne" name="searchPilotFollow" 
                        headerKey="1" readonly="true"
                        headerValue="Choose catagory"
                        list="{'rank','pilot name','status'}" />
            <s:textfield name="searchPilot" label="search pilot"/>
            <s:submit value="Search"/>
        </s:form><br/>
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
                            <th>Delete</th>

                        </tr>
                    </thead>
                    <tbody>

                        <s:iterator value="list" status="counter">

                            <tr>
                                <s:form action="SearchPilotAction2"  theme="simple" method="POST">
                                    <td><s:property value="%{#counter.count}" /></td>
                                    <td><s:property value="pilotCode"/>
                                        <s:hidden name="pilotCode" value="%{pilotCode}"/></td>

                                    <td><s:property value="pilotName"/></td>
                                    <td><s:property value="rank"/><s:hidden name="rank" value="%{rank}"/></td>
                                    <td><s:property value="status"/></td>
                                    <td><s:url id="deletelink"  action="DeletePilotAction">
                                            <s:param name="pilotCode" value="pilotCode"/>
                                            <s:param name="rank" value="rank"/>
                                            <s:param name="searchPilot" value="searchPilot"/>
                                            <s:param name="searchPilotFollow" value="searchPilotFollow" />
                                        </s:url>
                                        <s:a href="%{deletelink}">delete</s:a></td>
                                        <td>

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
