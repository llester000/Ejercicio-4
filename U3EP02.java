import java.util.*;

public class U3EP02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] meses = { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre",
                "Octubre", "Noviembre", "Diciembre" };
        double[] lluvia = new double[12];
        System.out.printf("%25s", "PRECIPITACIONES ANUALES");
        System.out.print("\n");
        System.out.printf("%25s", "=======================\n");
        for (int i = 0; i < 12; i++) {
            lluvia[i] = 0;
            System.out.print(meses[i] + ": ");
            lluvia[i] = sc.nextDouble();
        }
        double max = 0;
        int mes = 0;
        double total = 0;
        for (int i = 0; i < 12; i++) {
            if (max < lluvia[i]) {
                max = lluvia[i];
                mes = i;
            }
            total += lluvia[i];
        }
        double media = total / 12;
        Arrays.sort(lluvia);
        double median;
        double desv = 0;
        for (int i = 0; i < 12; i++) {
            desv += Math.pow(lluvia[i] - media, 2) / lluvia.length;
        }
        desv = Math.sqrt(desv);
        if (lluvia.length % 2 == 0)
            median = ((double) lluvia[lluvia.length / 2] + (double) lluvia[lluvia.length / 2 - 1]) / 2;
        else
            median = (double) lluvia[lluvia.length / 2];
        System.out.println(meses[mes] + max);
        System.out.println(media);
        System.out.println(median);
        System.out.printf("Desviacion: %.3f", desv);
    }
}