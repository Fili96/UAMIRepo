<?php
defined('BASEPATH') OR exit('No direct script access allowed');

/**
 *
 */
class Autores extends CI_Controller
{

  function __construct()
  {
    parent::__construct();
  }

  public function index(){
    $this->load->view('admin/autores/autores');
  }

  public function nuevo(){
    $this->load->view('admin/autores/autor_nuevo');
  }

  public function actualizar( $id ){
    $datos['id'] = $id;
    $this->load->view('admin/autores/autor_actualizar', $datos);
  }

}
