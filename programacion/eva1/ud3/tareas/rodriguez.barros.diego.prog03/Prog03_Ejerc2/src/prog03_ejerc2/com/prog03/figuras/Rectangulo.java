/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog03_ejerc2.com.prog03.figuras;

/**
 *
 * @author diego
 */
public class Rectangulo {
    
        private float base;   // Atributo que representa a base do rectángulo
    private float altura; // Atributo que representa a altura do rectángulo

    // Constructor sen parámetros que inicializa base e altura a 0
    public Rectangulo() {
        this.base = 0;
        this.altura = 0;
    }

    // Constructor que inicializa a base e a altura cos valores recibidos por parámetro
    public Rectangulo(float base, float altura) {
        this.base = base;
        this.altura = altura;
    }

    // Método para obter o valor da base
    public float getBase() { return base; }

    // Método para establecer un novo valor para a base
    public void setBase(float base) { this.base = base; }

    // Método para obter o valor da altura
    public float getAltura() { return altura; }

    // Método para establecer un novo valor para a altura
    public void setAltura(float altura) { this.altura = altura; }

    // Método que calcula a área do rectángulo multiplicando a base pola altura
    public float getArea() { return base * altura; }

    // Método que devolve unha descrición do rectángulo en formato de texto
    public String toString() { return "Rectangulo de base " + base + ", altura " + altura + " e area " + getArea(); }

    // Método que verifica se o rectángulo é un cadrado (se a base é igual á altura)
    public boolean isCuadrado() { return base == altura; }
    
}
