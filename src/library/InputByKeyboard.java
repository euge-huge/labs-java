package library;

import java.io.IOException;
import java.io.Serializable;

class InputByKeyboard implements Serializable {

    public InputByKeyboard() {}

    static String readString() throws IOException {
        byte  b[] = new byte[100];
        System.in.read(b);
        String s = new String(b);
        s = s.trim();
        return s;
    }

    static int readInteger() throws IOException {
        byte  b[] = new byte[100];
        System.in.read(b);
        String s = new String(b);
        s = s.trim();
        int number = 0;
        try {
            number = Integer.parseInt(s);
        } catch (NumberFormatException ex) {
            System.out.println("Error! " + ex.getMessage());
        }
        return number;
    }
}
