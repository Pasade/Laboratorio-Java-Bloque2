package domain.navales;
import java.util.List;
import java.util.ArrayList;
import domain.base.UnidadTransporte;
import domain.interfaces.Navegable;
import domain.enums.EstadoVehiculo;
import domain.enums.TipoIdentificador;
public class Barco extends UnidadTransporte implements Navegable {
    private double eslora;
    private String bandera;

    @Override
    public void navegar() {
    // Código pendiente de implementar
    }

    //Constructor
    public Barco(String id, TipoIdentificador tipoIdentificador, String marca, String modelo, EstadoVehiculo estado, 
                 double capacidadTanque, double nivelCombustibleLitros, double consumoPorKilometro, 
                 double cargaMaximaKilos, double capacidadMaximaVolumen, double eslora, String bandera) {
        
        super(id, tipoIdentificador, marca, modelo, estado, capacidadTanque, 
              nivelCombustibleLitros, consumoPorKilometro, cargaMaximaKilos, capacidadMaximaVolumen);
              this.eslora = eslora;
              this.bandera = bandera;
    }
}