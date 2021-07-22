package ar.com.proyectosemillas;

import java.util.List;
import java.util.ListIterator;
/**
 * Clase hija de Planta.
 * 
 * @author Sol Noguera
 * @see Planta
 *
 */
public class Quinoa extends Planta {
	
	private int horasBajoSol;
	
	/**
	 * Constructor unico de la clase Quinoa
	 * @param anioObtencion
	 * @param altura
	 * @param horasBajoSol
	 */
	public Quinoa(int anioObtencion, double altura, int horasBajoSol) {
		super(anioObtencion, altura);
		this.horasBajoSol = horasBajoSol;
	}
	
	public int getHorasBajoSol() {
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
