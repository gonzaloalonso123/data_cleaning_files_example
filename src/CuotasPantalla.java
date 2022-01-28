import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class CuotasPantalla {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		mostrarMatriz(consultarArchivo("audiencia.obj"));

	}

	public static int[][] consultarArchivo(String f) {
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
			ArrayList<Medicion> mediciones = Listar.paraMostrar(f);
			int[][] matriz = new int[3][5];
			for (Medicion m : mediciones) {
				if (Integer.parseInt(m.getHora()[0]) >= 0 && Integer.parseInt(m.getHora()[0]) <= 7) {
					if (m.cad == m.cad.cad1) {
						matriz[0][0] += (int) m.getTodos() * 10000;}
					else if (m.cad == m.cad.cad2) {
						matriz[1][0] += (int) m.getTodos() * 10000;}
					else if (m.cad == m.cad.cad3) {
						matriz[2][0] += (int) m.getTodos() * 10000;}
				} else if (Integer.parseInt(m.getHora()[0]) > 7 && Integer.parseInt(m.getHora()[0]) <= 14) {
					if (m.cad == m.cad.cad1) {
						matriz[0][1] += (int) m.getTodos() * 10000;}
					else if (m.cad == m.cad.cad2) {
						matriz[1][1] += (int) m.getTodos() * 10000;}
					else if (m.cad == m.cad.cad3) {
						matriz[2][1] += (int) m.getTodos() * 10000;}
				} else if (Integer.parseInt(m.getHora()[0]) > 14 && Integer.parseInt(m.getHora()[0]) <= 20) {
					if (m.cad == m.cad.cad1) {
						matriz[0][2] += (int) m.getTodos() * 10000;}
					else if (m.cad == m.cad.cad2) {
						matriz[1][2] += (int) m.getTodos() * 10000;}
					else if (m.cad == m.cad.cad3) {
						matriz[2][2] += (int) m.getTodos() * 10000;}
				} else if (Integer.parseInt(m.getHora()[0]) > 20 && Integer.parseInt(m.getHora()[0]) < 24) {
					if (m.cad == m.cad.cad1) {
						matriz[0][3] += (int) m.getTodos() * 10000;}
					else if (m.cad == m.cad.cad2) {
						matriz[1][3] += (int) m.getTodos() * 10000;}
					else if (m.cad == m.cad.cad3) {
						matriz[2][3] += (int) m.getTodos() * 10000;}
				}
			}
			matriz[0][4] = matriz[0][0] + matriz[0][1] + matriz[0][2] + matriz[0][3];
			matriz[1][4] = matriz[1][0] + matriz[1][1] + matriz[1][2] + matriz[1][3];
			matriz[2][4] = matriz[2][0] + matriz[2][1] + matriz[2][2] + matriz[2][3];
			return matriz;

		} catch (Exception e) {return new int[3][5];}
	}
	
	public static void mostrarMatriz(int[][] matriz)
	{
		System.out.println();
		System.out.printf("        | %-13s|%-13s|%-13s|%-13s|%-13S", "MADRUGADA", "MAÑANA", "TARDE", "PRIME TIME", "TOTAL");
		System.out.println("\n  ------+--------------+-------------+-------------+-------------+---------+");
		System.out.printf("  CAD1  | %-13d|%-13d|%-13d|%-13d|%-13d\n", matriz[0][0], matriz[0][1], matriz[0][2], matriz[0][3], matriz[0][4]);
		System.out.println("  ------+--------------+-------------+-------------+-------------+---------+");		
		System.out.printf("  CAD2  | %-13d|%-13d|%-13d|%-13d|%-13d\n", matriz[1][0], matriz[1][1], matriz[1][2], matriz[1][3], matriz[1][4]);
		System.out.println("  ------+--------------+-------------+-------------+-------------+---------+");
		System.out.printf("  CAD3  | %-13d|%-13d|%-13d|%-13d|%-13d\n", matriz[2][0], matriz[2][1], matriz[2][2], matriz[2][3], matriz[2][4]);
		System.out.println("  ------+--------------+-------------+-------------+-------------+---------+");
		
		
	}

}
