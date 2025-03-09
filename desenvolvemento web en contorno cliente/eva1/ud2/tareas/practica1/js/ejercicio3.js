//Declaramos la variable número y le asignamos el valor que introduce el usuario a través del prompt.
/*
Prompt() --> Es un método del objeto Window de JavaScript que se usa para mostrar un cuadro de diálogo
para que el usuario introduzca un valor.
Debemos tener en cuenta que devuelve una cadena de texto, por lo que si quieres recibir un valor entero 
hay que convertir el texto a number on el método parseInt (Método estático analiza un argumento de cadena y devuelve un número entero)

El segundo parámetro del método prompt nos indica el valor por defecto
 */

let numero = parseInt(prompt("Introduce el numero", 0));

document.write("<h1>Tabla de multiplicar</h1>");

//Declarar una variable constante con valor 10
const NUMEROS = 10;

for (let i = 0; i < NUMEROS; i++) {

    //Mostrar el resultado por la consola 
    console.log(`${numero}*${i}=${i * numero}`);
    //Mostrar el resultado en la ventana del navegador

    /*La función `document.write` en JavaScript se utiliza para manipular el contenido de una página web. 
    Esta función permite escribir directamente en el documento HTML, lo cual es útil para agregar contenido 
    dinámicamente o realizar cambios en tiempo real.
    Además, es posible utilizar etiquetas HTML dentro del argumento de la función `document.write` para dar formato al contenido
    */


    document.write(`${numero}*${i}=${i * numero}`); //Con esta sintaxis se sustituye el contenido de las variables numero e i
    document.write("<br>");

    //Otra forma de mostrar la tabla de multiplicar con document.write. Prueba a comentar las dos instrucciones anteriores y descomentar esta
    //document.write("<br>"+numero+"*"+i+"="+numero*i);

}

console.log("Bucle finalizado.");