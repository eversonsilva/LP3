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
    </head>
    <body>
        <%@include file="../menu.jspf" %>
       ${returnMsg}
        ${returnMsg=null}
        <h1>Visualizar Obra</h1>
        <table style="width:100%">
            <tr>
                <th>ID</th>
                <th>NOME</th>
                <th>AUTOR</th> 
            </tr>
            <c:forEach items="${obras}" var="obra">
                <tr>
                    <td>${obra.idObra}</td>
                    <td>${obra.nomeobra}</td>
                    <td>${obra.idAutor.nomeAutor}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
