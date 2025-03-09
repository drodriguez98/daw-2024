package database;

// Excepción personalizada para manejar errores de almacenamiento (por ejemplo, cuando un objeto ya existe o no se puede encontrar).
public class StorageException extends Exception {
    
    private static final long serialVersionUID = 1L;

    // Constructor que recibe un mensaje para la excepción.
    public StorageException(String msg) {
        super(msg);
    }
}
