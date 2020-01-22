<script type="text/javascript">

    // Variables
    var url = '<?php echo base_url(); ?>api/autores';

    // Methods VueJS

    /**
    * Metodo para eliminar un comite por id
    * mediante una peticion HTTP Delete
    **/
    var eliminarAutor = function(id){

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
                  cargarAutores();
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
        autores: []
      },
      methods: {
        eliminarAutor: eliminarAutor
      }
    });

    /**
    * Metodo para cargar Autores
    * mediante una peticion HTTP Get
    **/
    function cargarAutores(){
      fetch( url )
        .then( (res) => res.json() )
        .then( (json) => app.autores = json.autores );
    }

    // Aqui empieza la ejecucion
    cargarAutores();

    </script>