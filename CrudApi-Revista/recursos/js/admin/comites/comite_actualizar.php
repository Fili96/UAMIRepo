<script type="text/javascript">

    // Variables
    var url = '<?php echo base_url(); ?>api/comites/';
    var app = new Vue({
      el: '.vue',
      data: {
        status: "normal",
        comite: {}
      }
    });

    /**
    * Metodo para obtener comite por id
    * mediante una peticion HTTP GET
    **/
    function cargarComite(){
        fetch( url + 'ver/<?php echo $id ?>' )
          .then( (res) => res.json() )
          .then( (json) =>{
            app.comite = json[0];
            document.getElementById("text-nombreComite").value = app.comite.nombre;
            document.getElementById("text-añoInicio").value = app.comite.anioInicio;
            document.getElementById("text-añotermino").value = app.comite.anioTermino;
          });
    }

    /**
    * Metodo para Actualizar Comite
    * mediante una peticion HTTP PUT
    **/
    function actualizarComite(event){

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

        fetch( url + 'actualizar/<?php echo $id ?>', {
            method: 'PUT',
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
                setTimeout( () => {
                   location.href = "<?php echo base_url();?>admin/comites";
                 }, 1500);
            } else {
              app.status = "error";
            }
        })
        .catch( (err) => {
            alert( "ha ocurrido un error con la conexion");
        });
    }

    // Inicializacion de Codigo
    cargarComite();
    </script>