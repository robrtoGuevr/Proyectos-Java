package mundopc.modelo;

public class Computadora {
    private int idComputadora;
    private String nombreComputadora;
    private Monitor monitor;
    private Teclado teclado;
    private Raton raton;
    private static int contadorComputadoras;

    private Computadora() {
        idComputadora = ++contadorComputadoras;
    }

    public Computadora(String nombreComputadora, Monitor monitor, Teclado teclado, Raton raton) {
        this();
        this.nombreComputadora = nombreComputadora;
        this.monitor = monitor;
        this.teclado = teclado;
        this.raton = raton;
    }

    @Override
    public String toString() {
        return "Computadora{\n" +
                "idComputadora=" + idComputadora +
                ", nombreComputadora='" + nombreComputadora + '\'' +
                ",\n    Monitor=" + monitor +
                ",\n    Teclado=" + teclado +
                ",\n    Raton=" + raton +
                '}';
    }
}
