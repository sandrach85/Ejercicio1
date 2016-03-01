package persistence.entities;

import javax.persistence.*;

@Entity
public class PersonaEntity {
	
	@Id
	@GeneratedValue
	private int id;
	
	private String nombre;
	
	@Embedded
	private CocheEntity cocheEntity;
	
	public PersonaEntity()
	{
		
	}

	public PersonaEntity(String nombre, CocheEntity coche)
	{
		this.nombre= nombre;
		this.cocheEntity= coche;
	}
	
	@Override
	public String toString()
	{
		return "PersonaEntity[id="+id+"nombre="+nombre+"coche="+cocheEntity+"]";
		
	}
	 @Override
	    public int hashCode() {
	        return id;
	    }

	    @Override
	    public boolean equals(Object obj) {
	        if (obj == null) {
	            return false;
	        } else if (getClass() != obj.getClass()) {
	            return false;
	        } else {
	            return id == ((PersonaEntity) obj).id;
	        }
	    }

	    public int getId() {
	        return id;
	    }

	    public String getNombre() {
	        return nombre;
	    }

	    public CocheEntity getCocheEntity() {
	        return cocheEntity;
	    }
	
}
