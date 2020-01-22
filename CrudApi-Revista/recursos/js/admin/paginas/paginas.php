<script type="text/javascript">

    // Variables
    var url = '<?php echo base_url(); ?>api/paginas';

    // Methods VueJS

    /**
    * Metodo para eliminar un comite por id
    * mediante una peticion HTTP Delete
    **/
    var eliminarPagina = function(id){

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
                  cargarPaginas();
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
        paginas: []
      },
      methods: {
        eliminarPagina: eliminarPagina
      }
    });

    /**
    * Metodo para cargar paginas
    * mediante una peticion HTTP Get
    **/
    function cargarPaginas(){
      fetch( url )
        .then( (res) => res.json() )
        .then( (json) => app.paginas = json.paginas );
    }

    // Aqui empieza la ejecucion
    cargarPaginas();

    </script>