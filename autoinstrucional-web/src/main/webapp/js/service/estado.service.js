'use strict';
 
App.factory('EstadoService', ['$http', '$q', function($http, $q){
 
    return {
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
    
    updateEstado: function(estado, id){
    	
            return $http.put('http://localhost:8080/desafio/estado/'+id, estado)
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
     
    deleteEstado: function(id){
            return $http.delete('http://localhost:8080/autoinstrucional/estado/'+id)
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
    deletarTodos: function() {
    	
    	return $http.delete('http://localhost:8080/autoinstrucional/estado/')
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