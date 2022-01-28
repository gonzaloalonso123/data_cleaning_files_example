import java.io.IOException;
import java.util.Scanner;

public class Lanzador {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		boolean funcionando = true;
		
		while(funcionando) {	
			System.out.println("\nElige que quieres hacer:");
	
			
			System.out.println("1.-Crear\n2.-Listar\n3.-Cuotas Pantalla\n4.-Salir");
			switch(Integer.parseInt(sc.nextLine()))
			{
			case 1:
				Crear.main(null);
				break;
			case 2:
				Listar.main(null);
				break;
			case 3:
				CuotasPantalla.main(null);
				break;
			case 4:
				funcionando = false;
			}
		}
	}

}
