<?php
defined('BASEPATH') OR exit('No direct script access allowed');
?>

<!DOCTYPE html>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<h1>Interfaz Administrador</h1>
	<ul>
		<li><a href="<?php echo base_url();?>admin/institutos">Ver Institutos</a></li>
		<li><a href="<?php echo base_url();?>admin/comites">Ver Comites</a></li>
		<li><a href="<?php echo base_url();?>admin/autores">Ver Autores</a></li>
		<li><a href="<?php echo base_url();?>admin/indices">Ver Indices</a></li>
		<li><a href="<?php echo base_url();?>admin/paginas">Ver Paginas</a></li>
		<li><a href="<?php echo base_url();?>admin/revistas">Ver Revistas</a></li>
		<li>
			<a href="<?php echo base_url();?>admin/revista-autor">
				Revista-Autor
			</a>
		</li>
		<li>
			<a href="<?php echo base_url();?>admin/revista-arbitro">
				Revista-Arbitro
			</a>
		</li>
	</ul>
</body>
</html>
