/**
 * Created by Taiton on 12/15/2016.
 */
/**
 * UserController
 * @constructor
 */
/*angular.module('AppRole',[]).controller('RoleController',
    function($scope, $http) {
    $http.get('/listRoles.json').success(function (response) {
        $scope.roles = response;
    });
});*/
EmployeeController = function ($scope, $http) {

    $scope.fetchEmployeeList = function () {
        $scope.resetError();
        $http.get('/employeeList.json').success(function (response) {
            $scope.authors = response;
        }).error(function () {
            $scope.setError('беда в предосталвнии списка')
        });
    };

    $scope.setError = function (message) {
        $scope.error = false;
        $scope.errorMessage = message;
    };

    $scope.resetError = function() {
        $scope.error = false;
        $scope.errorMessage = '';
    };

    $scope.fetchEmployeeList();
};
