#include <stdio.h>
#include <stdlib.h>

int strLen(const char* str) {
	int len = 0;

	while (str[len] != '\0') {
		len++;
	}

	return len;
}

int charOccurs(const char* str, char ch) {
	int i = 0;

	while (i < strLen(str)) {
		if (str[i] == ch) {
			return 1;
		}

		i++;
	}

	return 0;
}

int findCharLeft(const char* str, char ch) {
	int i = 0;

	while (i < strLen(str)) {
		if (str[i] == ch) {
			return i;
		}

		i++;
	}

	return -1;
}

int findCharRight(const char* str, char ch) {
	int i = strLen(str) - 1;

	while (i > -1) {
		if (str[i] == ch) {
			return i;
		}

		i--;
	}

	return -1;
}

int findCharRandom(const char* str, char ch) {
	int iR = 0;
	srand(time(0));

	if (charOccurs(str, ch) == 1) {
		while (1) {
			iR = rand() % strLen(str);

			if (str[iR] == ch) {
				return iR;
			}
		}
	}
	
	return -1;
}