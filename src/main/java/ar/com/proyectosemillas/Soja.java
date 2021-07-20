package ar.com.proyectosemillas;

public class Soja extends Planta {

	
	public Soja(int anioObtencion, float altura) {
		super(anioObtencion, altura);
	}
	
	
	public float getHorasBajoSol() {
		
		if(getAltura() < 0.5) {
			return 6;
		} else if (getAltura() >= 0.5 && getAltura() < 1) {
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
