package laba9;

import javax.swing.*;

public class DescriptionPane {
    JFrame f;

    DescriptionPane(String description) {
        f = new JFrame();
        if (description.equals("not-selected")) {
            JOptionPane.showMessageDialog(f, "Вы не выбрали издание");
        } else {
            JOptionPane.showMessageDialog(f, description);
        }
    }
}
