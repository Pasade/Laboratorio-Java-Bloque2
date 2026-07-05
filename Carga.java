/**
 * Representa una clase abstracta base para la gestión de tipos de carga.
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

public abstract class Carga{
    private double peso;
    private String destino;
    private final String codigoDeSeguimiento;

    /**
     * Construye un nuevo objeto de tipo carga con los atrubutos compartidos por las clases hijas
     * peso, destino y codigo de seguimiento (Generado automáticamente con UUID de tipo final no puede ser modificada por el usuario)
     */
    public Carga(double peso, String destino){
        this.codigoDeSeguimiento = java.util.UUID.randomUUID().toString().substring(0, 8);
        setPeso(peso);
        setDestino(destino);
    }

    /**
     * Contrato obligatorio para las clases hijas
     * Cada clase calculará el Volumen en metros cuadrados 
     */
    public abstract double calcularVolumen();

    /**
     * Contrato obligatorio para las clases hijas
     * Cada clase mostrará los detalles de su carga 
     */
    public void mostrarDetalles(){
        System.out.println(this.toString());
    };

    //Getters y Setters
    /**
     * Obtiene el codigo de seguimiento
     * @return Devuelve un String con el código de seguimiento
     */
    public String getCodigoDeSeguimiento(){return this.codigoDeSeguimiento;}
    /**
     * Obtiene el destino
     * @return Devuelve un string con el destino
     */
    public String getDestino(){return this.destino;}
    /**
     * Modifica el destino
     * @param nuevoDestino El nuevo destino (String)
     */
    public void setDestino(String nuevoDestino){this.destino = nuevoDestino;}
    /**
    * Obtiene el peso
    * @return Devuelve un double con el peso 
    */
    public double getPeso(){return this.peso;}
      /**
     * Modifica el peso realizando una validación previa
     * <p>
     * Si el valor introducido es menor que cero se genera un error
     * y no se altera el valor previo del atributo
     * @param nuevoPeso el nuevo peso
     */
    public void setPeso(double nuevoPeso){
        if(nuevoPeso > 0)
        {
            this.peso = nuevoPeso;
        }
        else
        {
            System.err.println("❌ ERROR: El peso de un paquete no puede ser menor o igual a 0.");
        }
    }

    /**
     * Sobreescritura del metodo ToString de la clase Object para una impresión limpia
     * @return String
     */
    @Override
    public String toString(){
        return String.format("[%s] Destino: %s | Peso: %.2f kg",this.codigoDeSeguimiento, this.destino, this.peso);
    }


}