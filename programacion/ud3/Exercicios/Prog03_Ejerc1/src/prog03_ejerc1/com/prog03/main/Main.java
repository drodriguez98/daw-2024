/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog03_ejerc1.com.prog03.main;

import prog03_ejerc1.com.prog03.fecha.Fecha;

/**
 *
 * @author diego
 */
public class Main {

    public static void main(String[] args) {
        // Primera fecha, inicializada con el primer constructor
        Fecha objFecha1 = new Fecha(Fecha.enumMes.FEBRERO);
        objFecha1.setDia(20);
        objFecha1.setAnio(2000);
        System.out.println("Primera fecha, inicializada con el primer constructor");
        System.out.println("La fecha es: " + objFecha1.toString());
        System.out.println(objFecha1.isSummer() ? "Es verano" : "No es verano");

        // Segunda fecha, inicializada con el segundo constructor
        Fecha objFecha2 = new Fecha(15, Fecha.enumMes.JULIO, 2015);
        System.out.println("\nSegunda fecha, inicializada con el segundo constructor");
        System.out.println("La fecha 2 contiene el anio " + objFecha2.getAnio());
        System.out.println("La fecha es: " + objFecha2.toString());
        System.out.println(objFecha2.isSummer() ? "Es verano" : "No es verano");
    }

}