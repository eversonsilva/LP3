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
        <title>Visualizar Emprestimos</title>
        <link rel="icon" href="img/iconeMuseu.ico" />
        <link href="css/style.css" rel="stylesheet" />
    </head>
    <body>
        <%@include file="../menu.jspf" %>
        ${erromsg}
        ${erromsg=null}
        <h1>Visualizar Emprestimos</h1>
        <table style="width:100%">
            <tr>
                <th>ID</th>
                <th>OBRA</th>
                <th>USUARIO</th> 
                <th>DATA</th> 
            </tr>
            <c:forEach items="${emprestimos}" var="emprestimo">
                <tr>
                    <td>${emprestimo.idEmprestimo}</td>
                    <td>${emprestimo.idObra.nomeobra}</td>
                    <td>${emprestimo.idUsuario.nomeUsuario}</td>
                    <td>${emprestimo.dataEmprestimo}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
