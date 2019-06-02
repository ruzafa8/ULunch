package uLunch;
import java.util.List;

public class Usuario {
	
	private String nombre;
	private String password;
	private String email;
	private boolean moderator;
	private boolean admin;
	private List<Alergias> alergias;
	
	public Usuario (String nombre,String password, String email, List<Alergias> alergias) {
		this.nombre=nombre;
		this.password=password;
		this.email=email;
		this.alergias = alergias;
		moderator = false;
		admin = false;
	}
	
	public boolean login (String email, String password) {		
		return email.equals(this.email) && password.equals(this.password);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isModerator() {
		return moderator;
	}

	public void setModerator(boolean moderator) {
		this.moderator = moderator;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public List<Alergias> getAlergias() {
		return alergias;
	}
	
	public void setAlergias(List<Alergias> alergias) {
		this.alergias = alergias;
	}
	
	
}