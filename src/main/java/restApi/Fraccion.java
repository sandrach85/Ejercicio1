package restApi;

public class Fraccion {
	private int numerador;
	private int denomnador;
	
	public Fraccion() {
		
	}
	public Fraccion(int numerador, int denomnador) {
		super();
		this.numerador = numerador;
		this.denomnador = denomnador;
	}
	public int getNumerador() {
		return numerador;
	}
	public void setNumerador(int numerador) {
		this.numerador = numerador;
	}
	public int getDenomnador() {
		return denomnador;
	}
	public void setDenomnador(int denomnador) {
		this.denomnador = denomnador;
	}
	@Override
	public String toString() {
		return "Fraccion [numerador=" + numerador + ", denomnador=" + denomnador + "]";
	}

	
}
