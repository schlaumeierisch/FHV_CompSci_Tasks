#pragma once

typedef int ItemType;
typedef struct Node {
	ItemType value;
	struct Node* pLeft;
	struct Node* pRight;
} Node_t;

Node_t* insertValue(Node_t* pRoot, int value);
Node_t* createBinarySearchTree(int nrOfValues, int maxValue);
Node_t* getSuccessor(Node_t* pRoot, int value);
Node_t* getPredecessor(Node_t* pRoot, int value);
Node_t* minValue(Node_t* pRoot);
Node_t* maxValue(Node_t* pRoot);


/*------Functions from Task 1------*/
void printPreOrder(Node_t* pRoot);
void printInOrder(Node_t* pRoot);
void printPostOrder(Node_t* pRoot);
/*---------------------------------*/