<?php
defined('BASEPATH') OR exit('No direct script access allowed');

/**
 *
 */
class Revista_Autor extends CI_Controller
{

  function __construct()
  {
    parent::__construct();
  }

  public function index(){
    $this->load->view('admin/revistas-autores/revistas_autores');
  }

  public function nuevo(){
    $this->load->view('admin/revistas-autores/revista_autor_nuevo');
  }

  public function actualizar( $idAutor, $idRevista ){
    $datos['idAutor'] = $idAutor;
    $datos['idRevista'] = $idRevista;
    $this->load->view('admin/revistas-autores/revista_autor_actualizar', $datos);
  }

}
