/*
	Übung 9, Aufgabe 2: Modularisierung
	Student: Matthias Meier, Gruppe 1
	Datum: 20.01.2020
*/

#include <stdio.h>
#include "stringfunc.h"

int main() {
/* -string_len testen---------------------------------------------------- */
	printf("*** string_len testen ***\n");
	char word1[] = "Hallo";
	char word2[] = "X";
	char word3[] = "";

	int wordLength1 = string_len(word1);
	printf("L\x84nge von %s = %d\n", word1, wordLength1);
	int wordLength2 = string_len(word2);
	printf("L\x84nge von %s = %d\n", word2, wordLength2);
	int wordLength3 = string_len(word3);
	printf("L\x84nge von %s = %d\n\n", word3, wordLength3);
/* ---------------------------------------------------------------------- */


/* -string_cmp testen---------------------------------------------------- */
	printf("*** string_cmp testen ***\n");
	char name1[] = "Alfred";
	char name2[] = "Alfreda";
	
	int stringComparing1 = string_cmp(name1, name2);
	if (stringComparing1 == 0) {
		printf("Vergleich: %d,\t %s = %s\n", stringComparing1, name1, name2);
	} else if (stringComparing1 == 1) {
		printf("Vergleich: %d,\t %s > %s\n", stringComparing1, name1, name2);
	} else if (stringComparing1 == -1) {
		printf("Vergleich: %d,\t %s < %s\n", stringComparing1, name1, name2);
	}

	char name3[] = "A";
	char name4[] = "B";

	int stringComparing2 = string_cmp(name3, name4);
	if (stringComparing2 == 0) {
		printf("Vergleich: %d,\t %s = %s\n", stringComparing2, name3, name4);
	}
	else if (stringComparing2 == 1) {
		printf("Vergleich: %d,\t %s > %s\n", stringComparing2, name3, name4);
	}
	else if (stringComparing2 == -1) {
		printf("Vergleich: %d,\t %s < %s\n", stringComparing2, name3, name4);
	}

	char name5[] = "Matttias";
	char name6[] = "Matthias";

	int stringComparing3 = string_cmp(name5, name6);
	if (stringComparing3 == 0) {
		printf("Vergleich: %d,\t %s = %s\n\n", stringComparing3, name5, name6);
	}
	else if (stringComparing3 == 1) {
		printf("Vergleich: %d,\t %s > %s\n\n", stringComparing3, name5, name6);
	}
	else if (stringComparing3 == -1) {
		printf("Vergleich: %d,\t %s < %s\n\n", stringComparing3, name5, name6);
	}
/* ---------------------------------------------------------------------- */


/* -string_toUpperCase testen-------------------------------------------- */
	printf("*** string_toUpperCase testen ***\n");
	char string1[] = "kleingeschrieben";
	char string2[] = "tEsTwoRt";
	char string3[] = "z4hl3n";

	string_toUpperCase(string1);
	printf("%s\n", string1);
	string_toUpperCase(string2);
	printf("%s\n", string2);
	string_toUpperCase(string3);
	printf("%s\n\n", string3);
/* ---------------------------------------------------------------------- */


/* -string_copy testen--------------------------------------------------- */
	printf("*** string_copy testen ***\n");
	char string4[30] = "Mein Name ist ";					// genug Platz reservieren!
	char string5[] = "Matthias Meier";
	
	string_copy(string4, string5);
	printf("%s\n", string4);

	char string6[30] = "5 + 7 = ";							// genug Platz reservieren!
	char string7[] = "12";

	string_copy(string6, string7);
	printf("%s\n", string6);

	char string8[70] = "Heute ist ein sch\x94ner Tag, ";	// genug Platz reservieren!
	char string9[] = "gestern war ein beschi**ener Tag.";

	string_copy(string8, string9);
	printf("%s\n\n", string8);
/* ---------------------------------------------------------------------- */


/* -string_subStr testen------------------------------------------------- */
	printf("*** string_subStr testen ***\n");
	char string10[50] = "Harry Potter und ";				// genug Platz reservieren!
	char string11[] = "Ist das der Feuerkelch?";

	int copiedChars1 = string_subStr(string10, string11, 8, 21);
	printf("Kopierte Zeichen: %d\n\n", copiedChars1);

	char string12[50] = "Das glaube ich ";					// zu großes endOffs gewählt
	char string13[] = "dir nicht";

	int copiedChars2 = string_subStr(string12, string13, 2, 10);
	printf("Kopierte Zeichen: %d\n\n", copiedChars2);
	
	char string14[50] = "Nur ein kleiner ";					// startOffs ist größer als endOffs
	char string15[] = "Testfall, OK?";

	int copiedChars3 = string_subStr(string14, string15, 7, 3);
	printf("Kopierte Zeichen: %d\n\n", copiedChars3);
/* ---------------------------------------------------------------------- */


/* -string_revert testen------------------------------------------------- */
	char stringToRvrt1[40] = "Matthias";
	char stringToRvrt2[40] = "einsehrlangesWortzusammengeschrieben";
	char stringToRvrt3[40] = "!321 dlroW olleH";

	string_revert(stringToRvrt1);
	printf("%s\n", stringToRvrt1);

	string_revert(stringToRvrt2);
	printf("%s\n", stringToRvrt2);

	string_revert(stringToRvrt3);
	printf("%s\n", stringToRvrt3);
/* ---------------------------------------------------------------------- */

	return 0;
}