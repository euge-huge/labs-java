import javax.security.sasl.SaslClient;
import java.util.Scanner;
public class Lab3_2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the coordinate of area\n" +
                "Enter X1: ");
        double x1 = Double.parseDouble(scan.nextLine());
        System.out.print("Enter Y1: ");
        double y1 = Double.parseDouble(scan.nextLine());

        System.out.print("Enter X2: ");
        double x2 = Double.parseDouble(scan.nextLine());
        System.out.print("Enter Y2: ");
        double y2 = Double.parseDouble(scan.nextLine());

        System.out.print("Great! Now enter the coordinate of point\n" +
                "Enter X: ");
        double x = Double.parseDouble(scan.nextLine());
        System.out.print("Enter Y: ");
        double y = Double.parseDouble(scan.nextLine());

        System.out.print("----------------------------------\n");
        System.out.print("Here we go!\n" +
                "The aria with coordinate: " +
                "(" + x1 + ";" + y1 + ") and (" + x2 + ";" + y2 + ")\n" +
                "And point: (" + x + ";" +y +")\n\n");

        System.out.print("----------------------------------\n");
        if ((((x <= x1) && (x>=x2)) || ((x <= x2) && (x>=x1))) &&
                (((y <= y1) && (y>=y2)) || ((y <= y2) && (y>=x1)))) {
            System.out.print("Result: The point is inside! =)\n");
        } else {
            System.out.print("Result: The point is out! =(\n");
        }
        System.out.print("----------------------------------\n\n");
    }
}
