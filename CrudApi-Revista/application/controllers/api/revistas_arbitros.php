<?php
defined('BASEPATH') OR exit('No direct script access allowed');
require APPPATH . '/libraries/REST_Controller.php';
use Restserver\Libraries\REST_Controller;
require APPPATH . 'libraries/Format.php';

class Revistas_Arbitros extends REST_Controller {

  /**
  * Constructor
  */
  function __construct(){
    parent::__construct();
    $this->load->model('rarbitro_model');
  }

  /**
  * Metodo para obtener Todos los revista_arbitros
  * return: Json con los revista_arbitros
  * caso contrario un mensaje de error
  */
  public function index_get(){
    $rev_arbitro = $this->rarbitro_model->get();

    $this->response( array( 'revistas-arbitros' => $rev_arbitro), 200 );

    // Comprobar que la respuesta no sea nulo
    if ( !is_null($rev_arbitro) ) {
      $this->response( array( 'revistas-arbitros' => $rev_arbitro), 200 );
    } else {
        $this->response( array('error' => 'No hay revistas-arbitros en la base de datos..'), 404 );
    }
  }

  /**
  * Devuelve un revista_arbitro por id
  * return: Json con el revista_arbitro solicitado
  * caso contrario un mensaje de error
  */
  public function ver_get( $idArbitro, $idRevista ){

    // Comprobar que recibimos los id
    if( !$idArbitro || !$idRevista ){
      $this->response( array( 'error' => "problemas al recibir el id del arbitro y revista"), 400 );
    }

    // Devolver el revista_arbitro correspondiente al id
    $rev_arbitro = $this->rarbitro_model->get( $idArbitro, $idRevista );

    // Comprobar que la respuesta no sea null
    if( !is_null($rev_arbitro) ){
      $this->response( array( $rev_arbitro ), 200 );
    } else{
        $this->response( array( 'error' => "Revista-Arbitro no encontrado..."), 404 );
    }

  }

  /**
  * Agrega un revista_arbitro
  * Recibe: Cuerpo json atraves de verbo htto post
  * return: Json con mensaje positivo
  * caso contrario mensaje de error
  */
  public function index_post(){

    // Comprobar que venga un objeto revista_arbitro en la peticion
    if( !$this->post() ){
      $this->response( null, 400 );
    }

    // $idArbitro = $this->input->post('author');
    // $idRevista = $this->input->post('revista');

    $id = $this->rarbitro_model->save( $this->post() );

    // Comprobar que el id tiene informacion
    if( !is_null( $id ) ){
      $this->response( array( 'response' => "True" ), 200 );
    }

    else {
        $this->response( array('error' => "Algo ha falldo en el servidor. No se pudo añadir revista-arbitro" ), 400 );
    }
  }


  /**
  * Actualiza un revista_arbitro por id
  * return: Json con mensaje positivo
  * caso contrario mensaje de error
  */
  public function actualizar_put( $idArbitro, $idRevista ){

    if( !$this->put() ){
      $this->response( array( 'error' => "problemas al recibir los nuevos datos"), 400 );
    }

    // Si no viene un objeto, arbitro ó revista
    if( !$idArbitro || !$idRevista ){
      $this->response( array( 'error' => "problemas con id del arbitro y revista, asegurate de pasar ambos parametros"), 400 );
    }

    $update = $this->rarbitro_model->update( $idArbitro, $idRevista, $this->put() );

    // Comprobar que venga la informacion
    if( !is_null( $update ) ){
      $this->response( array( 'response' => 'revista_arbitro actualizado correctamente..' ), 200 );
    } else {
        $this->response( array('error' => "Algo ha falldo en el servidor. No se pudo editar el revista_arbitro" ), 400 );
    }
  }

  /**
  * Elimina un revista-arbitro por id
  * return: Json con mensaje positivo
  * caso contrario mensaje de error
  */
  public function eliminar_delete( $idArbitro, $idRevista ){

    // Si no viene un objeto, arbitro ó revista
    if( !$idArbitro || !$idRevista ){
      $this->response( array( 'error' => "problemas con id del arbitro y revista, asegurate de pasar ambos parametros"), 400 );
    }

    $delete = $this->rarbitro_model->delete( $idArbitro, $idRevista );

    // Comprobar que se haya borrado
    if( !is_null( $delete ) ){
      $this->response( array( 'response' => 'revista-arbitro eliminado correctamente..' ), 200 );
    } else {
        $this->response( array( 'error' => 'Algo ha fallado en el servidor. No se pudo borrar el revista-arbitro'));
    }
  }

}
