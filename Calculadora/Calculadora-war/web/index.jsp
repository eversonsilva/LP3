<%-- 
    Document   : index
    Created on : 18/03/2016, 15:18:37
    Author     : Everson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/style.css" />
        <title>Calculadora</title>
    </head>
    <body>
        <form action="FrontController" method="POST">
            <input type="hidden" name="command" value="Calc"/>
            <div id="calculator">
                <div id="screen">
                    ${visor}
                </div>
                <div id="clickables">
                    <div id="operators">
                        <a href="FrontController?command=Calc&action=%2B">+</a>
                        <a href="FrontController?command=Calc&action=-">-</a>
                        <a href="FrontController?command=Calc&action=*">*</a>
                        <a href="FrontController?command=Calc&action=/">/</a>
                        <a href="FrontController?command=Calc&action==" id="equals">=</a>
                    </div>
                    <div id="numbers">
                        <a href="FrontController?command=Calc&action=7">7</a>
                        <a href="FrontController?command=Calc&action=8">8</a>
                        <a href="FrontController?command=Calc&action=9">9</a>
                        <a href="FrontController?command=Calc&action=4">4</a>
                        <a href="FrontController?command=Calc&action=5">5</a>
                        <a href="FrontController?command=Calc&action=6">6</a>
                        <a href="FrontController?command=Calc&action=1">1</a>
                        <a href="FrontController?command=Calc&action=2">2</a>
                        <a href="FrontController?command=Calc&action=1">3</a>
                        <a href="FrontController?command=Calc&action=0">0</a>
                        <a href="FrontController?command=Calc&action=.">.</a>
                        <a href="FrontController?command=Calc&action=C">C</a>
                    </div>
                </div>
            </div>
        </form>
    </body>
</html>
