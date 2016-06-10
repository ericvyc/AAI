'use strict';
 
App.factory('EnderecoService', ['$http', '$q', function($http, $q){
 
	 return {
	        /* Busca todos enderecos */ 
	        findAll: function() {
	            return $http.get('http://localhost:8080/autoinstrucional/endereco/findall')
	                .then(
	                    function(response){
	                        return response.data;
	                    }, 
	                    function(errResponse){
	                        console.error('Erro ao recuperar enderecos');
	                        return $q.reject(errResponse);
	                    }
	                );
	        },

	        /* Insere novo endereco */ 
	        criarendereco: function(endereco){        	
	        		return $http.post('http://localhost:8080/autoinstrucional/endereco/new', endereco)
	                		.then(
	                				function(response){
	                					return response.data;
	                				}, 
	                				function(errResponse){
	                					console.error('Erro ao criar endereco');
	                					return $q.reject(errResponse);
	                				}
	                		);
	        },

	        /* Atualiza um endereco */ 
	        updateendereco: function(endereco){        	
	                return $http.post('http://localhost:8080/autoinstrucional/endereco/update', endereco)
	                        .then(
	                                function(response){
	                                    return response.data;
	                                }, 
	                                function(errResponse){
	                                    console.error('Erro ao atualizar endereco');
	                                    return $q.reject(errResponse);
	                                }
	                        );
	        },
	         
	         /* Exclui um endereco */ 
	        deleteendereco: function(id){
	                return $http.get('http://localhost:8080/autoinstrucional/endereco/delete/'+id)
	                        .then(
	                                function(response){
	                                    return response.data;
	                                }, 
	                                function(errResponse){
	                                    console.error('Erro ao deletar endereco');
	                                    return $q.reject(errResponse);
	                                }
	                        );
	        },

	        /* Exclui todos os enderecos */ 
	        deletarTodos: function() {        	
	        	return $http.get('http://localhost:8080/autoinstrucional/endereco/deleteall')
	        			.then(
	        					function(response){
	                                return response.data;
	                            }, 
	                            function(errResponse){
	                                console.error('Erro ao deletar todas as enderecos');
	                                return $q.reject(errResponse);
	                            }
	        			
	        			);
	        }
	    };
}]);