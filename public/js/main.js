/**
 * Created by andersonjso on 3/13/18.
 */

var app = angular.module("myApp", ["ngRoute"]);

app.config(function($routeProvider){
    $routeProvider
        .when("/", {
            templateUrl: "html/sourceCode.html",
            controller: "sourceCodeCtr",
        })
        .when("/dashboard", {
            templateUrl : "html/dashboard.html",
            controller: "dashboardCtr",
        })
        .when("/symptoms", {
            templateUrl : "html/symptoms.html",
            controller: "symptomCtr",
        });
    })

app.controller('sourceCodeCtr', ['$scope','$http', '$location', '$anchorScroll', function($scope,$http, $location, $anchorScroll){

        $http.get('/convert')
            .then(function(response){
                //the first item of the list is because I want to receive just one object
                $scope.dataResponse = response.data[0];
            });

          $scope.highlightCode = function(element) {

        for (var i=element.lineStart; i<=element.lineEnd; i++){
          //  console.log(i);
            var teste = 'li:nth-child(' + i + ')';
            myEl = angular.element( document.querySelector(teste))
            if (i%2 == 0){
                myEl.css('background','#ffc0b7');
            }
            else{
                myEl.css('background','#f9a89d');
            }
        }

        gotoAnchor(element)
    };

    gotoAnchor = function(element) {
        //4 is magic
        var correctedValue = element.lineStart-4;
        var eae =  ".linenums li:nth-child(" + correctedValue + ")";
        $(function () {
            $('div').animate({
                    scrollTop: $(eae).last().offset().top
                },
                'slow');
        });
    };
}]);

app.controller('dashboardCtr', ['$scope', '$http', 'dataFactory', function($scope, $http, dataFactory){

    // $http.get('/classes')
    //     .then(function(response){
    //         $scope.classes = response.data;
    //         console.log($scope.classes.source)
    //     });
    var symptomsToExclude = "empty";
    var listSymptoms = [];

    getClasses();

   // var b1 = document.getElementById("smellButton");

    $scope.isActivesmell = true;
    $scope.isActivearchitectural = true;
    $scope.isActiveobject = true;
    $scope.isActivenonFunctional = true;
    $scope.isActivestructural = true;

    // b1.onclick = function() {
    //     b1.style.background = "green";
    // }

    $scope.filterSymptom = function(symptom){
        var activeButton = 'isActive'+symptom;

        console.log(activeButton);
        if (listSymptoms.includes(symptom)) {
            var i = listSymptoms.indexOf(symptom);
            if(i != -1) {
                listSymptoms.splice(i, 1);

                switch (symptom){
                    case 'smell':
                        $scope.isActivesmell = true;
                        break;
                    case 'architectural':
                        $scope.isActivearchitectural =  true;
                    default:
                        break;
                }

            }
        }
        else{
            listSymptoms.push(symptom);
            switch (symptom) {
                case 'smell':
                    $scope.isActivesmell = false;
                    break;
                case 'architectural':
                    $scope.isActivearchitectural =  false;
                default:
                    break;
            }
        }

        if (listSymptoms.length == 0){
            symptomsToExclude = "empty";
        }
        else{
            symptomsToExclude = listSymptoms.toString().replace('[', '').replace(']', '');
        }





        getClasses();
    }

    function getClasses(){
        console.log("eata");
        dataFactory.getClasses(symptomsToExclude)
            .then (function(response){
                $scope.classes = response.data;

               // console.log(classes[0].syndrome.length)
            });
    }
}]);

app.controller('symptomCtr', ['$scope', '$http', 'dataFactory', function($scope, $http, dataFactory){

    getSymptoms();

    function getSymptoms(){
        console.log("vamos sintomas");
        dataFactory.getSymptoms()
            .then (function(response){
                $scope.symptoms = response.data;

                console.log($scope.symptoms)
            });
    }

    /*
     function getClasses(){
     console.log("eata");
     dataFactory.getClasses(symptomsToExclude)
     .then (function(response){
     $scope.classes = response.data;

     // console.log(classes[0].syndrome.length)
     });
     }
     */

    $scope.sendExample = function() {
        var file = document.getElementById("inputFile").files[0];

        var fd = new FormData();

        var test = {
            description:"Test",
            status: "REJECTED"
        };
     //   fd.append('data', angular.toJson(test));
        fd.append("file", file);
        fd.append('data', angular.toJson(test));


        $http({
            method: 'POST',
            url: '/snippets',
            headers: {'Content-Type': undefined},
            data: fd,
            transformRequest: angular.identity
        })
            .success(function(data, status) {
                alert("success");
            });



        // dataFactory.sendExample(file.data).then(function (response) {
        //
        //     console.log("aerohiuasdfhuiasdfhasdfkjlfasdjklnadfjkljkhl");
        //   console.log(response.data);
        // })

        // var fileReader = new FileReader();

        // fileReader.onloadend = function(e) {
        //     var data = e.target.result;
        //     //send your binary data via $http or $resource or do anything else with it
        // }
        // console.log($scope.userName);
        // console.log (file);
    }
}]);

app.factory('dataFactory', ['$http', function($http){
    var dataFactory = {};

    dataFactory.retrieveData = function(){
        return $http.get('/convert')
    }

    dataFactory.getClasses = function(data){
        return $http.put('/classes', data)
    }

    dataFactory.getSymptoms = function(){
        return $http.get('/symptoms/type')
    }

    dataFactory.sendExample = function(data){
        return $http.post('/snippets', data)
    }

    return dataFactory;
}])