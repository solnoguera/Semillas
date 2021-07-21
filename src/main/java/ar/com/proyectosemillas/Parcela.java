package ar.com.proyectosemillas;

import java.util.*;

public abstract class Parcela {

	private double ancho;
	private double largo;
	private int horasDeSolRecibidas;
	private List<Planta> plantas;

	// Verificar
	public Parcela(double ancho, double largo, int horasDeSolRecibidas) {
		this.ancho = ancho;
		this.largo = largo;
		this.horasDeSolRecibidas = horasDeSolRecibidas;
		this.plantas = new ArrayList<Planta>();
	}

	public Parcela(double ancho, double largo, int horasDeSolRecibidas, List<Planta> plantas) {
		this.ancho = ancho;
		this.largo = largo;
		this.horasDeSolRecibidas = horasDeSolRecibidas;
		this.plantas = plantas;
	}

	public double getSuperficie() {
		return ancho * largo;
	}

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

	public void plantar(Planta planta) {

		try {
			if (getCantidadPlantas() < this.cantidadMaximaPlantas())
				plantas.add(planta);
			else
				throw new SemillasException(
						"¡SEMILLAS ERROR! No se pudo agregar planta debido a que la Parcela esta llena.");

			if (this.horasDeSolRecibidas > (planta.getHorasBajoSol() + 2))
				throw new SemillasException(
						"¡SEMILLAS ERROR! No se pudo agregar la planta debido a que la Parcela está expuesta al sol a más horas de la que su planta puede soportar.");
			else
				plantas.add(planta);

		} catch (SemillasException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println("Lo sentimos, ha ocurrido un error: " + e.getMessage());
		}
	}

	public abstract boolean seAsociaBien(Planta planta);
	
	public int cantidadPlantasBienAsociadas() {
		
		int cantidad = 0;
		for(Planta planta : getPlantas()) {
			if(seAsociaBien(planta)) {
				cantidad++;
			}
		}
		return cantidad;
	}
	
	public double porcentajePlantasBienAsociadas() {
		return cantidadPlantasBienAsociadas() / getCantidadPlantas();
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
