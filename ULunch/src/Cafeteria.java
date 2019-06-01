
public class Cafeteria {
	private String nombre;
	private long ubicacion;
	private int afluencia;
	private Menu menu;
	
	public Cafeteria(String nom, long ubi) {
		nombre=nom;
		ubicacion=ubi;
	}
	public void addMenu(Menu m) {
		menu=m;
	}
	public Menu getMenu() {
		return menu;
	}
	public String getNombre() {
		return nombre;
	}
	public setNombre(String nom) {
		nobmre=nom;
	}
	public long getUbicacion() {
		return ubicacion
	}
	public void setUbicacion(long ubi) {
		ubicacion=ubi;
	}
	public int getAfluencia() {
		return afluencia;
	}
	public void setAfluencia(int af) {
		afluencia=af;
	}
}
