<%-- 
    Document   : user_login
    Created on : may 6, 2021, 7:13:11 p.m.
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
                        class="nav-link">Inicio</a></li>
            </ul>
            <ul class="navbar-nav">
                <li><a href="<%=request.getContextPath()%>/new"
                        class="nav-link">Registrarme</a></li>
            </ul>
        </nav>
    </header>
    <br>

    <div class="row">
            <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

        <div class="container">
            <h3 class="text-center">Login</h3>
            <hr>
            <div class="container text-left">
                <form action="home" method="post">
                    <fieldset class="form-group">
                            <label>Nickname</label> <input type="text"
                                    class="form-control"
                                    name="nickname" required="required" placeholder="ejem1234">
                    </fieldset>

                    <fieldset class="form-group">
                            <label>Password</label> <input type="password"
                                     class="form-control"
                                    name="password" required="required" placeholder="password">
                    </fieldset>
                    
                    <button type="submit" class="btn btn-success">Ingresar</button>
                </form>
                
            </div>
            <br>
            
        </div>
    </div>
</body>
</html>
