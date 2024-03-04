#include <stdio.h>
#include <stdlib.h>

typedef int value_t;
typedef struct Node {
	value_t value;
	struct Node* pNext;
} Node_t;

int getListLength(Node_t* pHead) {
	Node_t* pCurr = pHead;
	int len = 0;
	while (pCurr != NULL) {
		len++;
		pCurr = pCurr->pNext;
	}

	return len;
}

int getLargestNumber(Node_t* pHead) {
	Node_t* pCurr = pHead;
	int max = pCurr->value;
	while (pCurr != NULL) {
		if (pCurr->value > max) {
			max = pCurr->value;
		}
		pCurr = pCurr->pNext;
	}

	return max;
}

Node_t* getNode(Node_t* pHead, int index) {
	Node_t* pCurr = pHead;
	if (index >= 0) {
		for (int i = 0; i < index; i++) {
			if (pCurr->pNext != NULL) {
				pCurr = pCurr->pNext;
			}
			else {
				printf("Invalid index! Please enter a valid index. (0 <= index < n)\n");
				return NULL;
			}
		}
	}
	else {
		printf("Invalid index! Please enter a valid index. (0 <= index < n)\n");
		return NULL;
	}

	return pCurr;
}

int insertFront(Node_t** ppHead, const value_t value) {
	if (*ppHead != NULL) {
		Node_t* pNewNode = createNode(value);
		if (pNewNode != NULL) {
			pNewNode->pNext = *ppHead;
			*ppHead = pNewNode;
			return 1;
		}
	}

	printf("Error: Node insertion at the beginning failed!\n");
	return 0;
}

int insertBefore(Node_t** ppHead, Node_t* pPrevNode, const value_t value) {
	if (*ppHead != pPrevNode) {
		Node_t* pNewNode = malloc(sizeof(Node_t));
		if (pNewNode != NULL) {
			Node_t* pCurr = *ppHead;
			while (pCurr != NULL) {
				if (pCurr->pNext == pPrevNode) {
					pCurr->pNext = pNewNode;
					pNewNode->pNext = pPrevNode;
					pNewNode->value = value;
					return 1;
				}

				pCurr = pCurr->pNext;
			}
		}
	}
	else {
		if (insertFront(ppHead, value)) {
			return 1;
		}
		else {
			printf("Error: Node insertion before specific node failed!\n");
			return 0;
		}
	}

	printf("Error: Node insertion before specific node failed!\n");
	return 0;
}

int deleteValues(Node_t** ppHead, const value_t value, int deleteAllOcc) {
	int deletedItems = 0;
	if (*ppHead != NULL) {
		Node_t* pCurr = *ppHead;
		Node_t* pPrev = pCurr;
		while (pCurr != NULL) {
			if (pCurr->value == value) {
				if (pCurr == *ppHead) {
					*ppHead = pCurr->pNext;
				}
				else {
					pPrev->pNext = pCurr->pNext;
				}

				// free pCurr funktioniert nicht?!
				if (!deleteAllOcc) {
					printf("Success: The first item with the value %d has been deleted.\n", value);
					return 1;
				}

				pCurr = pPrev->pNext;
				deletedItems++;
			}
			else {
				pPrev = pCurr;
				pCurr = pCurr->pNext;
			}
		}
	}
	else {
		printf("Error: Deleting values failed!\n");
		return 0;
	}

	if (deletedItems > 0) {
		printf("Success: All items with the value %d have been deleted.\n", value);
		return 1;
	}
	else {
		printf("Error: No item with the value %d was found!\n", value);
		return 0;
	}
}

int deleteList(Node_t** ppHead) {
	Node_t* pCurr = *ppHead;
	Node_t* pNext;
	while (pCurr != NULL) {
		pNext = pCurr->pNext;
		free(pCurr);
		pCurr = pNext;
	}

	*ppHead = NULL;

	return 0;
}

void printList(const Node_t* pHead) {
	if (pHead != NULL) {
		Node_t* pCurr = pHead;
		while (pCurr != NULL) {
			printf("%d ", pCurr->value);
			pCurr = pCurr->pNext;
		}

		printf("\n");
	}
	else {
		printf("Error: Printing list failed!\n");
	}
}

int inverseList(Node_t** ppHead) {
	if (*ppHead != NULL) {
		Node_t* pPrev = NULL;
		Node_t* pCurr = *ppHead;
		Node_t* pNext = NULL;
		while (pCurr != NULL) {
			pNext = pCurr->pNext;
			pCurr->pNext = pPrev;
			pPrev = pCurr;
			pCurr = pNext;
		}

		*ppHead = pPrev;
		return 1;
	}
	else {
		printf("Error: Inverting list failed!\n");
		return 0;
	}
}

int sortList(Node_t** ppHead) {
	if (*ppHead != NULL) {
		Node_t* pCurr = *ppHead;
		Node_t* pMin = pCurr;
		int listLength = getListLength(*ppHead);

		for (int i = 0; i < listLength; i++) {
			int min = getLargestNumber(*ppHead);
			for (int j = i; j < listLength; j++) {
				if (pCurr->value <= min) {
					min = pCurr->value;
					pMin = pCurr;
				}

				pCurr = pCurr->pNext;
			}

			pCurr = *ppHead;
			for (int k = 0; k < i; k++) {
				pCurr = pCurr->pNext;
			}

			int temp = pCurr->value;
			pCurr->value = pMin->value;
			pMin->value = temp;
			pCurr = pCurr->pNext;
		}

		return 1;
	}
	else {
		printf("Error: Sorting list failed!\n");
		return 0;
	}
}