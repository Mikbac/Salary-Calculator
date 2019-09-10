/**
 * Created by MikBac on 2018
 */


var app = angular.module('myApp', []);


app.controller('myCtrl', function ($scope, $http) {
    $scope.content = "0";
    $scope.calculate = function (country, value) {
        $http.get("/salary-calculator/salary/pln/?countryCode=" + country + "&salary=" + value, {responseType: 'text'})
            .then(function successCallback(response) {
                    $scope.content = response.data;
                }, function errorCallback(response) {
                    $scope.content = "error";
                }
            );
    };
});