package io.mbab.sda;

public class ElementNotFoundException extends RuntimeException {

    public ElementNotFoundException() {
        super();
    }

    public ElementNotFoundException(String message) {
        super(message);
    }
}
