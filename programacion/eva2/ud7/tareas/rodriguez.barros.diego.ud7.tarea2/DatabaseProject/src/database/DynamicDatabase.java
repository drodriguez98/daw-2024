package database;

import java.util.*;

// Implementación de la interfaz Database utilizando una estructura de almacenamiento dinámica (un HashMap).
public class DynamicDatabase<T extends Storable<K>, K> implements Database<T, K> {

    // Mapa para almacenar los objetos, donde la clave es de tipo K y el valor es de tipo T.
    private final Map<K, T> storage = new HashMap<>();
    
    // Clase que se utiliza para crear instancias de tipo T.
    private final Class<T> clazz;

    // Constructor que recibe la clase de tipo T para poder crear arrays de T más tarde.
    public DynamicDatabase(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public T[] getAll() {
        // Crea un array de tipo T con el tamaño del almacenamiento actual.
        @SuppressWarnings("unchecked")
        T[] resultArray = (T[]) java.lang.reflect.Array.newInstance(clazz, storage.size());
        // Devuelve todos los valores del mapa en un array de tipo T.
        return storage.values().toArray(resultArray);
    }

    @Override
    public T get(K key) {
        // Retorna el objeto asociado con la clave 'key', o null si no existe.
        return storage.get(key);
    }

    @Override
    public T[] find(Filter<T> f) {
        // Crea una lista donde almacenaremos los objetos que cumplen con el filtro.
        List<T> resultList = new ArrayList<>();
        
        // Recorre todos los valores del mapa.
        for (T element : storage.values()) {
            // Si el objeto pasa el filtro, lo añadimos a la lista.
            if (f.isValid(element)) {
                resultList.add(element);
            }
        }
        
        // Crea un array de tipo T con el tamaño de la lista de resultados y lo devuelve.
        @SuppressWarnings("unchecked")
        T[] resultArray = (T[]) java.lang.reflect.Array.newInstance(clazz, resultList.size());
        return resultList.toArray(resultArray);
    }

    @Override
    public void add(T t) throws StorageException {
        // Si el objeto ya existe (según su clave), lanzamos una excepción.
        if (storage.containsKey(t.getKey())) {
            throw new StorageException("Elemento xa existente con clave: " + t.getKey());
        }
        // Si no existe, lo añadimos al almacenamiento.
        storage.put(t.getKey(), t);
    }

    @Override
    public void del(K key) throws StorageException {
        // Si el objeto no existe, lanzamos una excepción.
        if (!storage.containsKey(key)) {
            throw new StorageException("Non existe un elemento coa chave: " + key);
        }
        // Si existe, lo eliminamos del almacenamiento.
        storage.remove(key);
    }

    @Override
    public void update(T object) throws StorageException {
        // Si el objeto no existe, lanzamos una excepción.
        if (!storage.containsKey(object.getKey())) {
            throw new StorageException("Non existe un elemento coa chave: " + object.getKey());
        }
        // Si existe, lo actualizamos con el nuevo objeto.
        storage.put(object.getKey(), object);
    }

    @Override
    public int size() {
        // Retorna el tamaño del almacenamiento (número de objetos).
        return storage.size();
    }
}
