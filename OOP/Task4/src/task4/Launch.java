/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task4;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

/**
 *
 * @author Dina-PC
 */
public class Launch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final int r = 4; final int c = 5; 
        int m[][] = new int[r][c]; int k;

        // Вывод данных о задании на экран
        System.out.println("Laboratory work v1");
        System.out.println("Task: Подсчитать количество нулей в таблице и заменить на это значение все нечетные целые элементы таблицы");

        try {
            // Определяем текущий каталог с именем файла
            String FileName = new File(".").getAbsoluteFile().getParentFile().getAbsolutePath()
                    + System.getProperty("file.separator") + "our_data.xml";
            Properties p = new Properties(); // Переменная для хранения xml-данных
            File f = new File(FileName); // Переменная для доступа к файлам

            if (f.exists() == false) { // Если файл не существует, то
                f.createNewFile(); // Создаем пустой файл для дальнейшего сохранения в него данных xml
                // Создаем случайные данные для xml
                for (int i = 0; i < r; i++) {
                    for (int j = 0; j < c; j++) {
                        k = (int) Math.round(Math.random() * 9);
                        p.put("m" + i + j, String.valueOf(k));
                    }
                }
                // Сохранение обработанных данных массива в XML-файл
                p.storeToXML(new FileOutputStream(FileName), new Date().toString());
            } else { // Если файл существует, то
                // Загружаем xml-данные из файла в переменную p для сохранения существующих значений
                p.loadFromXML(new FileInputStream(FileName)); 
            }

            System.out.println("Matrix:");

            // Считывание данных из XML-файла
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    k = Integer.valueOf(p.getProperty("m" + i + j, "0"));
                    m[i][j] = k;
                    System.out.print(k + " ");
                }
                System.out.println("");
            }

            // Реализация алгоритма варианта задания 
            int zerosCount = 0;
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (m[i][j] == 0) zerosCount++;
                }
            }
            
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (m[i][j] % 2 == 1) m[i][j] = zerosCount;
                }
            }

            // Сохраняем данные итогового массива в перемменную XML-файла
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    // Сохраняем данные в переменную, хранящую данные xml
                    p.put("m" + i + j, String.valueOf(m[i][j]));
                }
            }
            // Сохранение обработанных данных массива в XML-файл
            p.storeToXML(new FileOutputStream(FileName), new Date().toString());

            // Считывание обработанных данных из XML-файла
            System.out.println("New matrix:");
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    System.out.print(p.getProperty("m" + i + j, "?") + " ");
                }
                System.out.println("");
            }

        } catch (IOException | NumberFormatException e) {
            System.err.println("Error working with XML-file!"); // Вывести сообщение об ошибке            
        }
    }
    
}
