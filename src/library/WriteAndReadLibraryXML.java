package library;


import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;

public class WriteAndReadLibraryXML {
    static void write(Library libraryToWrite, String filename) throws IOException {
        XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(filename)));
        encoder.writeObject(libraryToWrite);

        encoder.close();
    }

    public static Library read(String filename) throws IOException, ClassNotFoundException {
        XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(filename)));
        Library library = (Library) decoder.readObject();
        decoder.close();

        return library;
    }
}
