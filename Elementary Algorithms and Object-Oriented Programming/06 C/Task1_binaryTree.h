#pragma once

typedef int ItemType;
typedef struct Array {
	int nrOfValues;
	ItemType* pValues;
} Array_t;
typedef struct Node {
	ItemType value;
	struct Node* pLeft;
	struct Node* pRight;
} Node_t;

Node_t** transform(Array_t* pTree, Node_t** ppRoot);

Array_t* createSequentialTree(char fileName[], int length);
Node_t** createBinaryTree(int size);

void insertValue(ItemType* pValues, Node_t** ppRoot, int i, int n);

void printSequentialTree(Array_t* pArray);
void printPreOrder(Node_t* pRoot);
void printInOrder(Node_t* pRoot);
void printPostOrder(Node_t* pRoot);

void destroy(Node_t* pRoot);
int countLeaves(Node_t* pRoot);
int height(Node_t* pRoot);