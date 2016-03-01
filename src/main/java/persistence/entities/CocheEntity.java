package persistence.entities;

import javax.persistence.*;

@Embeddable
public class CocheEntity {

	private String matricula;
	private String modelo;
	
	public CocheEntity()
	{
		
	}
	
	public CocheEntity(String mat, String mod)
	{
		this.matricula= mat;
		this.modelo= mod;
	}

	@Override
	public String toString() {
		return "CocheEntity [matricula=" + matricula + ", modelo=" + modelo + "]";
	}

	public String getMatricula() {
		return matricula;
	}

	public String getModelo() {
		return modelo;
	}
	
	
}
