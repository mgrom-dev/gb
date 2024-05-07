/**
This time no story, no theory. The examples below show you how to write function accum:

Examples:
accum("abcd") -> "A-Bb-Ccc-Dddd"
accum("RqaEzty") -> "R-Qq-Aaa-Eeee-Zzzzz-Tttttt-Yyyyyyy"
accum("cwAt") -> "C-Ww-Aaa-Tttt"
accum("ZpglnRxqenU") -> "Z-Pp-Ggg-Llll-Nnnnn-Rrrrrr-Xxxxxxx-Qqqqqqqq-Eeeeeeeee-Nnnnnnnnnn-Uuuuuuuuuuu"
accum("NyffsGeyylB") -> "N-Yy-Fff-Ffff-Sssss-Gggggg-Eeeeeee-Yyyyyyyy-Yyyyyyyyy-Llllllllll-Bbbbbbbbbbb"
accum("MjtkuBovqrU") -> "M-Jj-Ttt-Kkkk-Uuuuu-Bbbbbb-Ooooooo-Vvvvvvvv-Qqqqqqqqq-Rrrrrrrrrr-Uuuuuuuuuuu"
accum("EvidjUnokmM") -> "E-Vv-Iii-Dddd-Jjjjj-Uuuuuu-Nnnnnnn-Oooooooo-Kkkkkkkkk-Mmmmmmmmmm-Mmmmmmmmmmm"
accum("HbideVbxncC") -> "H-Bb-Iii-Dddd-Eeeee-Vvvvvv-Bbbbbbb-Xxxxxxxx-Nnnnnnnnn-Cccccccccc-Ccccccccccc"

The parameter of accum is a string which includes only letters from a..z and A..Z.
*/

#include <ctype.h>
#include <stdlib.h>
#include <stdio.h>
#include <string.h>

char *accum(const char *source) {
    int len = strlen(source);
    int act_len = (len * (len + 1) / 2) + len;
    char *actual = malloc(sizeof(char) * act_len);

	int i = 0;
	for (int j = 0; j < len; j++, i++) {
		for (int k = 0; k < (j + 1); k++, i++) actual[i] = k ? tolower(source[j]) : toupper(source[j]);
		actual[i] = '-';
	}
    actual[i - 1] = '\0';

    return actual;
}

int main() {
    char *acc = accum("ZpglnRxqenU");
    printf("%s", acc);
    free(acc);
    return 0;
}