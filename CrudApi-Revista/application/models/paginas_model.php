<?php

class Paginas_model extends CI_Model{

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
  private function _setPagina( $pagina ){

    return array(
      'idPagina' => $pagina['idPagina'],
      'titulo' => $pagina['titulo'],
      'numero' => $pagina['numero'],
      'Indice_idIndice' => $pagina['Indice_idIndice']
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

      $query = $this->db->select( '*' )->from( 'pagina' )->where( 'idPagina', $id )->get();

      // Si nos regresa un elemento
      if( $query->num_rows() == 1 ){
        return $query->row_array();
      }

      return null;
    }

    // No ha llegado un id
    $query = $this->db->select( '*' )->from( 'pagina' )->get();

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
  public function save( $pagina ){

    $this->db->set( $this->_setPagina( $pagina ) )->insert('pagina');

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
  public function update( $id, $pagina ){

       $pagina['idPagina'] = $id;
       $this->db->set( $this->_setPagina( $pagina ) )->where( 'idPagina', $id )->update( 'pagina' );

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

       $this->db->where('idPagina', $id)->delete('pagina');

       // Si se ejecuta la consulta
       if ($this->db->affected_rows() === 1) {
           return true;
       }
       return null;
   }
}
