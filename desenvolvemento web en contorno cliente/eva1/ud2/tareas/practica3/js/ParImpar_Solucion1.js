//Declarar un array de numeros
let numeros=[1,2,3,5,6,7,22];

console.log(numeros);

//Llamada a la funcion mostrar por consola o documento si es par o impar 
for (let i=0;i<numeros.length;i++)
    mostrar(numeros[i]);


//Función que comprueba si un numero es par
function esPar(numero1){
if (numero1 % 2 == 0)
    return true;
else  return false;
}

function mostrar(numero1, mostrarParImpar=false){
   
    mostrarParImpar=esPar(numero1);

    if (mostrarParImpar)
        console.log("El numero " +numero1+ " es par");
    else   document.write("<h3> El numero " +numero1+ " es impar </h3>");
}