<%-- 
    Document   : index
    Created on : 12/02/2016, 22:50:17
    Author     : Everson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Notas das Escolas de Samba</title>
    </head>
    <body>
        <h1>Carnaval 2016</h1>
        <h3>Digite abaixo a quantidade de escolas participantes e a quantidade de jurados.</h3>
        
        <form method="POST" action="${pageContext.request.contextPath}/principal">
            <input type="hidden" name="command" value="Comando1" />
            <label>Escolas: </label> <input type="number" name="escolas" required/><br/><br/>
            <label>Jurados: </label> <input type="number" name="jurados" required/><br/><br/>
            <input type="button" name="enviar" value="Enviar" onclick="form.submit()">
        </form>
    </body>
</html>
