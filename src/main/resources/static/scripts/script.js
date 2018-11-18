var app = angular.module('myApp', []);


app.controller('myCtrl', function($scope, $http) {
$scope.value=0;
//$scope.country="";
$scope.content=0;

 $scope.myFunc = function(country) {
  $http.get("/country/salary/"+country+"/"+$scope.value)
  .then(function(response) {
      $scope.content = response.data;    
  });
  
    };
  
  
});