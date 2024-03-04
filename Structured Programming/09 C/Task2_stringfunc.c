#include <stdio.h>

int string_len(const char str[]) {
	int	strLength = 0;

	while (str[strLength] != '\0') {
		strLength = strLength + 1;
	}

	return strLength;
}

int string_cmp(const char str1[], const char str2[]) {
	int longerStrLength = string_len(str1);

	if (string_len(str1) < string_len(str2)) {
		longerStrLength = string_len(str2);
	}

	int cmpValue = 0;
	int i = 0;

	while ((i < longerStrLength) && (cmpValue == 0)) {
		if (str1[i] == str2[i]) {
			cmpValue = 0;
		} else if (str1[i] > str2[i]) {
			cmpValue = 1;
		} else if (str1[i] < str2[i]) {
			cmpValue = -1;
		}

		i = i + 1;
	}

	return cmpValue;
}

void string_toUpperCase(char str[]) {
	int i = 0;
	int validStr = 1;

	while ((i < string_len(str)) && (validStr == 1)) {
		if ((str[i] > 64) && (str[i] < 123)) {
			if (str[i] > 96) {
				str[i] = str[i] - 32;	
			}

			validStr = 1;
		} else {
			printf("Ung\x81ltiges Zeichen im Wort! Es d\x81rfen nur die Buchstaben a-Z verwendet werden!\n");
			validStr = 0;
		}

		i = i + 1;
	}
}

void string_copy(char destStr[], const char srcStr[]) {
	int destStrLength = string_len(destStr);
	int i = 0;

	while (i < string_len(srcStr)) {
		destStr[destStrLength] = srcStr[i];

		destStrLength = destStrLength + 1;
		i = i + 1;
	}
}

int string_subStr(char destStr[], const char srcStr[], int startOffs, int endOffs) {
	int destStrLength = string_len(destStr);
	int copiedChars = 0;

	if (startOffs < endOffs) {
		if (endOffs < string_len(srcStr)) {
			while (startOffs <= endOffs) {
				destStr[destStrLength] = srcStr[startOffs];

				copiedChars = copiedChars + 1;
				destStrLength = destStrLength + 1;
				startOffs = startOffs + 1;
			}
		} else {
			printf("Fehler: endOffs darf nicht gr\x94\xe1\er sein die L\x84nge des Worts \"%s\"!\n", srcStr);
			copiedChars = 1;
		}
	} else {
		printf("Fehler: startOffs darf nicht gr\x94\xe1\er sein als endOffs!\n");
		copiedChars = 1;
	}

	if (copiedChars > 1) {
		printf("Neuer Text: %s\n", destStr);
	}

	return copiedChars;
}

void string_revert(char str[]) {
	char revertedStr[50];				// muss mind. gleichgroß sein wie die Länge des übergebenen Strings
	int strLength = string_len(str);
	int i = 0;

	while (i < strLength) {
		revertedStr[i] = str[strLength - 1 - i];
		
		i = i + 1;
	}

	i = 0;

	while (i < strLength) {
		str[i] = revertedStr[i];

		i = i + 1;
	}
}