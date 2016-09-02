'use strict';

var app = angular.module('quizApp', ['ngRoute', 'ngSanitize']);
// Routing has been added to keep flexibility in mind. This will be used in future.
angular.module('quizApp')
.config(['$routeProvider',
  function ($routeProvider) {

      var routes = [
          {
              url: '/exam',
              template: 'quiz.html',
              controller: 'quizCtrl'
          }
      ];

      routes.forEach(function (r, index) {
          $routeProvider.when(r.url, { templateUrl: r.template, controller: r.controller });
      });

      $routeProvider.otherwise({ redirectTo: '/exam' });
  }]);
