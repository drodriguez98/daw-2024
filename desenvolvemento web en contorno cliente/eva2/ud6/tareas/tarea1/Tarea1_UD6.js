document.addEventListener("DOMContentLoaded", function () {
    // Referencias a los elementos del formulario
    const filasInput = document.getElementById("fila");
    const columnasInput = document.getElementById("columna");
    const crearTablaBtn = document.getElementById("crear");
    const resultadoDiv = document.getElementById("resultado");
  
    // Función para crear la tabla
    function crearTabla() {
      // Limpiar el contenido previo
      resultadoDiv.innerHTML = "";
  
      const numFilas = parseInt(filasInput.value);
      const numColumnas = parseInt(columnasInput.value);
  
      // Validar entradas
      if (isNaN(numFilas) || isNaN(numColumnas) || numFilas <= 0 || numColumnas <= 0) {
        alert("Por favor, introduce valores positivos para filas y columnas.");
        return;
      }
  
      // Crear la tabla
      const tabla = document.createElement("table");
  
      // Aplicar estilos a la tabla
      tabla.style.border = "2px solid blue";
      tabla.style.borderCollapse = "collapse";
      tabla.style.marginTop = "20px";
      tabla.style.fontSize = "16px";
      tabla.style.color = "darkblue";
  
      for (let i = 0; i < numFilas; i++) {
        const fila = document.createElement("tr");
  
        for (let j = 0; j < numColumnas; j++) {
          const celda = document.createElement("td");
          celda.textContent = `${i + 1}`;
  
          // Aplicar estilos a las celdas
          celda.style.border = "1px solid blue";
          celda.style.padding = "8px";
          celda.style.textAlign = "center";
  
          fila.appendChild(celda);
        }
  
        // Evento para borrar una fila al hacer doble clic
        fila.addEventListener("dblclick", function () {
          fila.remove();
        });
  
        // Evento para cambiar el color de fondo de las celdas al hacer clic en la fila
        fila.addEventListener("click", function () {
          const celdas = fila.querySelectorAll("td");
          celdas.forEach(celda => {
            celda.style.backgroundColor = celda.style.backgroundColor === "lightblue" ? "" : "lightblue";
          });
        });
  
        // Evento para cambiar el color del texto al hacer clic derecho en la fila
        fila.addEventListener("contextmenu", function (event) {
          event.preventDefault(); // Prevenir el menú contextual por defecto
          const celdas = fila.querySelectorAll("td");
          celdas.forEach(celda => {
            celda.style.color = celda.style.color === "red" ? "" : "red";
          });
        });
  
        tabla.appendChild(fila);
      }
  
      resultadoDiv.appendChild(tabla);
  
      // Bloquear el botón de crear tabla
      crearTablaBtn.disabled = true;
  
      // Crear botón para borrar la tabla
      const borrarTablaBtn = document.createElement("button");
      borrarTablaBtn.textContent = "Borrar tabla";
      borrarTablaBtn.id = "borrarTabla"; // Asignar id al botón
      borrarTablaBtn.style.marginLeft = "10px";
  
      // Añadir evento para borrar la tabla
      borrarTablaBtn.addEventListener("click", function () {
        resultadoDiv.innerHTML = "";
        crearTablaBtn.disabled = false;
        filasInput.value = ""; // Limpiar el campo de filas
        columnasInput.value = ""; // Limpiar el campo de columnas
        filasInput.focus(); // Enfocar el cuadro de texto de filas
        borrarTablaBtn.remove();
      });
  
      // Insertar el botón de borrar después del botón de crear
      crearTablaBtn.parentNode.appendChild(borrarTablaBtn);
    }
  
    // Asociar el evento al botón
    crearTablaBtn.addEventListener("click", crearTabla);
  });
  