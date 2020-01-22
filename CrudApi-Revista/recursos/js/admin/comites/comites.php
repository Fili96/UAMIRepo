<script type="text/javascript">

    // Variables
    var url = '<?php echo base_url(); ?>api/comites';

    // Methods VueJS

    /**
    * Metodo para eliminar un comite por id
    * mediante una peticion HTTP Delete
    **/
    var eliminarComite = function(id){

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
                  cargarComites();
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
        comites: []
      },
      methods: {
        eliminarComite: eliminarComite
      }
    });

    /**
    * Metodo para cargar Comites
    * mediante una peticion HTTP Get
    **/
    function cargarComites(){
      fetch( url )
        .then( (res) => res.json() )
        .then( (json) => app.comites = json.comites );
    }

    // Aqui empieza la ejecucion
    cargarComites();

    </script>