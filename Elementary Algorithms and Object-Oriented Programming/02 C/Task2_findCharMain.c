/*
	Übung 2, Aufgabe 2: Grobanalyse
	Student: Matthias Meier, Gruppe 1
	Datum: 23.03.2021
*/

#include <stdio.h>
#include <stdlib.h>
#include "findCharFunc.h"

int main(int argc, char* argv[]) {
	/* TESTFALL 1: Normaler Satz */
	char* string = "Ein einfacher Testsatz";
	char ch = 'e';
	printf("Satz: %s, Zeichen: %c\n", string, ch);

	int posLeft = findCharLeft(string, ch);
	printf("posLeft = %d\n", posLeft);

	int posRight = findCharRight(string, ch);
	printf("posRight = %d\n", posRight);

	int posRandom = findCharRandom(string, ch);
	printf("posRandom = %d\n\n", posRandom);


	/* TESTFALL 2: Zeichen kommt nur einmal vor */
	char* string2 = "Ein infacher Tststz";
	char ch2 = 'e';
	printf("Satz: %s, Zeichen: %c\n", string2, ch2);

	int posLeft2 = findCharLeft(string2, ch2);
	printf("posLeft = %d\n", posLeft2);

	int posRight2 = findCharRight(string2, ch2);
	printf("posRight = %d\n", posRight2);

	int posRandom2 = findCharRandom(string2, ch2);
	printf("posRandom = %d\n\n", posRandom2);


	/* TESTFALL 3: Zeichen kommt gar nicht vor */
	char* string3 = "Ein infachr Tstsatz";
	char ch3 = 'e';
	printf("Satz: %s, Zeichen: %c\n", string3, ch3);

	int posLeft3 = findCharLeft(string3, ch3);
	printf("posLeft = %d\n", posLeft3);

	int posRight3 = findCharRight(string3, ch3);
	printf("posRight = %d\n", posRight3);

	int posRandom3 = findCharRandom(string3, ch3);
	printf("posRandom = %d\n\n", posRandom3);

	return 0;
}