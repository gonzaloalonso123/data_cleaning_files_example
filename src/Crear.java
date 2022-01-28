import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Crear {
	
	public static void main(String[] args) throws IOException {
		crear("mediciones.txt", "audiencia.obj");
	}
	
	public static void crear(String fichorigen, String fichdestino) throws IOException
	{
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(fichorigen));
		} catch (FileNotFoundException e) {
			System.out.println("No se ha encontrado el fichero");
			return;
		}
		
		File fdest = new File(fichdestino);
		if(!fdest.exists())
		{
			fdest.createNewFile();
		}
		
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fdest));
		
		String linea; 
		
		while((linea = br.readLine())!= null)
		{
			//Si el input dado en una de las lineas no coincide con el patron he decidido descartarlo 
			//para prevenir posibles fallos como la linea 1 
			
			if(linea.matches("\\d{1,2}+,\\d{1,2}+,cad\\d,\\d{1,2}+.\\d,\\d{1,2}+.\\d{1,2}+,\\d{1,2}+.\\d{1,2}+,\\d{1,2}+.\\d{1,2}+"))
			{	
				String[] campos = linea.split(",");
				System.out.println(Arrays.toString(campos));
				oos.writeObject(new Medicion(campos[0], campos[1], campos[2], campos[3], campos[4], campos[5], campos[6]));	
			}
		}
		oos.close();
	}
}
