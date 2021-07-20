package ar.com.proyectosemillas;

public abstract class Planta {

	private int anioObtencion;
	private float altura; //Medida en metros
	
	/**
	 * @author: Sol Noguera
	 * 
	 * @param anioObtencion El año la semilla que le dio origen se sacó de su planta "madre"
	 * @param altura La altura que tiene, medida en metros.
	 */
	
	public Planta(int anioObtencion, float altura) {
		
		try {
			
			if(anioObtencion <= 0) throw new SemillasException("ERROR! El año de obtención de la semilla no puede ser menor o igual a 0.");
			if(altura <= 0) throw new SemillasException("ERROR! La altura de la planta (la cual está medida en metros) no puede ser menor o igual a 0.");
			
		} catch(SemillasException e) {
			System.out.println(e.getMessage());
		} catch(Exception e) {
			System.out.println("Lo sentimos, ha ocurrido un error: " + e.getMessage());
		}
		
		this.anioObtencion = anioObtencion;
		this.altura = altura;
	}
	
	
	/**
	 * @author: Sol Noguera
	 * 
	 * @return Se dice que una planta es fuerte si tolera más de 10 horas de sol al día,
	 * esto es igual para todas las plantas.
	 */
	public boolean esFuerte() {
		return (getHorasBajoSol() > 10);
	};

	
	//Metodos ABSTRACTOS 
	
	public abstract float getHorasBajoSol();
	
	public abstract boolean daSemillas();
	
	public abstract double getEspacioRequerido();
	
	

	//GETTERS
	
	public int getAnioObtencion() {
		return anioObtencion;
	}

	public float getAltura() {
		return altura;
	}
	
	
}
