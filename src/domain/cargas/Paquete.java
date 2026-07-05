package domain.cargas;
import domain.enums.TipoPaquete;
/**
 * Clase hija que estiende de la clase padre Carga
 * <p>
 * Esta clase se encarga de definir los paquetes
 */
public class Paquete extends Carga{

    //Atributos de la clase
    private TipoPaquete tipoPaquete;
    private double volumenM3;

    /**
     * {@inheritDoc}
     * Construye un objeto del tipo paquete con los atributos heredados del padre y los suyos propios
     * @param tipoPaquete El tipo de paquete (ESTANDAR, FRAGIL, PESADO, PELIGROSO)
     * @param volumenM3 El volumen en metros cubicos
     */
    public Paquete(double peso, String destino, TipoPaquete tipoPaquete, double volumenM3){
        super(peso, destino);
        this.tipoPaquete = tipoPaquete;
        this.volumenM3 = volumenM3;
    }

    //------GETTERS------//
    /**
     * Obtiene el tipo de paquete
     * @return Devuelve un String con el tipo de paquete
     */
    public TipoPaquete getTipoPaquete(){return this.tipoPaquete;}

    /**
     * Obtiene el volumen del paquete
     * @return Devuelve un double con el volumen del paquete
     */
    public double getVolumenM3(){return this.volumenM3;}

    //------SETTERS------//
    /**
     * Modifica el tipo de paquete
     * @param nuevoTipoPaquete El nuevo tipo de paquete (ESTANDAR, FRAGIL, PESADO, PELIGROSO)
     */
    public void setTipoPaquete(TipoPaquete nuevoTipoPaquete){
        this.tipoPaquete = nuevoTipoPaquete;
    }

    /**
     * Modifica el volumen del paquete reailzando una validacion previa
     * <p>
     * Si el volumen del paquete es inferior a cero, se uestra un mensaje de error
     * y no se altera el valor previo del atributo
     * <p>
     * @param nuevoVolumenM3 El nuevo volumen en metros cúbicos del paquete
     */
    public void setVolumenM3(double nuevoVolumenM3){
        if(nuevoVolumenM3 > 0){
             this.volumenM3 = nuevoVolumenM3;
        }
        else{
            System.err.println("❌ ERROR: lel volumen del paquete no puede ser menor o igual a 0.");           
        }
    }

    /**
     * Funcion que obligada por contrato con la clase padre
     * <p>
     * Calcula el volumen en metros 3
     * <p>
     * @return Double con el volumen del paquete
     */
    @Override
    public double calcularVolumen(){
        return this.volumenM3;
    }

    /**
     * Sobreescritura de ToString para agregar la información unaca del paquete
     * @return Strin
     */
    @Override
    public String toString(){
        return String.format("%s | Tipo: %s | Vol: %.3f m³", super.toString(), tipoPaquete, volumenM3);
    }

}