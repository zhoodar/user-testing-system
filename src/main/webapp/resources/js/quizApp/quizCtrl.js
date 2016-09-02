var extScope;
var quizCtrl = function ($scope, $http, helper) {
    $scope.quizName = '/miie/testing/questions';
    extScope = $scope;
    $scope.init= function () {
        $scope.mode = 'checking';
    };
    
    $scope.init();
    
    $scope.startQuiz = function (id) {
        var quizUrl;
        if (id != null) {
            quizUrl = '/miie/testing/questions?id=' + id;
            $scope.loadQuiz(quizUrl)
        }
    };

    $scope.defaultConfig = {
        'allowBack': true,
        'allowReview': true,
        'autoMove': false,  // if true, it will move to next question automatically when answered.
        'duration': 0,  // indicates the time in which quiz needs to be completed. post that, quiz will be automatically submitted. 0 means unlimited.
        'pageSize': 1,
        'requiredAll': true,  // indicates if you must answer all the questions before submitting.
        'richText': false,
        'shuffleQuestions': true,
        'shuffleOptions': true
    };

    $scope.goTo = function (index) {
        if (index > 0 && index <= $scope.totalItems) {
            $scope.currentPage = index;
            $scope.mode = 'quiz';
        }
    };

    $scope.onSelect = function (question, option) {
            question.answers.forEach(function (element, index, array) {
                if (element.id != option.id) {
                    element.Selected = false;
                    //question.Answered = element.Id;
                }
            });
        

        if ($scope.config.autoMove == true && $scope.currentPage < $scope.totalItems)
            $scope.currentPage++;
    };

    $scope.onSubmit = function () {
        var answers = [];
        $scope.questions.forEach(function (q, index) {
            answers.push({ 'QuizId': $scope.quiz.id, 'QuestionId': q.id, 'Answered': q.Answered });
        });
        //
        //$http.post('api/Quiz/Submit', answers).success(function (data, status) {
        //    alert(data);
        //});
        console.log($scope.questions);
        $scope.mode = 'result';
    };

    $scope.confQuestion = function (totalItems) {
        var questions = $scope.quiz.questions;
        var result = [];
        for(var i =1;i<=$scope.totalItems;i++){
            result.push(questions[i]);
        }
        return result;
    };

    $scope.pageCount = function () {
        return Math.ceil($scope.questions.length / $scope.itemsPerPage);
    };
    
    $scope.loadQuiz = function (http) {
        $http.get(http)
         .then(function (res) {
             $scope.quiz = res.data;
             $scope.testConfig = res.data.testConfig;
             $scope.config = helper.extend({}, $scope.defaultConfig, res.data.config);
             $scope.totalItems = $scope.testConfig.quantityOfQuestions>$scope.quiz.questions.length ? $scope.quiz.questions.length:$scope.testConfig.quantityOfQuestions;
             $scope.questions = helper.shuffle($scope.confQuestion($scope.totalItems));
             $scope.itemsPerPage = $scope.defaultConfig.pageSize;
             $scope.currentPage = 1;
             $scope.duration = $scope.testConfig.durationOfQuiz;
             $scope.questionsForThis= $scope.confQuestion($scope.totalItems);
             $scope.mode = 'quiz';
             $scope.shuffleOptions();
             countdown( "countdown", $scope.duration, 0 );

             $scope.$watch('currentPage + itemsPerPage', function () {
                 var begin = (($scope.currentPage - 1) * $scope.itemsPerPage),
                   end = begin + $scope.itemsPerPage;

                 $scope.filteredQuestions = $scope.questions.slice(begin, end);
             });
         });
    };
    
    $scope.shuffleOptions = function(){
        $scope.questions.forEach(function (question) {
           question.answers = helper.shuffle(question.answers);
        });
    };

    $scope.totalScore = function () {
        var scores = 0;
        var counter =0;
        $scope.questions.forEach(function (question, index, array){
            counter++;
            if(counter <= $scope.totalItems){
                scores += question.point;
                return false;
            }
        });
        return scores;
    };

    $scope.countPoints = function () {
        var points = 0;
        $scope.questions.forEach(function (question, index, array){
            if($scope.isItCorrect(question)=='correct' ){
                points+=question.point;
                return false;
            }
        });
        return points;

    };

    $scope.isAnswered = function (index) {
        var answered = 'Not Answered';
        $scope.questions[index].answers.forEach(function (element, index, array) {
            if (element.Selected == true) {
                answered = 'Answered';
                return false;
            }
        });
        return answered;
    };

    $scope.isItCorrect = function (question) {
        var result = 'correct';
        question.answers.forEach(function (option, index, array) {
            if (helper.toBool(option.Selected) != option.isCorrect) {
                result = 'wrong';
                return false;
            }
        });
        return result;
    };

    $scope.totalScored = function() {
        return parseInt($scope.countPoints()*100/ $scope.totalScore()); 
    };

    function countdown( elementName, minutes, seconds )
    {
        var element, endTime, hours, mins, msLeft, time;

        function twoDigits( n )
        {
            return (n <= 9 ? "0" + n : n);
        }

        function updateTimer()
        {
            msLeft = endTime - (+new Date);
            if ( msLeft < 1000 ) {
                window.alert("Время вышло!");
                extScope.$apply(function () {
                    extScope.mode = 'result';
                })

            } else {
                time = new Date( msLeft );
                hours = time.getUTCHours();
                mins = time.getUTCMinutes();
                element.innerHTML = (hours ? hours + ':' + twoDigits( mins ) : mins) + ':' + twoDigits( time.getUTCSeconds() );
                setTimeout( updateTimer, time.getUTCMilliseconds() + 500 );
            }
        }

        element = document.getElementById( elementName );
        endTime = (+new Date) + 1000 * (60*minutes + seconds) + 500;
        updateTimer();
    }

};

quizCtrl.$inject = ['$scope', '$http', 'helperService'];
app.controller('quizCtrl', quizCtrl);
