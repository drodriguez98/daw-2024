package database;

// Interfaz para objetos que se pueden almacenar en la base de datos, que deben tener una clave única.
public interface Storable<K> {
    
    // Método que devuelve la clave (clave única) del objeto.
    K getKey(); 
}
