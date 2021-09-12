package task1;
import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {
        try {
            Scanner scan = new Scanner(System.in);

            System.out.println("Создание простейшей консольной программы на JAVA");
            System.out.print("Введите X(число):");
            double x = scan.nextDouble();
            System.out.print("Введите А(число):");
            double a = scan.nextDouble();
            System.out.print("Введите B(число):");
            double b = scan.nextDouble();
            double y;

            if (x >= 5) {
                if(a == b * -1) {
                    System.out.print("Деление на 0. ");
                    throw new Exception("Деление на 0");
                }
                y = (5 * Math.pow(x, 2)) / (6 * Math.pow(a + b, 2));
            } else {
                y = Math.pow(x, 3) * (a + b);
            }

            System.out.format("Y=%.3f", y);
            //System.out.print("Y="+y);
            System.out.println();
        } catch (Exception e) {
            System.out.println("Входные параметры заданы неверно!");
        }
    }
    
}
