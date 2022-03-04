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

        // Вариант 1 ЛР 4
        System.out.println("Laboratory work v1");
        System.out.println("Task: Подсчитать количество нулей в таблице и заменить на это значение все нечетные целые элементы таблицы");

        try {
            // Путь до файла
            String FileName = new File(".").getAbsoluteFile().getParentFile().getAbsolutePath()
                    + System.getProperty("file.separator") + "our_data.xml";
            Properties p = new Properties(); // Переменная для хранения xml-данных
            File f = new File(FileName); // Объект файла
            // Проверка существования файла
            if (f.exists() == false) { // Если файла еще нет
                f.createNewFile(); // Создаем пустой файл xml
                // Генерация рандомных чисел от 0 до 9
                for (int i = 0; i < r; i++) {
                    for (int j = 0; j < c; j++) {
                        k = (int) Math.round(Math.random() * 9);
                        p.put("m" + i + j, String.valueOf(k));
                    }
                }
                // Сохранение обработанных данных массива в XML-файл
                p.storeToXML(new FileOutputStream(FileName), new Date().toString());
            } else { // Если же есть, то
                // Загружаем xml-данные из файла в Properties
                p.loadFromXML(new FileInputStream(FileName)); 
            }

            System.out.println("Вот что было:");

            // Циклично читаем числа из файла:
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    k = Integer.valueOf(p.getProperty("m" + i + j, "0"));
                    m[i][j] = k;
                    System.out.print(k + " ");
                }
                System.out.println("");
            }
            
            System.out.println("Считаем нули...");

            // Считаем количество нулей 
            int zerosCount = 0;
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (m[i][j] == 0) zerosCount++;
                }
            }
            
            System.out.println("Количество нулей: " + zerosCount);
            System.out.println("Заменяем нечетные числа на количество нулей...");
            
            // Заменяем все нечетные значения на количество нулей            
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (m[i][j] % 2 == 1) m[i][j] = zerosCount;
                }
            }

            // Записываем результирующий массив в перемменную XML-файла
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    // Сохраняем значение под соответсвующим ключом
                    p.put("m" + i + j, String.valueOf(m[i][j]));
                }
            }
            // Сохранение обработанного массива в XML-файл
            p.storeToXML(new FileOutputStream(FileName), new Date().toString());

            // Снова считывание и распечатка:
            System.out.println("Вот что стало:");
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
