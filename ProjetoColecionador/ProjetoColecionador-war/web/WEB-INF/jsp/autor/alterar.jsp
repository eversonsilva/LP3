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
        <title>Alterar Autor</title>
        <link rel="icon" href="img/iconeMuseu.ico" />
        <link href="css/style.css" rel="stylesheet" />
    </head>
    <body>
        <%@include file="../menu.jspf" %>
        <h1>Alterar Autor</h1>
        <form action="FrontController" method="POST">
            <p>Autores: 
                <select name="autores">
                    <option value=""> Selecione um Autor </option>
                    <c:forEach var="autor" items="${autores}">
                        <option value="${autor.idAutor}">${autor.nomeautor}</option> 
                    </c:forEach>
                </select>
                
            <p>Novo Autor: <input type="text" name="nomeAutor" /></p>
            <input type="hidden" name="command" value="Autor" />
            <input type="hidden" name="action" value="alterar.confirmar" />
            <input type="submit" value="Alterar" />
            </p>
        </form>
    </body>
</html>
