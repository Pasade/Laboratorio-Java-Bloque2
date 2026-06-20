public class Principal {
    
    public static void main(String[] args) {

        //Creamos "Objeto" p1 usando el molde(Clase)
        Paquete p1 = new Paquete();

        //Prueba de funciones en un archivo a parte
        Funciones.bienVenidaGestorEnvios();

        //Le asignamos los atributos
        p1.codigoSeguimiento = "TX-75201";
        p1.peso = 8.4;
        p1.destino = "Dallas";

        //Ejecutamos la funcion paramostrar los detalles
        p1.mostrarDetalles();
    }

}