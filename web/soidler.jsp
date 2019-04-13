<%-- 
    Document   : soidler
    Created on : Aug 21, 2018, 8:37:40 AM
    Author     : Tachibana Kanade
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="phu.dtos.SoidlerDTO"%>
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
            <s:submit  value="log out" />
        </s:form>
        <s:a href="MainPage.jsp" >return to main page</s:a>
        <s:form action="SearchSoidlerAction">
            <s:combobox label="search gerne" name="searchSoidlerFollow" 
                        headerKey="1" readonly="true"
                        headerValue="Choose catagory"
                        list="{'rank','full name'}" />
            <s:textfield name="searchSoidler" label="search soidler"/>
            <s:submit value="Search"/>
        </s:form><br/>
        <s:if test="%{!searchSoidler.isEmpty()}">
            <s:if test="%{list == null}"><h1>No soidler found</h1></s:if>
            <s:else>
                <table border="1">

                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>username</th>

                            <th>full name</th>
                            <th>rank</th>
                            <th>Delete</th>

                        </tr>
                    </thead>
                    <tbody>

                        <s:iterator value="list" status="counter">
                            <tr>
                                <s:form action="SearchSoidlerInfo"  theme="simple" method="POST">
                                    <td><s:property value="%{#counter.count}" /></td>
                                    <td><s:property value="username"/>
                                        <s:hidden name="username" value="%{username}"/></td>

                                    <td><s:property value="%{fullname}"/><s:hidden name="fullname" value="%{fullname}"/></td>
                                    <td><s:property value="rank"/><s:hidden name="rank" value="%{rank}"/>
                                    </td>

                                    <td><s:url id="deletelink"  action="DeleteSoidlerAction">
                                            <s:param name="username" value="username"/>
                                            <s:param name="rank" value="rank"/>
                                            <s:param name="searchSoidler" value="%{searchSoidler}"/>
                                            <s:param name="searchSoidlerFollow" value="%{searchSoidlerFollow}" />
                                        </s:url>
                                        <s:a href="%{deletelink}">delete</s:a></td>

                                        <td>
                                        <s:submit value="Update" />
                                    </td>
                                </s:form>
                            </tr>

                        </s:iterator>

                    </tbody>
                </table>
            </s:else>
        </s:if>
        <s:a href="addSoidler.jsp">add a soidler</s:a>
        <%@include file="myCss/footer.html" %>
    </body>
</html>
