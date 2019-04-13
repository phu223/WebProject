<%-- 
    Document   : MissionDetail
    Created on : Aug 23, 2018, 6:08:35 PM
    Author     : Tachibana Kanade
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@page import="phu.dtos.MissionDetailDTO"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="myCss/header.html" %>
        <c:out value="${sessionScope.missionCode}"/>


        <s:a href="addPilotToMission.jsp">add pilot</s:a>

        <s:if test="%{list == null}"><h1>No pilot found</h1></s:if>
        <s:else>
            <table border="1">

                <thead>
                    <tr>
                        <th>No.</th>
                        <th>pilot code</th>

                    </tr>
                </thead>
                <tbody>

                    <s:iterator value="list" status="counter">
                        <tr>
                            <s:form theme="simple">
                                <td><s:property value="%{#counter.count}" /></td>
                                <td><s:property value="pilotCode"/>
                                    <s:hidden name="pilotCode" value="%{pilotCode}"/></td>


                                <td><s:url id="deletelink"  action="RemovePilotFromMission">
                                        <s:param name="pilotCode" value="pilotCode"/>

                                    </s:url>
                                    <s:a href="%{deletelink}">delete</s:a></td>
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
