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
        <title>Alterar Emprestimo</title>
        <link rel="icon" href="img/iconeMuseu.ico" />
        <link href="css/style.css" rel="stylesheet" />
    </head>
    <body>
        <%@include file="../menu.jspf" %>
        <h1>Alterar Emprestimo</h1>
        <form action="FrontController" method="POST">
            <p>Emprestimos: 
                <select name="emprestimos">
                    <option value=""> Selecione um Emprestimo </option>
                    <c:forEach var="emprestimo" items="${emprestimos}">
                        <option value="${emprestimo.idEmprestimo}">${emprestimo.idUsuario.nomeUsuario} - ${emprestimo.idObra.nomeobra}</option> 
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
                </select></p>
                
            <p>Obras: 
                <select name="obras">
                    <option value=""> Selecione uma Obra </option>
                    <c:forEach items="${obras}" var="obra">
                        <option value="${obra.idObra}">${obra.nomeobra}</option>
                    </c:forEach>
                </select></p>
                
            <input type="hidden" name="command" value="Emprestimo" />
            <input type="hidden" name="action" value="alterar" />
            <input type="submit" value="Alterar" />

        </form>
    </body>
</html>
