// Programa que comprueba si un numero es primo

'use strict'
    
let numero1 = parseInt(prompt('Introduce un numero'));

//Función que comprueba si un numero es primo
function esPrimo(numero1){
    
    for (let i=2;i<numero1;i++)
        if (numero1 % i == 0)
            return false;
    return true;
}

//Llamar a la función esPrimo a la que se le manda como argumento el número introducido por el usuario. Dicha función devuelve un valor cierto o falso (return true/return false). Comprobamos el valor que devuelve con la estructura condicional if y se muestra el resultado a través del método write//

if (esPrimo(numero1))
    document.write(`El numero ${numero1} es primo`);
else
document.write(`El numero ${numero1} no es primo`);