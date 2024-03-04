/*
	Übung 6, Aufgabe 3: Zinsrechnung
	Student: Matthias Meier, Gruppe 1
	Datum: 04.12.2020
*/

#include <stdio.h>

int main() {
	float capital = 1000;			// Grundkapital
	int term = 10;					// Laufzeit in Jahre
	float interestRate = 5;			// Zinssatz in %

	printf("Kapitalentwicklung f\x81r Grundkapital: %.2f EUR\n", capital);
	printf("Fixzinssatz: %.2f %%, Laufzeit %d Jahre\n\n", interestRate, term);
	printf("Jahr\tKapital\n");
	printf("--------------------\n");

	int counter = 1;
	float interestIncome = 0;		// Zinsertrag

	while (counter <= term) {
		interestIncome = capital * (interestRate / 100);
		capital = capital + interestIncome;
		printf("%d\t%.2f EUR\n", counter, capital);

		counter = counter + 1;
	}
	
	return 0;
}