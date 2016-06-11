'use strict';
 
App.controller('EnderecoController', ['$scope', 'EnderecoService','EstadoService', 'CidadeService', function($scope, enderecoService, estadoService, cidadeService) {
	 	var self = this;
	 	self.endereco={id:null,logradouro:'',complemento:'',cidade:null,estado:null};
	    self.enderecos=[];
	    self.cidade={id:null,nome:'',estado:''};
	    self.cidades=[];
	    self.estado = {id:null,nome:'',sigla:''};
	    self.estados = [];
	         
	    
	    self.findAllCidades = function() {
	    	cidadeService.findAll()
	    	.then(
	    			function(d) {

	    				self.cidades = d;
	    			},
	    			function(errResponse){
	    				console.error('Erro ao buscar cidades');
	    			}
	    	);
	    };
		
		self.findAllEstados = function() {
			estadoService.findAll()
			.then(
					function(d) {

						self.estados = d;
					},
					function(errResponse){
						console.error('Erro ao buscar estados');
					}
			);
		};
	    
	    self.findAll = function(){
	    	enderecoService.findAll()
	              .then(
	                   function(d) {
	                	   
	                        self.enderecos = d;
	                   },
	                    function(errResponse){
	                        console.error('Erro ao buscar estados');
	                    }
	               );
	      };
	      
	    /* Função que cria um novo endereco */ 
	    self.criarendereco = function(endereco){
	  	  endereco.id=null;
	        enderecoService.criarendereco(endereco)
	                .then(
	                self.findAll, 
	                        function(errResponse){
	                             console.error('Erro ao criar endereco.');
	                        } 
	            );
	    };
	    
	    /* Função que atualiza os dados de um endereco */ 
	    self.updateendereco = function(endereco){
	        enderecoService.updateendereco(endereco)
	                .then(
	                        self.findAll, 
	                        function(errResponse){
	                             console.error('Erro ao atualizar endereco.');
	                        } 
	            );
	    };
	    
	    /* Função que exclui um endereco */ 
	    self.deleteendereco = function(id){
	        enderecoService.deleteendereco(id)
	                .then(
	                        self.findAll, 
	                        function(errResponse){
	                             console.error('Erro ao deletar endereco.');
	                        } 
	            );
	    };
	    
	    /* Função que exclui todos os enderecos cadatrados */ 
		  self.deletarTodos = function() {
				enderecoService.deletarTodos().then(self.findAll,
						function(errResponse) {
							console.error('Erro ao deletar todas as enderecos.');
						});
			};
	    
	    /* Função de envio dos dados do formulário */ 
	    self.submit = function() {
	        if(self.endereco.id === null  || self.endereco.id === undefined || self.endereco.id === ''){
	            console.log('Salvando novo endereco', self.endereco);    
	            debugger;
	            self.endereco.cidade = JSON.parse(self.cidade);
	        	self.endereco.estado = JSON.parse(self.estado);
	            self.criarendereco(self.endereco);
	        }else{
	        	debugger;
	        	self.endereco.cidade = JSON.parse(self.cidade);
	        	self.endereco.estado = JSON.parse(self.estado);
	            self.updateendereco(self.endereco);
	            console.log('endereco atualizada com o id ', self.endereco.id);
	        }
	        self.reset();
	        self.findAll();

	    };
	    
	    /* Função para edição de um endereco */ 
	    self.edit = function(id){
	        console.log('id para ser editado', id);
	        for(var i = 0; i < self.enderecos.length; i++){
	            if(self.enderecos[i].id === id) {
	               self.endereco = angular.copy(self.enderecos[i]);
	               break;
	            }
	        }
	    };
	    
	    /* Função que chama a função de excluir um endereco */ 
	    self.remove = function(id){
	        console.log('id para ser deletado', id);
	        if(self.endereco.id === id) {
	           self.reset();
	        }
	        self.deleteendereco(id);
	    };
	    
	    /* Função que limpa os dados do formulário */ 
	    self.reset = function(){
	        self.endereco={id:'',nome:'',sigla:''};
	        $scope.meuForm.$setPristine();
	    };
	      
	    self.findAll();
	    self.findAllCidades();
	    self.findAllEstados();
}]);