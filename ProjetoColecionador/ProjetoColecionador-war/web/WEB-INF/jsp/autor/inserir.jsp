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
        
        <h1>Inserir Autor</h1>
        <form>
            <p>Nome Autor: <input type="text" name="nomeAutor"/></p>
            <p><input type="hidden" name="command" value="Autor"/></p>
            <p><input type="hidden" name="action" value="inserir.confirmar"/></p>
            <p><input type="submit" value="Inserir"/></p>
        </form>
    </body>
</html>
