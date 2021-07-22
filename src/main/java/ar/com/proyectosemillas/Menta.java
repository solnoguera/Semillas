package ar.com.proyectosemillas;
/**
 * Clase hija de Planta.
 * 
 * @author Sol Noguera
 * @see Planta
 *
 */
public class Menta extends Planta {

	/**
	 * Constructor unico de la clase Menta
	 * @param anioObtencion
	 * @param altura
	 */
	public Menta(int anioObtencion, double altura) {
		super(anioObtencion, altura);
	}
	
	
	public int getHorasBajoSol() {
		return 6;
	}
	
	public boolean daSemillas() {
		return (esFuerte() || getAltura() > 0.4);
	}
	
	public double getEspacioRequerido() {
		return getAltura() * 3;
	}
	
	public boolean esMiParcelaIdeal(Parcela parcela) {
		return parcela.getSuperficie() > 6;
	}
}

