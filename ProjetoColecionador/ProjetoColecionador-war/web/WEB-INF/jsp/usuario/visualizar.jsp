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
        <h1>Visualizar Usuário</h1>
        <table style="width:100%">
            <tr>
                <th>ID</th>
                <th>NOME</th>
                <th>USUARIO</th> 
                <th>SENHA</th> 
                <th>TIPO USUARIO</th> 
            </tr>
            <c:forEach items="${usuarios}" var="usuario">
                <tr>
                    <td>${usuario.idUsuario}</td>
                    <td>${usuario.nomeUsuario}</td>
                    <td>${usuario.userUsuario}</td>
                    <td>${usuario.senhaUsuario}</td>
                    <td>${usuario.idTipousuario.nometipousuario}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
