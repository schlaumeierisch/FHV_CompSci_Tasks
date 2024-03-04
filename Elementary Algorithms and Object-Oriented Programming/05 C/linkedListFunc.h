#pragma once

typedef int value_t;
typedef struct Node {
	value_t value;
	struct Node* pNext;
} Node_t;

int getListLength(Node_t* pHead);
int getLargestNumber(Node_t* pHead);
Node_t* getNode(Node_t* pHead, int index);
int insertFront(Node_t** ppHead, const value_t value);
int insertBefore(Node_t** ppHead, Node_t* pPrevNode, const value_t value);
int deleteValues(Node_t** ppHead, const value_t value, int deleteAllOcc);
int deleteList(Node_t** ppHead);
void printList(const Node_t* pHead);
int inverseList(Node_t** ppHead);
int sortList(Node_t** ppHead);