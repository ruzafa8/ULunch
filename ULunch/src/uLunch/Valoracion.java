package uLunch;
public class Valoracion {
	
	private int puntuacion;
	private String comentario;
	private Usuario user;
	
	public Valoracion(Usuario user, int puntuacion)throws IllegalArgumentException {
		if(puntuacion<0 || puntuacion > 5)throw new IllegalArgumentException("La puntuacion debe ser un entero entre 0 y 5");
		this.user = user;
		this.puntuacion = puntuacion;
	}
	
	public Valoracion(Usuario user, int puntuacion, String comentario)throws IllegalArgumentException {
		this(user, puntuacion);
		this.comentario = comentario;
	}

	public String getComentario() {
		return comentario;
	}

	public int getPuntuacion() {
		return puntuacion;
	}

	public Usuario getUser() {
		return user;
	}
	
	

}
