<script>

// Variables
var url = '<?php echo base_url(); ?>api/';

var app = new Vue({
  el: '.vue',
  data: {
    comites: [],
    indices: [],
    status: "normal",
    error : ""
  }
});

/**
* Metodo para cargar Comites
* mediante una peticion HTTP Get
**/
function cargarComites(){
  fetch( url + "comites" )
    .then( (res) => res.json() )
    .then( (json) => app.comites = json.comites );
}

/**
* Metodo para cargar Comites
* mediante una peticion HTTP Get
**/
function cargarIndices(){
  fetch( url + "indices" )
    .then( (res) => res.json() )
    .then( (json) => app.indices = json.indices );
}

/**
* Metodo para agregar un Nuevo
* Autor a la base de datos
**/
function agregarRevista( event ){

  event.preventDefault();
  var forma = document.querySelector("form");
  var elementos = forma.elements;
  var formData = new FormData(forma);

  // Peticion POST
  fetch( this.url + "revistas", {
      method: 'POST',
      body: formData
    })
  .then( (response) => {
      if (response.ok) {
          for (let i = 0; i < elementos.length -1; i++) {
            elementos[i].value = "";
          }
          app.status = "success";
      }
      else {
        app.status = "error";
        return response.json();
      }

      setTimeout( () => {
        app.status = "normal";
      }, 3000);

      })

    .then( (json)=> {
      console.log(json.error);
      app.error = json.error;
      setTimeout( () => {
        app.error = "";
      }, 3000);
    })
}

// Aqui empieza la ejecucion
cargarComites();
cargarIndices();

</script>