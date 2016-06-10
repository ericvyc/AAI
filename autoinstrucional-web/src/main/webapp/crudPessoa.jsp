<div ng-controller="PessoaController as ctrl">

	<div class="row">
      <div class="col s12 m12" style="margin-top: 30px;">
        
        <div class="card">
        	<div class="card-content white-text">
        		<span class="card-title" style="color: #000;">Cadastro de Pessoa</span>
          		
          		<form method="post" ng-submit="ctrl.submit()" name="meuForm" class="form-horizontal">				
					<input type="hidden" ng-model="ctrl.pessoa.id" />						
					<div class="row">
						<div class="form-group  col s12">
							<label for="nomePessoa">Nome:</label> 
							<input type="text" class="form-control" id="nome" ng-model="ctrl.pessoa.nome" ng-required="required" style="color: #000;">
						</div>

						<div class="form-group  col s4">
							<label for="dataNascimento">Data Nascimento:</label>
							<input type="text" class="form-control" id="dataNascimento" ng-model="ctrl.pessoa.dataNascimento" ng-required="required" style="color: #000;">
						</div>

						<div class="form-group  col s4">									
							<label>Sexo</label>
							  <select id="sexo" class="browser-default" ng-model="ctrl.pessoa.sexo" ng-required="required" style="color: #000;">
							    <option value="" disabled selected style="color: #000;">Selecione...</option>
							    <option value="F" style="color: #000;">Feminino</option>
								<option value="M" style="color: #000;">Masculino</option>
							  </select>
						</div>
						
						<div class="form-group col s4">
							<label for="cpf">CPF:</label> 
							<input type="text" class="form-control" id="cpf" ng-model="ctrl.pessoa.cpf" ng-required="required" data-ng-mask="###.###.###-##" data-on="keyup" style="color: #000;">
						</div>	
					</div>
					<div class="row">		
						<div class="form-group col s4">
							<label for="bairro">Bairro</label> 
							<input type="text" class="form-control" id="bairro" ng-model="ctrl.endereco.bairro" style="color: #000;">
						</div>
						
						<div class="form-group col s4">
							<label for="localidade">Cidade</label> 
							<input type="text" class="form-control" id="localidade" ng-model="ctrl.endereco.localidade" style="color: #000;">
						</div>
						
						<div class="form-group col s4">
							<label for="uf">Estado</label> 
							<input type="text" class="form-control" id="uf" ng-model="ctrl.endereco.uf" style="color: #000;">
						</div>
					
					</div>

					<div id="actions" class="row">
						<div class="col-md-12">
							<input type="submit"  value="{{!ctrl.pessoa.id ? 'Adicionar' : 'Atualizar'}}" class="waves-effect waves-light btn" ng-disabled="meuForm.$invalid">
			                <button type="button" ng-click="ctrl.reset()" class="waves-effect waves-light btn yellow darken-3" ng-disabled="myForm.$pristine">Limpar Formulário</button>
			                <button type="button" ng-click="ctrl.deletarTodos()" class="waves-effect waves-light btn red darken-2">Deletar todas as Pessoas</button>
						</div>
					</div>
				</form>
			</div>
        </div>
        
      </div>
    </div>			
				
	<div class="tablecontainer">
		<table class="striped">
	        <thead>
	          <tr>
				<th>Código</th>
				<th>Nome</th>
				<th>Data Nasc.</th>
				<th>Sexo</th>
				<th>CPF</th>
				<th width="20%"></th>
	          </tr>
	        </thead>
	        <tbody>
	          <tr ng-repeat="p in ctrl.pessoas">
					<td><span ng-bind="p.id"></span></td>
					<td><span ng-bind="p.nome"></span></td>
                    <td><span ng-bind="p.dataNascimento"></span></td>
                    <td><span ng-bind="p.sexo"></span></td>
                    <td><span ng-bind="p.cpf"></span></td>
                    <td>
                      <button type="button" ng-click="ctrl.edit(p.id)" class="waves-effect waves-light btn blue darken-3">
                  			<i class="material-icons">mode_edit</i>
                      </button>  
                      <button type="button" ng-click="ctrl.remove(p.id)" class="waves-effect waves-light btn red darken-2">
                     		x
                      </button>
                    </td>
				</tr>
	        </tbody>
	      </table>
	</div>	

</div>