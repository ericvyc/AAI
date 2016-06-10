'use strict';
 
/* Controller da entidade pessoa */ 
App.controller('PessoaController', ['$scope', 'PessoaService', function($scope, PessoaService) {
	  var self = this;
	  self.pessoa={id:'',nome:'',idade:''};
	  self.pessoas=[];
	    

    /* Função que busca todas as pessoas cadastradas */   
	  self.findAll = function(){
		  PessoaService.findAll()
		      .then(
		         function(d) {		      	   
		              self.pessoas = d;
		         },
		          function(errResponse){
		              console.error('Erro ao buscar pessoas');
		          }
		      );
	  };

    /* Função que busca uma pessoa pelo id */   
    self.findOne = function(id){
      PessoaService.findOne(id)
          .then(
             function(d) {               
                  self.pessoa = d;
             },
              function(errResponse){
                  console.error('Erro ao buscar pessoa com id', id);
              }
          );
    };

    /* Função de envio do formulário de cadastro */   
    self.submit = function() {
        if(self.pessoa.id === null  || self.pessoa.id === undefined || self.pessoa.id === ''){
            console.log('Salvando nova pessoa', self.pessoa);    
            self.createPessoa(self.pessoa);
        }else{
            self.updatePessoa(self.pessoa);
            console.log('Pessoa atualizada com o id ', self.pessoa.id);
        }
        self.reset();
        self.findAll();

    };

    /* Função que insere um novo registro de pessoa */   
    self.createPessoa = function(pessoa){
      pessoa.id=null;
        PessoaService.createPessoa(pessoa)
            .then(
                self.findAll, 
                    function(errResponse){
                         console.error('Erro ao criar pessoa.');
                    } 
            );
    };
        
    /* Função que carrega os dados de uma pessoa pelo id */
    self.edit = function(id){
        console.log('id para ser atualizado', id);
        self.findOne(id);
    };
    
    /* Função que atualiza os dados de uma pessoa */
    self.updatePessoa = function(pessoa){
        PessoaService.updatePessoa(pessoa)
          .then(
              self.findAll, 
              function(errResponse){
                   console.error('Erro ao atualizar pessoa.');
              } 
          );
    };
    

    /* Função que chama a função de remover uma pessoa pelo id*/   
    self.remove = function(id){
        console.log('id para ser deletado', id);
        self.deletePessoa(id);
    };


    /* Função de remover uma pessoa pelo id */   
    self.deletePessoa = function(id){
        PessoaService.deletePessoa(id)
            .then(
                self.findAll, 
                function(errResponse){
                     console.error('Erro ao deletar pessoa.');
                } 
            );
    };
    
    /* Função de remover todos os registros de pessoa */
    self.deleteAll = function() {
      PessoaService.deleteAll().then(self.findAll,
          function(errResponse) {
            console.error('Erro ao deletar todas as pessoas.');
          });
    };


    /* Função para limpar os dados do formulário */
    self.reset = function(){
        self.pessoa={id:'',nome:'',idade:''};
        $scope.meuForm.$setPristine();
    };
	  	
    /* Busca todos registros de pessoa */ 
	  self.findAll();

}]);