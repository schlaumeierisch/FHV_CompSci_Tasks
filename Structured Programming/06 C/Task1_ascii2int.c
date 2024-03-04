/*
	Übung 6, Aufgabe 1: ascii2int
	Student: Matthias Meier, Gruppe 1
	Datum: 03.12.2020
*/

#include <stdio.h>

// Länge muss manuell angepasst werden, wenn die Zeichenkette (Zeile 13) gekürzt/erweitert wird

int main() {
	char string[] = "12A";
	int i = 0;
	
	while (string[i] != '\0') {
		i = i + 1;
	}

	int stringLength = i;

	int validValue = 1;
	int counter = 0;
	i = 0;

	// Überprüfen, ob bzw. an welcher Stelle ein falsches Zeichen (z.B. A) vorkommt
	while ((counter < stringLength) && (validValue == 1)) {
		if ((string[counter] >= 48) && (string[counter] <= 57)) {
			// ASCII Zeichen: 48 = "0", 57 = "9"
			i = stringLength - 1;
			validValue = 1;
		}
		else {
			validValue = 0;
			i = counter - 1;
		}

		counter = counter + 1;
	}

	int multiplier = 1;
	int stringToDec = 0;

	if (i >= 0) {
		while (i >= 0) {
			if (string[i] == '1') {
				stringToDec = stringToDec + (1 * multiplier);
			}
			else if (string[i] == '2') {
				stringToDec = stringToDec + (2 * multiplier);
			}
			else if (string[i] == '3') {
				stringToDec = stringToDec + (3 * multiplier);
			}
			else if (string[i] == '4') {
				stringToDec = stringToDec + (4 * multiplier);
			}
			else if (string[i] == '5') {
				stringToDec = stringToDec + (5 * multiplier);
			}
			else if (string[i] == '6') {
				stringToDec = stringToDec + (6 * multiplier);
			}
			else if (string[i] == '7') {
				stringToDec = stringToDec + (7 * multiplier);
			}
			else if (string[i] == '8') {
				stringToDec = stringToDec + (8 * multiplier);
			}
			else if (string[i] == '9') {
				stringToDec = stringToDec + (9 * multiplier);
			}

			multiplier = multiplier * 10;
			i = i - 1;
		}

	}
	else {
		stringToDec = 0;
	}

	printf("%d", stringToDec);
	return 0;
}