<?php

class Rautor_model extends CI_Model{

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
  private function _setRev_Aut( $rev_aut ){

    return array(
      'author' => $rev_aut['author'],
      'revista' => $rev_aut['revista'],
      'articuloEscrito' => $rev_aut['articuloEscrito']
     );
  }

  /**
  * Metodo para obtener institutos
  * No Recibe id --> return: todos los institutos
  * Si Recibe id --> return: un instituto correspondiente a el id
  * return: null en caso de error
  */
  public function get( $idAutor = null, $idRevista = null ){

    // Si llega un $id por parametro
    if( !is_null( $idAutor ) and !is_null( $idRevista ) ){

      $query = $this->db->select( '*' )
                        ->from( 'revista_author' )
                        ->where( 'author', $idAutor )
                        ->where( 'revista', $idRevista )
                        ->get();

      // Si nos regresa un elemento
      if( $query->num_rows() == 1 ){
        return $query->row_array();
      }

      return null;
    }

    // No ha llegado un id
    $query = $this->db->select( '*' )->from( 'revista_author' )->get();

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
  public function save( $rev_aut ){

    $this->db->set( $this->_setRev_Aut( $rev_aut ) )->insert('revista_author');

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
  public function update( $idAutor, $idRevista, $rev_aut ){

       $rev_aut['author'] = $idAutor;
       $rev_aut['revista'] = $idRevista;

       $this->db->set( $this->_setRev_Aut( $rev_aut ) )
                  ->where( 'author', $idAutor )
                  ->where( 'revista', $idRevista )
                  ->update( 'revista_author' );

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
   public function delete( $idAutor, $idRevista ){

       $this->db->where('author', $idAutor)
                ->where('revista', $idRevista)
                ->delete('revista_author');

       // Si se ejecuta la consulta
       if ($this->db->affected_rows() === 1) {
           return true;
       }
       return null;
   }

}
