<?php
defined('BASEPATH') OR exit('No direct script access allowed');
?>

<!Doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
    <!-- Vue -->
    <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>

    <title>Nuevo Comite</title>
  </head>

  <style>
    #contenedor_de_la_forma{
      margin: 20px auto;
    }

    #contenedor_de_la_forma h2{
      text-align: center;
      margin: 20px auto;
    }
  </style>

  <body>
    <div class="container vue" id="contenedor_de_la_forma">

      <h2>Nuevo Comite</h2>

      <div class="alert alert-success" v-if='status == "success"'>
        <strong>Agregado correctamente</strong>
      </div>

      <div class="alert alert-danger" v-if='status == "error"'>
        <strong>ERROR: </strong>No se pudo agregar, Intenta de nuevo
      </div>

      <form id="comiteForm" onsubmit="agregarComite(event)">

            <div class="form-group">
                <strong><label for="nombre">Nombre</label></strong>
                <input type="text" class="form-control" id="text-nombreComite" name="nombre" placeholder='Escribe un nombre para el comite' maxlength="45" required>
            </div>

            <div class="form-group">
                <strong><label for="año inicio">Año Inicio</label></strong>
                <input type="text" class="form-control" id="text-añoInicio" name="anioInicio" placeholder='Escribe un año de inicio para el comite' maxlength="45" required>
            </div>

            <div class="form-group">
                <strong><label for="año termino">Año Termino</label></strong>
                <input type="text" class="form-control" id="text-añotermino" name="anioTermino" placeholder='Escribe un año de Termino para el comite' maxlength="45" required>
            </div>

            <a class="btn btn-danger"
                href="<?php echo base_url();?>admin/comites">
                Cancelar
            </a>

            <input type="submit"
                  class="btn btn-success"
                  value="Agregar Comite">

      </form>
    </div>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
    <?php
      require_once('recursos/js/admin/comites/comite_nuevo.php');
    ?>
  </body>
</html>
