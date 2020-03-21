import java.util.Scanner;

public class Lab6 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        //Пользователь задает размерность массива
        int M, N;
        System.out.print("Введите размерность массива:\nстрок: ");
        M = Integer.parseInt(scan.nextLine());
        System.out.print("столбцов: ");
        N = Integer.parseInt(scan.nextLine());

        //Создаем массив размерностью N на M
        int arr[][] = new int[M][N];

        //Пользователь заполняет массив
        System.out.print("\nЗаполните массив: \n");
        for (int i = 0; i < M; i++) {
            for(int j =0; j < N; j++) {
                System.out.print("[" + (i) + "]["+ (j)+"]: ");
                arr[i][j] = Integer.parseInt(scan.nextLine());
            }
        }

        System.out.print("\nОтлично! сейчас массив выглядит так: \n");

        // Вывод массива
        for (int i = 0; i < M; i++) {
            for(int j =0; j < N; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.print("\n");
        }

        // Пользователь выбират вид сортировки
        int k = -1;
        System.out.print("\nВведите\n1 - отсортировать по возрастанию построчно(слева)\n" +
                "2 - отсортировать по возрастанию по столбцам: ");
        k = Integer.parseInt(scan.nextLine());

        int temp =0;
        if (k == 1) {
            // Сортировка по строкам методом пузырьков
            for(int l = 0; l < M; l++){
                for (int i = 0; i < N-1; i++) {
                    for(int j = 0; j < N-i-1; j++) {
                        if (arr[l][j] > arr[l][j + 1]) {
                            temp = arr[l][j];
                            arr[l][j] = arr[l][j + 1];
                            arr[l][j + 1] = temp;
                        }
                    }
                }
            }
        } else if (k == 2){
            // Сортировка по столбцам методом пузырьков
            for(int l = 0; l < N; l++){
                for (int i = 0; i < M-1; i++) {
                    for(int j = 0; j < M-i-1; j++) {
                        if (arr[j][l] > arr[j + 1][l]) {
                            temp = arr[j][l];
                            arr[j][l] = arr[j + 1][l];
                            arr[j + 1][l] = temp;
                        }
                    }
                }
            }
        } else {
            // Если пользователь введ некоректное значение
            System.out.print("\nЧто то пошло не так (некоректное значение)!!!\n");
        }

        System.out.print("\nТеперь массив выглядит так:\n");
        // Вывод массива
        for (int i = 0; i < M; i++) {
            for(int j =0; j < N; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.print("\n");
        }


    }
}
