package carrera;

import java.util.Random;
import java.util.Scanner;

public class Coche {
	private String nombrePiloto;
	private int dorsal;
	private double distanciaCarrera;
	private String estado;
	private int potencia;
	private double velocidad;
	private double kmRecoridos;

	public Coche(String nombrePiloto, int dorsal, double distanciaCarrera) {
		this.nombrePiloto = nombrePiloto;
		this.dorsal = dorsal;
		this.distanciaCarrera = distanciaCarrera;
		this.estado = "parado";
		this.potencia = 50;
		this.velocidad = 0;
		this.kmRecoridos = 0;

	}

	public void arrancar() {

		this.estado = "marcha";
	}

	public void acelerar() {

		Random r = new Random();
		double acelerar = r.nextInt(potencia + 1);

		if ((acelerar + velocidad) > 200) {
			estado = "accidentado";
			velocidad = 0;
		} else {
			velocidad += acelerar;
			kmRecoridos += acelerar;
		}
	}

	public void frenar() {
		Random r = new Random();
		double frenazo = r.nextInt(potencia + 1);

		if (velocidad <= frenazo) {
			velocidad = 0;
			kmRecoridos += velocidad;
		} else {
			velocidad -= frenazo;
			kmRecoridos += velocidad;
		}
	}

	public void rearrancar() {

		if (estado == "accidentado") {

			estado = "marcha";

		} else {
			System.out.println("el coche ya se encuentra arrancado");
		}

	}

	public double getDistanciaCarrera() {
		return distanciaCarrera;
	}

	public void setDistanciaCarrera(double distanciaCarrera) {
		this.distanciaCarrera = distanciaCarrera;
	}

	public double getKmRecoridos() {
		return kmRecoridos;
	}

	public void setKmRecoridos(double kmRecoridos) {
		this.kmRecoridos = kmRecoridos;
	}

	public double getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(double velocidad) {
		this.velocidad = velocidad;
	}

	@Override
	public String toString() {
		return "El piloto: " + nombrePiloto + " con el dorsal: " + dorsal + " lleva una velocidad de: " + getVelocidad()
				+ " llevando recorridos: " + kmRecoridos + "Km";
	}

}
