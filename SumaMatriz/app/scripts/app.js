'use strict';

/**
 * @ngdoc overview
 * @name sumaMatrizApp
 * @description
 * # sumaMatrizApp
 *
 * Main module of the application.
 */
angular
  .module('sumaMatrizApp', [
    'ngResource',
    'ngRoute'
  ])
  .config(function ($routeProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'views/main.html',
        controller: 'MainCtrl',
        controllerAs: 'main'
      })
      .otherwise({
        redirectTo: '/'
      });
  });
