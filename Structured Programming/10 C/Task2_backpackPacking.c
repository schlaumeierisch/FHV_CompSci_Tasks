/*
	�bung 10, Aufgabe 2: Bepacken eines Rucksacks
	Student: Matthias Meier, Gruppe 1
	Datum: 25.01.2020
*/

#include <stdio.h>
#define NR_OF_ITEMS 4			
// Anzahl der Gegenst�nde; wenn dies angepasst wird, muss auch das zweidimensionale Feld angepasst werden (siehe Info unten)
#define NR_OF_COLUMNS 2
#define MAX_ITEM_NAME_LENGTH 20


int determineMostOptimalItem(double matrix[NR_OF_ITEMS][NR_OF_COLUMNS]) {
	int mostOptimalItem = 0;
	int highestValue = 0;
	int i = 0;

	while (i < NR_OF_ITEMS) {
		if (matrix[i][0] > 0) {
			if (matrix[i][1] > highestValue) {
				highestValue = matrix[i][0];
				mostOptimalItem = i;
			}
		}

		i = i + 1;
	}

	return mostOptimalItem;
}


int main() {
	int backpackSize = 10;
	double itemQuantity[NR_OF_ITEMS][NR_OF_COLUMNS] = {{3, 1}, {1, 5}, {40, 0.5}, {100, 0.1}};
	// wenn Gegenst�nde hinzugef�gt werden, m�ssen weiter Klammern eingef�gt werden in dieser Form: {St�ckzahl, Preis}
	// ausserdem muss NR_OF_ITEMS angepasst werden

	char itemNames[NR_OF_ITEMS][MAX_ITEM_NAME_LENGTH] = { "Fuellfeder", "Filzstift", "Radiergummi", "Kreide" };
	// es m�ssen gleichviele Gegenst�nde sein wie in der anderen Matrix; wenn etwas ge�ndert wird, muss es bei beiden geschehen
	// die erste Position "Fuellfeder" steht auch f�r die erste Position in der anderen Matrix {3, 1}
	
	double totalCosts = 0;
	int itemNr = 0;
	int counter = 0;

	while (backpackSize > 0) {
		itemNr = determineMostOptimalItem(itemQuantity);
		while ((itemQuantity[itemNr][0] > 0) && (backpackSize > 0)) {
			totalCosts = totalCosts + itemQuantity[itemNr][1];
			itemQuantity[itemNr][0] = itemQuantity[itemNr][0] - 1;
			backpackSize = backpackSize - 1;
			counter = counter + 1;
		}

		printf("%dx %s, ", counter, itemNames[itemNr]);
		counter = 0;
	}

	printf("Gesamtsumme: %.2f EUR\n", totalCosts);

	return 0;
}