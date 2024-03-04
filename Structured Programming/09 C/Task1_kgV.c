/*
	Übung 9, Aufgabe 1: Kleinstes gemeinsames Vielfaches
	Student: Matthias Meier, Gruppe 1
	Datum: 16.01.2020
*/

#include <stdio.h>

void swap(int a, int b) {
	int temp = b;
	b = a;
	a = temp;
}

int get_ggT(int a, int b) {
	int ggT = 0;

	if (a != b) {			// sicherstellen, dass nicht durch die größere Zahl dividiert wird
		if (b > a) {
			swap(a, b);
		}

		ggT = b;

		while (a % b != 0) {
			ggT = a % b;
			a = b;
			b = ggT;
		}
	}
	else {
		ggT = a;
	}

	return ggT;
}

int get_kgV(int a, int b) {
	int kgV = 0;

	if ((a * b) != 0) {
		kgV = (a * b) / get_ggT(a, b);
	}
	else {
		printf("Keine der beiden Zahlen darf den Wert 0 haben!\n");
	}
	return kgV;
}

int main() {
	// Test 1:
	int number1 = 18;
	int number2 = 16;
	int kgV = get_kgV(number1, number2);
	printf("kgV(%d, %d) = %d\n\n", number1, number2, kgV);

	// Test 2: Primzahlen
	number1 = 67;
	number2 = 89;
	kgV = get_kgV(number1, number2);
	printf("kgV(%d, %d) = %d\n\n", number1, number2, kgV);

	// Test 2: Negative Zahlen
	number1 = -5;
	number2 = -20;
	kgV = get_kgV(number1, number2);
	printf("kgV(%d, %d) = %d\n\n", number1, number2, kgV);

	// Test 3: Eine Zahl hat den Wert 0
	number1 = 77;
	number2 = 0;
	kgV = get_kgV(number1, number2);
	printf("kgV(%d, %d) = %d\n\n", number1, number2, kgV);

	// Test 4: Große Zahlen
	number1 = 10564;
	number2 = 11397;
	kgV = get_kgV(number1, number2);
	printf("kgV(%d, %d) = %d\n\n", number1, number2, kgV);

	// Test 5: Große Primzahlen
	number1 = 9817;
	number2 = 11887;
	kgV = get_kgV(number1, number2);
	printf("kgV(%d, %d) = %d\n\n", number1, number2, kgV);

	return 0;
}