<%-- 
    Document   : page1
    Created on : 16/02/2016, 08:15:38
    Author     : Everson
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ProjetoBase</title>
    </head>
    <body>
        <c:set scope="session" var="menu" value="login"></c:set>
        <%@include file="topMenu.jsp" %>
        <c:if test="${errormsg != null && !''.equals(errormsg)}">
            <p class="msg">${errormsg}</p>
        </c:if>
        <c:set scope="session" var="errormsg" value=""></c:set>

            <h1>LOGIN</h1>

            <form method="POST" action="home">
                <p><input type="text" name="username" placeholder="username" value="${cookie.usernameCookie.value}"/></p>
            <p><input type="password" name="password" placeholder="password" value="${cookie.passwordCookie.value}"/></p>
            <p><input type="checkbox" name="checkSave" checked="checked" />Salvar usuário e senha</p>
            <p><input type="submit" value="LOGIN"/></p>
            <input type="hidden" name="command" value="User" />
            <input type="hidden" name="action" value="login" />
        </form>

        <p>-- OU --</p>
        <p>Faça seu cadastro</p>

        <form method="POST" action="home">
            <p><input type="text" name="fullname" placeholder="Nome Completo" required="required"/>*</p>
            <p><input type="text" name="username" placeholder="Username" required="required"/>*</p>
            <p><input type="password" name="pwd1" placeholder="Senha" required="required"/>*</p>
            <p><input type="password" name="pwd2" placeholder="Confirme a Senha" required="required"/>*</p>
            <p><input type="email" name="email" placeholder="Email" required="required"/>*</p>
            <p><input type="date" name="bday" placeholder="Data de Nascimento" required="required"/>*</p>
            <input type="hidden" name="command" value="User" />
            <input type="hidden" name="action" value="register" />
            <p><input type="submit" value="CADASTRAR"/></p>
        </form>

    </body>
</html>
