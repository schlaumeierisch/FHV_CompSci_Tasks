/*
	Übung 6, Aufgabe 1: Darstellungsformen von Binären Bäumen
	Student: Matthias Meier, Gruppe 1
	Datum: 04.05.2021
*/

#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include "binarySearchTree.h"

int main(int argc, char* argv[]) {
	int nrOfValues = 10;
	int maxValue = 100;

	Node_t* pBinarySearchTree = createBinarySearchTree(nrOfValues, maxValue);
	printf("#printInOrder: "); printInOrder(pBinarySearchTree); printf("\n");

	int newValue = 10;
	pBinarySearchTree = insertValue(pBinarySearchTree, newValue);
	printf("#insertValue(%d)\n", newValue);
	printf("#printInOrder: "); printInOrder(pBinarySearchTree); printf("\n");

	Node_t* pSuccNode = getSuccessor(pBinarySearchTree, newValue);
	printf("#getSuccessor(%d): %d\n", newValue, pSuccNode->value);

	printf("#printInOrder: "); printInOrder(pBinarySearchTree); printf("\n");
	Node_t* pPreNode = getPredecessor(pBinarySearchTree, 50);
	printf("#getPredecessor(%d): %d\n", newValue, pPreNode->value);
	

	return 0;
}