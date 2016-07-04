<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Projeto LP3</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="css/estilo.css"/>
    </head>
    <body>
        <c:if test="${user==null}">
            <c:set scope="session" var="errormsg" value="Acesso restrito! Faça login para continuar!"></c:set>
            <c:redirect url="login.jsp"></c:redirect>
        </c:if>

        <c:set scope="session" var="menu" value="pagina1"></c:set>
        <%@include file="topMenu.jsp" %>

        <h1>Heróis</h1>
        <form action="home" method="POST">
            <p><input type="text" name="name" 
                      required placeholder="nome do herói"/></p>
            <input type="hidden" name="command" value="Marvel"/>
            <input type="hidden" name="action" value="buscar"/>
            <p><input type="submit" value="buscar"/></p>
        </form>

        <section id="heroes">
            <c:forEach var="hero" items="${heroes}">
                <article>
                    <img src="${hero.thumbnail}" alt="hero"/>
                    <div>
                        <p>${hero.name}</p>
                        <p>${hero.description}</p>
                    </div>
                </article>
            </c:forEach>
        </section>
    </body>
</html>
