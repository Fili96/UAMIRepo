<script type="text/javascript">

// Variables
var url = '<?php echo base_url(); ?>api/indices/';
var app = new Vue({
  el: '.vue',
  data: {
    status: "normal",
    indice: {}
  }
});

/**
* Metodo para obtener indice por id
* mediante una peticion HTTP Post
**/
function cargarIndice(){
    fetch( url + 'ver/<?php echo $id ?>' )
      .then( (res) => res.json() )
      .then( (json) =>{
        app.indice = json[0];
        document.getElementById("text-nombreIndice").value = app.indice.nombre;
        console.log( app.indice );
      });
}

/**
* Metodo para agregar indice
* mediante una peticion HTTP Post
**/
function actualizarIndice(event){
    event.preventDefault();
    var nombre = document.getElementById("text-nombreIndice").value;
    var indice = '{"nombre": "' + nombre + '"}';

    fetch( url + 'actualizar/<?php echo $id ?>', {
        method: 'PUT',
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
            setTimeout( () => {
               location.href = "<?php echo base_url();?>admin/indices";
             }, 1500);
        } else {
          app.status = "error";
        }
    })
    .catch( (err) => {
        alert( "ha ocurrido un error con la conexion");
    });
}

// Inicializacion de Codigo
cargarIndice();
</script>