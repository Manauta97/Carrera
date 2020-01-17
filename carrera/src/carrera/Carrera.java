package carrera;

import java.util.Arrays;

public class Carrera {

	private Coche[] vParticipantes;
	private String nombreCarrera;
	private double distancia;

	public Carrera(Coche[] vParticipantes, String nombreCarrera, double distancia) {

		this.vParticipantes = new Coche[10];
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

}
