/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package comparator;

/**
 *
 * @author diego
 */

import java.util.Comparator;

public class ComparatorPorDni implements Comparator<Cliente> {
    @Override
    public int compare(Cliente o1, Cliente o2) {
        return o1.getDni().compareTo(o2.getDni());
    }
}
