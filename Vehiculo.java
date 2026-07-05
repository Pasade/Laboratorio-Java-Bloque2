/**
 * Representa una clase abstracta base para la gestión de tipos de vehículos.
 * Proporciona la estructura común y los métodos obligatorios que deben 
 * implementar las subclases concretas.
 * 
 * <p>Esta clase no puede ser instanciada directamente. Las clases hijas 
 * deben implementar el método {@link #calcularVolumen()}.
 *
 * @author Jose Antonio Gago
 * @version 1.0
 * @since 07/2026
 */
public abstract class Vehiculo{
    private String matricula;
    private double capacidadTanqueLitros;
    private double nivelCombustibleLitros;
    private double pesoMaximo;
    private int capacidadMaxima;

    /**
     * Construye un nuevo objeto de tipo vehiculo con los atrubutos compartidos por las clases hijas
     * matricula, combustible, pesoMaximo, capacidadMaxima
     */
    public Vehiculo(String matricula, double capacidadTanqueLitros, double nivelCombustibleLtros,
    double pesoMaximo, int capacidadMaxima){
        this.matricula = matricula;
        this.capacidadTanqueLitros = capacidadTanqueLitros;
        this.nivelCombustibleLitros = nivelCombustibleLitros;
        this.pesoMaximo = pesoMaximo;
        this.capacidadMaxima = capacidadMaxima;
    }

    //Getters y Setters

    /**
     * Obtiene la matrícula
     * @return Devuelve un String con la matrícula
     */
    public String getMatricula(){return this.matricula;}
    /**
     * Obtiene el combustible del vehículo
     * @return Devuelve un double con el combustible del vehículo
     */
    public double getCapacidadTanqueLitros(){return this.capacidadTanqueLitros;}
    /**
     * Obtiene nivel actual de combustible en litros
     * @return Devuelve un double con los litros actuales en el depósito
     */
    public double getNivelCombustibleLitros(){return this.nivelCombustibleLitros;}
    /**
     * Obtiene el peso máximo permitido por el vehículo
     * @return Devuelve un double con el peso máximo soportdo por el vehículo
     */
    public double getPesoMaximo(){return this.pesoMaximo;}
    /**
     * Obtiene la capacidad máxima en numero de elementos soportados por el vehículo
     * @return Devuelve un int con la cacidad máxima del vehículo
     */
    public int getCapacidadMaxima(){return this.capacidadMaxima;}
    /**
     * Modifica la matrícula del vehículo (En caso por ejemplo de un vehículo del extranjero que se matricula en España)
     * @param nuevaMatricula la nueva matrícula del vehículo
     */
    public void setMAtricula(String nuevaMatricula){
        this.matricula = nuevaMatricula;
    }
    /**
     * Modifica la capacidad en litros del tanque del vehículo (si se substituye por ejemplo por una avería)
     * @param nuevaCapacidadTanqueLitros la nueva capacidad en litros del depósito del vehículo
     */
    public void setCapacidadTanqueLitros(double nuevaCapacidadTanqueLitros){
        this.capacidadTanqueLitros = nuevaCapacidadTanqueLitros;
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
        if(nuevoNivelCombustibleLitros <= 0 || nuevoNivelCombustibleLitros > capacidadTanqueLitros){
            System.err.printf("ERROR: la cantidad de litros no puede ser 0 o superar la cantidad permitida por el tanque del vehículo\n");
        }
        else{
            this.capacidadTanqueLitros = nuevoNivelCombustibleLitros;
        }
    }
    /**
     * Modifica el peso máximo que puede soportar el vehículo pasando por una validación previa
     * <p>
     * Si el valor introducido es menor que cero o cero
     * muestra un error y no se altera el valor previo del atributo
     * en caso positivo, substituye el valor anterior
     * @param nuevoPesoMaximo el nuevo peso
     */
    public void setPesoMaximo(double nuevoPesoMaximo){
        if(nuevoPesoMaximo <= 0){
            System.err.printf("El valor del peso máximo no puede ser 0 o inferior a 0\n");
        }
        else{
            this.pesoMaximo = nuevoPesoMaximo;
        }
    }
    /**
     * Modifica la capacidad máxima que puede soportar el vehículo pasando por una validación previa
     * <p>
     * Si el valor introducido es menor que cero o cero
     * muestra un error y no se altera el valor previo del atributo
     * en caso positivo, substituye el valor anterior
     * @param nuevCapacidadMaxima el nuevo peso
     */
    public void setCapacidadMaxima(int nuevaCapacidadMaxima){
        if(nuevaCapacidadMaxima <= 0){
            System.err.printf("El valor de la capacidad máxima no puede ser 0 o inferior a 0\n");
        }
        else{
            this.capacidadMaxima = nuevaCapacidadMaxima;
        }
    }

}