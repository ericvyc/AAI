'use strict';
 
 /* Controller da entidade estado */ 
App.controller('EstadoController', ['$scope', 'EstadoService', function($scope, EstadoService) {
    var self = this;
    self.estado={id:'',nome:'',sigla:''};
    self.estados=[];
         
    /* Função que busca todos os estados cadatrados */ 
    self.findAll = function(){
  	  EstadoService.findAll()
            .then(
                 function(d) {
              	   
                      self.estados = d;
                 },
                  function(errResponse){
                      console.error('Erro ao buscar estados');
                  }
             );
    };
    
    /* Função que cria um novo estado */ 
    self.criarEstado = function(estado){
  	  estado.id=null;
        EstadoService.criarEstado(estado)
                .then(
                self.findAll, 
                        function(errResponse){
                             console.error('Erro ao criar estado.');
                        } 
            );
    };
    
    /* Função que atualiza os dados de um estado */ 
    self.updateEstado = function(estado){
        EstadoService.updateEstado(estado)
                .then(
                        self.findAll, 
                        function(errResponse){
                             console.error('Erro ao atualizar estado.');
                        } 
            );
    };
    
    /* Função que exclui um estado */ 
    self.deleteEstado = function(id){
        EstadoService.deleteEstado(id)
                .then(
                        self.findAll, 
                        function(errResponse){
                             console.error('Erro ao deletar estado.');
                        } 
            );
    };
    
    /* Função que exclui todos os estados cadatrados */ 
	  self.deletarTodos = function() {
			EstadoService.deletarTodos().then(self.findAll,
					function(errResponse) {
						console.error('Erro ao deletar todas as estados.');
					});
		};
    
    /* Função de envio dos dados do formulário */ 
    self.submit = function() {
        if(self.estado.id === null  || self.estado.id === undefined || self.estado.id === ''){
            console.log('Salvando novo estado', self.estado);    
            self.criarEstado(self.estado);
        }else{
            self.updateEstado(self.estado);
            console.log('Estado atualizada com o id ', self.estado.id);
        }
        self.reset();
        self.findAll();

    };
    
    /* Função para edição de um estado */ 
    self.edit = function(id){
        console.log('id para ser editado', id);
        for(var i = 0; i < self.estados.length; i++){
            if(self.estados[i].id === id) {
               self.estado = angular.copy(self.estados[i]);
               break;
            }
        }
    };
    
    /* Função que chama a função de excluir um estado */ 
    self.remove = function(id){
        console.log('id para ser deletado', id);
        if(self.estado.id === id) {
           self.reset();
        }
        self.deleteEstado(id);
    };
    
    /* Função que limpa os dados do formulário */ 
    self.reset = function(){
        self.estado={id:'',nome:'',sigla:''};
        $scope.meuForm.$setPristine();
    };
      
    self.findAll();

}]);