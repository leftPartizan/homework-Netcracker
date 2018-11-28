package homework.netcracker.swing;

import javax.swing.*;
import java.awt.*;

public class InputNameBookDialog extends JDialog{

    private PanelSouth panelSouth;
    private PanelCenter panelCenter;

    public InputNameBookDialog() {
        setSize(200,150);
        setLocation(500, 300);
        setLayout(new BorderLayout());

        panelCenter = new PanelCenter();
        add(panelCenter, BorderLayout.CENTER);

        this.panelSouth = new PanelSouth(this);
        add(panelSouth, BorderLayout.SOUTH);

    }

    public PanelSouth getPanelSouth() {
        return panelSouth;
    }

    public PanelCenter getPanelCenter() {
        return panelCenter;
    }

    class PanelCenter extends JPanel {
        private JTextField textField = new JTextField();
        private JLabel warnings = new JLabel();

        public PanelCenter() {
//            BoxLayout boxLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
            GridLayout gl =new GridLayout(3,1);
            setLayout(gl);

            JLabel label = new JLabel("name book");
            label.setHorizontalAlignment(JLabel.CENTER);
            add(label);
            add(textField);
            add(warnings);
        }

        public JTextField getTextField() {
            return textField;
        }

        public JLabel getWarnings() {
            return warnings;
        }
    }
}
