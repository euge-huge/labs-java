import java.util.Scanner;
public class Lab2_2 {
    public static void main(String[] args) {
        double x1,x2,z, y;
        x1 = x2 = z = y = 0;
        double b,c,l,m;
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter B = ");
        b = Double.parseDouble(scan.nextLine());

        System.out.print("Enter C = ");
        c = Double.parseDouble(scan.nextLine());

        System.out.print("Enter L = ");
        l = Double.parseDouble(scan.nextLine());

        System.out.print("Enter M = ");
        m = Double.parseDouble(scan.nextLine());

        System.out.print("Now:\nB = " + b + " C = " + c + " L = " + l + " M = " + m + " X1 = "
                + x1 + " X2 = " + x2 + " Y = " + y + " Z = " + z + "\n\n");

        x1 = b + Math.sqrt(Math.pow(b,2)-4*b*c);
        x2 =  m* b /2*c;
        y = ( b*x1 -Math.pow(c,2)*x2 ) / 2 ;
        z = ( m*Math.pow(x2,2) + l*x1 ) / b;

        System.out.print("Now:\nB = " + b + " C = " + c + " L = " + l + " M = " + m + " X1 = "
                + x1 + " X2 = " + x2 + " Y = " + y + " Z = " + z);
    }
}
