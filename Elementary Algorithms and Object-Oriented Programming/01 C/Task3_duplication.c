/*
	Übung 1, Aufgabe 3: Zeichenkette kopieren mit dynamischem Speicher
	Student: Matthias Meier, Gruppe 1
	Datum: 12.03.2021
*/

#include <stdio.h>
#include <stdlib.h>

int strLen(char* str) {
	int len = 0;

	while (str[len] != '\0') {
		len++;
	}

	return len;
}


char* strDuplicate(const char* pSrc) {
	char* pNew = (char*) malloc(strLen(pSrc) + 1);

	int i = 0;

	while (pSrc[i] != '\0') {
		pNew[i] = pSrc[i];

		i++;
	}

	pNew[i] = 0;

	return pNew;
}

int main(int argc, char* argv[]) {
	
	/*-------------------- TESTFALL 1 --------------------*/
	char* string1 = "Hallo Welt!";
	char* newString1 = strDuplicate(string1);

	printf("string Adresse: %p, string Inhalt: %s\n", string1, string1);
	printf("newString Adresse: %p, newString Inhalt: %s\n\n", newString1, newString1);
	/*----------------------------------------------------*/

	/*-------------------- TESTFALL 2 --------------------*/
	char* string2 = "Mein Name ist Matthias, ich studiere Informatik.";
	char* newString2 = strDuplicate(string2);

	printf("string Adresse: %p, string Inhalt: %s\n", string2, string2);
	printf("newString Adresse: %p, newString Inhalt: %s\n\n", newString2, newString2);
	/*----------------------------------------------------*/

	/*-------------------- TESTFALL 3 --------------------*/
	char* string3 = "Ein Schweizer gewann 210 Millionen Euro bei Euromillionen";
	char* newString3 = strDuplicate(string3);

	printf("string Adresse: %p, string Inhalt: %s\n", string3, string3);
	printf("newString Adresse: %p, newString Inhalt: %s\n\n", newString3, newString3);
	/*----------------------------------------------------*/

	free(newString1);
	free(newString2);
	free(newString3);

	return 0;
}