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
        <title>Adivinha</title>
    </head>
    <body>
        
        <h1>Adivinha!</h1>
        
        <h3>Adivinhe em que número eu estou pensando!</h3>
        
        <form method="POST" action="${pageContext.request.contextPath}/principal">
            <input type="hidden" name="command" value="Advinha.verifica"/>
            <input type="number" name="numero" placeholder="Adivinha!" required/>
            <input type="button" value="Verificar" onclick="form.submit()" required>
        </form>
        ${verifica}
    </body>
</html>
