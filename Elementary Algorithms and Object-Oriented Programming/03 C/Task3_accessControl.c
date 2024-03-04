/*
    Übung 3, Aufgabe 3: Mayar'sche Zutrittskontrolle
    Student: Matthias Meier, Gruppe 1
    Datum: 07.04.2021
*/

#include <stdio.h>
#include <stdlib.h>

#define MAX_ROW_VALUES 5
#define MAX_COL_VALUES 17

int compareVoicePatternAnalysis(int* correctPattern, int* testPattern) {
    for (int i = 0; i < MAX_COL_VALUES; i++) {
        // Bei größeren Matrizen können hier noch Abweichungen ergänzt werden
        if (correctPattern[i] != testPattern[i]) {
            return 0;
        }
    }

    return 1;
}

void voicePatternAnalysis(char voicePattern[MAX_ROW_VALUES][MAX_COL_VALUES], int* analysisPattern) {
    for (int i = 0; i < MAX_COL_VALUES; i++) {

        int freqBundleFound = 0;
        for (int j = 0; (j < MAX_ROW_VALUES) && (freqBundleFound == 0); j++) {
            if (voicePattern[j][i] == '*') {
                *(analysisPattern + i) = j;
                freqBundleFound = 1;
            } else {
                *(analysisPattern + i) = -1;
                freqBundleFound = 0;
            }
        }
    }
}

void compareVoicePattern(char correctPattern[MAX_ROW_VALUES][MAX_COL_VALUES], char testPattern[MAX_ROW_VALUES][MAX_COL_VALUES]) {
    int* analysisCorrectPattern = malloc(MAX_COL_VALUES * sizeof(int));
    int* analysisTestPattern = malloc(MAX_COL_VALUES * sizeof(int));

    if ((analysisCorrectPattern != NULL) && (analysisTestPattern != NULL)) {
        voicePatternAnalysis(correctPattern, analysisCorrectPattern);
        voicePatternAnalysis(testPattern, analysisTestPattern);

        if (compareVoicePatternAnalysis(analysisCorrectPattern, analysisTestPattern) == 1) {
            printf("Die Stimmmuster stimmen \201berein!\n");
        } else {
            printf("Die Stimmmuster stimmen nicht \201berein!\n");
        }
    } else {
        printf("Fehler: Kein Speicherplatz verf\201gbar!\n");
    }

    free(analysisCorrectPattern);
    free(analysisTestPattern);
}

int main(int argc, char* argv[]) {
    // Stimmmuster von Prof. Mayar:
    char mrMayarSr[MAX_ROW_VALUES][MAX_COL_VALUES] = {
        "                 ",
        "      *    *     ",
        "    ** ***  **  *",
        "   *      *   ** ",
        "***              "
    };

    // Stimmmuster von Frau Prof. Mayar:
    char mrsMayar[MAX_ROW_VALUES][MAX_COL_VALUES] = {
        "             *** ",
        "     **   ***    ",
        "*****  ***       ",
        "                 ",
        "                *"
    };

    // Stimmmuster von Prof. Mayars Sohn:
    char mrMayarJr[MAX_ROW_VALUES][MAX_COL_VALUES] = {
        "                 ",
        "      **   *     ",
        "   ***  *** **  *",
        " *            ** ",
        "* *              "
    };


    // Testfall 1: Selbes Muster wie Prof. Mayars Sohn
    printf("Testfall 1: Selbes Muster wie Prof. Mayars Sohn\n");
    char voicePattern1[MAX_ROW_VALUES][MAX_COL_VALUES] = {
        "                 ",
        "      **   *     ",
        "   ***  *** **  *",
        " *            ** ",
        "* *              "
    };

    printf("Sr. : "); compareVoicePattern(mrMayarSr, voicePattern1);
    printf("Mrs.: "); compareVoicePattern(mrsMayar, voicePattern1);
    printf("Jr. : "); compareVoicePattern(mrMayarJr, voicePattern1);


    // Testfall 2: Selbes Muster wie Frau Prof. Mayar
    printf("\nTestfall 2: Selbes Muster wie Frau Prof. Mayar\n");
    char voicePattern2[MAX_ROW_VALUES][MAX_COL_VALUES] = {
        "             *** ",
        "     **   ***    ",
        "*****  ***       ",
        "                 ",
        "                *"
    };

    printf("Sr. : "); compareVoicePattern(mrMayarSr, voicePattern2);
    printf("Mrs.: "); compareVoicePattern(mrsMayar, voicePattern2);
    printf("Jr. : "); compareVoicePattern(mrMayarJr, voicePattern2);


    // Testfall 3: Selbes Muster wie Prof. Mayar
    printf("\nTestfall 3: Selbes Muster wie Prof. Mayar\n");
    char voicePattern3[MAX_ROW_VALUES][MAX_COL_VALUES] = {
        "                 ",
        "      *    *     ",
        "    ** ***  **  *",
        "   *      *   ** ",
        "***              "
    };

    printf("Sr. : "); compareVoicePattern(mrMayarSr, voicePattern3);
    printf("Mrs.: "); compareVoicePattern(mrsMayar, voicePattern3);
    printf("Jr. : "); compareVoicePattern(mrMayarJr, voicePattern3);


    // Testfall 4: Leeres Muster
    printf("\nTestfall 4: Leeres Muster\n");
    char voicePattern4[MAX_ROW_VALUES][MAX_COL_VALUES] = {
        "                 ",
        "                 ",
        "                 ",
        "                 ",
        "                 "
    };

    printf("Sr. : "); compareVoicePattern(mrMayarSr, voicePattern4);
    printf("Mrs.: "); compareVoicePattern(mrsMayar, voicePattern4);
    printf("Jr. : "); compareVoicePattern(mrMayarJr, voicePattern4);


    // Testfall 5: Kleine Abweichung von Prof. Mayar
    printf("\nTestfall 5: Kleine Abweichung von Prof. Mayar\n");
    char voicePattern5[MAX_ROW_VALUES][MAX_COL_VALUES] = {
        "                 ",
        "      *    *     ",
        "    ** ***  **   ",
        "   *      *   ***",
        "***              "
    };

    printf("Sr. : "); compareVoicePattern(mrMayarSr, voicePattern5);
    printf("Mrs.: "); compareVoicePattern(mrsMayar, voicePattern5);
    printf("Jr. : "); compareVoicePattern(mrMayarJr, voicePattern5);

    return 0;
}