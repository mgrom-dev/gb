#include <stdio.h>

int main() {
    int array[] = {-8, 9, 8, -7, 3, -5, 7, 0, 6, -1, 4, -2, -6, 5, -9, 2, 1, -3, -4};
    int i, length = sizeof(array) / sizeof(array[0]);

    for (i = 0; i < length - 1; i++)
        if (array[i] > array[i + 1]) {
            array[i] += array[i + 1];
            array[i + 1] = array[i] - array[i + 1];
            array[i] -= array[i + 1];
            i = -1;
        }

    for (i = 0; i < length; i++)
        printf("%d%c", array[i], (i < length - 1 ? ' ': '\n'));

    return 0;
}