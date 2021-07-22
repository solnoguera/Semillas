package ar.com.proyectosemillas;
/**
 * Clase hija de Planta.
 * 
 * @author Sol Noguera
 * @see Planta
 *
 */
public class Soja extends Planta {

	/**
	 * Constructor unico de la clase Soja
	 * @param anioObtencion
	 * @param altura
	 */
	public Soja(int anioObtencion, double altura) {
		super(anioObtencion, altura);
	}
	
	
	public int getHorasBajoSol() {
		
		if(getAltura() < 0.5) {
			return 6;
		} else if (getAltura() >= 0.5 && getAltura() <= 1) {
			return 7;
		} else return 9;
	}
	
	
	public boolean daSemillas() {
		return (esFuerte() || (getAnioObtencion() > 2007 && getAltura() > 1) );
	}
	
	
	public double getEspacioRequerido() {
		return getAltura() / 2;
	}
	
	public boolean esMiParcelaIdeal(Parcela parcela) {
		return (this.getHorasBajoSol() == parcela.getHorasDeSolRecibidas());
	}
}
