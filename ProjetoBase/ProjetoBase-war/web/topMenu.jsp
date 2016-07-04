<%-- 
    Document   : topMenu
    Created on : 16/02/2016, 07:50:06
    Author     : Everson
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/estilo.css">
    </head>
    <body>
        <nav class="topMenu">
            <ul>
                <a href="index.jsp"><li class="${menu.equals("home")?"selectedMenu":""}">Home</li></a>
      
                <c:choose>
                    <c:when test="${user ==  null}">
                        <a href="login.jsp"><li class="${menu.equals("login")?"selectedMenu":""}">Login</li></a>
                    </c:when>
                    <c:otherwise>
                        <a href="pagina1.jsp"><li class="${menu.equals("pagina1")?"selectedMenu":""}">Page 1</li></a>
                        <a href="home?command=User&action=logout"><li>Logout</li></a>
                    </c:otherwise>
                    
                </c:choose> 
            </ul>
        </nav>
    </body>
</html>
