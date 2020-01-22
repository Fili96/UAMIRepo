<script type="text/javascript">

// Variables
var url = '<?php echo base_url(); ?>api/';
var app = new Vue({
  el: '.vue',
  data: {
    status: "normal",
    autores: [],
    revistas: []
  }
});

/**
* Metodo para cargar Autores
* mediante una peticion HTTP Get
**/
function cargarAutores(){
  fetch( url + "autores" )
    .then( (res) => res.json() )
    .then( (json) => {
      app.autores = json.autores;
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

    var author = document.getElementById("author").value;
    var revista = document.getElementById("revista").value;
    var articuloEscrito = document.getElementById("articuloEscrito").value;

    var ra = {
      "author": author,
      "revista": revista,
      "articuloEscrito": articuloEscrito
    };

    data = JSON.stringify(ra);
    console.log( data );

    // Peticion get
    fetch( url + "revistas_autores", {
        method: 'POST',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        },
        body: data
      })
    .then( (response) => {
        if (response.ok) {

          document.getElementById("author").value = "";
          document.getElementById("revista").value = "";
          document.getElementById("articuloEscrito").value = "";

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
  cargarAutores();
  cargarRevistas();
}

main();

</script>