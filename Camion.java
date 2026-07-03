import java.util.ArrayList;
import java.util.List;
public class Camion{
    //Creamos un Array dinámico para poder meter los paquetes (Como si fuera un camión)
    private ArrayList<Paquete> listaDeEnvios = new ArrayList<>();
    private String matricula;
    private int capacidad;

    //Constructor
    public Camion(String matricula, int capacidad){
        this.matricula = matricula;
        this.capacidad = capacidad;
    }

    //Getters y setter
    public String getMatricula(){return this.matricula;}
    public void setMatricula(String nuevaMatricula){
        this.matricula = nuevaMatricula;
    }
    public int getCapacidad(){return this.capacidad;}
    public void setCapacidad(int nuevaCapacidad){
        if(nuevaCapacidad < 0){
            System.out.println("La capacidad del camión no puede ser 0 on negativa");
        }
        else{
            this.capacidad = nuevaCapacidad;
        }
    }

    //Metodo para meter paquetes dentro del camión uno a uno
    public void agregarPaquete(Paquete nuevoPaquete){
        if(listaDeEnvios.size() >= this.capacidad){
            System.out.printf("Capacidad del camión superada, la capacidad actual es de %d e intentas meter %d", this.capacidad, listaDeEnvios.size());
        }
        else{
            listaDeEnvios.add(nuevoPaquete);
        }        
    }

    /**
     * Agrega múltiples paquetes al camión simultáneamente.
     * <p>
     * Este método calcula si la carga total excederá la capacidad máxima del camión
     * antes de realizar la inserción. Si la capacidad se supera, no se añade ningún 
     * paquete y se informa al usuario mediante un mensaje en consola.
     * </p>
     * * @param nuevosPaquetes Un número variable de objetos {@code Paquete} (varargs) 
     * que se intentarán añadir al camión.
     */

    //Metodo para meter varios paquetes
    public void agregarVariosPaquete(Paquete... nuevosPaquetes){
        int totalFuturoCarga = listaDeEnvios.size() + nuevosPaquetes.length;
        if(totalFuturoCarga > this.capacidad){
            System.out.printf("Capacidad del camión superada, la capacidad actual es de %d e intentas meter %d\n", this.capacidad, totalFuturoCarga);
        }
        else{
            listaDeEnvios.addAll(List.of(nuevosPaquetes));
        }        
    }

    //Metodo para quitar paquetes uno a uno
    public void quitarPaquete(Paquete viejoPaquete){
        if(!listaDeEnvios.contains(viejoPaquete)){
            System.out.printf("El paquete que intentas eliminar no existe, actualmente hay este numero de paquetes %d\n", listaDeEnvios.size());
            mostrarDetallesPaquetesCamion();
        }
        else{
            listaDeEnvios.remove(viejoPaquete);
        }
        
    }
    //Metodo para borrar varios paquetes
    public void quitarVariosPaquetes(Paquete... viejosPaquetes){
        if(!listaDeEnvios.containsAll(List.of(viejosPaquetes))){
            System.out.println("No todos los paquetes seleccionados se encuentran en el camión");
           mostrarDetallesPaquetesCamion();
        }
        else{
            listaDeEnvios.removeAll(List.of(viejosPaquetes));
        }
    }
    //Metodo para vaciar por completo el camión
    public void vaciarCamion(){
        if(listaDeEnvios.size() == 0){
            System.out.println("El camión ya se encuentra vacío");
        }
        else{
            listaDeEnvios.clear();
        }
    }
    //Método para comprobar que paquetes hay en el camión
    public void mostrarDetallesPaquetesCamion(){
            if(listaDeEnvios.isEmpty()){
                System.out.println("El camión está vacío");
            }
            else{
                for(Paquete p : listaDeEnvios){
                p.mostrarDetalles();
                }
            }
            
        
    }


}