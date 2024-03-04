/*
	Übung 8, Aufgabe 1: Primfaktorenzerlegung
	Student: Matthias Meier, Gruppe 1
	Datum: 08.01.2020
*/

#include <stdio.h>

int primeDetermination(int numberToBeChecked) {
	int isPrime = 1;
	int i = 2;
	
	if (numberToBeChecked == 2) {
		isPrime == 1;
	} else {
		while ((i < numberToBeChecked) && (isPrime == 1)) {
			if ((numberToBeChecked % i) == 0) {
				isPrime = 0;
			} else {
				isPrime = 1;
			}

			i = i + 1;
		}
	}

	return isPrime;
}

int primeFactorisation(int givenNumber) {
	int primeNumber = 2;

	while (givenNumber > 1) {
		if ((primeDetermination(primeNumber) == 1) && ((givenNumber % primeNumber) == 0)) {
			printf("%d\t|\t%d\n", givenNumber, primeNumber);
			givenNumber = givenNumber / primeNumber;
			primeNumber = 2;
		}
		else {
			if (primeNumber == 2) {
				primeNumber = primeNumber + 1;
			}
			else {
				primeNumber = primeNumber + 2;		// alle Zahlen ab 3 mit 2er-Schritten überprüfen (-> schneller)
			}
		}
	}

	printf("%d\t|\n\n\n", givenNumber);

	return 0;
}


int main() {
	// Test Case #1
	printf("--- Test Case #1 ---\n");
	printf("--------------------\n");
	int number1 = 2;
	primeFactorisation(number1);

	// Test Case #2
	printf("--- Test Case #2 ---\n");
	printf("--------------------\n");
	int number2 = 10;
	primeFactorisation(number2);

	// Test Case #3
	printf("--- Test Case #3 ---\n");
	printf("--------------------\n");
	int number3 = 17;
	primeFactorisation(number3);

	// Test Case #4
	printf("--- Test Case #4 ---\n");
	printf("--------------------\n");
	int number4 = 10572;
	primeFactorisation(number4);

	// Test Case #5
	printf("--- Test Case #5 ---\n");
	printf("--------------------\n");
	int number5 = 27793;
	primeFactorisation(number5);


	return 0;
}