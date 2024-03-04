/*
	Übung 10, Aufgabe 1: Wortlängenstatistik
	Student: Matthias Meier, Gruppe 1
	Datum: 25.01.2020
*/

#include <stdio.h>
#define LONGEST_WORD 20

int stringLength(char str[]) {
	int i = 0;

	while (str[i] != '\0') {
		i = i + 1;
	}

	return i;
}

int countingLetters(char str[], int currentPos) {
	int pos = currentPos;

	if (str[pos] != '\0') {
		if ((str[pos] > 64) && (str[pos] < 123)) {
			while ((str[pos] > 64) && (str[pos] < 123)) {
				pos = pos + 1;
			}
		} else {
			pos = pos + 1;
		}
	} else {
		pos = currentPos;
	}

	return pos;
}

void countingWords(int arr[]) {
	int i = 0;

	while (i < LONGEST_WORD) {
		if (arr[i] > 0) {
			printf("Anzahl der W\x94rter mit der L\x84nge %d: %d\n", i, arr[i]);
		}

		i = i + 1;
	}
}

void textAnalysis(char str[], int arr[]) {
	int textLength = stringLength(str);
	int currentPos = 0;
	int newPos = 0;

	while (currentPos < textLength) {
		newPos = countingLetters(str, currentPos);

		if ((str[newPos - 1] > 64) && (str[newPos - 1] < 123)) {
			arr[newPos - currentPos] = arr[newPos - currentPos] + 1;
		}

		currentPos = newPos;
	}

	countingWords(arr);
}

int main() {
	// Test 1: Kurzer Text
	printf("--- Test 1 ---\n");

	char text1[512] = "Hallo, wie geht es dir denn heute so? Ich hoffe, es geht dir gut.";
	int words1[LONGEST_WORD] = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

	printf("%s\n\n", text1);
	textAnalysis(text1, words1);

	// Test 2: Ein längerer Text (aus der Aufgabenstellung)
	printf("\n\n--- Test 2 ---\n");
	char text2[512] = "Es soll ein C-Programm entwickelt werden, das die Haeufigkeit des Vorkommens von Worten bestimmter Laenge zaehlt. Sowohl der Originaltext als auch das Resultat der Analyse nach aufsteigender Wortlaenge soll am Bildschirm praesentiert werden.";
	int words2[LONGEST_WORD] = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

	printf("%s\n\n", text2);
	textAnalysis(text2, words2);

	// Test 3: Englischer Text, um herauszufinden, ob auch Wörter mit Länge 1 erkannt werden.
	printf("\n\n--- Test 3 ---\n");
	char text3[512] = "A simple English sentence to find out if a word is also found that has only one letter.";
	int words3[LONGEST_WORD] = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

	printf("%s\n\n", text3);
	textAnalysis(text3, words3);


	return 0;
}