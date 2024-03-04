/*
	Übung 4, Aufgabe 2: Pascal'sches Dreieck
	Student: Matthias Meier, Gruppe 1
	Datum: 12.04.2021
*/

#include <stdio.h>

int pascalsFormula(int n, int k) {
	if ((n * k != 0) && (n != k)) {
		return pascalsFormula(n - 1, k - 1) + pascalsFormula(n - 1, k);
	} else {
		return 1;
	}
}

void pascalsTriangle(int numOfExt) {
	int tabs = numOfExt - 1;

	for (int i = 0; i < numOfExt; i++) {
		// bis zur richten Stelle einrücken
		for (int iTabs = 0; iTabs < tabs; iTabs++) {
			printf("\t");
		}

		for (int j = 0; j <= i; j++) {
			printf("%d\t\t", pascalsFormula(i, j));
		}
		printf("\n");
		tabs--;
	}
}

int main(int argc, char* argv[]) {
	int numOfExt1 = 3;
	printf("Testfall 1: %d Erweiterungen\n", numOfExt1);
	pascalsTriangle(numOfExt1);

	int numOfExt2 = 1;
	printf("\nTestfall 2: %d Erweiterungen\n", numOfExt2);
	pascalsTriangle(numOfExt2);

	int numOfExt3 = 0;
	printf("\nTestfall 3: %d Erweiterungen\n", numOfExt3);
	pascalsTriangle(numOfExt3);

	int numOfExt4 = 10;
	printf("\nTestfall 4: %d Erweiterungen\n", numOfExt4);
	pascalsTriangle(numOfExt4);


	return 0;
}