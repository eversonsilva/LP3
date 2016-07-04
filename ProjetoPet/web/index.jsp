<%-- 
    Document   : index
    Created on : 06/05/2016, 10:09:25
    Author     : Everson
--%>

<%@taglib prefix="lp3" uri="/WEB-INF/tlds/pet.tld" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/estilo.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        
        <c:if test="${pets==null}">
            <c:redirect url="Controller"></c:redirect>
        </c:if>
        
        <c:forEach var="p" items="${pets}">
            <lp3:pet pet="${p}"></lp3:pet>
        </c:forEach>
        
    </body>
</html>
