
<%--
  Created by IntelliJ IDEA.
  @: Zhoodar
  Date: 03.08.2016
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
                <li class="active"><a href="#">Тесты</a></li>
                <li><a href="${pageContext.servletContext.contextPath}/teacher/add/test">Добавить тест</a></li>
                <li> <a href="${pageContext.servletContext.contextPath}/teacher/results">Результаты</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><span class="glyphicon glyphicon-user"></span> ${teacher.surname} ${teacher.name} <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Настройки</a></li>
                    </ul>
                </li>
                <li><a href="${pageContext.servletContext.contextPath}/j_spring_security_logout"><span class="glyphicon glyphicon-log-out"></span> Выйти</a> </li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>
<!-- Begin page content -->
<div class="container">
    <div class="row">
        <div class="col-sm-12">
            <div class="page-header">
                <h3 class="sub-header">Все тесты</h3>
            </div>
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>Наименование</th>
                        <th>Кол-во вопросов </th>
                        <th>Категория</th>
                        <th>Действие</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${tests}" var="test" varStatus="status">
                    <tr>
                        <td>${1}</td>
                        <td>${test.name}</td>
                        <td>${test.questions.size()}</td>
                        <td>${test.category.name}</td>
                        <td><a title="Добавить вопрос" href="${pageContext.request.contextPath}/teacher/add/question/test?id=${test.id}" ><span class="glyphicon glyphicon-plus"></span></a>
                             &nbsp; <a title="Устонавить конфиг" href="${pageContext.request.contextPath}/teacher/set/config/test?id=${test.id}"><span class="glyphicon glyphicon-cog"></span></a>
                        </td>
                    </tr>
                    </c:forEach>
                    </tbody>
                </table>
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