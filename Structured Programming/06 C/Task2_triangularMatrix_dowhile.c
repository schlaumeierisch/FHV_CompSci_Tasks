/*
	Übung 6, Aufgabe 2: Dreiecksmatrix
	Student: Matthias Meier, Gruppe 1
	Datum: 04.12.2020
*/

#include <stdio.h>

int main() {

	int i = 1;
	int n = 30;

	int counter = 0;
	int rowLength = 1;

	printf("n = %d\n", n);

	do {
		do {
			printf("%d\t", i);
			counter = counter + 1;
			i = i + 2;
		} while ((counter < rowLength) && (i < n));
		printf("\n");
		counter = 0;
		rowLength = rowLength + 1;

	} while ((i >= 0) && (i < n));

	return 0;
}