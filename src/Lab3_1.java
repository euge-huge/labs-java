import java.util.Scanner;
public class Lab3_1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double R, Q;
        System.out.print("Enter the value: ");
        Q = Double.parseDouble(scan.nextLine());

        if( Q < -2) {
            R = Q;
        } else if (Q <= 2) {
            R = Math.pow(Q, 2);
        } else if (Q <= 5) {
            R = Math.pow(Q, 3);
        } else {
            R = Math.pow(Q, 4);
        }

        System.out.println("Q = " + Q + "\nR = " + R);
}
}
