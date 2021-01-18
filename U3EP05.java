import java.util.*;

public class U3EP05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Texto 1: ");
        String original1 = sc.nextLine();
        System.out.print("Texto 2: ");
        String original2 = sc.nextLine();
        String[] frase1 = original1.split(" ");
        String[] frase2 = original2.split(" ");
        double a = 0;
        double b = 0;
        double c = 0;
        for (int i = 0; i < frase1.length; i++) {
            boolean chivato = false;
            for (int e = 0; e < frase2.length; e++) {
                if (frase1[i].equals(frase2[e]) && chivato == false) {
                    a += 1;
                    chivato = true;
                }
            }
            if (chivato == false) {
                b += 1;
            }
        }
        for (int i = 0; i < frase2.length; i++) {
            boolean chivato = false;
            for (int e = 0; e < frase1.length; e++) {
                if (frase2[i].equals(frase1[e]) && chivato == false) {
                    chivato = true;
                }
            }
            if (chivato == false) {
                c += 1;
            }
        }

        System.out.println("a = " + a + " b = " + b + " c = " + c);
        double formula = a / (a + b + c);
        System.out.print("Parecido [0,1]: " + formula);

    }
}