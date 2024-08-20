Proceso PromedioNumeros
    Definir i Como Entero;
    Definir numero, suma, promedio Como Real;
    suma = 0;
	
    Para i = 1 Hasta 5 Con Paso 1 Hacer
        Repetir
            Escribir "Ingrese el número ", i, " (debe estar entre 0 y 10): ";
            Leer numero;
            Si numero < 0 O numero > 10 Entonces
                Escribir "Error: El número debe estar entre 0 y 10.";
            FinSi;
        Hasta Que numero >= 0 Y numero <= 10;
		
        suma = suma + numero;
    FinPara;
    
    promedio = suma / 5;
    Escribir "El promedio de los 5 números es: ", promedio;
FinProceso
