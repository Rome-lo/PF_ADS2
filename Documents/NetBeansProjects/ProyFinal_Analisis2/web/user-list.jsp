<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
                        class="nav-link">Usuarios</a></li>
                <li><a href="<%=request.getContextPath()%>/login"
                        class="nav-link">Ingresar</a></li>
            </ul>
        </nav>
    </header>
    <br>

    <div class="row">
            <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

        <div class="container">
            <h3 class="text-center">Estos negocios pueden interesarte</h3>
            <hr>
            <div class="container text-left">

                <a href="<%=request.getContextPath()%>/new" class="btn btn-success">Nuevo Usuario</a>
            </div>
            <br>
            <div style="align-content: center;">
                <div class="row">
                    <c:forEach var="negocio" items="${listNegocio}">
                        <div class="col-sm-6">
                        

                            <div class="card">
                                <div class="card-body">
                                    <h5 class="card-title"><c:out value="${negocio.nombre}" /></h5>
                                    <p class="card-text"><c:out value="${negocio.descripcion}" /></p>
                                    <a href="edit?idusuario=<c:out value='${negocio.idnegocio}' />" class="btn btn-primary">Go somewhere</a>
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
            <table class="table table-bordered">
                <thead>
                    <tr>
                            <th>Id</th>
                            <th>Nombre</th>
                            <th>Apellido</th>
                            <th>Nickname</th>
                            <th>Contraseña</th>
                            <th>Dirección</th>
                            <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                
                    
                    
                    <c:forEach var="negocio" items="${listNegocio}">

                        <tr>
                            <td><c:out value="${negocio.idnegocio}" /></td>
                            <td><c:out value="${negocio.nombre}" /></td>
                            <td><c:out value="${negocio.id_dir}" /></td>
                            <td><c:out value="${negocio.descripcion}" /></td>
                            <td><c:out value="${negocio.sanciones}" /></td>
                            <td><a href="edit?idusuario=<c:out value='${negocio.idnegocio}' />">Edit</a>
                                    &nbsp;&nbsp;&nbsp;&nbsp; <a
                                    href="delete?idusuario=<c:out value='${negocio.idnegocio}' />">Delete</a></td>
                        </tr>
                    </c:forEach>

                </tbody>

            </table>
        </div>
    </div>
</body>
</html>
