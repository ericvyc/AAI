'use strict';
 
/* Serviços relacionado a entidade Pessoa */
App.factory('PessoaService', ['$http', '$q', function($http, $q){
 
    return {

        /* Função que retorna todos os registros de pessoas */
        findAll: function() {
            return $http.get('http://localhost:8080/autoinstrucional/pessoa/findAll')
                .then(
                    function(response){
                        return response.data;
                    }, 
                    function(errResponse){
                        console.error('Erro ao recuperar pessoas');
                        return $q.reject(errResponse);
                    }
                );
        },

        /* Função que retorna os dados de uma única pessoa */
        findOne: function(id) {
            return $http.get('http://localhost:8080/autoinstrucional/pessoa/findOne/'+id)
                .then(
                    function(response){
                        return response.data;
                    }, 
                    function(errResponse){
                        console.error('Erro ao recuperar pessoa');
                        return $q.reject(errResponse);
                    }
                );
        },

        /* Função que insere uma nova pessoa */
        createPessoa: function(pessoa){            
            return $http.post('http://localhost:8080/autoinstrucional/pessoa/create', pessoa)
                .then(
                    function(response){
                        return response.data;
                    }, 
                    function(errResponse){
                        console.error('Erro ao criar pessoa');
                        return $q.reject(errResponse);
                    }
                );
        },

        /* Função que atualiza os dados de uma pessoa */
        updatePessoa: function(pessoa){            
            return $http.post('http://localhost:8080/autoinstrucional/pessoa/update', pessoa)
                .then(
                    function(response){
                        return response.data;
                    }, 
                    function(errResponse){
                        console.error('Erro ao atualizar pessoa');
                        return $q.reject(errResponse);
                    }
                );
        },
         
        /* Função que exclui o registro de uma pessoa */
        deletePessoa: function(id){
            return $http.get('http://localhost:8080/autoinstrucional/pessoa/delete/'+id)
                .then(
                    function(response){
                        return response.data;
                    }, 
                    function(errResponse){
                        console.error('Erro ao deletar pessoa');
                        return $q.reject(errResponse);
                    }
                );
        },

        /* Função que exclui todos os registros de pessoas */
        deleteAll: function() {            
            return $http.get('http://localhost:8080/autoinstrucional/pessoa/deleteAll')
                .then(
                    function(response){
                        return response.data;
                    }, 
                    function(errResponse){
                        console.error('Erro ao deletar todas as pessoas');
                        return $q.reject(errResponse);
                    }
                
                );
        }
    };
}]);