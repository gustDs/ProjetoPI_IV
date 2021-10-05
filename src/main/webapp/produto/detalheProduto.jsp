
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <c:import url="../header.jsp"/>

        <title>Detalhe</title>
    </head>
    <body class="container">
        <div class="titulo">
            <h1>Visualizar Produto</h1>
        </div>

        <div class="info">
            <c:if test="${not empty produtos}">

                <h3>
                    ${produtos.wNome}
                </h3> <br><br>
                <div class="container-fluid">
                    <div class="row">
                        <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
                            <ol class="carousel-indicators">
                                <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>,
                                <c:forEach items="${listaProdutos}" var="produtos">
                                <li data-target="#carouselExampleIndicators" data-slide-to="1"></li
                                </c:forEach>
                            </ol>
                            <div class="carousel-inner">                            
                                <div class="carousel-item active">
                                    <img class="d-block w-100" slide="" src="nvidia.jpg" width="500px" height="500px" alt="First slide">
                                </div>
                                <c:forEach items="${listaProdutos}" var="produtos">
                                  <img class="d-block w-100" src="" width="500px" height="500px" alt="First slide">
                                </c:forEach>
                            </div>
                            <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                                <span class="sr-only">Previous</span>
                            </a>
                            <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                                <span class="sr-only">Next</span>
                            </a>
                        </div>
                        <!-- 
                        <div id="carouselExampleSlidesOnly" class="carousel slide" data-ride="carousel">
                            <div class="carousel-inner">
                                <div class="carousel-item active">
                                    <img src="logo.png" alt="..." width="100px">
                                </div>
                                <div class="carousel-item">
                                    <img src="teste-memoria.jpg" width="100px alt="...">
                                </div>
                                <div class="carousel-item">
                                    <img class="d-block w-100" src="..." alt="Third slide">
                                </div>
                            </div>
                        </div>
                        -->
                    </div>
                </div>
                <h3>
                    Descrição do produto:
                </h3>
                <h5>
                    ${produtos.wDesc}
                </h5>
            </c:if>
        </div>

    </body>
</html>
