<%-- 
    Document   : alterar
    Created on : 02/04/2016, 20:23:27
    Author     : Everson
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alterar Usuario</title>
        <link rel="icon" href="img/iconeMuseu.ico" />
        <link href="css/style.css" rel="stylesheet" />
    </head>
    <body>
        <%@include file="../menu.jspf" %>

        <h1>Alterar Usuario</h1>
        <form action="FrontController" method="POST">
            <p>Usuarios: 
                <select name="usuarios">
                    <option value=""> Selecione um Usuario </option>
                    <c:forEach items="${usuarios}" var="usuario">
                        <option value="${usuario.idUsuario}">${usuario.nomeUsuario}</option>
                    </c:forEach>
                </select>
            </p>
            <p>Novo Nome Usuario: <input type="text" name="nomeUsuario" /></p>
            <p>Novo Username: <input type="text" name="userUsuario" /></p>
            <p>Nova Senha: <input type="password" name="senhaUsuario" /></p>

            <p>Tipo de Usuário: 
                <select name="tipousuarios">
                    <option value=""> Selecione um Tipo de Usuário </option>
                    <c:forEach items="${tipousuarios}" var="tipousuario">
                        <option value="${tipousuario.idTipousuario}">${tipousuario.nometipousuario}</option>
                    </c:forEach>
                </select>
            </p>
            <input type="hidden" name="command" value="Usuario" />
            <input type="hidden" name="action" value="alterar" />
            <p><input type="submit" value="Alterar" /></p>
        </form>

    </body>
</html>
