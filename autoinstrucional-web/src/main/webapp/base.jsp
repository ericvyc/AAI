<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
	<head>
		<meta charset="utf-8">
		<title>AAI DAW</title>
		<style>
		.nome.ng-valid {
			background-color: lightgreen;
		}

		.nome.ng-dirty.ng-invalid-required {
			background-color: red;
		}

		.nome.ng-dirty.ng-invalid-minlength {
			background-color: yellow;
		}

		.email.ng-valid {
			background-color: lightgreen;
		}

		.email.ng-dirty.ng-invalid-required {
			background-color: red;
		}

		.email.ng-dirty.ng-invalid-email {
			background-color: yellow;
		}
		</style>

  		<link rel="stylesheet" href="materialize/css/materialize.min.css">
  		<script src="materialize/js/materialize.min.js"></script>
  		<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
          
		<script src="js/angular.js"></script>
		<script src="js/angular.ui.router.js"></script>
		<script src="js/app.js"></script>
		<script src="js/ng-mask-1.0.1.js"></script>
		<script src="js/service/estado.service.js"></script>
		<script src="js/controller/estado.controller.js"></script>
		<script src="js/service/endereco.service.js"></script>
		<script src="js/controller/endereco.controller.js"></script>
		<script src="js/service/pessoa.service.js"></script>
		<script src="js/controller/pessoa.controller.js"></script>
		<script src="js/service/cidade.service.js"></script>
		<script src="js/controller/cidade.controller.js"></script>
	</head>
	<body ng-app="meuApp" class="ng-cloak">	

		<div class="navbar-fixed">
		    <nav>
		      <div class="nav-wrapper container	">
		        <a href="#!" class="brand-logo">AAI DAW</a>
		        <ul class="right hide-on-med-and-down">
		          	<li><a ui-sref="pessoa">Pessoa </a></li>
		        	<li><a ui-sref="endereco">Endereço</a></li>
		        	<li><a ui-sref="estado">Estado</a></li>
		        	<li><a ui-sref="cidade">Cidade</a></li>
		        </ul>
		      </div>
		    </nav>
		  </div>

		<div class="container">

			<div ui-view></div>

		</div>

		<footer class="page-footer">
          <div class="container">
            <div class="row">
              <div class="col l6 s12">
                <h5 class="white-text">Atividade AutoInstrucional DAW</h5>
                <p class="grey-text text-lighten-4">Trabalho apresentado como requisito de avaliação para a disciplina de Desenvolvimento WEB na Universidade FUMEC.</p>
              </div>
              <div class="col l4 offset-l2 s12">
                <h5 class="white-text">Grupo</h5>
                <ul>
                  <li><span class="grey-text text-lighten-3" href="#!">Eric Vilar Yankous Castanheira</span></li>
                  <li><span class="grey-text text-lighten-3" href="#!">Gabriel Barbosa Rocha</span></li>
                  <li><span class="grey-text text-lighten-3" href="#!">Matheus Neiva Amaro</span></li>
                </ul>
              </div>
            </div>
          </div>
          <div class="footer-copyright">
            <div class="container">
            © 2016
            </div>
          </div>
        </footer>
	</body>
</html>