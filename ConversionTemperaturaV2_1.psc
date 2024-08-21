Algoritmo ConversionTemperatura
    Definir temperatura, resultado Como Real;
    Definir opcion Como Entero;
    Definir continuar Como Caracter;
	
    Repetir
        Escribir "Seleccione la conversión de temperatura:";
        Escribir "1. Celsius a Fahrenheit";
        Escribir "2. Fahrenheit a Celsius";
        Escribir "3. Celsius a Kelvin";
        Escribir "4. Kelvin a Celsius";
        Leer opcion;
		
        Escribir "Ingrese la temperatura a convertir:";
        Leer temperatura;
		
        Segun opcion Hacer
            1:
                resultado <- (temperatura * 9/5) + 32;
                Escribir temperatura, "°C equivale a ", resultado, "°F";
            2:
                resultado <- (temperatura - 32) * 5/9;
                Escribir temperatura, "°F equivale a ", resultado, "°C";
            3:
                resultado <- temperatura + 273.15;
                Escribir temperatura, "°C equivale a ", resultado, "K";
            4:
                resultado <- temperatura - 273.15;
                Escribir temperatura, "K equivale a ", resultado, "°C";
            De Otro Modo:
                Escribir "Opción no válida";
        FinSegun
		
        Escribir "¿Desea realizar otra conversión? (S/N):";
        Leer continuar;
    Hasta Que continuar = "N" O continuar = "n"
	
FinAlgoritmo
