angular.module("myApp").controller('sourceCodeCtr', ['$scope','$http', '$location', '$anchorScroll', function($scope,$http, $location, $anchorScroll){

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