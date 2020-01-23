package carrera;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Carrera {

	private Coche[] vParticipantes;
	private Coche[] podium;
	private String nombreCarrera;
	private double distancia;

	public Carrera(String nombreCarrera, double distancia) {

		this.vParticipantes = new Coche[5];
		this.nombreCarrera = nombreCarrera;
		this.distancia = distancia;
	}

	public Coche[] getvParticipantes() {
		return vParticipantes;
	}

	public void setvParticipantes(Coche[] vParticipantes) {
		this.vParticipantes = vParticipantes;
	}

	public String getNombreCarrera() {
		return nombreCarrera;
	}

	public void setNombreCarrera(String nombreCarrera) {
		this.nombreCarrera = nombreCarrera;
	}

	public double getDistancia() {
		return distancia;
	}

	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}

	@Override
	public String toString() {
		return "Nombre de la carrera:" + nombreCarrera + " nº de participantes: " + Arrays.toString(vParticipantes)
				+ "distancia de la carrera " + distancia + "Km";
	}

	public boolean isConfigurada() {
		int contador = 0;
		// busco dos coches
		for (Coche coche : vParticipantes) {
			if (coche != null) {
				contador++;
			}

			if (contador >= 2) {
				return true;
			}
		}
		return false;
	}

	public void añadirPilotoHumano() {
		Scanner leer = new Scanner(System.in);

		String nombrePiloto = "";
		int dorsal = 0;
		boolean bandera = true;

		for (int i = 0; i < vParticipantes.length; i++) {
			if (vParticipantes[i] == null) {
				bandera = false;
				leer = new Scanner(System.in);
				System.out.println("Nombre del piloto");
				nombrePiloto = leer.nextLine();

				System.out.println("Dorsal del piloto");

				do {
					leer = new Scanner(System.in);
					dorsal = leer.nextInt();
				} while (comprobarDorsal(dorsal));
				// compruebo que no este
				Coche c = new Coche(nombrePiloto, dorsal, this.distancia, false);
				vParticipantes[i] = c;
				break;
			}
		}
		if (bandera) {
			System.out.println("No hay más huecos");
		}

	}

	public void añadirPilotoBot() {
		String nombrePiloto = "";
		int dorsal = 0;
		boolean bandera = true;

		Random r = new Random();
		for (int i = 0; i < vParticipantes.length; i++) {
			if (vParticipantes[i] == null) {

				bandera = false;

				nombrePiloto = "Bot " + i;

				do {

					dorsal = r.nextInt(20);
				} while (comprobarDorsal(dorsal));
				// compruebo que no este
				Coche c = new Coche(nombrePiloto, dorsal, this.distancia, true);
				vParticipantes[i] = c;
				break;
			}
		}

		if (bandera) {
			System.out.println("No hay más huecos");
		}

	}

	public boolean comprobarDorsal(int dorsal) {

		for (Coche coche : vParticipantes) {
			if (coche != null && coche.getDorsal() == dorsal) {
				System.out.println("Dorsal repetido");
				return true;
			}
		}

		return false;
	}

	public void configurarCarrera() {
		Scanner leer = new Scanner(System.in);
		Menu menu = new Menu();
		// Crear piloto humano o maquina
		int opc = 0;
		do {
			opc = menu.menuCreacionJugador();
			switch (opc) {
			case 1:
				añadirPilotoHumano();
				break;
			case 2:
				añadirPilotoBot();
				break;
			case 3:
				System.out.println("Fin de configuración");
				break;
			}
		} while (opc != 3);

	}

	private void subirCochePodium(Coche coche) {

		for (int i = 0; i < vParticipantes.length; i++) {

			if (coche != null && coche.getEstado().equalsIgnoreCase("terminado")) {
				podium[i] = coche;
				System.out.println("el participante " + i + "ha terminado " + i + "º posición");
			}
		}
	}

	public void jugar() {

		int opc = 0;
		Menu menu = new Menu();
		Coche coche;

		Random r = new Random();
		int accionBot;

		arrancarTodosCoches();
		do {

			for (int i = 0; i < vParticipantes.length; i++) {
				if (vParticipantes[i] != null) {
					coche = vParticipantes[i];
				} else {
					continue; // Saltamos a la siguiente posicion del vector
				}

				if (!coche.getBot()) {
					if (coche.getEstado().equalsIgnoreCase("terminado")) {
						System.out.println("el coche ha terminado");
					} else {
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
						subirCochePodium(coche);
					}

				} else {
					imprimirSituacionCarrera(coche);
					if (coche.getEstado() == "accidentado") {
						coche.rearrancar();
					} else {
						accionBot = r.nextInt(2);
						if (accionBot == 1) {
							coche.acelerar();
						} else {
							coche.frenar();
						}
					}

				}

			}
		} while (!juegoTerminado());
	}

	private void arrancarTodosCoches() {

		for (int i = 0; i < vParticipantes.length; i++) {
			if (vParticipantes[i] != null) {
				vParticipantes[i].arrancar();
			}
		}

	}

	private boolean juegoTerminado() {
		boolean bandera = true;

		for (Coche coche : vParticipantes) {
			if (coche != null && coche.getEstado().equalsIgnoreCase("marcha")) {
				bandera = false;
			}

		}

		return bandera;
	}

	private void imprimirSituacionCarrera(Coche c) {
		System.out.println(c.toString());
	}

}
