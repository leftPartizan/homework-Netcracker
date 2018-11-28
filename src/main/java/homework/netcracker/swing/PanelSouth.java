package homework.netcracker.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class PanelSouth extends JPanel {
    private JDialog dialog;
    private JPanel subPanel = new JPanel();
    private JButton buttonOk = new JButton("OK");
    private JButton buttonCancel = new JButton("Cancel");

    public PanelSouth(JDialog dialog) {

        setLayout(new BorderLayout());
        this.dialog = dialog;
        subPanel.setLayout(new FlowLayout());
        subPanel.add(buttonOk);
        subPanel.add(buttonCancel);
        add(subPanel, BorderLayout.EAST);

        buttonCancel.addActionListener(this::closeDialog);
    }


    public JButton getButtonOk() {
        return buttonOk;
    }

    public JButton getButtonCancel() {
        return buttonCancel;
    }

    private void closeDialog(ActionEvent e) {
        dialog.dispose();
    }

}