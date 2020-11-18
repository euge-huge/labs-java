package laba5;

import java.io.Serializable;

public class BookException extends Exception implements Serializable {
    public BookException(String msg) {
        super(msg);
    }
}
