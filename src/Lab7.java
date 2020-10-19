import java.util.Scanner;
import java.lang.StringBuffer;

public class Lab7 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter your string: ");
        String str = new String(scan.nextLine());
        System.out.println("String: " + str + "\n");

        //Поиск повторяющихся ПАР символов.
        for(int i = 0; i < str.length()-1; i++) {
            if (str.charAt(i) == str.charAt(i+1)) {
                System.out.println("Double \""+ (char)str.charAt(i)+"\" at: "+ i + " " + (i+1));
            }
        }

        str = str.trim(); // Убираем все пробелы в начале и в конце
        str = str.toLowerCase(); // Переводим все слова в нижний регистр

        // Подсчитываем количество слов в предложении
        int count = 0;
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == ' ') {
                count++;
            }
        }
        count++;

        //Создаем массив слов предложения
        StringBuffer[] words = new StringBuffer[count];

        int j = 0;

        //Заполнение массива словами
        //ВНИМАНИЕ! Предложение должно заканчиваться любым НЕ буквенным символом!
        for(int i = 0; i < words.length; i++) {
            words[i] = new StringBuffer("");
            while(Character.isLetter(str.charAt(j))) {
                words[i].append(str.charAt(j));
                j++;
            }
            if(str.charAt(j) == ' ') j++;
        }

        int c = 0;
        int max = 0;
        int index = 0;

        //Ищем наиболее часто встречающееся слово в массиве
        for (int i = 0; i < words.length; i++)
        {
            c = 0;
            for (j = i; j < words.length; j++){
                if ((words[i].toString()).equals((words[j].toString()))) {
                    c++;
                }
            }
            if (max <= c)
            {
                max = c;
                index = i;
            }
        }

        System.out.print("\nThe most repeated word:  " + words[index] + " " + max + " times.");

    }
}
