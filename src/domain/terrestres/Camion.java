package domain.terrestres;
import java.util.List;
import java.util.ArrayList;
import domain.base.UnidadTransporte;
import domain.interfaces.Circulable;
import domain.enums.EstadoVehiculo;
import domain.enums.TipoIdentificador;
public class Camion extends UnidadTransporte implements Circulable {
    private int numeroEjes;
    private boolean tieneRemolque;

    @Override
    public void circular() {
    // Código pendiente de implementar
    }

    //Cosntructor
    public Camion(String id, TipoIdentificador tipoIdentificador, String marca, String modelo, EstadoVehiculo estado, 
                  double capacidadTanque, double nivelCombustibleLitros, double consumoPorKilometro, 
                  double cargaMaximaKilos, double capacidadMaximaVolumen, int numeroEjes, boolean tieneRemolque) {
        
        super(id, tipoIdentificador, marca, modelo, estado, capacidadTanque, 
              nivelCombustibleLitros, consumoPorKilometro, cargaMaximaKilos, capacidadMaximaVolumen);
        this.numeroEjes = numeroEjes;
        this.tieneRemolque = tieneRemolque;
    }

    //GETTERS Y SETTERS (POR CONSTRUIR)
}