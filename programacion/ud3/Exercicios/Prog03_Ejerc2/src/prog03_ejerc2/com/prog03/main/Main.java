/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog03_ejerc2.com.prog03.main;

import prog03_ejerc2.com.prog03.figuras.Rectangulo;

/**
 *
 * @author diego
 */
public class Main {
  
    public static void main(String[] args) {
    // Instanciamos el primer rectángulo
    Rectangulo rect1 = new Rectangulo(10, 5);
    System.out.println(rect1.toString());
    System.out.println(rect1.isCuadrado() ? "Es un cuadrado" : "No es un cuadrado");

    // Instanciamos el segundo rectángulo
    Rectangulo rect2 = new Rectangulo(7, 7);
    System.out.println(rect2.toString());
    System.out.println(rect2.isCuadrado() ? "Es un cuadrado" : "No es un cuadrado");
}
    
}
