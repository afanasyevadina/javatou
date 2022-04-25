/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task8;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

/**
 *
 * @author Dina-PC
 */
public class OutputThread extends Thread {

    public OutputThread() {
        //
    }    
    
    @Override
    public void run()
    {
        System.out.println("thread 3");
        PropertiesStorage storage = PropertiesStorage.createInstance();
        try {
            // Записываем результирующий массив в перемменную XML-файла
            for (int r = 0; r < storage.getMatrix().length; r++) {
                for (int c = 0; c < storage.getMatrix()[r].length; c++) {
                    // Сохраняем значение под соответсвующим ключом
                    storage.getProperies().put("m" + r + c, String.valueOf(storage.getMatrix()[r][c]));
                }
            }
            // Сохранение обработанного массива в XML-файл
            storage.getProperies().storeToXML(new FileOutputStream(storage.getFileName()), new Date().toString());

            // Снова считывание и распечатка:
            System.out.println("Вот что стало:");
            for (int r = 0; r < storage.getMatrix().length; r++) {
                for (int c = 0; c < storage.getMatrix()[r].length; c++) {
                    System.out.print(storage.getProperies().getProperty("m" + r + c, "?") + " ");
                }
                System.out.println("");
            }

        } catch (IOException | NumberFormatException e) {
            System.err.println("Error working with XML-file!"); // Вывести сообщение об ошибке            
        }
    }
}
