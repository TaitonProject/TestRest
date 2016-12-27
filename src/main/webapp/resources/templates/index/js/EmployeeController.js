/**
 * UserController
 * @constructor
 */
EmployeeController = function ($scope, $http) {

    $scope.fetchEmployeeList = function () {
        $scope.resetError();
        $http.get('/employeeList.json').success(function (response) {
            $scope.authors = response;
        }).error(function () {
            $scope.setError('Не удалось предоставить список сотрудников.')
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
