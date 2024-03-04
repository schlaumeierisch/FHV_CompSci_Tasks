/*
	Übung 7, Aufgabe 5: Reihenentwicklung der Exponentialfunktion
	Student: Matthias Meier, Gruppe 1
	Datum: 14.12.2020
*/

#include <stdio.h>

double calculateExponentialValue(int base, int exp) {
	int exponentialValue = base;
	int i = 1;

	if (exp > 1) {
		while (i < exp) {
			exponentialValue = exponentialValue * base;

			i = i + 1;
		}
	} else if (exp == 1) {
		exponentialValue = base;
	} else if (exp == 0) {
		exponentialValue = 1;
	}

	return exponentialValue;
}

double calculateFaculty(int n) {
	double facultyValue = 1;
	int i = 1;
	
	if (n > 0) {
		while (i <= n) {
			facultyValue = facultyValue * i;
			
			i = i + 1;
		}
	} else if (n == 0) {
		facultyValue = 1;
	}

	return facultyValue;
}


int main() {
	int N = 5;
	double z = 15;

	double numerator = 0;				// Zähler
	double denominator = 0;				// Nenner

	double sum = 0;
	int n = 0;							// Counter
	
	if (N > 0) {
		while (n < N) {
			numerator = calculateExponentialValue(z, n);
			denominator = calculateFaculty(n);

			sum = sum + (numerator / denominator);

			n = n + 1;
		}
	}

	printf("Summe = %.2f\n", sum);

	return 0;
}