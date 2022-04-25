/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task8;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author Dina-PC
 */
public class PropertiesStorage {
    private Properties properies;
    private String fileName;
    private int[][] matrix;
    private static PropertiesStorage instance;

    private PropertiesStorage() {
        //
    }

    public synchronized int[][] getMatrix() {
        return matrix;
    }

    public synchronized void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public static PropertiesStorage getInstance() {
        return instance;
    }

    public static void setInstance(PropertiesStorage instance) {
        PropertiesStorage.instance = instance;
    }

    public synchronized void setProperies(Properties properies) {
        this.properies = properies;
    }

    public synchronized void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public synchronized Properties getProperies() {
        return properies;
    }

    public synchronized String getFileName() {
        return fileName;
    }
    
    static synchronized PropertiesStorage createInstance()
    {
        if(instance == null) {
            instance = new PropertiesStorage();
        }
        return instance;
    }
    
    public static synchronized String generateFullPath(String name)
    {
        try {
            // Путь до файла
            String fullName = new File(".").getAbsoluteFile().getParentFile().getAbsolutePath()
                    + System.getProperty("file.separator") + name;
            File f = new File(fullName); // Объект файла
            // Проверка существования файла
            if (f.exists() == false) { // Если файла еще нет
                f.createNewFile(); // Создаем пустой файл xml                
            }
            return fullName;

        } catch (IOException | NumberFormatException e) {
            System.err.println("Error working with XML-file!"); // Вывести сообщение об ошибке 
            return null;
        }
    }
    
}
