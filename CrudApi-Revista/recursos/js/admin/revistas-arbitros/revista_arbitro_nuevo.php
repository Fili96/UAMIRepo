<script type="text/javascript">

// Variables
var url = '<?php echo base_url(); ?>api/';
var app = new Vue({
  el: '.vue',
  data: {
    status: "normal",
    arbitros: [],
    revistas: []
  }
});

/**
* Metodo para cargar arbitros
* mediante una peticion HTTP Get
**/
function cargarArbitros(){
  fetch( url + "autores" )
    .then( (res) => res.json() )
    .then( (json) => {
      app.arbitros = json.autores;
      
    } );
}

/**
* Metodo para cargar Institutos
* mediante una peticion HTTP Get
**/
function cargarRevistas(){
  fetch( url + "revistas" )
    .then( (res) => res.json() )
    .then( (json) => {
      app.revistas = json.revistas;
    } );
}

/**
* Metodo para agregar instituto
* mediante una peticion HTTP Post
**/
function agregarRevistaAutor(event){
    event.preventDefault();

    var arbitro = document.getElementById("arbitro").value;
    var revista = document.getElementById("revista").value;
    var articuloRevisado = document.getElementById("articuloRevisado").value;

    var ra = {
      "arbitro": arbitro,
      "revista": revista,
      "articuloRevisado": articuloRevisado
    };

    data = JSON.stringify(ra);

    // Peticion get
    fetch( url + "revistas_arbitros", {
        method: 'POST',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        },
        body: data
      })
    .then( (response) => {
        if (response.ok) {

          document.getElementById("arbitro").value = "";
          document.getElementById("revista").value = "";
          document.getElementById("articuloRevisado").value = "";

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

function main(){
  cargarArbitros();
  cargarRevistas();
}

main();

</script>