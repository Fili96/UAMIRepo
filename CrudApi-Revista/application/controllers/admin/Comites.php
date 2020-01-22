<?php
defined('BASEPATH') OR exit('No direct script access allowed');

/**
 *
 */
class Comites extends CI_Controller
{

  function __construct()
  {
    parent::__construct();
  }

  public function index(){
    $this->load->view('admin/comites/comites');
  }

  public function nuevo(){
    $this->load->view('admin/comites/comite_nuevo');
  }

  public function actualizar( $id ){
    $datos['id'] = $id;
    $this->load->view('admin/comites/comite_actualizar', $datos);
  }

}
