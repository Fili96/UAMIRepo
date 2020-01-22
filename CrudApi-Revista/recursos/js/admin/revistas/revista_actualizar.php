<script>

"use strict";

// Variables
var url = '<?php echo base_url(); ?>api/';

var app = new Vue({
  el: '.vue',
  data: {
    comites: [],
    indices: [],
    revista: {},
    status: "normal",
    error: ""
  }
});

/**
* Metodo para obtener autor por id
* mediante una peticion HTTP GET
**/
 async function cargarRevista(){

   await fetch( url + 'revistas/ver/<?php echo $id ?>' )
    .then( (res) => res.json() )
    .then( (json) =>{
      app.revista = json[0];

      document.getElementById("nombre").value = app.revista.nombreArticulo;
      document.getElementById("fechaRecpcion").value = app.revista.fechaRecpcion;
      document.getElementById("fechaPublicacion").value = app.revista.fechaPublicacion;
      document.getElementById( "Comite_idComite" ).value = app.revista.Comite_idComite;
      document.getElementById( "Indice_idIndice" ).value = app.revista.Indice_idIndice;

    });
}

/**
* Metodo para cargar Comites
* mediante una peticion HTTP Get
**/
async function cargarComites(){
  await fetch( url + "comites" )
    .then( (res) => res.json() )
    .then( (json) => {
      app.comites = json.comites;

    });
}

/**
* Metodo para cargar Comites
* mediante una peticion HTTP Get
**/
async function cargarIndices(){
  await fetch( url + "indices" )
    .then( (res) => res.json() )
    .then( (json) => {
      app.indices = json.indices;

    });
}

/**
* Metodo para agregar un Nuevo
* Autor a la base de datos
**/
async function actualizarRevista( event ){

  event.preventDefault();
  var forma = document.querySelector("form");
  var elementos = forma.elements;
  var formData = new FormData(forma);

  // Peticion PUT
  await fetch( url + "revistas/actualizar/<?php echo $id ?>", {
      method: 'POST',
      body: formData
    })
  .then( (response) => {
      if (response.ok) {
          for (let i = 0; i < elementos.length -1; i++) {
            elementos[i].value = "";
          }
          app.status = "success";
          setTimeout( () => {
             location.href = "<?php echo base_url();?>admin/revistas";
           }, 1000);
      }
      else {
        app.status = "error";
        return response.json()
      }
      })

      .then( (json)=> {
        console.log(json.error);
        app.error = json.error;
      })

  .catch( (err) => {
    if(eapp.rror == "")
      alert( "ha ocurrido un error con la conexion");
  });
}

async function main(){
  await cargarComites();
  await cargarIndices();
  await cargarRevista();
}

main();


</script>