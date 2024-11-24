
//Ejemplo de bucle que pide numeros hasta pulsar 0
//En esta primera solución no se almacena en un array, pero es más aconsejable,
//ya que de esa forma podríamos mostrar los números en el mensaje de salida

let numero = 0;
let suma = 0;
let media = 0.0;
let cont = 0;
let numeros = [];



do {
    numero = parseInt(prompt('Introduce numeros hasta pulsar 0'));

    //Supongamos que queremos almacenar los datos en un array
    //El método push inserta elementos al final del array. Se tratará en temas posteriores el manejo de arrays
    if (numero != 0 || isNaN(numero)) {
        cont++;
        suma = suma + numero;
        numeros.push(numero);
    }



} while (numero != 0);

//Comprobar que el usuario introduce datos y no pulsa cancelar. Podemos realizarlo de muchas maneras pero una básica es preguntar si cont==0
if (cont != 0) {
    //Obtener la media. Otra forma podría ser recorrer el array para sumar y calcular la media
    media = suma / cont;
    document.write(`<h2>La suma de los numeros ${numeros} es ${suma}</h2>`);

    //Método para mostrar el dato por pantalla con formato
    document.write("<p>La media es " + media.toFixed(2) + "</p>");
}
