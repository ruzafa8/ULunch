package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import uLunch.*;
import uLunch.Plato.Alergias;
import uLunch.Plato.Dieta;


class Menu_Test {

	Menu m;

	@Before
	public void init() {
		m = new Menu(4.25, "04/07/2019");
		//Introducimos platos:
		//Primeros
		ArrayList<Plato.Alergias>alergenos = new ArrayList<>();
		alergenos.add(Alergias.LACTEOS);
		m.addPlato(new PrimerPlato("Ensala de Pasta", "", Dieta.VEGETARIANA, alergenos));

		alergenos.clear();
		alergenos.add(Alergias.HUEVOS);
		alergenos.add(Alergias.PESCADO);
		m.addPlato(new PrimerPlato("Porra","", Dieta.MEDITERRANEA,alergenos));

		//Segundos
		alergenos.clear();
		m.addPlato(new SegundoPlato("Filete de pollo", "",Dieta.DEFAULT, alergenos));
		alergenos.add(Alergias.PESCADO);
		m.addPlato(new SegundoPlato("Pescado a la plancha","", Dieta.MEDITERRANEA,alergenos));

		//Postre
		alergenos.clear();
		alergenos.add(Alergias.LACTEOS);
		m.addPlato(new Postre("Natillas", "", Dieta.DEFAULT, alergenos));

		alergenos.clear();
		m.addPlato(new Postre("Plátano", "", Dieta.MEDITERRANEA, alergenos));
	}

	@Test
	void test() {
		assertTrue(m.getPlatos(new Filter() {

			@Override
			public boolean filtra(Plato p) {
				return p.getAlergias().contains(Dieta.CELIACA);
			}
		}).isEmpty());

		//Le pido al menu los platos que sean de Alergenos Pescado...
		// ¿A que lista es igual?
		List<Plato> p = new LinkedList<>();
		List<Alergias> al = new LinkedList<>();
		al.add(Alergias.LACTEOS);
        p.add(new PrimerPlato("Ensala de Pasta", "", Dieta.VEGETARIANA, al));
        p.add(new Postre("Natillas", "", Dieta.DEFAULT, al));
        assertEquals(p, m.getPlatos(new Filter() {

	            @Override
	            public boolean filtra(Plato p) {
	                return p.getAlergias().contains(Alergias.LACTEOS);
	            }
            }));
	    }

	@After
	public void finish() {
		m = null;
	}

}
