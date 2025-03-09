
let numero = 0;
let numeroI = 0;

let cont = 0;

/*Para obtener el número de cifras de número en base 10 (base decimal)
se puede obtener haciendo divisiones sucesivas entre 10 y quedar con
la parte entera */

numero = (prompt("Introduce un numero entero", 0));
if (numero == null)
    alert("Ha pulsado cancelar");
else {
    numero = parseInt(numero);
    if (isNaN(numero)|| numero <=0)
        alert("Valor incorrecto");
    else {
        document.write("<h2>CALCULAR EL NUMERO DE CIFRAS DE UN NUMERO </h2>" + "<BR>");
        numeroI = numero;

        do {
            numero = numero / 10;
            numero = Math.floor(numero);
            cont++;

        } while (numero > 0);
        document.write(`<p>El numero ${numeroI} tiene ${cont} cifras </p>`);
    }
}
