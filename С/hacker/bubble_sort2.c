#include <stdio.h>

int main() {
    int array[] = {-8, 9, 8, -7, 3, -5, 7, 0, 6, -1, 4, -2, -6, 5, -9, 2, 1, -3, -4};
    
    int finish = 1;
    do {
        finish = 1;
        for (int i = 0; i < 18; i++) {
            if (array[i] > array[i + 1]) {
                int temp = array[i];
                array[i] = array[i + 1];
                array[i + 1] = temp;
                finish = 0;
            }
        }
    } while (!finish);

    for (int i = 0; i < 19; i++) {
        if (i > 0) {
            printf(" ");
        }
        printf("%d", array[i]);
    }

    printf("\n");

    return 0;
}