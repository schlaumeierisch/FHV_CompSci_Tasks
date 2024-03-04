/*
	Übung 7, Aufgabe 6: Näherungsweise Berechnung der Quadratwurzel
	Student: Matthias Meier, Gruppe 1
	Datum: 14.12.2020
*/

#include <stdio.h>

double calculateSquareRoot(int x, double eps) {
	double y = (double)x / 2;
	double temp = 0;

	while (((y - temp) <= ((-1) * eps)) || ((y - temp) >= eps)) {	// solange Differenz kleiner gleich -0.001 bzw. größer gleich 0.001
		temp = y;
		y = 0.5 * (temp + (x / temp));
	}

	return y;
}


int main() {
	int x = 4;
	double eps = 0.001;												// Genauigkeit/Toleranz
	
	double y = calculateSquareRoot(x, eps);
	printf("Die Quadratwurzel von %d ist %f\n", x, y);

	return 0;
}