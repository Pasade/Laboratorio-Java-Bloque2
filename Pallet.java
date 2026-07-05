/**
 * Clase hija que estiende de la clase padre Carga
 * <p>
 * Esta clase se encarga de definir los pallets
 */
public class Pallet extends Carga{
    private boolean esEuropeo;
    private double altoMercancia;

    /**
     * Construye un objeto del tipo pallet con los atributos heredados del padre y los suyos propios
     */
    public Pallet(double peso, String destino, boolean esEuropeo, double altoMercancia){
        super(peso, destino);
        this.esEuropeo = esEuropeo;
        this.altoMercancia = altoMercancia;
    }

    //Getters y Setters
    /**
     * Obtiene el tipo de pallet
     * @return Devuelve un boolean con true si el pallet es europeo o falso si es americano
     */
    public boolean getEsEuropeo(){return this.esEuropeo;}
    /**
     * Obtiene la altura del pallet
     * @return Devuelve un doublecon la altura del pallet
     */
    public double getAlturaMercancia(){return this.altoMercancia;}
    /**
     * Modifica el valor del tipo de pallet a true o false
     * True = es Europeo false = es Americano
     */
    public void setEsEuropeo(boolean nuevoEsEuropeo){
        this.esEuropeo = nuevoEsEuropeo;
    }
    /**
     * Modifica la altura del pallet reailzando una validacion previa
     * <p>
     * Si el peso del pallet es inferior a cero, se uestra un mensaje de error
     * y no se altera el valor previo del atributo
     */
    public void setAltoMercancia(double nuevoAltoMercancia){
        if(nuevoAltoMercancia < 0){
            System.err.println("❌ ERROR: la altura del pllet no puede ser menor o igual a 0.");
        }
        else{
            this.altoMercancia = nuevoAltoMercancia;        }
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
        double base = esEuropeo ? (1.2 * 0.8) : (1.2 * 1.10);
        return base + altoMercancia;
    }

    /**
     * Sobreescritura de ToString para agregar la información unaca del paquete
     * @return Strin
     */
    @Override
    public String toString(){
        return String.format("%s | Es una pallet Europeo: %s | Altura de la mercancia: %.2f m", super.toString(), esEuropeo, altoMercancia);
    }


}