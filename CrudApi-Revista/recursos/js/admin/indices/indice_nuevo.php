<script type="text/javascript">

// Variables
var url = '<?php echo base_url(); ?>api/indices';
var app = new Vue({
  el: '.vue',
  data: {
    status: "normal"
  }
});

/**
* Metodo para agregar indice
* mediante una peticion HTTP Post
**/
function agregarIndice(event){
    event.preventDefault();
    var nombre = document.getElementById("text-nombreIndice").value;
    var indice = '{"nombre": "' + nombre + '"}';

    // Peticion get
    fetch( this.url, {
        method: 'POST',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        },
        body: indice
      })
    .then( (response) => {
        if (response.ok) {
          document.getElementById("text-nombreIndice").value = "";
          app.status = "success";
        } else {
          app.status = "error";
        }
        setTimeout( () => app.status = "normal", 3000);
      })
    // Promesa negativa
    .catch( (err) => {
      alert( "ha ocurrido un error con la conexion");
    });
}

</script>