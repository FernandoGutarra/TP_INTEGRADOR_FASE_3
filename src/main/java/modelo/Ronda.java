package modelo;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Ronda {

	private int nro;
	private List<Partido> partidos;
	
	public Ronda(int nro) {
		this.setNro(nro);
		this.partidos = new ArrayList<Partido>();
	}
	
	public void agregarPartido(Partido p) {
		this.partidos.add(p);
	}
	
	public void quitarPartido(Partido p) {
		this.partidos.remove(p);
	}
	
}
