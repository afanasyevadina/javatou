/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task8;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

/**
 *
 * @author Dina-PC
 */
public class OutputThread extends Thread {
    int[][] m;
    public Properties properies;
    public String fileName;

    public OutputThread(int[][]m) {
        this.m = m;
        PropertiesStorage storage = PropertiesStorage.createInstance();
        this.properies = storage.getProperies();
        this.fileName = storage.getFileName();
    }    
    
    @Override
    public void run()
    {
        System.out.println("thread 3");
        try {
            // Записываем результирующий массив в перемменную XML-файла
            for (int r = 0; r < m.length; r++) {
                for (int c = 0; c < m[r].length; c++) {
                    // Сохраняем значение под соответсвующим ключом
                    properies.put("m" + r + c, String.valueOf(m[r][c]));
                }
            }
            // Сохранение обработанного массива в XML-файл
            properies.storeToXML(new FileOutputStream(fileName), new Date().toString());

            // Снова считывание и распечатка:
            System.out.println("Вот что стало:");
            for (int r = 0; r < m.length; r++) {
                for (int c = 0; c < m[r].length; c++) {
                    System.out.print(properies.getProperty("m" + r + c, "?") + " ");
                }
                System.out.println("");
            }

        } catch (IOException | NumberFormatException e) {
            System.err.println("Error working with XML-file!"); // Вывести сообщение об ошибке            
        }
    }
}
