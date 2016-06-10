'use strict';
 
App.controller('EstadoController', ['$scope', 'EstadoService', function($scope, EstadoService) {
          var self = this;
          self.estado={id:'',nome:'',sigla:''};
          self.estados=[];
               
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
          
          self.criarEstado = function(estado){
        	  estado.id = 1;
              EstadoService.criarEstado(estado)
                      .then(
                      self.findAll, 
                              function(errResponse){
                                   console.error('Erro ao criar estado.');
                              } 
                  );
          };
          
          self.updateEstado = function(estado, id){
              EstadoService.updateEstado(estado, id)
                      .then(
                              self.findAll, 
                              function(errResponse){
                                   console.error('Erro ao atualizar estado.');
                              } 
                  );
          };
          
          self.deleteEstado = function(id){
              EstadoService.deleteEstado(id)
                      .then(
                              self.findAll, 
                              function(errResponse){
                                   console.error('Erro ao deletar estado.');
                              } 
                  );
          };
          

		 self.deletarTodos = function() {
				EstadoService.deletarTodos().then(self.findAll,
						function(errResponse) {
							console.error('Erro ao deletar todas as estados.');
						});
			};
          
          self.submit = function() {
              if(self.estado.id === null  || self.estado.id === undefined || self.estado.id === ''){
                  console.log('Salvando novo usuário', self.estado);    
                  self.criarEstado(self.estado);
              }else{
                  self.updateEstado(self.estado, self.estado.id);
                  console.log('estado atualizada com o id ', self.estado.id);
              }
              self.reset();
              self.findAll();

          };
          
          self.edit = function(id){
              console.log('id para ser editado', id);
              for(var i = 0; i < self.estados.length; i++){
                  if(self.estados[i].id === id) {
                     self.estado = angular.copy(self.estados[i]);
                     break;
                  }
              }
          };
          
          self.remove = function(id){
              console.log('id para ser deletado', id);
              if(self.estado.id === id) {
                 self.reset();
              }
              self.deleteEstado(id);
          };
          
          self.reset = function(){
              self.estado={id:'',nome:'',sigla:''};
              $scope.meuForm.$setPristine();
          };
            
          self.findAll();
 
      }]);