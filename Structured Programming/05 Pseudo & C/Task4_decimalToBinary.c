/*
	Übung 5, Aufgabe 4: Umwandlung einer Dezimalzahl in eine Binärzahl
	Student: Matthias Meier, Gruppe 1
	Datum: 25.11.2020
*/

#include <stdio.h>

int decimalToBinary() {
	
	int decimalValue = 0;
	int binaryValues[8] = { 128, 64, 32, 16, 8, 4, 2, 1 };
	int i = 0;

	if ((decimalValue > 0) && (decimalValue < 256)) {
		printf("Der binaere Wert von %d lautet:\n", decimalValue);

		while (i < 8) {
			if ((decimalValue - binaryValues[i]) >= 0) {
				decimalValue = decimalValue - binaryValues[i];

				printf("1");
			}
			else {
				printf("0");
			}

			i = i + 1;
		}
	}
	else {
		printf("Der Dezimalwert muss groesser als 0 und kleiner als 256 sein.");
	}

	return 0;
}