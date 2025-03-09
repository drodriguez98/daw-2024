// SELECCIONAR, MODIFICAR Y AÑADIR ELEMENTOS HTML

// Opción 1

var resultados1 = [5, 4, 7, 1, 3];
var parrafo1 = document.createElement('p');
parrafo1.innerHTML = `Estos son los resultados1: ${resultados1.join(', ')}`;
document.getElementById("resultados1").append(parrafo1);

// Opción 2

var resultados2 = [8, 2, 5, 4, 9];
var resultadosDiv2 = document.getElementById("resultados2");
resultadosDiv2.innerHTML = `Estos son los resultados2: ${resultados2.join(', ')}`;

// Opción 3

var resultados3 = [3, 9, 2, 3, 1];
var resultadosDiv3 = document.querySelector("#resultados3");
resultadosDiv3.innerHTML = `Estos son los resultados3: ${resultados3.join(', ')}`;

// BOTONES Y EVENTOS

// Opción 1

document.getElementById('submitButton').addEventListener('click', esPar);

function esPar() {
    var num = document.getElementById('numero').value;
    if ((num % 2) == 0) {
        document.write('PAR')
        return "Número par";
    } else { 
        document.write('IMPAR')
        return "Número impar" 
    }
}

// Opción 2

var resultados4 = document.getElementById('resultados4');

function esPar() {
    var num = document.getElementById('numero').value;
    if ((num % 2) == 0) {
        var respuesta = document.createElement('p');
        respuesta.innerHTML = `El número ${num} es par`;
        resultados4.append(respuesta);
    } else { 
        var respuesta = document.createElement('p');
        respuesta.innerHTML = `El número ${num} es impar`;
        resultados4.append(respuesta);
    }
}

// VENTANAS

// Esperar a que el DOM esté completamente cargado

var nuevaVentana = window.open("", "_blank", "resizable=no");
var cerrarVentanaDiv = document.getElementById('cerrarVentana');
var botonCerrarVentanaSecundaria = document.createElement('button');
var saludoVentanaPrincipal = document.createElement('p');
var saludoVentanaSecundaria = nuevaVentana.document.createElement('p'); 

saludoVentanaPrincipal.innerHTML = `Saludos desde la ventana principal`;
saludoVentanaSecundaria.innerHTML = `Saludos desde la ventana secundaria`;
botonCerrarVentanaSecundaria.innerHTML = "Cerrar ventana secundaria";  

nuevaVentana.document.body.appendChild(saludoVentanaSecundaria);
cerrarVentanaDiv.appendChild(saludoVentanaPrincipal);
cerrarVentanaDiv.appendChild(botonCerrarVentanaSecundaria);

botonCerrarVentanaSecundaria.addEventListener('click', cerrarNuevaVentana);

function cerrarNuevaVentana() {
    nuevaVentana.close();
}
