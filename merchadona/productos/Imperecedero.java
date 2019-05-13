package merchadona.productos;
/**
 * 
 * @author Jorge y Javi
 *
 */
public class Imperecedero extends Producto {
	
	//Atributos
	
	 //No tiene atributos específicos
	
	//Metodos
	
	
	/**
	 * Constructor de la clase Imperecedero que hereda de Producto
	 * @param nombre : nombre del producto
	 * @param precio : precio del producto
	 */
	public Imperecedero(String nombre, double precio) {
		super(nombre, precio);
		// TODO Auto-generated constructor stub
	}
	/**
	 * Metodo que aniade la cantidad de producto pasada por parametro
	 * @param cantidad : cantidad de producto que se aniade
	 */
	public void aniadirCantidad(int cantidad) {
		this.cantidad += cantidad;
	}

}