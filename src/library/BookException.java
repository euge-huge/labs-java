package library;

import java.io.Serializable;

public class BookException extends Exception implements Serializable {
    public BookException() {}
    public BookException(String msg) {
        super(msg);
    }
}
