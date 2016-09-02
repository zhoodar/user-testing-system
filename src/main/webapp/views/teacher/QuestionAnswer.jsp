
<%--
  Created by IntelliJ IDEA.
  @: Zhoodar
  Date: 05.08.2016
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
                <li ><a href="${pageContext.servletContext.contextPath}/teacher">Назад</a></li>
                <li class="active"><a href="#">Добавить тест</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"> <span class="glyphicon glyphicon-user"></span> ${teacher.surname} ${teacher.name} <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Настройки</a></li>
                    </ul>
                </li>
                <li> <a href="${pageContext.servletContext.contextPath}/j_spring_security_logout"><span class="glyphicon glyphicon-log-out"></span> Выйти</a></li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>
<!-- Begin page content -->
<div class="container">
    <div class="row">
        <div class="col-md-10">
            <div class="row">
                <div class="col-md-3">
                    <c:if test="${ test.questions.size()>0}">
                        <c:choose>
                            <c:when test="${test.questions.size()==1}">
                                <div class="alert alert-success">
                                       Добавлено ${test.questions.size()} вопроc.
                                </div>
                           </c:when>
                            <c:otherwise>
                                <div class="alert alert-success">
                                    Добавлено ${test.questions.size()} вопроcов.
                                </div>
                            </c:otherwise>
                        </c:choose>
                    </c:if>
                </div>
            </div>
            <h3>Добавление вопроса и ответветов к тесту ${test.name}</h3>
            <div class="well">
                <form class="form-horizontal" action="${pageContext.request.contextPath}/teacher/add/test/question" method="post">
                    <input type="hidden" name="testId" value="${test.id}">
                    <div class="form-group">
                        <label class="control-label col-xs-3" for="question">Вопрос:</label>
                        <div class="col-xs-9">
                            <input type="text" class="form-control" name="question" id="question" placeholder="Введите вопрос" required>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-1"></div>
                        <div class="col-md-4">
                            <div class="form-group">
                                <label class="control-label col-xs-6" for="typeQ" >Тип ответа:</label>
                                <div class="col-xs-6">
                                    <select class="form-control" id="typeQ" name="questionType" >
                                        <option value="1">одиночный</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="form-group">
                                <label class="control-label col-xs-7" for="level">Уровень сложности :</label>
                                <div class="col-xs-5">
                                    <select class="form-control" id="level" name="complexity" >
                                        <option value="1">лёгкий</option>
                                        <option value="2">средный</option>
                                        <option value="3">сложный</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-3">
                            <div class="form-group">
                                <label class="control-label col-xs-3" for="point">Балл:</label>
                                <div class="col-xs-9">
                                    <input type="text" class="form-control" id="point" name="point" placeholder="Введите балл" required >
                                </div>
                            </div>
                        </div>
                    </div>
                    <hr>
                    <div class="form-group">
                        <label class="control-label col-xs-3" for="option1">Варианты ответов</label>
                    </div>
                    <div class="row">
                        <div class="col-md-1"></div>
                        <div class="col-md-5">
                            <div class="form-group">
                                <label class="control-label col-xs-5" for="option1">Вариант 1:</label>
                                <div class="col-xs-7">
                                    <textarea class="form-control" id="option1" name="option1" placeholder="Введите вариант 1"  required ></textarea>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-1"></div>
                        <div class="col-md-5">
                            <div class="form-group">
                                <label class="control-label col-xs-4" for="option2">Вариант 2:</label>
                                <div class="col-xs-8">
                                    <textarea class="form-control" id="option2" name="option2" placeholder="Введите вариант 2" required ></textarea>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-1"></div>
                        <div class="col-md-5">
                            <div class="form-group">
                                <label class="control-label col-xs-5" for="option3">Вариант 3:</label>
                                <div class="col-xs-7">
                                    <textarea class="form-control" id="option3" name="option3" placeholder="Введите вариант 3" ></textarea>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-1"></div>
                        <div class="col-md-5">
                            <div class="form-group">
                                <label class="control-label col-xs-4" for="option4">Вариант 4:</label>
                                <div class="col-xs-8">
                                    <textarea class="form-control" id="option4" name="option4" placeholder="Введите вариант 4" ></textarea>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-xs-3" for="key">Укажите правильный ответ:</label>
                        <div class="col-xs-3">
                            <select class="form-control" id="key" name="isCorrect">
                                <option value="1">Вариант 1</option>
                                <option value="2">Вариант 2</option>
                                <option value="3">Вариант 3</option>
                                <option value="4">Вариант 4</option>
                            </select>
                        </div>
                    </div>
                    <hr>
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