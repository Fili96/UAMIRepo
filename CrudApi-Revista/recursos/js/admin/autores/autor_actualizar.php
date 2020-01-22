<script>

      "use strict";

      // Variables
      var url = '<?php echo base_url(); ?>api/';
      var app = new Vue({
        el: '.vue',
        data: {
          comites: [],
          institutos: [],
          autor: {},
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

        for (var i = 7; i <= 18; i++) {
          texto = i;
          valor= i;
          select.insertAdjacentHTML('beforeend', `<option value="${valor}">${texto}</option>`);
        }
      }

      /**
      * Metodo para cargar Comites
      * mediante una peticion HTTP Get
      **/
      async function cargarComites(){
        await fetch( url + "comites" )
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
      async function cargarInsitutos(){
        await fetch( url + "institutos" )
          .then( (res) => res.json() )
          .then( (json) => {
            app.institutos = json.institutos;
          } );
      }

      /**
      * Metodo para obtener autor por id
      * mediante una peticion HTTP GET
      **/
      async function cargarAutor(){

        var forma = document.querySelector("form");
        var elementos = forma.elements;

        await fetch( url + 'autores/ver/<?php echo $id ?>' )
          .then( (res) => res.json() )
          .then( (json) =>{
            app.autor = json[0];

            for (let i = 0; i < elementos.length -1; i++) {
              document.getElementById( elementos[i].name ).value = app.autor[ elementos[i].name ];
            }

          });
      }

      /**
      * Metodo para actualizar un Nuevo
      * Autor a la base de datos
      **/
      async function actualizarAutor( event ){

        event.preventDefault();
        var datos = {};
        var forma = document.querySelector("form");
        var elementos = forma.elements;

        for (let i = 0; i < elementos.length -1; i++) {
            datos[elementos[i].name] = elementos[i].value;
        }
           console.log(datos);

          datos = JSON.stringify(datos);

          // Peticion POST
          await fetch( url + "autores/actualizar/<?php echo $id ?>", {
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
                   location.href = "<?php echo base_url();?>admin/autores";
                 }, 1000);
              }
              else {
                app.status = "error";
              }

              topFunction();
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

      async function main(){
        cargarEdades();
        await cargarComites();
        await cargarInsitutos();
        await cargarAutor();
      }


      main();


    </script>