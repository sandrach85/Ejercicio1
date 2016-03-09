package persistence.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class User {

	@Id
	@GeneratedValue
	private int id;
	
	private String name;
	
	private String rol;
	
	public User() {
	}

	public User(String name, String rol) {
		super();
		this.name = name;
		this.rol = rol;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", rol=" + rol + "]";
	}

	@Override
	public int hashCode() {
		return id;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (rol == null) {
			if (other.rol != null)
				return false;
		} else if (!rol.equals(other.rol))
			return false;
		return true;
	}
	
	
	
}
