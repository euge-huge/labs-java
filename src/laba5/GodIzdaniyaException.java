package laba5;

import java.io.Serializable;

public class GodIzdaniyaException extends Exception implements Serializable {
    public GodIzdaniyaException(String msg) {
        super(msg);
    }
}
