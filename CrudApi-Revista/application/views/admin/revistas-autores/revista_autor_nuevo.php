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
    <!-- Vue -->
    <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
    <title>Nuevo Revista-Autor</title>
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
      <h2>Nuevo Revista-Autor</h2>

      <div class="alert alert-success" v-if='status == "success"'>
        <strong>Agregado correctamente</strong>
      </div>

      <div class="alert alert-danger" v-if='status == "error"'>
        <strong>ERROR: </strong>No se pudo agregar, Los datos ya existen
      </div>

      <form id="institutoForm" onsubmit="agregarRevistaAutor(event)">

        <div class="form-group">

            <strong><label>Autor</label></strong>

            <select class="form-control"
                    id="author"
                    name="author"
                    required>

                <option v-bind:value="autor.idAuthor" v-for="autor in autores">
                  {{ autor.nombreAuthor}} {{ autor.apat}} {{ autor.amat}}
                </option>

            </select>
        </div>

        <div class="form-group">

            <strong><label>Revista</label></strong>

            <select class="form-control"
                    id="revista"
                    name="revista"
                    required>

                <option v-bind:value="revista.numero" v-for=" revista in revistas">
                  {{ revista.nombreArticulo}}
                </option>

            </select>
        </div>

        <div class="form-group">
          <strong><label for="nombre">Articulo</label></strong>

          <textarea class="form-control"
                    id="articuloEscrito"
                    style="resize:none;"
                    name="articuloEscrito"
                    placeholder='Escribe el articulo del autor'
                    rows="8" cols="80" required>
          </textarea>

        </div>

        <a class="btn btn-danger"
            href="<?php echo base_url();?>admin/revista-autor">
            Cancelar
        </a>

        <input type="submit"
              class="btn btn-success"
              value="Agregar">

      </form>
    </div>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
    <?php
      require_once('recursos/js/admin/revistas-autores/revista_autor_nuevo.php');
    ?>
  </body>
</html>
