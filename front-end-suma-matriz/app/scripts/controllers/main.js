'use strict';

/**
 * @ngdoc function
 * @name sumaMatrizApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the sumaMatrizApp
 */
angular.module('sumaMatrizApp')
  .controller('MainCtrl', function ($scope) {
    this.awesomeThings = [
      'HTML5 Boilerplate',
      'AngularJS',
      'Karma'
    ];

    $scope.MatrixAndOperationsDTO = {};
    $scope.MatrixAndOperationsDTO.operations = [];

    $scope.addQuery = function () {
      $scope.MatrixAndOperationsDTO.operations.push({
        operationName: 'QUERY'
      });
    }
    $scope.addUpdate = function () {
      $scope.MatrixAndOperationsDTO.operations.push({
        operationName: 'UPDATE'
      });
    }
  });
