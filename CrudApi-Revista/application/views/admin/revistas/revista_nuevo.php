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
    <title>Nueva Revista!</title>
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
      <h2>Nueva Revista</h2>

      <div class="alert alert-success" v-if='status == "success"'>
        <strong>Agregado correctamente</strong>
      </div>

      <div class="alert alert-danger" v-if='status == "error"'>
        <strong>ERROR: </strong>{{error}}
      </div>

      <form onsubmit="agregarRevista(event)" enctype="multipart/form-data">

          <div class="form-group">
              <strong><label for="nombreArticulo">Nombre</label></strong>
              <input type="text" class="form-control" id="nombre" name="nombre" placeholder='Escribe un titulo para la revista' maxlength="45" required>
          </div>

          <div class="form-row">

              <div class="form-group col-md-6">
                  <strong><label for="fechaRecpcion">Fecha de Recepcion</label></strong>
                  <input type="date" id="fechaRecpcion" name="fechaRecpcion" required>
              </div>

              <div class="form-group col-md-6">
                  <strong><label for="fechaPublicacion">Fecha de Publicacion</label></strong>
                  <input type="date" id="fechaPublicacion" name="fechaPublicacion" required>
              </div>

          </div>

          <div class="form-row">

              <div class="form-group col-md-6">
                  <strong><label for="imagen">Portada</label></strong>
                  <input type="file" class="form-control-file" id="imagen" name="imagen" accept="image/*" required>
              </div>

              <div class="form-group col-md-6">
                  <strong><label for="pdf">Archivo PDF</label></strong>
                  <input type="file" class="form-control-file" id="pdf" name="pdf" accept="application/pdf" required>
              </div>

          </div>

          <div class="form-group">
              <strong><label for="comite para revista">Comite para la revista</label></strong>
              <select class="form-control" id="Comite_idComite" name="comite" required>
                  <option v-for="comite in comites" v-bind:value="comite.idComite"> {{ comite.nombre }} </option>
              </select>
          </div>

          <div class="form-group">
              <strong><label for="indice para revista">Indice para la revista</label></strong>
              <select class="form-control" id="Indice_idIndice" name="indice" required>
                  <option v-for="indice in indices" v-bind:value="indice.idIndice"> {{ indice.nombre }} </option>
              </select>
          </div>

          <a class="btn btn-danger" href="<?php echo base_url();?>admin/revistas">Cancelar</a>
          <input type="submit" class="btn btn-success" value="Agregar Revista">
      </form>

    </div>
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
    <?php
      require_once('recursos/js/admin/revistas/revista_nuevo.php');
    ?>
  </body>
</html>
