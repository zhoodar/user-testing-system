<%--
  Created by IntelliJ IDEA.
  @: Zhoodar
  Date: 23.08.2016
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
                <li ><a href="${pageContext.servletContext.contextPath}/teacher">Назад</a></li>
                <li class="active"><a href="#">Конфигурация</a></li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>
<!-- Begin page content -->
<div class="container">
    <div class="row">
        <div class="col-xs-8 col-sm- col-md-8">
            <h2>Устонвить конфигурацию </h2>
            <div class="well">
                <form class="form-horizontal" action="${pageContext.request.contextPath}/teacher/set/config"  method="post">
                    <input type="hidden" name="testId" value="${test.id}">
                    <div class="form-group">
                        <label class="control-label col-xs-5" for="Name">Время тестирование в минутах:</label>
                        <div class="col-xs-7">
                            <input type="text" class="form-control" id="Name" name="duration" placeholder="Введите время в минутах">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-xs-5" for="group" >Статус теста:</label>
                        <div class="col-xs-7">
                            <select class="form-control" id="group" name="isActive" >
                                <option value="true">Активно</option>
                                <option value="false">Отключено</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-xs-5" for="quantity">Количество вопросов во время теста:</label>
                        <div class="col-xs-7">
                            <input type="text" class="form-control" id="quantity" name="quantity" placeholder="Введите количество вопросов">
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-3">
                        </div>
                        <div class="col-md-4">
                            <input type="reset" class="btn btn-default" value="Очистить форму">
                        </div>
                        <div class="col-md-5">
                            <input type="submit" class="btn btn-primary" value="Устонавить">
                        </div>
                    </div>
                </form>
            </div>
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
