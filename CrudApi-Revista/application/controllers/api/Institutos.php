<?php
defined('BASEPATH') OR exit('No direct script access allowed');
require APPPATH . '/libraries/REST_Controller.php';
use Restserver\Libraries\REST_Controller;
require APPPATH . 'libraries/Format.php';

class Institutos extends REST_Controller {

  /**
  * Constructor
  */
  function __construct(){
    parent::__construct();
    $this->load->model('institutos_model');
  }

  /**
  * Metodo para obtener Todos los institutos
  * return: Json con los institutos
  * caso contrario un mensaje de error
  */
  public function index_get(){
    $institutos = $this->institutos_model->get();

    // Comprobar que la respuesta no sea nulo
    if ( !is_null($institutos) ) {
      $this->response( array( 'institutos' => $institutos), 200 );
    } else {
        $this->response( array('error' => 'No hay institutos en la base de datos..'), 404 );
    }
  }

  /**
  * Devuelve un Instituto por id
  * return: Json con el instituto solicitado
  * caso contrario un mensaje de error
  */
  public function ver_get( $id ){

    // Comprobar que recibimos un id
    if( !$id ){
      $this->response( null, 400 );
    }

    // Devolver el instituto correspondiente al id
    $instituto = $this->institutos_model->get( $id );

    // Comprobar que la respuesta no sea null
    if( !is_null($instituto) ){
      $this->response( array( $instituto ), 200 );
    } else{
        $this->response( array( 'error' => "instituto no encontrado..."), 404 );
    }

  }

  /**
  * Agrega un Instituto
  * Recibe: Cuerpo json atraves de verbo htto post
  * return: Json con mensaje positivo
  * caso contrario mensaje de error
  */
  public function index_post(){

    // Comprobar que venga un objeto instituto en la peticion
    if( !$this->post() ){
      $this->response( null, 400 );
    }

    $id = $this->institutos_model->save( $this->post() );

    // Comprobar que el id tiene informacion
    if( !is_null( $id ) ){
      $this->response( array( 'response' => $id ), 200 );
    } else {
        $this->response( array('error' => "Algo ha falldo en el servidor. No se pudo añadir el instituto" ), 400 );
    }
  }

  /**
  * Actualiza un Instituto por id
  * return: Json con mensaje positivo
  * caso contrario mensaje de error
  */
  public function actualizar_put( $id ){

    // Si no viene un Instituto ó no viene un Id
    if( !$this->put() || !$id ){
      $this->response( null, 400 );
    }

    $update = $this->institutos_model->update( $id, $this->put() );

    // Comprobar que venga la informacion
    if( !is_null( $update ) ){
      $this->response( array( 'response' => 'Instituto actualizado correctamente..' ), 200 );
    } else {
        $this->response( array('error' => "Algo ha falldo en el servidor. No se pudo editar el instituto" ), 400 );
    }
  }

  /**
  * Elimina un Instituto por id
  * return: Json con mensaje positivo
  * caso contrario mensaje de error
  */
  public function eliminar_delete( $id ){

    // Comprobar que se reciba un id
    if( !$id ){
      $this->response( null, 400 );
    }

    $delete = $this->institutos_model->delete( $id );

    // Comprobar que se haya borrado
    if( !is_null( $delete ) ){
      $this->response( array( 'response' => 'Instituto eliminado correctamente..' ), 200 );
    } else {
        $this->response( array( 'error' => 'Algo ha fallado en el servidor. No se pudo borrar el instituto'));
    }
  }

}
