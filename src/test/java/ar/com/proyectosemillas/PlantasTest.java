package ar.com.proyectosemillas;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.*;

/**
 * Unit test for simple App.
 */
public class PlantasTest {

	static Menta menta1, menta2;
	static Soja soja1, soja2, soja3;
	static Quinoa quinoa1, quinoa2;
	static Parcela parcela1, parcela2, parcela3;

	/**
	 * Método setUp:
	/* Asignamos valores iniciales a variables antes de la ejecución de cada test.
	 */
	@Before
	public void setUpClass()  {
		menta1 = new Menta(2005, 2);
		soja1 = new Soja(2008, 2);
		quinoa1 = new Quinoa(2010, 3, 12);
		soja2 = new Soja(2002, 0.4);
		soja3 = new Soja(2002, 0.7);
		quinoa2 = new Quinoa(2001, 0.4, 5);
		List<Planta> plantas = new ArrayList<Planta>();
		plantas.add(menta1);
		plantas.add(soja1);
		plantas.add(quinoa1);
		
		parcela1 = new ParcelaEcologica(20.0, 15.5, 6, plantas);
		parcela2 = new ParcelaEcologica(40.0, 10.0, 8, plantas);
		parcela3 = new ParcelaIndustrial(100.0, 25.0, 12, plantas);
		
	}

	/**
	 * Test Método: daSemillas()
	 * 
	 * Si las plantas soportan mas de 10 horas de Sol, son fuertes y dan semillas.
	 * 
	 * Condiciones alternativas:
	 * 
	 * Menta: Si su altura es mayor a 0.4 deberia dar semillas.
	 * 
	 * Soja: si su año de obtencion es posterior a 2007 y ademas su altura
	 * es de mas de un metro debe dar semillas.
	 *  
	 * Quinoa: Si su año de obtención es anterior al 2005 da semillas.
	 */
	@Test
    public void testDaSemillas(){
		assertTrue(menta1.daSemillas());
		assertTrue(soja1.daSemillas());
		assertTrue(quinoa1.daSemillas());
		assertTrue(quinoa2.daSemillas());
    }
	
	/**
	 * Test Método: getHorasBajoSol()
	 * 
	 * El cálculo de las horas de sol que tolera depende exclusivamente de cada especie.
	 * 
	 * Menta: Tolera seis horas de sol al día. 
	 * 
	 * Soja: La tolerancia al sol depende de su altura:
	 *
	 * menor a 0.5 metros: 6 horas;
	 * entre 0.5 y 1 metro: 7 horas;
	 * más de 1 metro: 9 horas;
	 *
	 * Quinoa: la cantidad de horas de sol que tolera la configuraremos para cada planta.
	 */
	@Test
    public void testHorasBajoElSol(){
		assertEquals(6.0, menta1.getHorasBajoSol(), 0.01);
		assertEquals(9.0, soja1.getHorasBajoSol(), 0.01);
		assertEquals(6.0, soja2.getHorasBajoSol(), 0.01);
		assertEquals(7.0, soja3.getHorasBajoSol(), 0.01);
		assertEquals(12.0, quinoa1.getHorasBajoSol(), 0.01);
    }
	
	/**
	 * Test Método: getEspacioRequerido()
	 * 
	 * Menta: Como crece al ras del suelo, el espacio que ocupa es su altura multiplicada por 3.
	 * 
	 * Soja : El espacio que ocupa es la mitad de su altura.
	 * 
	 * Quinoa: Ocupa siempre 0.5 metros cuadrados.
	 * 
	 * Hierbabuena: el espacio que ocupa es el doble del que ocuparía una planta de menta de las mismas características.
	 * 
	 * Soja Transgenica: Igual que la soja
	 */
	@Test
    public void testEspacioRequerido(){
		
		Menta menta1 = new Menta(2005, 2);
		Hierbabuena hierbabuena = new Hierbabuena(2005, 2);
		
		assertEquals(6.0, menta1.getEspacioRequerido(), 0.01);
		assertEquals(12.0, hierbabuena.getEspacioRequerido(), 0.01);
		
		Soja soja1 = new Soja(2008, 2);
		SojaTransgenica sojaT = new SojaTransgenica(2002, 6.0);
		assertEquals(1.0, soja1.getEspacioRequerido(), 0.01);
		assertEquals(3.0, sojaT.getEspacioRequerido(), 0.01);
		
		Quinoa quinoa1 = new Quinoa(2010, 3, 12);
		assertEquals(0.5, quinoa1.getEspacioRequerido(), 0.01);
		
    }

	
	/**
	 * Test Metodo : esMiParcelaIdeal()
	 * 
	 * Cada planta define ciertas condiciones para saber si una parcela le resulta ideal:
	 * 
	 * la menta prefiere suelos extensos, por lo cual le resultan ideales las parcelas con una superficie mayor a 6 metros cuadrados. La hierbabuena, como buena menta que es, se comporta igual;
	 * la quinoa es bajita y por eso anda mejor en parcelas en las que no haya ninguna planta cuya altura supere los 1.5 metros;
	 * la soja común va bien si la cantidad de sol que recibe la parcela es exactamente igual a los que ella tolera;
	 * la soja transgénica está pensada como monocultivo, así que prefiere parcelas cuya cantidad máxima de plantas sea igual a 1.
	 */
	
	@Test
	public void testEsMiParcelaIdeal() throws SemillasException {
		
		ParcelaEcologica parcelaEcologica1 = new ParcelaEcologica(50,2,7);
        Soja soja = new Soja(2004, 0.8); //7 horas sol // Es mi parcela ideal
        Soja soja2 = new Soja(2004, 1.1); //9 horas sol // No es mi parcela ideal
        Quinoa quinoa = new Quinoa(2010, 1, 7); //7 horas // Es mi parcela ideal
        Menta menta1 = new Menta(2009, 1.3); // Es mi parcela ideal
        Hierbabuena hierbabuena = new Hierbabuena(2005, 1.2); // Es mi parcela ideal
        SojaTransgenica sojaT = new SojaTransgenica(2002, 0.9); // No es mi parcela ideal
        
    	assertTrue(soja.esMiParcelaIdeal(parcelaEcologica1));
    	
    	assertFalse(soja2.esMiParcelaIdeal(parcelaEcologica1));
    	
    	assertTrue(quinoa.esMiParcelaIdeal(parcelaEcologica1));
    	assertTrue(menta1.esMiParcelaIdeal(parcelaEcologica1));
    	assertTrue(hierbabuena.esMiParcelaIdeal(parcelaEcologica1));
    	
    	assertFalse(sojaT.esMiParcelaIdeal(parcelaEcologica1));
    	
    	ParcelaIndustrial parcelaEcologica2 = new ParcelaIndustrial(5,1,7); // Maximo plantas = 1
    	
    	assertTrue(sojaT.esMiParcelaIdeal(parcelaEcologica2));
	}

}
