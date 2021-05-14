<%-- 
    Document   : index
    Created on : 22/04/2021, 22:15:53
    Author     : Martins
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body class="">
        <c:import url="header.jsp"/>
        <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
        <c:import url="navBar.jsp"/>
        <script type="text/javascript" src="index.js"></script>
        <div class="cc-row p-4">
            <canvas class='cc-col-36'id="myChart" ></canvas>
        </div>

    </body>
</html>
