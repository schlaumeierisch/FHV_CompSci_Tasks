#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include "binaryTree.h"

void destroy(Node_t* pRoot) {
	if (pRoot != NULL) {
		destroy(pRoot->pLeft);
		destroy(pRoot->pRight);

		free(pRoot);
	}
}

int countLeaves(Node_t* pRoot) {
	if (pRoot != NULL) {
		if ((pRoot->pLeft == NULL) && (pRoot->pRight == NULL)) {
			return 1;
		} else {
			return countLeaves(pRoot->pLeft) + countLeaves(pRoot->pRight);
		}
	}

	return 0;
}

int height(Node_t* pRoot) {
	if (pRoot != NULL) {
		int treeHeight;
		treeHeight = height(pRoot->pLeft);
		return treeHeight + 1;
	}

	return 0;
}

void printPreOrder(Node_t* pRoot) {
	if (pRoot != NULL) {
		printf("%d ", pRoot->value);
		printPreOrder(pRoot->pLeft);
		printPreOrder(pRoot->pRight);
	}
}

void printInOrder(Node_t* pRoot) {
	if (pRoot != NULL) {
		printInOrder(pRoot->pLeft);
		printf("%d ", pRoot->value);
		printInOrder(pRoot->pRight);
	}
}

void printPostOrder(Node_t* pRoot) {
	if (pRoot != NULL) {
		printPostOrder(pRoot->pLeft);
		printPostOrder(pRoot->pRight);
		printf("%d ", pRoot->value);
	}	
}

void printSequentialTree(Array_t* pArray) {
	if (pArray != NULL) {
		printf("#printSequentialTree: ");

		for (int i = 0; i < pArray->nrOfValues; i++) {
			printf("%d ", pArray->pValues[i]);
		}

		printf("\n");
	}
}

Node_t** createBinaryTree(int size) {
	Node_t** pNewTree = malloc(size * sizeof(Node_t*));

	if (pNewTree != NULL) {
		return pNewTree;
	}

	return NULL;
}

Array_t* createSequentialTree(char fileName[], int size) {
	if (size > 0) {
		FILE* textFile;
		textFile = fopen(fileName, "r");
		Array_t* pNewArray = malloc(sizeof(Array_t));

		if ((textFile != NULL) && (pNewArray != NULL)) {
			pNewArray->nrOfValues = size;
			pNewArray->pValues = malloc(pNewArray->nrOfValues * sizeof(int));

			if (pNewArray->pValues != NULL) {
				int count = 0;

				while (fscanf(textFile, "%d", &pNewArray->pValues[count]) != EOF) {
					count++;

					if (count > size) {
						printf("Error: The specified size does not match the number of values in the text file!\n");
						fclose(textFile);
						return NULL;
					}
				}

				if (count == size) {
					fclose(textFile);
					return pNewArray;
				} else if (count == 0) {
					printf("Error: The text file is empty!\n");
					fclose(textFile);
				} else {
					printf("Error: The specified size does not match the number of values in the text file!\n");
					fclose(textFile);
				}
			} else {
				fclose(textFile);
			}
		} else {
			printf("Error: Invalid text file or invalid name of the text file!\n");
		}
	} else {
		printf("Error: The specified size must be greater than 0!\n");
	}

	return NULL;
}

void insertValue(ItemType* pValues, Node_t** ppRoot, int i, int n) {
	if (i < n) {
		*ppRoot = malloc(sizeof(**ppRoot));

		if (*ppRoot != NULL) {
			(*ppRoot)->value = pValues[i];
			(*ppRoot)->pLeft = NULL;
			(*ppRoot)->pRight = NULL;

			insertValue(pValues, &(*ppRoot)->pLeft, 2 * i + 1, n);
			insertValue(pValues, &(*ppRoot)->pRight, 2 * i + 2, n);
		}
	}
}

Node_t** transform(Array_t* pTree, Node_t** ppRoot) {
	if ((pTree != NULL) && (ppRoot != NULL)) {
		if (pTree->nrOfValues > 0) {
			insertValue(pTree->pValues, ppRoot, 0, pTree->nrOfValues);

			return ppRoot;
		}
	}

	return NULL;
}