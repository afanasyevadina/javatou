/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task5;

import java.util.prefs.Preferences;

/**
 *
 * @author Dina-PC
 */
public class LabTaskPreferences {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final int r = 4; final int c = 5; 
        int m[][] = new int[r][c]; int k;
        
        // Вариант 1 ЛР 5
        System.out.println("Laboratory work v1");
        System.out.println("Task: Подсчитать количество нулей в таблице и заменить на это значение все нечетные целые элементы таблицы");
        
        Preferences prefs = Preferences.userNodeForPackage(LabTaskPreferences.class);
        
        // Генерация рандомных чисел от 0 до 9
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                k = (int) Math.round(Math.random() * 9);
                prefs.putInt("m" + i + j, k);
            }
        }
        
        System.out.println("Вот что было:");

        // Циклично читаем числа из префов:
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                k = prefs.getInt("m" + i + j, 0);
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

        // Записываем результирующий массив в префы
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                // Сохраняем значение под соответсвующим ключом
                prefs.putInt("m" + i + j, m[i][j]);
            }
        }
        
        // Снова считывание и распечатка:
        System.out.println("Вот что стало:");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(prefs.getInt("m" + i + j, -999) + " ");
            }
            System.out.println("");
        }
    }
    
}
