<script type="text/javascript">

// Variables
var url = '<?php echo base_url(); ?>api/indices';

// Methods VueJS

/**
* Metodo para eliminar un instituto por id
* mediante una peticion HTTP Delete
**/
var eliminarIndice = function(id){

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
              cargarIndices();
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
    indices: []
  },
  methods: {
    eliminarIndice: eliminarIndice
  }
});

/**
* Metodo para cargarIndices
* mediante una peticion HTTP Get
**/
function cargarIndices(){
  fetch( url )
    .then( (res) => res.json() )
    .then( (json) => app.indices = json.indices );
}

// Aqui empieza la ejecucion
cargarIndices();

</script>