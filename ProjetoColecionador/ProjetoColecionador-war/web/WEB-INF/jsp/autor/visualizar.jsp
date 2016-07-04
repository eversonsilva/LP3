<%-- 
    Document   : visualizar
    Created on : 01/04/2016, 20:18:18
    Author     : Everson
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Visualizar Autores</title>
        <link rel="icon" href="img/iconeMuseu.ico" />
        <link href="css/style.css" rel="stylesheet" />
        <link href="css/tabelas.css" rel="stylesheet" />
    </head>
    <body>
        <%@include file="../menu.jspf" %>
        ${erromsg}
        ${erromsg=null}
        <h1>Visualizar Autores</h1>
        <table style="width:100%">
            <tr class="tbody">
                <th>ID</th>
                <th>NOME</th> 
            </tr>
            <c:forEach items="${autores}" var="autor">
                <tr>
                    <td>${autor.idAutor}</td>
                    <td>${autor.nomeautor}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
