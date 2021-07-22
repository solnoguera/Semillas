package ar.com.proyectosemillas;

import java.util.List;

/**
 * Clase hija de Parcela.
 * 
 * @author Sol Noguera
 * @see Parcela
 *
 */
public class ParcelaIndustrial extends Parcela {

	/**
	 * Constructor parametrizado sin la colección de plantas.
	 * 
	 * @param ancho
	 * @param largo
	 * @param horasDeSolRecibidas
	 */
	public ParcelaIndustrial(double ancho, double largo, int horasDeSolRecibidas) {
		super(ancho, largo, horasDeSolRecibidas);
	}
	
	/**
	 * Constructor que sí recibe las plantas que va a tener la parcela. 
	 * 
	 * @param ancho
	 * @param largo
	 * @param horasDeSolRecibidas
	 * @param plantas
	 */
	public ParcelaIndustrial(double ancho, double largo, int horasDeSolRecibidas, List<Planta> plantas) {
		super(ancho, largo, horasDeSolRecibidas, plantas);
	}
	
	@Override
	public boolean seAsociaBien(Planta planta) {
		return (getCantidadPlantas() <= 2 && planta.esFuerte());
	}

}
