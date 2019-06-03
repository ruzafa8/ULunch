package uLunch;
import java.util.List;


public class Cafeteria {
	private String nombre;
	private long ubicacion[];
	private int afluencia;
	private List<Menu> menu;
	
	public Cafeteria(String nom, long ubicacion[]) {
		nombre=nom;
		this.ubicacion = ubicacion.clone();
	}
	public Cafeteria(String nom, long ubicacion[],List<Menu> menus) {
		this(nom, ubicacion);
		addMenus(menus);
	}
	public void addMenu(Menu menu) {
		this.menu.add(menu);
	}
	public void addMenus(List<Menu> menus) {
		for(Menu m : menus) {
			this.addMenu(m);
		}
	}
	public List<Menu> getMenu() {
		return menu;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public long[] getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(long ubicacion[]) {
		this.ubicacion = ubicacion;
	}
	public int getAfluencia() {
		return afluencia;
	}
	public void setAfluencia(int afluencia) {
		this.afluencia = afluencia;
	} 
}
