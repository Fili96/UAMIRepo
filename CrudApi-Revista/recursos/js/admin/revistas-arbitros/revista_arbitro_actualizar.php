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

    var articuloRevisado = document.getElementById("articuloRevisado").value;

    var ra = {
      "articuloRevisado": articuloRevisado
    };

    data = JSON.stringify(ra);
    
    fetch( url + "revistas_arbitros/actualizar/<?php echo $idArbitro ?>/<?php echo $idRevista ?>",
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

          document.getElementById("articuloRevisado").value = "";
          app.status = "success";
          setTimeout( () => {
             location.href = "<?php echo base_url();?>admin/revista-arbitro";
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