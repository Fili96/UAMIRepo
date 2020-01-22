<script>

      // Variables
      var url = '<?php echo base_url(); ?>api/';
      var app = new Vue({
        el: '.vue',
        data: {
          comites: [],
          institutos: [],
          status: "normal"
        }
      });

      /**
      * Metodo para cargar las edades
      * en el combobox
      **/
      function cargarEdades(){
        var select = document.getElementById('edad');
        var texto;
        var valor;

        for (var i = 15; i <= 50; i++) {
          texto = i;
          valor= i;
          select.insertAdjacentHTML('beforeend', `<option value="${valor}">${texto}</option>`);
        }
      }

      /**
      * Metodo para cargar Comites
      * mediante una peticion HTTP Get
      **/
      function cargarComites(){
        fetch( url + "comites" )
          .then( (res) => res.json() )
          .then( (json) => {
            app.comites = json.comites;
            // console.log(app.comites);
          } );
      }

      /**
      * Metodo para cargar Institutos
      * mediante una peticion HTTP Get
      **/
      function cargarInsitutos(){
        fetch( url + "institutos" )
          .then( (res) => res.json() )
          .then( (json) => {
            app.institutos = json.institutos;
            // console.log(app.institutos);
          } );
      }

      /**
      * Metodo para agregar un Nuevo
      * Autor a la base de datos
      **/
      function agregarAutor( event ){

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
          fetch( url + "autores", {
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

              topFunction();
              setTimeout( () => app.status = "normal", 3000);
            })
          // Promesa negativa
          .catch( (err) => {
            alert( "ha ocurrido un error con la conexion");
            topFunction();
          });
      }

      /**
      * posiciona la pagina
      * al inicio
      */
      function topFunction() {
          document.body.scrollTop = 0;
          document.documentElement.scrollTop = 0;
      }

      function main(){
        cargarEdades();
        cargarComites();
        cargarInsitutos();
      }

      main();

    </script>