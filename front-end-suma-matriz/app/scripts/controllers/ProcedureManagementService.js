angular
  .module('sumaMatrizApp')
  .factory('ProcedureManagementService', procedureManagementService);

function procedureManagementService($resource) {
  var defaultParams = {};
  var urlBase = 'http://localhost:8094/';

  var actions = {
    getResults: {
      method: 'POST',
      url: urlBase + 'matrix/',
      isArray: true,
    },
  };

  return $resource(urlBase, defaultParams, actions);
}
