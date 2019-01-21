var app = angular.module('myApp', []);


app.controller('myCtrl', function($scope, $http) {

$scope.content=0;

 $scope.myFunc = function(country, value) {
  $http.get("/country-management/salary/"+country+"/"+value)
  .then(function(response) {
      $scope.content = response.data;    
  });
  
    };
  
  
});