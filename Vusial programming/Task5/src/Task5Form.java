/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.JPanel;
/**
 *
 * @author user
 */
public class Task5Form extends javax.swing.JFrame {
    
    public class MyPicture extends JPanel { // КЛАСС РИСОВАНИЯ СВОЕЙ КАРТИНКИ

        Graphics2D canvas;   // Класс рисования
        BufferedImage buff;  // Буферное изображение
        int x = 400; // Константа размера полотна по х
        int y = 250; // Константа размера полотна по y

        MyPicture() {
            // Создаем буферное полотно для рисования размером x-y
            buff = new BufferedImage(x, y, BufferedImage.TYPE_INT_RGB);
            // Создаем двустороннюю связь между буферным изображением и классом рисования
            canvas = (Graphics2D) buff.getGraphics();
            System.out.println("9090");
            
            canvas.setPaint(Color.WHITE);
            canvas.fillRect(0, 0, x, y);
            
            canvas.setPaint(Color.GRAY);  // Устанавливаем цвет рисования черным
            Point topCorner = new Point(50, 50);
            Point bottomCorner = new Point(350, 200);
            int catetX = bottomCorner.x - topCorner.x;
            int catetY = bottomCorner.y - topCorner.y;
            int pencilLength = (int)Math.sqrt(Math.pow(catetX, 2) + Math.pow(catetY, 2));
            int pencilWidth = 20;
            int smallCatetX = (int)pencilWidth * catetY / pencilLength;
            int smallCatetY = (int)pencilWidth * catetX / pencilLength;
            canvas.drawLine(topCorner.x, topCorner.y, bottomCorner.x, bottomCorner.y);
            canvas.drawLine(topCorner.x + smallCatetX, topCorner.y - smallCatetY, bottomCorner.x + smallCatetX, bottomCorner.y - smallCatetY); 
            canvas.drawLine(bottomCorner.x, bottomCorner.y, bottomCorner.x + (pencilWidth / 2) * pencilLength / catetY, bottomCorner.y);
            canvas.drawLine(bottomCorner.x + smallCatetX, bottomCorner.y - smallCatetY, bottomCorner.x + (pencilWidth / 2) * pencilLength / catetY, bottomCorner.y);
            
            int pencilAngle = (int)Math.ceil(Math.asin((double)catetY / pencilLength) * 180 / Math.PI * 2);
            
            canvas.drawArc(bottomCorner.x, bottomCorner.y - pencilWidth, pencilWidth * 2, pencilWidth * 2, 180 - pencilAngle, pencilAngle);
            canvas.drawArc(topCorner.x, topCorner.y - pencilWidth, pencilWidth * 2, pencilWidth * 2, 180 - pencilAngle, pencilAngle);
            canvas.drawArc(topCorner.x + (int)(catetX * 0.03), topCorner.y - pencilWidth + (int)(catetY * 0.03), pencilWidth * 2, pencilWidth * 2, 180 - pencilAngle, pencilAngle);
                        
            canvas.setPaint(Color.BLUE);
            canvas.drawLine(topCorner.x + (int)(catetX * 0.2) + smallCatetX / 2, topCorner.y + (int)(catetY * 0.2) - smallCatetY / 2, topCorner.x + (int)(catetX * 0.4) + smallCatetX / 2, topCorner.y + (int)(catetY * 0.4) - smallCatetY / 2);
            canvas.drawLine(topCorner.x + (int)(catetX * 0.45) + smallCatetX / 2, topCorner.y + (int)(catetY * 0.45) - smallCatetY / 2, topCorner.x + (int)(catetX * 0.5) + smallCatetX / 2, topCorner.y + (int)(catetY * 0.5) - smallCatetY / 2);
            canvas.drawArc(topCorner.x + (int)(catetX * 0.05), topCorner.y - pencilWidth + (int)(catetY * 0.05), pencilWidth * 2, pencilWidth * 2, 180 - pencilAngle, pencilAngle);
            canvas.drawArc(topCorner.x + (int)(catetX * 0.07), topCorner.y - pencilWidth + (int)(catetY * 0.07), pencilWidth * 2, pencilWidth * 2, 180 - pencilAngle, pencilAngle);
            canvas.drawArc(topCorner.x + (int)(catetX * 0.09), topCorner.y - pencilWidth + (int)(catetY * 0.09), pencilWidth * 2, pencilWidth * 2, 180 - pencilAngle, pencilAngle);
            
            canvas.setPaint(Color.BLACK);
            canvas.drawLine(topCorner.x, topCorner.y + 1, bottomCorner.x, bottomCorner.y + 1);
            canvas.drawLine(bottomCorner.x, bottomCorner.y + 1, bottomCorner.x + (pencilWidth / 2) * pencilLength / catetY, bottomCorner.y + 1);
            
            /*canvas.drawLine(260, 160, 285, 160);
            canvas.setPaint(Color.GRAY);
            canvas.drawLine(50, 100 , 268, 145);
            canvas.drawLine(268, 145, 285, 160);
            canvas.drawLine(260, 159, 285, 159);
            canvas.drawArc(258, 145, 25, 25, 90, 180);
            canvas.setPaint(Color.BLUE);
            canvas.drawLine(100, 103, 140, 115);*/
            canvas.setPaint(Color.BLACK);
            canvas.setFont(new Font("Tahoma", Font.PLAIN, 14));
            canvas.drawString("Афанасьева Д.Т.", 220, 50);
            canvas.drawString("1 вариант", 220, 70);
           
            try {
                fill(topCorner.x + (int)(catetX * 0.01) + smallCatetX / 2, topCorner.y + (int)(catetY * 0.01) - smallCatetY / 2, Color.WHITE, Color.RED);
                fill(topCorner.x + (int)(catetX * 0.04) + smallCatetX / 2, topCorner.y + (int)(catetY * 0.04) - smallCatetY / 2, Color.WHITE, Color.BLUE);
                fill(topCorner.x + (int)(catetX * 0.06) + smallCatetX / 2, topCorner.y + (int)(catetY * 0.06) - smallCatetY / 2, Color.WHITE, Color.YELLOW);
                fill(topCorner.x + (int)(catetX * 0.08) + smallCatetX / 2, topCorner.y + (int)(catetY * 0.08) - smallCatetY / 2, Color.WHITE, Color.BLUE);
                fill(topCorner.x + (int)(catetX * 0.6) + smallCatetX / 2, topCorner.y + (int)(catetY * 0.6) - smallCatetY / 2, Color.WHITE, Color.YELLOW);
            } catch (Exception ex) {
                
            }
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g); // Отрисовываем панель и компоненты на ней
            g.drawImage(buff, 0, 0, this); // Отрисовываем буфер с нашим изображением на панель
        }

        private void fill(int x, int y, Color bgcolor, Color color) throws Exception {
            // Заливка фигур методом ромба, параметры: х,y- координаты начала заливки, 
            // bgcolor-цвет который надо закрашивать, color-цвет которым надо закрашивать 
            ArrayList<Point> point = new ArrayList<>(); // Создаем динамический массив точек
            point.add(new Point(x, y)); // Добавляем начальную точку в массив
            Color oldColor = canvas.getColor(); // Сохраняем старый цвет рисования
            canvas.setPaint(color); //ставим цвет закраски
            while (point.size() > 0) { // Пока в массиве имеются точки для закрашивания
                Point p = point.remove(0); // Считываем координаты первой точки, и удаляем ее из массива
                x = p.x;
                y = p.y;
                if (bgcolor.getRGB() == buff.getRGB(x, y)) { // Если ее надо нам закрасить
                    canvas.drawLine(x, y, x, y); // Закрашиваем точку
                    point.add(new Point(x + 1, y)); // Добавляем точку справа
                    point.add(new Point(x - 1, y)); // Добавляем точку слева
                    point.add(new Point(x, y + 1)); // Добавляем точку снизу
                    point.add(new Point(x, y - 1)); // Добавляем точку сверху
                }
            }
            canvas.setPaint(oldColor); //ставим старый цвет рисования
            repaint();  // Перерисовываем изображение
        }
    }

    /**
     * Creates new form Task5Form
     */
    public Task5Form() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new MyPicture();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Рисунок");
        setResizable(false);

        jPanel1.setPreferredSize(new java.awt.Dimension(400, 200));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Task5Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Task5Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Task5Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Task5Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Task5Form().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
