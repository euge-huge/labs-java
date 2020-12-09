package laba7;

import java.awt.*;
import java.io.*;

public class Laba7 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Laba7GUI app = new Laba7GUI();
        app.pack();
        app.setSize(new Dimension(540, 300));
        app.setLocationRelativeTo(null);
        app.setVisible(true);
    }
}
