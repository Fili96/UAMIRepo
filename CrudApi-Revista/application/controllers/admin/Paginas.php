<?php
defined('BASEPATH') OR exit('No direct script access allowed');

/**
 *
 */
class Paginas extends CI_Controller
{

  function __construct()
  {
    parent::__construct();
  }

  public function index(){
    $this->load->view('admin/paginas/paginas');
  }

  public function nuevo(){
    $this->load->view('admin/paginas/pagina_nuevo');
  }

  public function actualizar( $id ){
    $datos['id'] = $id;
    $this->load->view('admin/Paginas/pagina_actualizar', $datos);
  }

}
