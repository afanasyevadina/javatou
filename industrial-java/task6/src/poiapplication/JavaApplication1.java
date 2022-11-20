package poiapplication;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class JavaApplication1 {

    static Double hotel;
    static Double transport;
    static Double daily;
    static Double received;
    static String destination;
    static String start;
    static String end;
    static String purpose;
    static String name;
    
    static Scanner scanner = new Scanner(System.in);

    // Модификация данных в XLSX-файле
    public static void modifyXLSXFile(String xlsxFileName) throws IOException {
        XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(xlsxFileName));
        XSSFSheet sheet = wb.getSheetAt(0);
        sheet.getRow(1).getCell(1).setCellValue(name);
        sheet.getRow(2).getCell(1).setCellValue(destination);
        sheet.getRow(3).getCell(1).setCellValue(purpose);
        sheet.getRow(4).getCell(1).setCellValue(start + " - " + end);
        sheet.getRow(5).getCell(1).setCellValue(received);
        sheet.getRow(9).getCell(1).setCellValue(transport);
        sheet.getRow(10).getCell(1).setCellValue(hotel);
        sheet.getRow(11).getCell(1).setCellValue(daily);
        Double spent = hotel + transport + daily;
        sheet.getRow(12).getCell(1).setCellValue(spent);
        sheet.getRow(13).getCell(1).setCellValue(Math.max(0, received - spent));
        sheet.getRow(14).getCell(1).setCellValue(Math.max(0, spent - received));
        try (FileOutputStream fos = new FileOutputStream(xlsxFileName)) {
            wb.write(fos);
            fos.flush();
        }
    }

    public static void readInfo() {
        System.out.println("Куда поедете в командировку:");
        destination = scanner.nextLine();
        System.out.println("Дата начала командировки:");
        start = scanner.nextLine();
        System.out.println("Дата окончания командировки:");
        end = scanner.nextLine();
        System.out.println("Цель командировки:");
        purpose = scanner.nextLine();
        received = readDouble("Получено средств на расходы:");
        hotel = readDouble("Стоимость проживания:");
        transport = readDouble("Расходы на проезд:");
        daily = readDouble("Суточные расходы за все дни:");
        scanner.nextLine();
        System.out.println("Ваше имя, пожалуйста:");
        name = scanner.nextLine();
    }
    
    public static Double readDouble(String s)
    {
        if(s != null) {
            System.out.println(s);
        }
        Double value;
        while (true) {
            if (scanner.hasNextDouble()) {
                value = scanner.nextDouble();
                break;
            } else {
                System.out.println("Надо было число: ");
                scanner.next();
            }
        }
        return value;
    }

    public static void main(String[] args) {
        try {
            String xlsxFileName = new File(".").getAbsoluteFile().getParentFile().getAbsolutePath()
                    + System.getProperty("file.separator") + "Document.xlsx";
            readInfo();
            modifyXLSXFile(xlsxFileName);
            Desktop.getDesktop().open(new File(xlsxFileName));
            System.out.println("Документ готов, можно проверить!");
        } catch (IOException e) {
        }
    }

}
