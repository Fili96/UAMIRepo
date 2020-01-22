package test.mx.uam.ayd.estetica.negocio;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import mx.uam.ayd.estetica.modelo.Trabajo;
import mx.uam.ayd.estetica.negocio.ServicioTrabajo;
import test.mx.uam.ayd.estetica.persistencia.DAOTrabajoSustituto;

class ServicioTrabajoTest {

	ServicioTrabajo ST;
	DAOTrabajoSustituto DTS = new DAOTrabajoSustituto();
	
	@BeforeEach
	void setUp() throws Exception {
		ST = new ServicioTrabajo(DTS);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testdameNumeroTrabajos() {
		//Provamos el metodo que recupera todos los trabajos de un empleado
		//mandamos un id de empleado cualquiera y los guardamos en una variable
		int trabajos=0;
		//Caso 1: el emplado con id 0 si existe
		trabajos=ST.dameNumeroTrabajos(0);
		//Como existen 2 trabajos deberia regresar los dos
		assertEquals(2, trabajos,"el empleado no tenia trabajos");
		
		//Caso 2: el emplado con id tres no existe
		trabajos=ST.dameNumeroTrabajos(3);
		//Deberia regresar un areglo de tamaño 0
		assertEquals(0, 0, "El empleado si tenia trabajos");
	}

}
