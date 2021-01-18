import java.util.*;

public class U3EP03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] asignaturas = new String[0];
        Double[][] horas = new Double[0][0];
        int opc = 1;
        while (opc < 6 && opc > 0) {
            System.out.print("\033[H\033[2J");
            System.out.printf("%25s", "HORAS DE ESTUDIO\n");
            System.out.printf("%25s", "================\n");
            System.out.print(
                    "\n1. Definir tabla.\n2. Modificar horas.\n3. Total horas por asignatura.\n4. Total horas por meses.\n5. Nombre y horas de asignaturas mas estudiada.\n6. Salir.\n\nEscoja una opcion (1-6): ");
            opc = sc.nextInt();
            switch (opc) {
                case 1:
                    sc.nextLine();
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.printf("%25s", "Definir Tablas");
                    System.out.print("\n\nCuantas asignaturas: ");
                    int asig = sc.nextInt();
                    asignaturas = new String[asig];
                    sc.nextLine();
                    for (int i = 0; i < asig; i++) {
                        int e = i + 1;
                        System.out.printf("%15s", "Asignatura " + e + ": ");
                        asignaturas[i] = sc.nextLine();
                    }
                    horas = new Double[asig][12];
                    System.out.printf("%15s", "Pulse ENTER para menu...");
                    try {
                        System.in.read();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    sc.nextLine();
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.printf("%25s", "Modificar horas");
                    System.out.println("\n");
                    System.out.print("Asignatura: ");
                    String nombre = sc.nextLine();
                    boolean chivato1 = false;
                    for (int i = 0; i < asignaturas.length; i++) {
                        if (nombre.equals(asignaturas[i])) {
                            while (chivato1 == false) {
                                System.out.print("Mes (1-12): ");
                                int mes = sc.nextInt();
                                if (mes <= 12 && mes >= 1) {
                                    chivato1 = true;
                                    System.out.print("Horas: ");
                                    horas[i][mes - 1] = sc.nextDouble();
                                }
                            }
                        }
                    }
                    if (chivato1 == false) {
                        System.out.printf("%15s", "No encontrada, pulse ENTER para menu...");
                        try {
                            System.in.read();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.printf("%15s", "Pulse ENTER para menu...");
                    try {
                        System.in.read();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    sc.nextLine();
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.printf("%25s", "Total horas por asignatura\n");
                    for (int i = 0; i < asignaturas.length; i++) {
                        double total = 0;
                        for (int e = 0; e < 12; e++) {
                            if (horas[i][e] != null) {
                                total += horas[i][e];
                            }
                        }
                        System.out.printf("%-10s %6.2f", asignaturas[i], total);
                        System.out.print("\n");
                    }
                    System.out.println("Pulsa ENTER para volver al menú.");
                    try {
                        System.in.read();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 4:
                    sc.nextLine();
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.printf("%25s", "Total horas por meses\n");
                    for (int i = 0; i < 12; i++) {
                        double total = 0;
                        for (int e = 0; e < asignaturas.length; e++) {
                            if (horas[e][i] != null) {
                                total += horas[e][i];
                            }
                        }
                        String o = String.valueOf(i + 1);
                        System.out.printf("%-10s %6.2f", o, total);
                        System.out.print("\n");
                    }
                    System.out.println("Pulsa ENTER para volver al menú.");
                    try {
                        System.in.read();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 5:
                    sc.nextLine();
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.printf("%25s", "Asignatura mas estudiada\n");
                    double max = 0;
                    int maxasig = 0;
                    for (int i = 0; i < asignaturas.length; i++) {
                        double total = 0;

                        for (int e = 0; e < 12; e++) {
                            if (horas[i][e] != null) {
                                total += horas[i][e];
                            }
                        }
                        if (total > max) {
                            max = total;
                            maxasig = i;
                        }
                    }
                    System.out.printf("%-10s %6.2f", asignaturas[maxasig], max);
                    System.out.print("\n");
                    System.out.println("Pulsa ENTER para volver al menú.");
                    try {
                        System.in.read();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
            }
        }
    }
}
