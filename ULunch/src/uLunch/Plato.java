package uLunch;
import java.util.LinkedList;
import java.util.List;

public class Plato {
	
	private String nombre;
	private String imagen;
	private Dieta dieta;
	private List<Alergias> alergias;
	private List<Valoracion> valoracion;
	
	public Plato(String nombre, String imagen, Dieta dieta, List<Alergias> alergias)throws IllegalArgumentException {
		if(nombre == null)throw new IllegalArgumentException("Es necesario especificar el nombre");
		if(dieta == null)throw new IllegalArgumentException("Es necesario especificar la dieta");
		this.nombre = nombre;
		this.imagen = imagen;
		this.dieta  = dieta;
		this.alergias = new LinkedList<>();
		this.alergias.addAll(alergias);
		this.valoracion = new LinkedList<Valoracion>();
	}
	
	public void addValoracion(Usuario user, int puntuacion, String comentario)throws IllegalArgumentException{
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alergias == null) ? 0 : alergias.hashCode());
		result = prime * result + ((dieta == null) ? 0 : dieta.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Plato))
			return false;
		Plato other = (Plato) obj;
		if (alergias == null) {
			if (other.alergias != null)
				return false;
		} else if (!alergias.equals(other.alergias))
			return false;
		if (dieta != other.dieta)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equalsIgnoreCase(other.nombre))
			return false;
		return true;
	}
}
