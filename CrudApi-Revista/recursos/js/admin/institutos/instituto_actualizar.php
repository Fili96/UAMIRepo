<script type="text/javascript">

// Variables
var url = '<?php echo base_url(); ?>api/institutos/';
var app = new Vue({
  el: '.vue',
  data: {
    status: "normal",
    inst: {}
  }
});

/**
* Metodo para obtener instituto por id
* mediante una peticion HTTP Post
**/
function cargarIntituto(){
    fetch( url + 'ver/<?php echo $id ?>' )
      .then( (res) => res.json() )
      .then( (json) =>{
        app.inst = json[0];
        document.getElementById("text-nombreInstituto").value = app.inst.instituto;
        console.log( app.inst );
      });
}

/**
* Metodo para agregar instituto
* mediante una peticion HTTP Post
**/
function actualizarInstituto(event){
    event.preventDefault();
    var nombre = document.getElementById("text-nombreInstituto").value;
    var instituto = '{"instituto": "' + nombre + '"}';

    fetch( url + 'actualizar/<?php echo $id ?>', {
        method: 'PUT',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        },
        body: instituto
    })
    .then( (response) => {
        if (response.ok) {
            document.getElementById("text-nombreInstituto").value = "";
            app.status = "success";
            setTimeout( () => {
               location.href = "<?php echo base_url();?>admin/institutos";
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
cargarIntituto();
</script>