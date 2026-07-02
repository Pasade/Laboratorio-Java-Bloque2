public class Principal {
    
    public static void main(String[] args) {

        //Prueba de funciones en un archivo a parte
        Funciones.bienvenidaGestorEnvios();

        //Creamos un Array dinámico para poder meter los paquetes (Como si fuera un camión)
        //ArrayList<Paquete> listaDeEnvios = new ArrayList<>();

        //Usamos el cosntructor para crear dos paquetes
        Paquete p1 = new Paquete(8.4, "Dallas");
        Paquete p2 = new Paquete(14.2);
        Paquete p3 = new Paquete(23.4, "Madrid");
        //Modificamos los paquetes a petición del cliente
        p1.setDestino("Ribeira");
        p1.setPeso(10);

        //Ejecutamos la función para mostrar detalles
        // p1.mostrarDetalles();

        //Añadiremos los paquetes al Array dinámico
        /*listaDeEnvios.addAll(List.of(p1,p2));

        //Mostramos todos los paquetes que hay en el Array
        System.out.println("\n🚚 LISTADO DE PAQUETES REGISTRADOS EN EL ARRAYLIST:");
        for(Paquete p : listaDeEnvios){
            p.mostrarDetalles();
        }

        //Creamos un condicional para que compruebe si el camión está vacio
        if(listaDeEnvios.isEmpty()){
            System.out.println("No hay paquetes para enviar.");
        }
        else{
            //Indicamos cuantos elementos hay dentro del Array
            System.out.println("\nTotal de paquetes en el sistema elástico: " + listaDeEnvios.size() + "/10");
        }

        listaDeEnvios.remove(1);
        listaDeEnvios.add(p3);

        
        //Mostramos todos los paquetes que hay en el Array
        System.out.println("\n🚚 LISTADO DE PAQUETES REGISTRADOS EN EL ARRAYLIST:");
        for(Paquete p : listaDeEnvios){
            p.mostrarDetalles();
        }

        //Creamos un condicional para que compruebe si el camión está vacio
        if(listaDeEnvios.isEmpty()){
            System.out.println("No hay paquetes para enviar.");
        }
        else{
            //Indicamos cuantos elementos hay dentro del Array
            System.out.println("\nTotal de paquetes en el sistema elástico: " + listaDeEnvios.size() + "/10");
        }        */
        

    }

}