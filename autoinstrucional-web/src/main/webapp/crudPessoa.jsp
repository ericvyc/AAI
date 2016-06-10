<div ng-controller="PessoaController as ctrl">
	
	<div class="row">
      <div class="col s12 m12" style="margin-top: 30px;">        
        <div class="card">
        	<div class="card-content white-text">
        		<span class="card-title" style="color: #000;">Cadastro de Pessoa</span> 

        		<!-- Formulário de Cadastro de Pessoas -->         		
          		<form method="post" ng-submit="ctrl.submit()" name="meuForm" class="form-horizontal">				
					<input type="hidden" ng-model="ctrl.pessoa.id" />						
					<div class="row">
						<div class="form-group  col s10">
							<label for="nomePessoa">Nome:</label> 
							<input type="text" class="form-control" id="nome" ng-model="ctrl.pessoa.nome" ng-required="required" style="color: #000;">
						</div>

						<div class="form-group  col s2">
							<label for="dataNascimento">Idade:</label>
							<input type="text" class="form-control" id="idade" ng-model="ctrl.pessoa.idade" ng-required="required" style="color: #000;">
						</div>
					</div>
					<div id="actions" class="row">
						<div class="col s12">
							<input type="submit"  value="{{!ctrl.pessoa.id ? 'Adicionar' : 'Atualizar'}}" class="waves-effect waves-light btn" ng-disabled="meuForm.$invalid">
			                <button type="button" ng-click="ctrl.reset()" class="waves-effect waves-light btn yellow darken-3" ng-disabled="myForm.$pristine">Limpar Formulário</button>
			                <button type="button" ng-click="ctrl.deleteAll()" class="waves-effect waves-light btn red darken-2">Deletar Todos Registros</button>
						</div>
					</div>
				</form>
			</div>
        </div>        
      </div>
    </div>	
			
	<!-- Grid de Pessoas -->
	<div class="tablecontainer">
		<table class="striped">
	        <thead>
	          <tr>
				<th>Código</th>
				<th>Nome</th>
				<th>Idade</th>
				<th width="20%"></th>
	          </tr>
	        </thead>
	        <tbody>
	          <tr ng-repeat="p in ctrl.pessoas">
					<td><span ng-bind="p.id"></span></td>
					<td><span ng-bind="p.nome"></span></td>
                    <td><span ng-bind="p.idade"></span></td>
                    <td>
                      <button type="button" ng-click="ctrl.edit(p.id)" class="waves-effect waves-light btn blue darken-3">
                  			<i class="material-icons">mode_edit</i>
                      </button>  
                      <button type="button" ng-click="ctrl.remove(p.id)" class="waves-effect waves-light btn red darken-2">
                     		<b>x</b>
                      </button>
                    </td>
				</tr>
	        </tbody>
	    </table>
	</div>	

</div>