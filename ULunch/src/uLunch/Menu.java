package uLunch;

import java.util.*;

public class Menu {
	private double precio;
	private String dia;
	private List<Plato> primerPlato, segundoPlato, postre;

	public Menu(double precio, String dia) throws IllegalArgumentException {
		if(dia == null)throw new IllegalArgumentException("Es necesario especificar el dia");
		if(precio<0)throw new IllegalArgumentException("El precio no puede ser negativo");
		this.precio=precio;
		this.dia=dia;
		primerPlato=new ArrayList<Plato>();
		segundoPlato=new ArrayList<Plato>();
		postre=new ArrayList<Plato>();
	}
	public Menu(double precio, String dia, Plato[] platos) throws IllegalArgumentException {
		this(precio, dia);
		addPlato(platos);
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
	public List<Plato> getPlatos() {
		List<Plato>listaPlatos= new ArrayList<>();
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
	public List<Plato> getPlatos(Filter filter) {
		List<Plato>listaPlatos= new ArrayList<>();
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
	public void setDia(String dia) {
		this.dia=dia;
	}
	public double getValoracion() {
		int i=0;
		double res=0;
		for(Plato plato:this.primerPlato) {
			for(Valoracion valoracion : plato.getValoraciones()) {
				i++;
				res += valoracion.getPuntuacion();
			}
		}
		for(Plato plato:this.segundoPlato) {
			for(Valoracion valoracion : plato.getValoraciones()) {
				i++;
				res += valoracion.getPuntuacion();
			}
		}
		for(Plato plato:this.postre) {
			for(Valoracion valoracion : plato.getValoraciones()) {
				i++;
				res += valoracion.getPuntuacion();
			}
		}
		return i==0?null:res/i;
	}
}
