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
                            class="nav-link">Inicio</a></li>
            </ul>
        </nav>
    </header>
    <br>
    <div class="container col-md-5">
        <div class="card">
            <div class="card-body">

                    <form action="insert" method="POST">
                    <caption>
                        <h2>Registro de datos</h2>
                    </caption>

                    <fieldset class="form-group">
                            <label>Nombre</label> <input type="text"
                                     class="form-control"
                                    name="nombre" required="required">
                    </fieldset>
                        
                    <fieldset class="form-group">
                            <label>Apellido</label> <input type="text"
                                     class="form-control"
                                    name="apellido" required="required">
                    </fieldset>

                    <fieldset class="form-group">
                            <label>Nickname</label> <input type="text"
                                     class="form-control"
                                    name="nickname">
                    </fieldset>
                        
                    <fieldset class="form-group">
                            <label>Contraseña</label> <input type="password"
                                     class="form-control"
                                    name="password">
                    </fieldset>

                    <fieldset class="form-group">
                            <label>Dirección</label><input type="number"
                                     class="form-control"
                                    name="id_dir">      
                    </fieldset>

                    <button type="submit" class="btn btn-success">Agregar</button>
                    </form>
            </div>
        </div>
    </div>
    
</body>
</html>
