/*
	Übung 6, Aufgabe 2: Dreiecksmatrix
	Student: Matthias Meier, Gruppe 1
	Datum: 04.12.2020
*/

#include <stdio.h>

int main() {

	int i = 1;
	int n = 100;

	int counter = 0;
	int rowLength = 1;

	printf("n = %d\n", n);

	while ((i >= 0) && (i < n)) {
		while ((counter < rowLength) && (i < n)) {
			printf("%d\t", i);
			counter = counter + 1;
			i = i + 2;
		}

		printf("\n");
		counter = 0;
		rowLength = rowLength + 1;
	}

	return 0;
}