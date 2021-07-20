package ar.com.proyectosemillas;

public class Hierbabuena extends Menta {
	
	
	public Hierbabuena(int anioObtencion, float altura) {
		super(anioObtencion, altura);
	}
	
	public double getEspacioRequerido() {
		return getAltura();
	}
}
