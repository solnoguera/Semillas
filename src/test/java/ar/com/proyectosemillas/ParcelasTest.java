package ar.com.proyectosemillas;

import static org.junit.Assert.*;
import org.junit.*;

public class ParcelasTest {

	/**
	 * Test Método : getSuperficie() 
	 * 
	 * Se calcula multiplicando ancho por largo;
	 */
	@Test
	public void testGetSuperficie() {
		ParcelaEcologica parcelaEcologica1 = new ParcelaEcologica(8,10,7);
        assertEquals(80, parcelaEcologica1.getSuperficie(), 0.01);
        ParcelaIndustrial parcelaIndustrial = new ParcelaIndustrial(10,2,7);
        assertEquals(20, parcelaIndustrial.getSuperficie(), 0.01);
	}
	/**
	 * Test Metodo : cantidadMaximaPlantas()
	 * 
	 * Si el ancho es mas grande que el largo entonces la rta deberia ser
	 * getSuperficie() / 5;
	 * 
	 * De lo contrario, la cuenta es (getSuperficie() / 3) + largo
	 */
	@Test
	public void testCantidadMaximaPlantas() {
		ParcelaEcologica parcelaEcologica1 = new ParcelaEcologica(2,40,7);
		assertEquals(66.0, parcelaEcologica1.cantidadMaximaPlantas(), 0.01);
		ParcelaIndustrial parcelaIndustrial = new ParcelaIndustrial(9,5,7);
        assertEquals(9.0, parcelaIndustrial.cantidadMaximaPlantas(), 0.01);
	}
	/**
	 * Test Metodo : tieneComplicaciones()
	 * 
	 * Tiene complicaciones si alguna de sus plantas tolera menos sol del
	 * que recibe la parcela
	 */
	@Test
	public void testTieneComplicaciones() throws SemillasException{
		ParcelaEcologica parcelaEcologica1 = new ParcelaEcologica(50,2,5);
		ParcelaIndustrial parcelaIndustrial = new ParcelaIndustrial(10,20,7);
        Soja soja = new Soja(2004, 0.8); //7 horas
        Quinoa quinoa = new Quinoa(2010, 7, 5); //5 horas
    	parcelaEcologica1.plantar(soja);
    	parcelaEcologica1.plantar(quinoa);
    	parcelaIndustrial.plantar(soja);
    	parcelaIndustrial.plantar(quinoa);
        assertFalse(parcelaEcologica1.tieneComplicaciones());
        assertTrue(parcelaIndustrial.tieneComplicaciones());
	}
	
	/**
	 * Test Metodo : plantar()
	 * 
	 * El efecto que produce es que se agregue a la colección. 
	 * 
	 * Esto debe arrojar un error si al plantar se supera la cantidad máxima
	 * o bien si la parcela recibe al menos 2 horas más de sol que los que la planta tolera.
	 */
	@Test
	public void testPlantar() throws SemillasException{
		ParcelaEcologica parcelaEcologica1 = new ParcelaEcologica(50,2,5);
        ParcelaIndustrial parcelaIndustrial = new ParcelaIndustrial(10,20,7);
        Soja soja = new Soja(2004, 0.8); 
        Quinoa quinoa = new Quinoa(2010, 7, 5); 
        
        parcelaEcologica1.plantar(soja);
        parcelaEcologica1.plantar(quinoa);
        
        parcelaIndustrial.plantar(soja);
        
        assertEquals(2, parcelaEcologica1.getCantidadPlantas());
        assertEquals(1, parcelaIndustrial.getCantidadPlantas());
        
	}
	
	/**
	 * Test Metodo : plantar()
	 * 
	 * Hecho para fallar ya que la Parcela recibe 25 horas de sol, muchas mas de las
	 * que las plantas toleran.
	 * 
	 * @throws SemillasException
	 */
	@Test (expected=SemillasException.class)
	public void testMasSolDelQueSoportan() throws SemillasException{
		ParcelaEcologica parcelaEcologica1 = new ParcelaEcologica(50,2,25); //25 horas
        Soja soja = new Soja(2004, 0.8); //7 horas
        Quinoa quinoa = new Quinoa(2010, 7, 5); //5 horas
    	parcelaEcologica1.plantar(soja);
    	parcelaEcologica1.plantar(quinoa);
	}
	
	/**
	 * Test Metodo : plantar()
	 * 
	 * Hecho para fallar ya que la Parcela tiene un maximo de 2 plantas,
	 * arroja una Exception cuando queremos plantar una tercera.
	 * 
	 * @throws SemillasException
	 */
	@Test (expected=SemillasException.class)
	public void testMaximaCantidadPlantas() throws SemillasException {
		ParcelaEcologica parcelaEcologica1 = new ParcelaEcologica(5,2,7); //2 plantas MAXIMO
		Soja soja = new Soja(2004, 0.8); 
        Quinoa quinoa = new Quinoa(2010, 7, 5); 
        Quinoa quinoa2 = new Quinoa(2010, 7, 5);
        parcelaEcologica1.plantar(soja);
        parcelaEcologica1.plantar(quinoa);
        parcelaEcologica1.plantar(quinoa2);

	}

	/**
	 * Test Metodo : porcentajePlantasBienAsociadas()
	 * 
	 * El porcentaje lo calculamos con la cantidad de plantas bien asociadas / total plantas
	 * 
	 * Para estar bien asociadas:
	 * Parcelas ecológicas: que la parcela no tenga complicaciones y sea ideal para la planta;
	 * 
	 * @throws SemillasException 
	 */
	@Test
	public void testPorcentajePlantasBienAsociadasEnParcelaEcologica() throws SemillasException {
		
		ParcelaEcologica parcelaEcologica1 = new ParcelaEcologica(50,2,7);
        Soja soja = new Soja(2004, 0.8); //7 horas sol // Es mi parcela ideal -> Bien Asociada
        Soja soja2 = new Soja(2004, 1.1); //9 horas sol // No es mi parcela ideal -> Mal Asociada
        Quinoa quinoa = new Quinoa(2010, 1, 7); //7 horas // Es mi parcela ideal -> Bien Asociada
    	parcelaEcologica1.plantar(soja);
    	parcelaEcologica1.plantar(quinoa);
    	parcelaEcologica1.plantar(soja2);
    	assertFalse(parcelaEcologica1.tieneComplicaciones());
    	assertEquals(2, parcelaEcologica1.cantidadPlantasBienAsociadas());
    	assertEquals(66.6, parcelaEcologica1.porcentajePlantasBienAsociadas(), 0.1);
	}
	/**
	 * Test Metodo : porcentajePlantasBienAsociadas()
	 * 
	 * El porcentaje lo calculamos con la cantidad de plantas bien asociadas / total plantas
	 * 
	 * Para estar bien asociadas:
	 * Parcelas industriales: que haya como máximo 2 plantas y que la planta en cuestión sea fuerte.
	 * 
	 * @throws SemillasException
	 */
	
	@Test
	public void testPorcentajePlantasBienAsociadasEnParcelaIndustrial() throws SemillasException {
		ParcelaIndustrial parcelaIndustrial = new ParcelaIndustrial(10,20,7);
		Quinoa quinoa = new Quinoa(2010, 1, 14); //Fuerte porque aguanta mas de 10 hs bajo el sol
		Quinoa quinoa2 = new Quinoa(2010, 1, 12); //Fuerte porque aguanta mas de 10 hs bajo el sol
		parcelaIndustrial.plantar(quinoa);
		parcelaIndustrial.plantar(quinoa2);
		assertEquals(2, parcelaIndustrial.cantidadPlantasBienAsociadas());
		assertEquals(100, parcelaIndustrial.porcentajePlantasBienAsociadas(), 0.1);
	}
	
}
