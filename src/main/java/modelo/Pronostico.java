package modelo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pronostico {
	
	private String participante;
	private Partido partido;
	private Equipo equipo;
	private ResultadoEnum resultado;
	private int puntaje;
	
	public Pronostico(String participante, Partido partido, Equipo equipo) {
		this.setPartido(partido);
		this.setEquipo(equipo);
		this.setParticipante(participante);
	}
	
	public int puntos() {
		int puntaje = 0;
		
		String nombreGanador = this.getPartido().ganadorReal();
		
		if(nombreGanador.equals(this.getEquipo().getNombre())) {
			puntaje++; 
		}
		
		return puntaje;
	}
}

