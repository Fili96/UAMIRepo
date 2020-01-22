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
    <title>Nueva Autor</title>
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

      <h2>Nuevo Autor</h2>

      <div class="alert alert-success" v-if='status == "success"'>
        <strong>Agregado correctamente</strong>
      </div>

      <div class="alert alert-danger" v-if='status == "error"'>
        <strong>ERROR: </strong>No se pudo agregar, Intenta de nuevo
      </div>

      <form onsubmit="agregarAutor(event)">
            <div class="form-group">
                <strong><label for="nombre">Nombre</label></strong>
                <input type="text" class="form-control" id="text-nombreComite" name="nombreAuthor" placeholder='Escribe el nombre del autor' maxlength="45" required>
            </div>

            <div class="form-group">
                <strong><label for="apellido paterno">Apellido Paterno</label></strong>
                <input type="text" class="form-control" id="text-apat" name="apat" placeholder='Escribe el apellido paterno del autor' maxlength="45" required>
            </div>

            <div class="form-group">
                <strong><label for="apellido materno">Apellido Materno</label></strong>
                <input type="text" class="form-control" id="text-amat" name="amat" placeholder='Escribe el apellido materno del autor' maxlength="45" required>
            </div>

            <div class="form-group">
                <strong><label for="edad">Edad</label></strong>

                <select class="form-control" name="edad" id="edad" required>
                </select>
            </div>

            <div class="form-group">
                <strong><label for="correo electronico">Correo Electronico</label></strong>

                <input type="email" class="form-control" id="text-amat" name="correo"
                placeholder='Escribe un correo electronico' maxlength="45"
                pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" required>
                
            </div>

            <div class="form-group">

                <strong><label for="instituto">Instituto</label></strong>

                <select class="form-control" id="instituto" name="Instituto_idInstituto" required>
                    <option v-bind:value="inst.idInstituto" v-for=" inst in institutos">
                      {{ inst.instituto}}
                    </option>
                </select>
            </div>

            <div class="form-group">

                <strong><label for="comite">Comite</label></strong>

                <select class="form-control" id="comite" name="Comite_idComite" required>
                    <option v-bind:value="comite.idComite" v-for=" comite in comites">
                      {{ comite.nombre }}
                    </option>
                </select>
            </div>

            <a class="btn btn-danger" href="<?php echo base_url();?>admin/autores">Cancelar</a>
            <input type="submit" class="btn btn-success" value="Agregar Autor">

      </form>
    </div>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
    <?php
      require_once('recursos/js/admin/autores/autor_nuevo.php');
    ?>
  </body>
</html>
