Algoritmo Calculadora
    Definir num1, num2 Como Real;
    Definir operacion Como Caracter;
    Definir continuar Como Logico;
	continuar <- Verdadero;
	
	Mientras continuar Hacer
		Escribir "Ingrese el primer número: ";
		Leer num1;
		Escribir "Ingrese el segundo número: ";
		Leer num2;
		Escribir "Ingrese la operación (+, -, *, /): ";
		Leer operacion;
		
		Segun operacion Hacer
			Caso "+":
				Escribir "El resultado es: ", num1 + num2;
			Caso "-":
				Escribir "El resultado es: ", num1 - num2;
			Caso "*":
				Escribir "El resultado es: ", num1 * num2;
			Caso "/":
				Si num2 <> 0 Entonces
					Escribir "El resultado es: ", num1 / num2;
				Sino
					Escribir "Error: División por cero.";
				FinSi;
				De Otro Modo:
					Escribir "Operación no válida.";
			FinSegun;
			
			Escribir "¿Desea realizar otra operación? (S/N):";
			Leer operacion;
			Si Mayusculas(operacion) <> "S" Entonces
				continuar <- Falso;
			FinSi
		FinMientras
	
FinAlgoritmo
