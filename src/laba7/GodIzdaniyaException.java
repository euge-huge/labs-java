package laba7;

import java.io.Serializable;

public class GodIzdaniyaException extends Exception implements Serializable {
    public GodIzdaniyaException() {}
    public GodIzdaniyaException(String msg) {
        super(msg);
    }
}
