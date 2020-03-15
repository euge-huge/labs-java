public class Lab4_1 {
    public static void main(String[] args) {
        double z,x1, b, f;
        z = 0;
        x1 = 1;
        b = 5;
        f = 5;

        System.out.print("а) Исходные данные: " +
                "\nZ = " + z +
                "\nF = " + f +
                "\nX1 = " + x1 +
                "\nB = " + b);
        for (f = 5 ; f >= -3; f -= 0.1) {
            z += ((f+1)*3)-(b*b*(x1+2)*(x1+2));

        }
        System.out.print("\n\nВыходные данные: " +
                "\nZ = " + z +
                "\nF = " + f +
                "\nX1 = " + x1 +
                "\nB = " + b);

        System.out.print("\n\n\n" +
                "" +
                "" +
                "б) Исходные данные: " +
                "\nZ = " + z +
                "\nF = " + f +
                "\nX1 = " + x1 +
                "\nB = " + b);

        for (f = 5; f >= -3; f -= 0.1) {
            for (b = 5; b >= -3; b-= 1) {
                z += ((f+1)*3)-(b*b*(x1+2)*(x1+2));

            }
        }

        System.out.print("\n\nВыходные данные: " +
                "\nZ = " + z +
                "\nF = " + f +
                "\nX1 = " + x1 +
                "\nB = " + b);


    }
}
