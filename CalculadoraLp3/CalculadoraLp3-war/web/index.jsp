<%-- 
    Document   : index
    Created on : 17/03/2016, 11:49:18
    Author     : Everson
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <form action="FrontController" method="POST">
            <p>Parcela 1:<br> <input type="text" name="n1"/></p>
            <p>Parcela 2:<br> <input type="text" name="n2"/></p>
            <select name="op">
                <option value="+">Soma</option>
                <option value="-">Subtração</option>
                <option value="*">Multiplicação</option>
                <option value="/">Divisão</option>
            </select>
            <input type="hidden" name="command" value="Calc"/>
            <p><input type="submit" value="CALCULAR"/></p>
        </form>

        <p>${resultado}</p>
        <c:set scope="session" var="resultado" value=""></c:set>

    </body>
</html>
