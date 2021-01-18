import java.util.*;

public class U3EP04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] contactos = new String[0];
        String[][] direcciones = new String[0][0];
        int opc = 1;
        while (opc < 5 && opc > 0) {
            System.out.print("\033[H\033[2J");
            System.out.printf("%25s", "AGENDA DE CONTACTOS\n");
            System.out.printf("%25s", "===================\n");
            System.out.print(
                    "\n1. Nuevo contacto.\n2. Borrar contacto.\n3. Modifica direcciones de un contacto.\n4. Busca contactos.\n5. Salir.\n\nEscoja una opcion (1-5): ");
            opc = sc.nextInt();
            switch (opc) {
                case 1:
                    sc.nextLine();
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    String[] contactos2 = contactos.clone();
                    String[][] direcciones2 = direcciones.clone();
                    int posicion = 0;
                    boolean chivato = false;
                    if (contactos.length == 0 && direcciones.length == 0) {
                        contactos = new String[1];
                        direcciones = new String[1][1];
                        posicion = 0;
                    } else {
                        for (int i = 0; i < contactos2.length; i++) {
                            contactos[i] = contactos2[i];
                            direcciones[i] = new String[direcciones2[i].length];
                            if (contactos[i] == null && chivato == false) {
                                posicion = i;
                                chivato = true;
                            }
                            for (int e = 0; e < direcciones2[i].length; e++) {
                                direcciones[i][e] = direcciones2[i][e];
                            }
                        }
                        if (chivato != true) {
                            contactos = new String[contactos.length + 1];
                            direcciones = new String[direcciones.length + 1][1];
                            for (int i = 0; i < contactos2.length; i++) {
                                contactos[i] = contactos2[i];
                                direcciones[i] = new String[direcciones2[i].length];
                                for (int e = 0; e < direcciones2[i].length; e++) {
                                    direcciones[i][e] = direcciones2[i][e];
                                }
                            }
                        }
                    }
                    if (contactos.length > 1 && chivato != true) {
                        posicion = contactos.length - 1;
                    }
                    System.out.printf("%25s", "Nuevo contacto");
                    System.out.print("\n\nNombre: ");
                    contactos[posicion] = sc.nextLine();
                    System.out.print("Posicion " + posicion);
                    System.out.print("\n");
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
                    System.out.printf("%25s", "Borrar contacto");
                    int borrar = -1;
                    int max = contactos.length - 1;
                    while (borrar < 0 && borrar < max) {
                        System.out.print("\nPosicion a borrar [0-" + max + "]:");
                        borrar = sc.nextInt();
                    }
                    System.out.print("Quieres borrar el contacto " + contactos[borrar] + "(s/n)? ");
                    sc.nextLine();
                    String confirmacion = sc.nextLine();
                    if (confirmacion.equals("s")) {
                        contactos[borrar] = null;
                        for (int i = 0; i < direcciones[borrar].length; i++) {
                            direcciones[borrar][i] = null;
                        }
                    } else {
                    }
                    System.out.print("\n");
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
                    System.out.printf("%25s", "Modificar contacto");
                    borrar = -1;
                    max = contactos.length - 1;
                    while (borrar < 0 && borrar < max) {
                        System.out.print("\nPosicion a Modificar [0-" + max + "]:");
                        borrar = sc.nextInt();
                    }
                    sc.nextLine();
                    confirmacion = "A";
                    while (!confirmacion.equals("S")) {
                        System.out.print("Direcciones de " + contactos[borrar] + "\n");
                        if (direcciones[borrar].length != 0) {
                            for (int i = 0; i < direcciones[borrar].length; i++) {
                                if (direcciones[borrar][i] != null)
                                    System.out.print(i + "     " + direcciones[borrar][i] + "\n");
                            }
                        }
                        System.out.print("(I) Insertar  (B) Borrar  (S) Salir   Operacion: ");
                        confirmacion = sc.nextLine();
                        if (confirmacion.equals("I")) {
                            posicion = direcciones[borrar].length - 1;
                            if (posicion == 0 && direcciones[borrar][0] == null) {
                                System.out.print("Insertar: ");
                                direcciones[borrar][posicion] = sc.nextLine();
                            } else {
                                chivato = false;
                                String[][] direcciones3;
                                direcciones3 = new String[1][direcciones[borrar].length];
                                direcciones3 = direcciones.clone();
                                direcciones[borrar] = new String[direcciones[borrar].length + 1];
                                posicion = direcciones[borrar].length - 1;
                                for (int e = 0; e < direcciones3[borrar].length; e++) {
                                    if (direcciones3[borrar][e] == null && chivato == false) {
                                        posicion = e;
                                        chivato = true;
                                    }

                                    direcciones[borrar][e] = direcciones3[borrar][e];
                                }

                                System.out.print("Insertar: ");
                                direcciones[borrar][posicion] = sc.nextLine();
                            }
                        }
                        if (confirmacion.equals("B")) {
                            max = direcciones[borrar].length - 1;
                            System.out.print("Borrar : [0-" + max + "]");
                            int posborrar = sc.nextInt();
                            direcciones[borrar][posborrar] = null;
                        }
                        if (confirmacion.equals("S")) {

                        }

                    }
                    System.out.print("\n");
                    System.out.printf("%15s", "Pulse ENTER para menu...");
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
                    System.out.printf("%25s", "Buscar contactos\n");
                    System.out.print("Comienza por la frase:    ");
                    String empezar = sc.nextLine();
                    System.out.print("Contiene la frase:    ");
                    String contiene = sc.nextLine();
                    int numero = 0;
                    if (contiene != "" || empezar != "") {
                        for (int i = 0; i < contactos.length; i++) {
                            if (contactos[i].startsWith(empezar) && empezar != "") {
                                numero += 1;
                                System.out.print("(" + numero + ") DIRECCIONES DE " + contactos[i] + "\n");
                                for (int e = 0; e < direcciones[i].length; e++) {
                                    if (direcciones[i][e] != null)
                                        System.out.print(e + "     " + direcciones[i][e] + "\n");
                                }
                            }
                            if (contactos[i].contains(contiene) && contiene != "") {
                                numero += 1;
                                System.out.print("(" + numero + ") DIRECCIONES DE " + contactos[i] + "\n");
                                for (int e = 0; e < direcciones[i].length; e++) {
                                    if (direcciones[i][e] != null)
                                        System.out.print(e + "     " + direcciones[i][e] + "\n");
                                }
                            }

                        }
                    } else {
                        for (int i = 0; i < contactos.length; i++) {
                            numero += 1;
                            System.out.print("(" + numero + ") DIRECCIONES DE " + contactos[i] + "\n");
                            for (int e = 0; e < direcciones[i].length; e++) {
                                if (direcciones[i][e] != null)
                                    System.out.print(e + "     " + direcciones[i][e] + "\n");
                            }

                        }

                    }
                    System.out.print("\n");
                    System.out.printf("%15s", "Pulse ENTER para menu...");
                    break;
            }
        }
    }
}
