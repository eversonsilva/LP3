<%-- 
    Document   : remover
    Created on : 02/04/2016, 20:23:49
    Author     : Everson
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Remover Autor</title>
        <link rel="icon" href="img/iconeMuseu.ico" />
        <link href="css/style.css" rel="stylesheet">
    </head>
    <body>
        <%@include file="../menu.jspf" %>
        <h1>Remover Usuário</h1>
        <form action="FrontController" method="POST">
            <p>Usuários: 
                <select name="usuarios">
                    <option value=""> Selecione um Usuário </option>
                    <c:forEach items="${usuarios}" var="usuario">
                        <option value="${usuario.idUsuario}">${usuario.nomeUsuario}</option>
                    </c:forEach>
                </select>
            </p>
            <input type="hidden" name="command" value="Usuario" />
            <input type="hidden" name="action" value="remover" />
            <p><input type="submit" value="Remover" /></p>
        </form>
    </body>
</html>
