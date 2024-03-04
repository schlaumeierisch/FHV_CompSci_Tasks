/*
	Übung 7, Aufgabe 1, 2 & 3: (Erweiterte) Summenbildung
	Student: Matthias Meier, Gruppe 1
	Datum: 10.12.2020
*/

#include <stdio.h>

#define FALSE 0
#define TRUE (!(FALSE))

// Summenbildung: alle Zahlen zwischen 1 und n addieren
int summation(n) {
	int x = 2;
	int sum = 0;

	while (x < n) {
		sum = sum + x;
		x = x + 1;
	}

	return sum;
}

// Summenbildung - Erweiterung 1: alle geraden Zahlen zwischen 1 und n addieren
int summationAdvanced1(n) {
	int x = 2;
	int sum = 0;

	while (x < n) {
		if ((x % 2) == 0) {
			sum = sum + x;
		}
		x = x + 1;
	}

	return sum;
}

// Summenbildung - Erweiterung 2 : alle Zahlen zwischen m und n addieren
int summationAdvanced2(m, n) {
	int sum = 0;

	while (m <= n) {
		sum = sum + m;
		m = m + 1;
	}

	return sum;
}

int main() {
	int sum = 0;

	sum = summation(100);
	printf("Summenbildung:\nSumme = %d\n\n", sum);

	sum = summationAdvanced1(100);
	printf("Summenbildung - Erweiterung 1:\nSumme = %d\n\n", sum);

	sum = summationAdvanced2(50, 100);
	printf("Summenbildung - Erweiterung 2:\nSumme = %d\n\n", sum);

	return 0;
}