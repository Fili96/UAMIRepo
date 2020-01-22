package test.mx.uam.ayd.estetica.negocio;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import mx.uam.ayd.estetica.modelo.Empleado;
import mx.uam.ayd.estetica.negocio.ServicioEmpleado;
import test.mx.uam.ayd.estetica.persistencia.DAOEmpleadoSustituto;

class ServicioEmpleadoTest {
	DAOEmpleadoSustituto daoEmpleado ;
	ServicioEmpleado servicioEmpleado ;
	
	@BeforeEach
	void setUp() throws Exception {
		
		 daoEmpleado = new DAOEmpleadoSustituto();
		 servicioEmpleado = new ServicioEmpleado(daoEmpleado);
		
		//la precondicion será que ya exista un empleado "almacenado en la BD"
		//esto esta realizado en la clase DAOEmpleadoSustituto
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testActualizaEmpleado() {
		//el test consiste en probar el metodo actualizaEmpleado, para ello necesitamos crear un empleado temporal
		//del cual se "copiaran-actualizaran" los datos del ya existente
		
		Empleado empleadoTemporal = new Empleado("Angel","Rebollo","Tlah 85","2017-12-19",100);
		
		
		
		//Caso 1: Si el Empleado con el id 25, pasado como argumento, existe:
		boolean resultado = servicioEmpleado.actualizaEmpleado(empleadoTemporal, 25);
		assertEquals("Valor esperado: TRUE, Sí existe el empleado con el id 25, y se pudo actualizar su informacion",resultado,true);
		
		//Caso 2: Si el Empleado con el id 15 ,pasado como argumento, NO existe:
		resultado= servicioEmpleado.actualizaEmpleado(empleadoTemporal, 15);
		assertEquals("Valor esperado: FALSE, NO existe el empleado con el id 15,  no se logro actualizar su informacion",resultado,false);
		
		

	}
	

}
