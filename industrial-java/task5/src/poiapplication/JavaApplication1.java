package poiapplication;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import java.util.Scanner;

public class JavaApplication1 {
    
    static Double hotel;
    static Double transport;
    static Double daily;
    static String destination;
    static String start;
    static String end;
    static String purpose;
    static String name;
    
    static Scanner scanner = new Scanner(System.in);

    public static void readInfo() {
        System.out.println("Куда поедете в командировку:");
        destination = scanner.nextLine();
        System.out.println("Дата начала командировки:");
        start = scanner.nextLine();
        System.out.println("Дата окончания командировки:");
        end = scanner.nextLine();
        System.out.println("Цель командировки:");
        purpose = scanner.nextLine();
        System.out.println("Стоимость проживания:");
        hotel = readDouble();
        System.out.println("Расходы на проезд:");
        transport = readDouble();
        System.out.println("Суточные расходы за все дни:");
        daily = readDouble();
        scanner.nextLine();
        System.out.println("Ваше имя, пожалуйста:");
        name = scanner.nextLine();
    }
    
    public static Double readDouble()
    {
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

    public static void main(String[] args) throws Exception {
        readInfo();
        Double total = transport + hotel + daily;
        HashMap<String, String> map = new HashMap();
        map.put("fffdestination", destination);
        map.put("fffstart", start);
        map.put("fffend", end);
        map.put("fffpurpose", purpose);
        map.put("fffhotel", hotel.toString());
        map.put("ffftransport", transport.toString());
        map.put("fffdaily", daily.toString());
        map.put("ffftotal", total.toString());
        map.put("fffname", name);
        map.put("fffdate", (new SimpleDateFormat("dd.MM.yyyy")).format(new Date()));
        String dir = new File(".").getAbsoluteFile().getParentFile().getAbsolutePath()
                + System.getProperty("file.separator");
        XWPFDocument doc = new XWPFDocument(OPCPackage.open(dir + "input.docx"));
        for (XWPFParagraph p : doc.getParagraphs()) {
            List<XWPFRun> runs = p.getRuns();
            if (runs != null) {
                for (XWPFRun r : runs) {
                    String text = r.getText(0);
                    if (text != null) {
                        for(String key : map.keySet()) {
                            text = text.replace(key, map.get(key));
                        }
                    }
                    r.setText(text, 0);
                }
            }
        }
        for (XWPFTable tbl : doc.getTables()) {
            for (XWPFTableRow row : tbl.getRows()) {
                for (XWPFTableCell cell : row.getTableCells()) {
                    for (XWPFParagraph p : cell.getParagraphs()) {
                        for (XWPFRun r : p.getRuns()) {
                            String text = r.getText(0);
                            if (text != null) {
                                for(String key : map.keySet()) {
                                    text = text.replace(key, map.get(key));
                                }
                            }
                            r.setText(text, 0);
                        }
                    }
                }
            }
        }
        FileOutputStream fos = new FileOutputStream(dir + "output.docx");
        doc.write(fos);
        fos.close();
        fos.flush();
        Desktop.getDesktop().open(new File(dir + "output.docx"));
        System.out.println("Документ готов, можно проверить!");
    }
}
