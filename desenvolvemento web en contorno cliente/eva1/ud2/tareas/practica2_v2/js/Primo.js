//Programa que comprueba si un numero es primo

/*
Los números primos son aquellos que solo son divisibles entre ellos mismos y el 1, 
es decir, que si intentamos dividirlos por cualquier otro número, el resultado no es entero. 
Dicho de otra forma, si haces la división por cualquier número que no sea 1 o él mismo, se obtiene un resto distinto de cero.

¿Cuáles son los números primos del 1 al 100?
Números primos: cómo encontrarlos con la criba de Eratóstenes
2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89 y 97.
*/

'use strict'

let numero = 0;
let primos = [];

//Declarar la función recorreMenoresPrimos como una expresión, por lo que debe declararse antes de su llamada

const recorreMenoresPrimos = function (numero) {
    
    let i=0;
    for (let num = numero - 1; num > 2; num--)
        if (esPrimo(num)) {
            //Añadir el número primo en un array de Primos;
            primos[i] = num;
            i++;
        }

};

// Método que solicita número comprueba que el número sea positivo y que no sea caracter y que el 
// usuario no pulse el botón Cancelar5

numero = (prompt("Introduce un numero entero", 0));
if (numero == null)
    alert("Ha pulsado cancelar");
else {
    numero = parseInt(numero);
    if (isNaN(numero) || (numero <= 0))
        alert("Valor incorrecto");
    else {
        if (esPrimo(numero)) {
            document.write("<hr>");
            document.write(`<h2> El numero ${numero} es primo </h2>`);
            document.write("<hr> <br>");
            recorreMenoresPrimos(numero); //Llama a la función que comprueba y muestra todos los números primos menor a un número dado
            console.log(primos);
            document.write(`<h1> Los números primos menores que el ${numero} son ${primos} </h1>`);
        }

        else
            document.write(`<h2> El numero ${numero} no es primo </h2>`);

    }
}


//Función que comprueba si un numero es primo5
function esPrimo(numero) {

    for (let i = 2; i < numero; i++)
        if (numero % i == 0)
            return false;
    return true;
}




