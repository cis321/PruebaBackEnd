'use strict';

/**
 * @ngdoc function
 * @name sumaMatrizApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the sumaMatrizApp
 */
angular.module('sumaMatrizApp')
  .controller('MainCtrl', function ($scope, ProcedureManagementService) {
    this.awesomeThings = [
      'HTML5 Boilerplate',
      'AngularJS',
      'Karma'
    ];

    $scope.MatrixAndOperationsDTO = {};
    $scope.MatrixAndOperationsDTO.operations = [];
    $scope.showResults = false;

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

    $scope.send = function () {
      ProcedureManagementService.getResults({}, $scope.MatrixAndOperationsDTO, sendSuccess, sendError);
    }

    function sendSuccess(response) {
      $scope.showResults = true;
      $scope.results = response
      console.log(response);

    }

    function sendError() {
      console.log('sendError');
    }
  });
