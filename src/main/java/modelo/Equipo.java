package modelo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Equipo {

	private String nombre;
	private String descripcion;
	
	public Equipo(String nombre) {
		this.setNombre(nombre);
	}	
}