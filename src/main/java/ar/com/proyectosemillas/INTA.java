package ar.com.proyectosemillas;

import java.util.*;

public class INTA {

	private List<Parcela> parcelas;
	
	public INTA() {
		this.parcelas = new ArrayList<Parcela>();
	}
	
	public INTA(List<Parcela> parcelas) {
		this.parcelas = parcelas;
	}
	
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
