package ar.com.proyectosemillas;

public class SojaTransgenica extends Soja {

	public SojaTransgenica(int anioObtencion, float altura) {
		super(anioObtencion, altura);
	}
	
	public boolean daSemillas() {
		return false;
	}
	public boolean esMiParcelaIdeal(Parcela parcela) {
		return(parcela.cantidadMaximaPlantas() == 1);
	}
}
