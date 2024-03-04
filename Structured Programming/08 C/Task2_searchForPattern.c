/*
	Übung 8, Aufgabe 2: Suche nach einer Teilzeichenkette
	Student: Matthias Meier, Gruppe 1
	Datum: 08.01.2020
*/

#include <stdio.h>

int stringLengthDetermination(char string[]) {
	int stringLength = 0;

	while (string[stringLength] != '\0') {
		stringLength = stringLength + 1;
	}

	return stringLength;
}


int patternCheck(char string[], char stringPat[], int currentPos) {
	int patternOccurs = 0;
	
	if (string[currentPos] == stringPat[0]) {
		if (string[currentPos + 1] == stringPat[1]) {
			patternOccurs = 1;
		} else {
			patternOccurs = 0;
		}
	} else {
		patternOccurs = 0;
	}

	return patternOccurs;
}


int main() {
	char text[] = "dieses da ist es";
	char pattern[] = "es";
	int textLength = stringLengthDetermination(text);

	int i = 0;

	printf("Positionen sind: ");

	while (i < (textLength - 1)) {
		if (patternCheck(text, pattern, i) == 1) {
			printf("%d ", i);
		} 

		i = i + 1;
	}

	return 0;
}