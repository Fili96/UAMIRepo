<script>

      // Variables
      var url = '<?php echo base_url(); ?>api/';
      var app = new Vue({
        el: '.vue',
        data: {
          indices: [],
          pagina: {},
          status: "normal"
        }
      });


      /**
      * Metodo para cargar Indices
      * mediante una peticion HTTP Get
      **/
      async function cargarIndices(){
        await fetch( url + "indices" )
          .then( (res) => res.json() )
          .then( (json) => {
            app.indices = json.indices;
          } );
      }

      /**
      * Metodo para obtener pagina por id
      * mediante una peticion HTTP GET
      **/
      async function cargarPagina(){

        var forma = document.querySelector("form");
        var elementos = forma.elements;

        await fetch( url + 'paginas/ver/<?php echo $id ?>' )
          .then( (res) => res.json() )
          .then( (json) =>{
            app.pagina = json[0];

            for (let i = 0; i < elementos.length -1; i++) {
              document.getElementById( elementos[i].name ).value = app.pagina[ elementos[i].name ];
            }

          });
      }

      /**
      * Metodo para actualizar un Nuevo
      * pagina a la base de datos
      **/
      async function actualizarPagina( event ){

        event.preventDefault();
        var datos = {};
        var forma = document.querySelector("form");
        var elementos = forma.elements;

        for (let i = 0; i < elementos.length -1; i++) {
            datos[elementos[i].name] = elementos[i].value;
        }

        datos = JSON.stringify(datos);

        // Peticion POST
        await fetch( url + "paginas/actualizar/<?php echo $id ?>", {
          method: "PUT",
          headers: {'Accept': 'application/json', 'Content-Type': 'application/json'},
          body: datos
        })
        .then( (response) => {

            if (response.ok) {
              for (let i = 0; i < elementos.length -1; i++) {
                elementos[i].value = "";
              }
              app.status = "success";
              setTimeout( () => {
                  location.href = "<?php echo base_url();?>admin/paginas";
                }, 1000);
            }
            else {
              app.status = "error";
            }
          })
        // Promesa negativa
        .catch( (err) => {
          alert( "ha ocurrido un error con la conexion");
        });
      }


      async function main(){
        await cargarIndices();
        await cargarPagina();
      }

      main();

    </script>