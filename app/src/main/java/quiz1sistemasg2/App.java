package quiz1sistemasg2;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el tipo de vehículo estacionado (C: Carro, M: Moto, B: Bicicleta): ");
        char tipoV = sc.next().toUpperCase().charAt(0);

        System.out.print("Ingrese el número de horas de permanencia: ");
        int numHoras = Integer.parseInt(sc.nextLine());

        System.out.print("¿Es estudiante? (true: Sí, false: No): ");
        Boolean esEstudiante = Boolean.parseBoolean(sc.nextLine());

        double valorBase = calcularValorHora(tipoV, numHoras);

    }

    public static double calcularValorHora(char tipoV, int numHoras) {
        try {
            double tarifaPorHora;
            switch (tipoV) {
                case 'C':
                    tarifaPorHora = 5000;
                    break;
                case 'M':
                    tarifaPorHora = 3000;
                    break;
                case 'B':
                    tarifaPorHora = 1000;
                    break;
                default:
                    throw new Exception("Tipo de vehículo invalido.");
            }
            double valorTotal;
            if (numHoras <= 3) {
                valorTotal = tarifaPorHora * numHoras;
            } else {
                valorTotal = (tarifaPorHora * 3) + ((numHoras - 3) * (tarifaPorHora + 2000));
            }
            return valorTotal;
        } catch (Exception e) {
            return -1;
        }
    }

    public static double calcularDescuentos(double valorTotal, int numHoras, boolean esEstudiante) {
        try {
            if (numHoras > 4) {
                valorTotal *= 0.3;
            }
            if (esEstudiante == true) {
                valorTotal *= 0.95;
            }

            return valorTotal;
        } catch (Exception e) {
            return -1;
        }
    }

}
