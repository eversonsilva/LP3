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
        <title>Inserir Obra</title>
        <link rel="icon" href="img/iconeMuseu.ico" />
        <link href="css/style.css" rel="stylesheet">
    </head>
    <body>
        <%@include file="../menu.jspf" %>    
        
        <p>Nome Obra: <input type="text" name="nomeobra" /></p>
            <p>Autor: <select name="autores">
                    <option value=""> Selecione um Autor --</option>
                    <c:forEach items="${autores}" var="autor">
                        <option value="${autor.idAutor}">${autor.nomeAutor}</option>
                    </c:forEach>
                </select>
            </p>
            <input type="hidden" name="command" value="Obra" />
            <input type="hidden" name="action" value="inserir" />
            <p><input type="submit" value="Inserir" /></p>
        </form>
    </body>
</html>
