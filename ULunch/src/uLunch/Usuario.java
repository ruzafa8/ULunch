package uLunch;
import java.util.LinkedList;
import java.util.List;

public class Usuario {
	
	private String nombre;
	private String password;
	private String email;
	private boolean moderator;
	private boolean admin;
	private List<Alergias> alergias;
	
	public Usuario (String nombre,String password, String email, List<Alergias> alergias) throws IllegalArgumentException{
		if(password.length()<6)throw new IllegalArgumentException("Contraseña demasiado debil");
		this.nombre=nombre;
		this.password=password;
		this.email=email;
		this.alergias = new LinkedList<>();
		this.alergias.addAll(alergias);
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

	public void setPassword(String password)throws IllegalArgumentException {
		if(password.length()<6)throw new IllegalArgumentException("Contraseña demasiado debil");
		this.password = password;
	}
	
	public List<Alergias> getAlergias() {
		return alergias;
	}
	
	public void setAlergias(List<Alergias> alergias) {
		this.alergias.clear();
		this.alergias.addAll(alergias);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Usuario))
			return false;
		Usuario other = (Usuario) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}
	
	
}