public class Principal {
    
    public static void main(String[] args) {

        //Prueba de funciones en un archivo a parte
        Funciones.bienvenidaGestorEnvios();

        //Usamos los constructores para crear objetos
        Paquete p1 = new Paquete(8.4, "Dallas");
        Paquete p2 = new Paquete(14.2);
        Paquete p3 = new Paquete(23.4, "Madrid");
        Paquete p4 = new Paquete(3.4, "Vigo");
        Camion c1 = new Camion("2345MXZ", 3);
        Camion c2 = new Camion("3476WCV", 10, 1000.0, 80.0);
        //Modificamos los paquetes a petición del cliente
        p1.setDestino("Ribeira");
        p1.setPeso(10);

        //Agregamos paquetes al camion
        c1.agregarVariosPaquete(p1, p2, p3, p4);
        c1.agregarVariosPaquete(p1, p2, p3);
        c1.mostrarDetallesPaquetesCamion();
        c1.quitarPaquete(p4);
        c1.quitarVariosPaquetes(p2, p3);
        c1.mostrarDetallesPaquetesCamion();
        c1.vaciarCamion();
        c1.mostrarDetallesPaquetesCamion();
        c2.setCombustible(100);
        c2.agregarVariosPaquete(p1, p2, p3);

        // 1. Comprobar el estado inicial del camión antes de salir
        System.out.println("\n--- ESTADO INICIAL DEL CAMIÓN ---");
        System.out.printf("Combustible inicial: %.2f Litros\n", c2.getCombustible());
        System.out.printf("Matrícula del vehículo: %s\n", c2.getMatricula());
        System.out.printf("Listado de paquetes: \n");
        c2.mostrarDetallesPaquetesCamion();

        // 2. Realizar un viaje corto con los paquetes cargados
        System.out.println("\n--- INICIANDO PRIMER VIAJE ---");
        c2.viajar(150); // Simulamos una ruta de 150 km

        // 3. Intentar un viaje larguísimo para forzar la validación de combustible
        System.out.println("\n--- INICIANDO SEGUNDO VIAJE (PRUEBA DE LÍMITE) ---");
        c2.viajar(900); // Esto debería calcular un consumo enorme y ser rechazado

        


        

    }

}