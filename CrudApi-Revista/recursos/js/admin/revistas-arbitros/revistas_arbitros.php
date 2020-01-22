<script type="text/javascript">

// Variables
var url = '<?php echo base_url(); ?>api/revistas-arbitros';

// Methods VueJS

/**
* Metodo para eliminar un instituto por id
* mediante una peticion HTTP Delete
**/
var elimRevistaArbitro = function( idArbitro, idRevista){

    var respuesta = confirm(`¿Estas seguro de elimiar el registro con los datos:\nidArbitro = ${idArbitro} y idRevista = ${idRevista}?`);

    if (respuesta) {
        fetch( `${url}/eliminar/${idArbitro}/${idRevista}`, {
          method: 'DELETE',
          headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
          }
        })
        .then( (response) => {
            if( response.ok){
              cargarRevistasArbitros();
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
    revs_arbitros: []
  },
  methods: {
    elimRevistaArbitro: elimRevistaArbitro
  }
});

/**
* Metodo para cargarRevistasArbitros
* mediante una peticion HTTP Get
**/
function cargarRevistasArbitros(){
  fetch( url )
    .then( (res) => res.json() )
    .then( (json) => app.revs_arbitros = json["revistas-arbitros"] );
}

// Aqui empieza la ejecucion
cargarRevistasArbitros();

</script>