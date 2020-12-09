package laba9;

import library.Library;

import java.awt.*;
import java.io.IOException;

public class Laba9 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        run(null);
    }

    public static void run(Library library) throws IOException, ClassNotFoundException {
        Laba9GUI app = new Laba9GUI(library);
        app.pack();
        app.showMenu(library != null);
        app.setSize(new Dimension(540, 300));
        app.setLocationRelativeTo(null);
        app.setVisible(true);
    }
}
