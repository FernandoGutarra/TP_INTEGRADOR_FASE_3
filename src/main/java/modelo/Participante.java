package modelo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Participante implements Comparable<Participante>{

	private String nombre;
	private int puntajeTotal;
	
	public Participante(String nombre, int puntajeTotal) {
		this.setNombre(nombre);
		this.setPuntajeTotal(puntajeTotal);
	}
	
	 @Override
     public int compareTo(Participante p) {
        String a = new String(String.valueOf(this.getPuntajeTotal()));
        String b = new String(String.valueOf(p.getPuntajeTotal()));
        return a.compareTo(b);
    }
	
}
