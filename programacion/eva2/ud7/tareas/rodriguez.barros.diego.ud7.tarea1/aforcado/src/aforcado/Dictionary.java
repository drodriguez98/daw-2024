/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aforcado;

/**
 *
 * @author diego
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// Dictionary almacena obxectos Definition e ofrece operacións sobre eles.
public class Dictionary implements Store<Definition> {
    private List<Definition> definitions = new ArrayList<>();

    @Override
    // Engade unha definición ao diccionario, devolve false se a palabra xa existe
    public boolean add(Definition obj) {
        for (Definition def : definitions) {
            if (def.getPalabra().equals(obj.getPalabra())) {
                return false;  // Non permite duplicados
            }
        }
        definitions.add(obj);  // Engadir ao diccionario
        return true;
    }

    @Override
    // Recupera as definicións que cumpren co filtro, devolve null se non hai resultados
    public Definition[] get(Filter<Definition> f) {
        List<Definition> result = new ArrayList<>();
        for (Definition def : definitions) {
            if (f.isValid(def)) {
                result.add(def);
            }
        }
        return result.isEmpty() ? null : result.toArray(new Definition[0]);
    }

    @Override
    // Elimina definicións que cumpren co filtro, devolve -1 se non hai elementos que eliminar
    public int delete(Filter<Definition> f) {
        int count = 0;
        List<Definition> toRemove = new ArrayList<>();
        for (Definition def : definitions) {
            if (f.isValid(def)) {
                toRemove.add(def);
            }
        }
        if (!toRemove.isEmpty()) {
            definitions.removeAll(toRemove);
            count = toRemove.size();
        }
        return count == 0 ? -1 : count;
    }

    @Override
    // Recupera todas as definicións almacenadas
    public Definition[] list() {
        return definitions.toArray(new Definition[0]);
    }

    // Recupera unha definición aleatoria do diccionario
    public Definition getRandomDefinition() {
        Random rand = new Random();
        if (definitions.isEmpty()) {
            throw new IllegalStateException("Non hai definicións no diccionario.");
        }
        return definitions.get(rand.nextInt(definitions.size()));
    }
}