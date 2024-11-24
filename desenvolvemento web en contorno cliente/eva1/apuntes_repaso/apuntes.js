//  DIFERENCIA ENTRE VAR Y LET (var permite la declaracion de variables con el mismo nombre, let no)

var x1=1
var x1=2
console.log("Variables con var "+ x1)

let x2=1 
//let x2=2
console.log("Variables con var "+ x2)

// VARIABLES

var numero= 10;
var pais="España"

let numero= 10;
let pais="España"

// CONSTANTES

const num1=2,num2=2;

// USE STRICT (evita el uso de variables globales implícitas)

// Sin 'use strict' se crea como variable global
x = 10;

// Con 'use strict' da error: x no está declarada
x = 10;

// OPERACIONES MATEMÁTICAS

suma=num1 + num2;
resta=num1 - num2;
multiplicacion=num1 * num2;
division=num1 / num2;

const coseno180 = Math.cos(180 * (Math.PI / 180)).toFixed(10);
const numeroMayor = Math.max(34, 67, 23, 75, 35, 19);
const numeroAzar = (Math.random() * 100);

// AÑADIR ELEMENTOS AL FINAL DE UN ARRAY

let numeros = [];
numeros.push(num1);

// GENERAR UN NÚMERO ALEATORIO ENTRE 0 Y 50

const max = 50;
const min = 0;

const aleatorio = Math.floor(Math.random() * ((max - min) + 1) + min);

// ESCRIBIR EN CONSOLA

console.log("La suma es " + suma);
console.log("La resta es " + resta);
console.log("La multiplicacion es " + multiplicacion);
console.log("La division es " + division);

console.log(`La suma es ${suma}`);
console.log(`La resta es ${resta}`);
console.log(`La multiplicacion es ${multiplicacion}`);
console.log(`La division es ${division}`);

// ESCRIBIR EN EL DOCUMENTO

document.write(`<h2>El país seleccionado es ${pais}</h2>`);

// TRATAMIENTO DE STRINGS

const nombreCompleto = prompt("Introduzca su nombre y apellidos:");

const nombreSinEspacios = nombreCompleto.trim();
const primeraA = nombreSinEspacios.toLowerCase().indexOf('a') + 1;
const ultimaA = nombreSinEspacios.toLowerCase().lastIndexOf('a') + 1;
const nombreMenosTres = nombreSinEspacios.slice(3);
const nombreMayusculas = nombreSinEspacios.toUpperCase();

// TRATAMIENTO DE FECHAS

const diaNacimiento = prompt("Introduzca DIA de nacimiento:");
const mesNacimiento = prompt("Introduzca MES de nacimiento:");
const anioNacimiento = prompt("Introduzca AÑO de nacimiento:");

const fechaNacimiento = new Date(`${anioNacimiento}-${mesNacimiento}-${diaNacimiento}`);

// PEDIR INPUTS POR CONSOLA

var numero1 = parseInt(prompt('Introduce el primer numero'));
var numero2 = parseInt(prompt('Introduce el segundo numero'));

// BUCLE QUE PIDE NÚMEROS HASTA QUE SEAN CORRECTOS

while (numero1 <=0  || isNaN(numero1)|| numero2 <=0  || isNaN(numero2) ){
    numero1 = parseInt(prompt('Introduce el primer numero',0));
    numero2 = parseInt(prompt('Introduce el segundo numero',0));
}

// BUCLE QUE PIDE UN NÚMERO Y NO SE DETIENE HASTA QUE EL NÚMERO INTRODUCIDO ES 0

do {
    numero = parseInt(prompt('Introduce numeros hasta pulsar 0'));
} while (numero != 0);

// MOSTRAR MENSAJE DE ALERTA SI LOS DATOS NO SON CORRECTOS

if (!isNaN(numeroUsuario) && numeroUsuario >= 1 && numeroUsuario <= 100) {
    // break; // Salir del bucle si es válido
}
alert("Por favor, introduce un número válido entre 1 y 100.");

// ABRIR UNA VENTANA NUEVA Y MOSTRAR DATOS DEL NAVEGADOR

const nuevaVentana = window.open("", "_blank", "width=800,height=600,resizable=no");

nuevaVentana.document.write("<h3>Ejemplo de Ventana Nueva</h3>");
nuevaVentana.document.write(`URL Completa: ${window.location.href}<br>`);
nuevaVentana.document.write(`Protocolo utilizado: ${window.location.protocol}<br>`);
nuevaVentana.document.write(`Nombre en código del navegador: ${navigator.appCodeName}<br>`);
nuevaVentana.document.write('<iframe src="https://example.com" width="800" height="600"></iframe>');

if (navigator.javaEnabled()) {
    nuevaVentana.document.write("Java SI disponible en esta ventana<br>");
} else { nuevaVentana.document.write("Java NO disponible en esta ventana<br>"); }

// SELECCIONAR ELEMENTOS POR SU ID

const enviarButton = document.querySelector("#idEnviar");
document.getElementById("idEnviar");

// AÑADIR CÓDIGO HTML A UN ELEMENTO PREEXISTENTE SELECCIONANDOLO POR SU ID

const resultadosDiv = document.getElementById("resultados");

resultadosDiv.innerHTML = 
`
    <p>Buenos días ${nombreCompleto}.</p>
    <p>Tu nombre tiene ${nombreCompleto.length} caracteres, incluidos espacios.</p>
`;

// CREAR UN NUEVO ELEMENTO HTML, AÑADIRLE CÓDIGO HTML Y AÑADIRLO A OTRO PREEXISTENTE SELECCIONANDOLO POR SU ID

let parrafo1=document.createElement('h1');

let dia = fecha.getDate();
let mes = fecha.getMonth();
let anno = fecha.getFullYear();
parrafo1.innerHTML=`${dia}/${( mes +1 )}/${anno}` ;

document.getElementById("fecha1").append(parrafo1);

// OBTENER EL VALOR DE UN INPUT EN UN FORMULARIO

let cadena = document.getElementById("fechaNacimiento").value;

// MODIFICAR ATRIBUTOS CSS DE UN ELEMENTO DESDE JS

mostrar = () => document.getElementById("parrafoAyuda").style.visibility = 'visible';
ocultar = () => document.getElementById("parrafoAyuda").style.visibility = 'hidden';

// EVENTO DE ESCUCHA PARA EJECUTAR UNA FUNCIÓN CUANDO EL USUARIO PULSA UN BOTÓN

ventana.document.getElementById('botonCerrar').addEventListener('click', cerrarNuevaVentana);

// FUNCIONES

// Función para limpiar valores de un formulario

function limpiarFormulario() {
    window.location.reload();
}

//Función que comprueba si un numero es primo
function esPrimo(numero1){
    for (let i=2;i<numero1;i++)
        if (numero1 % i == 0)
            return false;
    return true;
}
if (esPrimo(numero1))
    document.write(`El numero ${numero1} es primo`);
else
document.write(`El numero ${numero1} no es primo`);

// FUNCIÓN DE CALLBACK

// Las funciones Callbacks es un modo de asegurarnos de que cierto código no se ejecuta hasta que otro código haya terminado de ejecutarse   

function suma(numero1, numero2){ return (numero1+numero2); }

function esParImpar(numero1){
    console.log(numero1);
    if (numero1 % 2 == 0)
        return " par";
    else  
        return " impar";
}

function mostrar(numero1,numero2,esParImpar) {

    let resultado=suma(numero1,numero2);
    esParImpar(resultado);
    document.write("<h3> El numero " + resultado + esParImpar);

}

mostrar(numero1,numero2,esParImpar());