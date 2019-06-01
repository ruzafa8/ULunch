
public class Valoracion {
	
	private int puntuacion;
	private String comentario;
	private Usuario user;
	
	public Valoracion(Usuario user, int puntuacion, String comentario) {
		this.user = user;
		this.puntuacion = puntuacion;
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
