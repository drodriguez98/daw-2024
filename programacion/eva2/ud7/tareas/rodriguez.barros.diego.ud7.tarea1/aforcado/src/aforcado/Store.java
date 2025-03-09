/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package aforcado;

/**
 *
 * @author diego
 */

// Store é un obxecto que permite realizar operacións sobre os obxectos dunha clase.
public interface Store<T> {
    // Engade un obxecto á Store, retornando true se o engade correctamente, falso noutro caso
    boolean add(T obj);
    
    // Recupera obxectos que cumpren co filtro, devolve null se non hai resultados
    T[] get(Filter<T> f);

    // Elimina obxectos que cumpren co filtro, devolve -1 se hai erro
    int delete(Filter<T> f);

    // Recupera todos os obxectos almacenados na Store
    T[] list();
}
