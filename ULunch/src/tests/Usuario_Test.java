package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uLunch.Alergias;
import uLunch.Usuario;

public class Usuario_Test {
	Usuario u = null;
		
	@BeforeEach
	public void init() {
		List<Alergias>a=new LinkedList<>();
		u = new Usuario("user","112233","user@user.user",a);
	}
	
	@Test
	public void test() {
		assertTrue(u.login("user@user.user","112233"));
		assertFalse(u.login("user","112233"));
		assertFalse(u.login("user@user.user","121233"));
		assertFalse(u.login("usera@usera.usera","112233"));
	}
	
	@Test
	public void test2() {
		int catches = 0;
		try {
			@SuppressWarnings("unused")
		 	Usuario u2 = new Usuario("user","1","user@user.user",new LinkedList<>());
		}catch (IllegalArgumentException e) {
			assertEquals(e.getMessage(),"Contraseña demasiado debil");
			catches++;
		}
		try {
			@SuppressWarnings("unused")
		 	Usuario u2 = new Usuario(null,"buenapass","user@user.user",new LinkedList<>());
		}catch (IllegalArgumentException e) {
			assertEquals(e.getMessage(),"Se debe especificar un nombre");
			catches++;
		}
		try {
			@SuppressWarnings("unused")
		 	Usuario u2 = new Usuario("nombreOriginal","buenapass",null,new LinkedList<>());
		}catch (IllegalArgumentException e) {
			assertEquals(e.getMessage(),"Se debe especificar un correo");
			catches++;
		}
		assertEquals(catches,3);
	}
	
	@AfterEach
	public void finish () {
		u = null;
	}

}


