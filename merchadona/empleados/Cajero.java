package merchadona.empleados;
/**
 * Los cajeros venderán. 
 * Todos los empleados tienen un nombre, y un id (número) que los identifica.
 * Los cajeros tienen el precio total de productos vendidos.
 * @author Jorge y Javi
 */
import merchadona.Merchadona;

public class Cajero extends Empleado {

	//Atributos
	/**
	 * Atributos: String nombre e int hash (de la clase Empleado)
	 * y float total_ventas que almacenará el precio total de productos vendidos
	 */
	private float total_ventas;
	
	//Metodos
	/**
	 * Constructor de la clase Cajero
	 * @param nombre : nombre del cajero
	 * @param hash   : numero del cajero
	 * total_ventas se inicializa en 0.
	 */
	public Cajero(String nombre, int hash) {
		// TODO Auto-generated constructor stub
		super(nombre, hash);
		total_ventas = 0;
	}
	/**
	 * Metodo que añade productos a la compra
	 * @param numeroProd : numero del producto
	 * @param cantidad   : cantidad a comprar
	 * @return b         : true si se puede vender y false si no
	 */
	public boolean aniadirProducto (int numeroProd, int cantidad) {
		boolean b= false;
		
		if (Merchadona.productos.get(numeroProd).getCantidad()<cantidad) {
			System.out.println("No hay suficientes, avise a un reponedor");
		}
		else {
			if(Merchadona.productos.get(numeroProd).getPrecio() > 0) {
				this.total_ventas += Merchadona.productos.get(numeroProd).getPrecio();
			System.out.println("El producto se ha aniadido correctamente");
			//La cantidad se va restando seg�n se vende, no hay una memoria de productos.
			Merchadona.productos.get(numeroProd).restarCantidad(cantidad);
			b= true;
			}
			else {
				System.out.println("Este producto no se puede vender");
				
			} 
		}
		return b;
	}

	/**
	 * Metodo que devuelve el precio total de productos vendidos
	 * @return total_ventas
	 */
	public float getTotal_ventas() {
		return total_ventas;
	}

	/**
	 * Metodo que actualiza el precio total de productos vendidos
	 * @param total_ventas 
	 */
	public void setTotal_ventas(float total_ventas) {
		this.total_ventas = total_ventas;
	}
	
	

	
}
