<?php

class Revistas_model extends CI_Model{

  /**
  * Constructor
  */
  function __construct()
  {
    parent::__construct();
  }


  /**
  * Metodo para obtener revistas
  * No Recibe id --> return: todas las revistas
  * Si Recibe id --> return: una revista correspondiente a el id
  * return: null en caso de error
  */
  public function get( $id = null){

    // Si llega un $id por parametro
    if( !is_null( $id ) ){

      $query = $this->db->select( '*' )->from( 'revista' )->where( 'numero', $id )->get();

      // Si nos regresa un elemento
      if( $query->num_rows() == 1 ){
        return $query->row_array();
      }

      return null;
    }

    // No ha llegado un id
    $query = $this->db->select( '*' )->from( 'revista' )->get();

    // Comprobar si regresa elementos
    if( $query->num_rows() > 0 ){
      return $query->result_array();
    }

    return null;
  }

  /**
  * Metodo para Agregar una revista
  * Recibe: La revista a agregar
  * Return:
  */
  public function save( $revista ){

    $this->db->set( $revista )->insert('revista');

    // Si se ejecuta la consulta
    if($this->db->affected_rows() == 1 ){
      return $this->db->insert_id();
    } else{
      return null;
    }
  }

  /**
  * Metodo para actualizar revista por id
  * Recibe: El id de la revista a actualizar
  * Return:
  */
  public function update( $id, $revista ){

       $revista['numero'] = $id;
       $this->db->set( $revista )->where( 'numero', $id )->update( 'revista' );

       // Si se ejecuta la consulta
       if ($this->db->affected_rows() == 1) {
           return true;
       }
       return null;
   }

   /**
   * Metodo para Eliminar una revista por id
   * Recibe: El id de la revista a borrar
   * Return:
   */
   public function delete($id){

       $this->db->where('numero', $id)->delete('revista');

       // Si se ejecuta la consulta
       if ($this->db->affected_rows() === 1) {
           return true;
       }
       return null;
   }
}
