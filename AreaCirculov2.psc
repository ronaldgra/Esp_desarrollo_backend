Algoritmo AreaCirculo
    Definir radio, area Como Real;
    
    Repetir
        Escribir "Ingrese el radio del círculo (debe ser un número positivo):";
        Leer radio;
        Si radio <= 0 Entonces
            Escribir "El radio debe ser un número positivo. Intente nuevamente.";
        FinSi
    Hasta Que radio > 0
    
    area <- Pi * radio * radio;
    Escribir "El área del círculo es:", area;
FinAlgoritmo