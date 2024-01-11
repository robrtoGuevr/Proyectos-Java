package mundopc;

import mundopc.modelo.Computadora;
import mundopc.modelo.Monitor;
import mundopc.modelo.Raton;
import mundopc.modelo.Teclado;
import mundopc.servicio.Orden;

public class VentaComputadorasApp {
    public static void main(String[] args) {
        Raton ratonLenovo = new Raton("USB", "Lenovo");
        //System.out.println(ratonLenovo);
        Teclado tecladoLenovo = new Teclado("USB", "Lenovo");
        //System.out.println(tecladoLenovo);
        Monitor monitorAOC = new Monitor("AOC", 24);
        //System.out.println(monitorAOC);

        //Creacion de objeto Computadora

        Computadora computadoraLenovo = new Computadora("Computadora Lenovo", monitorAOC, tecladoLenovo, ratonLenovo);
        //System.out.println(computadoraLenovo);

        //Creacion de objeto Orden

        Orden orden1 = new Orden();
        orden1.agregarComputadora(computadoraLenovo);
        orden1.mostrarOrden();
    }
}