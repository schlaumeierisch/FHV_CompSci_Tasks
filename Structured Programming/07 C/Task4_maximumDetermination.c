/*
	Übung 7, Aufgabe 4: Bestimmung des Maximums
	Student: Matthias Meier, Gruppe 1
	Datum: 10.12.2020
*/

#include <stdio.h>
#define valuesLength 5

int maximumDetermination(int values[]) {
	int i = 0;
	int max = values[i];
	
	while (i < valuesLength) {
		if (values[i] > max) {
			max = values[i];
		}

		i = i + 1;
	}

	return max;
}

int main() {
	int values[valuesLength] = { 3, 11, 10, 2, 1 };

	int max = maximumDetermination(values);
	printf("Maximum = %d\n", max);

	return 0;
}