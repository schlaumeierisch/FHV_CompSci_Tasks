/*
	‹bung 6, Aufgabe 4: Arithmetisches Mittel + Ausreiﬂer
	Student: Matthias Meier, Gruppe 1
	Datum: 04.12.2020
*/

#include <stdio.h>
#define valuesLength 8			
// Anzahl der Werte von "values"; wird "values" angepasst, muss ggf. auch valuesLength angepasst werden

int main() {
	int values[valuesLength] = { 0, 0, 0, 0, 0, 0, 0, 0 };
	int i = 0;

	float sumOfValues = 0;
	int minValue = values[0];
	int maxValue = values[0];
	
	while (i < valuesLength) {
		sumOfValues = sumOfValues + values[i];

		if (values[i] > maxValue) {
			maxValue = values[i];
		} 
		if (values[i] < minValue) {
			minValue = values[i];
		}
	
		i = i + 1;
		}

	float arithmeticMean = sumOfValues / valuesLength;

	printf("Arithmetisches Mittel = %.3f\nMinimaler Wert = %d\nMaximaler Wert = %d\n", arithmeticMean, minValue, maxValue);

	return 0;
}