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
    <title>Авторизация</title>

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
                <li><a href="${pageContext.request.contextPath}/">Назад</a></li>
            </ul>
        </div>
    </div>
</nav>
<!-- Begin page content -->
    <div class="container">
        <div class="row">
            <div class="row">
                <div class="col-md-4"></div>
                <div class="col-md-4">
                    <c:if test="${not empty error}">
                    <div class="alert alert-danger">
                        <strong>Oops!</strong> Something went wrong! <br/>
                        ${error}
                    </div>
                    </c:if>
                </div>
            </div>
            <div class="row">
                <div class="col-md-4"></div>
                <div class="col-md-4">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <h3 class="panel-title"> Авторизация </h3>
                        </div>
                        <c:url value="/j_spring_security_check"  var="loginUrl"/>
                        <form name="form_login" action="${loginUrl}" method="post">
                            <div class="panel-body">
                                <div class="col-md-12">
                                    <div class="input-group">
                                        <span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
                                        <input type="text" name="j_username" class="form-control" placeholder="Имя пользователя" required autofocus />
                                    </div>
                                    <div class="input-group">
                                        <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
                                        <input type="password" name="j_password" class="form-control" placeholder="Ваш пароль" required />
                                    </div>
                                </div>
                            </div>
                            <div class="panel-footer">
                                <div class="row">
                                    <div class="col-md-1">
                                    </div>
                                    <div class="col-md-5"></div>
                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <button type="submit" name="submit" class="btn btn-labeled btn-primary">Войти</button>
                                    </div>
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