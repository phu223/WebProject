<%-- 
    Document   : PilotMainPage
    Created on : Aug 22, 2018, 8:39:38 AM
    Author     : Tachibana Kanade
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="phu.dtos.ArmanentDTO"%>
<%@page import="phu.dtos.PilotDTO"%>
<%@page import="phu.dtos.MissionDTO"%>
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
        <s:if test="%{list5 == null}" >you have no mission now</s:if>
        <s:iterator value="list5" >
            <s:property value="missionCode" />
            <s:if test="%{list6 == null}" >you have no mission now</s:if>
                <table border="1">
                    <thead>
                        <tr>
                            <th>mission code</th>
                            <th>mission name</th>
                            <th> start date</th>
                            <th>status</th>
                            <th>type</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                        <s:iterator value="list6" >
                            <td><s:property value="missionCode" /></td>
                            <td><s:property value="missionName" /></td>
                            <td><s:property value="startDate" /></td>
                            <td> <s:property value="status" /></td>
                            <td><s:property value="type" /></td>
                        </s:iterator>
                    </tr>
                </tbody>
            </table>








        </s:iterator><br/>

        <s:a href="pilotChooseGear.jsp" >Modified gear</s:a><br/>

        <s:if test="%{list4 == null}"><h1>No Gear found</h1></s:if>
        <s:else>
            <s:iterator value="list4">

                <s:iterator value="list" >
                    Crew     <s:property value="pilotName" /><br/>
                </s:iterator>


                <s:form>

                    <s:if test="%{list3 == null}" ></s:if>

                        your gear <s:property value="gearName" />(<s:property value="gearCode" />)<br/>
                    <s:url action="SoidlerRemoveGear" id="removelink">
                        <s:param name="gearCode" value="gearCode" />

                    </s:url>
                    <s:a href="%{removelink}" >remove this gear</s:a><br/>
                    <s:url action="modify" id="modlink">
                        <s:param name="gearCode" value="gearCode" />

                    </s:url>
                    <s:a href="%{modlink}" >modify weapon</s:a>
                </s:form>
            </s:iterator>

        </s:else>
        <%@include file="myCss/footer.html" %>
    </body>
</html>
