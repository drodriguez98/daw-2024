// El uso de rest es bastante sencillo, ya que podemos emplearlo dentro del juego de parámetros definido en la cabecera de una función. Veámoslo con un ejemplo de código en el que indicaremos como parámetro de la función “…numeros”:
// function max(...numeros) {
//    console.log(numeros);
// }

// En este ejemplo, lo que indicamos es que cualquier cantidad de parámetros que se envíen al invocar la función se estructurará como un array y dentro de la función se conocerá con el nombre de “numeros”. De este modo, podremos invocar a la función con el número de parámetros que queramos, teniendo siempre en el parámetro numero un array, con el número de casillas deseado. Para comprobar esto, basta con invocar a la función anterior utilizando el juego de parámetros que deseemos:

//  max(1, 2, 6);
//  max();
//  max(1, 5, 6, 7, 10001);

// Podemos hacerlo así, o también mezclando varios tipos de parámetros:
//  max('test', 4, true, 2000, '90');
// Siempre  llegará un array

//Función que comprueba si un numero es par
function esPar(numero1){
    if (numero1 % 2 == 0)
    return true;
else  return false;
}

function mostrar(...numeros){
    console.log("El tipo de dato es "+typeof(numeros));
    
    for (var i=0;i<numeros.length;i++){
        console.log("El tipo de dato de cada elemento es "+typeof(numeros[i]));
        if (esPar(numeros[i]))
            console.log("El numero " +numeros[i]+ " es par");
        else   document.write("<h3> El numero " +numeros[i]+ " es impar </h3>");
    }
}

//Llamada a la funcion mostrar por consola o documento si es par o impar 

mostrar(1,6,7,22,2,3,5);
