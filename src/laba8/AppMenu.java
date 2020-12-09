package laba8;

import javax.swing.*;

public class AppMenu {
    JMenuBar menuBar = new JMenuBar();
    JMenu menu = new JMenu();
    JMenuItem item1 = new JMenuItem("first");
    JMenuItem item2 = new JMenuItem("second");
    JMenuItem item3 = new JMenuItem("third");
    public AppMenu() {
        menu.add(item1);
        menu.add(item2);
        menu.add(item3);

        menuBar.add(menu);
    }
}
