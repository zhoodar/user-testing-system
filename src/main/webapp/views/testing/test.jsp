<%--
  Created by IntelliJ IDEA.
  @: Zhoodar
  Date: 05.08.2016
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ru" ng-app="quizApp">
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
                <li class="active"><a href="${pageContext.servletContext.contextPath}/testing/available/tests">Тестирование</a></li>
                <li><a href="${pageContext.servletContext.contextPath}/student">Выйти</a></li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>
<!-- Begin page content -->
<div class="container">
    <div ng-view></div>
    <script type="text/ng-template" id="quiz.html">
        <div id="quiz">
            <div class="col-sm-12">
                <div ng-show="mode!='result'&& mode!='checking' ">
                    <div class="row">
                        <div class="col-sm-9">
                            <h3 class="text-center">{{quiz.name}}</h3>

                        </div>
                        <div class="col-sm-3 right">
                            <jsp:useBean id="date" class="java.util.Date" />
                            <fmt:formatDate value="${date}" type="date" dateStyle="medium" var="currentdate" />
                            <p style="font-size: 16px;"> Сегодня: <c:out value="${currentdate}" /><br>
                                Оставшееся время: <span style="color: #d58512;" id="countdown"></span> </p>
                        </div>
                    </div>
                </div>

                <div ng-show="mode=='quiz'">
                    <div class="label label-warning"> {{currentPage}} из {{totalItems}} вопросов.</div>
                    <div class="well">
                        <div ng-repeat="question in filteredQuestions">
                            <div class="row">
                                <div class="col-md-12">
                                    <h3>{{currentPage}}. <span ng-bind-html="question.text"></span></h3>
                                </div>
                            </div>
                            <div class="row text-left options">
                                <div class="col-md-6" ng-repeat="option in question.answers">
                                    <div class="option">
                                        <label class="" for="{{option.id}}">
                                            <input  id="{{option.id}}" type="checkbox" ng-model="option.Selected" ng-change="onSelect(question, option);" />
                                            {{option.text}}
                                        </label>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6"></div>
                            <div class="col-md-3">
                                <button class="btn btn-default" ng-show="config.allowBack" ng-click="goTo(currentPage - 1);">Предыдуший</button>
                            </div>
                            <div class="col-md-3">
                                <button class="btn btn-primary" ng-click="goTo(currentPage + 1);">Следующий</button>
                            </div>

                        </div>
                    </div>
                </div>
                <div class="row review" ng-show="mode=='review'">
                    <div class="col-sm-4" ng-repeat="question in questions">
                        <div ng-click="goTo($index + 1)" class="{{ isAnswered($index) == 'Answered'? 'answered': 'not-answered' }}">{{$index + 1}}. {{ isAnswered($index) }}</div>
                    </div>
                </div>
                <br/>
            </div>
        </div>

        <div ng-show="mode=='checking'">
            <div class="row">
                <div class="col-md-3"></div>
                <div class="col-md-6">
                    <div class="panel panel-info">
                        <div class="panel-body">
                            <p class="lead">
                                <strong>Экзамен: ${test.name}</strong><br>
                                Количество вопросов: ${test.testConfig.quantityOfQuestions} <br>
                                Продолжительность экзамена:${test.testConfig.durationOfQuiz} мин.
                            </p>


                            <div class="row">
                                <div class="col-md-4 "></div>
                                <div class="col-md-8 ">
                                    <button class="btn btn-success" ng-click="startQuiz(${test.id})">Начать экзамен!</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="result" ng-show="mode=='result'">
            <h3>Результат</h3><hr/>
            <div class="row">
                <div class="col-md-6">
                    <p class="lead">Вы получили {{ totalScored() }}% </p>
                    <ul>
                        <li>правилных ответов: {{countPoints()}}</li>
                        <li>неправилных ответов: {{ }}</li>
                    </ul>
                </div>
                <div class="col-md-6"></div>
            </div>
            <div class="panel panel-info">
                <div class="panel-body">
                    <p style="cursor:pointer; font-size: 16px; font-weight: bolder;" onClick="expandit(this)">
                    Показать/скрыть ответов тестирование</p>
                    <span style="display:none">
                        <div ng-repeat="question in questions">
                            <div class="result-question">
                                <h4>{{$index + 1}}. {{question.text}}</h4>
                                <div class="row">
                                    <div class="col-md-6" ng-repeat="answer in question.answers">
                                        <div>
                                            <input id="{{answer.id}}" type="checkbox" disabled="disabled" ng-model="answer.Selected" />
                                            {{answer.text}}
                                        </div>
                                    </div>
                                </div>
                                <h4 class="alert {{ isItCorrect(question) == 'correct'? 'alert-success': 'alert-danger'}}">Your answer is {{isItCorrect(question)}}.</h4>
                            </div>
                        </div>
                    </span>
                </div>
            </div>
        </div>
            <div class="col-md-6"></div>

                <div class="quizNav" ng-show="mode!='result'&& mode!='checking' ">
                    <hr />
                    <div class="col-md-2">
                        <button class="btn btn-default" ng-click="mode = 'quiz'">Тестирование</button>
                    </div>
                    <div class="col-md-2">
                        <button class="btn btn-default" ng-click="mode = 'review'">Просмотр</button>
                    </div>
                    <div class="col-md-2">
                        <button class="btn btn-success" ng-click="onSubmit();">Завершить тест</button>
                    </div>
                </div>
    </script>
</div>
<footer class="footer">
    <div class="container">
        <p class="text-muted">MIIE 2016 © </p>
    </div>
</footer>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="${pageContext.request.contextPath}/resources/js/jquery-1.12.4.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/angular.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/angular-sanitize.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/angular-route.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/quizApp/app.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/quizApp/helperService.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/quizApp/quizCtrl.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/quizApp/createCtrl.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jsapi.js"></script>
<script language="JavaScript1.2">
    var ns6=document.getElementById&&!document.all?1:0;
    var head="display:''";
    var folder='';
    function expandit(curobj){
        folder=ns6?curobj.nextSibling.nextSibling.style:document.all[curobj.sourceIndex+1].style
        if (folder.display=="none")
            folder.display="";
        else
            folder.display="none";
    }
</script>


</body>
</html>