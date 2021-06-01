package ar.edu.unlam.pb2.quemado;

import java.util.ArrayList;
import java.util.List;

public class Quemado {

	private Integer cantidadJugadores;
	private List<Integer> equipoRojo;
	private List<Integer> equipoAzul;
	private Integer contadorDeJugadoresRojo;
	private Integer contadorDeJugadoresAzul;

	public Quemado(Integer cantidadJugadores) {

		this.cantidadJugadores = cantidadJugadores;
		equipoRojo = new ArrayList<>();
		equipoAzul = new ArrayList<>();
		contadorDeJugadoresRojo = 0;
		contadorDeJugadoresAzul = 0;
		inicializarListaJugadores(equipoRojo,cantidadJugadores);
		inicializarListaJugadores(equipoAzul,cantidadJugadores);
	}
	
	private void inicializarListaJugadores(List<Integer> equipo, Integer jugadoresPorEquipo) {
		for(int i=0; i < jugadoresPorEquipo;i++) {
			equipo.add(i);
		}
	}

	public Integer contarJugadoresQuemados(Equipo color) {

		if (color == Equipo.AZUL) {
			return contadorDeJugadoresAzul;
		} else {
			return contadorDeJugadoresRojo;
		}

	}

	public List<Integer> obtenerCamisetasDeJugadoresNoQuemados(Equipo color) {

		if (color == Equipo.AZUL) {
			return equipoAzul;
		} else {
			return equipoRojo;
		}

	}

	public void quemarJugardor(Equipo color, Integer numeroCamiseta) {

		if (color == Equipo.AZUL) {
			contadorDeJugadoresAzul++;
			equipoAzul.remove(numeroCamiseta);
		} else {
			contadorDeJugadoresRojo++;
			equipoRojo.remove(numeroCamiseta);
		}

	}

	public Boolean termino() {

		Boolean terminado = false;

		if (equipoAzul.size()==0) {
			terminado = true;
		}
		if (equipoRojo.size()==0) {
			terminado = true;
		}

		return terminado;
	}

	public Equipo obtenerGanador() {
		Equipo ganador = null;
		if (equipoAzul.size()==0) {
			ganador = Equipo.ROJO;
		}
		if (equipoRojo.size()==0) {
			ganador = Equipo.AZUL;
		}
		return ganador;
	}

}
