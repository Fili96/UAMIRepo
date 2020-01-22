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
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
    <!-- FontAwesome -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"">
    <!-- Vue -->
    <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
    <title>Nuevo Revista-Arbitro</title>
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
      <h2>Nuevo Revista-Arbitro</h2>

      <div class="alert alert-success" v-if='status == "success"'>
        <strong>Agregado correctamente</strong>
      </div>

      <div class="alert alert-danger" v-if='status == "error"'>
        <strong>ERROR: </strong>No se pudo agregar, Los datos ya existen
      </div>

      <form id="institutoForm" onsubmit="agregarRevistaAutor(event)">

        <div class="form-group">

            <strong><label>Arbitro</label></strong>

            <select class="form-control"
                    id="arbitro"
                    name="arbitro"
                    required>

                <option v-bind:value="arbitro.idAuthor" v-for="arbitro in arbitros">
                  {{ arbitro.nombreAuthor}} {{ arbitro.apat}} {{ arbitro.amat}}
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
                    id="articuloRevisado"
                    style="resize:none;"
                    name="articuloRevisado"
                    placeholder='Escribe el articulo del arbitro'
                    rows="8" cols="80" required>
          </textarea>

        </div>

        <a class="btn btn-danger"
            href="<?php echo base_url();?>admin/revista-arbitro">
            Cancelar
        </a>

        <input type="submit"
              class="btn btn-success"
              value="Agregar">

      </form>
    </div>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <?php
      require_once('recursos/js/admin/revistas-arbitros/revista_arbitro_nuevo.php');
    ?>
  </body>
</html>
