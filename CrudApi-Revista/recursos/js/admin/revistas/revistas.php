<script type="text/javascript">

// Variables
var url = '<?php echo base_url(); ?>api/revistas';

// Methods VueJS

/**
* Metodo para eliminar un revista por id
* mediante una peticion HTTP Delete
**/
var eliminarRevista = function(id){

    var respuesta = confirm("Estas seguro de elimiar el registro " + id );
    if (respuesta) {
        fetch( url + '/eliminar/' + id, {
          method: 'DELETE',
          headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
          }
        })
        .then( (response) => {
            if( response.ok){
              cargarRevistas();
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
    revistas: []
  },
  methods: {
    eliminarRevista: eliminarRevista
  }
});

/**
* Metodo para cargar Comites
* mediante una peticion HTTP Get
**/
function cargarRevistas(){
  fetch( url )
    .then( (res) => res.json() )
    .then( (json) => app.revistas = json.revistas );
}

// Aqui empieza la ejecucion
cargarRevistas();

</script>