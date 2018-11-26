package homework.Netcracker.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class DialogBook extends JDialog{

    private PanelCenter panelCenter;
    private PanelSouth panelSouth;

    public DialogBook(LibraryDesktop owner) {
        super(owner);
        this.setSize(400, 400);
        this.setLocation(250, 200);

        setLayout(new BorderLayout());
        panelSouth = new PanelSouth(this);
        panelCenter = new PanelCenter(owner);
        add(panelCenter, BorderLayout.CENTER);
        add(panelSouth, BorderLayout.SOUTH);

    }

    public PanelCenter getPanelCenter() {
        return panelCenter;
    }

    public PanelSouth getPanelSouth() {
        return panelSouth;
    }

    class PanelCenter extends JPanel {
        //главный фрейм
        private LibraryDesktop owner;
        // для теста
        Book bookNew2 = new Book("name", new Author("name", "1@mail.ru", "m"),
                "a", "rus", 100, 1);
        // для тригера - если данные книги заданы правильно, то
        // меняем состояние кнопки
        private JButton triggerNewBook = new JButton();
        // выбор языков
        private String[] language = {"Russian", "English", "French", "Estonian", "German", "Cre", "Swedish", "Indonesian", "Chinese"};
        // пояснение для полей книги
        private JLabel labelName = new JLabel("Name");
        private JLabel labelGenre = new JLabel("Genre");
        private JLabel labelLanguage = new JLabel("Language");
        private JLabel labelNumberOfPages = new JLabel("NumberOfPages");
        private JLabel labelCount = new JLabel("Count");
        // поля книги
        private JTextField fieldName = new JTextField();
        private JTextField fieldGenre = new JTextField();
        private JComboBox comboBoxLanguage = new JComboBox(language);
        private JTextField fieldNumberOfPages = new JTextField();
        private JTextField fieldCount = new JTextField();

        // пояснение для полей автора книги
        private JLabel labelAuthorName = new JLabel("Name");
        private JLabel labelAuthorEmail = new JLabel("Email");
        private JLabel labelAuthorGender = new JLabel("Gender");
        // поля автора книги
        private JTextField fieldAuthorName = new JTextField();
        private JTextField fieldAuthorEmail = new JTextField();
        // панель для компонента выбора гендера и сама та компаненнта
        private JRadioButton male = new JRadioButton("male");
        private JRadioButton female = new JRadioButton("female");
        private ButtonGroup groupGender = new ButtonGroup();


        public ArrayList<JTextField> fieldsArray(ArrayList<JTextField> fieldsArray) {
            // поля книги
            fieldsArray.add(fieldName);
            fieldsArray.add(fieldGenre);
            fieldsArray.add(fieldNumberOfPages);
            fieldsArray.add(fieldCount);
            // поля автора книги
            fieldsArray.add(fieldAuthorName);
            fieldsArray.add(fieldAuthorEmail);
            return fieldsArray;
        }

        public PanelCenter(LibraryDesktop owner) {
            BoxLayout boxLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
            setLayout(boxLayout);
            add(new panelBook());
            add(new panelAuthor());
            this.owner = owner;
        }

        public void setPanelCenterFields(String[] bookData) {
            this.fieldName.setText(bookData[0]);

            this.fieldAuthorName.setText(bookData[1]);
            this.fieldAuthorEmail.setText(bookData[2]);
            if ("male" == bookData[3]) {
                male.setSelected(true);
            } else {
                female.setSelected(true);
            }
            this.fieldGenre.setText(bookData[4]);
            this.comboBoxLanguage.setSelectedItem(bookData[5]);
            this.fieldNumberOfPages.setText(bookData[6]);
            this.fieldCount.setText(bookData[7]);
        }

        public JButton getTriggerNewBook() {
            return triggerNewBook;
        }

        public JTextField getFieldName() {
            return fieldName;
        }

        public JTextField getFieldAuthorName() {
            return fieldAuthorName;
        }

        public JTextField getFieldAuthorEmail() {
            return fieldAuthorEmail;
        }

        public ButtonGroup getGroupGender() {
            return groupGender;
        }

        public JTextField getFieldGenre() {
            return fieldGenre;
        }

        public JComboBox getComboBoxLanguage() {
            return comboBoxLanguage;
        }

        public JTextField getFieldNumberOfPages() {
            return fieldNumberOfPages;
        }

        public JTextField getFieldCount() {
            return fieldCount;
        }

        class panelBook extends JPanel {

            public panelBook() {
                GroupLayout gl = new GroupLayout(this);
                setLayout(gl);
                setLayoutPanel(gl);
            }

            private void setLayoutPanel(GroupLayout gl){
                gl.setAutoCreateGaps(true);
                gl.setAutoCreateContainerGaps(true);
                gl.setHorizontalGroup(gl.createSequentialGroup().
                        addGroup(gl.createParallelGroup(GroupLayout.Alignment.TRAILING).
                                addComponent(labelName).addComponent(labelGenre).addComponent(labelLanguage).
                                addComponent(labelNumberOfPages).addComponent(labelCount)).
                        addGroup(gl.createParallelGroup(GroupLayout.Alignment.LEADING).
                                addComponent(fieldName).addComponent(fieldGenre).addComponent(comboBoxLanguage).
                                addComponent(fieldNumberOfPages).addComponent(fieldCount)));

                gl.setVerticalGroup(gl.createSequentialGroup().
                        addGroup(gl.createParallelGroup(GroupLayout.Alignment.BASELINE).
                                addComponent(labelName).addComponent(fieldName)).
                        addGroup(gl.createParallelGroup(GroupLayout.Alignment.BASELINE).
                                addComponent(labelGenre).addComponent(fieldGenre)).
                        addGroup(gl.createParallelGroup(GroupLayout.Alignment.BASELINE).
                                addComponent(labelLanguage).addComponent(comboBoxLanguage)).
                        addGroup(gl.createParallelGroup(GroupLayout.Alignment.BASELINE).
                                addComponent(labelNumberOfPages).addComponent(fieldNumberOfPages)).
                        addGroup(gl.createParallelGroup(GroupLayout.Alignment.BASELINE).
                                addComponent(labelCount).addComponent(fieldCount)));
            }

        }

        class panelAuthor extends JPanel {
            private JPanel panelGender = new JPanel();

            public panelAuthor() {
                setBorder(BorderFactory.createTitledBorder("Author"));
                panelGender.setLayout(new FlowLayout());
                male.setActionCommand("male");
                female.setActionCommand("female");
                groupGender.add(male);
                groupGender.add(female);
                panelGender.add(male);
                panelGender.add(female);
                male.setSelected(true);
                setPanelLayout();
            }

            private void setPanelLayout(){

                GroupLayout gl = new GroupLayout(this);
                setLayout(gl);
                gl.setAutoCreateGaps(true);
                gl.setAutoCreateContainerGaps(true);

                gl.setHorizontalGroup(gl.createSequentialGroup().
                        addGroup(gl.createParallelGroup(GroupLayout.Alignment.TRAILING).
                                addComponent(labelAuthorName).addComponent(labelAuthorEmail).addComponent(labelAuthorGender)).
                        addGroup(gl.createParallelGroup(GroupLayout.Alignment.LEADING).
                                addComponent(fieldAuthorName).addComponent(fieldAuthorEmail).addComponent(panelGender)));

                gl.setVerticalGroup(gl.createSequentialGroup().
                        addGroup(gl.createParallelGroup(GroupLayout.Alignment.BASELINE).
                                addComponent(labelAuthorName).addComponent(fieldAuthorName)).
                        addGroup(gl.createParallelGroup(GroupLayout.Alignment.BASELINE).
                                addComponent(labelAuthorEmail).addComponent(fieldAuthorEmail)).
                        addGroup(gl.createParallelGroup(GroupLayout.Alignment.BASELINE).
                                addComponent(labelAuthorGender).addComponent(panelGender)));
            }
        }

        public boolean checkIncorrectData(String nameBook, String genre, String numberOfpages,
                                           String count, String nameAuthor, String emailAuthor) {
            boolean check = true;
            boolean a1 = nameBook.isEmpty();
            if (!nameBook.isEmpty() && ! Check.isName(nameBook)) {
                fieldName.setToolTipText("enter correct name");
                fieldName.setBackground(Color.RED);
                check = false;
            }

            if (!genre.isEmpty() && ! Check.isName(genre)) {
                fieldGenre.setToolTipText("enter correct genres");
                fieldGenre.setBackground(Color.RED);
                check = false;
            }

            if (!emailAuthor.isEmpty() && ! Check.isEmail(emailAuthor)) {
                fieldAuthorEmail.setToolTipText("enter correct Email");
                fieldAuthorEmail.setBackground(Color.RED);
                check = false;
            }

            if (!nameAuthor.isEmpty() && ! Check.isName(nameAuthor)) {
                fieldAuthorName.setToolTipText("enter correct name");
                fieldAuthorName.setBackground(Color.RED);
                check = false;
            }

            if (!numberOfpages.isEmpty() && !Check.isInteger(numberOfpages)) {
                fieldNumberOfPages.setToolTipText("enter positive integer");
                fieldNumberOfPages.setBackground(Color.RED);
                check = false;
            }
            if (!numberOfpages.isEmpty() && Integer.valueOf(numberOfpages) <= 0){
                fieldNumberOfPages.setToolTipText("enter positive integer");
                fieldNumberOfPages.setBackground(Color.RED);
                check = false;
            }

            if (!count.isEmpty() && !Check.isInteger(count)) {
                fieldCount.setToolTipText("enter positive integer");
                fieldCount.setBackground(Color.RED);
                check = false;
            }
            if (!count.isEmpty() && Integer.valueOf(count) <= 0) {
                fieldCount.setToolTipText("enter positive integer");
                fieldCount.getToolTipText();
                fieldCount.setBackground(Color.RED);
                check = false;
            }
            if (check) {
                return true;
            }
            return false;
        }
    }

    private void closeDialog(ActionEvent e) {
        dispose();
    }

}
