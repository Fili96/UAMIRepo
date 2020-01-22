<?php
defined('BASEPATH') OR exit('No direct script access allowed');
require APPPATH . '/libraries/REST_Controller.php';
use Restserver\Libraries\REST_Controller;
require APPPATH . 'libraries/Format.php';

class Revistas_Autores extends REST_Controller {

  /**
  * Constructor
  */
  function __construct(){
    parent::__construct();
    $this->load->model('rautor_model');
  }

  /**
  * Metodo para obtener Todos los revista_autores
  * return: Json con los revista_autores
  * caso contrario un mensaje de error
  */
  public function index_get(){
    $rev_aut = $this->rautor_model->get();

    $this->response( array( 'revistas-autores' => $rev_aut), 200 );

    // Comprobar que la respuesta no sea nulo
    if ( !is_null($rev_aut) ) {
      $this->response( array( 'revistas-autores' => $rev_aut), 200 );
    } else {
        $this->response( array('error' => 'No hay revistas-autores en la base de datos..'), 404 );
    }
  }

  /**
  * Devuelve un revista_author por id
  * return: Json con el revista_author solicitado
  * caso contrario un mensaje de error
  */
  public function ver_get( $idAutor, $idRevista ){

    // Comprobar que recibimos los id
    if( !$idAutor || !$idRevista ){
      $this->response( array( 'error' => "problemas al recibir el id del autor y revista"), 400 );
    }

    // Devolver el revista_author correspondiente al id
    $rev_aut = $this->rautor_model->get( $idAutor, $idRevista );

    // Comprobar que la respuesta no sea null
    if( !is_null($rev_aut) ){
      $this->response( array( $rev_aut ), 200 );
    } else{
        $this->response( array( 'error' => "Revista-Autor no encontrado..."), 404 );
    }

  }

  /**
  * Agrega un revista_author
  * Recibe: Cuerpo json atraves de verbo htto post
  * return: Json con mensaje positivo
  * caso contrario mensaje de error
  */
  public function index_post(){

    // Comprobar que venga un objeto revista_author en la peticion
    if( !$this->post() ){
      $this->response( null, 400 );
    }

    $id = $this->rautor_model->save( $this->post() );

    // Comprobar que el id tiene informacion
    if( !is_null( $id ) ){
      $this->response( array( 'response' => "True" ), 200 );
    }

    else {
        $this->response( array('error' => "Algo ha falldo en el servidor. No se pudo añadir revista-autor" ), 400 );
    }
  }


  /**
  * Actualiza un revista_author por id
  * return: Json con mensaje positivo
  * caso contrario mensaje de error
  */
  public function actualizar_put( $idAutor, $idRevista ){

    if( !$this->put() ){
      $this->response( array( 'error' => "problemas al recibir los nuevos datos"), 400 );
    }

    // Si no viene un objeto, autor ó revista
    if( !$idAutor || !$idRevista ){
      $this->response( array( 'error' => "problemas con id del autor y revista, asegurate de pasar ambos parametros"), 400 );
    }

    $update = $this->rautor_model->update( $idAutor, $idRevista, $this->put() );

    // Comprobar que venga la informacion
    if( !is_null( $update ) ){
      $this->response( array( 'response' => 'revista_author actualizado correctamente..' ), 200 );
    } else {
        $this->response( array('error' => "Algo ha falldo en el servidor. No se pudo editar el revista_author" ), 400 );
    }
  }

  /**
  * Elimina un revista-autor por id
  * return: Json con mensaje positivo
  * caso contrario mensaje de error
  */
  public function eliminar_delete( $idAutor, $idRevista ){

    // Si no viene un objeto, autor ó revista
    if( !$idAutor || !$idRevista ){
      $this->response( array( 'error' => "problemas con id del autor y revista, asegurate de pasar ambos parametros"), 400 );
    }

    $delete = $this->rautor_model->delete( $idAutor, $idRevista );

    // Comprobar que se haya borrado
    if( !is_null( $delete ) ){
      $this->response( array( 'response' => 'revista-autor eliminado correctamente..' ), 200 );
    } else {
        $this->response( array( 'error' => 'Algo ha fallado en el servidor. No se pudo borrar el revista-autor'));
    }
  }

}
