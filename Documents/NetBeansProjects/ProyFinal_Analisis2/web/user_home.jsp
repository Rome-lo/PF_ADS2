<%-- 
    Document   : user_home
    Created on : may 6, 2021, 10:59:27 p.m.
    Author     : Romeo Lopez Molina
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Prueba Proy - v3</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

    <header>
        <nav class="navbar navbar-expand-md navbar-dark"
                style="background-color: tomato">
            <div>
                    <a class="navbar-brand">Anroy </a>
            </div>

            <ul class="navbar-nav">
                <li><a href="<%=request.getContextPath()%>/list"
                        class="nav-link">Cerrar sesión</a></li>
            </ul>
            <ul class="navbar-nav">
                <li><a href="<%=request.getContextPath()%>/myNegocio"
                        class="nav-link">Mi perfil</a></li>
            </ul>
        </nav>
    </header>
    <br>

    <div class="row">
            <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

        <div class="container">
            <h2 class="text-center">HOME</h2>
            <h3 class="text-center">Estos negocios se encuentran en tu área</h3>
            <hr>
            <div style="align-content: center;">
                <div class="row">
                    <c:forEach var="negocio" items="${listNegocio}">
                        <div class="col-sm-6">
                        

                            <div class="card">
                                <div class="card-body">
                                    <h5 class="card-title"><c:out value="${negocio.nombre}" /></h5>
                                    <p class="card-text"><c:out value="${negocio.descripcion}" /></p>
                                    <a href="<%=request.getContextPath()%>/negocio?rng=1&idnegocio=<c:out value='${negocio.idnegocio}' />" class="btn btn-primary">Ver perfil</a>
                                </div>
                            </div>
                            <br/>
                        
                        </div>
                    </c:forEach>
                    <!--<div class="col-sm-6">
                      <div class="card">
                        <div class="card-body">
                          <h5 class="card-title">Special title treatment</h5>
                          <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
                          <a href="#" class="btn btn-primary">Go somewhere</a>
                        </div>
                      </div>
                    </div>-->
                </div>
            </div>
            <br>
            
        </div>
    </div>
</body>
</html>

