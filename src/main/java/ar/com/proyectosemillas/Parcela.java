package ar.com.proyectosemillas;

import java.util.*;

/**
 * Esta clase abstracta madre de todas las Parcelas, contiene sus atributos y
 * metodos.
 * 
 * @author Sol Noguera
 */

public abstract class Parcela {

	private double ancho;
	private double largo;
	private int horasDeSolRecibidas;
	private List<Planta> plantas;

	/**
	 * Constructor parametrizado sin la colección de plantas.
	 * 
	 * @param ancho
	 * @param largo
	 * @param horasDeSolRecibidas
	 */
	public Parcela(double ancho, double largo, int horasDeSolRecibidas) {

		this.ancho = ancho;
		this.largo = largo;
		this.horasDeSolRecibidas = horasDeSolRecibidas;
		this.plantas = new ArrayList<Planta>();
		verificar();
	}

	/**
	 * Constructor que sí recibe las plantas que va a tener la parcela.
	 * 
	 * @param ancho
	 * @param largo
	 * @param horasDeSolRecibidas
	 * @param plantas
	 */
	public Parcela(double ancho, double largo, int horasDeSolRecibidas, List<Planta> plantas) {

		this.ancho = ancho;
		this.largo = largo;
		this.horasDeSolRecibidas = horasDeSolRecibidas;
		this.plantas = plantas;
		verificar();
	}

	private void verificar() {
		try {

			if (this.ancho <= 0)
				throw new SemillasException("¡SEMILLAS ERROR! El ancho de la Parcela no puede ser menor o igual a 0.");
			if (this.largo <= 0)
				throw new SemillasException("¡SEMILLAS ERROR! El largo de la Parcela no puede ser menor o igual a 0.");
			if (this.horasDeSolRecibidas < 0)
				throw new SemillasException(
						"¡SEMILLAS ERROR! Las horas de sol recibidas de la Parcela no puede ser menor a 0.");
			if (this.plantas == null)
				throw new SemillasException("¡SEMILLAS ERROR! La colección de plantas no puede ser nula.");

		} catch (SemillasException e) {
			System.err.println(e.getMessage());
		} catch (Exception e) {
			System.err.println("Lo sentimos, ha ocurrido un error: " + e.getMessage());
		}

	}

	public double getSuperficie() {
		return ancho * largo;
	}

	/**
	 * 
	 * @return Cantidad máxima de plantas que puede alojar la Parcela.
	 */
	public int cantidadMaximaPlantas() {
		if (this.ancho > this.largo) {
			return (int) getSuperficie() / 5;
		} else {
			return (int) ((getSuperficie() / 3) + this.largo);
		}
	}

	public boolean tieneComplicaciones() {

		ListIterator<Planta> iterador = plantas.listIterator();
		boolean encontrado = false;
		while (iterador.hasNext() && encontrado == false) {
			Planta planta = iterador.next();
			if (planta.getHorasBajoSol() < this.horasDeSolRecibidas)
				encontrado = true;
		}
		return encontrado;
	}

	/**
	 * Se agrega la planta a la colección.
	 * 
	 * No puede plantar si se alcanza la cantidad máxima de plantas No puede plantar
	 * si la parcela recibe al menos 2 horas más de sol que los que la planta
	 * tolera.
	 * 
	 * @param Planta a plantar en la Parcela
	 */
	public void plantar(Planta planta) throws SemillasException {

		if (getCantidadPlantas() < this.cantidadMaximaPlantas()
				&& !(this.horasDeSolRecibidas > (planta.getHorasBajoSol() + 2))) {
			plantas.add(planta);
		} else
			throw new SemillasException(
					"¡SEMILLAS ERROR! No se pudo agregar planta debido a que la Parcela esta llena o porque está expuesta al sol a más horas de la que su planta puede soportar..");
	}

	/**
	 * Para saber si una planta se asocia bien en una parcela, depende
	 * exclusivamente del tipo de Parcela.
	 * 
	 * @param Planta a evaluar si se asocia bien en la Parcela
	 * @return Si se asocia bien o no.
	 */
	public abstract boolean seAsociaBien(Planta planta);

	/**
	 * 
	 * @return El total de plantas bien asociadas a esta Parcela.
	 */
	public int cantidadPlantasBienAsociadas() {

		int cantidad = 0;
		for (Planta planta : getPlantas()) {
			if (seAsociaBien(planta)) {
				cantidad++;
			}
		}
		return cantidad;
	}

	/**
	 * El porcentaje de plantas bien asociadas se calcula como el total de plantas
	 * bien asociadas a la Parcela dividido la cantidad de plantas.
	 * 
	 * @return El porcentaje de plantas bien asociadas a la parcela.
	 */
	public double porcentajePlantasBienAsociadas() {
		if (getCantidadPlantas() == 0)
			return 0;
		else
			return (cantidadPlantasBienAsociadas() / (double)getCantidadPlantas()) * 100;
	}

	public double getAncho() {
		return ancho;
	}

	public double getLargo() {
		return largo;
	}

	public int getHorasDeSolRecibidas() {
		return horasDeSolRecibidas;
	}

	public List<Planta> getPlantas() {
		return plantas;
	}

	public int getCantidadPlantas() {
		return this.plantas.size();
	}

}
