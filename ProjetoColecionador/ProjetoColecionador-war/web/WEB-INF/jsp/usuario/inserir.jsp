<%-- 
    Document   : inserir
    Created on : 02/04/2016, 20:23:42
    Author     : Everson
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inserir Autor</title>
        <link rel="icon" href="img/iconeMuseu.ico" />
        <link href="css/style.css" rel="stylesheet">
    </head>
    <body>
        <%@include file="../menu.jspf" %>    
        <h1>Inserir Usuário</h1>
        <form action="FrontController" method="POST">
            <p>Nome Usuário: <input type="text" name="nomeUsuario" /></p>
            <p>Username: <input type="text" name="userUsuario" /></p>
            <p>Senha: <input type="text" name="senhaUsuario" /></p>
            <p>Tipo de Usuário: 
                <select name="tipoUsuarios">
                    <option value=""> Selecione um Tipo de Usuário </option>
                    <c:forEach items="${tipousuarios}" var="tipousuario">
                        <option value="${tipousuario.idTipousuario}">${tipousuario.nometipousuario}</option>
                    </c:forEach>
                </select>
            </p>
            <input type="hidden" name="command" value="Usuario" />
            <input type="hidden" name="action" value="inserir" />
            <p><input type="submit" value="Inserir" /></p>
        </form>
    </body>
</html>
