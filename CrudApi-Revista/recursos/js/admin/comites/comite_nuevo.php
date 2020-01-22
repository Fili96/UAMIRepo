<script type="text/javascript">

    // Variables
    var url = '<?php echo base_url(); ?>api/comites';
    var app = new Vue({
      el: '.vue',
      data: {
        status: "normal"
      }
    });

    /**
    * Metodo para agregar Comite
    * mediante una peticion HTTP Post
    **/
    function agregarComite(event){

        event.preventDefault();
        var nombre = document.getElementById("text-nombreComite").value;
        var anioInicio = document.getElementById("text-añoInicio").value;
        var anioTermino = document.getElementById("text-añotermino").value;

        var comite = {
          "nombre": nombre,
          "anioInicio": anioInicio,
          "anioTermino": anioTermino
         };

         comite = JSON.stringify(comite);

        // Peticion POST
        fetch( this.url, {
            method: 'POST',
            headers: {
              'Accept': 'application/json',
              'Content-Type': 'application/json'
            },
            body: comite
          })
        .then( (response) => {
            if (response.ok) {
              document.getElementById("text-nombreComite").value = "";
              document.getElementById("text-añoInicio").value = "";
              document.getElementById("text-añotermino").value = "";
              app.status = "success";
            } else {
              app.status = "error";
            }
            setTimeout( () => app.status = "normal", 3000);
          })
        // Promesa negativa
        .catch( (err) => {
          alert( "ha ocurrido un error con la conexion");
        });
    }

    </script>