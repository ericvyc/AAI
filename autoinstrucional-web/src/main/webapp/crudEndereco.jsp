<div ng-controller="EnderecoController as ctrl">
	<div class="row">
      <div class="col s12 m12" style="margin-top: 30px;">
        
        <div class="card">
        	<div class="card-content white-text">
        		<span class="card-title" style="color: #000;">Cadastro de Endereço</span>
          		
          		<form method="post" ng-submit="ctrl.submit()" name="meuForm" class="form-horizontal">			
					
					<div class="row">
						<div class="form-group col s2">
						<label for="cep">CEP</label> 
						<input type="text"	class="form-control" id="cep" ng-model="ctrl.endereco.cep" ng-blur="ctrl.getEndereco(ctrl.endereco.cep)" style="color: #000;">
					</div>	
					
					<div class="form-group col s4">
						<label for="logradouro">Endereço</label> 
						<input type="text"	class="form-control" id="logradouro" ng-model="ctrl.endereco.logradouro" style="color: #000;">
					</div>

					<div class="form-group col s2">
						<label for="numero">Número</label> 
						<input type="text" class="form-control" id="numero" ng-model="ctrl.endereco.numero" style="color: #000;">
					</div>
					
					<div class="form-group col s4">
						<label for="complemento">Complemento</label> 
						<input type="text"	class="form-control" id="complemento" ng-model="ctrl.endereco.complemento" style="color: #000;">
					</div>					
						
					</div>

					<div id="actions" class="row">
						<div class="col -s12">
							<input type="submit"  value="{{!ctrl.endereco.id ? 'Adicionar' : 'Atualizar'}}" class="waves-effect waves-light btn" ng-disabled="meuForm.$invalid">
			                <button type="button" ng-click="ctrl.reset()" class="waves-effect waves-light btn yellow darken-3" ng-disabled="myForm.$pristine">Limpar Formulário</button>
			                <button type="button" ng-click="ctrl.deletarTodos()" class="waves-effect waves-light btn red darken-2">Deletar Todos Registros</button>
						</div>
					</div>
				</form>
			</div>
        </div>
        
      </div>
    </div>		
</div>