package domain.util;
import java.util.Scanner;
public class Funciones{
     // 🌟 NUEVAS VARIABLES GLOBALES (Métricas del Estadio)
    // Estas variables viven fuera del main y guardan los datos durante toda la ejecución
    public static int totalPaquetes = 0;
    public static double pesoTotal = 0.0;

    // Método de bienvenida básico
    public static void bienvenidaGestorEnvios(){
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("                      BIENVENIDO AL GESTOR DE ENVIOS (V1.0)");
        System.out.println("             Por favor introduzca los datos solicitados por la consola");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    }

    //Función para calcular el 21% de IVA
    public static double calcularPrecioConIva(double precioBase) {
        return precioBase * 1.21;
    }

    // Funciones comodín para capturar datos de forma limpia y sanitizada
    public static String pedirTexto(Scanner teclado, String mensaje){
        System.out.print(mensaje);
        return teclado.nextLine().trim();
    }
    
    
    // Este método devuelve 'true' si el texto tiene solo letras y espacios, o 'false' si encuentra basura
    public static boolean esNombreValido(String texto) {
        // Si el usuario le da al ENTER sin escribir nada, no es válido
        if (texto.isEmpty()) {
         return false;
            }

         // Revisamos el texto letra por letra
        for (int i = 0; i < texto.length(); i++) {
        char letraActual = texto.charAt(i);

        // Verificamos si NO es una letra Y tampoco es un espacio en blanco
        if (!Character.isLetter(letraActual) && letraActual != ' ') {
            return false; // En cuanto encuentra un número o símbolo, aborta y dice "no es válido"
        }
    }
    return true; // Si revisa todo el texto y no encuentra nada raro, da el visto bueno
}

    public static int pedirEntero(Scanner teclado, String mensaje){
        System.out.print(mensaje);
        int entero = teclado.nextInt();
        teclado.nextLine(); // Limpieza del buffer
        return entero;
    }

    public static double pedirDecimal(Scanner teclado, String mensaje){
        System.out.print(mensaje);
        double decimal = teclado.nextDouble();
        teclado.nextLine(); // Limpieza del buffer
        return decimal;
    }

    // Función de despedida que ahora muestra el reporte final de caja
    public static void despedidaGestorEnvios(){
        System.out.println("\n=========================================================");
        System.out.println("              REPORTE DE METRICAS");
        System.out.println("=========================================================");
        System.out.println("Total paquetes eviados hoy: " + totalPaquetes);
        System.out.println("Peso total de los paquetes: " + pesoTotal + "Kg");
        System.out.println("=========================================================");
        System.out.println("Datos guardados. Gracias por usar la aplicación.");
    }
}