package domain.gestion;
import domain.base.UnidadTransporte;
import java.util.ArrayList;
import java.util.List;

public class GestorFlota {
    private List<UnidadTransporte> flota = new ArrayList<>();

    public void agregarVehiculo(UnidadTransporte v) {
        this.flota.add(v);
    }

    public List<UnidadTransporte> getFlota() {
        return new ArrayList<>(this.flota); // Copia defensiva de la flota total
    }
    
    // Aquí podrías añadir lógica potente:
    /*public List<UnidadTransporte> buscarDisponibles() {
        // Lógica para filtrar vehículos con estado DISPONIBLE
    }*/
}