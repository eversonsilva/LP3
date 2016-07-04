<%-- 
    Document   : pagina1
    Created on : 11/02/2016, 11:12:26
    Author     : Everson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<style>
    table tr, td{
        border: 1px black solid;
    }
    table {
        border-collapse: collapse;
        width: 80%;
    }
</style>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tabela de Notas</title>
    </head>
    <body>
        <h1>Carnaval</h1>
        <p>
            TABELA DE NOTAS
        </p>

        <table>
                <tr>
                    <td></td>
                    <c:forEach var="jurado" begin="1" end="${jurados}">
                        <td>${jurado}</td>
                    </c:forEach>
                </tr>

                <c:forEach var="escola" begin="1" end="${escolas}">
                    <tr>
                        <td>${escola}</td>
                        <c:forEach var="jurado" begin="1" end="${jurados}">
                            <td>
                                ${notas[jurado-1][escola-1]}
                            </td>
                        </c:forEach>
                    </tr>
                </c:forEach>
            </table>

    </body>
</html>
