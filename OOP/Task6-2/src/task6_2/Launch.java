package task6_2;

import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;

public class Launch extends javax.swing.JFrame {

    ResourceBundle rb; // Переменная для доступа к файлу с текстовыми строками для нужного языка
    
    Person person = new Person();

    public Launch() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        enterDetailsPanel = new javax.swing.JPanel();
        createCongrats = new javax.swing.JButton();
        lastNameField = new javax.swing.JTextField();
        firstNameField = new javax.swing.JTextField();
        lastNameLabel = new javax.swing.JLabel();
        firstNameLabel = new javax.swing.JLabel();
        positionLabel = new javax.swing.JLabel();
        positionCheck1 = new javax.swing.JRadioButton();
        positionCheck2 = new javax.swing.JRadioButton();
        specializationSelect = new javax.swing.JComboBox<>();
        specializationLabel = new javax.swing.JLabel();
        agreeCheck = new javax.swing.JCheckBox();
        companyLabel = new javax.swing.JLabel();
        companyField = new javax.swing.JTextField();
        backToLanguage = new javax.swing.JButton();
        jFrame2 = new javax.swing.JFrame();
        congratsPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        congratsText = new javax.swing.JTextArea();
        okButton = new javax.swing.JButton();
        backToDetails = new javax.swing.JButton();
        chooseLanguagePanel = new javax.swing.JPanel();
        chooseLanguage = new javax.swing.JComboBox<>();
        setLanguage = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();

        jFrame1.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        jFrame1.setTitle("Test");
        jFrame1.setLocationByPlatform(true);
        jFrame1.setMaximumSize(new java.awt.Dimension(438, 382));
        jFrame1.setMinimumSize(new java.awt.Dimension(438, 382));
        jFrame1.setResizable(false);
        jFrame1.setSize(new java.awt.Dimension(420, 432));

        enterDetailsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Впишите данные"));
        enterDetailsPanel.setMaximumSize(new java.awt.Dimension(417, 370));
        enterDetailsPanel.setMinimumSize(new java.awt.Dimension(417, 370));

        createCongrats.setText("Создать поздравление");
        createCongrats.setEnabled(false);
        createCongrats.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createCongratsActionPerformed(evt);
            }
        });

        lastNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastNameFieldActionPerformed(evt);
            }
        });

        firstNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstNameFieldActionPerformed(evt);
            }
        });

        lastNameLabel.setText("Фамилия");

        firstNameLabel.setText("Имя");

        positionLabel.setText("Должность");

        positionCheck1.setSelected(true);
        positionCheck1.setText("Студент");
        positionCheck1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                positionCheck1ActionPerformed(evt);
            }
        });

        positionCheck2.setText("Преподаватель");
        positionCheck2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                positionCheck2ActionPerformed(evt);
            }
        });

        specializationSelect.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Айтишник", "Художник", "Спортсмен", "Просто хороший человек" }));
        specializationSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                specializationSelectActionPerformed(evt);
            }
        });

        specializationLabel.setText("Специализация");

        agreeCheck.setText("Я согласен на обработку персональных данных");
        agreeCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agreeCheckActionPerformed(evt);
            }
        });

        companyLabel.setText("Место работы");

        companyField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                companyFieldActionPerformed(evt);
            }
        });

        backToLanguage.setText("Назад");
        backToLanguage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backToLanguageActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout enterDetailsPanelLayout = new javax.swing.GroupLayout(enterDetailsPanel);
        enterDetailsPanel.setLayout(enterDetailsPanelLayout);
        enterDetailsPanelLayout.setHorizontalGroup(
            enterDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(enterDetailsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(enterDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(enterDetailsPanelLayout.createSequentialGroup()
                        .addComponent(backToLanguage, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(createCongrats))
                    .addGroup(enterDetailsPanelLayout.createSequentialGroup()
                        .addComponent(agreeCheck)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(enterDetailsPanelLayout.createSequentialGroup()
                        .addGroup(enterDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(enterDetailsPanelLayout.createSequentialGroup()
                                .addGroup(enterDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lastNameLabel)
                                    .addComponent(firstNameLabel)
                                    .addComponent(positionLabel)
                                    .addComponent(companyLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE))
                                .addGap(0, 0, 0))
                            .addGroup(enterDetailsPanelLayout.createSequentialGroup()
                                .addComponent(specializationLabel)
                                .addGap(46, 46, 46)))
                        .addGroup(enterDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(positionCheck2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(positionCheck1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, enterDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(companyField, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(firstNameField, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lastNameField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(specializationSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(44, 44, 44))
        );
        enterDetailsPanelLayout.setVerticalGroup(
            enterDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, enterDetailsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(enterDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lastNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lastNameLabel))
                .addGap(18, 18, 18)
                .addGroup(enterDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(firstNameLabel))
                .addGap(18, 18, 18)
                .addGroup(enterDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(positionLabel)
                    .addComponent(positionCheck1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(positionCheck2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(enterDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(companyField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(companyLabel))
                .addGap(23, 23, 23)
                .addGroup(enterDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(specializationSelect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(specializationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(agreeCheck)
                .addGap(53, 53, 53)
                .addGroup(enterDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backToLanguage)
                    .addComponent(createCongrats))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(enterDetailsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(enterDetailsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jFrame2.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        jFrame2.setTitle("Test");
        jFrame2.setLocationByPlatform(true);
        jFrame2.setResizable(false);
        jFrame2.setSize(new java.awt.Dimension(420, 250));

        congratsPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        congratsText.setEditable(false);
        congratsText.setColumns(20);
        congratsText.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        congratsText.setRows(5);
        jScrollPane1.setViewportView(congratsText);

        okButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        okButton.setText("Спасибо");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        backToDetails.setText("Назад");
        backToDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backToDetailsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout congratsPanelLayout = new javax.swing.GroupLayout(congratsPanel);
        congratsPanel.setLayout(congratsPanelLayout);
        congratsPanelLayout.setHorizontalGroup(
            congratsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(congratsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(congratsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
                    .addGroup(congratsPanelLayout.createSequentialGroup()
                        .addComponent(backToDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        congratsPanelLayout.setVerticalGroup(
            congratsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, congratsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(congratsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(okButton)
                    .addComponent(backToDetails))
                .addContainerGap())
        );

        javax.swing.GroupLayout jFrame2Layout = new javax.swing.GroupLayout(jFrame2.getContentPane());
        jFrame2.getContentPane().setLayout(jFrame2Layout);
        jFrame2Layout.setHorizontalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrame2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(congratsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jFrame2Layout.setVerticalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrame2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(congratsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Поздравление");
        setLocationByPlatform(true);
        setMaximumSize(new java.awt.Dimension(420, 230));
        setMinimumSize(new java.awt.Dimension(420, 230));
        setPreferredSize(new java.awt.Dimension(420, 230));
        setResizable(false);
        setSize(new java.awt.Dimension(420, 230));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        chooseLanguagePanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Выберите язык"));

        chooseLanguage.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Русский", "English", "Казакша" }));
        chooseLanguage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseLanguageActionPerformed(evt);
            }
        });

        setLanguage.setText("Выбрать язык");
        setLanguage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setLanguageActionPerformed(evt);
            }
        });

        exitButton.setText("Выйти");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout chooseLanguagePanelLayout = new javax.swing.GroupLayout(chooseLanguagePanel);
        chooseLanguagePanel.setLayout(chooseLanguagePanelLayout);
        chooseLanguagePanelLayout.setHorizontalGroup(
            chooseLanguagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(chooseLanguagePanelLayout.createSequentialGroup()
                .addGap(145, 145, 145)
                .addComponent(chooseLanguage, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(147, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, chooseLanguagePanelLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(setLanguage)
                .addGap(30, 30, 30))
        );
        chooseLanguagePanelLayout.setVerticalGroup(
            chooseLanguagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, chooseLanguagePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chooseLanguage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 118, Short.MAX_VALUE)
                .addGroup(chooseLanguagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(setLanguage)
                    .addComponent(exitButton))
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chooseLanguagePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chooseLanguagePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void chooseLanguageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseLanguageActionPerformed
        // Выбор языка для программы (в первом окне)
        String language = "", country = "";
        String selectedLanguage = chooseLanguage.getSelectedItem().toString();
        switch (selectedLanguage) {
            case "Русский":
                language = "";
                country = "";
                break;
            case "English":
                language = "en";
                country = "US";
                break;
            case "Казакша":
                language = "kk";
                country = "KZ";
                break;
        }

        // Определяем файл с текстовыми строками для нужного языка
        rb = ResourceBundle.getBundle("text", new Locale(language, country));

        // Устанавливаем нужные тексовые значения в компонентах первого окна
        this.setTitle(rb.getString("jFrame.title"));
        chooseLanguagePanel.setBorder(BorderFactory.createTitledBorder(rb.getString("chooseLanguagePanel.text")));
        setLanguage.setText(rb.getString("setLanguage.text"));
        exitButton.setText(rb.getString("exit.text"));
    }//GEN-LAST:event_chooseLanguageActionPerformed

    private void setLanguageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setLanguageActionPerformed
        // Кнопка "Выбрать язык" (переход на второе окно)
        this.setVisible(false); // Скрываем первое окно
        jFrame1.setVisible(true); // Открываем второе окно
        jFrame1.setLocationRelativeTo(null);

        // Устанавливаем нужные тексовые значения в компонентах второго окна
        jFrame1.setTitle(rb.getString("jFrame.title"));
        enterDetailsPanel.setBorder(BorderFactory.createTitledBorder(rb.getString("enterDetailsPanel.text")));
        lastNameLabel.setText(rb.getString("lastNameLabel.text"));
        firstNameLabel.setText(rb.getString("firstNameLabel.text"));
        positionLabel.setText(rb.getString("positionLabel.text"));
        specializationLabel.setText(rb.getString("specializationLabel.text"));
        positionCheck1.setText(rb.getString("positionCheck1.text"));
        positionCheck2.setText(rb.getString("positionCheck2.text"));
        agreeCheck.setText(rb.getString("agreeCheck.text"));
        createCongrats.setText(rb.getString("createCongrats.text"));
        ArrayList<String> model = new ArrayList<>();
        int index = 1;
        while(rb.containsKey("specialization" + index + ".text")) {
            model.add(rb.getString("specialization" + index + ".text"));
            index++;
        }
        String[] arr = new String[model.size()];
        for(int i = 0; i < model.size(); i++) {
            arr[i] = model.get(i);
        }
        specializationSelect.setModel(new javax.swing.DefaultComboBoxModel<>(arr));
        backToDetails.setText(rb.getString("back.text"));
        backToLanguage.setText(rb.getString("back.text"));
        okButton.setText(rb.getString("ok.text"));
    }//GEN-LAST:event_setLanguageActionPerformed

    private void createCongratsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createCongratsActionPerformed
        // Кнопка "Создать поздравление" (переход на третье окно)
        jFrame1.setVisible(false); // Скрываем второе окно
        jFrame2.setVisible(true); // Открываем третье окно
        jFrame2.setLocationRelativeTo(null);

        // Устанавливаем нужные тексовые значения в компонентах третьего окна
        jFrame2.setTitle(rb.getString("jFrame.title"));
        person.setFirstName(firstNameField.getText());
        person.setLastName(lastNameField.getText());
        if(positionCheck1.isSelected()) person.setPosition(positionCheck1.getText());
        if(positionCheck2.isSelected()) person.setPosition(positionCheck2.getText());
        if(specializationSelect.getSelectedItem() != null)
        {
            person.setSpecialization(specializationSelect.getSelectedItem().toString());
        }
        person.setCompany(companyField.getText());
        String congratulation = rb.getString("congratulation")
                + ", "
                + person.getPosition()+ " "
                + person.getFirstName() + " "
                + person.getLastName() + "\n"
                + rb.getString("recognize")
                +" \""
                + rb.getString("best")
                + " "
                + person.getSpecialization()
                +"\"\n"
                + rb.getString("company")
                + " "
                + person.getCompany();
        congratsText.setText(congratulation);
    }//GEN-LAST:event_createCongratsActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        // Выход из программы
        System.exit(0);
    }//GEN-LAST:event_okButtonActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // Инициализация языка при открытии первого окна
        chooseLanguageActionPerformed(null);
    }//GEN-LAST:event_formWindowOpened

    private void positionCheck2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_positionCheck2ActionPerformed
        positionCheck1.setSelected(!positionCheck2.isSelected());
    }//GEN-LAST:event_positionCheck2ActionPerformed

    private void specializationSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_specializationSelectActionPerformed
        //
    }//GEN-LAST:event_specializationSelectActionPerformed

    private void agreeCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agreeCheckActionPerformed
        createCongrats.setEnabled(agreeCheck.isSelected());
    }//GEN-LAST:event_agreeCheckActionPerformed

    private void lastNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastNameFieldActionPerformed
        //
    }//GEN-LAST:event_lastNameFieldActionPerformed

    private void firstNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstNameFieldActionPerformed
        //
    }//GEN-LAST:event_firstNameFieldActionPerformed

    private void positionCheck1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_positionCheck1ActionPerformed
        positionCheck2.setSelected(!positionCheck1.isSelected());
    }//GEN-LAST:event_positionCheck1ActionPerformed

    private void companyFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_companyFieldActionPerformed
        //
    }//GEN-LAST:event_companyFieldActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitButtonActionPerformed

    private void backToLanguageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backToLanguageActionPerformed
        jFrame1.setVisible(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }//GEN-LAST:event_backToLanguageActionPerformed

    private void backToDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backToDetailsActionPerformed
        jFrame2.setVisible(false);
        jFrame1.setVisible(true);
        jFrame1.setLocationRelativeTo(null);
    }//GEN-LAST:event_backToDetailsActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Launch().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox agreeCheck;
    private javax.swing.JButton backToDetails;
    private javax.swing.JButton backToLanguage;
    private javax.swing.JComboBox<String> chooseLanguage;
    private javax.swing.JPanel chooseLanguagePanel;
    private javax.swing.JTextField companyField;
    private javax.swing.JLabel companyLabel;
    private javax.swing.JPanel congratsPanel;
    private javax.swing.JTextArea congratsText;
    private javax.swing.JButton createCongrats;
    private javax.swing.JPanel enterDetailsPanel;
    private javax.swing.JButton exitButton;
    private javax.swing.JTextField firstNameField;
    private javax.swing.JLabel firstNameLabel;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JFrame jFrame2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField lastNameField;
    private javax.swing.JLabel lastNameLabel;
    private javax.swing.JButton okButton;
    private javax.swing.JRadioButton positionCheck1;
    private javax.swing.JRadioButton positionCheck2;
    private javax.swing.JLabel positionLabel;
    private javax.swing.JButton setLanguage;
    private javax.swing.JLabel specializationLabel;
    private javax.swing.JComboBox<String> specializationSelect;
    // End of variables declaration//GEN-END:variables
}
