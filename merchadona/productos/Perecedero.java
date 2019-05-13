package merchadona.productos;
/**
 * Los que caducan tendrán una fecha de reposición (LocalDateTime), 
 * según pasa tiempo desde esa fecha el precio del producto se va reduciendo, cada 10 segundos que pasa el precio se reduce un 10%, 
 * y si pasa 1 minuto el producto ya no se podrá vender. 
 * Cada vez que un reponedor agrega productos se resetea la fecha del producto.
 * @author Jorge y Javi
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import javax.swing.Timer;

public class Perecedero extends Producto {

	
	//Atributos
	/**
	 * Atributos : LocalDateTime fechaRepo, int contador y Timer timer
	 */
	LocalDateTime fechaRepo;
	private int contador;
	private Timer timer = new Timer (10000, new ActionListener() {
		public void actionPerformed(ActionEvent e)
		{
			if(contador < 6) {precio -= (precio*10/100);
								contador++;}
			else {precio = 0;}
		}
	}); 
	
	//Metodos
	
	
	/**
	 * Constructor de la clase Perecedero que hereda de Producto
	 * @param nombre : nombre del producto 
	 * @param precio : precio del producto
	 */
	public Perecedero(String nombre, double precio) {
		super(nombre, precio);
		fechaRepo = LocalDateTime.now();
		contador = 0;
		// TODO Auto-generated constructor stub
	}
	/**
	 * Metodo que aniade al producto la cantidad pasada por parametro
	 * @param cantidad : cantidad de producto que se aniade
	 */
	public void aniadirCantidad(int cantidad) {
		this.cantidad += cantidad;
		fechaRepo = LocalDateTime.now();
		timer.start();
	}

}
