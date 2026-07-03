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


        

    }

}