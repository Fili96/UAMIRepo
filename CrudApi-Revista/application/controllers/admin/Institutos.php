<?php
defined('BASEPATH') OR exit('No direct script access allowed');

/**
 *
 */
class Institutos extends CI_Controller
{

  function __construct()
  {
    parent::__construct();
  }

  public function index(){
    $this->load->view('admin/institutos/institutos');
  }

  public function nuevo(){
    $this->load->view('admin/institutos/instituto_nuevo');
  }

  public function actualizar( $id ){
    $datos['id'] = $id;
    $this->load->view('admin/institutos/instituto_actualizar', $datos);
  }

}
