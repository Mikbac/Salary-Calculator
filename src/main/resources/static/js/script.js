/**
 * Created by MikBac on 2018
 */


var app = angular.module('myApp', []);


app.controller('myCtrl', function ($scope, $http) {
    $scope.content = "0";
    $scope.myFunc = function (country, value) {
        $http.get("/salary-calculator/salary/pln/?countryCode=" + country + "&salary=" + value, {responseType: 'text'})
            .then(function (response) {
                $scope.content = response.data;
            });
    };
});