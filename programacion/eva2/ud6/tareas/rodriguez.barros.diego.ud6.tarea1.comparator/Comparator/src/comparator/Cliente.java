/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package comparator;

/**
 *
 * @author diego
 */

public class Cliente {
    private String dni;
    private String nome;
    private double saldo;

    // Constructor
    public Cliente(String dni, String nome, double saldo) {
        this.dni = dni;
        this.nome = nome;
        this.saldo = saldo;
    }

    // Getters
    public String getDni() {
        return dni;
    }

    public String getNome() {
        return nome;
    }

    public double getSaldo() {
        return saldo;
    }

    // ToString para imprimir
    @Override
    public String toString() {
        return "Cliente{" + "dni='" + dni + "', nome='" + nome + "', saldo=" + saldo + "}";
    }
}
