//El evento onload de Javascript 
//se activa cuando se termina de cargar la página.

window.addEventListener('load', function() {
    console.log('La página ha terminado de cargarse!!');
    
    let boton=document.getElementById('enviar');   
    boton.addEventListener('click',crearTexto);
    //Asignar el foco al cuadro de texto
    document.getElementById('nombre').focus();
});



/* Función que crea una nueva ventana y a la que se le manda como argumento el nombre introducido en el cuadro de texto con los estilos predeterminados */
const abrirVentana=(nombre,resultado)=>{
    let opciones="left=800,top=400,width=250px,height=250px", i= 0; 
    ventana = window.open('', 'ventana', opciones);
    
    ventana.name= "nueva";

    /* Asignar los estilos a la nueve ventana y crea el botón y la capa en la que se muestra el resultado. Esta es una forma básica de crearlos. Podemos hacerlo también con las 
    funciones de la estructura DOM */
    ventana.document.write('<head><meta http-equiv="content-type" content="text/html; charset=iso-8859-1"><title>Titulo nueva ventana</title>');
    ventana.document.write ('<link rel="StyleSheet" href="estilos.css" type="text/css"></head>')
    ventana.document.write('<body id="cuerpo">');
    ventana.document.write('<div id="capa">');
    ventana.document.write('</div>');
    ventana.document.write ('<input type="button" id="botonCerrar" value="Cerrar">');
   
    const capa = ventana.document.getElementById("capa");
    const parrafo = ventana.document.createElement("h1");
    const lineaHorizontal=ventana.document.createElement('hr');

    // Accede al contenido del texto de un elemento
    parrafo.innerHTML = nombre;
    
    capa.appendChild(parrafo);
    capa.appendChild(lineaHorizontal);

    let capanueva=ventana.document.createTextNode("p");
    capanueva=resultado.cloneNode(true);
    
    capanueva.style.textTransform = "capitalize";
    
    capa.appendChild(capanueva);
    
    ventana.document.write('</body>');
    
    ventana.blur();
    //Adjunta un controlador de eventos al elemento especificado
    ventana.document.getElementById('botonCerrar').addEventListener('click',cerrarNuevaVentana,false);
}

const cerrarNuevaVentana=(ventana)=>{

    parent.ventana.close();
    /* A continuación vamos a recargar la página principal para que borre el contenido. Al ejecutar puedes comprobar
    que si cerramos la ventana con el botón Cerrar, recarga la página principal, mientras que si lo hacemos con la X 
    no la recarga.  */
    window.location.reload();
}

const crearTexto=(event)=> {
    //Desactivar la funcionalidad por defecto de un botón de tipo Submit que es enviar los datos del formulario y recargar la pagina
    event.preventDefault();
    //Obtengo el nombre del campo de texto
    const nombre = document.miFormulario.nombre.value;

    //Obtengo el color de la lista desplegable
    var colores = document.miFormulario.color;
    var color = colores.options[colores.selectedIndex].value;
    //Tambiés sería válido, al menos en Chrome y Firefox, color = colores.value
    console.log(color);

    //Obtengo la fuente de los botones radio
    let fuentes = document.miFormulario.fuente;
    
    for (i=0; i<fuentes.length; i++) {
        let valor = fuentes[i].checked;
        if (valor == true) {
            elegido = fuentes[i];
        }
    }
    let fuente = elegido.value;
    console.log("La fuente elegida es " + fuente);
    //También sería váliudo, al menos en Chrome y Firefox, fuente = fuentes.value

    //Obtengo los efectos del checkbox
    let tachado = document.miFormulario.tachado.checked;
    let negrita = document.miFormulario.negrita.checked;
    let cursiva = document.miFormulario.cursiva.checked;
    let versalita = document.miFormulario.versalita.checked;
    let subrayado = document.miFormulario.subrayado.checked;
    console.log("tachado: " + tachado);
    console.log("negrita: " + negrita);


    //Ahora genero el texto
    const resultado = document.getElementById("resultado");
    //Escribo el texto
    resultado.innerHTML = nombre;

    //FALTA BORRAR EL ESTILO
    resultado.removeAttribute("style");
    resultado.style.textTransform = "capitalize"; //Esto serviría para poner las palabras con la primera letra en mayúscula si no se tuvieran en cuenta de, del o la

    //Aplico el color
    resultado.style.color = color;
    //Aplico la fuente
    resultado.style.fontFamily = fuente;
    resultado.style.fontSize = "40px"; //Pongo el texto mayor para que se vean los efectos

    //Aplico los efectos. En este caso no se utiliza un if anidado ya que las casillas de verificación permiten seleccionar varios estilos 
    if (tachado)
        resultado.style.textDecoration = "line-through";
    if (negrita)
        resultado.style.fontWeight = "bold";
    if (cursiva)
        resultado.style.fontStyle = "italic";
    if (versalita)
        resultado.style.fontVariant = "small-caps";
    if (subrayado)
        resultado.style.textDecoration = "underline";
    
    //LLamo a la funcion abrir ventana
    abrirVentana(nombre,resultado);
}