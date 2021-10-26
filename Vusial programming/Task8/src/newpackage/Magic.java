/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;
import java.util.Arrays; 
import static java.lang.Math.*; 

/**
 *
 * @author Dina-PC
 */
public class Magic {
    int[] src;
    double a, b;
    double[] dst;
    int arrLength;
    
    public Magic() {
        this.a = 1;
        this.b = 1;
        this.arrLength = 10;
        this.src = new int[10];
        this.dst = new double[this.arrLength];
    }
    
    public Magic(int inputArr[], double a, double b) {
        this.a = a;
        this.b = b;
        this.arrLength = inputArr.length;
        this.src = Arrays.copyOf(inputArr, this.arrLength);
        this.dst = new double[this.arrLength];
    }
    
    public void setSrc(int inputArr[], double a, double b) {
        this.a = a;
        this.b = b;
        this.arrLength = inputArr.length;
        this.src = Arrays.copyOf(inputArr, this.arrLength);
        this.dst = new double[this.arrLength];
    }
    
    public double[] getResult() {
        for(int i = 0; i < 10; i++) {
            int sum = 0;
            for(int j = 0; j < i; j++) {
                sum += src[j];
            }
            dst[i] = Math.sqrt(Math.pow(Math.cos(src[i]), 2) / (Math.pow(a, 2) + Math.pow(b, 2)) - Math.sin(src[i])) * sum;
        }

        return this.dst;
    }
}
