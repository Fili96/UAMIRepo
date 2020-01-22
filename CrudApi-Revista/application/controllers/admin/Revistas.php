<?php
defined('BASEPATH') OR exit('No direct script access allowed');

/**
 *
 */
class Revistas extends CI_Controller
{

  function __construct()
  {
    parent::__construct();
  }

  public function index(){
    $this->load->view('admin/revistas/revistas');
  }


    public function nuevo(){
      $this->load->view('admin/revistas/revista_nuevo');
    }

    public function actualizar( $id ){
      $datos['id'] = $id;
      $this->load->view('admin/revistas/revista_actualizar', $datos);
    }

}
