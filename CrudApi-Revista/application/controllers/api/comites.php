<?php
defined('BASEPATH') OR exit('No direct script access allowed');
require APPPATH . '/libraries/REST_Controller.php';
use Restserver\Libraries\REST_Controller;
require APPPATH . 'libraries/Format.php';

class Comites extends REST_Controller {

  /**
  * Constructor
  */
  function __construct(){
    parent::__construct();
    $this->load->model('comites_model');
  }

  /**
  * Metodo para obtener Todos los comites
  * return: Json con los comites
  * caso contrario un mensaje de error
  */
  public function index_get(){
    $comites = $this->comites_model->get();

    // Comprobar que la respuesta no sea nulo
    if ( !is_null($comites) ) {
      $this->response( array( 'comites' => $comites), 200 );
    } else {
        $this->response( array('error' => 'No hay comites en la base de datos..'), 404 );
    }
  }

  /**
  * Devuelve un Comite por id
  * return: Json con el comite solicitado
  * caso contrario un mensaje de error
  */
  public function ver_get( $id ){

    // Comprobar que recibimos un id
    if( !$id ){
      $this->response( null, 400 );
    }

    // Devolver el comite correspondiente al id
    $comite = $this->comites_model->get( $id );

    // Comprobar que la respuesta no sea null
    if( !is_null($comite) ){
      $this->response( array( $comite ), 200 );
    } else{
        $this->response( array( 'error' => "comite no encontrado..."), 404 );
    }

  }

  /**
  * Agrega un Comite
  * Recibe: Cuerpo json atraves de verbo http post
  * return: Json con mensaje positivo
  * caso contrario mensaje de error
  */
  public function index_post(){

    // Comprobar que venga un objeto comite en la peticion
    if( !$this->post() ){
      $this->response( null, 400 );
    }

    $id = $this->comites_model->save( $this->post() );

    // Comprobar que el id tiene informacion
    if( !is_null( $id ) ){
      $this->response( array( 'response' => $id ), 200 );
    } else {
        $this->response( array('error' => "Algo ha falldo en el servidor. No se pudo añadir el comite" ), 400 );
    }
  }

  /**
  * Actualiza un Comite por id
  * return: Json con mensaje positivo
  * caso contrario mensaje de error
  */
  public function actualizar_put( $id ){

    // Si no viene un comite ó no viene un Id
    if( !$this->put() || !$id ){
      $this->response( null, 400 );
    }

    $update = $this->comites_model->update( $id, $this->put() );

    // Comprobar que venga la informacion
    if( !is_null( $update ) ){
      $this->response( array( 'response' => 'Comite actualizado correctamente..' ), 200 );
    } else {
        $this->response( array('error' => "Algo ha falldo en el servidor. No se pudo editar el comite" ), 400 );
    }
  }

  /**
  * Elimina un Comite por id
  * return: Json con mensaje positivo
  * caso contrario mensaje de error
  */
  public function eliminar_delete( $id ){

    // Comprobar que se reciba un id
    if( !$id ){
      $this->response( null, 400 );
    }

    $delete = $this->comites_model->delete( $id );

    // Comprobar que se haya borrado
    if( !is_null( $delete ) ){
      $this->response( array( 'response' => 'comite eliminado correctamente..' ), 200 );
    } else {
        $this->response( array( 'error' => 'Algo ha fallado en el servidor. No se pudo borrar el comite'));
    }
  }

}
