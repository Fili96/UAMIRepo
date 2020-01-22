<?php

class Institutos_model extends CI_Model{

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
  private function _setInstituto( $instituto ){

    return array(
      'idInstituto' => $instituto['idInstituto'],
      'instituto' => $instituto['instituto']
     );
  }

  /**
  * Metodo para obtener institutos
  * No Recibe id --> return: todos los institutos
  * Si Recibe id --> return: un instituto correspondiente a el id
  * return: null en caso de error
  */
  public function get( $id = null){

    // Si llega un $id por parametro
    if( !is_null( $id ) ){

      $query = $this->db->select( '*' )->from( 'instituto' )->where( 'idInstituto', $id )->get();

      // Si nos regresa un elemento
      if( $query->num_rows() == 1 ){
        return $query->row_array();
      }

      return null;
    }

    // No ha llegado un id
    $query = $this->db->select( '*' )->from( 'instituto' )->get();

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
  public function save( $instituto ){

    $this->db->set( $this->_setInstituto( $instituto ) )->insert('instituto');

    // Si se ejecuta la consulta
    if($this->db->affected_rows() == 1 ){
      return $this->db->insert_id();
    } else{
      return null;
    }
  }

  /**
  * Metodo para actualizar institutos por id
  * Recibe: El id del instituto a actualizar
  * Return:
  */
  public function update( $id, $instituto ){

       $instituto['idInstituto'] = $id;
       $this->db->set( $this->_setInstituto( $instituto ) )->where( 'idInstituto', $id )->update( 'instituto' );

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
   public function delete($id){

       $this->db->where('idInstituto', $id)->delete('instituto');

       // Si se ejecuta la consulta
       if ($this->db->affected_rows() === 1) {
           return true;
       }
       return null;
   }
}
