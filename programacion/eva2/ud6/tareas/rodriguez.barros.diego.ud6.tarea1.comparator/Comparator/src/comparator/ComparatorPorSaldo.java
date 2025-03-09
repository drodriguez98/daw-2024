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

public class ComparatorPorSaldo implements Comparator<Cliente> {
    @Override
    public int compare(Cliente o1, Cliente o2) {
        return Double.compare(o1.getSaldo(), o2.getSaldo());
    }
}

