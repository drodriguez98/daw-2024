package utils;

public class CancelException extends Exception {
    public CancelException() {
        super("Operación cancelada polo usuario.");
    }
}
