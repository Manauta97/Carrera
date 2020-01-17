package carrera;

import java.util.Scanner;

public class Principal {

	public static Coche crearCoche() {
		Scanner leer = new Scanner(System.in);
		String nombrePiloto = "";
		int dorsal = 0;
		double distanciaCarrera = 0;

		System.out.println("Introduce el nombre del Piloto");
		nombrePiloto = leer.nextLine();

		leer = new Scanner(System.in);
		System.out.println("Introduce el número de dorsal");
		dorsal = leer.nextInt();

		leer = new Scanner(System.in);
		System.out.println("Distancia de la carrera");
		distanciaCarrera = leer.nextDouble();

		Coche c1 = new Coche(nombrePiloto, dorsal, distanciaCarrera);
		
		return c1;
	}

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
		int opc = 0;
		Coche coche = null;

		Menu menu = new Menu();

		do {
			opc = menu.menuJugador();
			switch (opc) {
			case 1:
				if (coche != null) {
					coche.arrancar();
					jugar(coche);
					System.out.println("carrera finalizada");
					//Escribiremos el podium
				} else {
					System.out.println("Carrera no configurada, necesitas introducir al jugador");
				}
				break;
			case 2:
				coche = crearCoche();
				break;
			case 3:
				System.out.println("Has salido del juego");
				break;

			default:
				break;
			}
		} while (opc != 3);

	}

}
