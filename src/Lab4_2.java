public class Lab4_2 {

    public static void main(String[] args) {
        double f, l ,z1, m, z2;
        z2 = 10;
        f = 0;
        l = 100;
        z1 = 25;
        m = 5;

        System.out.print("Исходные данные: " +
                "\nF = " + f +
                "\nZ2 = " + z2 +
                "\nL = " + l +
                "\nM = " + m +
                "\nZ1 = " + z1);

        while (z2>= 5) {
            f += (l-z1-m-z2)/(l*m);
            z2--;
        }

        System.out.print("\n\n\n" +
                "Выходные данные: " +
                "\nF = " + f +
                "\nZ2 = " + z2 +
                "\nL = " + l +
                "\nM = " + m +
                "\nZ1 = " + z1);

    }
}
