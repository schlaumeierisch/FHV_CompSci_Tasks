/*
	Übung 6, Aufgabe 2: Dreiecksmatrix
	Student: Matthias Meier, Gruppe 1
	Datum: 04.12.2020
*/

#include <stdio.h>

int main() {

	int i = 1;
	int n = 50;

	int counter = 0;
	int rowLength = 1;

	printf("n = %d\n", n);

	for (i = 1; i < n;) {
		for (counter = 0; (counter < rowLength && (i < n)); counter++) {
			printf("%d\t", i);
			i = i + 2;
		}
		printf("\n");
		rowLength = rowLength + 1;
	}

	return 0;
}