/*
	Übung 6, Aufgabe 1: Darstellungsformen von Binären Bäumen
	Student: Matthias Meier, Gruppe 1
	Datum: 04.05.2021
*/

#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include "binaryTree.h"

int main(int argc, char* argv[]) {
	int treeSize;

	/* Test Case 1 (numbers from the task) */
	{
		printf("--------------------------------------\n");
		printf("| Test Case 1 (values from the task) |\n");
		printf("--------------------------------------\n");
		
		treeSize = 10;
		Array_t* pTestArray = createSequentialTree("textfile_1.txt", treeSize);
		Node_t** ppTestTree = createBinaryTree(treeSize);

		printSequentialTree(pTestArray);

		printf("#transform\n");
		ppTestTree = transform(pTestArray, ppTestTree);

		printf("#printPreOrder: ");	printPreOrder(*ppTestTree);	printf("\n");
		printf("#printInOrder: "); printInOrder(*ppTestTree); printf("\n");
		printf("#printPostOrder: "); printPostOrder(*ppTestTree); printf("\n");

		printf("#countLeaves: %d\n", countLeaves(*ppTestTree));
		printf("#treeHeight: %d\n", height(*ppTestTree));
		printf("#destroy\n\n"); destroy(*ppTestTree);
		free(pTestArray->pValues); free(pTestArray);
	}

	/* Test Case 2 (any numbers) */
	{
		printf("------------------------------------\n");
		printf("| Test Case 2 (100 random numbers) |\n");
		printf("------------------------------------\n");

		treeSize = 100;
		Array_t* pTestArray = createSequentialTree("textfile_2.txt", treeSize);
		Node_t** ppTestTree = createBinaryTree(treeSize);

		printSequentialTree(pTestArray);

		printf("#transform\n");
		ppTestTree = transform(pTestArray, ppTestTree);

		printf("#printPreOrder: ");	printPreOrder(*ppTestTree);	printf("\n");
		printf("#printInOrder: "); printInOrder(*ppTestTree); printf("\n");
		printf("#printPostOrder: "); printPostOrder(*ppTestTree); printf("\n");

		printf("#countLeaves: %d\n", countLeaves(*ppTestTree));
		printf("#treeHeight: %d\n", height(*ppTestTree));
		printf("#destroy\n\n"); destroy(*ppTestTree);
		free(pTestArray->pValues); free(pTestArray);
	}

	/* Test Case 3 (only one number) */
	{
		printf("---------------------------------\n");
		printf("| Test Case 3 (only one number) |\n");
		printf("---------------------------------\n");
		
		treeSize = 1;
		Array_t* pTestArray = createSequentialTree("textfile_3.txt", treeSize);
		Node_t** ppTestTree = createBinaryTree(treeSize);

		printSequentialTree(pTestArray);

		printf("#transform\n");
		ppTestTree = transform(pTestArray, ppTestTree);

		printf("#printPreOrder: ");	printPreOrder(*ppTestTree);	printf("\n");
		printf("#printInOrder: "); printInOrder(*ppTestTree); printf("\n");
		printf("#printPostOrder: "); printPostOrder(*ppTestTree); printf("\n");

		printf("#countLeaves: %d\n", countLeaves(*ppTestTree));
		printf("#treeHeight: %d\n", height(*ppTestTree));
		printf("#destroy\n\n"); destroy(*ppTestTree);
		free(pTestArray->pValues); free(pTestArray);
	}

	/* Test Case 4 (no number/empty file) */
	{
		printf("--------------------------------------\n");
		printf("| Test Case 4 (no number/empty file) |\n");
		printf("--------------------------------------\n");
		
		treeSize = 0;
		Array_t* pTestArray = createSequentialTree("textfile_4.txt", treeSize);
		Node_t** ppTestTree = createBinaryTree(treeSize);

		printSequentialTree(pTestArray);

		/*	does not work!
		printf("#transform\n");
		ppTestTree = transform(pTestArray, ppTestTree);
		
		printf("#printPreOrder: ");	printPreOrder(*ppTestTree);	printf("\n");
		printf("#printInOrder: "); printInOrder(*ppTestTree); printf("\n");
		printf("#printPostOrder: "); printPostOrder(*ppTestTree); printf("\n");

		printf("#countLeaves: %d\n", countLeaves(*ppTestTree));
		printf("#treeHeight: %d\n", height(*ppTestTree));
		

		printf("#destroy\n"); destroy(*ppTestTree);
		free(pTestArray->pValues); free(pTestArray);
		*/
	}


	return 0;
}