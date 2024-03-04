#include <stdio.h>
#include <stdlib.h>

int nextPos(const char str[], int currPos) {
	while ((str[currPos] > 64) && (str[currPos] < 123)) {
		currPos++;
	}

	return currPos;
}

int countingWords(const char str[]) {
	int i = 0;
	int counter = 0;

	while (i < strLen(str)) {
		if ((str[i] > 64) && (str[i] < 123)) {
			counter++;
			i = nextPos(str, i);
		} else {
			i++;
		}
	}

	return counter;
}

int strLen(const char str[]) {
	int len = 0;

	while (str[len] != '\0') {
		len++;
	}

	return len;
}

int* getIntArray(const char str[], int* indexes) {
	indexes = malloc(countingWords(str) * sizeof(int));

	if (!indexes) {
		return NULL;
	}

	return indexes;
}

char** getCharArray(const char str[], char** addresses) {
	addresses = malloc(countingWords(str) * sizeof(char*));

	if (!addresses) {
		return NULL;
	}

	return addresses;
}

int* tokenizerV1(const char str[], int* indexes) {
	indexes = getIntArray(str, indexes);
	
	int i = 0;
	int currIndex = 0;

	while (i < strLen(str)) {
		if ((str[i] > 64) && (str[i] < 123)) {
			*(indexes + currIndex) = i;
			currIndex++;
			i = nextPos(str, i);
		} else {
			i++;
		}
	}

	return indexes;
}

char** tokenizerV2(const char str[], char** addresses) {
	addresses = getCharArray(str, addresses);
	
	int* indexes = NULL;
	indexes = tokenizerV1(str, indexes);
	
	for (int i = 0; i < countingWords(str); i++) {
		addresses[i] = &(str[indexes[i]]);
	}

	free(indexes);

	return addresses;
}