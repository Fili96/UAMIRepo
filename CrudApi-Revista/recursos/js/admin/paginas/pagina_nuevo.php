<script>

      // Variables
      var url = '<?php echo base_url(); ?>api/';
      var app = new Vue({
        el: '.vue',
        data: {
          indices: [],
          status: "normal"
        }
      });


      /**
      * Metodo para cargar indices
      * mediante una peticion HTTP Get
      **/
      function cargarIndices(){
        fetch( url + "indices" )
          .then( (res) => res.json() )
          .then( (json) => {
            app.indices = json.indices;
            // console.log(app.indices);
          } );
      }

      /**
      * Metodo para agregar un Nuevo
      * Autor a la base de datos
      **/
      function agregarPagina( event ){

        event.preventDefault();

        var forma = document.querySelector("form");
        var elementos = forma.elements;
        var datos = {};

        for (let i = 0; i < elementos.length -1; i++) {
          datos[elementos[i].name] = elementos[i].value;
        }
          // console.log(datos);
          datos = JSON.stringify(datos);

          // Peticion POST
          fetch( url + "paginas", {
            method: "POST",
            headers: {'Accept': 'application/json', 'Content-Type': 'application/json'},
            body: datos
          })
          .then( (response) => {

              if (response.ok) {
                for (let i = 0; i < elementos.length -1; i++) {
                  elementos[i].value = "";
                }
                app.status = "success";
              }
              else {
                app.status = "error";
              }
              setTimeout( () => app.status = "normal", 3000);
            })
          // Promesa negativa
          .catch( (err) => {
            alert( "ha ocurrido un error con la conexion");
          });
      }


      function main(){
        cargarIndices();
      }

      main();

    </script>