package ar.com.proyectosemillas;

import java.util.*;
/**
 * Clase que modela al Instituto Nacional de Tecnología Agropecuaria (INTA), el cual
 * le interesa realizar una serie de estadísticas sobre todas las parcelas del país.
 * 
 * @author Sol Noguera
 * @see Parcela, Planta
 */
public class INTA {

	private List<Parcela> parcelas;
	/**
	 * Constructor INTA sin parametros.
	 */
	public INTA() {
		this.parcelas = new ArrayList<Parcela>();
	}
	/**
	 * Constructor INTA parametrizado.
	 * @param Lista de parcelas
	 */
	public INTA(List<Parcela> parcelas) {
		this.parcelas = parcelas;
	}
	/**
	 * 
	 * @param Parcela para agregar a la lista.
	 */
	public void agregarParcela(Parcela parcela) {
		if(parcela != null) {
			parcelas.add(parcela);
		}
	}
	
	
	/**
	 * 
	 * @return La suma de plantas que hay en cada parcela 
	 * dividido por la cantidad de parcelas que existen;
	 */
	
	public double promedioPlantas() {
		int sumaPlantas = 0;
		
		for(Parcela parcela : this.parcelas) {
			
			int cantPlantas = parcela.getCantidadPlantas();
			sumaPlantas += cantPlantas;
		}
		
		return (sumaPlantas / parcelas.size());
	}
	
	
	
	/**
	 * Aquella Parcela con más de 4 plantas que tiene 
	 * mayor porcentaje de plantas "bien asociadas" es
	 * considerada la mas autosustentable.
	 * 
	 * @return La parcela más autosustentable
	 */
	
	public Parcela laMasAutosustentable() {
		
		Parcela elegida = null;
		double mayorPorcentaje = 0;
		
		for(Parcela parcela : this.parcelas) {

			if(parcela.getCantidadPlantas() > 4) {
				
				if(parcela.porcentajePlantasBienAsociadas() > mayorPorcentaje) {
					elegida = parcela;
				}
			}
		}
		return elegida;
	}
	
}
