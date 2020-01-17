package carrera;

import java.util.Scanner;

public class Menu {

	public int menuJugador() {
		Scanner leer = new Scanner(System.in);
		int opc = 0;
		boolean bandera = true;

		do {

			try {
				do {
					leer = new Scanner(System.in);
					System.out.println("1. Iniciar Carrera");
					System.out.println("2. Añadir Coche");
					System.out.println("3. Salir");
					opc = leer.nextInt();
					bandera = true;

				} while (opc < 1 || opc > 3);

			} catch (NullPointerException e) {
				System.out.println("datos mal introducidos");
				bandera = false;
			} catch (Exception e) {
				System.out.println("datos mal introducidos");
				bandera = false;
			}
		} while (!bandera);
		return opc;
	}

	public int menuCarrera() {

		Scanner leer = new Scanner(System.in);
		int opc = 0;
		boolean bandera = true;

		do {

			try {
				do {
					leer = new Scanner(System.in);
					System.out.println("1. Acelerar");
					System.out.println("2. Frenar");
					System.out.println("3. Rearrancar");
					opc = leer.nextInt();
					bandera = true;

				} while (opc < 1 || opc > 3);

			} catch (NullPointerException e) {
				System.out.println("datos mal introducidos");
				bandera = false;
			} catch (Exception e) {
				System.out.println("datos mal introducidos");
				bandera = false;
			}
		} while (!bandera);
		return opc;
	}
}
