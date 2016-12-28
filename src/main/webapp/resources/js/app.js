'use strict';

var AngularSpringApp = {};

var App = angular.module('AngularSpringApp', ['AngularSpringApp.filters', 'AngularSpringApp.services', 'AngularSpringApp.directives']);

// Declare app level module which depends on filters, and services
App.config(['$routeProvider', function ($routeProvider) {
    $routeProvider.when('/reservation', {
        templateUrl: 'reservation/layout',
        controller: ReservationController
    });

    $routeProvider.when('/registration', {
        templateUrl: 'registration/layout',
        controller: RegistrationController
    });


    $routeProvider.otherwise({redirectTo: '/reservation'});
}]);
