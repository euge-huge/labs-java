package laba8;

import java.io.IOException;

public class Laba8 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Laba8GUI app = new Laba8GUI();
        app.pack();
        app.showMenu();
        app.setVisible(true);
    }
}
