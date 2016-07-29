var controllers = angular.module('mainApp.controllers', ['ui.bootstrap']);
var services = angular.module('mainApp.services', ['ngResource']);
var mainApp = angular.module("mainApp", ['ngRoute','mainApp.controllers','angular-loading-bar','ui.bootstrap']);

function NavBarCtrl($scope) {
    $scope.navbarCollapsed = true;
}

mainApp.config(['$routeProvider', '$httpProvider', 'cfpLoadingBarProvider',
   function($routeProvider,$httpProvider,cfpLoadingBarProvider) {

	  cfpLoadingBarProvider.includeBar = false;
      $routeProvider.
         when('/home', {
            templateUrl: 'home.html',
            controller: 'HomeController'
         }).
         when('/consulta', {
            templateUrl: 'consultaReservas.html',
            controller: 'ReservasController'
         }).
         otherwise({
            redirectTo: '/home'
         });

      $httpProvider.interceptors.push(function($q, $rootScope, $location) {

		    return {
			    'request' : function(config) {
				    return config || $q.when(config);
			    }
		    };
	    });

   }]);

mainApp.run(
		  [
		    "$rootScope",
		    function($rootScope) {
		    	$rootScope.urlServices = 'http://localhost:8181/app';
		    	$rootScope.documento = '12324567';
}]);

mainApp.factory('ServicesFactory', [ '$rootScope','$http', function($rootScope,$http) {

   	var dataFactory = {};

   	dataFactory.listarVuelosEntreHoras = function(horaIni,horaFin){
   	 	return $http.get($rootScope.urlServices+'/reserva/listarTarifa/'+horaIni+"/"+horaFin);
   	}
   	dataFactory.listarVuelosEntreTarifas= function(min,max){
   	 	return $http.get($rootScope.urlServices+'/reserva/listarHorario/'+min+"/"+max);
   	}
   	
   	dataFactory.listarVuelosPorEstado= function(estado){
   	 	return $http.get($rootScope.urlServices+'/reserva/listarEstado/'+estado);
   	}
   	return dataFactory;
}]);
mainApp.controller('HomeController', ['$route', '$routeParams', '$location','$scope','ServicesFactory',
        function($route, $routeParams, $location,$scope,FacturaFactory) {
	
   }]);
