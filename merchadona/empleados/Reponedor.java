package merchadona.empleados;
/**
 * Los reponedores añaden stock a los productos.
 * Los reponedores tienen el total del número de productos que han respuesto.
 * @author Jorge y Javi
 */
import merchadona.Merchadona;

public class Reponedor extends Empleado {

	//Metodos
	
	/**
	 * Constructor de la clase Reponedor que hereda de Empleado.
	 * @param nombre : nombre del reponedor
	 * @param hash   : id del reponedor
	 */
	public Reponedor(String nombre, int hash) {
		// TODO Auto-generated constructor stub
		super(nombre, hash);
	}
	/**
	 * Metodo que llamaremos para reponer productos.
	 * Imprime el listado de productos y el usuario elige cual reponer
	 */
	public void reponerProductos () {
		int numeroProd;
		int cantidad; 
	
		System.out.println("Elija un producto escribiendo su"
				+ " numero (0 para salir) - Reponer");
		Merchadona.listarProductos();
		numeroProd = Merchadona.sc.nextInt()-1;
		
	while (numeroProd >= 0)	{
		System.out.println("Has elegido: "+ Merchadona.productos.get(numeroProd).getNombre());
		System.out.println("�Cuantos va a reponer?");
		cantidad = Merchadona.sc.nextInt();
		
		Merchadona.productos.get(numeroProd).aniadirCantidad(cantidad);
		
			
		System.out.println("Elija un producto escribiendo su"
				+ " numero (0 para salir) - Reponer");
		Merchadona.listarProductos();
		numeroProd = Merchadona.sc.nextInt()-1;
	
			}

		}

	}
