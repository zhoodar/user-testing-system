<%--
  Created by IntelliJ IDEA.
  @: Zhoodar
  Date: 03.08.2016
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Добро пожаловать</title>

    <!-- Bootstrap -->
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/style/style.css" rel="stylesheet">

</head>
<body>
<!-- Fixed navbar -->
<nav class="navbar navbar-inverse navbar-fixed-top">
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
                <li class="active"><a href="${pageContext.servletContext.contextPath}/administration"><span class="glyphicon glyphicon-home"></span></a></li>
                <li><a href="${pageContext.servletContext.contextPath}/administration/tests">Тесты</a></li>
                <li class="dropdown">
                    <a href="${pageContext.servletContext.contextPath}/administration/groups" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"> Студенты <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="${pageContext.servletContext.contextPath}/administration/add/students">Добавить студента</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="${pageContext.servletContext.contextPath}/administration/teachers" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"> Преподователи <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="${pageContext.servletContext.contextPath}/administration/add/teacher">Добавить преподователа</a></li>
                    </ul>
                </li>
                <li><a href="">Резултаты тестов</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><span class="glyphicon glyphicon-user"></span> admin <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Настройки</a></li>
                    </ul>
                </li>
                <li><a href="${pageContext.servletContext.contextPath}/"><span class="glyphicon glyphicon-log-out"></span> Выйти</a> </li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>
<!-- Begin page content -->
<div class="container">
    <div class="row">
        <div class="col-sm-12">
            <div class="page-header">
                <h2>Most Important Is Education</h2>
            </div>
            <p class="lead"> Admin</p>
        </div>
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