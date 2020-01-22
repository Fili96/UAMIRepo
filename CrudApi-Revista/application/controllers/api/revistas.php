<?php
defined('BASEPATH') OR exit('No direct script access allowed');
require APPPATH . '/libraries/REST_Controller.php';
use Restserver\Libraries\REST_Controller;
require APPPATH . 'libraries/Format.php';

class Revistas extends REST_Controller {

  /**
  * Constructor
  */
  function __construct(){
    parent::__construct();
    $this->load->model('revistas_model');
  }

  /**
  * Metodo para obtener Todas las revistas
  * return: Json con las revistas
  * caso contrario un mensaje de error
  */
  public function index_get(){
    $revistas = $this->revistas_model->get();

    // Comprobar que la respuesta no sea nulo
    if ( !is_null($revistas) ) {
      $this->response( array( 'revistas' => $revistas), 200 );
    } else {
        $this->response( array('error' => 'No hay revistas en la base de datos..'), 404 );
    }
  }

  /**
  * Devuelve una Revista por id
  * return: Json con la revista solicitada
  * caso contrario un mensaje de error
  */
  public function ver_get( $id ){

    // Comprobar que recibimos un id
    if( !$id ){
      $this->response( null, 400 );
    }

    // Devolver la revista correspondiente al id
    $revista = $this->revistas_model->get( $id );

    // Comprobar que la respuesta no sea null
    if( !is_null($revista) ){
      $this->response( array( $revista ), 200 );
    } else{
        $this->response( array( 'error' => "revista no encontrado..."), 404 );
    }

  }

  /**
  * Agrega una Revista
  * Recibe: Cuerpo json atraves de verbo http post
  * return: Json con mensaje positivo
  * caso contrario mensaje de error
  */
  public function index_post(){

    // Comprobar que venga un objeto revista en la peticion
    if( !$this->post() ){
      $this->response( array('error' => "No llego el objeto correctamente" ), 400 );
    }

    //verifica que llegue bien la imagen
    if ($_FILES["imagen"]["error"] > 0) {
      $this->response( array('error' => "No llego la imagen correctamente" ), 400 );
    }

    //verifica que llegue bien el pdf
    if ($_FILES["pdf"]["error"] > 0) {
      $this->response( array('error' => "No llego el pdf correctamente" ), 400 );
    }

    //asigna las extenciones permitidas para los archivos
    $permitidosImagen = array("image/jpeg","image/jpg","image/png");
    $permitidosPDF = array("application/pdf");
    //asigna el tamaña maximo en MegaBytes permitido para los archivos
    $tamañoImagenMB = 10;
    $tamañoPdfMB = 200;

    //valida que la extencion y tamaño sea el apropiado para los archivos
    //si es asi continua con el procedimiento
    //caso contrario manda error debido al formato y/o tamaño de los archivos
    if( ( in_array($_FILES["imagen"]["type"], $permitidosImagen) &&
        $_FILES["imagen"]["size"] < ($tamañoImagenMB * 1024 * 1024)) &&
        ( in_array($_FILES["pdf"]["type"], $permitidosPDF) &&
        $_FILES["pdf"]["size"] < ($tamañoPdfMB * 1024 * 1024)) ){

              //la ruta donde se van a crear los archivos
              //ejemplo de ruta: revistas/tituloRevista/
              $ruta = 'revistas/' . $_POST['nombre'] . '/';
              //la ruta donde se va guarda la imagen
              //ejemplo de ruta: revistas/tituloRevista/nombreImagen
              $imagen = $ruta . $_FILES["imagen"]["name"];
              //la ruta donde se va guarda el pdf
              //ejemplo de ruta: revistas/tituloRevista/nombrePdf
              $pdf =  $ruta . $_FILES["pdf"]["name"];

              //valida la existencia de la carpeta en esa ruta
              //si no existe la carpeta, crea la carpeta en esa ruta
              //caso contrario manda error
              if (!file_exists($ruta)) {
                mkdir($ruta);
              }
              else{
                $this->response( array('error' => "La carpeta ya existe" ), 400 );
              }

              //valida la existencia de la imagen y el pdf
              //si ambos no existen, copia los archivos temporales subidos a la ruta en cuestion y guarda el resultado obtenido
              //caso contrario, manda error con los archivos
              if((!file_exists($imagen))&&(!file_exists($pdf))){

                      $resultadoImagen = @move_uploaded_file($_FILES["imagen"]["tmp_name"], $imagen);
                      $resultadoPDF = @move_uploaded_file($_FILES["pdf"]["tmp_name"], $pdf);

                      //si todo fue bien con los resultados, los archivos se guardaron correctamente
                      if ( ($resultadoImagen) && ($resultadoPDF) ) {

                              // echo "Archivos Guardados Correctamente <br>";
                              $revista = array(
                                'nombreArticulo' => $_POST['nombre'],
                                'fechaRecpcion' => $_POST['fechaRecpcion'],
                                'fechaPublicacion' => $_POST['fechaPublicacion'],
                                'imagen' => base_url() . $imagen,
                                'pdf' => base_url() . $pdf,
                                'Comite_idComite' => $_POST['comite'],
                                'Indice_idIndice' => $_POST['indice']
                               );

                              //empieza la validacion de los datos para la base de datos

                              $id = $this->revistas_model->save( $revista );

                              // Comprobar que el id tiene informacion
                              if( !is_null( $id ) ){
                                $this->response( array( 'response' => $id ), 200 );
                              }

                              else {
                                  $this->response( array('error' => "Algo ha falldo en el servidor. No se pudo añadir la revista" ), 400 );
                              }

                      }

                      else{
                        $this->response( array('error' => "Error al Cargar los Archivos" ), 400 );
                      }

              }

              else{

                  $this->response( array('error' => "Puede que alguno de los archivos ó ambos archivos ya existan" ), 400 );
                }

    }

    else{
      $this->response( array('error' => "Verifica tipo y tamaño de los archivos" ), 400 );
    }
  }

  /**
  * Actualiza una Revista por id
  * return: Json con mensaje positivo
  * caso contrario mensaje de error
  */
  public function actualizar_post( $id ){

    // Si no viene una Revista ó no viene un Id
    if( !$this->post() || !$id ){
      $this->response( array('error' => "No llego el objeto correctamente" ), 400 );
    }

    //verifica que llegue bien la imagen
    if ($_FILES["imagen"]["error"] > 0) {
      $this->response( array('error' => "No llego la imagen correctamente" ), 400 );
    }

    //verifica que llegue bien el pdf
    if ($_FILES["pdf"]["error"] > 0) {
      $this->response( array('error' => "No llego el pdf correctamente" ), 400 );
    }


    //asigna las extenciones permitidas para los archivos
    $permitidosImagen = array("image/jpeg","image/jpg","image/png");
    $permitidosPDF = array("application/pdf");
    //asigna el tamaña maximo en MegaBytes permitido para los archivos
    $tamañoImagenMB = 10;
    $tamañoPdfMB = 200;

    //valida que la extencion y tamaño sea el apropiado para los archivos
    //si es asi continua con el procedimiento
    //caso contrario manda error debido al formato y/o tamaño de los archivos
    if( ( in_array($_FILES["imagen"]["type"], $permitidosImagen) && $_FILES["imagen"]["size"] < ($tamañoImagenMB * 1024 * 1024)) &&
        ( in_array($_FILES["pdf"]["type"], $permitidosPDF) && $_FILES["pdf"]["size"] < ($tamañoPdfMB * 1024 * 1024)) ){

              //la ruta donde se van a crear los archivos
              //ejemplo de ruta: revistas/tituloRevista/
              $ruta = 'revistas/' . $_POST['nombre'] . '/';
              //la ruta donde se va guarda la imagen
              //ejemplo de ruta: revistas/tituloRevista/nombreImagen
              $imagen = $ruta . $_FILES["imagen"]["name"];
              //la ruta donde se va guarda el pdf
              //ejemplo de ruta: revistas/tituloRevista/nombrePdf
              $pdf =  $ruta . $_FILES["pdf"]["name"];

              //valida la existencia de la carpeta en esa ruta
              //si no existe la carpeta, crea la carpeta en esa ruta
              //caso contrario manda error
              if (!file_exists($ruta)) {
                mkdir($ruta);
              }

              $resultadoImagen = @move_uploaded_file($_FILES["imagen"]["tmp_name"], $imagen);
              $resultadoPDF = @move_uploaded_file($_FILES["pdf"]["tmp_name"], $pdf);

              //si todo fue bien con los resultados, los archivos se guardaron correctamente
              if ( ($resultadoImagen) && ($resultadoPDF) ) {

                      // echo "Archivos Guardados Correctamente <br>";

                      //empieza la validacion de los datos para la base de datos

                      $update = array(
                        'nombreArticulo' => $_POST['nombre'],
                        'fechaRecpcion' => $_POST['fechaRecpcion'],
                        'fechaPublicacion' => $_POST['fechaPublicacion'],
                        'imagen' => base_url() . $imagen,
                        'pdf' => base_url() . $pdf,
                        'Comite_idComite' => $_POST['comite'],
                        'Indice_idIndice' => $_POST['indice']
                        );

                      $res = $this->revistas_model->update( $id, $update );

                      // Comprobar que el id tiene informacion
                      if( !is_null( $res ) && $res == "true"){
                        $this->response( array( 'response' => $res ), 200 );
                      }

                      else {
                          $this->response( array('error' => "No se pudo actualizar la revista" ), 400 );
                      }

              }

              else{
                $this->response( array('error' => "Error al Cargar los Archivos" ), 400 );
              }

    }

    else{
      $this->response( array('prueba error' => $post_vars['nombre'] ), 400 );
    }

  }

  /**
  * Elimina una Revista por id
  * return: Json con mensaje positivo
  * caso contrario mensaje de error
  */
  public function eliminar_delete( $id ){

    // Comprobar que se reciba un id
    if( !$id ){
      $this->response( null, 400 );
    }

    $delete = $this->revistas_model->delete( $id );

    // Comprobar que se haya borrado
    if( !is_null( $delete ) ){
      $this->response( array( 'response' => 'Revista eliminado correctamente..' ), 200 );
    } else {
        $this->response( array( 'error' => 'Algo ha fallado en el servidor. No se pudo borrar la revista'));
    }
  }

}
