'use strict';
 
App.factory('CidadeService', ['$http', '$q', function($http, $q){
 
    return {
        findAll: function() {
            return $http.get('http://localhost:8080/autoinstrucional/cidade/findall')
                .then(
                    function(response){
                        return response.data;
                    }, 
                    function(errResponse){
                        console.error('Erro ao recuperar cidades');
                        return $q.reject(errResponse);
                    }
                );
        },

        criarcidade: function(cidade){
        	
        		return $http.post('http://localhost:8080/autoinstrucional/cidade/new', cidade)
                		.then(
                				function(response){
                					return response.data;
                				}, 
                				function(errResponse){
                					console.error('Erro ao criar cidade');
                					return $q.reject(errResponse);
                				}
                		);
        },

        updatecidade: function(cidade){
        	
                return $http.post('http://localhost:8080/autoinstrucional/cidade/update', cidade)
                        .then(
                                function(response){
                                    return response.data;
                                }, 
                                function(errResponse){
                                    console.error('Erro ao atualizar cidade');
                                    return $q.reject(errResponse);
                                }
                        );
        },
         
        deletecidade: function(id){
                return $http.get('http://localhost:8080/autoinstrucional/cidade/delete/'+id)
                        .then(
                                function(response){
                                    return response.data;
                                }, 
                                function(errResponse){
                                    console.error('Erro ao deletar cidade');
                                    return $q.reject(errResponse);
                                }
                        );
        },
        deletarTodos: function() {
        	
        	return $http.get('http://localhost:8080/autoinstrucional/cidade/deleteall')
        			.then(
        					function(response){
                                return response.data;
                            }, 
                            function(errResponse){
                                console.error('Erro ao deletar todas as cidades');
                                return $q.reject(errResponse);
                            }
        			
        			);
        }
    };
}]);