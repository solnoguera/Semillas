package ar.com.proyectosemillas;
/**
 * Clase hija de Menta.
 * 
 * @author Sol Noguera
 * @see Menta
 *
 */
public class Hierbabuena extends Menta {
	
	/**
	 * Constructor unico de la clase Hierbabuena
	 * @param anioObtencion
	 * @param altura
	 */
	public Hierbabuena(int anioObtencion, double altura) {
		super(anioObtencion, altura);
	}
	
	public double getEspacioRequerido() {
		return super.getEspacioRequerido() * 2;
	}
}
