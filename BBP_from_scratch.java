import java.util.Scanner;

public class BBP_from_scratch {

    double osszeg = 0.0d;

    public BBP_from_scratch(double k) {

        for(int i = 0; i < k; i++) {
            double formula = (double)(1.0d/Math.pow(16.0d, i)) * ((double)(4.0d/(8.0d*i+1.0d)) - (double)(2.0d/(8.0d*i+4.0d)) - (double)(1.0d/(8.0d*i+5.0d)) - (double)(1/(8*i+6.0d)));

            osszeg += formula;
        }

        kiir(String.valueOf(osszeg));
    }

    public static void kiir(String ki) {
        System.out.println(ki);
    }

    public static void main(String[] args) {

        System.out.println("Add meg, hogy mennyire akarod közelíteni a pi értékét! (1-11)");
        System.out.println("(CTRL + C a megszakításhoz)");

        while(true) {

            Scanner sc = new Scanner(System.in);
            System.out.print("Pontosság: ");
            double number = (double) sc.nextInt();
            if(number < 1 || number > 11) {
                System.out.println("A számnak 1 és 11 közöttinek kell lennie!");
            }
            else {
                BBP_from_scratch bbp = new BBP_from_scratch(number);
            }
        }
    }
}