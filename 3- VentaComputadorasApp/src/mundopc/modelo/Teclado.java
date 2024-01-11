package mundopc.modelo;

public class Teclado extends DispositivoEntrada{

    private final int idTeclado;
    private static int contadorTeclados;

    public Teclado(String tipoEntrada, String marca) {
        super(tipoEntrada, marca);
        idTeclado = ++contadorTeclados;
    }

    @Override
    public String toString() {
        return "Teclado{" +
                "idTeclado= " + idTeclado +
                "}" +super.toString();
    }
}
