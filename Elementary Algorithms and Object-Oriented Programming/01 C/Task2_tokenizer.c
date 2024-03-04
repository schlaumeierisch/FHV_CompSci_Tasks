/*
	Übung 1, Aufgabe 2: Tokenizer
	Student: Matthias Meier, Gruppe 1
	Datum: 12.03.2021
*/

#include <stdio.h>
#include <stdlib.h>
#include "tokfunc.h"

int main(int argc, char* argv[]) {
	
	/*-------------------- TESTFALL 1 --------------------*/
	char testStr1[] = "Dies ist ein Probetext mit      mehreren Leerzeichen hintereinander";
	int* testStrIndexes1 = NULL;
	char** testStrAddresses1 = NULL;
	
	printf("Test 1: %s", testStr1);

	testStrIndexes1 = tokenizerV1(testStr1, testStrIndexes1);
	printf("\nIndexes: ");
	for (int i = 0; i < countingWords(testStr1); i++) {
		printf("%d ", *(testStrIndexes1 + i));
	}

	testStrAddresses1 = tokenizerV2(testStr1, testStrAddresses1);
	printf("\nAddresses: ");
	for (int i = 0; i < countingWords(testStr1); i++) {
		printf("0x%p ", &(testStrAddresses1[i]));
	}
	/*----------------------------------------------------*/

	/*-------------------- TESTFALL 2 --------------------*/
	char testStr2[] = "Ein Satz, der kurz ist, aber dennoch Beistriche beinhaltet. Und zwei Punkte.";
	int* testStrIndexes2 = NULL;
	char** testStrAddresses2 = NULL;

	printf("\n\nTest 2: %s", testStr2);

	testStrIndexes2 = tokenizerV1(testStr2, testStrIndexes2);
	printf("\nIndexes: ");
	for (int i = 0; i < countingWords(testStr2); i++) {
		printf("%d ", *(testStrIndexes2 + i));
	}

	testStrAddresses2 = tokenizerV2(testStr2, testStrAddresses2);
	printf("\nAddresses: ");
	for (int i = 0; i < countingWords(testStr2); i++) {
		printf("0x%p ", &(testStrAddresses2[i]));
	}
	/*----------------------------------------------------*/

	/*-------------------- TESTFALL 2 --------------------*/
	char testStr3[] = "Ein Ausrufesatz - mit einer eingeklammerten Notiz (dies ist eine Notiz)!";
	int* testStrIndexes3 = NULL;
	char** testStrAddresses3 = NULL;

	printf("\n\nTest 2: %s", testStr3);

	testStrIndexes3 = tokenizerV1(testStr3, testStrIndexes3);
	printf("\nIndexes: ");
	for (int i = 0; i < countingWords(testStr3); i++) {
		printf("%d ", *(testStrIndexes3 + i));
	}

	testStrAddresses3 = tokenizerV2(testStr3, testStrAddresses3);
	printf("\nAddresses: ");
	for (int i = 0; i < countingWords(testStr3); i++) {
		printf("0x%p ", &(testStrAddresses3[i]));
	}
	/*----------------------------------------------------*/

	free(testStrAddresses1);
	free(testStrAddresses2);
	free(testStrAddresses3);

	free(testStrIndexes1);
	free(testStrIndexes2);
	free(testStrIndexes3);

	return 0;
}