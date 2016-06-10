'use strict';
 
 /* Serviços relacionados a entidade Estado */ 
App.factory('EstadoService', ['$http', '$q', function($http, $q){
 
    return {
        /* Busca todos estados */ 
        findAll: function() {
            return $http.get('http://localhost:8080/autoinstrucional/estado/findall')
                .then(
                    function(response){
                        return response.data;
                    }, 
                    function(errResponse){
                        console.error('Erro ao recuperar estados');
                        return $q.reject(errResponse);
                    }
                );
        },

        /* Insere novo estado */ 
        criarEstado: function(estado){        	
        		return $http.post('http://localhost:8080/autoinstrucional/estado/new', estado)
                		.then(
                				function(response){
                					return response.data;
                				}, 
                				function(errResponse){
                					console.error('Erro ao criar estado');
                					return $q.reject(errResponse);
                				}
                		);
        },

        /* Atualiza um estado */ 
        updateEstado: function(estado){        	
                return $http.post('http://localhost:8080/autoinstrucional/estado/update', estado)
                        .then(
                                function(response){
                                    return response.data;
                                }, 
                                function(errResponse){
                                    console.error('Erro ao atualizar estado');
                                    return $q.reject(errResponse);
                                }
                        );
        },
         
         /* Exclui um estado */ 
        deleteEstado: function(id){
                return $http.get('http://localhost:8080/autoinstrucional/estado/delete/'+id)
                        .then(
                                function(response){
                                    return response.data;
                                }, 
                                function(errResponse){
                                    console.error('Erro ao deletar estado');
                                    return $q.reject(errResponse);
                                }
                        );
        },

        /* Exclui todos os estados */ 
        deletarTodos: function() {        	
        	return $http.get('http://localhost:8080/autoinstrucional/estado/deleteall')
        			.then(
        					function(response){
                                return response.data;
                            }, 
                            function(errResponse){
                                console.error('Erro ao deletar todas as estados');
                                return $q.reject(errResponse);
                            }
        			
        			);
        }
    };
}]);