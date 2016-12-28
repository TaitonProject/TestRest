/**
 * UserController
 * @constructor
 */
ReservationController = function ($scope, $http) {

    $scope.message = {};
    $scope.dateNow = new Date();
    $scope.reqDate = null;

    $scope.addMessage = function (message) {
        $http.post('reservation/addMessage', message).success(function () {
            $scope.resetError();
            $scope.fetchMessagesList(message.requestedDate);
            $scope.message = {
                employeeIdEmployee : null,
                durationTime : null,
                requestedDate :  null,
                requestedTime : null
            };
        }).error(function (data, status) {
            if (status === 400){
                $scope.setError('Чо-т не то!')
            } else {
                $scope.setError('Не удалось добавить заявку')
            }
        });
    };

    $scope.updateMessage = function(message) {
        $scope.resetError();

        $http.put('reservation/updateMessage', message).success(function() {
            $scope.fetchMessagesList();
            $scope.message = {
                employeeIdEmployee : null,
                durationTime : null,
                requestedDate : null,
                requestedTime : null
            };
            $scope.editMode = false;
        }).error(function() {
            $scope.setError('Could not update the message');
        });
    };

    $scope.editMessage = function(message) {
        $scope.resetError();
        $scope.message = message;
        $scope.editMode = true;
    };

    $scope.fetchMessagesList = function(date) {
        $scope.resetError();
        $http.get('reservation/messagesList.json/' + date).success(function(messagesList){
            $scope.messages = messagesList;
            $scope.reqDate = date;
        }).error(function (data, status) {
            if(status === 402){
                $scope.errorMessage = 'Нет заявок на этот день.'
            } else {
              $scope.errorMessage = 'Не удалось вывести список заявок, поробуйте еще раз.'
            }
        });
    };

    $scope.fetchEmployeeList = function () {
        $scope.resetError();
        $http.get('reservation/employeeList.json').success(function (response) {
            $scope.employees = response;
        }).error(function () {
            $scope.setError('Не удалось предоставить список сотрудников.')
        });
    };

    $scope.selectedDate = function (date) {
        $scope.resetError();
        $scope.fetchMessagesList(date);
    };

    $scope.selectedTime = function (time) {
        $scope.resetError();
        $scope.time = time;
        var durationTimeInput = angular.element(document.querySelector('#durationTimeInput'));
        durationTimeInput.attr('min',time);
    };

    $scope.resetMessageForm = function() {
        $scope.resetError();
        $scope.message = {};
        $scope.editMode = false;
    };

    $scope.resetError = function() {
        $scope.error = false;
        $scope.errorMessage = '';
    };

    $scope.setError = function(message) {
        $scope.error = true;
        $scope.errorMessage = message;
    };

    $scope.fetchEmployeeList();

    $scope.fetchMessagesList();

    $scope.predicate = 'requestedTime'
};

