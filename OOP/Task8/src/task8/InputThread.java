/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task8;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

/**
 *
 * @author Dina-PC
 */
public class InputThread extends Thread {
    public InputThread() {
    }    
       
    @Override    
    public void run()
    {
        System.out.println("thread 1");
        PropertiesStorage storage = PropertiesStorage.createInstance();
        try {
            // Путь до файла
            Properties properties = new Properties(); // Переменная для хранения xml-данных
            String fileName = PropertiesStorage.generateFullPath("our_data.xml");
            properties.loadFromXML(new FileInputStream(fileName)); 
            // Генерация рандомных чисел от 0 до 9
            int k;
            for (int i = 0; i < storage.getMatrix().length; i++) {
                for (int j = 0; j < storage.getMatrix()[i].length; j++) {
                    k = (int) Math.round(Math.random() * 9);
                    properties.put("m" + i + j, String.valueOf(k));
                }
            }
            // Сохранение обработанных данных массива в XML-файл
            properties.storeToXML(new FileOutputStream(fileName), new Date().toString());

            System.out.println("Вот что было:");

            // Циклично читаем числа из файла:
            for (int i = 0; i < storage.getMatrix().length; i++) {
                for (int j = 0; j < storage.getMatrix()[i].length; j++) {
                    k = Integer.valueOf(properties.getProperty("m" + i + j, "0"));
                    storage.getMatrix()[i][j] = k;
                    System.out.print(k + " ");
                }
                System.out.println("");
            }
            
            
            storage.setFileName(fileName);
            storage.setProperies(properties);
            
            (new ProcessThread()).start();

        } catch (IOException | NumberFormatException e) {
            System.err.println("Error working with XML-file!"); // Вывести сообщение об ошибке            
        }
    }
}
