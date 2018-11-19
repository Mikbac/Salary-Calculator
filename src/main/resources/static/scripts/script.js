var app = angular.module('myApp', []);


app.controller('myCtrl', function($scope, $http) {

$scope.content=0;

 $scope.myFunc = function(country, value) {
  $http.get("/country/salary/"+country+"/"+value)
  .then(function(response) {
      $scope.content = response.data;    
  });
  
    };
  
  
});