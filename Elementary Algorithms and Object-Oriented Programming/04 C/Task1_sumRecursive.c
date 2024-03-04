/*
	Übung 4, Aufgabe 1: Rekursive Berechnung der Summe
	Student: Matthias Meier, Gruppe 1
	Datum: 12.04.2021
*/

#include <stdio.h>

int sumRecursive(int n) {
	if (n >= 1) {
		n = n + sumRecursive(n - 1);
		return n;
	} else {
		return 0;
	}
}

int main(int argc, char* argv[]) {
	int n1 = 10;
	printf("n = %d, Summe = %d\n\n", n1, sumRecursive(n1));

	int n2 = 1;
	printf("n = %d, Summe = %d\n\n", n2, sumRecursive(n2));

	int n3 = 0;
	printf("n = %d, Summe = %d\n\n", n3, sumRecursive(n3));

	int n4 = -10;
	printf("n = %d, Summe = %d\n\n", n4, sumRecursive(n4));


	return 0;
}