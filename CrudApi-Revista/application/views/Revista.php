<?php
defined('BASEPATH') OR exit('No direct script access allowed');
?>

<!DOCTYPE html>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.7.0/animate.min.css">
	<link rel="stylesheet" type="text/css" href="<?php echo base_url();?>recursos/css/menu.css">
	<link rel="stylesheet" type="text/css" href="<?php echo base_url();?>recursos/css/estilos.css">
	<!-- Vue -->
	<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
	<title>Revista</title>
</head>
<body>
<!-- Menu -->
	<nav class="navbar navbar-expand-lg navbar-dark" id="sticky" style="background-color: #008100;">
	  	<a class="navbar-brand" href="#">Estacion Ciencia</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	  	</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav">
				<li class="nav-item">
		        	<a class="nav-link" href="#"><span class="sr-only">(current)</span></a>
		      	</li>
		      	<li class="nav-item ">
		        	<a class="nav-link" href="#">Inicia secion</a>
		      	</li>
		      	<li class="nav-item ">
		        	<a class="nav-link" href="#">Registrate</a>
		      	</li>
		      	<li class="nav-item ">
		      		<a class="nav-link" href="#">Talleres</a>
		      	</li>
		      	<li class="nav-item ">
			        <a class="nav-link disabled" href="#">Eventos</a>
		    	</li>
		    	<li class="nav-item active">
			        <a class="nav-link" href="#">Revista</a>
		    	</li>
		    	<li class="nav-item ">
			        <a class="nav-link disabled" href="#">Juegos</a>
		    	</li>
		    	<li class="nav-item ">
			        <a class="nav-link disabled" href="#">Mini notas</a>
		    	</li>
		    	<li class="nav-item ">
			        <a class="nav-link disabled" href="#">Buzon</a>
		    	</li>
			</ul>
		</div>
	</nav>
<!-- Numero Actual -->
	<!-- Carrusel -->
	<div id="carouselNumActual" class="carousel slide carousel-fade animated fadeIn mt-3" data-ride="carousel">
			<div class="carousel-inner">
				<div class="carousel-item carouselNumActualContenedordeImg active">
					<img class="d-block w-100 imagenCarouselNumActual" src="<?php echo base_url();?>recursos/img/numeroActual/numactual-s1.jpg" alt="Error al cargar imagen">
				</div>
				<div class="carousel-item carouselNumActualContenedordeImg">
				    <img class="d-block w-100 imagenCarouselNumActual" src="<?php echo base_url();?>recursos/img/numeroActual/numactual-s2.jpg" alt="Error al cargar imagen">
				</div>
				<div class="carousel-item carouselNumActualContenedordeImg">
				    <img class="d-block w-100 imagenCarouselNumActual" src="<?php echo base_url();?>recursos/img/numeroActual/numactual-s3.jpg" alt="Error al cargar imagen">
				</div>
			</div>
	</div>
	

	<div class="vue-slider">
		<!-- Num Actual -->
		<div class="container mt-5" id="num-actual">
				<h3>NUMERO ACTUAL</h3>
				<div class="row">
					<div class="col-md-3 animated fadeIn img-descripcion">
						<a  v-bind:href="revistaActual.pdf"
							target="_blank">
							<img v-bind:src="revistaActual.imagen">
						</a>	
						<a class="btn btn-outline-primary btn-block"
							   v-bind:href="revistaActual.pdf"
							   target="_blank">Ver PDF</a>
					
					</div>
					<div class="col-md-9 animated fadeIn num-actual-info">
						<div class="col-md-12">
							<h3 class="num-actual-titulo">
								{{revistaActual.nombreArticulo}}
							</h3>
							<div class="info">
								<p id="fecha-recepcion"> 
									<span class="info-etiqueta">
										Fecha de Recepcion:
									</span>
									<span class="info-respuesta">
										{{ revistaActual.fechaRecpcion }}
									</span>
								</p>
								<p id="fecha-publicacion"> 
									<span class="info-etiqueta">
										Fecha de Publicacion:
									</span>
									<span class="info-respuesta">
										{{ revistaActual.fechaPublicacion }}
									</span>
								</p>
								<p id="autor"> 
									<span class="info-etiqueta">
										Autor(es):
									</span>
									<span class="info-respuesta"
										  v-for="autor in autoresActual">
										{{ autor.nombreAuthor }}
										{{ autor.apat }}
										{{ autor.amat }}
										&nbsp;
									</span>
								</p>
							</div>
							
						</div>
						<div class="col-md-10 mt-3 mb-3 indice">
							<div class="card-header">INDICE</div>
							<ul class="list-group list-group-flush">
								<li class="list-group-item" v-for="pagina in paginasActual">
									<a :href=`${revistaActual.pdf}#page=${pagina.numero}` 			target="_blank"
										class="pagina-indice">
										<p class="titulo-pagina">{{ pagina.titulo }}</p>
										<p class="numero-pagina">{{ pagina.numero }}</p>
									</a>
								</li>
							</ul>
						</div>
					</div>
				</div>
		</div>

		<!-- Numeros Anteriores -->
		<div class="container controles">
			<h3>NUMEROS ANTERIORES</h3>
			<div class="anteriores-slider" id="anteriores-slider">
				<img v-bind:src="revista.imagen"
					class="img-anteriores"
					v-for="revista in revistas"
					v-on:click="cambiarNumeroActual(revista)">
			</div>
			<div class="previo" id="previo">
				<i class="fas fa-arrow-circle-left"></i>
			</div>
			<div class="siguiente" id="siguiente">
				<i class="fas fa-arrow-circle-right"></i>
			</div>
		</div>
	</div>


<!-- Footer -->
	<footer class="page-footer font-small indigo pt-0 mt-5" style="background-color: #008100">
	    <div class="container">
	        <div class="row">
	            <div class="col-md-12 py-5">
	                <div class="mb-5 flex-center">
						<center>
		                    <a class="fb-ic" href="https://www.facebook.com/FeriaCienciaUAMI/">
		                        <i class="fa fa-facebook fa-lg white-text mr-md-5 mr-3 fa-2x"><img class="red" src="<?php echo base_url();?>recursos/img/redes/fb_ico.png"></i>
		                        <i class=""></i>
		                    </a>
		                    <a class="tw-ic" href="https://twitter.com/fcienciasuami?lang=es">
		                        <i class="fa fa-twitter fa-lg white-text mr-md-5 mr-3 fa-2x"><img class="red" src="<?php echo base_url();?>recursos/img/redes/tw_ico.png"> </i>
		                    </a>
		                    <a class="yt-ic" href="https://www.youtube.com/channel/UCS2gvRQvnWcghzISgDJ2gxA">
		                        <i class="fa fa-google-plus fa-lg white-text mr-md-5 mr-3 fa-2x"><img class="red" src="<?php echo base_url();?>recursos/img/redes/yt_ico.png">  </i>
		                    </a>
		                </center>
	                </div>
	            </div>
	        </div>
	    </div>
	    <div class="footer-copyright py-3 text-center">
	        © 2018 Copyright:
	    </div>
	</footer>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<script src="<?php echo base_url();?>recursos/js/menu-sticky.js"></script>
<?php
require_once('recursos/js/vistas/revista.php');
?>

</body>
</html>
