<?php

class Comites_model extends CI_Model{

  /**
  * Constructor
  */
  function __construct()
  {
    parent::__construct();
  }

  /**
  * Metodo de ayuda para setear un comite
  * Recibe: un objeto comite
  * Return: el objeto seteado
  */
  private function _setComite( $comite ){

    return array(
      'idComite' => $comite['idComite'],
      'nombre' => $comite['nombre'],
      'anioInicio' => $comite['anioInicio'],
      'anioTermino' => $comite['anioTermino']
     );
  }

  /**
  * Metodo para obtener comites
  * No Recibe id --> return: todos los comites
  * Si Recibe id --> return: un comite correspondiente a el id
  * return: null en caso de error
  */
  public function get( $id = null){

    // Si llega un $id por parametro
    if( !is_null( $id ) ){

      $query = $this->db->select( '*' )->from( 'comite' )->where( 'idComite', $id )->get();

      // Si nos regresa un elemento
      if( $query->num_rows() == 1 ){
        return $query->row_array();
      }

      return null;
    }

    // No ha llegado un id
    $query = $this->db->select( '*' )->from( 'comite' )->get();

    // Comprobar si regresa elementos
    if( $query->num_rows() > 0 ){
      return $query->result_array();
    }

    return null;
  }

  /**
  * Metodo para Agregar un comite
  * Recibe: El comite a agregar
  * Return:
  */
  public function save( $comite ){

    $this->db->set( $this->_setComite( $comite ) )->insert('comite');

    // Si se ejecuta la consulta
    if($this->db->affected_rows() == 1 ){
      return $this->db->insert_id();
    } else{
      return null;
    }
  }

  /**
  * Metodo para actualizar comite por id
  * Recibe: El id del comite a actualizar
  * Return:
  */
  public function update( $id, $comite ){

       $comite['idComite'] = $id;
       $this->db->set( $this->_setComite( $comite ) )->where( 'idComite', $id )->update( 'comite' );

       // Si se ejecuta la consulta
       if ($this->db->affected_rows() == 1) {
           return true;
       }
       return null;
   }

   /**
   * Metodo para Eliminar un comite por id
   * Recibe: El id del comite a borrar
   * Return:
   */
   public function delete($id){

       $this->db->where('idComite', $id)->delete('comite');

       // Si se ejecuta la consulta
       if ($this->db->affected_rows() === 1) {
           return true;
       }
       return null;
   }
}
