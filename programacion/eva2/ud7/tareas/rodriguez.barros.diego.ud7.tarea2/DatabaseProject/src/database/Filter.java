package database;

// Interfaz genérica para un filtro que valida objetos del tipo T.
public interface Filter<T> {
    
    // Método que devuelve true si el objeto es válido según el filtro, false en caso contrario.
    boolean isValid(T obj);
}
