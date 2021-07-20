package ar.com.proyectosemillas;

public class Quinoa extends Planta {
	
	private int horasBajoSol;
	
	public Quinoa(int anioObtencion, float altura, int horasBajoSol) {
		super(anioObtencion, altura);
		this.horasBajoSol = horasBajoSol;
	}
	
	public float getHorasBajoSol() {
		return this.horasBajoSol;
	}
	
	public boolean daSemillas() {
		return (esFuerte() || getAnioObtencion() < 2005);
	}
	
	public double getEspacioRequerido() {
		return 0.5;
	}
}
