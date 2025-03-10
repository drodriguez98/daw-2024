'use strict'
//El evento onload de Javascript 
//se activa cuando se termina de cargar la página.

window.addEventListener('load', function() {
    console.log('La página ha terminado de cargarse!!');
    
    let boton=document.getElementById('crear');   
    boton.addEventListener('click',crearCajas);

    let insertar=document.getElementById('antes');
    insertar.addEventListener('click',anadirAntes);

    let despues=document.getElementById('despues');
    despues.addEventListener('click',anadirDespues);
});

//Función que cambia el color de la caja al pasar con el ratón por encima

function cambiarColor(event){  
   
    //this.style.background='blue';
    //Otra forma
    event.target.style.background='blue';
}

/* Función que vuelve al color original al sacar el ratón. Para ello 
   debe comprobar de que clase se trata*/

function volverColor(event){  
    console.log("De que clase se trata "+this.getAttribute('class'));
    if (this.getAttribute('class')=="caja amarillo")
         this.style.background='chartreuse';
    else if (this.getAttribute('class')=="caja naranja")
            this.style.background='orangered';
        else
            this.style.background='blueviolet';
}

//Añadir cajas antes de una posicion determinada
function anadirAntes(){
    let cajasCreadas=document.getElementsByClassName('caja');
    let cuadroAntes=document.getElementById('numeroAnterior');
    let posicion=document.getElementById('numeroAnterior').value;
    
    if ((posicion=="") || (posicion > cajasCreadas.length-1)){
        alert (`Error, debe introducir un valor válido mayor que 0 y menor que ${cajasCreadas.length}`);
        //Poner el foco en el cuadro de texto

        cuadroAntes.focus();
        cuadroAntes.value="";
    }else{
        //Obtener el padre de las cajas
        let padre=cajasCreadas[0].parentNode;

        //Crear la nueva caja
        let nuevacaja=document.createElement("div");
        
        //Asignar estilos a la caja
        nuevacaja.setAttribute('class', 'caja amarillo');
        //Poner las cajas a la escucha del evento mouse
        nuevacaja.addEventListener('mouseenter',cambiarColor);

        nuevacaja.addEventListener('mouseleave',volverColor);

        padre.insertBefore(nuevacaja,cajasCreadas[posicion]);

        //Volver a numerar las cajas 
        for ( let i=posicion-1; i<cajasCreadas.length;i++){

            //Asignar un id a la caja
            cajasCreadas[i].setAttribute('id', i);
            cajasCreadas[i].innerHTML=`<h1>${i}</h1>`;
        }

    }
       
   


}

/* Javascript no proporciona una funcion para insertar despues de una posicion dada, así que la vamos a implementar.
Para ello creamos la función insertAfter, la cual recibe como argumento la caja que se encuentra en la posicion sobre la que
queremos insertar en este caso es cajaIndice y la nuevaCaja. 
Para ello necesitamos el métodos nextSibling devuelve el siguiente nodo hermano. */
const insertAfter=(cajaIndice,nuevaCaja)=>{ 
    if(cajaIndice.nextSibling){ 

        /* Si tenemos un nuevo nodo a continuación, añadimos la nueva caja antes del nodo hermano */
        /* El método Node.insertBefore() inserta un nodo antes del nodo de referencia como hijo de un nodo padre indicado. 
        Si el nodo hijo es una referencia a un nodo ya existente en el documento, insertBefore() lo mueve de la posición actual a la nueva posición 
        (no hay necesidad de eliminar el nodo de su nodo padre antes de agregarlo al algún nodo nuevo). 
        La sintaxis es parentElement.insertBefore.(newElement,targetElement), es decir añadir el newElement antes del nodo de referencia que es targetElement*/

        cajaIndice.parentNode.insertBefore(nuevaCaja,cajaIndice.nextSibling); 
    } else { 
         /* En caso contrario, nos está indicando que estamos en la última caja, por lo que con el nodo appendChild añadimos un nuevo 
         nodo al final del arbol*/
        cajaIndice.parentNode.appendChild(nuevaCaja); 
    }
    /* En ambos casos necesitamos acceder a través del nodo padre */
}

//Añadir cajas despues de una posicion determinada
const anadirDespues=()=>{
    let cajasCreadas=document.getElementsByClassName('caja');
    let cuadroDespues=document.getElementById('numeroPosterior');

    let posicion=document.getElementById('numeroPosterior').value;
    console.log("La posicion es "+posicion);
   

    if ((posicion=="") || (posicion > cajasCreadas.length)){
        alert (`Error, debe introducir un valor válido, menor que ${cajasCreadas.length} y mayor que 0`);
        //Poner el foco en el cuadro de texto

        cuadroDespues.focus();
        cuadroDespues.value="";
    }else{
            //Obtener el padre de las cajas
            let padre=cajasCreadas[0].parentNode;

            //Crear la nueva caja
            let nuevacaja=document.createElement("div");
            
            //Asignar estilos a la caja
            nuevacaja.setAttribute('class', 'caja naranja');
            //Poner las cajas a la escucha del evento mouse

            nuevacaja.addEventListener('mouseenter',cambiarColor);

            nuevacaja.addEventListener('mouseleave',volverColor);
        
        
            insertAfter(cajasCreadas[posicion],nuevacaja);

            //Volver a numerar las cajas 
            for ( let i=posicion; i<cajasCreadas.length;i++){

                //Asignar un id a la caja
                cajasCreadas[i].setAttribute('id', i);
                cajasCreadas[i].innerHTML=`<h1>${i}</h1>`;
                
                
            }
        }
}
/* Método para crear las cajas. He modificado el archivo html para que muestre por defecto un 1 y así cuando el usuario pulsa el botón Crear
ya tenemos como mínimo una caja. En caso contrario deberíamos validar que el usuario introduzca un valor en el cuadro de texto */
const crearCajas=()=>{
    //Pasos para crear elementos de la estructura DOM
    //Numero de cajas que queremos crear
    let numero=document.getElementById('cantidad').value;
    console.log(numero);

    //Bucle para solicitar numero

    let numeroDeCajas= document.querySelectorAll(".caja").length;
    console.log(numeroDeCajas);

    for ( let i=numeroDeCajas; i<numero;i++){

        let caja=document.createElement("div");
        console.log(caja);
        caja.setAttribute('id', i);

        caja.innerHTML=`<h1>${i}</h1>`;

        //Asignar estilos a la caja
        caja.setAttribute('class', 'caja');

        //Poner las cajas a la escucha del evento mouse
        caja.addEventListener('mouseenter',cambiarColor);

        caja.addEventListener('mouseleave',volverColor);

        //Añadir las cajas al documento
        let seccion=document.getElementById("seccion");
        seccion.append(caja);
    }
    

}
