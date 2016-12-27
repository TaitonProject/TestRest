/**
 * UserController
 * @constructor
 */
MessageController = function ($scope, $http) {

    $scope.message = {};
    $scope.date = new Date();

    $scope.addMessage = function (message) {
        $http.post('/addMessage', message).success(function () {
            $scope.resetError();
            $scope.fetchMessagesList(message.requestedDate);
            $scope.message = {
                employeeIdEmployee : null,
                durationTime : null,
                requestedDate : null,
                requestedTime : null,
                employee : null
            };
        }).error(function () {
            $scope.setError('Не удалось добавить заявку')
        });
    };

    $scope.editMessage = function (message) {
        $scope.resetError();
        $http.put('/update', message).success(function () {
            $scope.fetchMessagesList(message.requestedDate);
            $scope.message = {
                durationTime : null,
                requestedDate : null,
                requestedTime : null
            };
        }).error(function () {
            $scope.setError('Не удалось редактирвоать заявку')
        });
    };

    $scope.fetchMessagesList = function(date) {
        $scope.resetError();
        $http.get('/messagesList.json/' + date).success(function(messagesList){
            $scope.messages = messagesList;
        });
    };

    $scope.selectedDate = function (date) {
        $scope.resetError();
        $scope.fetchMessagesList(date);
    };

    $scope.selectedTime = function (time) {
        $scope.resetError();
        $scope.time = time;
    };

    $scope.resetError = function() {
        $scope.error = false;
        $scope.errorMessage = '';
    };

    $scope.setError = function(message) {
        $scope.error = true;
        $scope.errorMessage = message;
    };

    $scope.fetchMessagesList();

    $scope.predicate = 'requestedTime'
};

