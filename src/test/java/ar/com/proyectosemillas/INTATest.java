package ar.com.proyectosemillas;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.*;

public class INTATest {
	 @Test
	    public void promedioDePlantasTest () throws SemillasException {
		 
	        ParcelaIndustrial parcelaIndustrial = new ParcelaIndustrial(5,10,6);
	        
	        Soja plantaSoja = new Soja(2009, 0.3);
	        Quinoa plantaQuinoa = new Quinoa(2010, 7.0, 5);
	        
	        parcelaIndustrial.plantar(plantaSoja);
	        parcelaIndustrial.plantar(plantaQuinoa);
	        
	        assertEquals(2, parcelaIndustrial.getCantidadPlantas());
	        
	        ParcelaEcologica parcelaEcologica = new ParcelaEcologica(5,10,6);
	        
	        Soja plantaSoja2 = new Soja(2009, 0.3);
	        Quinoa plantaQuinoa2 = new Quinoa(2010, 7.0, 7);
	        
	        parcelaEcologica.plantar(plantaSoja2);
	        parcelaEcologica.plantar(plantaQuinoa2);
	        
	        assertEquals(2, parcelaEcologica.getCantidadPlantas());
	        
	        List<Parcela> parcelas = new ArrayList<>();
	        parcelas.add(parcelaIndustrial);
	        parcelas.add(parcelaEcologica);
	        
	        INTA inta = new INTA(parcelas);
	        assertEquals(2, inta.promedioPlantas(), 0.1);

	        ParcelaIndustrial parcelaIndustrial2 = new ParcelaIndustrial(5,10,6);
	        
	        parcelaIndustrial2.plantar(plantaSoja);
	        parcelaIndustrial2.plantar(plantaQuinoa);
	        
	        assertEquals(2, parcelaIndustrial2.getCantidadPlantas());
	        
	        ParcelaEcologica parcelaEcologica2 = new ParcelaEcologica(5,10,6);
	        
	        parcelaEcologica2.plantar(plantaSoja2);
	        
	        assertEquals(1, parcelaEcologica2.getCantidadPlantas());
	        
	        List<Parcela> parcelas2 = new ArrayList<>();
	        parcelas2.add(parcelaIndustrial2);
	        parcelas2.add(parcelaEcologica2);
	        
	        INTA inta2 = new INTA(parcelas2);
	        assertEquals(1.5, inta2.promedioPlantas(), 0.1);
	    }

	    @Test
	    public void parcelaMasSustentable () throws SemillasException {
	    	
	        ParcelaIndustrial parcelaIndustrial = new ParcelaIndustrial(5,10,6);
	        
	        Soja plantaSoja = new Soja(2009, 0.3);
	        Quinoa plantaQuinoa = new Quinoa(2010, 7.0, 5);
	        
	        parcelaIndustrial.plantar(plantaSoja);
	        parcelaIndustrial.plantar(plantaQuinoa);
	        parcelaIndustrial.plantar(plantaSoja);
	        parcelaIndustrial.plantar(plantaQuinoa);
	        parcelaIndustrial.plantar(plantaSoja);
	        
	        assertEquals(5, parcelaIndustrial.getCantidadPlantas());
	        
	        ParcelaEcologica parcelaEcologica = new ParcelaEcologica(5,10,6);
	        
	        Soja plantaSoja2 = new Soja(2009, 0.3);
	        Quinoa plantaQuinoa2 = new Quinoa(2010, 1.0, 6);
	        
	        parcelaEcologica.plantar(plantaSoja2);
	        parcelaEcologica.plantar(plantaQuinoa2);
	        parcelaEcologica.plantar(plantaSoja2);
	        parcelaEcologica.plantar(plantaQuinoa2);
	        parcelaEcologica.plantar(plantaSoja2);
	        
	        assertEquals(5, parcelaEcologica.getCantidadPlantas());
	        
	        List<Parcela> parcelas = new ArrayList<>();
	        
	        parcelas.add(parcelaIndustrial);
	        parcelas.add(parcelaEcologica);
	        
	        INTA inta = new INTA(parcelas);
	        
	        assertEquals(parcelaEcologica, inta.laMasAutosustentable());

	        assertEquals(5, parcelaIndustrial.getCantidadPlantas());
	        
	        ParcelaEcologica parcelaEcologica2 = new ParcelaEcologica(5,10,6);
	        
	        parcelaEcologica2.plantar(plantaSoja2);
	        parcelaEcologica2.plantar(plantaQuinoa2);
	        parcelaEcologica2.plantar(plantaSoja2);
	        parcelaEcologica2.plantar(plantaQuinoa2);
	        
	        assertEquals(4, parcelaEcologica2.getCantidadPlantas());
	        
	        List<Parcela> parcelas2 = new ArrayList<>();
	        parcelas2.add(parcelaEcologica2);
	        parcelas2.add(parcelaEcologica);
	        INTA inta2 = new INTA(parcelas2);
	        
	        assertEquals(parcelaEcologica, inta2.laMasAutosustentable());
	    }
}
