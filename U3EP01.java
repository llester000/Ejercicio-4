import java.util.*;
Esto lo he modificado
public class U3EP01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opc = 1;
        String alfa = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        while (opc < 4 && opc > 0) {
            System.out.print("\033[H\033[2J");
            System.out.printf("%25s", "CRIPTOGRAFIA CESAR");
            System.out
                    .print("\n1. Configurar.\n2. Encriptar.\n3. Desencriptar.\n4. Salir.\n\nEscoja una opcion (1-4):");
            opc = sc.nextInt();
            if (opc == 1) {
                sc.nextLine();
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.printf("%25s", "CRIPTOGRAFIA CESAR-CONFIGURAR");
                boolean chivato1 = true;
                System.out.println("\n\nAlfabeto actual: " + alfa);
                System.out.println("\nModulo actual: " + alfa.length());
                while (chivato1 == true) {
                    chivato1 = false;
                    System.out.printf("%10s", "Nuevo alfabeto (enter para no cambiar):");
                    String newalfa = sc.nextLine();
                    if (!newalfa.equals("")) {
                        for (int j = 0; j < newalfa.length(); j++) {
                            for (int i = 1 + j; i < newalfa.length(); i++) {
                                if (newalfa.charAt(j) == newalfa.charAt(i)) {
                                    chivato1 = true;
                                    System.out.println("Tiene letras repetidas.");
                                    break;
                                }
                            }
                            if (chivato1 == true) {
                                break;
                            }
                        }
                    }
                    if (chivato1 == false && !newalfa.equals("")) {
                        alfa = newalfa;
                        System.out.println("Modulo actual: " + alfa.length());
                    }
                }
                System.out.println("Pulsa ENTER para volver al menú.");
                try {
                    System.in.read();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (opc == 2) {
                sc.nextLine();
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.printf("%25s", "CRIPTOGRAFIA CESAR-ENCRIPTAR");
                System.out.println("\n");
                boolean chivato1 = true;
                int longitud = alfa.length() - 1;
                int clave = 0;
                while (chivato1 == true) {
                    System.out.print("Clave (1-" + longitud + "): ");
                    clave = sc.nextInt();
                    if (clave >= 1 && clave <= longitud) {
                        chivato1 = false;
                    }
                }
                sc.nextLine();
                System.out.print("Texto en claro: ");
                String claro = sc.nextLine();
                String filtrado = "";
                for (int j = 0; j < claro.length(); j++) {
                    for (int i = 0; i < alfa.length(); i++) {
                        if (claro.charAt(j) == alfa.charAt(i)) {
                            filtrado = filtrado + claro.charAt(j);
                        }
                    }
                }
                System.out.print("\nTexto Filtrado: " + filtrado);
                String cifrado = "";
                for (int i = 0; i < filtrado.length(); i++) {
                    int encrip = filtrado.charAt(i);
                    if (alfa.indexOf(encrip) + clave > longitud) {
                        cifrado = cifrado + alfa.charAt(alfa.indexOf((encrip) + clave) - longitud);
                    } else {
                        cifrado = cifrado + alfa.charAt(alfa.indexOf(encrip) + clave);
                    }
                }
                System.out.println("Texto en claro: " + cifrado);
                System.out.println("Pulsa ENTER para volver al menú.");
                try {
                    System.in.read();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (opc == 3) {
                sc.nextLine();
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.printf("%25s", "CRIPTOGRAFIA CESAR-DESENCRIPTAR");
                System.out.println("\n");
                boolean chivato1 = true;
                int longitud = alfa.length() - 1;
                int clave = 0;
                while (chivato1 == true) {
                    System.out.print("Clave (1-" + longitud + "): ");
                    clave = sc.nextInt();
                    if (clave >= 1 && clave <= longitud) {
                        chivato1 = false;
                    }
                }
                sc.nextLine();
                System.out.print("Texto en claro: ");
                String claro = sc.nextLine();
                String filtrado = "";
                for (int j = 0; j < claro.length(); j++) {
                    for (int i = 0; i < alfa.length(); i++) {
                        if (claro.charAt(j) == alfa.charAt(i)) {
                            filtrado = filtrado + claro.charAt(j);
                        }
                    }
                }
                System.out.print("\nTexto Filtrado: " + filtrado);
                String cifrado = "";
                for (int i = 0; i < filtrado.length(); i++) {
                    int encrip = filtrado.charAt(i);
                    if ((alfa.indexOf(encrip) - clave) < 0) {
                        cifrado = cifrado + alfa.charAt(alfa.indexOf((encrip) - clave) + longitud);
                    } else {
                        cifrado = cifrado + alfa.charAt(alfa.indexOf(encrip) - clave);
                    }
                }
                System.out.println("Texto en claro: " + cifrado);
                System.out.println("Pulsa ENTER para volver al menú.");
                try {
                    System.in.read();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
