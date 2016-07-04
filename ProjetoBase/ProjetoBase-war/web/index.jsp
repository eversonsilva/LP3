<%-- 
    Document   : index
    Created on : 16/02/2016, 07:48:28
    Author     : Everson
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ProjetoBase</title>
    </head>
    <body>
        <c:set scope="session" var="menu" value="home"></c:set>
        
        <%@include file="topMenu.jsp" %>
        
        <c:choose>
            <c:when test="${username == null}">
                <h1>Hello World!</h1>
            </c:when>
            <c:otherwise>
                <h1>Hello ${username}</h1>
                <p>XD</p>
            </c:otherwise>
        </c:choose>
    </body>
</html>
