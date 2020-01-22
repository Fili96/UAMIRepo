<?php

class Indices_model extends CI_Model{

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
  private function _setIndice( $indice ){

    return array(
      'idIndice' => $indice['idIndice'],
      'nombre' => $indice['nombre']
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

      $query = $this->db->select( '*' )->from( 'indice' )->where( 'idIndice', $id )->get();

      // Si nos regresa un elemento
      if( $query->num_rows() == 1 ){
        return $query->row_array();
      }

      return null;
    }

    // No ha llegado un id
    $query = $this->db->select( '*' )->from( 'indice' )->get();

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
  public function save( $indice ){

    $this->db->set( $this->_setIndice( $indice ) )->insert('indice');

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
  public function update( $id, $indice ){

       $indice['idIndice'] = $id;
       $this->db->set( $this->_setIndice( $indice ) )->where( 'idIndice', $id )->update( 'indice' );

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

       $this->db->where('idIndice', $id)->delete('indice');

       // Si se ejecuta la consulta
       if ($this->db->affected_rows() === 1) {
           return true;
       }
       return null;
   }
}
