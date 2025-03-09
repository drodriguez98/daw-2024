package utils;

import java.util.Arrays;

public class DinamicArray {

    private int number; // Número de elementos almacenados.
    private Object[] array; // Array subyacente.

    public DinamicArray(int initialcap) {
        if (initialcap <= 0) {
            throw new IllegalArgumentException("Capacidad inicial debe ser mayor a 0.");
        }
        this.array = new Object[initialcap];
        this.number = 0;
    }

    public int length() { return number; }

    public int size() { return array.length; }

    public Object[] toArray() { return Arrays.copyOf(array, number); }

    public void append(Object[] newArray) {
        for (Object obj : newArray) {
            add(obj);
        }
    }

    public void append(DinamicArray da) { append(da.toArray()); }

    public void add(Object obj) {
        if (number >= array.length) {
            resize(array.length + 20); // Incrementa la capacidad en bloques de 20.
        }
        array[number++] = obj;
    }

    public Object get(int idx) {
        checkBounds(idx);
        return array[idx];
    }

    public Object put(int idx, Object obj) {
        checkBounds(idx);
        Object old = array[idx];
        array[idx] = obj;
        return old;
    }

    public Object remove(int idx) {
        checkBounds(idx);
        Object removed = array[idx];
        System.arraycopy(array, idx + 1, array, idx, number - idx - 1);
        number--;
        array[number] = null; // Limpia la referencia.
        return removed;
    }

    public Integer position(Object obj) {
        for (int i = 0; i < number; i++) {
            if (array[i].equals(obj)) {
                return i;
            }
        }
        return null;
    }

    private void resize(int newCapacity) { array = Arrays.copyOf(array, newCapacity); }

    private void checkBounds(int idx) {
        if (idx < 0 || idx >= number) {
            throw new IndexOutOfBoundsException("Índice fuera de rango: " + idx);
        }
    }

}