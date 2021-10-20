
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<body class="container">
    <div class="cc-row ">

        <div class="row m-auto " style="max-width: 1900px;">
            <div class="cc-col w-100 "  >
                <h3>Produtos</h3>
                <div class="cc-col w-100">
                    <div class=" border  cc-col cc-col-36" > 
                        <div class="titulo">
                            <h1>Visualizar Produto</h1>
                        </div>
                        <div class="info">
                            <c:if test="${not empty produtos}">
                                <h3>
                                    ${produtos.wNome}
                                </h3>
                                <br><br>

                                <div class="container-fluid">
                                    <div class="row">
                                        <div id="carouselExampleSlidesOnly" class="carousel slide" data-ride="carousel">
                                            <div class="carousel-inner">
                                                <c:forEach items="${listaImagens}" var="imagens">
                                                    <div class="carousel-item active">
                                                        <img class="d-block w-100" src="${imagens.blArquivo}" width="500px" height="500px" alt="First slide">
                                                    </div>
                                                </c:forEach>

                                            </div>
                                        </div>

                                        <div id="carouselExampleSlidesOnly" class="carousel slide" data-ride="carousel">
                                            <div class="carousel-inner">
                                                <div class="carousel-inner">
                                                    <div class="carousel-item active">                            

                                                    </div>
                                                </div>
                                            </div>

                                        </div>
                                    </div>
                                </div>
                                <h3>
                                    R$ ${produtos.wValor}<br>
                                    Avaliação: ${produtos.wAvaliacao} estrelas<br>
                                    <button name="button" type="button"
                                            style="margin: 10px; padding: 16px; width: 150px; background-color: darkblue; color: aliceblue; border: none;border-radius: 4px;font-size: 16px">Comprar
                                    </button>
                                </h3><br>
                                <h3>
                                    Descrição do produto:
                                </h3>
                                <h5>
                                    ${produtos.wDesc}
                                </h5>
                            </c:if>
                        </div>
                    </div>
                </div>
            </div>
        </div>


</body>

