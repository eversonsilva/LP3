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
        <title>Inserir Emprestimo</title>
        <link rel="icon" href="img/iconeMuseu.ico" />
        <link href="css/style.css" rel="stylesheet">
    </head>
    <body>
        <%@include file="../menu.jspf" %>    
        
        <h1>Inserir Emprestimo</h1>
        <form>
            <p>Obra: 
                <select name="obras">
                    <option value=""> Selecione uma Obra </option>
                    <c:forEach items="${obras}" var="obra">
                        <option value="${obra.idObra}">${obra.nomeobra}</option>
                    </c:forEach>
                </select>
            </p>
            <p>Usuário: 
                <select name="usuarios">
                    <option value=""> Selecione um Usuário </option>
                    <c:forEach items="${usuarios}" var="usuario">
                        <c:if test="${usuario.idTipoUsuario.idTipoUsuario == 2}">
                            <option value="${usuario.idUsuario}">${usuario.nomeUsuario}</option>
                        </c:if>
                    </c:forEach>
                </select>
            </p>
            <input type="hidden" name="command" value="Emprestimo" />
            <input type="hidden" name="action" value="inserir" />
            <p><input type="submit" value="Inserir" /></p>
        </form>
    </body>
</html>
