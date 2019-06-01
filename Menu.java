package Ulunch;

import java.util.*;

public class Menu {
	private double precio;
	private String dia;
	private List<Plato> primerPlato, segundoPlato, postre;
	
	public Menu(double precio, String dia) {
		this.precio=precio;
		this.dia=dia;
		primerPlato=new ArrayList<Plato>();
		segundoPlato=new ArrayList<Plato>();
		postre=new ArrayList<Plato>();
	}
	public void addPlato(Plato plato) {
		if(plato instanceof PrimerPlato) {
			primerPlato.add(plato);
		}
		if(plato instanceof SegundoPlato) {
			segundoPlato.add(plato);
		}
		if(plato instanceof Postre) {
			postre.add(plato);
		}
	}
	public void addPlato(Plato[] platos) {
		for(Plato plato:platos) {
			addPlato(plato);
		}
	}
	public List getPlatos() {
		listaPlatos= new ArrayList<Plato>();
		for(Plato plato1:this.primerPlato) {
			listaPlatos.add(plato1);
		}
		for(Plato plato2:this.segundoPlato) {
			listaPlatos.add(plato2);
		}
		for(Plato plato3:this.postre) {
			listaPlatos.add(plato3);
		}

		return listaPlatos;
	}
	public List getPlatos(Filter filter) {
		listaPlatos= new ArrayList<Plato>();
		for(Plato plato1:this.primerPlato) {
			if(filter.filtra(plato1)) {
				listaPlatos.add(plato1);
			}
		}
		for(Plato plato2:this.segundoPlato) {
			if(filter.filtra(plato2)) {
				listaPlatos.add(plato2);
			}
		}
		for(Plato plato3:this.postre) {
			if(filter.filtra(plato3)) {
				listaPlatos.add(plato3);
			}
		}

		return listaPlatos;
	}
	public void setPrecio(double precio) {
		this.precio=precio;
	}
	public double getPrecio() {
		return this.precio;
	}
	public String getDia() {
		return this.dia;
	}
	public String setDia(String dia) {
		this.dia=dia;
	}
	public double getValoracion() {
		int i=0;
		double res=0;
		for(Plato plato1:this.primerPlato) {
			i++;
			res+=plato1.getValoración();
		}
		for(Plato plato2:this.segundoPlato) {
			i++;
			res+=plato2.getValoración();
		}
		for(Plato plato3:this.postre) {
			i++;
			res+=plato3.getValoración();
		}
		return res/i;
	}	
}
