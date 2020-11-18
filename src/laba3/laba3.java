package laba3;

import java.io.*;

public class laba3 {
    public static void main(String[] args) throws IOException {

        // Открываем все файлы
        FileInputStream f_1 = new FileInputStream("/home/bystrov/Documents/projects/labs-java/src/laba3/f1.txt");
        InputStreamReader f1 = new InputStreamReader(f_1, "UTF-8");
        FileOutputStream f2 = new FileOutputStream("/home/bystrov/Documents/projects/labs-java/src/laba3/f2.txt");
        FileOutputStream f3 = new FileOutputStream("/home/bystrov/Documents/projects/labs-java/src/laba3/f3.txt");
        FileOutputStream f4 = new FileOutputStream("/home/bystrov/Documents/projects/labs-java/src/laba3/f4.txt");

        // Считываем файл в одну большую строку
        int i;
        StringBuilder line = new StringBuilder();
        while ((i = f1.read()) != -1) {
            line.append((char) i);
        }

        // Делим строку по переносам строки
        String[] lines = line.toString().split("\n\r");

        // Создаем переменные для хранения количества симолов, слови полной строки для f4
        int symbolsInLine = 0;
        int wordsInLine = 0;
        String[] resultLine = new String[lines.length];

        for(i = 0; i < lines.length; i++) {
            // Удаляем все переносы строк
            lines[i]= lines[i].replaceAll("[\n]", "");

            // Сохраняем значения в переменные
            symbolsInLine = lines[i].length();
            wordsInLine = lines[i].split(" ").length;

            // Создаем итоговую строку
            resultLine[i] = lines[i] + " " + symbolsInLine + " " + wordsInLine;

            // Заносим все в файлы
            f2.write(String.valueOf(symbolsInLine).concat("\n").getBytes());
            f3.write(String.valueOf(wordsInLine).concat("\n").getBytes());
            f4.write(resultLine[i].concat("\n").getBytes());
        }

        // Закрываем файлы
        f1.close();
        f2.close();
        f3.close();
        f4.close();


    }
}
