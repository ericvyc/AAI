'use strict';
 
App.factory('PessoaService', ['$http', '$q', function($http, $q){
 
    return {
        findAll: function() {
            return $http.get('http://localhost:8080/autoinstrucional/pessoa/findall')
                .then(
                    function(response){
                        return response.data;
                    }, 
                    function(errResponse){
                        console.error('Erro ao recuperar pessoas');
                        return $q.reject(errResponse);
                    }
                );
        }
    };
}]);