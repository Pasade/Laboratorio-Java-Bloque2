import java.util.ArrayList;
import java.util.List;
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
public abstract class Vehiculo{
    private String idVehiculo;
    private String marca;
    private String modelo;
    private String estado;
    private double capacidadTanque;
    private double nivelCombustibleLitros;
    private double consumoPorKilometro;
    private double cargaMaximaKilos;
    private double capacidadMaximaVolumen;
    private List<Carga> cargas = new ArrayList<>();

    /**
     * Construye un nuevo objeto de tipo vehiculo con los atrubutos compartidos por las clases hijas
     * idVehiculo, combustible, cargaMaximaKilos, capacidadMaximaVolumen
     */
    public Vehiculo(String idVehiculo, String marca, String modelo, String estado, double capacidadTanque, double nivelCombustibleLitros,
    double consumoPorKilometro, double cargaMaximaKilos, double capacidadMaximaVolumen){
        this.idVehiculo = idVehiculo;
        this.marca = marca;
        this.modelo = modelo;
        this.estado = estado;
        this.capacidadTanque = capacidadTanque;
        this.nivelCombustibleLitros = nivelCombustibleLitros;
        this.consumoPorKilometro = consumoPorKilometro;
        this.cargaMaximaKilos = cargaMaximaKilos;
        this.capacidadMaximaVolumen = capacidadMaximaVolumen;
    }

    //Getters y Setters

    /**
     * Obtiene la matrícula
     * @return Devuelve un String con la matrícula
     */
    public String getidVehiculo(){return this.idVehiculo;}
    /**
     * Obtiene el combustible del vehículo
     * @return Devuelve un double con la capacidad del tanque de combustible del vehículo
     */
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
    public double getcargaMaximaKilos(){return this.cargaMaximaKilos;}
    /**
     * Obtiene la capacidad máxima de volumen soportada por el vehículo
     * @return Devuelve un double con la cacidad máxima del vehículo
     */
    public double getcapacidadMaximaVolumen(){return this.capacidadMaximaVolumen;}
    /**
     * Modifica el Id  del vehículo 
     * @param nuevaidVehiculo la nueva matrícula del vehículo
     */
    public void setidVehiculo(String nuevaidVehiculo){
        this.idVehiculo = nuevaidVehiculo;
    }
    /**
     * Modifica la capacidad en litros del tanque del vehículo (si se substituye por ejemplo por una avería)
     * @param nuevacapacidadTanque la nueva capacidad en litros del depósito del vehículo
     */
    public void setcapacidadTanque(double nuevacapacidadTanque){
        this.capacidadTanque = nuevacapacidadTanque;
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
        if(nuevoNivelCombustibleLitros <= 0 || nuevoNivelCombustibleLitros > capacidadTanque){
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
     * @param nuevacargaMaximaKilos el nuevo peso
     */
    public void setcargaMaximaKilos(double nuevacargaMaximaKilos){
        if(nuevacargaMaximaKilos <= 0){
            System.err.printf("El valor del peso máximo no puede ser 0 o inferior a 0\n");
        }
        else{
            this.cargaMaximaKilos = nuevacargaMaximaKilos;
        }
    }
    /**
     * Modifica la capacidad máxima que puede soportar el vehículo pasando por una validación previa
     * <p>
     * Si el valor introducido es menor que cero o cero
     * muestra un error y no se altera el valor previo del atributo
     * en caso positivo, substituye el valor anterior
     * @param nuevcapacidadMaximaVolumen el nuevo peso
     */
    public void setcapacidadMaximaVolumen(int nuevacapacidadMaximaVolumen){
        if(nuevacapacidadMaximaVolumen <= 0){
            System.err.printf("El valor de la capacidad máxima no puede ser 0 o inferior a 0\n");
        }
        else{
            this.capacidadMaximaVolumen = nuevacapacidadMaximaVolumen;
        }
    }




}