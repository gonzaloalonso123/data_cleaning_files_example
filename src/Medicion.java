import java.io.Serializable;
import java.util.Arrays;

public class Medicion implements Serializable {

	private String[] hora = new String[2];

	public enum cad {
		cad1, cad2, cad3
	}

	cad cad;
	private double ninos;
	private double jovenes;
	private double adultos;
	private double mayores;
	private double todos;

	public Medicion(String hora1, String hora2, String cad, String ninos, String jovenes, String adultos,
			String mayores) {
		this.hora[0] = hora1;
		this.hora[1] = hora2;
		this.ninos = Double.parseDouble(ninos);
		this.jovenes = Double.parseDouble(jovenes);
		this.adultos = Double.parseDouble(adultos);
		this.mayores = Double.parseDouble(mayores);
		this.todos = this.ninos + this.jovenes + this.adultos + this.mayores;
		switch (cad) {
		case "cad1":
			this.cad = this.cad.cad1;
			break;
		case "cad2":
			this.cad = this.cad.cad2;
			break;
		case "cad3":
			this.cad = this.cad.cad3;
			break;
		}

	}

	@Override
	public String toString() {
		String medicion = "Hora    : " + this.hora[0] + ":" + this.hora[1] + "\nCadena  : " + this.cad.toString().charAt(3) + "\nNiños   : "
				+ (int)this.ninos * 10000 + "\nJovenes : " + (int)this.jovenes * 10000 + "\nMayores : " + (int)this.mayores * 10000
				+ "\nTodos   : " + (int)this.todos * 10000 + "\n----------------\n";
		return medicion;
	}

	public String[] getHora() {
		return hora;
	}

	public double getNinos() {
		return ninos;
	}

	public double getJovenes() {
		return jovenes;
	}


	public double getAdultos() {
		return adultos;
	}

	public double getMayores() {
		return mayores;
	}

	public double getTodos() {
		return todos;
	}


	

}