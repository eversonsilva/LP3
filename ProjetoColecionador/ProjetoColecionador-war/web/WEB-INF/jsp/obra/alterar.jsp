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
        <title>Alterar Obra</title>
        <link rel="icon" href="img/iconeMuseu.ico" />
        <link href="css/style.css" rel="stylesheet" />
    </head>
    <body>
        <%@include file="../menu.jspf" %>
        <h1>Alterar Obra</h1>
        <form action="FrontController" method="POST">
            <p>Obras: 
                <select name="obras">
                    <option value=""> Selecione uma Obra </option>
                    <c:forEach items="${obras}" var="obra">
                        <option value="${obra.idObra}">${obra.nomeobra}</option>
                    </c:forEach>
                </select>
            </p>
            <p>Novo Nome Obra: <input type="text" name="nomeObra" /></p>
            <p>Autor: 
                <select name="autores">
                    <option value=""> Selecione um Autor </option>
                    <c:forEach items="${autores}" var="autor">
                        <option value="${autor.idAutor}">${autor.nomeAutor}</option>
                    </c:forEach>
                </select>
            </p>
            <input type="hidden" name="command" value="Obra" />
            <input type="hidden" name="action" value="alterar" />
            <p><input type="submit" value="Alterar" /></p>
        </form>
    </body>
</html>
