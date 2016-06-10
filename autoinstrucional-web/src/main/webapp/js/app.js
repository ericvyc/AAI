'use strict';
 
var App = angular.module('meuApp',['ui.router']);

App.config(['$stateProvider','$urlRouterProvider', function($stateProvider, $urlRouterProvider) {
    
    $urlRouterProvider.otherwise('/');
    
    $stateProvider

        .state('estado', {
            url: '/estado',
            templateUrl: 'crudEstado.jsp'
        })
        
        .state('endereco', {
        	url: '/endereco',
            templateUrl: 'crudEndereco.jsp'      
        })
        
        .state('pessoa', {
            url: '/pessoa',
            templateUrl: 'crudPessoa.jsp'      
        });
    
}]);