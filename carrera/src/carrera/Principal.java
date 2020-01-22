package carrera;

import java.util.Scanner;

public class Principal {



	public static void jugar(Coche coche) {
		int opc = 0;
		Menu menu = new Menu();

		do {
			imprimirSituacionCarrera(coche);
			opc = menu.menuCarrera();
			switch (opc) {
			case 1:
				coche.acelerar();
				break;
			case 2:
				coche.frenar();
				break;
			case 3:
				coche.rearrancar();
				break;
			}

		} while (coche.getKmRecoridos() <= coche.getDistanciaCarrera());
	}

	private static void imprimirSituacionCarrera(Coche c) {
		System.out.println(c.toString());
	}

	public static void main(String[] args) {
		Scanner leer = new Scanner(System.in);
		
		int opc = 0;
		String nombreCarrera;
		double distancia;
		
		System.out.println("Nombre de la carrera");
		nombreCarrera = leer.nextLine();
		leer = new Scanner(System.in);
		System.out.println("Distancia de la carrera");
		distancia = leer.nextDouble();
		
		Carrera carrera = new Carrera(nombreCarrera, distancia);

		Menu menu = new Menu();

		do {
			opc = menu.menuJugador();
			switch (opc) {
			case 1:
				if (carrera.isConfigurada()) {
					//carrera.jugar();
				}else {
					System.out.println("Carrera sin configurar");
				}
				
			case 2:
				carrera.configurarCarrera();
				break;
			case 3:
				System.out.println("Has salido del juego");
				break;
			}
		} while (opc != 3);

	}

}
