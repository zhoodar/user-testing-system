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
                <li class="active"><a href="#"><span class="glyphicon glyphicon-home"></span></a></li>
                <li><a href="${pageContext.servletContext.contextPath}/testing">Тестирование</a></li>
                <li><a href="${pageContext.servletContext.contextPath}/student">Студенту</a></li>
                <li><a href="${pageContext.servletContext.contextPath}/teacher">Преподователю</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"> Инфо <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">О программе</a></li>
                        <li><a href="#">Инструкция</a></li>
                    </ul>
                </li>
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
            <p class="lead">
                Приветствуем Вас в системе тестирования MIIE.
                Данная система предназначена для создания и проведения тестов.
                Более подробнее познакомиться с системой можно на странице <a href="#">"Инструкция"</a>.
                Если у Вас есть логин и пароль для прохождения теста по какой-нибудь теме, заходите во вкладку <a href="#">"Студенту"</a>.
                При наличии у Вас доступа к созданию тестов - <a href="#">"Преподавателю"</a>.</p>
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