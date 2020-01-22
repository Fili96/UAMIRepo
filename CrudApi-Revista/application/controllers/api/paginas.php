<?php
defined('BASEPATH') OR exit('No direct script access allowed');
require APPPATH . '/libraries/REST_Controller.php';
use Restserver\Libraries\REST_Controller;
require APPPATH . 'libraries/Format.php';

class Paginas extends REST_Controller {

  /**
  * Constructor
  */
  function __construct(){
    parent::__construct();
    $this->load->model('paginas_model');
  }

  /**
  * Metodo para obtener Todos los paginas
  * return: Json con los paginas
  * caso contrario un mensaje de error
  */
  public function index_get(){
    $paginas = $this->paginas_model->get();

    // Comprobar que la respuesta no sea nulo
    if ( !is_null($paginas) ) {
      $this->response( array( 'paginas' => $paginas), 200 );
    } else {
        $this->response( array('error' => 'No hay paginas en la base de datos..'), 404 );
    }
  }

  /**
  * Devuelve un pagina por id
  * return: Json con el instituto solicitado
  * caso contrario un mensaje de error
  */
  public function ver_get( $id ){

    // Comprobar que recibimos un id
    if( !$id ){
      $this->response( null, 400 );
    }

    // Devolver el pagina correspondiente al id
    $pagina = $this->paginas_model->get( $id );

    // Comprobar que la respuesta no sea null
    if( !is_null($pagina) ){
      $this->response( array( $pagina ), 200 );
    } else{
        $this->response( array( 'error' => "pagina no encontrado..."), 404 );
    }

  }

  /**
  * Agrega un pagina
  * Recibe: Cuerpo json atraves de verbo http post
  * return: Json con mensaje positivo
  * caso contrario mensaje de error
  */
  public function index_post(){

    // Comprobar que venga un objeto pagina en la peticion
    if( !$this->post() ){
      $this->response( null, 400 );
    }

    $id = $this->paginas_model->save( $this->post() );

    // Comprobar que el id tiene informacion
    if( !is_null( $id ) ){
      $this->response( array( 'response' => $id ), 200 );
    } else {
        $this->response( array('error' => "Algo ha falldo en el servidor. No se pudo añadir la pagina" ), 400 );
    }
  }

  /**
  * Actualiza un pagina por id
  * return: Json con mensaje positivo
  * caso contrario mensaje de error
  */
  public function actualizar_put( $id ){

    // Si no viene un pagina ó no viene un Id
    if( !$this->put() || !$id ){
      $this->response( null, 400 );
    }

    $update = $this->paginas_model->update( $id, $this->put() );

    // Comprobar que venga la informacion
    if( !is_null( $update ) ){
      $this->response( array( 'response' => 'pagina actualizada correctamente..' ), 200 );
    } else {
        $this->response( array('error' => "Algo ha falldo en el servidor. No se pudo editar la pagina" ), 400 );
    }
  }

  /**
  * Elimina un pagina por id
  * return: Json con mensaje positivo
  * caso contrario mensaje de error
  */
  public function eliminar_delete( $id ){

    // Comprobar que se reciba un id
    if( !$id ){
      $this->response( null, 400 );
    }

    $delete = $this->paginas_model->delete( $id );

    // Comprobar que se haya borrado
    if( !is_null( $delete ) ){
      $this->response( array( 'response' => 'pagina eliminada correctamente..' ), 200 );
    } else {
        $this->response( array( 'error' => 'Algo ha fallado en el servidor. No se pudo borrar la pagina'));
    }
  }

}
