// En este código el usuario introduce dos números y devuelve como resultado la suma, indicando además si es par o impar. Para ello utilizamos una función de callback para asegurarnos de que cierto código no se ejecuta hasta que otro código no haya terminado de ejecutarse. 

'use strict'

var numero1 = parseInt(prompt('Introduce el primer numero'));

var numero2 = parseInt(prompt('Introduce el segundo numero'));

//Ejemplo de bucle que pide numeros hasta que sean correctos

while (numero1 <=0  || isNaN(numero1)|| numero2 <=0  || isNaN(numero2) ){

    numero1 = parseInt(prompt('Introduce el primer numero',0));

    numero2 = parseInt(prompt('Introduce el segundo numero',0));

}

//Funcion que suma dos numeros

function suma(numero1, numero2){

    return (numero1+numero2);

}

//Función que comprueba si un numero es par

function esParImpar(numero1){

    console.log(numero1);

    if (numero1 % 2 == 0)

        return " par";

    else  

        return " impar";

}

function mostrar(numero1,numero2,esParImpar)

{

    let resultado=suma(numero1,numero2);

    esParImpar(resultado);

    //Las funciones Callbacks es un modo de asegurarnos de que cierto código no se ejecuta hasta que otro código haya terminado de ejecutarse   

    document.write("<h3> El numero " + resultado + esParImpar);

}

mostrar(numero1,numero2,esParImpar());