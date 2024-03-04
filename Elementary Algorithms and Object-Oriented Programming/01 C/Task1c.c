/*
	Übung 1, Aufgabe 1c: Grafik implementieren
	Student: Matthias Meier, Gruppe 1
	Datum: 12.03.2021
*/

#include <stdio.h>

int main(int argc, char* argv[]) {

	/* SCHRITT 1 */
	int i = 1234;
	int k = 5678;
	printf("#1: i = %d, k = %d\n", i, k);

	/* SCHRITT 2 */
	int* pI = &i;
	printf("#2: pI = %d\n", *pI);

	/* SCHRITT 3 */
	*pI = 2323;
	printf("#3: pI = %d\n", *pI);

	/* SCHRITT 4 */
	(*pI)++;
	printf("#4: pI = %d\n", *pI);

	/* SCHRITT 5 */
	pI = &k;
	printf("#5: pI = %d, i = %d, k = %d", *pI, i, k);


	return 0;
}