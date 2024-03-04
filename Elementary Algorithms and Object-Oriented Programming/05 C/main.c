/*
	Übung 5, Aufgabe 1: Bibliothek zum Arbeiten mit einfach-verketteten Listen
	Student: Matthias Meier, Gruppe 1
	Datum: 20.04.2021
*/

#include <stdio.h>
#include <stdlib.h>
#include "linkedListFunc.h"

Node_t* createNode(value_t value) {
	Node_t* pHead = malloc(sizeof(Node_t));
	if (pHead != NULL) {
		pHead->value = value;
		pHead->pNext = NULL;
		return pHead;
	}

	printf("Error: Node creation failed!\n");
	return NULL;
}

int main(int argc, char* argv[]) {
	/* createNode */
	Node_t* pHead1 = createNode(0);
	Node_t** ppHead1 = &pHead1;

	Node_t* pHead2 = createNode(1);
	Node_t** ppHead2 = &pHead2;

	Node_t* pHead3 = createNode(10);
	Node_t** ppHead3 = &pHead3;

	Node_t* pHead4 = createNode(-10);
	Node_t** ppHead4 = &pHead4;

	/* insertFront */
	{
		insertFront(ppHead1, 1);
		insertFront(ppHead1, 2);
		insertFront(ppHead1, 3);

		insertFront(ppHead2, 10);
		insertFront(ppHead2, 1000);
		insertFront(ppHead2, 10000);

		insertFront(ppHead3, 30);
		insertFront(ppHead3, 20);
		insertFront(ppHead3, 50);
		insertFront(ppHead3, 20);
		insertFront(ppHead3, 40);

		insertFront(ppHead4, -5);
		insertFront(ppHead4, 5);
		insertFront(ppHead4, -10);
		insertFront(ppHead4, 10);
	}

	/* insertBefore */
	{
		insertBefore(ppHead1, pHead1->pNext, 10);
		insertBefore(ppHead2, pHead2->pNext->pNext, 100);
		insertBefore(ppHead3, pHead3, 60);
		insertBefore(ppHead4, pHead4->pNext->pNext->pNext->pNext, 10);
	}

	/* printList after insertFront and insertBefore */
	{
		printf("\nprintList after insertFront and insertBefore\n");
		printf("--------------------------------------------\n");
		printf("Testlist 1: "); printList(pHead1);
		printf("Testlist 2: "); printList(pHead2);
		printf("Testlist 3: "); printList(pHead3);
		printf("Testlist 4: "); printList(pHead4);
	}

	/* deleteValues */
	{
		printf("\ndeleteValues\n");
		printf("------------\n");
		printf("Testlist 1: "); deleteValues(ppHead1, 10, 0);
		printf("Testlist 2: "); deleteValues(ppHead2, 0, 0);
		printf("Testlist 3: "); deleteValues(ppHead3, 20, 0);
		printf("Testlist 4: "); deleteValues(ppHead4, 10, 1);
	}

	/* printList after deleteValues */
	{
		printf("\nprintList after deleteValues\n");
		printf("----------------------------\n");
		printf("Testlist 1: "); printList(pHead1);
		printf("Testlist 2: "); printList(pHead2);
		printf("Testlist 3: "); printList(pHead3);
		printf("Testlist 4: "); printList(pHead4);
	}
	
	/* inverseList */
	{
		inverseList(ppHead1);
		inverseList(ppHead2);
		inverseList(ppHead3);
		inverseList(ppHead4);
	}

	/* printList after inverseList */
	{
		printf("\nprintList after inverseList\n");
		printf("---------------------------\n");
		printf("Testlist 1: "); printList(pHead1);
		printf("Testlist 2: "); printList(pHead2);
		printf("Testlist 3: "); printList(pHead3);
		printf("Testlist 4: "); printList(pHead4);
	}
	
	/* sortList */
	{
		sortList(ppHead1);
		sortList(ppHead2);
		sortList(ppHead3);
		sortList(ppHead4);
	}

	/* printList after sortList */
	{
		printf("\nprintList after sortList\n");
		printf("------------------------\n");
		printf("Testlist 1: "); printList(pHead1);
		printf("Testlist 2: "); printList(pHead2);
		printf("Testlist 3: "); printList(pHead3);
		printf("Testlist 4: "); printList(pHead4);
	}

	/* deleteList */
	{
		deleteList(ppHead1);
		deleteList(ppHead2);
		deleteList(ppHead3);
		deleteList(ppHead4);
	}

	/* printList after deleteList */
	{
		printf("\nprintList after deleteList\n");
		printf("--------------------------\n");
		printf("Testlist 1: "); printList(pHead1);
		printf("Testlist 2: "); printList(pHead2);
		printf("Testlist 3: "); printList(pHead3);
		printf("Testlist 4: "); printList(pHead4);
	}


	return 0;
}