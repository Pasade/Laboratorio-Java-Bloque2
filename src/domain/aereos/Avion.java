package domain.aereos;
import java.util.List;
import java.util.ArrayList;
import domain.base.UnidadTransporte;
import domain.interfaces.Volable;
import domain.enums.EstadoVehiculo;
import domain.enums.TipoIdentificador;
public class Avion extends UnidadTransporte implements Volable {

    private double autonomiaMaxima;
    private double altitudMaxima;

    @Override
    public void volar() {
    // Código pendiente de implementar
    }

    //Constructor
    public Avion(String id, TipoIdentificador tipoIdentificador, String marca, String modelo, EstadoVehiculo estado, 
                 double capacidadTanque, double nivelCombustibleLitros, double consumoPorKilometro, 
                 double cargaMaximaKilos, double capacidadMaximaVolumen, double autonomiaMaxima, double altitudMaxima) {
        
        super(id, tipoIdentificador, marca, modelo, estado, capacidadTanque, 
              nivelCombustibleLitros, consumoPorKilometro, cargaMaximaKilos, capacidadMaximaVolumen);
              this.autonomiaMaxima = autonomiaMaxima;
              this.altitudMaxima = altitudMaxima;
    }
}