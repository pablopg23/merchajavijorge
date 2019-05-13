package merchadona;
/**
 * Se pide el hacer el programa que va controlar las cajas de la aplicación.
 * Para abrir una caja se pondrá un empleado, y venderán productos.
 * 
 * @author Jorge y Javi
 */
import merchadona.empleados.Cajero;

public class Caja {
	/**
	 * Atributos: Cajero empleado y double precioTotalCompra;
	 */
	//Atributos
	private Cajero empleado;
	private double precioTotalCompra;
	
	//Metodos
	/**
	 * 	Constructor de la clase Caja
	 * @param cajero : Cajero que vamos a asignar al empleado de la caja
	 * el precio total de la compra empieza en 0.0
	 */
	public Caja (Cajero cajero) {
		this.empleado = cajero;
		precioTotalCompra = 0.0;
	}
	
/**
 * Metodo que llamaremos a la hora de realizar una venta.
 * Para elegir el prodcuto, pide su numero.
 * Resta a la cantidad de producto que hay, la cantidad que compra el cliente.
 * 
 */
	public void vender () {
		precioTotalCompra = 0.0;
		int numeroProd;
		int cantidad; 
		System.out.println("Aniada un producto escribiendo su"
				+ " numero (0 para salir)-Caja");
		Merchadona.listarProductos();
		numeroProd = Merchadona.sc.nextInt()-1;
		
	while (numeroProd >= 0)	{
		System.out.println("Has elegido: "+ Merchadona.productos.get(numeroProd).getNombre());
		System.out.println("�Cuantos va a comprar?");
		cantidad = Merchadona.sc.nextInt();
		
		if(empleado.aniadirProducto(numeroProd, cantidad)) {
			precioTotalCompra += Merchadona.productos.get(numeroProd).getPrecio()*cantidad;
		}
		
		
		System.out.println("La compra asciende a: "+ Merchadona.df.format(precioTotalCompra));
		
		System.out.println("Aniada un producto escribiendo su"
				+ " numero (0 para salir)-caja");
		Merchadona.listarProductos();
		numeroProd = Merchadona.sc.nextInt()-1;
	

	}
	
	}
	}

