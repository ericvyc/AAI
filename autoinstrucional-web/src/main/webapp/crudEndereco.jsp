<div ng-controller="EnderecoController as ctrl">
	<div class="row">
      <div class="col s12 m12" style="margin-top: 30px;">
        
        <div class="card">
        	<div class="card-content white-text">
        		<span class="card-title" style="color: #000;">Cadastro de Endereço</span>
          		
          		<form method="post" ng-submit="ctrl.submit()" name="meuForm" class="form-horizontal">			
					
					<div class="row">
					
					<div class="form-group col s6">
						<label for="logradouro">Logradouro</label> 
						<input type="text"	class="form-control" id="logradouro" ng-model="ctrl.endereco.logradouro" style="color: #000;">
					</div>

					<div class="form-group col s6">
						<label for="complemento">Complemento</label> 
						<input type="text"	class="form-control" id="complemento" ng-model="ctrl.endereco.complemento" style="color: #000;">
					</div>					
						
					</div>
					
					<div class="row">
						
						<div class="form-group  col s2">
							<label for="cidade">Cidade:</label> 
							<select id="cidade" class="browser-default" ng-model="ctrl.cidade" style="color: #000;">
							    <option value="" disabled selected style="color: #000;">Selecione...</option>
							    <option ng-repeat="e in ctrl.cidades" value="{{e}}">{{e.nome}}</option>
							  </select>
						</div>
						
						<div class="form-group  col s2">
							<label for="sigla">Estado:</label> 
							<select id="estado" class="browser-default" ng-model="ctrl.estado" style="color: #000;">
							    <option value="" disabled selected style="color: #000;">Selecione...</option>
							    <option ng-repeat="e in ctrl.estados" value="{{e}}">{{e.nome}}</option>
							  </select>
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
    
        <!-- Grid de Endereco -->
	<div class="tablecontainer">
		<table class="striped">
	        <thead>
	          <tr>
				<th>Id</th>
				<th>Logradouro</th>
				<th>Complemento</th>
				<th>Cidade</th>
				<th>Estado</th>
				<th width="20%"></th>
	          </tr>
	        </thead>
	        <tbody>
	          <tr ng-repeat="e in ctrl.enderecos">
					<td><span style="color : #000;">{{ e.id }}</span></td>
					<td><span style="color : #000;">{{ e.logradouro }}</span></td>
                    <td><span style="color : #000;">{{ e.complemento }}</span></td>
                    <td><span style="color : #000;">{{ e.cidade.nome }}</span></td>
                    <td><span style="color : #000;">{{ e.estado.sigla }}</span></td>
                    <td>
                      <button type="button" ng-click="ctrl.edit(e.id)" class="waves-effect waves-light btn blue darken-3">
                  			<i class="material-icons">mode_edit</i>
                      </button>  
                      <button type="button" ng-click="ctrl.remove(e.id)" class="waves-effect waves-light btn red darken-2">
                     		<b>x</b>
                      </button>
                    </td>
				</tr>
	        </tbody>
	      </table>
	</div>
    
</div>