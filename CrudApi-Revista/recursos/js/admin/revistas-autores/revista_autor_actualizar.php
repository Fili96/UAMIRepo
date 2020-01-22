<script type="text/javascript">

// Variables
var url = '<?php echo base_url(); ?>api/';
var app = new Vue({
  el: '.vue',
  data: {
    status: "normal"
  }
});

/**
* Metodo para agregar instituto
* mediante una peticion HTTP Post
**/
function ActualizarRevistaAutor(event){
    event.preventDefault();

    var articuloEscrito = document.getElementById("articuloEscrito").value;

    var ra = {
      "articuloEscrito": articuloEscrito
    };

    data = JSON.stringify(ra);
    
    fetch( url + "revistas_autores/actualizar/<?php echo $idAutor ?>/<?php echo $idRevista ?>",
     {
        method: 'PUT',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        },
        body: data
      })
    .then( (response) => {
        if (response.ok) {

          document.getElementById("articuloEscrito").value = "";
          app.status = "success";
          setTimeout( () => {
             location.href = "<?php echo base_url();?>admin/revista-autor";
           }, 1000);

        } else {
          app.status = "error";
        }
      })
    // Promesa negativa
    .catch( (err) => {
      alert( "ha ocurrido un error con la conexion");
    });
}

</script>