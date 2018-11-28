package homework.netcracker.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.regex.Pattern;


public class DialogBook extends JDialog{

    private PanelCenter panelCenter;
    private PanelSouth panelSouth;
    private LibraryDesktop owner;

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

        private JLabel checkName = new JLabel();
        private JLabel checkGenre = new JLabel();
        private JLabel checkAuthorName = new JLabel();
        private JLabel checkAuthorEmail = new JLabel();
        private JLabel checkNumberOfPages = new JLabel();
        private JLabel checkCount = new JLabel();
        private JLabel checkLanguage = new JLabel();

        public ArrayList<JLabel> warningsLabelArray() {
            ArrayList<JLabel> warningsLabelArray = new ArrayList<>();
            // поля книги
            warningsLabelArray.add(checkName);
            warningsLabelArray.add(checkGenre);
            warningsLabelArray.add(checkNumberOfPages);
            warningsLabelArray.add(checkCount);
            // поля автора книги
            warningsLabelArray.add(checkAuthorName);
            warningsLabelArray.add(checkAuthorEmail);
            return warningsLabelArray;
        }

        public ArrayList<JTextField> fieldsArray() {
            ArrayList<JTextField> fieldsArray = new ArrayList<JTextField>();
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
            add(new PanelBook());
            add(new PanelAuthor());
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

        class PanelBook extends JPanel {

            public PanelBook() {
                GroupLayout gl = new GroupLayout(this);
                setLayout(gl);
                setLayoutPanel(gl);
                checkLanguage.setVisible(false);
            }

            private void setLayoutPanel(GroupLayout gl){
                gl.setAutoCreateGaps(true);
                gl.setAutoCreateContainerGaps(true);
                gl.setHorizontalGroup(gl.createSequentialGroup().
                        addGroup(gl.createParallelGroup(GroupLayout.Alignment.TRAILING).
                                addComponent(labelName).addComponent(labelGenre).addComponent(labelLanguage).
                                addComponent(labelNumberOfPages).addComponent(labelCount)).
                        addGroup(gl.createParallelGroup(GroupLayout.Alignment.CENTER).
                                addComponent(fieldName).addComponent(fieldGenre).addComponent(comboBoxLanguage).
                                addComponent(fieldNumberOfPages).addComponent(fieldCount)).
                        addGroup(gl.createParallelGroup(GroupLayout.Alignment.LEADING).
                                addComponent(checkName).addComponent(checkGenre).addComponent(checkLanguage).
                                addComponent(checkNumberOfPages).addComponent(checkCount)));

                gl.setVerticalGroup(gl.createSequentialGroup().
                        addGroup(gl.createParallelGroup(GroupLayout.Alignment.BASELINE).
                                addComponent(labelName).addComponent(fieldName).addComponent(checkName)).
                        addGroup(gl.createParallelGroup(GroupLayout.Alignment.BASELINE).
                                addComponent(labelGenre).addComponent(fieldGenre).addComponent(checkGenre)).
                        addGroup(gl.createParallelGroup(GroupLayout.Alignment.BASELINE).
                                addComponent(labelLanguage).addComponent(comboBoxLanguage).addComponent(checkLanguage)).
                        addGroup(gl.createParallelGroup(GroupLayout.Alignment.BASELINE).
                                addComponent(labelNumberOfPages).addComponent(fieldNumberOfPages).addComponent(checkNumberOfPages)).
                        addGroup(gl.createParallelGroup(GroupLayout.Alignment.BASELINE).
                                addComponent(labelCount).addComponent(fieldCount).addComponent(checkCount)));
            }

        }

        class PanelAuthor extends JPanel {
            private JPanel panelGender = new JPanel();

            public PanelAuthor() {
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
                                addComponent(fieldAuthorName).addComponent(fieldAuthorEmail).addComponent(panelGender)).
                        addGroup(gl.createParallelGroup(GroupLayout.Alignment.TRAILING).
                            addComponent(checkAuthorName).addComponent(checkAuthorEmail)));

                gl.setVerticalGroup(gl.createSequentialGroup().
                        addGroup(gl.createParallelGroup(GroupLayout.Alignment.BASELINE).
                                addComponent(labelAuthorName).addComponent(fieldAuthorName).addComponent(checkAuthorName)).
                        addGroup(gl.createParallelGroup(GroupLayout.Alignment.BASELINE).
                                addComponent(labelAuthorEmail).addComponent(fieldAuthorEmail).addComponent(checkAuthorEmail)).
                        addGroup(gl.createParallelGroup(GroupLayout.Alignment.BASELINE).
                                addComponent(labelAuthorGender).addComponent(panelGender)));
            }
        }

        public boolean checkEmptyField() {
            ArrayList<JTextField> fieldsArray = fieldsArray();
            ArrayList<JLabel> warningsLabelArray = warningsLabelArray();
            boolean testDone = true;
            warningsLabelArray.forEach(x -> x.setText(""));

            for (JTextField x : fieldsArray) {
                if (x.getText().isEmpty()) {
                    x.setBackground(Color.RED);
                    testDone = false;
                }
            }

            for (JLabel x : warningsLabelArray) {
                if (x.getText().isEmpty()) {
                    x.setText("field is empty)))");
                    x.setVisible(true);
                }
                else{
                    System.out.println(x.getText());
                    x.setVisible(false);
                    x.setText("");
                }
            }
            return testDone;
        }

        public boolean checkIncorrectData() {
            String nameBook = fieldName.getText();
            String genre = fieldGenre.getText();
            String numberOfpages = fieldNumberOfPages.getText();
            String count = fieldCount.getText();

            String nameAuthor = fieldAuthorName.getText();
            String emailAuthor = fieldAuthorEmail.getText();

            final String NAME_REGEX = "\\`|\\~|\\!|\\@|\\#|\\$|\\%|\\^|\\&|\\*|\\(|\\)|\\" +
                    "+|\\=|\\[|\\{|\\]|\\}|\\||\\\\|\\'|\\<|\\,|\\.|\\>|\\?|\\/|\\\"\"|\\;|\\:|\\s"; // no
            final String EMAIL_REGEX = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$"; // yes
            final String NUMBERS_REGEX = "^[1-9][0-9]{0,2}$"; // yes
            final String NAME_AUTHOR_REGEX = "^([a-zA-Z]{2,}\\s[a-zA-z]{1,}'?-?[a-zA-Z]{2,}\\s?([a-zA-Z]{1,})?)"; //yes

            boolean check = true;
            if (! nameBook.isEmpty()) {
                if (Pattern.matches(NAME_REGEX, nameBook)) {
                    checkName.setText("enter correct name");
                    checkName.setVisible(true);
                    fieldName.setBackground(Color.RED);
                    check = false;
                }
                else { checkName.setVisible(false);}
            }

            if (! genre.isEmpty()) {
                if (! Pattern.matches(NAME_REGEX, genre)) {
                    checkGenre.setText("enter correct genre");
                    checkGenre.setVisible(true);
                    fieldGenre.setBackground(Color.RED);
                    check = false;
                }
                else {checkGenre.setVisible(false);}
            }

            if (! emailAuthor.isEmpty() ) {
                if (! Pattern.matches(EMAIL_REGEX, emailAuthor)){
                    checkAuthorEmail.setText("enter correct email");
                    checkAuthorEmail.setVisible(true);
                    fieldAuthorEmail.setBackground(Color.RED);
                    check = false;
                }
                else {checkAuthorEmail.setVisible(false);}
            }

            if (!nameAuthor.isEmpty()) {
                if (! Pattern.matches(NAME_AUTHOR_REGEX, nameAuthor)) {
                    checkAuthorName.setText("enter correct name");
                    checkAuthorName.setVisible(true);
                    fieldAuthorName.setBackground(Color.RED);
                    check = false;
                }
                else {checkAuthorName.setVisible(false);}
            }

            if (!numberOfpages.isEmpty()) {
                if (! Pattern.matches(NUMBERS_REGEX, numberOfpages)) {
                    checkNumberOfPages.setText("enter positive integer");
                    checkNumberOfPages.setVisible(true);
                    fieldNumberOfPages.setBackground(Color.RED);
                    check = false;
                }
                else {checkNumberOfPages.setVisible(false);}
            }

            if (!count.isEmpty()) {
                if (! Pattern.matches(NUMBERS_REGEX, numberOfpages)) {
                    checkCount.setText("enter positive integer");
                    checkCount.setVisible(true);
                    fieldCount.setBackground(Color.RED);
                    check = false;
                }
                else {checkCount.setVisible(false);}
            }

            if (check) {
                return true;
            }
            return false;
        }
    }

}
