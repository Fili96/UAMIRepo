<?php

class Rarbitro_model extends CI_Model{

  /**
  * Constructor
  */
  function __construct()
  {
    parent::__construct();
  }

  /**
  * Metodo de ayuda para setear un instituto
  * Recibe: un objeto instituto
  * Return: el objeto seteado
  */
  private function _setRev_Arbitro( $rev_arbitro ){

    return array(
      'arbitro' => $rev_arbitro['arbitro'],
      'revista' => $rev_arbitro['revista'],
      'articuloRevisado' => $rev_arbitro['articuloRevisado']
     );
  }

  /**
  * Metodo para obtener institutos
  * No Recibe id --> return: todos los institutos
  * Si Recibe id --> return: un instituto correspondiente a el id
  * return: null en caso de error
  */
  public function get( $idArbitro = null, $idRevista = null ){

    // Si llega un $id por parametro
    if( !is_null( $idArbitro ) and !is_null( $idRevista ) ){

      $query = $this->db->select( '*' )
                        ->from( 'revista_arbitro' )
                        ->where( 'arbitro', $idArbitro )
                        ->where( 'revista', $idRevista )
                        ->get();

      // Si nos regresa un elemento
      if( $query->num_rows() == 1 ){
        return $query->row_array();
      }

      return null;
    }

    // No ha llegado un id
    $query = $this->db->select( '*' )->from( 'revista_arbitro' )->get();

    // Comprobar si regresa elementos
    if( $query->num_rows() > 0 ){
      return $query->result_array();
    }

    return null;
  }

  /**
  * Metodo para Agregar un instituto
  * Recibe: El instituto a agregar
  * Return:
  */
  public function save( $rev_arbitro ){

    $this->db->set( $this->_setRev_Arbitro( $rev_arbitro ) )->insert('revista_arbitro');

    // Si se ejecuta la consulta
    if($this->db->affected_rows() == 1 ){
      return $this->db->insert_id();
    }

    else {
      return null;
    }
  }

  /**
  * Metodo para actualizar institutos por id
  * Recibe: El id del instituto a actualizar
  * Return:
  */
  public function update( $idArbitro, $idRevista, $rev_arbitro ){

       $rev_arbitro['arbitro'] = $idArbitro;
       $rev_arbitro['revista'] = $idRevista;

       $this->db->set( $this->_setRev_Arbitro( $rev_arbitro ) )
                  ->where( 'arbitro', $idArbitro )
                  ->where( 'revista', $idRevista )
                  ->update( 'revista_arbitro' );

       // Si se ejecuta la consulta
       if ($this->db->affected_rows() == 1) {
           return true;
       }
       return null;
   }

   /**
   * Metodo para Eliminar un instituto por id
   * Recibe: El id del instituto a borrar
   * Return:
   */
   public function delete( $idArbitro, $idRevista ){

       $this->db->where('arbitro', $idArbitro)
                ->where('revista', $idRevista)
                ->delete('revista_arbitro');

       // Si se ejecuta la consulta
       if ($this->db->affected_rows() === 1) {
           return true;
       }
       return null;
   }

}
