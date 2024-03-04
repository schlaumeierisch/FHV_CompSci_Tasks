#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include "binarySearchTree.h"

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

Node_t* minValue(Node_t* pRoot) {
	if (pRoot != NULL) {
		Node_t* pTempNode = pRoot;

		while (pTempNode->pLeft != NULL) {
			pTempNode = pTempNode->pLeft;
		}

		return pTempNode;
	}
	
	return NULL;
}

Node_t* maxValue(Node_t* pRoot) {
	if (pRoot != NULL) {
		while (pRoot->pRight) {
			pRoot = pRoot->pRight;
		}

		return pRoot;
	}

	return NULL;
}

Node_t* getPredecessor(Node_t* pRoot, int value) {
	if (pRoot != NULL) {
		Node_t* pCurrNode = pRoot;
		Node_t* pPreNode = pRoot;

		// if "value" is already the lowest value
		if ((minValue(pRoot)->value == value)) {
			pPreNode = minValue(pRoot);
			return pPreNode;
		}

		while ((pCurrNode != NULL) && (pCurrNode->value != value)) {
			if (pCurrNode->value > value) {
				pCurrNode = pCurrNode->pLeft;
			} else {
				pPreNode = pCurrNode;
				pCurrNode = pCurrNode->pRight;
			}
		}

		if ((pCurrNode != NULL) && (pCurrNode->pLeft != NULL)) {
			pPreNode = maxValue(pCurrNode->pLeft);
		}
		
		return pPreNode;
	}

	return NULL;
}

Node_t* getSuccessor(Node_t* pRoot, int value) {
	if (pRoot != NULL) {
		Node_t* pSuccNode = pRoot;

		// if "value" is already the highest value
		if ((maxValue(pRoot)->value == value)) {
			pSuccNode = maxValue(pRoot);
			return pSuccNode;
		}
		
		while (pRoot != NULL) {
			if (pRoot->value == value) {
				if (pRoot->pRight == NULL) {
					return pSuccNode;
				}

				return minValue(pRoot->pRight);
			}

			if (pRoot->value < value) {
				pRoot = pRoot->pRight;
			} else {
				pSuccNode = pRoot;
				pRoot = pRoot->pLeft;
			}
		}

		return pSuccNode;
	}

	return NULL;
}

Node_t* insertValue(Node_t* pRoot, int value) {
	if (pRoot == NULL) {	// node that is "empty" has been reached
		Node_t* pNewNode = malloc(sizeof(Node_t));
		
		if (pNewNode != NULL) {
			pNewNode->value = value;
			pNewNode->pLeft = NULL;
			pNewNode->pRight = NULL;

			return pNewNode;
		}
		
	} else if (value == pRoot->value) {	// already existing values are not inserted
		return pRoot;
	} else if (value > pRoot->value) {	// values higher than this value are inserted right
		pRoot->pRight = insertValue(pRoot->pRight, value);
	} else {							// values lower than this value are inserted left
		pRoot->pLeft = insertValue(pRoot->pLeft, value);
	}

	return pRoot;
}

Node_t* createBinarySearchTree(int n, int max) {
	if ((max != 0) && (n > 0)) {
		Node_t* pNewTree = malloc(sizeof(Node_t));

		if (pNewTree != NULL) {
			time_t t;
			srand((unsigned)time(&t));

			// generate value for the root (1)
			pNewTree->value = rand() % max;
			pNewTree->pLeft = NULL;
			pNewTree->pRight = NULL;

			// generate values for the nodes (n - 1)
			for (int i = 0; i < (n - 1); i++) {
				insertValue(pNewTree, rand() % (max - 1));
			}

			return pNewTree;
		}
	}

	return NULL;
}