<%-- 
    Document   : index
    Created on : 03/05/2016, 08:42:28
    Author     : thiago
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <title>Pets</title>
    </head>
    <body>
        <c:choose>
            <c:when test="${pets==null}">
                <c:redirect url="/Controller"></c:redirect>
            </c:when>
            <c:otherwise>

                <h1>Pets</h1>

                <c:forEach items="${pets}" var="pet">
                    <section clss="square">
                            <div class="circle"><img src="${pet.photo}" class="circle"/></div>
                            <h3>Nome: ${pet.name}</h3>
                            ${pet.description}<br/>
                            Idade: ${pet.age} anos<br/>
                            Raça: ${pet.race}<br/>
                            Cidade: ${pet.city}<br/>
                            Estado: ${pet.state.name}<br/>
                            País: ${pet.country.initials}<br/>
                    </section>
                </c:forEach>

            </c:otherwise>

        </c:choose>


    </body>
</html>
