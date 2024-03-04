/*
	Übung 5, Aufgabe 3: "Russische Bauernmultiplikation"
	Student: Matthias Meier, Gruppe 1
	Datum: 25.11.2020
*/

#include <stdio.h>

int main() {
	int multiplier;
	int multiplicand;
	int result = 0;

	printf("Multiplikator: ");
	scanf("%d", &multiplier);
	printf("Multiplikand: ");
	scanf("%d", &multiplicand);

	int a = multiplier;
	int b = multiplicand;
	// Faktoren zwischenspeichern, relevant für die printf-Funktion am Schluss

	if ((multiplicand != 0) && (multiplier != 0)) {
		while (multiplier > 1) {
			if ((multiplier % 2) != 0) {
				result = result + multiplicand;
			}

			multiplier = multiplier / 2;
			multiplicand = multiplicand * 2;
		}

		result = result + multiplicand;
		printf("%d * %d = %d", a, b, result);
	}
	else {
		printf("Keiner der Faktoren darf den Wert 0 haben!");
	}

	return 0;
}