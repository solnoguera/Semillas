package ar.com.proyectosemillas;

public class Menta extends Planta {

	public Menta(int anioObtencion, float altura) {
		super(anioObtencion, altura);
	}
	
	
	public float getHorasBajoSol() {
		return 6;
	}
	
	public boolean daSemillas() {
		return (esFuerte() || getAltura() > 0.4);
	}
	
	public double getEspacioRequerido() {
		return getAltura() *3;
	}
	
	public boolean esMiParcelaIdeal(Parcela parcela) {
		return parcela.getSuperficie() >= 6;
	}
}

