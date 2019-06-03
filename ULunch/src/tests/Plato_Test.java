package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uLunch.*;

public class Plato_Test {
	Plato p1 = null;
	Plato p1bis = null;
	Plato p2 = null;
	Plato p2bis = null;
	Plato p3 = null;
	
		
	@BeforeEach
	public void init() {
		ArrayList<Alergias>alergenos = new ArrayList<>();
		alergenos.add(Alergias.MOSTAZA);
		p1 = new PrimerPlato("Patatas con mostaza", "UNO", Dieta.VEGETARIANA,alergenos);
		p1bis = new PrimerPlato("Patatas con mostaza", "UNOPERODOS", Dieta.VEGETARIANA,alergenos);
		alergenos.add(Alergias.GLUTEN);
		p2 = new SegundoPlato("Mostaza con mostaza dulce","DOS", Dieta.DEFAULT,alergenos);
		p2bis = new SegundoPlato("MOSTAZA CON MOSTAZA DULCE","DOSYDOS", Dieta.DEFAULT,alergenos);
		alergenos.clear();
		p3 = new Postre("Mostaza en salsa","TRES", Dieta.CELIACA, alergenos);
		
		p1.addValoracion(new Usuario("user","112233","user@user.user",new ArrayList<Alergias>()),4, null);
		p1.addValoracion(new Usuario("user","112233","user@user.user",new ArrayList<Alergias>()),1, null);
		p1.addValoracion(new Usuario("user","112233","user@user.user",new ArrayList<Alergias>()),4, null);
	}
	@Test
	public void test() {
		assertEquals(p1,p1bis);
		assertEquals(p2,p2bis);
		assertEquals(p1.getPuntuacionMedia(),3);
		assertEquals(p2.getDieta(),Dieta.DEFAULT);
		assertTrue(p3.getAlergias().isEmpty());
		assertTrue(p1.getAlergias().contains(Alergias.MOSTAZA));
		ArrayList<Alergias> alergias = new ArrayList<>(); alergias.add(Alergias.MOSTAZA); alergias.add(Alergias.GLUTEN);
		assertEquals(p2.getAlergias(),alergias);
		
	}
	
	@Test
	public void test2() {
		int catches = 0;
		try {
			p1.addValoracion(new Usuario("user","112233","user@user.user",new ArrayList<Alergias>()),8, null);
		}catch (IllegalArgumentException e) {
			assertEquals(e.getMessage(),"La puntuacion debe ser un entero entre 0 y 5");
			catches++;
		}
		try {
			p1.addValoracion(new Usuario("user","112233","user@user.user",new ArrayList<Alergias>()),-6, null);
		}catch (IllegalArgumentException e) {
			assertEquals(e.getMessage(),"La puntuacion debe ser un entero entre 0 y 5");
			catches++;
		}
		try {
			@SuppressWarnings("unused")
			Plato p5 = new Plato(null,"hola",Dieta.DEFAULT,null);
		}catch (IllegalArgumentException e) {
			assertEquals(e.getMessage(),"Es necesario especificar el nombre");
			catches++;
		}
		try {
			@SuppressWarnings("unused")
			Plato p5 = new Plato("esto","hola",null,null);
		}catch (IllegalArgumentException e) {
			assertEquals(e.getMessage(),"Es necesario especificar la dieta");
			catches++;
		}
		assertEquals(4,catches);
	}
	
	@AfterEach
	public void finish () {
		p1 = null;
		p1bis = null;
		p2 = null;
		p2bis = null;
		p3 = null;
	}

}
