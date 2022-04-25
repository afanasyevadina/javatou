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
public class ProcessThread extends Thread { 

    public ProcessThread() {
        //
    }    
    
    @Override
    public void run()
    {            
        PropertiesStorage storage = PropertiesStorage.createInstance();
        System.out.println("thread 2");
        System.out.println("Считаем нули...");
        
        int zerosCount = 0;
        
        for(int[] r : storage.getMatrix())
        {
            for(int c : r)
            {
                if(c == 0) zerosCount++;
            }
        }
            
        System.out.println("Количество нулей: " + zerosCount);
        System.out.println("Заменяем нечетные числа на количество нулей...");
            
        // Заменяем все нечетные значения на количество нулей
        for(int r = 0; r < storage.getMatrix().length; r++)
        {
            for(int c = 0; c < storage.getMatrix()[r].length; c++)
            {
                if(storage.getMatrix()[r][c] % 2 == 1) storage.getMatrix()[r][c] = zerosCount;
            }
        }
        
        (new OutputThread()).start();
    }
}
