package ar.com.proyectosemillas;

import java.util.List;

public class ParcelaEcologica extends Parcela {
	
	public ParcelaEcologica(double ancho, double largo, int horasDeSolRecibidas) {
		super(ancho, largo, horasDeSolRecibidas);
	}

	public ParcelaEcologica(double ancho, double largo, int horasDeSolRecibidas, List<Planta> plantas) {
		super(ancho, largo, horasDeSolRecibidas, plantas);
	}
	
	@Override
	public boolean seAsociaBien(Planta planta) {
		return (planta.esMiParcelaIdeal(this) && tieneComplicaciones() );
	}
	

}
