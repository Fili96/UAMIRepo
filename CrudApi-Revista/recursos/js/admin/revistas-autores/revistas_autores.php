<script type="text/javascript">

// Variables
var url = '<?php echo base_url(); ?>api/revistas-autores';

// Methods VueJS

/**
* Metodo para eliminar un instituto por id
* mediante una peticion HTTP Delete
**/
var elimRevistaAutor = function( idAutor, idRevista){

    var respuesta = confirm(`¿Estas seguro de elimiar el registro con los datos:\nidAutor = ${idAutor} y idRevista = ${idRevista}?`);

    if (respuesta) {
        fetch( `${url}/eliminar/${idAutor}/${idRevista}`, {
          method: 'DELETE',
          headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
          }
        })
        .then( (response) => {
            if( response.ok){
              cargarRevistasAutores();
            }else{
              alert( "ha ocurrido un error es posible que el registro tenga dependencias");
            }
        })
        .catch( (error) => {
          alert( "ha ocurrido un error con la conexion");
        })
    }

}

var app = new Vue({
  el: '.vue',
  data: {
    revs_auts: []
  },
  methods: {
    elimRevistaAutor: elimRevistaAutor
  }
});

/**
* Metodo para cargarRevistasAutores
* mediante una peticion HTTP Get
**/
function cargarRevistasAutores(){
  fetch( url )
    .then( (res) => res.json() )
    .then( (json) => app.revs_auts = json["revistas-autores"] );
}

// Aqui empieza la ejecucion
cargarRevistasAutores();

</script>