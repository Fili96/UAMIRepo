<?php
defined('BASEPATH') OR exit('No direct script access allowed');

/**
 *
 */
class Revista_Arbitro extends CI_Controller
{

  function __construct()
  {
    parent::__construct();
  }

  public function index(){
    $this->load->view('admin/revistas-arbitros/revistas_arbitros');
  }

  public function nuevo(){
    $this->load->view('admin/revistas-arbitros/revista_arbitro_nuevo');
  }

  public function actualizar( $idArbitro, $idRevista ){
    $datos['idArbitro'] = $idArbitro;
    $datos['idRevista'] = $idRevista;
    $this->load->view('admin/revistas-arbitros/revista_arbitro_actualizar', $datos);
  }

}
