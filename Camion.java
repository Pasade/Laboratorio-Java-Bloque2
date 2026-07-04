import java.util.ArrayList;
import java.util.List;

/**
 * Representa un vehículo de transporte logístico encargado de gestionar 
 * y trasladar una colección de paquetes.
 * <p>
 * Esta clase centraliza las reglas de negocio para la carga, descarga,
 * vaciado y diagnóstico de la lista de envíos, controlando los límites
 * de capacidad máxima del vehículo.
 * </p>
 *  @author Jose Antonio Fernández Gago
 * @version 1.0
 */
public class Camion{
    private ArrayList<Paquete> listaDeEnvios = new ArrayList<>();
    private String matricula;
    private int capacidad;
    private double pesoMaximo;
    private double combustible;

    // ==========================================
    // CONSTRUCTORES
    // ==========================================

    /**
     * Construye un nuevo Camión con una matrícula y capacidad máxima definidas.
     * Le adudica una capácidad máxima de peso estándar y el combustible al 100% por defecto
     * @param matricula El identificador alfanumérico único del vehículo.
     * @param capacidad La cantidad máxima de paquetes que puede albergar la lista de envíos.
     */
    public Camion(String matricula, int capacidad){
        this.matricula = matricula;
        this.capacidad = capacidad;
        this.pesoMaximo = 2000.0;
        this. combustible = 100.0;
    }

    /**
     * Construye un nuevo Camión especificando de forma detallada todos sus parámetros.
     * <p>
     * Este constructor permite configurar camiones a medida, definiendo límites personalizados
     * de carga máxima en kilogramos y el estado inicial de su tanque de combustible.
     * </p>
     * @param matricula El identificador alfanumérico único del vehículo.
     * @param capacidad La cantidad máxima de paquetes que puede albergar la lista de envíos.
     * @param pesoMaximo El límite de carga total en kilogramos que soportan los ejes del camión.
     * @param combustible La cantidad inicial de litros de combustible en el tanque.
     */
    public Camion(String matricula, int capacidad, double pesoMaximo, double combustible){
        this.matricula = matricula;
        this.capacidad = capacidad;
        this.pesoMaximo = pesoMaximo;
        this.combustible = combustible;
    }

    // ==========================================
    // GETTERS Y SETTERS DOCUMENTADOS
    // ==========================================
    /**
     * Obtiene la matrícula actual del camión.
     * @return Un String que representa la matrícula identificativa del vehículo.
     */
    public String getMatricula(){return this.matricula;}
    /**
     * Modifica la matrícula del camión por una nueva.
     * @param nuevaMatricula El nuevo String que se asignará como matrícula del camión.
     */
    public void setMatricula(String nuevaMatricula){
        this.matricula = nuevaMatricula;
    }
    /**
     * Obtiene la capacidad máxima de paquetes permitida en el camión.
     * @return El número entero (int) que indica el límite de paquetes que puede cargar.
     */
    public int getCapacidad(){return this.capacidad;}
    /**
     * Modifica la capacidad máxima del camión realizando una validación previa.
     * <p>
     * Si el valor introducido es menor que cero, se informa del error en consola 
     * y no se altera el valor previo del atributo.
     * </p>
     * @param nuevaCapacidad La nueva cantidad máxima de paquetes (debe ser 0 o positiva).
     */
    public void setCapacidad(int nuevaCapacidad){
        if(nuevaCapacidad < 0){
            System.err.println("ERROR: La capacidad del camión no puede ser 0 on negativa");
        }
        else{
            this.capacidad = nuevaCapacidad;
        }
    }
    /**
     * Obtiene el peso máximo que soporta del camión.
     * @return Un double que representa lel peso máximo soportado por el vehículo.
     */
    public double getPesoMaximo(){return this.pesoMaximo;}
    /**
     * Modifica el peso máximo que soporta el camión realizando una validación previa
     * <p>
     * Si el valor introducido es menor que 0 se informa con un mensaje de error
     * y no se altera el valor previo del atributo
     * <p>
     * @param nuevoPesoMaximo el nuevo peso máximo soportado por el vehículo (debe ser 0 o positivo)
     */
    public void setPesoMaximo(double nuevoPesoMaximo){
        if(nuevoPesoMaximo < 0){
            System.err.printf("ERROR: el peso máximo soportado no puede ser 0 o negativo");
        }
        else{
            this.pesoMaximo = nuevoPesoMaximo;
        }        
    }
    /**
     * Obtiene la cantidad de combustible del vehículo (En Litros)
     * @return un double que representa la cantidad de combustible disponible en el vehículo (en Litros)
     */
    public double getCombustible(){return this.combustible;}
    /**
     * Modifica la cantidad de combustible disponible en el vehículo realizando una validación previa
     * <p>
     * Si el valor introducido es menor que 0 o mayor que 100
     * se informa al usuario con un mensaje de error
     * y no se altera el valor previo del atributo
     * <p>
     * @param nuevoCombustible la nueva cantidad de combustible en el vehículo
     */
    public void setCombustible(double nuevoCombustible){
        if(nuevoCombustible < 0 || nuevoCombustible > 100){
            System.err.printf("ERROR: el combustible no puede ser inferior a 0 o superior al 100%");
        }
        else{
            this.combustible = nuevoCombustible;
        }
    }



    // ==========================================
    // MÉTODOS DE CARGA (INSERCIÓN)
    // ==========================================

    /**
     * Añade un único paquete al camión si no se ha alcanzado el límite de capacidad o sobrepasado el peso soportado.
     * <p>
     * Comprueba si el tamaño actual de la lista de envíos ya es igual o superior 
     * a la capacidad máxima. Si está lleno, bloquea la inserción y muestra un mensaje en consola.
     * Comprueba si el peso de los paquetes supera la carga máxima del camión
     * </p>
     * @param nuevoPaquete El objeto {@code Paquete} que se desea cargar.
     */
    public void agregarPaquete(Paquete nuevoPaquete){
        double pesoNuevoPAquete = calcularPesoActual() + nuevoPaquete.getPeso();
        if(listaDeEnvios.size() >= this.capacidad){
            System.err.printf("ERROR: Capacidad del camión superada, la capacidad actual es de %d e intentas meter %d", this.capacidad, listaDeEnvios.size());
        }
        else{
            listaDeEnvios.add(nuevoPaquete);
        }
        if(pesoNuevoPAquete > this.pesoMaximo){
            System.err.printf("ERROR: superado el peso máximo soportado por el camión");
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
     * @param nuevosPaquetes Un número variable de objetos {@code Paquete} (varargs) 
     * que se intentarán añadir al camión.
     */
    public void agregarVariosPaquete(Paquete... nuevosPaquetes){
        int totalFuturoCarga = listaDeEnvios.size() + nuevosPaquetes.length;
        if(totalFuturoCarga > this.capacidad){
            System.err.printf("Capacidad del camión superada, la capacidad actual es de %d e intentas meter %d\n", this.capacidad, totalFuturoCarga);
        }
        else{
            listaDeEnvios.addAll(List.of(nuevosPaquetes));
        }        
    }

    // ==========================================
    // MÉTODOS DE DESCARGA (ELIMINACIÓN)
    // ==========================================

    /**
     * Elimina un paquete específico del camión de manera individual.
     * <p>
     * Primero verifica mediante {@code contains} si el paquete existe en la carga. 
     * En caso negativo, no altera la lista y muestra un aviso detallando el error y la carga actual.
     * </p>
     * @param viejoPaquete El objeto {@code Paquete} exacto que se desea descargar del camión.
     */
    public void quitarPaquete(Paquete viejoPaquete){
        if(!listaDeEnvios.contains(viejoPaquete)){
            System.err.printf("El paquete que intentas eliminar no existe, actualmente hay este numero de paquetes %d\n", listaDeEnvios.size());
            mostrarDetallesPaquetesCamion();
        }
        else{
            listaDeEnvios.remove(viejoPaquete);
        }
        
    }
    /**
     * Elimina varios paquetes del camión.
     * <p>
     * Primero verifica mediante {@code contains} si alguno de los paquetes existe en la carga. 
     * En caso negativo, no altera la lista y muestra un aviso detallando el error y la carga actual.
     * </p>
     * @param viejosPaquetes El objeto {@code Paquete} exacto que se desea descargar del camión.
     */
    public void quitarVariosPaquetes(Paquete... viejosPaquetes){
        if(!listaDeEnvios.containsAll(List.of(viejosPaquetes))){
            System.err.println("No todos los paquetes seleccionados se encuentran en el camión");
           mostrarDetallesPaquetesCamion();
        }
        else{
            listaDeEnvios.removeAll(List.of(viejosPaquetes));
        }
    }
    /**
     * Vacía por completo la carga de paquetes del camión, dejándolo limpio.
     * <p>
     * Evalúa si el camión ya se encuentra sin elementos. Si contiene carga, 
     * utiliza el método nativo {@code clear()} para resetear la lista por completo.
     * </p>
     */
    public void vaciarCamion(){
        if(listaDeEnvios.size() == 0){
            System.err.println("El camión ya se encuentra vacío");
        }
        else{
            listaDeEnvios.clear();
        }
    }
    // ==========================================
    // MÉTODOS DE VISUALIZACIÓN Y DIAGNÓSTICO
    // ==========================================

    /**
     * Recorre e imprime de manera detallada la información de cada paquete cargado.
     * <p>
     * Mediante un bucle for-each, accede secuencialmente a cada elemento del inventario 
     * y delega la impresión en el método público {@code mostrarDetalles()} de cada paquete.
     * </p>
     */
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
    /**
     * Calcula y devuelve el peso total acumulado de todos los paquetes 
     * que se encuentran actualmente cargados en el camión.
     * @return El peso total de la carga en kilogramos (double).
     */
    private double calcularPesoActual(){
        double pesoTotal = 0.0;
        for(Paquete p : listaDeEnvios){
            pesoTotal += p.getPeso();
        }
        return pesoTotal;
    }

    /**
     * Simula un viaje de una distancia determinada en kilómetros, consumiendo
     * combustible de forma dinámica según el peso actual de la carga.
     * <p>
     * Si el camión no dispone de suficiente combustible en el tanque para cubrir
     * el gasto estimado, el viaje se cancela para evitar que se quede varado.
     * </p>
     * @param kilometros La distancia total a recorrer en el viaje.
     */
    public void viajar(int kilometros) {
        // 1. Calcular el consumo dinámico
        double consumoBase = kilometros * 0.1;
        double consumoPorCarga = calcularPesoActual() * 0.005 * kilometros;
        double totalCombustibleNecesario = consumoBase + consumoPorCarga;

        System.out.printf("Iniciando ruta de %d km... Combustible actual: %.2fL\n", kilometros, this.combustible);
        System.out.printf("Consumo estimado para este viaje: %.2fL\n", totalCombustibleNecesario);

        // 2. Validación de seguridad: ¿Tenemos suficiente combustible?
        if (totalCombustibleNecesario > this.combustible) {
            System.err.printf("ERROR: Combustible insuficiente. Necesitas %.2fL y solo quedan %.2fL. ¡Reposta antes de salir!\n", 
                              totalCombustibleNecesario, this.combustible);
            return; // Bloqueamos el viaje
        }

        // 3. Si pasa la validación, el camión viaja y consume
        this.combustible -= totalCombustibleNecesario;
        System.out.printf("¡Viaje completado con éxito! Combustible restante en el tanque: %.2fL\n", this.combustible);
    }


}