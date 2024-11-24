// En este código el usuario introduce dos números pero con las funciones de callback tenemos la seguridad que ejecuta las funciones muestraSuma y muestraPorDos antes de acabar la ejecución de la función sumame

'use strict' 

var numero1 = parseInt(prompt('Introduce el primer numero'));

var numero2 = parseInt(prompt('Introduce el segundo numero'));

// Ejemplo de bucle que pide numeros hasta que sean correctos

while (numero1 <=0  || isNaN(numero1)|| numero2 <=0  || isNaN(numero2) ){

    numero1 = parseInt(prompt('Introduce el primer numero',0));

    numero2 = parseInt(prompt('Introduce el segundo numero',0));

}

// Funcion que suma dos numeros

function sumaYmuestra(dato){

    console.log("La suma es", dato)

}

function sumaPorDos(dato) { 
    
    console.log("La suma por dos es", (dato*2))

}

function sumame(numero1, numero2,muestraSuma, PorDos){

    var sumar=numero1+numero2;

    muestraSuma(sumar);

    PorDos(sumar);

    return sumar;

}

console.log(sumame(numero1,numero2,sumaYmuestra,sumaPorDos));