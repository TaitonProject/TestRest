/**
 * UserController
 * @constructor
 */
RegistrationController = function ($scope, $http) {

    $scope.employee = {};
    $scope.editMode = false;

    $scope.fetchEmployeeList = function () {
        $scope.resetError();
        $http.get('registration/employeeList.json').success(function (response) {
            $scope.employees = response;
        }).error(function () {
            $scope.setError('Не удалось предоставить список сотрудников.')
        });
    };

    $scope.addEmployee = function (employee) {
        $http.post('registration/addEmployee', employee).success(function () {
            $scope.resetError();
            $scope.fetchEmployeeList(employee.requestedDate);
            $scope.employee = {
                name : null,
                idEmployee : null
            };
        }).error(function () {
            $scope.setError('Не удалось добавить отрудника')
        });
    };

    $scope.updateEmployee = function(employee) {
        $scope.resetError();

        $http.put('registration/updateEmployee', employee).success(function() {
            $scope.fetchEmployeeList();
            $scope.employee.name = '';
            $scope.editMode = false;
        }).error(function() {
            $scope.setError('Обновить не удалось');
        });
    };

    $scope.removeEmployee = function(idEmployee) {
        $scope.resetError();

        $http.delete('registration/removeEmployee/' + idEmployee).success(function() {
            $scope.fetchEmployeeList();
        }).error(function() {
            $scope.setError('Не удалось удалит ьсотрудника');
        });
        $scope.employee.name = '';
    };

    $scope.resetEmployeeForm = function() {
        $scope.resetError();
        $scope.employee = {};
        $scope.editMode = false;
    };

    $scope.editEmployee = function(employee) {
        $scope.resetError();
        $scope.employee = employee;
        $scope.editMode = true;
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

    $scope.predicate = 'name';
};
