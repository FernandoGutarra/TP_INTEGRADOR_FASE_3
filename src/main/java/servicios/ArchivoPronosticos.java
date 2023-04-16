package servicios;

import com.opencsv.bean.CsvBindByPosition;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArchivoPronosticos {
    @CsvBindByPosition(position = 0)
    private String participante;
    @CsvBindByPosition(position = 1)
    private String equipo1;
    @CsvBindByPosition(position = 2)
    private String gana1;
    @CsvBindByPosition(position = 3)
    private String empate;
    @CsvBindByPosition(position = 4)
    private String gana2;
    @CsvBindByPosition(position = 5)
    private String equipo2;

    
}