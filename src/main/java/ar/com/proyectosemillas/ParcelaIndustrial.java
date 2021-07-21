package ar.com.proyectosemillas;

import java.util.List;

public class ParcelaIndustrial extends Parcela {

	
	public ParcelaIndustrial(double ancho, double largo, int horasDeSolRecibidas) {
		super(ancho, largo, horasDeSolRecibidas);
	}
	
	public ParcelaIndustrial(double ancho, double largo, int horasDeSolRecibidas, List<Planta> plantas) {
		super(ancho, largo, horasDeSolRecibidas, plantas);
	}
	
	@Override
	public boolean seAsociaBien(Planta planta) {
		return (getCantidadPlantas() <= 2 && planta.esFuerte());
	}

}
