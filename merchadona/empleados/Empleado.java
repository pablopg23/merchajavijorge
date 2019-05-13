package merchadona.empleados;
/**
 * 
 * Los empleados son de dos tipos, cajeros y reponedores, los cajeros venderán y los reponedores añaden stock a los productos. 
 * Todos los empleados tienen un nombre, y un id (número) que los identifica..
 * 
 * El empleado número 1 no se puede dar de alta porque será el administrador, esté será el encargado de dar de alta empleados y productos.
 * Los empleados se guardarán en un HashMap en el cual se pondrá de índice el id del empleado.
 *
 * La clase Empleado no funciona como una clase abstracta, porque si que creamos un 
 * Empleado generico, el que tiene el Hash 1, y funciona como un administrador.
 * Crear una clase Administrador que herede de empleado vacia no me parece practico
 * para la estructura que tengo del programa. Si los metodos de Administrador fueran
 * inherentes a su clase, seria viable e incluso recomendable; pero como el caso es
 * diferente, es mas conveniente dejarlo como esta.
 * 
 * @author Jorge y Javi
 *
 */
import merchadona.Merchadona;
import merchadona.productos.*;


public class Empleado {
	/**
	 * Atributos: String nombre e int hash
	 */
	//Atributos
	
	String nombre;
	public int hash;
	
	//Métodos
	/**
	 * Constructor de la clase Empleado
	 * @param nombre : nombre del Empleado
	 * @param hash   : id del Empleado
	 */
	public Empleado (String nombre, int hash) {
		this.nombre = nombre;
		this.hash = hash;
	}
	
	/**
	 * Si eres el empleado con el hash numero 1, puedes utilizar este
	 * método. En caso de que puedas, das de alta un empleado en la lista
	 * de empleados
	 * @return b : true cuando pueda dar de alta el empleado y false cuando no 
	 */
	public boolean altaEmpleado (String nombre, String tipo) {
		boolean b=false;
		char comp = tipo.toLowerCase().charAt(0);
		int tamanio = Merchadona.empleados.size()+1;
		
		if (this.hash == 1) {
			if (comp == 'c') {
				Merchadona.empleados.put(tamanio, 
						new Cajero(nombre, tamanio));
				b=true;
			}
			else if (comp == 'r') {
				Merchadona.empleados.put(tamanio, 
						new Reponedor(nombre, tamanio));
				b=true;
			}
			else {
				System.out.println("Tiene que ser un empleado valido");
			}
			
		}
		else {
			System.out.println("Este empleado no tiene permisos");
		}
		return b;
	}
	/**
	 * Metodo para dar de alta un producto
	 * @param nombre : nombre del producto
	 * @param precio : precio del producto
	 * @param tipo   : perecedero o imperecedero
	 * @return b	 : true si se puede dar de alta el producto y false si no (producto no valido o empleado sin permisos)
	 */
	public boolean altaProducto (String nombre, double precio, String tipo) {
		boolean b= false;
		char comp = tipo.toLowerCase().charAt(0);
		if (this.hash == 1) {
			if (comp == 'p') {
				Merchadona.productos.add(new Perecedero(nombre, precio));
				b= true;
			}
			else if (comp == 'i') {
				Merchadona.productos.add(new Imperecedero(nombre, precio));
				b= true;
			}
			else {
				System.out.println("Tiene que ser un producto valido");
				
			}			
		}
		else {
			System.out.println("Este empleado no tiene permisos");
		
		}
		return b;
	}
	/**
	 * Metodo que muestra una lista de los cajeros y el total de dinero de sus ventas
	 */
	public void listarCajeros() {
		
		if (this.hash == 1) {
			//Se tiene que recorrer el array de empleados
			//Comprobar si la clase del V es cajero
			//En ese caso, se imprime el nombre y la cantidad
			for (int i=1; i<=Merchadona.empleados.size(); i++) {
				Empleado empleadito = Merchadona.empleados.get(i);
				if(empleadito.getClass() == Cajero.class) {
					Cajero cajerito = (Cajero) empleadito;
					System.out.println(cajerito.nombre + " -- " + cajerito.getTotal_ventas());
				}
				}
		}
		else {
			System.out.println("Este empleado no tiene permisos");
		}
	}
	/**
	 * Metodo que da de baja un producto
	 * @param number : numero del producto a dar de baja
	 */
	public void bajaProducto(int number) {
		if (this.hash == 1) {
			Merchadona.productos.remove(number);
		}
		else {}
	}
	/**
	 * Metodo que da de baja un empleado
	 * @param number : numero del empleado a dar de baja	
	 */
	public void bajaEmpleado(int number) {
		if (this.hash == 1) {
			Merchadona.empleados.remove(number);		
		}
		else {}
	}
	
	/**
	 * Metodo toString de la clase Empleado que nos devuelve el par nombre-hash
	 */
	@Override
	public String toString() {
		return this.getClass() +" [nombre=" + nombre + ", hash=" + hash + "]";
	}
	
}
