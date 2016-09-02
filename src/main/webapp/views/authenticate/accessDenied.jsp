<%--
  Created by IntelliJ IDEA.
  @: Zhoodar
  Date: 19.08.2016
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Access denied</title>

    <!-- Bootstrap -->
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/style/style.css" rel="stylesheet">

</head>
<body>
<!-- Fixed navbar -->
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Система тестирование MIIE</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li><a href="${pageContext.request.contextPath}/j_spring_security_logout">Назад</a></li>
            </ul>
        </div>
    </div>
</nav>
<!-- Begin page content -->
<div class="container">
    <div class="center-block">
        <div class="page-header">
            <h2>HTTP Status 403 - Access is denied</h2>
        </div>
        <div class="alert alert-warning"><p class="lead"> ${errorMsg} </p> </div>
    </div>
</div>
<footer class="footer">
    <div class="container">
        <p class="text-muted">MIIE 2016 © </p>
    </div>
</footer>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="${pageContext.request.contextPath}/resources/js/jquery-1.12.4.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>

</body>
</html>