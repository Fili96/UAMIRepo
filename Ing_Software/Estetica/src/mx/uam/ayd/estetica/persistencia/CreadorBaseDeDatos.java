package mx.uam.ayd.estetica.persistencia;


import java.sql.Connection;
import java.sql.Statement;

public class CreadorBaseDeDatos {

	/**
	 * @param args
	 */
	
	public static void main(String[] args)
	{
		try
		{
			//inicia la conexion con la base de datos
			Connection connection = ManejadorBD.dameConnection();
			//inicia el statement para poder usar los querys
			Statement statement = connection.createStatement();
			
			
			//crea tabla Producto en la base de datos y dos productos para prueba
			
			statement.execute("create table Producto(idProducto INTEGER PRIMARY KEY not null GENERATED ALWAYS AS IDENTITY (START WITH 0, INCREMENT BY 1), nombre varchar(40), marca varchar(40), pzaExistencia int, precio int)"); // , CONSTRAINT primary_key PRIMARY KEY (autorId)
			statement.execute("insert into Producto values (DEFAULT,'ninguno','ninguno',0,0)",Statement.RETURN_GENERATED_KEYS);
			statement.execute("insert into Producto values (DEFAULT,'Kit 81', 'Wella', 19,30)",Statement.RETURN_GENERATED_KEYS);
			statement.execute("insert into Producto values (DEFAULT,'LE VERNIS', 'Chanel', 23, 20)",Statement.RETURN_GENERATED_KEYS);

			System.out.println("Tabla de Productos creada exitosamente");
			
			
			//crea tabla Empleado en la base de datos y 5 empleados
			statement.execute("create table Empleado(idEmpleado INTEGER PRIMARY KEY not null GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), nombre varchar(40), apellido varchar(40), domicilio varchar(40), fecha date, sueldo double)"); // , CONSTRAINT primary_key PRIMARY KEY (autorId)
			statement.execute("insert into Empleado values (DEFAULT,'Miriam ','Gomez','Izt num86 cp09645','2017-12-19',120.00)",Statement.RETURN_GENERATED_KEYS);
			statement.execute("insert into Empleado values (DEFAULT,'Dulce','Perez','Izt num10 cp09115','2016-02-11',120.00)",Statement.RETURN_GENERATED_KEYS);
			statement.execute("insert into Empleado values (DEFAULT,'Ricardo Oscar','Hernandez','Azc num86 cp09884','2015-10-10',120.00)",Statement.RETURN_GENERATED_KEYS);
			statement.execute("insert into Empleado values (DEFAULT,'yahir','Lopez','Izt num51 cp09140','2015-09-01',120.00)",Statement.RETURN_GENERATED_KEYS);
			statement.execute("insert into Empleado values (DEFAULT,'Karina','Morales','Coy num15 cp09385','2012-01-9',120.00)",Statement.RETURN_GENERATED_KEYS);
			System.out.println("Tabla de Empleados creada exitosamente");
			
			//crea tabla Trabajo en la base de datos
			statement.execute("create table Trabajo(idTrabajo INTEGER PRIMARY KEY not null GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), nombre varchar(40), idEmpleado int, descripcion varchar(80), monto double, fecha date, idProducto int, pzaUsadas int)"); // , CONSTRAINT primary_key PRIMARY KEY (autorId)
			statement.execute("insert into Trabajo values (DEFAULT,'uñas',1,'No se uso todo el esmalte',150.0,'2017-11-10',1,1)",Statement.RETURN_GENERATED_KEYS);
			statement.execute("insert into Trabajo values (DEFAULT,'Corte',2,'No se uso todo el esmalte',150.0,'2017-11-10',1,1)",Statement.RETURN_GENERATED_KEYS);
			statement.execute("insert into Trabajo values (DEFAULT,'Tinte',2,'Se ocupo el tinte completo',90.0,'2017-10-09',1,1)",Statement.RETURN_GENERATED_KEYS);
			System.out.println("Tabla de Trabajos creada exitosamente");
			
			//crea tabla Cita en la base de datos
			statement.execute("create table Cita(idCita INTEGER PRIMARY KEY not null GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), idEmpleado int, nombreCliente varchar(80), fecha timestamp, descripcion varchar(300))"); // , CONSTRAINT primary_key PRIMARY KEY (autorId)
			statement.execute("insert into Cita values (DEFAULT,1,'angel','2017-12-07 12:00:00','hola')",Statement.RETURN_GENERATED_KEYS);
			statement.execute("insert into Cita values (DEFAULT,2,'esteban','2017-12-07 12:00:00','corte de peluca')",Statement.RETURN_GENERATED_KEYS);
			System.out.println("Tabla de Cita creada exitosamente");
			
			//crea tabla VentaProducto en la base de datos
			statement.execute("create table VentaProducto(idVentaProducto INTEGER PRIMARY KEY not null GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), idProducto int, pzaVendida int, total int)"); // , CONSTRAINT primary_key PRIMARY KEY (autorId)
			statement.execute("insert into VentaProducto values (DEFAULT,1,1,30)",Statement.RETURN_GENERATED_KEYS);
			System.out.println("Tabla de Ventas de Productos creada exitosamente");
			
			//Crea tabla Cuentas
			statement.execute("create table Cuenta(idCuenta INTEGER PRIMARY KEY not null GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), nombre varchar(40), idEmpleado int, contraseña varchar(40) )"); // , CONSTRAINT primary_key PRIMARY KEY (autorId)
			System.out.println("Tabla de Ventas de Cuenta creada exitosamente");
			statement.execute("insert into Cuenta values (DEFAULT,'fili xD',1,'filiberto')",Statement.RETURN_GENERATED_KEYS);
			statement.execute("insert into Cuenta values (DEFAULT,'maryanc',2,'234')",Statement.RETURN_GENERATED_KEYS);
			System.out.println("Tabla de Cuentas creada exitosamente");
			
			statement.execute("create table Proveedor (idProveedor INTEGER PRIMARY KEY not null GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), nombreProveedor varchar(80), descripcion varchar(300), domicilio varchar(300), telefono varchar(300))"); // , CONSTRAINT primary_key PRIMARY KEY (autorId)
			statement.execute("insert into Proveedor values (DEFAULT,'salerm', 'tintes','guayabitos 50', '56985678')",Statement.RETURN_GENERATED_KEYS);
			statement.execute("insert into Proveedor values (DEFAULT,'koleston', 'tintes','alfredo del mazo 50', '56985678')",Statement.RETURN_GENERATED_KEYS);
			//termina la conexion con la base de datos
			
			//Tabla Paquetes

			statement.execute(
					"create table Paquete(idPaquete INTEGER PRIMARY KEY not null GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),nombrePaquete varchar(40),descripcion varchar(200),puntos varchar(10))");
			statement.execute(
					"insert into Paquete values (DEFAULT,'paquete1','corte de cabello con 15% de descuento','1-15')",
					Statement.RETURN_GENERATED_KEYS);
			statement.execute(
					"insert into Paquete values (DEFAULT,'paquete2','corte de cabello tinte 20% de descuento','15-20')",
					Statement.RETURN_GENERATED_KEYS);
			statement.execute(
					"insert into Paquete values (DEFAULT,'paquete3','corte de cabello con tinte mas uñas 30% de descuento','20-30')",
					Statement.RETURN_GENERATED_KEYS);
			System.out.println("Tabla de Paquete creada exitosamente");

			
			
			
			ManejadorBD.termina();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}




	}

}
