Algoritmo SustituirYConcatenar
	Definir numerosConcatenados Como Cadena
	Escribir 'Ingrese el primer n�mero (m�ximo 5 d�gitos):'
	Leer numero1
	Escribir 'Ingrese el segundo n�mero (m�ximo 5 d�gitos):'
	Leer numero2
	SI (Longitud(numero1) <= 5) Y (Longitud(numero2) <= 5) Entonces
		numerosConcatenados <- Concatenar(numero1,numero2)
		reemplazar8Por0(numerosConcatenados)
	SiNo
		Escribir "Debe ingresar dos n�meros con 5 d�gitos como m�ximo"
	FinSi
FinAlgoritmo

Funci�n reemplazar8Por0(numero)
	resultado <- ''
	Para i<-1 Hasta Longitud(numero) Hacer
		Si Subcadena(numero,i,i)='8' Entonces
			resultado <- resultado+'0'
		SiNo
			resultado <- resultado+Subcadena(numero,i,i)
		FinSi
	FinPara
	Escribir resultado
FinFunci�n
