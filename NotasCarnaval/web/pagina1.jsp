<%-- 
    Document   : pagina1
    Created on : 11/02/2016, 11:12:26
    Author     : Everson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tabela para Notas</title>
        <style>
            table tr, td{
                border: 1px black solid;
            }
            table {
                border-collapse: collapse;
                width: 80%;
            }
        </style>
    </head>
    <body>
        <h1>Carnaval</h1>
        <p>
            TABELA PARA NOTAS
        </p>

        <form action="${pageContext.request.contextPath}/principal" method="POST">

            <input type="hidden" name="jurados" value="${jurados}"/>
            <input type="hidden" name="escolas" value="${escolas}"/>
            <input type="hidden" name="command" value="Comando2"/>

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
                                <input type="number" placeholder="Nota" name="nota${escola}x${jurado}" required/>
                            </td>
                        </c:forEach>
                    </tr>
                </c:forEach>
            </table>
            
            <p>
                <input type="button" value="Enviar Notas" onclick="form.submit()">
            </p>

        </form>

    </body>
</html>
