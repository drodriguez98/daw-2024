//Generar un número aleatorio de 0 a 50
const max = 50;
const min = 0;
const intentos = 5;

const aleatorio = Math.floor(Math.random() * ((max - min) + 1) + min);
//Para probar que funciona correctamente podemos asignar un valor fijo a la variable aleatorio
//const aleatorio=23;

var numero;

//Llamada a la función acertarAleatorio
acertarAleatorio();


//Declarar funcion pedirNumero que solicita al usuario un número y comprueba que el valor introducido es correcto
function pedirNumero(i) {
    
    //Ejemplo de bucle que pide numeros hasta que sean correctos. La sentencia (hacer mientras) crea un bucle que ejecuta una sentencia especificada, 
    //hasta que la condición de comprobación se evalúa como falsa. 
    //La condición se evalúa después de ejecutar la sentencia, dando como resultado que la sentencia especificada se ejecute al menos una vez
    
    do {
        
        numero = (prompt(`Introduce el numero ${i}`, 0));

        //Comprueba si el usuario pulsa el botón Cancelar
        if (numero == null)
            break;
        numero = parseInt(numero);
        
    } while (isNaN(numero) || (numero <= 0 || numero > 50))

}

function acertarAleatorio() {

    for (let i = 0; i < intentos; i++) {

        pedirNumero(i);
        //En el caso de que el usuario pulse el botón Cancelar ya no continúa la ejecución del programa
        if (numero == null) {
            alert("Error, has pulsado cancelar");
            break;
        }


        if (numero === aleatorio) {
            alert("Has encontrado el número a buscar");
            break;
        } else if (numero < aleatorio)
            alert("El número a buscar en mayor");
        else
            alert("El número a buscar es menor");

    }

}
