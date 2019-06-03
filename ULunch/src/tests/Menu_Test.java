package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uLunch.*;


public class Menu_Test {

	Menu m = null;

	@BeforeEach
	public void init() {
		m = new Menu(4.25, "04/07/2019");
		//Introducimos platos:
		//Primeros
		ArrayList<Alergias>alergenos = new ArrayList<>();
		alergenos.add(Alergias.LACTEOS);
		m.addPlato(new PrimerPlato("Ensala de Pasta", "NONE", Dieta.VEGETARIANA, alergenos));

		alergenos.clear();
		alergenos.add(Alergias.HUEVOS);
		alergenos.add(Alergias.PESCADO);
		m.addPlato(new PrimerPlato("Porra","NONE", Dieta.MEDITERRANEA,alergenos));

		//Segundos
		alergenos.clear();
		m.addPlato(new SegundoPlato("Filete de pollo", "NONE",Dieta.DEFAULT, alergenos));
		alergenos.add(Alergias.PESCADO);
		m.addPlato(new SegundoPlato("Pescado a la plancha","NONE", Dieta.MEDITERRANEA,alergenos));

		//Postre
		alergenos.clear();
		alergenos.add(Alergias.LACTEOS);
		m.addPlato(new Postre("Natillas", "NONE", Dieta.DEFAULT, alergenos));

		alergenos.clear();
		m.addPlato(new Postre("Plátano", "NONE", Dieta.MEDITERRANEA, alergenos));
	}

	@Test
	public void test() {
		assertTrue(!m.getPlatos().isEmpty());
		assertTrue(m.getPlatos(new Filter() {

			@Override
			public boolean filtra(Plato p) {
				return p.getDieta()==Dieta.CELIACA;
			}
		}).isEmpty());

		//Le pido al menu los platos que sean de Alergenos Pescado...
		// ¿A que lista es igual?
		List<Plato> p = new LinkedList<>();
		List<Alergias> al = new LinkedList<>();
		al.add(Alergias.LACTEOS);
        p.add(new PrimerPlato("Ensala de Pasta", "NONE", Dieta.VEGETARIANA, al));
        p.add(new Postre("Natillas", "NONE", Dieta.DEFAULT, al));
        assertFalse(m.getPlatos(new Filter() {

            @Override
            public boolean filtra(Plato p) {
                return p.getAlergias().contains(Alergias.LACTEOS);
            }
        }).isEmpty());
        assertTrue(m.getPlatos(new Filter() {

	            @Override
	            public boolean filtra(Plato p) {
	                return p.getAlergias().contains(Alergias.LACTEOS);
	            }
            }).containsAll(p));
        assertFalse(p.containsAll(m.getPlatos()));
	    }
	
	@Test
	public void test2() {
		int catches = 0;
		try {
			@SuppressWarnings("unused")
			Menu m2 = new Menu(-4.25, "04/07/2019");
		}catch(IllegalArgumentException e) {
			assertEquals(e.getMessage(),"El precio no puede ser negativo");
			catches++;
		}
		
		try {
			@SuppressWarnings("unused")
			Menu m2 = new Menu(4.25, null);
		}catch(IllegalArgumentException e) {
			assertEquals(e.getMessage(),"Es necesario especificar el dia");
			catches++;
		}
		
		try {
			Plato plt[] = new Plato[10];
			@SuppressWarnings("unused")
			Menu m2 = new Menu(4.25, "04/07/2019",plt);
		}catch(IllegalArgumentException e) {
			assertEquals(e.getMessage(),"La lista de platos no puede estar vac�a");
			catches++;
		}
		
		try {
			Plato plt[] = {new PrimerPlato("Ensala de Pasta", "NONE", Dieta.VEGETARIANA, null),
					new Postre("Natillas", "NONE", Dieta.DEFAULT, null)};
			@SuppressWarnings("unused")
			Menu m2 = new Menu(4.25, "04/07/2019",plt);
		}catch(IllegalArgumentException e) {
			assertEquals(e.getMessage(),"Se debe especificar como minimo un primer plato, un segundo y un postre");
			catches++;
		}
		assertEquals(catches,4);
		
	}
		

	@AfterEach
	public void finish() {
		m = null;
	}

}
