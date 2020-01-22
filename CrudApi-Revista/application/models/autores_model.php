<?php

class Autores_model extends CI_Model{

  /**
  * Constructor
  */
  function __construct()
  {
    parent::__construct();
  }

  /**
  * Metodo de ayuda para setear un autor
  * Recibe: un objeto autor
  * Return: el objeto seteado
  */
  private function _setAutor( $autor ){

    return array(
      'idAuthor' => $autor['idAuthor'],
      'nombreAuthor' => $autor['nombreAuthor'],
      'apat' => $autor['apat'],
      'amat' => $autor['amat'],
      'edad' => $autor['edad'],
      'correo' => $autor['correo'],
      'Instituto_idInstituto' => $autor['Instituto_idInstituto'],
      'Comite_idComite' => $autor['Comite_idComite']
     );
  }

  /**
  * Metodo para obtener autores
  * No Recibe id --> return: todos los autores
  * Si Recibe id --> return: un autor correspondiente a el id
  * return: null en caso de error
  */
  public function get( $id = null){

    // Si llega un $id por parametro
    if( !is_null( $id ) ){

      $query = $this->db->select( '*' )->from( 'author' )->where( 'idAuthor', $id )->get();

      // Si nos regresa un elemento
      if( $query->num_rows() == 1 ){
        return $query->row_array();
      }

      return null;
    }

    // No ha llegado un id
    $query = $this->db->select( '*' )->from( 'author' )->get();

    // Comprobar si regresa elementos
    if( $query->num_rows() > 0 ){
      return $query->result_array();
    }

    return null;
  }

  /**
  * Metodo para Agregar un autor
  * Recibe: El autor a agregar
  * Return:
  */
  public function save( $autor ){

    $this->db->set( $this->_setAutor( $autor ) )->insert('author');

    // Si se ejecuta la consulta
    if($this->db->affected_rows() == 1 ){
      return $this->db->insert_id();
    } else{
      return null;
    }
  }

  /**
  * Metodo para actualizar autores por id
  * Recibe: El id del autor a actualizar
  * Return:
  */
  public function update( $id, $autor ){

       $autor['idAuthor'] = $id;
       $this->db->set( $this->_setAutor( $autor ) )->where( 'idAuthor', $id )->update( 'author' );

       // Si se ejecuta la consulta
       if ($this->db->affected_rows() == 1) {
           return true;
       }
       return null;
   }

   /**
   * Metodo para Eliminar un autor por id
   * Recibe: El id del autor a borrar
   * Return:
   */
   public function delete($id){

       $this->db->where('idAuthor', $id)->delete('author');

       // Si se ejecuta la consulta
       if ($this->db->affected_rows() === 1) {
           return true;
       }
       return null;
   }
}
