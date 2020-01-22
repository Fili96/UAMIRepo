<?php
defined('BASEPATH') OR exit('No direct script access allowed');

/**
 *
 */
class Indices extends CI_Controller
{

  function __construct()
  {
    parent::__construct();
  }

  public function index(){
    $this->load->view('admin/indices/indices');
  }

  public function nuevo(){
    $this->load->view('admin/indices/indice_nuevo');
  }

  public function actualizar( $id ){
    $datos['id'] = $id;
    $this->load->view('admin/indices/indice_actualizar', $datos);
  }

}
