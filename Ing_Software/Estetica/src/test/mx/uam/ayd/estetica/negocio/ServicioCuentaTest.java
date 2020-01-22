package test.mx.uam.ayd.estetica.negocio;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import mx.uam.ayd.estetica.negocio.ServicioCuenta;
import test.mx.uam.ayd.estetica.persistencia.DAOCuentasSustituto;

class ServicioCuentaTest {
	
	ServicioCuenta ser;
	DAOCuentasSustituto dao = new DAOCuentasSustituto();

	@BeforeEach
	void setUp() throws Exception {
		ser= new ServicioCuenta(dao);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testValidaCuentaAdmin() {
		
		//CASO POSITIVO
		boolean resultado = ser.validaCuentaAdmin("miriam", "123");
		assertEquals("esperaba un true ya que SI ES la cuenta del administrador",resultado,true);
		
		//CASO NEGATIVO
		resultado= ser.validaCuentaAdmin("cuenta", "contraseña");
		assertEquals("esperaba un false ya que NO ES la cuenta del administrador",resultado,false);
		
	}

	@Test
	void testValidaCuentaUsuario() {
		
		//CASO POSITIVO
		boolean resultado = ser.validaCuentaUsuario("fili xD", "filiberto");
		assertEquals("esperaba un true ya que SI ES una cuenta de usuario",resultado,true);
		
		//CASO NEGATIVO
		resultado = ser.validaCuentaUsuario("cuenta", "contraseña");
		assertEquals("esperaba un false ya que NO ES una cuenta de usuario",resultado,false);
		
		
	}

}
