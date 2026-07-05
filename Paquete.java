/**
 * Clase hija que estiende de la clase padre Carga
 * <p>
 * Esta clase se encarga de definir los paquetes
 */
public class Paquete extends Carga{

    //Atributos de la clase
    private String tipoPaquete;
    private double volumenM3;

    /**
     * Construye un objeto del tipo paquete con los atributos heredados del padre y los suyos propios
     */
    public Paquete(double peso, String destino, String tipoPaquete, double volumenM3){
        super(peso, destino);
        this.tipoPaquete = tipoPaquete;
        this.volumenM3 = volumenM3;
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
    public String ToString(){
        return super.ToString() + " | Tipo: " + tipoPaquete + " | Vol: " + volumenM3 + "m³";
    }


    //Función de la clase
    public void mostrarDetalles(){
    System.out.println("📦 PAQUETE [" + codigoDeSeguimiento + "] con destino a " + destino + " (" + peso + " kg).");       
    }
    
}