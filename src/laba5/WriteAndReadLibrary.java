package laba5;

import java.io.*;

public class WriteAndReadLibrary {
    static void write(Library libraryToWrite, String filename) throws IOException {
        FileOutputStream fileOutput = new FileOutputStream(filename);
        ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);
        objectOutput.writeObject(libraryToWrite);

        fileOutput.close();
        objectOutput.close();
    }
    
    static Library read(String filename) throws IOException, ClassNotFoundException {
        FileInputStream fileInput = new FileInputStream(filename);
        ObjectInputStream objectInput = new ObjectInputStream(fileInput);

        Library library = (Library) objectInput.readObject();

        fileInput.close();
        objectInput.close();

        return library;
    }

}
