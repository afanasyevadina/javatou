package logsapplication;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.SimpleFormatter;
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

    static {
        // Установка формата вывода для java.util.logging.SimpleFormatter
        System.setProperty("java.util.logging.SimpleFormatter.format",
                "%1$tF %1$tT [%4$-7s] %3$s - %5$s %n");
    }

    // Объявление логировцика типа java.util.logging.Logger 
    static final java.util.logging.Logger log = java.util.logging.Logger.getLogger(JavaApplication1.class.getName());

    // Объявление логировцика типа org.apache.log4j.Logger
    static org.apache.log4j.Logger log4j = org.apache.log4j.Logger.getLogger(JavaApplication1.class);

    // Модификация данных в XLSX-файле
    public static void modifyXLSXFile(String xlsxFileName) throws IOException {
        log.info("Идет запись в файл");
        log4j.info("Идет запись в файл");
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
        try ( FileOutputStream fos = new FileOutputStream(xlsxFileName)) {
            wb.write(fos);
            fos.flush();
        }
        log.log(Level.INFO, "Файл записан");
        log4j.info("Файл записан");
    }

    public static void readInfo() {
        log.info("Ожидание ввода данных");
        log4j.info("Ожидание ввода данных");
        System.out.println("Куда поедете в командировку:");
        destination = scanner.nextLine();
        System.out.println("Дата начала командировки:");
        start = scanner.nextLine();
        System.out.println("Дата окончания командировки:");
        end = scanner.nextLine();
        System.out.println("Цель командировки:");
        purpose = scanner.nextLine();
        System.out.println("Получено средств на расходы:");
        received = readDouble();
        System.out.println("Стоимость проживания:");
        hotel = readDouble();
        System.out.println("Расходы на проезд:");
        transport = readDouble();
        System.out.println("Суточные расходы за все дни:");
        daily = readDouble();
        scanner.nextLine();
        System.out.println("Ваше имя, пожалуйста:");
        name = scanner.nextLine();
        log.log(Level.INFO, "Получены данные");
        log4j.info("Получены данные");
    }
    
    public static Double readDouble()
    {
        Double value;
        while (true) {
            if (scanner.hasNextDouble()) {
                value = scanner.nextDouble();
                break;
            } else {
                log.log(Level.WARNING, "Неверные входные данные");
                log4j.warn("Неверные входные данные");
                System.out.println("Надо было число: ");
                scanner.next();
            }
        }
        return value;
    }

    public static void main(String[] args) throws IOException {
        try {
            // Инициализация логировцика типа java.util.logging.Logger 
            // с файлом не более 100 КБ и не более 3 файлов-логов с дозаписью логов
            Handler fileHandler = new FileHandler("logging.log", 100 * 1024, 3, true);
            fileHandler.setFormatter(new SimpleFormatter());
            log.addHandler(fileHandler);

            // Технология логирования java.util.logging
            log.setLevel(Level.ALL);
            log.log(Level.INFO, "Начало работы программы");
            log4j.info("Начало работы программы");
            String xlsxFileName = new File(".").getAbsoluteFile().getParentFile().getAbsolutePath()
                    + System.getProperty("file.separator") + "Document.xlsx";
            readInfo();
            modifyXLSXFile(xlsxFileName);
            Desktop.getDesktop().open(new File(xlsxFileName));
            log.log(Level.INFO, "Документ готов, можно проверить!");
            System.out.println("Документ готов, можно проверить!");
            log4j.info("Документ готов, можно проверить!");
        } catch (IOException e) {
            log.log(Level.SEVERE, "Ошибка ввода-вывода");
            log4j.fatal("Ошибка ввода-вывода");
        }
    }

}
