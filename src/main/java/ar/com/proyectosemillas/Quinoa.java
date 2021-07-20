package ar.com.proyectosemillas;

import java.util.List;
import java.util.ListIterator;

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
	
	public boolean esMiParcelaIdeal(Parcela parcela) {
		
		List<Planta> plantas = parcela.getPlantas();
		ListIterator<Planta> iterador = plantas.listIterator();
		boolean encontrado = false;
		
		while (iterador.hasNext() && encontrado == false) {
			Planta planta = iterador.next();
			if(planta.getAltura() > 1.5) encontrado = true;
		}
		return !encontrado;
	}
}
