import java.util.LinkedList;
import java.util.List;

public class Plato {

	private String nombre;
	private String imagen;
	private Dieta dieta;
	private List<Alergias> alergias;
	private List<Valoracion> valoracion;

	public Plato(String nombre, String imagen, Dieta dieta, List<Alergias> alergias) {
		this.nombre = nombre;
		this.imagen = imagen;
		this.dieta  = dieta;
		this.alergias = alergias;
		this.valoracion = new LinkedList<Valoracion>();
	}

	public void addValoracion(Usuario user, int puntuacion, String comentario){
		Valoracion val = new Valoracion(user, puntuacion, comentario);
		valoracion.add(val);
	}

	public double getPuntuacionMedia() {
		double media = 0;
		for(Valoracion val : valoracion) {
			media += val.getPuntuacion();
		}
		return media/valoracion.size();
	}

	public List<Valoracion> getValoraciones() {
		return valoracion;
	}

	public Dieta getDieta() {
		return dieta;
	}

	public List<Alergias> getAlergias(){
		return alergias;
	}

	public String getNombre() {
		return nombre;
	}

	public String getImagen() {
		return imagen;
	}

	@Override
	public boolean equals(Object obj){
		boolean res = obj instanceof Plato
		Plato plato = res?(Plato)obj:null;
		return plato != null && getNombre().equalsIgnoreCase(plato.getNombre())
			&& getDieta() == plato.getDieta()
			&& getAlergias().equals(plato.getAlergias());
	}
	@Override
	public int hashCode(){
		return getNombre().hashCodeIgnoreCase() +
			getDieta() + getAlergias().hashCode();
	}
}
