<%--
  Created by IntelliJ IDEA.
  @: Zhoodar
  Date: 05.08.2016
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
                <li ><a href="${pageContext.servletContext.contextPath}/teacher">Тесты</a></li>
                <li class="active"><a href="#">Добавить тест</a></li>
                <li> <a href="${pageContext.servletContext.contextPath}/teacher/results">Резултаты</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"> <span class="glyphicon glyphicon-user"></span> Teacher <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Настройки</a></li>
                    </ul>
                </li>
                <li> <a href="${pageContext.servletContext.contextPath}/"><span class="glyphicon glyphicon-log-out"></span> Выйти</a></li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>
<!-- Begin page content -->
<div class="container">
    <div class="row">
        <div class="col-xs-8 col-sm- col-md-8">
            <h2>Добавление нового Теста</h2>
            <div class="well">
                <form class="form-horizontal">
                    <div class="form-group">
                        <label class="control-label col-xs-3" for="lastName">Наименование</label>
                        <div class="col-xs-9">
                            <input type="text" class="form-control" id="lastName" placeholder="Введите называние">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-xs-3" for="group">Тест для:</label>
                        <div class="col-xs-9">
                            <select class="form-control" id="group" >
                                <option value="">пробный</option>
                                <option value="">A</option>
                                <option value="">B</option>
                                <option value="">C</option>
                            </select>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-3">
                        </div>
                        <div class="col-md-4">
                            <input type="reset" class="btn btn-default" value="Очистить форму">
                        </div>
                        <div class="col-md-5">
                            <input type="submit" class="btn btn-primary" value="Добавить">
                        </div>
                    </div>
                </form>

            </div>
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