
//Declaración de variables globales
var opciones = "left=100,top=500,width=450,height=150";
var ventana = null;
var cuadrosTexto;
/* Función que crea una nueva ventana. En este caso utilizamos el método document.write para escribir toda la estructura de la página 
Web. Es la forma más simple de crear la estructura sin necesidad de añadir y crear nuevos módulos. A medida que avancemos se irá resolviendo
de una forma más adecuada */

const crearNuevaVentana = () => {

    ventana = window.open('', 'ventana', opciones);
    ventana.name = "nueva";
    console.log(cuadrosTexto[0].value);

    ventana.document.write('<head><meta http-equiv="content-type" content="text/html; charset=iso-8859-1"><title>Titulo nueva ventana</title>');
    ventana.document.write('<link rel="stylesheet" href="./css/styles.css"></head>')
    ventana.document.write('<body id="cuerpo">');
    ventana.document.write('<div id="capa"></div>');
    ventana.document.write('<input type="button" id="botonCerrar" value="Cerrar">');
    ventana.document.write('</body>')

    /* Utilizamos los métodos de la estructura DOM para acceder al div capa y el método createElement para crear un nuevo nodo H1 */
    const capa = ventana.document.getElementById("capa");
    const h1 = ventana.document.createElement("h1");

    // Accede al contenido del texto de un elemento
    h1.innerHTML = cuadrosTexto[0].value+ "</br>" + cuadrosTexto[1].value;
    capa.appendChild(h1);

    ventana.document.write('</div>');
    ventana.document.write('</body>');
    ventana.document.getElementById('cuerpo').style.backgroundColor = "grey";


    //Adjunta un controlador de eventos al elemento especificado
    ventana.document.getElementById('botonCerrar').addEventListener('click', cerrarNuevaVentana, false);

}

const comprobar = () => {

    //Recorre todos los cuadros de texto para comprobar que tienen valores
    for (let i = 0; i < cuadrosTexto.length; i++) {
        if (cuadrosTexto[i].value == "") {
            alert("Error debe introducir un valor");
            return false;
        }
    }
    return true;
}

/* Método que da funcionalidad al botón Cerrar de la nueva ventana creada */
const cerrarNuevaVentana = () => {
    console.log(ventana.name);
    ventana.close();
}

/* Metodo que modifica la propiedad css para hacer visible la ayuda */
mostrar = () => document.getElementById("parrafoAyuda").style.visibility = 'visible';
/* Metodo que modifica la propiedad css para ocultar la ayuda */
ocultar = () => document.getElementById("parrafoAyuda").style.visibility = 'hidden';

/*Evento load --> A través de este evento tenemos la seguridad de que la página está cargada completamente, incluyento las imagenes
, estiloes, etc  */

window.addEventListener('load', function () {
    console.log('La página ha terminado de cargarse!!');

    /* Almacena todos los  cuadros de la página en el array cuadrosTexto */
    cuadrosTexto = document.querySelectorAll("input");

    const enviarButton = document.querySelector("#idEnviar");
    const borrarButton = document.querySelector("#idBorrar");
    const ayudaButton = document.querySelector("#idAyuda");
    const cerrarAyuda = document.querySelector("#idCerrarAyuda");

    /* A continuación vamoa a implementar la funcionalidad */

    enviarButton.onclick = function () {
        /* Con esta instruccion condicional comprobarmos que el usuario introduce los datos en el cuadro de texto.
        Para ello se llama a la función comprobar la cual devuelve el valor true o false dependiendo que los cuadros de texto
        tengan o no valores */

        if (comprobar())
            /* Llama a la función crearNuevaVentana*/
            crearNuevaVentana();
    }

    borrarButton.onclick = function () {
        cuadrosTexto.forEach((element) => element.value = "");
    }

    ayudaButton.onclick = function () {
        mostrar();
    }

    cerrarAyuda.onclick = function () {
        ocultar();
    }

});