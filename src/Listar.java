import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Listar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		muestraFichero(paraMostrar("audiencia.obj"));
	}

	public static ArrayList paraMostrar(String nomfich) {
		ArrayList<Medicion> mediciones = new ArrayList<Medicion>();

		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomfich));
			while (true) {
				try {
					mediciones.add((Medicion) ois.readObject());
				} catch (Exception e) {
					ois.close();
					break;
				}
			}
		} catch (IOException e) { System.out.println();
		}
		return mediciones;
	}

	public static void muestraFichero(ArrayList<Medicion> listaObjectosFichero) {
		for (Medicion m : listaObjectosFichero) {
			System.out.println(m.toString());
		}
	}
}