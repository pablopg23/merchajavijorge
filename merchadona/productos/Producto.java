package merchadona.productos;
/**
 * Los productos a vender tienen un nombre, un precio base, y una cantidad en stock, 
 * Los tenemos de dos tipos perecederos e imperecederos. 
 * @author Jorge y Javi
 *
 */
public class Producto {
	//Atributos
	/**
	 * Atributos: int cantidad, String nombre y double precio
	 */
	 int cantidad;
	 private String nombre;
	 double precio;
	
	//Metodos
	/**
	 * Constructor de la clase Producto
	 * @param nombre : nombre del producto
	 * @param precio : precio del producto
	 */
	public Producto (String nombre, double precio) {
		this.cantidad = 0;
		this.nombre = nombre;
		this.precio = precio;
	}

	/**
	 * Metodo que devuelve la cantidad de producto
	 * @return the cantidad
	 */
	public int getCantidad() {
		return cantidad;
	}

	/**
	 * Metodo que actualiza la cantidad de producto, sumando el numero que se aniada
	 * @param cantidad : cantidad de producto que se suma a la cantidad que habia antes de aniadir
	 */
	public void aniadirCantidad(int cantidad) {
		this.cantidad += cantidad;
	}
	/**
	 * Metodo que actualiza la cantidad de producto, restando el numero que se retire
	 * @param cantidad : cantidad de producto que se resta a la cantidad que habia antes de retirar
	 */
	public void restarCantidad(int cantidad) {
		if(this.cantidad>0) {
		this.cantidad -= cantidad;
		}
	}

	/**
	 * Metodo que devuelve el precio del producto
	 * @return precio : precio del producto
	 */
	public double getPrecio() {
		return precio;
	}

	/**
	 * Metodo que devuelve el nombre del producto
	 * @return nombre : nombre del producto
	 */
	public String getNombre() {
		return nombre;
	}
	
}
