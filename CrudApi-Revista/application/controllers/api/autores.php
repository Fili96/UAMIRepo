<?php
defined('BASEPATH') OR exit('No direct script access allowed');
require APPPATH . '/libraries/REST_Controller.php';
use Restserver\Libraries\REST_Controller;
require APPPATH . 'libraries/Format.php';

class Autores extends REST_Controller {

  /**
  * Constructor
  */
  function __construct(){
    parent::__construct();
    $this->load->model('autores_model');
  }

  /**
  * Metodo para obtener Todos los autores
  * return: Json con los autores
  * caso contrario un mensaje de error
  */
  public function index_get(){
    $autores = $this->autores_model->get();

    // Comprobar que la respuesta no sea nulo
    if ( !is_null($autores) ) {
      $this->response( array( 'autores' => $autores), 200 );
    } else {
        $this->response( array('error' => 'No hay autores en la base de datos..'), 404 );
    }
  }

  /**
  * Devuelve un Autor por id
  * return: Json con el instituto solicitado
  * caso contrario un mensaje de error
  */
  public function ver_get( $id ){

    // Comprobar que recibimos un id
    if( !$id ){
      $this->response( null, 400 );
    }

    // Devolver el autor correspondiente al id
    $autor = $this->autores_model->get( $id );

    // Comprobar que la respuesta no sea null
    if( !is_null($autor) ){
      $this->response( array( $autor ), 200 );
    } else{
        $this->response( array( 'error' => "autor no encontrado..."), 404 );
    }

  }

  /**
  * Agrega un Autor
  * Recibe: Cuerpo json atraves de verbo http post
  * return: Json con mensaje positivo
  * caso contrario mensaje de error
  */
  public function index_post(){

    // Comprobar que venga un objeto autor en la peticion
    if( !$this->post() ){
      $this->response( null, 400 );
    }

    $id = $this->autores_model->save( $this->post() );

    // Comprobar que el id tiene informacion
    if( !is_null( $id ) ){
      $this->response( array( 'response' => $id ), 200 );
    } else {
        $this->response( array('error' => "Algo ha falldo en el servidor. No se pudo añadir el autor" ), 400 );
    }
  }

  /**
  * Actualiza un Autor por id
  * return: Json con mensaje positivo
  * caso contrario mensaje de error
  */
  public function actualizar_put( $id ){

    // Si no viene un Autor ó no viene un Id
    if( !$this->put() || !$id ){
      $this->response( null, 400 );
    }

    $update = $this->autores_model->update( $id, $this->put() );

    // Comprobar que venga la informacion
    if( !is_null( $update ) ){
      $this->response( array( 'response' => 'Autor actualizado correctamente..' ), 200 );
    } else {
        $this->response( array('error' => "Algo ha falldo en el servidor. No se pudo editar el autor" ), 400 );
    }
  }

  /**
  * Elimina un Autor por id
  * return: Json con mensaje positivo
  * caso contrario mensaje de error
  */
  public function eliminar_delete( $id ){

    // Comprobar que se reciba un id
    if( !$id ){
      $this->response( null, 400 );
    }

    $delete = $this->autores_model->delete( $id );

    // Comprobar que se haya borrado
    if( !is_null( $delete ) ){
      $this->response( array( 'response' => 'Autor eliminado correctamente..' ), 200 );
    } else {
        $this->response( array( 'error' => 'Algo ha fallado en el servidor. No se pudo borrar el autor'));
    }
  }

}
