package ca.canada.utils;

public class FrameworkException extends RuntimeException {
    public FrameworkException(String errorMessage) {
        super(errorMessage);
    }

    public FrameworkException(String errorMessage, Exception e) {
        super(errorMessage, e);
    }
}
