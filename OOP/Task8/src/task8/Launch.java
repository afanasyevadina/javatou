/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task8;

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

        // Вариант 1 ЛР 8
        System.out.println("Laboratory work v1");
        System.out.println("Task: Подсчитать количество нулей в таблице и заменить на это значение все нечетные целые элементы таблицы");
        
        PropertiesStorage storage = PropertiesStorage.createInstance();        
        storage.setMatrix(new int[r][c]);
        
        (new InputThread()).start();
    }
    
}
