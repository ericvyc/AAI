'use strict';
 
App.controller('PessoaController', ['$scope', 'PessoaService', function($scope, PessoaService) {
	  var self = this;
	  self.pessoa={id:'',nome:'',idade:''};
	  self.pessoas=[];
	       
	  self.findAll = function(){
		  PessoaService.findAll()
		      .then(
		         function(d) {
		      	   
		              self.pessoas = d;
		         },
		          function(errResponse){
		              console.error('Erro ao buscar pessoas');
		          }
		      );
	  };
	  	              
	   self.findAll();
}]);