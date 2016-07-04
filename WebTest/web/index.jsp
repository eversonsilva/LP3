<%-- 
    Document   : index
    Created on : 19/04/2016, 08:54:44
    Author     : Everson
--%>

<%@taglib prefix="w" uri="/WEB-INF/tlds/weather.tld" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <w:weather appid="d029df4aaecfcc317ce7aa2dbb8b60f0" city="SaoPaulo" units="metric"></w:weather>
        <w:weather appid="d029df4aaecfcc317ce7aa2dbb8b60f0" city="Barueri" units="metric"></w:weather>
        <w:weather appid="d029df4aaecfcc317ce7aa2dbb8b60f0" city="Curitiba" units="metric"></w:weather>
        
    </body>
</html>
