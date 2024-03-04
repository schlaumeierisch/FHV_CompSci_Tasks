/*
	Übung 3, Aufgabe 1: Dreiecksmatrix
	Student: Matthias Meier, Gruppe 1
	Datum: 29.03.2021
*/

#include <stdio.h>
#include <stdlib.h>
#include "triangularMatrixFunc.h"

int main(int argc, char* argv[]) {
	/* TESTFALL 1 */
	printf("Testfall 1:\n");
	int n1 = 100;
	int** testMatrix1 = getTriangularMatrix(n1);
	fillAndPrint(testMatrix1, n1);
	free(testMatrix1);

	/* TESTFALL 2 */
	printf("\nTestfall 2:\n");
	int n2 = 13;
	int** testMatrix2 = getTriangularMatrix(n2);
	fillAndPrint(testMatrix2, n2);
	free(testMatrix2);

	/* TESTFALL 3 */
	printf("\nTestfall 3:\n");
	int n3 = 1;
	int** testMatrix3 = getTriangularMatrix(n3);
	fillAndPrint(testMatrix3, n3);
	free(testMatrix3);

	return 0;
}