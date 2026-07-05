package domain.base;
import domain.enums.EstadoVehiculo;
import domain.enums.TipoIdentificador;
import domain.cargas.Carga;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
/**
 * Representa una clase abstracta base para la gestión de tipos de vehículos.
 * Proporciona la estructura común y los métodos obligatorios que deben 
 * implementar las subclases concretas.
 * 
 * <p>Esta clase no puede ser instanciada directamente. Las clases hijas 
 * deben implementar el método {@link}.
 *
 * @author Jose Antonio Gago
 * @version 1.0
 * @since 07/2026
 */
public abstract class UnidadTransporte{
    //------ATRIBUTOS------//
    private final String id;
    private final TipoIdentificador tipoIdentificador;
    private final String marca;
    private final String modelo;
    private EstadoVehiculo estado;
    private double capacidadTanque;
    private double nivelCombustibleLitros;
    private double consumoPorKilometro;
    private double cargaMaximaKilos;
    private double capacidadMaximaVolumen;
    private List<Carga> manifiesto = new ArrayList<>();

    /**
     * Construye un nuevo objeto de tipo vehiculo con los atrubutos compartidos por las clases hijas
     * Cuando se crea este se encuentra vacio (es decir no lleva carga)
     * @param id El identificador único del vehículo
     * @param tipoIdentificador El tipo de identificado del vehículo (VIN, MSN, HIN, MATRICULA)
     * @param marca La marca del vehículo
     * @param modelo El modelo del vehículo
     * @param estado El estado del vehículo (DISPONIBLE, EN_TRANSITO, MANTENIMIENTO)
     * @param capacidadTanque La capcidad en listros de tanque del vehículo
     * @param nivelCombustibleLitros La cantidad de litros actual en el tanque del vehículo
     * @param consumoPorKilometro EL consumo por Kilómetro del vehículo
     * @param cargaMaximaKilos La carga máxima del vehículo en Kilos
     * @param capacidadMaximaVolumen la capacidad máxima del vehículo en volumen
     * 
     */
    public UnidadTransporte(String id, TipoIdentificador tipoIdentificador, String marca, String modelo, EstadoVehiculo estado, 
    double capacidadTanque, double nivelCombustibleLitros, 
    double consumoPorKilometro, double cargaMaximaKilos, double capacidadMaximaVolumen){
        this.id = id;
        this.tipoIdentificador = tipoIdentificador;
        this.marca = marca;
        this.modelo = modelo;
        this.estado = estado;
        this.capacidadTanque = capacidadTanque;
        this.nivelCombustibleLitros = nivelCombustibleLitros;
        this.consumoPorKilometro = consumoPorKilometro;
        this.cargaMaximaKilos = cargaMaximaKilos;
        this.capacidadMaximaVolumen = capacidadMaximaVolumen;
    }

    //-------GETTERS-------//

    /**
     * Obtiene el ID del vehículo
     * @return Devuelve un String con el ID del vehículo
     */
    public String getId(){return this.id;}

    /**
     * Obtiene el tipo de ID del vehículo
     * @return Devuelve un TipoIdentificador con el tipo de ID del vehículo
     */
    public TipoIdentificador getTipoIdentificador(){return this.tipoIdentificador;}

    /**
     * Obtiene la marca del vehículo
     * @return Devuelve un String con la marca del vehículo
     */
    public String getMarca(){return this.marca;}

    /**
     * Obtiene el moodelo del vehículo
     * @return Devuelve un String con el modelo del vehículo
     */
    public String getModelo(){return this.modelo;}

    /**
     * Obtiene el estado actual vehículo
     * @return Devuelve un EstadoVehiculo con el estado actual del vehículo
     */
    public EstadoVehiculo getEstadoVehiculo(){return this.estado;}

    /**
    public double getcapacidadTanque(){return this.capacidadTanque;}
    /**
     * Obtiene nivel actual de combustible en litros
     * @return Devuelve un double con los litros actuales en el depósito
     */
    public double getNivelCombustibleLitros(){return this.nivelCombustibleLitros;}
    /**
     * Obtiene la carga máxima soportada por el vehículo
     * @return Devuelve un double con la carga máxima soportda por el vehículo
     */
    /**
     * Obtiene el consumo del vehículo por kilómetro recorrido
     * @return Devuelve un double con el consumo por kilometro del vehículo
     */
    public double getConsumoPorKilometro(){return this.consumoPorKilometro;}
    /**
    public double getcargaMaximaKilos(){return this.cargaMaximaKilos;}
    /**
     * Obtiene la capacidad máxima de volumen soportada por el vehículo
     * @return Devuelve un double con la cacidad máxima del vehículo
     */
    public double getCapacidadMaximaVolumen(){return this.capacidadMaximaVolumen;}

    /**
    * Obtiene el manifiesto de carga del vehículo.
    * @return Una vista inmutable del manifiesto.
    */
    public List<Carga> getManifiesto() {
    return Collections.unmodifiableList(this.manifiesto);
    }

    //------SETTERS------//
    /**
     * Establece el estado actual del vehículo.
     * @param estado El nuevo estado del vehículo (debe ser un valor de EstadoVehiculo).
     */
    public void setEstado(EstadoVehiculo estado) {
        this.estado = estado;
    }

    /**
     * Modifica la capacidad en litros del tanque del vehículo (si se substituye por ejemplo por una avería)
     * @param nuevaCapacidadTanque la nueva capacidad en litros del depósito del vehículo
     */
    public void setCapacidadTanque(double nuevaCapacidadTanque){
        this.capacidadTanque = nuevaCapacidadTanque;
    }
    /**
     * Modifica la cantidad actual de litros en el tanque pasando por una validación previa
     * <p>
     * Si el valor introducido es menor que cero o es mayor que la capacidad del tanque
     * muestra un error y no se altera el valor previo del atributo
     * en caso positivo, substituye el valor anterior
     * @param nuevoNivelCombustibleLitros el nuevo peso
     */
    public void setNivelCombustibleLitros(double nuevoNivelCombustibleLitros){
        if(nuevoNivelCombustibleLitros < 0 || nuevoNivelCombustibleLitros > capacidadTanque){
            System.err.printf("ERROR: la cantidad de litros no puede ser 0 o superar la cantidad permitida por el tanque del vehículo\n");
        }
        else{
            this.nivelCombustibleLitros = nuevoNivelCombustibleLitros;
        }
    }
    /**
     * Modifica el peso máximo que puede soportar el vehículo pasando por una validación previa
     * <p>
     * Si el valor introducido es menor que cero o cero
     * muestra un error y no se altera el valor previo del atributo
     * en caso positivo, substituye el valor anterior
     * @param nuevaCargaMaximaKilos el nuevo peso
     */
    public void setCargaMaximaKilos(double nuevaCargaMaximaKilos){
        if(nuevaCargaMaximaKilos <= 0){
            System.err.printf("El valor del peso máximo no puede ser 0 o inferior a 0\n");
        }
        else{
            this.cargaMaximaKilos = nuevaCargaMaximaKilos;
        }
    }
    /**
     * Modifica la capacidad máxima que puede soportar el vehículo pasando por una validación previa
     * <p>
     * Si el valor introducido es menor que cero o cero
     * muestra un error y no se altera el valor previo del atributo
     * en caso positivo, substituye el valor anterior
     * @param nuevaCapacidadMaximaVolumen el nuevo peso
     */
    public void setCapacidadMaximaVolumen(double nuevaCapacidadMaximaVolumen){
        if(nuevaCapacidadMaximaVolumen <= 0){
            System.err.printf("El valor de la capacidad máxima no puede ser 0 o inferior a 0\n");
        }
        else{
            this.capacidadMaximaVolumen = nuevaCapacidadMaximaVolumen;
        }
    }




}