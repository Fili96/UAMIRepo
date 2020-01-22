<script type="text/javascript">

// Variables
var url = '<?php echo base_url(); ?>api/institutos';
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
function agregarInstituto(event){
    event.preventDefault();
    var nombre = document.getElementById("text-nombreInstituto").value;
    var instituto = '{"instituto": "' + nombre + '"}';

    // Peticion get
    fetch( this.url, {
        method: 'POST',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        },
        body: instituto
      })
    .then( (response) => {
        if (response.ok) {
          document.getElementById("text-nombreInstituto").value = "";
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