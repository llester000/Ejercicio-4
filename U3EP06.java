import java.util.*;

public class U3EP06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Generando y buscando numeros de forma secuencial ...");
        int[] enteros = new int[1000000];
        for (int i = 0; i <= 999999; i++) {
            enteros[i] = (int) (Math.random() * 500000 + 1);
        }
        long startTime = System.currentTimeMillis();
        int[] enteros2 = new int[1000];
        for (int i = 0; i <= 999; i++) {
            enteros2[i] = (int) (Math.random() * 100000 + 1);
        }
        double aciertoentero = 0;
        double noaciertoentero = 0;
        for (int e = 0; e <= 999; e++) {
            boolean chivato = false;
            for (int i = 0; i < 999999; i++) {
                if (chivato == false && enteros2[e] == enteros[i]) {
                    aciertoentero += 1;
                    chivato = true;
                }
            }
            if (chivato == false) {
                noaciertoentero += 1;
            }
        }
        double porencontrado = (aciertoentero / 1000) * 100;
        double pornoencontrado = (noaciertoentero / 1000) * 100;
        System.out.printf("\nEncontrados: %2.2f", porencontrado);
        System.out.print("%");
        System.out.printf("\nNo encontrados: %2.2f", pornoencontrado);
        System.out.print("%");
        long estimatedTime = (System.currentTimeMillis() - startTime);
        System.out.println("\nTiempo: " + estimatedTime + " milsegundos");
        System.out.print("\nGenerando, ordenando y buscando numeros de forma binaria ...");
        int[] enteros12 = new int[1000000];
        for (int i = 0; i <= 999999; i++) {
            enteros12[i] = (int) (Math.random() * 500000 + 1);
        }
        int[] enteros22 = new int[1000];
        for (int i = 0; i <= 999; i++) {
            enteros22[i] = (int) (Math.random() * 100000 + 1);
        }
        aciertoentero = 0;
        noaciertoentero = 0;
        for (int e = 0; e <= 999; e++) {
            boolean chivato = false;
            for (int i = 0; i < 999999; i++) {
                if (chivato == false && enteros22[e] == enteros12[i]) {
                    aciertoentero += 1;
                    chivato = true;
                }
            }
            if (chivato == false) {
                noaciertoentero += 1;
            }
        }
        startTime = System.currentTimeMillis();
        aciertoentero = 0;
        noaciertoentero = 0;
        Arrays.sort(enteros12);
        estimatedTime = (System.currentTimeMillis() - startTime);
        System.out.print("\nTiempo en ordenar: " + estimatedTime + " milsegundos");
        long startTime2 = System.currentTimeMillis();
        for (int e = 0; e <= 999; e++) {
            int posicion = Arrays.binarySearch(enteros12, enteros22[e]);
            if (posicion >= 0) {
                aciertoentero += 1;
            } else {
                noaciertoentero += 1;
            }
        }
        porencontrado = (aciertoentero / 1000) * 100;
        pornoencontrado = (noaciertoentero / 1000) * 100;
        System.out.printf("\nEncontrados: %2.2f", porencontrado);
        System.out.print("%");
        System.out.printf("\nNo encontrados: %2.2f", pornoencontrado);
        System.out.print("%");
        estimatedTime = (System.currentTimeMillis() - startTime2);
        System.out.println("\nTiempo: " + estimatedTime + " milsegundos");

    }
}