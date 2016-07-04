<%-- 
    Document   : registro
    Created on : 02/04/2016, 02:40:56
    Author     : Everson
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" href="img/iconeMuseu.ico" />
        <link rel="stylesheet" href="css/registro.css" />
        <title>Registro</title>
    </head>
    <body>
        <c:if test="${errormsg!=null && !''.equals(errormsg)}">
            <p class="error">${errormsg}</p>
            <c:set scope="session" var="errormsg" value=""></c:set>
        </c:if>

        <form class="login" method="POST" action="FrontController">
            <h1>Cadastre-se</h1>
            <p><input id="p" class="login-input" type="text" name="fullname" placeholder="Nome completo" required="required"/>*</p>
            <p><input id="p" class="login-input" type="text" name="username" placeholder="Nome de usuário" required="required"/>*</p>
            <p><input id="p" class="login-input" type="password" name="pwd1" placeholder="Senha" required="required"/>*</p>
            <p><input id="p" class="login-input" type="password" name="pwd2" placeholder="Confirmar Senha" required="required"/>*</p>
            <p>
                <select name="tipoUsuario" class="login-input">
                    <option value="" selected=""> Escolha um tipo de Usuario </option>
                    <c:forEach items="${tipoUsuarios}" var="tipoUsuario">
                        <option value="${tipoUsuario.idTipousuario}"> ${tipoUsuario.nometipousuario} </option>
                    </c:forEach>
                </select>
            </p>
            <input type="hidden" name="command" value="Login"/>
            <input type="hidden" name="action" value="registro"/>
            <p><input class="login-submit" type="submit" value="Cadastrar"/></p>
        </form>
    </body>
</html>
