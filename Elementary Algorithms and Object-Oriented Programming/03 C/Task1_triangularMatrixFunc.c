#include <stdio.h>
#include <stdlib.h>

int getNrOfRows(int n) {
	int usedNrs = n / 2;

	if (n % 2 != 0) {
		usedNrs++;
	}

	int nrOfRows = 1;

	while (1) {
		usedNrs = usedNrs - nrOfRows;

		if (usedNrs > 0) {
			nrOfRows++;
		}
		else {
			return nrOfRows;
		}
	}
}

void freeUnusedMemory(int** matrix, int row) {
	int count = 0;

	for (int i = 0; i < row; i++) {
		if (matrix[row][i] == 0) {
			count++;
		}
	}

	matrix[row] = realloc(matrix[row], sizeof(int) * (row - count));
}

void fillAndPrint(int** matrix, int n) {
	int row = 0;
	int col = 0;
	int currNr = 1;

	printf("n = %d\n", n);
	while (currNr < n) {
		while ((col <= row) && (currNr < n)) {
			matrix[row][col] = currNr;
			printf("%d ", currNr);
			currNr += 2;
			col++;
		}

		printf("\n");
		col = 0;
		row++;
	}

	freeUnusedMemory(matrix, (getNrOfRows(n) - 1));
}

int** getTriangularMatrix(int n) {
	int** triMatrix = (int**)calloc(getNrOfRows(n), sizeof(int*));

	if (triMatrix != NULL) {
		for (int i = 0; i < getNrOfRows(n); i++) {
			triMatrix[i] = (int*)calloc((i + 1), sizeof(int));

			if (triMatrix[i] == NULL) {
				printf("Kein Speicherplatz frei!\n");
				return 0;
			}
		}
	}
	else {
		printf("Kein Speicherplatz frei!\n");
		return 0;
	}

	return triMatrix;
}