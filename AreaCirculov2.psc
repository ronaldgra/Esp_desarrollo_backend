Algoritmo AreaCirculo
    Definir radio, area Como Real;
    
    Repetir
        Escribir "Ingrese el radio del c�rculo (debe ser un n�mero positivo):";
        Leer radio;
        Si radio <= 0 Entonces
            Escribir "El radio debe ser un n�mero positivo. Intente nuevamente.";
        FinSi
    Hasta Que radio > 0
    
    area <- Pi * radio * radio;
    Escribir "El �rea del c�rculo es:", area;
FinAlgoritmo