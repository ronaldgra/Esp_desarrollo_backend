Algoritmo Calculadora
    Definir num1, num2 Como Real;
    Definir operacion Como Caracter;
    Definir continuar Como Logico;
	continuar <- Verdadero;
	
	Mientras continuar Hacer
		Escribir "Ingrese el primer n�mero: ";
		Leer num1;
		Escribir "Ingrese el segundo n�mero: ";
		Leer num2;
		Escribir "Ingrese la operaci�n (+, -, *, /): ";
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
					Escribir "Error: Divisi�n por cero.";
				FinSi;
				De Otro Modo:
					Escribir "Operaci�n no v�lida.";
			FinSegun;
			
			Escribir "�Desea realizar otra operaci�n? (S/N):";
			Leer operacion;
			Si Mayusculas(operacion) <> "S" Entonces
				continuar <- Falso;
			FinSi
		FinMientras
	
FinAlgoritmo
