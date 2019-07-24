/**
 * Created by MikBac on 2018
 */


var app = angular.module('myApp', []);


app.controller('myCtrl', function ($scope, $http) {

    $scope.content = 0;

    $scope.myFunc = function (country, value) {
        $http.get("/salary-calculator/country/" + country + "/salary/" + value + "/salaryPLN")
            .then(function (response) {
                $scope.content = response.data;
            });
    };

});