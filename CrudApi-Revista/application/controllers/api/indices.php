<?php
defined('BASEPATH') OR exit('No direct script access allowed');
require APPPATH . '/libraries/REST_Controller.php';
use Restserver\Libraries\REST_Controller;
require APPPATH . 'libraries/Format.php';

class Indices extends REST_Controller {

  /**
  * Constructor
  */
  function __construct(){
    parent::__construct();
    $this->load->model('indices_model');
  }

  /**
  * Metodo para obtener Todos los indices
  * return: Json con los indices
  * caso contrario un mensaje de error
  */
  public function index_get(){
    $indices = $this->indices_model->get();

    // Comprobar que la respuesta no sea nulo
    if ( !is_null($indices) ) {
      $this->response( array( 'indices' => $indices), 200 );
    } else {
        $this->response( array('error' => 'No hay indices en la base de datos..'), 404 );
    }
  }

  /**
  * Devuelve un Indice por id
  * return: Json con el indice solicitado
  * caso contrario un mensaje de error
  */
  public function ver_get( $id ){

    // Comprobar que recibimos un id
    if( !$id ){
      $this->response( null, 400 );
    }

    // Devolver el indice correspondiente al id
    $indice = $this->indices_model->get( $id );

    // Comprobar que la respuesta no sea null
    if( !is_null($indice) ){
      $this->response( array( $indice ), 200 );
    } else{
        $this->response( array( 'error' => "indice no encontrado..."), 404 );
    }

  }

  /**
  * Agrega un Indice
  * Recibe: Cuerpo json atraves de verbo htto post
  * return: Json con mensaje positivo
  * caso contrario mensaje de error
  */
  public function index_post(){

    // Comprobar que venga un objeto indice en la peticion
    if( !$this->post() ){
      $this->response( null, 400 );
    }

    $id = $this->indices_model->save( $this->post() );

    // Comprobar que el id tiene informacion
    if( !is_null( $id ) ){
      $this->response( array( 'response' => $id ), 200 );
    } else {
        $this->response( array('error' => "Algo ha falldo en el servidor. No se pudo añadir el indice" ), 400 );
    }
  }

  /**
  * Actualiza un Indice por id
  * return: Json con mensaje positivo
  * caso contrario mensaje de error
  */
  public function actualizar_put( $id ){

    // Si no viene un Indice ó no viene un Id
    if( !$this->put() || !$id ){
      $this->response( null, 400 );
    }

    $update = $this->indices_model->update( $id, $this->put() );

    // Comprobar que venga la informacion
    if( !is_null( $update ) ){
      $this->response( array( 'response' => 'Indice actualizado correctamente..' ), 200 );
    } else {
        $this->response( array('error' => "Algo ha falldo en el servidor. No se pudo editar el indice" ), 400 );
    }
  }

  /**
  * Elimina un Indice por id
  * return: Json con mensaje positivo
  * caso contrario mensaje de error
  */
  public function eliminar_delete( $id ){

    // Comprobar que se reciba un id
    if( !$id ){
      $this->response( null, 400 );
    }

    $delete = $this->indices_model->delete( $id );

    // Comprobar que se haya borrado
    if( !is_null( $delete ) ){
      $this->response( array( 'response' => 'Indice eliminado correctamente..' ), 200 );
    } else {
        $this->response( array( 'error' => 'Algo ha fallado en el servidor. No se pudo borrar el indice'));
    }
  }

}
