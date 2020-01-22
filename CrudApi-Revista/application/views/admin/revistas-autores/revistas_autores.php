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
    <!-- FontAwesome -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
    <title>Revistas-Autores</title>

    <!-- Vue -->
    <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
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

    <div class="container mt-5 vue">
      <div class="row">
        <div class="col-10" style="margin-left: auto; margin-right: auto;">
          <div class="float-right">

            <a class="btn btn-danger mb-3"
                href="<?php echo base_url();?>admin/Principal">
                Regresar
            </a>

            <a class="btn btn-success mb-3"
                href="<?php echo base_url();?>admin/revista-autor/nuevo">
                <i class="fas fa-plus-circle"></i>
                Nuevo
            </a>

          </div>
          <table class="table">
            <thead class="table-dark">
              <tr>
                <th>id-Autor</th>
                <th>id-Revista</th>
                <th>Articulo Escrito</th>
                <th>Operaciones</th>
              </tr>
            </thead>
            <tbody>
              <tr  v-for="ra in revs_auts">
                <td>{{ ra.author }}</td>
                <td>{{ ra.revista }}</td>
                <td>{{ ra.articuloEscrito }}</td>
                <th>

                  <a class="btn btn-outline-info"
                  v-bind:href=`<?php echo base_url(); ?>admin/revista-autor/actualizar/${ra.author}/${ra.revista}`>
                    <i class="fas fa-pencil-alt"></i>
                    Editar
                  </a>

                  <button class="btn btn-outline-danger" v-on:click="elimRevistaAutor( ra.author, ra.revista )">
                    <i class="fas fa-trash-alt"></i>
                    Borrar
                  </button>
                </th>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
    </div>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
    <?php
      require_once('recursos/js/admin/revistas-autores/revistas_autores.php');
    ?>
  </body>
</html>
