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
        <title>Notas das Esxolas de Samba</title>
    </head>
    <body>
        <h1>Carnaval 2016<h1>
        <h2>Digite abaixo a quantidade de escolas participantes e a quantidade de jurados.</h2>
        
        <form method="POST" action="FrontController">
            <label>Escolas: </label> <input type="text" name="escolas" required/><br><br/>
            <label>Jurados: </label> <input type="text" name="jurados" required/>
            <input type="submit" name="ok" value="OK">
        </form>
    </body>
</html>
