package database;

// Interfaz para la base de datos, con métodos genéricos para operar con objetos Storable.
public interface Database<T extends Storable<K>, K> {
    
    // Retorna todos los objetos almacenados en la base de datos.
    T[] getAll(); 
    
    // Retorna el objeto identificado por la clave 'key' o null si no existe.
    T get(K key); 
    
    // Retorna todos los objetos que cumplan con el filtro proporcionado.
    T[] find(Filter<T> f); 
    
    // Almacena un objeto. Lanza StorageException si ya existe o si ocurre otro error.
    void add(T t) throws StorageException; 
    
    // Elimina el objeto identificado por la clave 'key'. Lanza StorageException si no existe.
    void del(K key) throws StorageException;  
    
    // Actualiza un objeto. Lanza StorageException si no existe o si ocurre otro error.
    void update(T object) throws StorageException; 
    
    // Retorna el número de objetos almacenados en la base de datos.
    int size(); 
}
