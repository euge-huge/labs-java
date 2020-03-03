import java.io.BufferedInputStream;
import java.util.Scanner;

public class Lab2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Hello!\nThis program calculate area of triangle\n\nEnter the A: ");
        double a = Double.parseDouble(scan.nextLine());
        System.out.print("Okay! Now enter the H of your shape: ");
        double h = Double.parseDouble(scan.nextLine());
        System.out.print("\nHere we go!\n" +
                "A = " + a+
                "\nH = " + h + "\n");
        System.out.print("\nWell done! Here's yours result -- S= 0,5АН = " + 0.5*a*h +
                ".\n---Good Luck!---\n\n");

    }
}
