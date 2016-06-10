<div ng-controller="EstadoController as ctrl">

	<div class="row">
      <div class="col s12 m12" style="margin-top: 30px;">
        
        <div class="card">
        	<div class="card-content white-text">
        		<span class="card-title" style="color: #000;">Cadastro de Estado</span>
          		
          		<form method="post" ng-submit="ctrl.submit()" name="meuForm" class="form-horizontal">				
					<input type="hidden" ng-model="ctrl.estado.id" />						
					<div class="row">
					
						<div class="form-group  col s10">
							<label for="nome">Nome:</label> 
							<input type="text" class="form-control" id="nome" ng-model="ctrl.estado.nome" ng-required="required" style="color: #000;">
						</div>
						
						<div class="form-group  col s2">
							<label for="sigla">Sigla:</label> 
							<input type="text" class="form-control" id="sigla" ng-model="ctrl.estado.sigla" ng-required="required" style="color: #000;">
						</div>
					
					</div>

					<div id="actions" class="row">
						<div class="col-md-12">
							<input type="submit"  value="{{!ctrl.estado.id ? 'Adicionar' : 'Atualizar'}}" class="waves-effect waves-light btn" ng-disabled="meuForm.$invalid">
			                <button type="button" ng-click="ctrl.reset()" class="waves-effect waves-light btn yellow darken-3" ng-disabled="myForm.$pristine">Limpar Formulário</button>
			                <button type="button" ng-click="ctrl.deletarTodos()" class="waves-effect waves-light btn red darken-2">Deletar todos os Estados</button>
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
				<th>Sigla</th>
				<th width="20%"></th>
	          </tr>
	        </thead>
	        <tbody>
	          <tr ng-repeat="e in ctrl.estados">
					<td><span style="color : #000;">{{ e.id }}</span></td>
					<td><span style="color : #000;">{{ e.nome }}</span></td>
                    <td><span style="color : #000;">{{ e.sigla }}</span></td>
                    <td>
                      <button type="button" ng-click="ctrl.edit(e.id)" class="waves-effect waves-light btn blue darken-3">
                  			<i class="material-icons">mode_edit</i>
                      </button>  
                      <button type="button" ng-click="ctrl.remove(e.id)" class="waves-effect waves-light btn red darken-2">
                     		x
                      </button>
                    </td>
				</tr>
	        </tbody>
	      </table>
	</div>	

</div>