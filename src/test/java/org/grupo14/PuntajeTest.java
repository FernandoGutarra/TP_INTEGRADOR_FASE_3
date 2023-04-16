package org.grupo14;

import org.junit.Test;

import com.opencsv.exceptions.CsvValidationException;

import exceptions.NingunoOMasDeUnEquipoPronosticadoException;
import exceptions.NoEsNumeroEnteroException;
import exceptions.NumeroIncorrectoDeCamposException;
import modelo.Equipo;
import modelo.Participante;
import modelo.Partido;
import modelo.Pronostico;
import servicios.LectorArchivos;

import java.io.IOException;
import java.util.ArrayList;

public class PuntajeTest {

	@Test
	public void validarCalculoDePuntaje() {
		
		String rutaArchivoResultados = "src/main/resources/resultados.csv";
		String rutaArchivoPronosticos = "src/main/resources/pronosticos.csv";
		
		try {
			boolean correcto = Main.validarArchivos(rutaArchivoResultados, rutaArchivoPronosticos);
		
			if(correcto) {
		
				LectorArchivos lectorArchivos1 = new LectorArchivos(rutaArchivoResultados);
		        
		        //Obtengo todas las líneas del archivo CSV "Resultados"
		        lectorArchivos1.parsearArchivo("R");
		        
		        //Creo equipos
		        ArrayList<Equipo> equipos = lectorArchivos1.crearEquipos();
		        
		        //Creo Partidos            
		        ArrayList<Partido> partidos = lectorArchivos1.crearPartidos(equipos);               
		        
		        
		        LectorArchivos lectorArchivos2 = new LectorArchivos(rutaArchivoPronosticos);
		        
		        //Obtengo todas las líneas del archivo CSV "Pronosticos"
		        lectorArchivos2.parsearArchivo("P");
		        
		        //Creo Pronosticos           
		        ArrayList<Pronostico> pronosticos = lectorArchivos2.crearPronosticos(equipos, partidos);    
		
		        //Creo Participantes
		        ArrayList<Participante> participantes = lectorArchivos2.crearParticipantes(pronosticos);
		        
		        ArrayList<Participante> p = new ArrayList<Participante>();
		        p.add(participantes.get(0));
		        
		        
		        //Calculo Y Muestro Puntaje de un Participante
				Main.calcularPuntajePorRonda(1, pronosticos, p,0);
		        p.get(0).setPuntajeTotal(0);
		        Main.calcularPuntajePorRonda(2, pronosticos, p, 0) ;
        
			}
		
		} catch (CsvValidationException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NumeroIncorrectoDeCamposException e) {
			System.out.println("\n ----- La cantidad de campos de los archivos es incorrecta! ----- \n");
		} catch (NoEsNumeroEnteroException e) {
			System.out.println("\n ----- La Ronda y la Cantidad de Goles deben ser Numeros Enteros! ----- \n");
		} catch (NingunoOMasDeUnEquipoPronosticadoException e) {
			System.out.println("\n ----- Se debe seleccionar un Equipo por Pronostico! ----- \n");
		}
			
	}

}
