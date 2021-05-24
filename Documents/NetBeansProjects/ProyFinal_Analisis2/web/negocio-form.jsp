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
                <h1><c:out value='${negocio.nombre}'/></h1>
                
                <h5>Califícanos! </h5>
<div class="rating"> <input type="radio" name="rating" value="5" id="5"><label for="5">☆</label> <input type="radio" name="rating" value="4" id="4"><label for="4">☆</label> <input type="radio" name="rating" value="3" id="3"><label for="3">☆</label> <input type="radio" name="rating" value="2" id="2"><label for="2">☆</label> <input type="radio" name="rating" value="1" id="1"><label for="1">☆</label>
</div>

                    <fieldset class="form-group">
                            <label>Nombre: <c:out value='${negocio.nombre}' /></label> 
                    </fieldset>

                    <fieldset class="form-group">
                            <label>Descripción : <c:out value='${negocio.descripcion}' /></label> 
                    </fieldset>
                  

                    <a href="<%=request.getContextPath()%>/list=" class="btn btn-primary">Volver</a>
                    </form>
            </div>
        </div>                           
    </div>
    
</body>
</html>
