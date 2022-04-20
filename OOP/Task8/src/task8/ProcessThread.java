/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task8;

import java.util.Properties;

/**
 *
 * @author Dina-PC
 */
public class ProcessThread extends Thread {
    int[][] m;   

    public ProcessThread(int[][]m) {
        this.m = m;
    }    
    
    @Override
    public void run()
    {            
        System.out.println("thread 2");
        System.out.println("Считаем нули...");
        
        int zerosCount = 0;
        
        for(int[] r : m)
        {
            for(int c : r)
            {
                if(c == 0) zerosCount++;
            }
        }
            
        System.out.println("Количество нулей: " + zerosCount);
        System.out.println("Заменяем нечетные числа на количество нулей...");
            
        // Заменяем все нечетные значения на количество нулей
        for(int r = 0; r < m.length; r++)
        {
            for(int c = 0; c < m[r].length; c++)
            {
                if(m[r][c] % 2 == 1) m[r][c] = zerosCount;
            }
        }
        
        (new OutputThread(m)).start();
    }
}
