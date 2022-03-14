/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task6;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 *
 * @author Dina-PC
 */
public class Launch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        String country = "", language = "";
        System.out.println("1 – Английский");
        System.out.println("2 – Казахский");
        System.out.println("3 – Французский");
        System.out.println("Любой другой символ – Русский");
        char i = (char) System.in.read();
        switch (i) {
            case '1':
                language = "en";
                country = "US";
                break;
            case '2':
                language = "kk";
                country = "KZ";
                break;
            case '3':
                language = "fr";
                country = "FR";
                break;      
        }
        ResourceBundle rb = ResourceBundle.getBundle("text", new Locale(language, country));
        LinkedHashMap<String, String> answers = new LinkedHashMap<>();
        int questionNumber = 1;
        while(rb.containsKey("my.question" + String.valueOf(questionNumber))) {
            String questionText = getStr(rb.getString("my.question" + questionNumber), rb.getString("utf16"));
            System.out.println(questionText);
            ArrayList<String> variants = new ArrayList<>();
            int variantNumber = 1;
            while(rb.containsKey("my.reply" + questionNumber + String.valueOf(variantNumber))) {
                variants.add(getStr(rb.getString("my.reply" + questionNumber + String.valueOf(variantNumber)), rb.getString("utf16")));
                variantNumber++;
            }
            for(variantNumber = 0; variantNumber < variants.size(); variantNumber++) {
                System.out.println(String.valueOf(variantNumber + 1) + " - " + variants.get(variantNumber));
            }
            int selected;
            while (true) {
                if (scan.hasNextInt()) {
                    selected = scan.nextInt();
                    boolean success = false;
                    if(selected > 0  && selected <= variants.size()) {
                        success = true;
                        break;
                    } else {
                        System.out.println(getStr(rb.getString("error.variant"), rb.getString("utf16")));
                    }
                    if(success) break;
                } else {
                    System.out.println(getStr(rb.getString("error.type"), rb.getString("utf16")));
                    scan.next();
                }
            }
            try {
                answers.put(questionText, variants.get(selected - 1));
            } catch(IndexOutOfBoundsException e) {
                System.out.println(getStr(rb.getString("error.exception"), rb.getString("utf16")));
            }
            questionNumber++;
        }
        System.out.println("---");
        System.out.println(getStr(rb.getString("result"), rb.getString("utf16")) + ":");
        answers.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        });
    }
    
    public static String getStr(String text, String utf16) throws UnsupportedEncodingException {
        if (!utf16.equals("true")) {
            return new String(text.getBytes("ISO-8859-1"), "Windows-1251");
        } else {
            return text;
        }
    }
    
}
