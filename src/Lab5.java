import java.util.Scanner;

public class Lab5 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the size of array: ");
        int size = Integer.parseInt(scan.nextLine());

        double[] arr = new double[size];

        /*Заполнение массива*/
        for (int i = 0; i < size; i++) {
            System.out.print("Enter " + (i+1) + "th element: ");
            arr[i] = Double.parseDouble(scan.nextLine());
        }

        System.out.print("\n\n");
        /*1) Найти количество элементов равных единице, стоящих на чётных местах.
        * ИЗМЕНИТЬ false, чтобы выполнить этот участок кода*/

        if(false) {
            System.out.print("Our array now:\n");
            for(int i = 0; i < size; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.print("\n");


            int n = 0;
            for (int i = 0; i < size; i++) {
                if (arr[i] == 1 && i%2 == 0) n++;
            }
            System.out.println("The number of (1) in the array in unodd places: " + n + "\n");
        }


        /*2) Составить новый массив так, чтобы чередовались положительные и отрицательные числа.
        * При условии, если СТРОГО половина отрицательных и половина положительных!
        * ИЗМЕНИТЬ false, чтобы выполнить этот участок кода*/
        if(false) {
            System.out.print("Our array before:\n");
            for(int i = 0; i < size; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.print("\n");

            int m = 0;
            double t = 0;
            for (int i = 0; i < size-1; i++) {
                if (arr[i]*arr[(i+1)] > 0) {
                    m = i;
                    while(arr[i]*arr[m] > 0) {
                        m++;
                    }
                    t = arr[m];
                    arr[m] = arr[i+1];
                    arr[i+1] = t;
                }
            }

            System.out.print("Our array after:\n");
            for(int i = 0; i < size; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.print("\n");
        }

        /*3) Найти максимальный элемент и его местоположение в массиве!
         * ИЗМЕНИТЬ false, чтобы выполнить этот участок кода*/

        if(false) {
            System.out.print("Our array now:\n");
            for(int i = 0; i < size; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.print("\n");

            double max = 0;
            int place = 0;
            for (int i = 0 ; i < size; i++) {
                max = arr[i];
                if(arr[i] >= max) {
                    max = arr[i];
                    place = i;
                }
            }

            System.out.println("Maximum of the array is: " + max + " in " + place);
        }

    }
}
