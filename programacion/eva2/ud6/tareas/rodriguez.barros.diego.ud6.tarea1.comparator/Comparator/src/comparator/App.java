/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package comparator;

/**
 *
 * @author diego
 */

import java.util.Arrays;
import java.util.Comparator;

public class App {
    public static void main(String[] args) {
        Cliente[] clientes = new Cliente[]{
            new Cliente("12345678A", "Carlos García", 2500.00),
            new Cliente("98765432B", "Ana Pérez", 3500.50),
            new Cliente("45678901C", "Luis López", 1800.75),
            new Cliente("13579246D", "Sofia Martínez", 4200.25)
        };

        // Ordenados por DNI (clase ordinaria)
        System.out.println("Ordeados por DNI (clase ordinaria):");
        Arrays.sort(clientes, new ComparatorPorDni());
        for (Cliente c : clientes) {
            System.out.println(c);
        }

        // Ordenados por saldo (clase ordinaria)
        System.out.println("\nOrdeados por saldo (clase ordinaria):");
        Arrays.sort(clientes, new ComparatorPorSaldo());
        for (Cliente c : clientes) {
            System.out.println(c);
        }

        // Ordenados por nombre (alfabético, mayor a menor) (clase ordinaria)
        System.out.println("\nOrdeados por nome (alfabético, mayor a menor) (clase ordinaria):");
        Arrays.sort(clientes, new ComparatorPorNome());
        for (Cliente c : clientes) {
            System.out.println(c);
        }

        // Ordenados por DNI (clase anónima)
        System.out.println("\nOrdeados por DNI (clase anónima):");
        Arrays.sort(clientes, new Comparator<Cliente>() {
            @Override
            public int compare(Cliente o1, Cliente o2) {
                return o1.getDni().compareTo(o2.getDni());
            }
        });
        for (Cliente c : clientes) {
            System.out.println(c);
        }

        // Ordenados por saldo (clase anónima)
        System.out.println("\nOrdeados por saldo (clase anónima):");
        Arrays.sort(clientes, new Comparator<Cliente>() {
            @Override
            public int compare(Cliente o1, Cliente o2) {
                return Double.compare(o1.getSaldo(), o2.getSaldo());
            }
        });
        for (Cliente c : clientes) {
            System.out.println(c);
        }

        // Ordenados por nombre (alfabético, mayor a menor) (clase anónima)
        System.out.println("\nOrdeados por nome (alfabético, mayor a menor) (clase anónima):");
        Arrays.sort(clientes, new Comparator<Cliente>() {
            @Override
            public int compare(Cliente o1, Cliente o2) {
                return o2.getNome().compareTo(o1.getNome());
            }
        });
        for (Cliente c : clientes) {
            System.out.println(c);
        }

        // Ordenados por DNI (lambda)
        System.out.println("\nOrdeados por DNI (lambda):");
        Arrays.sort(clientes, (o1, o2) -> o1.getDni().compareTo(o2.getDni()));
        for (Cliente c : clientes) {
            System.out.println(c);
        }

        // Ordenados por saldo (lambda)
        System.out.println("\nOrdeados por saldo (lambda):");
        Arrays.sort(clientes, (o1, o2) -> Double.compare(o1.getSaldo(), o2.getSaldo()));
        for (Cliente c : clientes) {
            System.out.println(c);
        }

        // Ordenados por nombre (alfabético, mayor a menor) (lambda)
        System.out.println("\nOrdeados por nome (alfabético, mayor a menor) (lambda):");
        Arrays.sort(clientes, (o1, o2) -> o2.getNome().compareTo(o1.getNome()));
        for (Cliente c : clientes) {
            System.out.println(c);
        }
    }
}
