<%-- 
    Document   : index
    Created on : 01/04/2016, 20:19:57
    Author     : Everson
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/login.css" rel="stylesheet">
        <link rel="icon" href="img/iconeMuseu.ico" />
        <title>Colecionador</title>
    </head>
    <body>

        <c:if test="${errormsg!=null && !''.equals(errormsg)}">
            <p class="error">${errormsg}</p>
            <c:set scope="session" var="errormsg" value=""></c:set>
        </c:if>
 
        <form method="POST" action="FrontController" class="login">
            <h1>Login</h1>
            <p><input class="login-input" type="text" name="username" placeholder="username" value="${cookie.username.value}"/></p>
            <p><input class="login-input" type="password" name="password" placeholder="password" value="${cookie.password.value}"/></p>
            <p><input type="checkbox" name="lembrar"/> Lembrar nome e senha</p>
            <p><input class="login-submit" type="submit" value="LOGIN"/></p>
            <input type="hidden" name="command" value="Login"/>
            <input type="hidden" name="action" value="login"/>
            <p><a class="login-help" href="FrontController?command=Login&action=cadastrar">Cadastrar</a></p>
        </form>
            
    </body>
</html>
