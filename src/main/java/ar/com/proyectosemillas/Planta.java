package ar.com.proyectosemillas;

/**
 * Esta clase abstracta madre de todas las plantas,
 * contiene sus atributos y metodos.
 * Implementa la Interfaz MiParcelaIdeal
 * 
 * @author Sol Noguera
 * @see MiParcelaIdeal Interface
 */

public abstract class Planta implements MiParcelaIdeal {

	private int anioObtencion;
	private double altura;
	
	
	/**
	 * Constructor parametrizado
	 * 
	 * @param anioObtencion El año la semilla que le dio origen se sacó de su planta "madre".
	 * @param altura La altura que tiene, medida en metros.
	 */
	
	public Planta(int anioObtencion, double altura) {
		
		try {
			
			if(anioObtencion <= 0) throw new SemillasException("¡SEMILLAS ERROR! El año de obtención de la semilla no puede ser menor o igual a 0.");
			if(altura <= 0) throw new SemillasException("¡SEMILLAS ERROR! La altura de la planta (la cual está medida en metros) no puede ser menor o igual a 0.");
			
		} catch(SemillasException e) {
			System.err.println(e.getMessage());
		} catch(Exception e) {
			System.err.println("Lo sentimos, ha ocurrido un error: " + e.getMessage());
		}
		
		this.anioObtencion = anioObtencion;
		this.altura = altura;
	}
	
	
	/**
	 * Se dice que una planta es fuerte si tolera más de 10 horas de sol al día,
	 * esto es igual para todas las plantas.
	 * 
	 * @return Si la planta es fuerte o no.
	 */
	public boolean esFuerte() {
		return (getHorasBajoSol() > 10);
	};


	/**
	 * El cálculo de las horas de sol que tolera depende exclusivamente de cada especie.
	 * 
	 * @return La cantidad de horas bajo el sol que puede aguantar la planta.
	 */
	public abstract int getHorasBajoSol();
	
	/**
	 * Si da nuevas semillas se tiene que cumplir que la planta sea 
	 * fuerte o bien una condición alternativa, que define cada especie. 
	 *
	 * @return Si la planta puede dar semillas o no.
	 */
	public abstract boolean daSemillas();
	
	/**
	 * Depende pura y exclusivamente de características de la especie.
	 * @return El espacio que ocupa una vez plantada, medido en metros cuadrados.
	 */
	public abstract double getEspacioRequerido();
	
	/**
	 * Cada planta define ciertas condiciones para saber si una parcela le resulta ideal.
	 * 
	 * @param La Parcela a evaluar si es ideal.
	 * @return Si la Parcela le resulta ideal a la planta o no.
	 */
	public abstract boolean esMiParcelaIdeal(Parcela parcela);

	
	/**
	 *  
	 * @return El año la semilla que le dio origen se sacó de su planta "madre".
	 */
	public int getAnioObtencion() {
		return anioObtencion;
	}
	/**
	 * 
	 * @return La altura que tiene la planta, medida en metros.
	 */
	public double getAltura() {
		return altura;
	}
	
	
}
