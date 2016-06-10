'use strict';
 
App.controller('CidadeController', ['$scope', 'CidadeService','EstadoService', function($scope, cidadeService, estadoService) {
    var self = this;
    self.cidade={id:null,nome:'',estado:''};
    self.cidades=[];
    self.estado = {id:null,nome:'',sigla:''};
    self.estados = [];
    
    self.findAllEstados = function(){
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
    
    self.criarcidade = function(cidade){
  	  cidade.id=null;
        cidadeService.criarcidade(cidade)
                .then(
                self.findAll, 
                        function(errResponse){
                             console.error('Erro ao criar cidade.');
                        } 
            );
    };
    
    self.updatecidade = function(cidade){
        cidadeService.updatecidade(cidade)
                .then(
                        self.findAll, 
                        function(errResponse){
                             console.error('Erro ao atualizar cidade.');
                        } 
            );
    };
    
    self.deletecidade = function(id){
        cidadeService.deletecidade(id)
                .then(
                        self.findAll, 
                        function(errResponse){
                             console.error('Erro ao deletar cidade.');
                        } 
            );
    };
    
	  self.deletarTodos = function() {
			cidadeService.deletarTodos().then(self.findAll,
					function(errResponse) {
						console.error('Erro ao deletar todas as cidades.');
					});
		};
    
    self.submit = function() {
        if(self.cidade.id === null  || self.cidade.id === undefined || self.cidade.id === ''){
            console.log('Salvando novo cidade', self.cidade);    
            self.criarcidade(self.cidade);
        }else{
            self.updatecidade(self.cidade);
            console.log('cidade atualizada com o id ', self.cidade.id);
        }
        self.reset();
        self.findAll();

    };
    
    self.edit = function(id){
        console.log('id para ser editado', id);
        for(var i = 0; i < self.cidades.length; i++){
            if(self.cidades[i].id === id) {
               self.cidade = angular.copy(self.cidades[i]);
               break;
            }
        }
    };
    
    self.remove = function(id){
        console.log('id para ser deletado', id);
        if(self.cidade.id === id) {
           self.reset();
        }
        self.deletecidade(id);
    };
    
    self.reset = function(){
        self.cidade={id:'',nome:'',sigla:''};
        $scope.meuForm.$setPristine();
    };
      
    self.findAll();
    
    self.findAllEstados();

}]);