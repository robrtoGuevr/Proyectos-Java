import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner consola = new Scanner(System.in);

        while (true) {
            mostrarMenu();
            try {
                var operacion = Integer.parseInt(consola.nextLine());

                if (operacion >= 1 && operacion <= 4) {
                    ejecutarInfomacion(operacion, consola);

                } else if (operacion == 5) {
                    System.out.println("HASTA PRONTO...");
                    break;

                } else {
                    System.out.println("Opcion erronea: " + operacion);
                }
                System.out.println(" ");
            }// fin try
            catch (Exception e){
                System.out.println("Ocurrio un error:" +e.getMessage());
            }
        } //fin while
    } //fin main

    private static void mostrarMenu(){
        System.out.println("Calculadora App");
        //Menu
        System.out.println("1. Suma \n2. Resta \n3.Multiplicacion \n4. Division \n5. Salir");
    }

    private static void ejecutarInfomacion(int operacion, Scanner consola){
        System.out.print("Proporciona el valor del numero 1: ");
        var numero1 = Double.parseDouble(consola.nextLine());
        System.out.print("Proporciona el valor del numero 2: ");
        var numero2 = Double.parseDouble(consola.nextLine());
        var suma = numero1 + numero2;
        System.out.println("El reusltado de la suma es: " + suma);
        double resultado;

        switch (operacion) {
            case 1 -> {
                resultado = numero1 + numero2;
                System.out.println("Resultado de la suma es: " + resultado);
            }

            case 2 -> {
                resultado = numero1 - numero2;
                System.out.println("Resultado de la resta es: " + resultado);
            }
            case 3 -> {
                resultado = numero1 * numero2;
                System.out.println("Resultado de la multiplicaicion es: " + resultado);
            }
            case 4 -> {
                resultado = numero1 / numero2;
                System.out.println("Resultado de la division es: " + resultado);
            }
            default -> System.out.println("Opcion erronea" + operacion);

        }
    }
}// fin class