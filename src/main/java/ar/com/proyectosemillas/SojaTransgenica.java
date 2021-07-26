package ar.com.proyectosemillas;
/**
 * Clase hija de Soja.
 * 
 * @author Sol Noguera
 * @see Soja
 *
 */
public class SojaTransgenica extends Soja {

	/**
	 * Constructor unico de la clase SojaTransgenica
	 * @param anioObtencion
	 * @param altura
	 */
	public SojaTransgenica(int anioObtencion, double altura) {
		super(anioObtencion, altura);
	}
	
	public boolean daSemillas() {
		return false;
	}
	public boolean esMiParcelaIdeal(Parcela parcela) {
		return(parcela.cantidadMaximaPlantas() == 1);
	}
}
