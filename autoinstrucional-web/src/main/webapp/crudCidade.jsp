<div ng-controller="CidadeController as ctrl">

	<div class="row">
      <div class="col s12 m12" style="margin-top: 30px;">
        <div class="card">
        	<div class="card-content white-text">
        		<span class="card-title" style="color: #000;">Cadastro de cidade</span>
          		
          		<form method="post" ng-submit="ctrl.submit()" name="meuForm" class="form-horizontal">				
					<input type="hidden" ng-model="ctrl.cidade.id" />						
					<div class="row">
					
						<div class="form-group  col s8">
							<label for="nome">Nome:</label> 
							<input type="text" class="form-control" id="nome" ng-model="ctrl.cidade.nome" ng-required="required" style="color: #000;">
						</div>
						
						<div class="form-group  col s4">
							<label for="sigla">Estado:</label> 
							<select id="estado" class="browser-default" ng-model="ctrl.estado.id" style="color: #000;">
							    <option value="" disabled selected style="color: #000;">Selecione...</option>
							    <option ng-repeat="e in ctrl.estados" value="e.id">{{e.nome}}</option>
							  </select>
						</div>
					
					</div>

					<div id="actions" class="row">
						<div class="col-md-12">
							<input type="submit"  value="{{!ctrl.cidade.id ? 'Adicionar' : 'Atualizar'}}" class="waves-effect waves-light btn" ng-disabled="meuForm.$invalid">
			                <button type="button" ng-click="ctrl.reset()" class="waves-effect waves-light btn yellow darken-3" ng-disabled="myForm.$pristine">Limpar Formulário</button>
			                <button type="button" ng-click="ctrl.deletarTodos()" class="waves-effect waves-light btn red darken-2">Deletar todos os cidades</button>
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
				<th>Id</th>
				<th>Nome</th>
				<th>Nome do Estado</th>
				<th width="20%"></th>
	          </tr>
	        </thead>
	        <tbody>
	          <tr ng-repeat="c in ctrl.cidades">
					<td><span style="color : #000;">{{ c.id }}</span></td>
					<td><span style="color : #000;">{{ c.nome }}</span></td>
                    <td><span style="color : #000;">{{ c.estado.sigla }}</span></td>
                    <td>
                      <button type="button" ng-click="ctrl.edit(c.id)" class="waves-effect waves-light btn blue darken-3">
                  			<i class="material-icons">mode_edit</i>
                      </button>  
                      <button type="button" ng-click="ctrl.remove(c.id)" class="waves-effect waves-light btn red darken-2">
                     		x
                      </button>
                    </td>
				</tr>
	        </tbody>
	      </table>
	</div>	

</div>
